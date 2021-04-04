package com.simsoft.transport.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

public class BaseDAO  {
    @Autowired
    private EntityManager entityManager;

    public Session getCurrentSession() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession;
    }

}
