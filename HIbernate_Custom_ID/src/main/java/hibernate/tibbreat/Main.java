package hibernate.tibbreat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        SessionFactory factory = cfg.configure().buildSessionFactory();
        Session session = factory.openSession();

        //Bắt đầu Transaction
        Transaction tx = session.beginTransaction();

        try {
            //Tạo một Customer mới
            Customer customer = Customer.builder()
                    .name("Trung Kien")
                    .build();
            // Lưu customer vào db
            session.save(customer);
            tx.commit();

            // Lấy ra Id của Customer vừa mới add
            System.out.println("Customer ID: " + customer.getId());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}