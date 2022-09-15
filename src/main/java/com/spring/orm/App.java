package com.spring.orm;
import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");

		StudentDao studentDao = context.getBean("StudentDao", StudentDao.class);
//        Student student= new Student(88,"Vinay Kumar","Kangra");
//        
//        int r= studentDao.insert(student);
//        System.out.println("Done "+r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean flag = true;
		while (flag) {

			System.out.println("Press 1 to add new Student");
			System.out.println("Press 2 to display All Students");
			System.out.println("Press 3 to get a single Student");
			System.out.println("Press 4 to delete a Student");
			System.out.println("Press 5 to update Student");
			System.out.println("Press 6 to exit");

			try {

				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					
					//adding student
					int id = Integer.parseInt(br.readLine());
					String name= br.readLine();
					String city= br.readLine();
					
					studentDao.insert(new Student(id,name,city));
					break;

				case 2:
					//displaying all students
					List<Student> students= studentDao.getAllStudents();
					for(Student st : students) {
						System.out.println(st.getStudentId()+" "+st.getStudentName()+" "+st.getStudentCity());
					}
					break;

				case 3:
					int cid= Integer.parseInt(br.readLine());
					Student student= studentDao.getStudent(cid);
					System.out.print(student.getStudentId()+" "+student.getStudentName()+" "+student.getStudentCity());
					break;
				case 4:
					int iid= Integer.parseInt(br.readLine());
					studentDao.deleteStudent(iid);
					System.out.print("Student Deleted Successfully");
					break;

				case 5:
					int uid = Integer.parseInt(br.readLine());
					String nname= br.readLine();
					String ccity= br.readLine();
					studentDao.updateStudent(new Student(uid,nname,ccity));
					System.out.print("Student got Updated");
					break;

				case 6:
					flag=false;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
                     System.out.println("Invalid Input Please Enter Valid Input");
			}
		}
		
		System.out.println("Thankyou for Using My Application");

	}

}
