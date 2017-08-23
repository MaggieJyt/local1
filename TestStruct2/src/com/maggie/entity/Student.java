package com.maggie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 将一个类声明为一个实体bean(即一个持久化POJO类)
@Table(name = "student", schema = "test") // 注解声明了该实体bean映射指定的表（table）schema
public class Student {
	@Id
	@Column(name = "sno", nullable = false, unique = true)
	private String sno;
	@Column(name = "age")
	private int age;
	@Column(name = "totalscore")
	private double totalScore;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", age=" + age + ", totalScore=" + totalScore + "]";
	}

	public Student(String sno, int age, double totalScore) {
		super();
		this.sno = sno;
		this.age = age;
		this.totalScore = totalScore;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
