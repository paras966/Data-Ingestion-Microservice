package com.spring.API.service;

import com.spring.API.repository.RoutersData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouterDataService {
    public List<RoutersData> getAll(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(RoutersData.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<RoutersData> query = session.createQuery("FROM RoutersData", RoutersData.class);
        List<RoutersData> routersDataList = query.getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return routersDataList;
    }

    public List<Object> getDeviceData(String deviceId){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(RoutersData.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<Object> query = session.createQuery("SELECT cpuUtilization, memoryUtilization FROM RoutersData WHERE deviceId = :deviceId");
        query.setParameter("deviceId", deviceId);
        List<Object> results = query.getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return results;
    }

    public List<String> getNts(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(RoutersData.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT networkTrafficStatus FROM RoutersData");
        List<String> results = query.getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return  results;
    }

    public List<Object> getResources(){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(RoutersData.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<Object> query = session.createQuery("SELECT cpuUtilization, memoryUtilization FROM RoutersData");
        List<Object> results = query.getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return results;
    }
}
