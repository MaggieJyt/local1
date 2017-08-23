package com.maggie.service;


import com.maggie.dao.StudentDao;
import com.maggie.entity.Student;
import com.maggie.iservice.IStudentService;


public class StudentService implements IStudentService{
	private StudentDao stuDao = null;
	private Student student;
	private String sno;
	private double totalScore;
	private int age;
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public StudentService() {
		super();
		stuDao = new StudentDao();
	}


	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public boolean deleteStuBySno(String sno) {
		boolean bool = stuDao.deleteStuBySno(sno);
		return bool;
	}

	@Override
	public boolean addStu(Student student) {
		System.out.println(student+"====service");
		boolean bool = stuDao.addStu(student);
		return bool;
	}
	public String addStu() {
		student = new Student();
//		System.out.println(age);
//		System.out.println(sno);
//		System.out.println(totalScore);
		student.setAge(age);
		student.setSno(sno);
		student.setTotalScore(totalScore);
		boolean bool = stuDao.addStu(student);
		return "true";
	}

	@Override
	public boolean updateStu(Student student) {
		boolean bool = stuDao.updateStu(student);
		return bool;
	}

	@Override
	public Student findStuBySno(String sno) {
		return stuDao.findStuBySno(sno);
	}



}
