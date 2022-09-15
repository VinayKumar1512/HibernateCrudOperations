package com.spring.orm.dao;
import java.util.*;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	//save student
	
	@Transactional
	public int insert(Student student) {
		
		//insert
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	//get single student
	public Student getStudent(int studentId) {
		
		Student student= this.hibernateTemplate.get(Student.class,studentId);
		
		return student;
	}

	//get all students
	public List<Student> getAllStudents() {
		List<Student> students= this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//deleting student data
	@Transactional
	public void deleteStudent(int studentId) {
		
		Student student= this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
