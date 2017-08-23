package com.maggie.iservice;

import java.util.List;

import com.maggie.entity.Student;


public interface IStudentService {
	boolean deleteStuBySno(String sno);
	boolean addStu(Student student);
	boolean updateStu(Student student);
	Student findStuBySno(String sno);
}
