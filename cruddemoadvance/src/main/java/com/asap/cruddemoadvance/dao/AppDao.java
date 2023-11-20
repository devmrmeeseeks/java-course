package com.asap.cruddemoadvance.dao;

import com.asap.cruddemoadvance.entity.Course;
import com.asap.cruddemoadvance.entity.Instructor;
import com.asap.cruddemoadvance.entity.InstructorDetail;
import com.asap.cruddemoadvance.entity.Student;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void updateStudent(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
    void deleteCourseById(int id);
    void saveCourse(Course course);
    Course findCourseAndReviewsById(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
    void updateStudent(Student student);
    void deleteStudentById(int id);
}
