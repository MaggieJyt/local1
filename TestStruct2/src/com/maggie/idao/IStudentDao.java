package com.maggie.idao;

import java.sql.SQLException;
import java.util.List;

import com.maggie.entity.Student;


public interface IStudentDao {
	boolean deleteStuBySno(String sno);
	boolean addStu(Student student);
	boolean updateStu(Student student);
	Student findStuBySno(String sno);
}
