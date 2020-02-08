import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {


        final Session session = getSession();
        try {


            Transaction tx = session.beginTransaction();


            /*
            Company company1 = new Supplier("KowalskiSA", "Sloneczna 1","Krakow", "1234");
            Company company2 = new Supplier("KowalskiSA2", "Sloneczna 2","Krakow", "1235");
            Company company3 = new Supplier("KowalskiSA3", "Sloneczna 3","Krakow", "1236");
            Company company4 = new Supplier("KowalskiSA4", "Sloneczna 4","Krakow", "1237");

            //Company company1 = new Supplier("KowalskiSA", "Sloneczna 1","Krakow", "1234");
            Company c5 = new Customer("Nowak1", "Sloneczna 2","Warszawa", 0.24);
            Company c6 = new Customer("Nowak2", "Sloneczna 3","Warszawa", 0.1);
            Company c7 = new Customer("Nowak3", "Sloneczna 4","Warszawa", 0.12);
            Company c8 = new Customer("Nowak4", "Sloneczna 4","Warszawa", 0.4);

            session.save(company2);
            session.save(company3);
            session.save(company4);
            session.save(c5);
            session.save(c6);
            session.save(c7);
            session.save(c8);


            String hql = "from Company ";
            Query q = session.createQuery(hql);
            List <Company> results = q.list();

            for(Company c : results){
                System.out.println(c.getCompanyName());
            }

*/
            //Supplier supplier1 = session.get(Supplier.class, 21);

           // Supplier supplier2 = session.get(Supplier.class, 22);
           // Supplier supplier3 = session.get(Supplier.class, 23);
           // Supplier supplier4 = session.get(Supplier.class, 24);



            /*


            Supplier supplier1 = new Supplier("SportNutrition", "Sloneczna 20", "Lodz");
            Supplier supplier2 = new Supplier("ABC Meble", "Stara 11", "Rzeszow");
            Supplier supplier3 = new Supplier("VegeSupp", "Mickiewicza 1", "Krakow");
            Supplier supplier4 = new Supplier("Mlekovita", "Dluga 5", "Warszawa");

            session.save(supplier1);
            session.save(supplier2);
            session.save(supplier3);
            session.save(supplier4);
            */
            //Product product1 = session.get(Product.class, 261);
            //Invoice invoice1 = session.get(Invoice.class, 363);
            //invoice1.addProduct(product1, 31);
            //session.save(invoice1);

            //Supplier supplier1 = session.get(Supplier.class, 242);

            //Supplier supplier2 = session.get(Supplier.class, 243);
            //Supplier supplier3 = session.get(Supplier.class, 244);

   //         Category category1 = new Category("Izotoniki");
     //       Category category2 = new Category("Meble");
  //          Category category3 = new Category("Owoce");
//
      //      session.save(category1);
    //        session.save(category2);
        //    session.save(category3);
/*
            Product product1 = session.get(Product.class, 260);
            Product product2 = session.get(Product.class, 261);
            Product product3 = session.get(Product.class, 262);
            Product product4 = session.get(Product.class, 263);
            Product product5 = session.get(Product.class, 264);

            product1.setCategory(category1);
            product2.setCategory(category3);
            product3.setCategory(category1);
            product4.setCategory(category2);
            product5.setCategory(category2);

            session.save(product1);
            session.save(product2);
            session.save(product3);
            session.save(product4);
            session.save(product5);
*/



/*
            Product product1 = session.get(Product.class, 13);
            Product product2 = session.get(Product.class, 14);
            Product product3 = session.get(Product.class, 15);
            Product product4 = session.get(Product.class, 16);
            Product product5 = session.get(Product.class, 17);
            Product product6 = session.get(Product.class, 18);
            Product product7 = session.get(Product.class, 19);
            Product product8 = session.get(Product.class, 20);


            supplier1.addProduct(product1);
            supplier1.addProduct(product2);
            supplier2.addProduct(product3);
            supplier2.addProduct(product4);
            supplier3.addProduct(product5);
            supplier3.addProduct(product6);
            supplier4.addProduct(product7);
            supplier4.addProduct(product8);
*/

            tx.commit();



        } finally {
            session.close();
        }
    }

}