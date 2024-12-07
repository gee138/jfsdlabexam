package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration()
                .configure()
                .addAnnotatedClass(Device.class)
                .addAnnotatedClass(Smartphone.class)
                .addAnnotatedClass(Tablet.class);
        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert Device Record
        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("G1");
        device.setPrice(15000);

        // Insert Smartphone Record
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 13");
        smartphone.setPrice(80000);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution(12);

        // Insert Tablet Record
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S7");
        tablet.setPrice(60000);
        tablet.setScreenSize(11.0);
        tablet.setBatteryLife(12);

        // Persist Objects
        session.save(device);
        session.save(smartphone);
        session.save(tablet);

        transaction.commit();
        session.close();

        System.out.println("Records inserted successfully!");
    }
}
