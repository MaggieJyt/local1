package com.jyt.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jyt.entity.Student;

public class UserDao {
	private static SessionFactory sessionFactory = null;

	private Transaction ts = null;
	private String sql = "";
	private Session session = null;

	
	public boolean Login(Student user) {
		try {
			getSession();
            sql = "select name,password from Student where name=? and password=?";
            Query query = session.createQuery(sql);
            query.setParameter(0, user.getName());
            query.setParameter(1, user.getPassword());
            System.out.println(user.getName()+user.getPassword());
            List list = query.list();
            ts.commit();
            if (!list.isEmpty())
                return true;
            else
                return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// 创建Configuration对象:对应hibernate的基本配置信息和对象关系映射信息
			Configuration config = new Configuration().configure();
			// 创建一个对象StandardServiceRegistry，configure("你的***.cfg.xml")，默认为hibernate.cfg.xml
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			// 创建会话工厂对象
			sessionFactory = config.buildSessionFactory(registry);
			return sessionFactory;
		} else
			return sessionFactory;
	}

	public void getSession() {
		session = UserDao.getSessionFactory().openSession();
		ts = session.beginTransaction();
	}

}
