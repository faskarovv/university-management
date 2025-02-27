package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Course;

public class CourseService {
    private String courseTaken = "courseTaken.txt";
    private String courses = "allCourses.txt";


    public String addCourse(Course course) {

        try(BufferedWriter writer = new  BufferedWriter(new FileWriter(courseTaken))){
            writer.write(courseToCsv(course));

            }
             catch (IOException e) {
                e.printStackTrace();
                return "Error adding course: " + e.getMessage();           
             }
            
             return "added succesuful";
                }
            
            
                private String  courseToCsv(Course course) {
                    StringBuilder stringBuilder = new StringBuilder();

                    stringBuilder.append(course.getTitle()).append(",");
                    stringBuilder.append(course.getDescription()).append(",");
                    stringBuilder.append(course.getCourseCode()).append(",");
                    stringBuilder.append(course.getCredits()).append(",");
                    stringBuilder.append(course.getCRN()).append(",");
                    stringBuilder.append(course.getPassingGrade()).append(",");
                    stringBuilder.append(course.getPrerequisites()).append(",");
                    stringBuilder.append(course.getStudents()).append(",");
                    stringBuilder.append(course.getTeacher());

                    return stringBuilder.toString();
                }



        
}
