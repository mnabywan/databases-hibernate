import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.persistence.*;
import javax.swing.text.Caret;
import java.util.List;

public class MainJPA {
    public static EntityManagerFactory entityManagerFactory = null;

    public static void main(String argv[]) {

        EntityManager em = getEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Supplier supplier = em.find(Supplier.class, 23);

//        Product p1 = new Product("Mango", 100, supplier);
  //      Invoice invoice = new Invoice(p1,10);

//        em.persist(invoice);


        //Product p2 = new Product("Pomarancza", 1000, supplier);
        //p2.getCanBeSoldIn().add(new Invoice());
        // em.persist(p2);
        /*
        Category c1 = new Category("Izotoniki");
        Category c2 = new Category("Meble");
        Category c3 = new Category("Owoce");
        Category c4 = new Category("Nabial");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);

/*
        Category c1 = em.find(Category.class, 1);
        Category c2 = em.find(Category.class, 2);
        Category c3 = em.find(Category.class, 3);
        Category c4 = em.find(Category.class, 4);

        Product p1 = new Product("Powerade", 1000);
        Product p2 = new Product("Oshee", 1240);
        Product p3 = new Product("Krzeslo1", 232);
        Product p4 = new Product("Lozko1", 12);
        Product p5 = new Product("Jablko", 1000);
        Product p6 = new Product("Banan", 600);
        Product p7 = new Product("Mleko1", 100);
        Product p8 = new Product("Ser zolty1", 250);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.persist(p7);
        em.persist(p8);


        c1.addProduct(p1);
        c1.addProduct(p2);
        c2.addProduct(p3);
        c2.addProduct(p4);
        c3.addProduct(p5);
        c3.addProduct(p6);
        c4.addProduct(p7);
        c4.addProduct(p8);
*/
        /*
        TypedQuery<Product> query = em.createQuery("from Product as product" +
                " where product.category.categoryID= 1", Product.class);
        List<Product> allProducts = query.getResultList();
        for(Product prod: allProducts){
            System.out.println(prod.getProductName());
        }

        Product p1 = em.find(Product.class, 17);

        TypedQuery<Category> query2 = em.createQuery("from Category as category" +
               " where :p member category.products", Category.class);
        query2.setParameter("p", p1);
        Category cat = query2.getSingleResult();
        System.out.println(cat.getName());
*/
        transaction.commit();
        em.close();

    }
    private static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("derby");
        }
        return entityManagerFactory.createEntityManager();
    }


}
