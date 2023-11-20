package com.asap.cruddemoadvance;

import com.asap.cruddemoadvance.dao.AppDao;
import com.asap.cruddemoadvance.entity.Course;
import com.asap.cruddemoadvance.entity.Instructor;
import com.asap.cruddemoadvance.entity.InstructorDetail;
import com.asap.cruddemoadvance.entity.Review;
import com.asap.cruddemoadvance.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class CruddemoadvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoadvanceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
//			createInstructors(appDao);
//			findInstructorById(appDao);
//			deleteInstructorById(appDao);
//			findInstructorDetailById(appDao);
//			deleteInstructorDetailById(appDao);
//			createInstructorWithCourses(appDao);
//			findInstructorWithCourses(appDao);
//			findCoursesByInstructorId(appDao);
//			updateInstructor(appDao);
//			updateCourse(appDao);
//			deleteCourse(appDao);
//			createCourseAndReviews(appDao);
//			findCourseAndReviewsById(appDao);
//			deleteCourseAndReviews(appDao);
//			createCourseAndStudents(appDao);
//			findCourseAndStudents(appDao);
			findStudentAndCourses(appDao);
//			addMoreCoursesForStudent(appDao);
//			deleteStudent(appDao);
		};
	}

	private void deleteStudent(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting student with id: " + id);

		appDao.deleteStudentById(id);

		System.out.println("Deleted student with id: " + id);
	}

	private void addMoreCoursesForStudent(AppDao appDao) {
		int id = 2;
		Student student = appDao.findStudentAndCoursesByStudentId(id);
		student.addCourse(new Course("Rubik's Cube - How to Speed Cube"));
		student.addCourse(new Course("Atari 2600 - Game Development"));

		System.out.println("Saving student: " + student);
		appDao.updateStudent(student);
		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDao appDao) {
		int id = 2;
		Student student = appDao.findStudentAndCoursesByStudentId(id);
		System.out.println("Found student: " + student);
		System.out.println("Found courses: " + student.getCourses());
	}

	private void findCourseAndStudents(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseAndStudentsByCourseId(id);
		System.out.println("Found course: " + course);
		System.out.println("Found students: " + course.getStudents());
	}

	private void createCourseAndStudents(AppDao appDao) {
		Course course = new Course("Pacman - How to Score One Million Points");
		Student student1 = new Student("John", "Doe", "john@asap.com");
		Student student2 = new Student("Mary", "Public", "mary@asap.com");
		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving course: " + course);
		System.out.println("Saving students: " + course.getStudents());

		appDao.saveCourse(course);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDao appDao) {
		int id = 10;
		appDao.deleteCourseById(id);
		System.out.println("Deleted course: " + id);
	}

	private void findCourseAndReviewsById(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseAndReviewsById(id);
		System.out.println("Found course: " + course);
		System.out.println("Found reviews: " + course.getReviews());
	}

	private void createCourseAndReviews(AppDao appDao) {
		Course course = new Course("Pacman - How to Score One Million Points");
		course.addReview(new Review("Great course ... loved it!"));
		course.addReview(new Review("Cool course, job well done"));
		course.addReview(new Review("What a dumb course, you are an idiot!"));

		System.out.println("Saving course: " + course);
		System.out.println("Saving reviews: " + course.getReviews());
		appDao.saveCourse(course);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseById(id);
		System.out.println("Found course: " + course);

		appDao.deleteCourseById(id);
		System.out.println("Deleted course: " + id);
	}

	private void deleteInstructor(AppDao appDao) {
	}

	private void updateCourse(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseById(id);
		System.out.println("Found course: " + course);

		course.setTitle("Enjoy the Simple Things");
		appDao.updateCourse(course);
		System.out.println("Updated course: " + 10);
	}

	private void updateInstructor(AppDao appDao) {
		int id = 1;
		System.out.println("Updating instructor with id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Found instructor: " + instructor);

		instructor.setFirstName("TESTER");

		System.out.println("Updated instructor: " + instructor);

		appDao.updateStudent(instructor);
	}

	private void findCoursesByInstructorId(AppDao appDao) {
		int id = 1;

		System.out.println("Finding instructor by id: " + id);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);
		System.out.println("Found instructor: " + instructor);

		System.out.println("Found courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int id = 1;
		System.out.println("Finding instructor with courses. With id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Found instructor: " + instructor);
		System.out.println("Found courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor instructor = new Instructor("Chad", "Darby", "chad@asap.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/chad", "Luv 2 code!!!");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);
		instructor.setCourses(instructor.getCourses());

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Saving courses: " + instructor.getCourses());
		appDao.save(instructor);

		System.out.println("Saved instructor: " + instructor);
	}

	private void deleteInstructorDetailById(AppDao appDao) {
		int id = 5;
		System.out.println("Deleting instructor detail with id: " + id);

		appDao.deleteInstructorDetailById(id);

		System.out.println("Deleted instructor detail with id: " + id);
	}

	private void findInstructorDetailById(AppDao appDao) {
		int id = 3;
		System.out.println("Finding instructor detail with id: " + id);

		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);

		System.out.println("Found instructor detail: " + instructorDetail);

		Instructor instructor = instructorDetail.getInstructor();

		System.out.println("Found instructor: " + instructor);
	}

	private void deleteInstructorById(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor with id: " + id);

		appDao.deleteInstructorById(id);

		System.out.println("Deleted instructor with id: " + id);
	}

	private void findInstructorById(AppDao appDao) {
		int id = 2;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Found instructor: " + instructor);
		System.out.println("Found instructor detail: " + instructor.getInstructorDetail());
	}

	private void createInstructors(AppDao appDao) {
		ArrayList<Instructor> tempInstructors = new ArrayList() {
			{
				add(new Instructor("Chad", "Darby", "darby@asap.com"));
				add(new Instructor("Madhu", "Patel", "madhu@asap.com"));
				add(new Instructor("Luca", "Bogdan", "luca@asap.com"));
				add(new Instructor("Jhon", "Doe", "john@asap.com"));
			}
		};

		InstructorDetail[] tempInstructorDetails = {
				new InstructorDetail("http://www.youtube.com/darby", "Luv 2 code!!!"),
				new InstructorDetail("http://www.youtube.com/madhu", "guitar"),
				new InstructorDetail("http://www.youtube.com/luca", "sports"),
				new InstructorDetail("http://www.youtube.com/john", "computers")
		};

		for (int i = 0; i < tempInstructors.size(); i++) {
			Instructor tempInstructor = tempInstructors.get(i);
			tempInstructor.setInstructorDetail(tempInstructorDetails[i]);
			System.out.println("Saving instructor: " + tempInstructor);
			appDao.save(tempInstructor);
		};
	}

}
