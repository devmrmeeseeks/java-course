package com.asap.cruddemo;

import com.asap.cruddemo.dao.StudentDao;
import com.asap.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
//			createStudent(studentDao);
			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			queryForStudents(studentDao);
//			queryForStudentsByLastName(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//			deleteAllStudents(studentDao);

		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		int deleted = studentDao.deleteAll();
		System.out.println("Deleted " + deleted + " students");
	}

	private void deleteStudent(StudentDao studentDao) {
		studentDao.deleteById(3);
	}

	private void updateStudent(StudentDao studentDao) {
		Student student = studentDao.findById(1);
		student.setFirstName("John");
//		student.setLastName("Doo");
		studentDao.update(student);
	}

	private void queryForStudents(StudentDao studentDao) {
		System.out.println("Querying for students");
		studentDao.findAll().forEach(student -> System.out.println(student.toString()));
//		List<Student> students = studentDao.findAll();
//		for(Student student: students) {
//			System.out.println(student.toString());
//		}
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		studentDao.findByLastName("Doe").forEach(student -> System.out.println(student.toString()));
	}

	private void readStudent(StudentDao studentDao) {
		Student transientStudent = createStudent(studentDao);

		Student student = studentDao.findById(transientStudent.getId());
		System.out.println(student.toString());
	}

	private Student createStudent(StudentDao studentDao) {
		System.out.println("Creating new student object");
		Student tempStudent = new Student("John", "Doe", "john.doe@gmail");

		System.out.println("Saving student");
		studentDao.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		return tempStudent;
	}

	private void createMultipleStudents(StudentDao studentDao) {
		System.out.println("Creating multiple students object");
		ArrayList<Student> students = new ArrayList() {
			{
				add(new Student("John", "Doe", "john.doe@gmail"));
				add(new Student("Mary", "Public", "mary.public@gmail"));
				add(new Student("Bonita", "Applebum", "bonita.applebum@gmail"));
				add(new Student("James", "Bond", "james.bond@gmail"));
			}
		};

		students.forEach(student -> {
			System.out.println("Saving student: " + student.getEmail());
			studentDao.save(student);
			System.out.println("Saved student. Generated id: " + student.getId());
		});
	}
}
