package com.mvc.dao;

import java.util.List;

import com.mvc.dto.StudentDTO;

public interface StudentDAOInterface {

	void addStudent(String name, String email, String userName, String password);

	StudentDTO login(String userName, String password);

	List<StudentDTO> viewAllStudents();

	StudentDTO removeStudent(int id);

	StudentDTO updateStudent(int id, String name, 
			String email, String userName, String password);
	
	StudentDTO searchStudent(int id);
}
