package com.maggie.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jyt.dao.UserDao;
import com.maggie.entity.Student;
import com.maggie.idao.IStudentDao;

public class StudentDao implements IStudentDao {
	// private SessionFactory sessionFactory;
	//
	// public Session getSession() {
	// return sessionFactory.getCurrentSession();
	// }
	//
	// @Resource
	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }
	private static SessionFactory sessionFactory = null;

	private Transaction ts = null;
	private String sql = "";
	private Session session = null;

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

	@Override
	public boolean deleteStuBySno(String sno) {
		getSession();
		String sql = "delete from student where sno = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, sno);

		return (query.executeUpdate() > 0);

	}

	@Override
	public boolean addStu(Student student) {
		getSession();
		
		System.out.println("======"+student);
		session.save(student);
		session.flush();
		ts.commit();
		
		return true;
		// System.out.println(student.getSno());
		// System.out.println(student.getAge());
		// System.out.println(student.getTotalScore());
		// getSession();
		// String sql = "insert into student(sno,age,totalScore) values(?,?,?)";
		// Query query = session.createQuery(sql);
		//
		// query.setParameter(0, student.getSno());
		// query.setParameter(1, student.getAge());
		// query.setParameter(2, student.getTotalScore());
		// return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateStu(Student student) {
		getSession();
		String sql = "update student set age = ?, totalscore = ? where sno = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, student.getAge());
		query.setParameter(1, student.getTotalScore());
		query.setParameter(2, student.getSno());
		return (query.executeUpdate() > 0);

	}

	@Override
	public Student findStuBySno(String sno) {
		getSession();
		List<Student> list = null;
		String sql = "SELECT sno,age,totalscore from student where sno = ?";
		Query query = session.createQuery(sql);
		query.setParameter(0, sno);
		list = query.list();

		return (Student) list;
	}

}
