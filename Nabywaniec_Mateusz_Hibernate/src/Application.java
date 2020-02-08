import javax.persistence.*;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;


    public static void main(String argv[]) {
        em = getEntityManager();

        Menu menu = new Menu("Options");
        menu.setOneshot(false);
        menu.addMenuOption(1,"List suppliers", Application::listSuppliers);
        menu.addMenuOption(2,"Add supplier", Application::addSupplier);
        menu.addMenuOption(3, "List customers", Application::listCustomers);
        menu.addMenuOption(4,"Add customer", Application::addCustomer);
        menu.addMenuOption(5, "List products", Application::listProducts);
        menu.addMenuOption(6,"Add products", Application::addProduct);
        menu.addMenuOption(7, "List orders", Application::listOrders);
        menu.addMenuOption(8, "Order products", Application::orderProducts);

        menu.printOptions();

    }
    private static void orderProducts(Scanner scanner){

        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        List<Customer> customers = getAll(Customer.class);
        List<Product> products = getAll(Product.class);

        Order order = new Order();

        Menu client = new Menu("choose client");
        System.out.println("choose client");
        customers.forEach(c->
                client.addMenuOption(c.hashCode(), c.CompanyName, x->order.setCustomer(c)));
        client.printOptions();

        Menu productMenu = new Menu("choose products");
        products.forEach(p ->
                productMenu.addMenuOption(p.getProductID(),p.ProductName, x -> order.addProduct(p))
        );
        productMenu.addMenuOption(0, "Finish order", x -> productMenu.setOneshot(true));

        productMenu.printOptions();

        em.persist(order);
        entityTransaction.commit();
    }


    private static void addSupplier(Scanner scanner) {
        String name, street, city, bankAccount;

        System.out.println("Company name: ");
        name = readNonemptyLine(scanner);

        System.out.println("Street: ");
        street = readNonemptyLine(scanner);

        System.out.println("City: ");
        city = readNonemptyLine(scanner);

        System.out.println("Bank account: ");
        bankAccount = readNonemptyLine(scanner);

        Supplier s = new Supplier(name, street, city, bankAccount);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
    }

    private static void addCategory(Scanner scanner){
        String name;

        System.out.println("Category name: ");
        name = readNonemptyLine(scanner);

    }

    private static void listOrders(Scanner scanner) {
        List result = em.createQuery("SELECT o, o.products.size FROM Order o")
                .getResultList();

        for (Object pair : result) {
            Order o = (Order) ((Object[]) pair)[0];
            int count = (Integer) ((Object[]) pair)[1];

            System.out.println(String.format("%d: %d products for %s",
                    o.getOrderID(), count, o.getCustomer().CompanyName));
        }
    }

    private static void listProducts(Scanner scanner){
        List<Product> products = getAll(Product.class);

        System.out.println("Name -- Units in stock -- Supplier");
        products.forEach(
                p -> System.out.println(String.format("%5d | %s | %s", p.UnitsOnStock,
                        p.ProductName, p.getSuppliedBy().CompanyName)));
    }

    public static void addProduct(Scanner scanner){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        System.out.println("Name: ");
        String name = readNonemptyLine(scanner);

        System.out.println("Stock: ");
        int initialStock = scanner.nextInt();

        Product product = new Product(name);
        product.UnitsOnStock = initialStock;

        List<Supplier> suppliers = getAll(Supplier.class);

        Menu supplierMenu = new Menu("Choose product's supplier");
        suppliers.forEach(s ->
                supplierMenu.addMenuOption(Integer.parseInt(s.getBankAccountNumber()) % 100 , s.CompanyName, x -> product.setSuppliedBy(s))
        );
        supplierMenu.printOptions();

        em.persist(product);
        transaction.commit();
    }


    private static void addCustomer(Scanner scanner) {
        String name, street, city;
        double discount;

        System.out.println("Company name: ");
        name = readNonemptyLine(scanner);

        System.out.println("Street: ");
        street = readNonemptyLine(scanner);

        System.out.println("City: ");
        city = readNonemptyLine(scanner);

        System.out.println("Discount: ");
        discount = scanner.nextDouble();

        Customer customer = new Customer(name, street, city, discount);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(customer);
        transaction.commit();
    }

    private static void listSuppliers(Scanner scanner) {
        List<Supplier> suppliers = getAll(Supplier.class);

        System.out.println("Name");
        suppliers.stream().map(s -> s.CompanyName).forEach(System.out::println);
    }

    private static void listCustomers(Scanner scanner) {
        List<Customer> customers = getAll(Customer.class);

        System.out.println("Name");
        customers.stream().map(c -> c.CompanyName).forEach(System.out::println);
    }

    private static <T> List<T> getAll(Class<T> entity) {
        return em.createQuery("SELECT t FROM " + entity.getName() + " t", entity)
                .getResultList();
    }

    private static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("derby");
        }
        return entityManagerFactory.createEntityManager();
    }

    private static String readNonemptyLine(Scanner scanner) {
        String line;
        do {
            line = scanner.nextLine();
        } while (line == null || line.chars().allMatch(Character::isWhitespace));
        return line;
    }
}
