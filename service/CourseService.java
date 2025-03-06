package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


                public List<Course>  getTakenCourses() throws FileNotFoundException, IOException{

                    List<Course> list = new ArrayList<>();

                
                    try(BufferedReader reader = new BufferedReader(new FileReader(courseTaken))){
                        String line;

                        while((line = reader.readLine() )!= null){
                           Course course =  csvToCourse(line);
                            list.add(course);
                        }
                        
                    }


                    return list;
                }

                
                private Course csvToCourse(String line) {
                    Course course = new Course();
                    
                    String[] csv = line.split(",");
                    char charr = csv[5].charAt(0);

                    course.setTitle(csv[0]);
                    course.setDescription(csv[1]);
                    course.setCourseCode(Integer.parseInt(csv[2]));
                    course.setCredits(Integer.parseInt(csv[3]));
                    course.setCRN(Integer.parseInt(csv[4]));
                    course.setPassingGrade(charr);
                    course.setPrerequisiteCourses(null);
                    course.setStudents(null);
                    course.setTeacher(null);

                    return course;
                }

        
}
