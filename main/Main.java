package main;

import model.Course;
import service.CourseService;

public class Main {
    public static void main(String[] args) {
        

        Course newCourse  = new Course("pp2", "Java", 1202, 6, 20318, 'B', null, null, null);


        CourseService courseService = new CourseService();


        courseService.addCourse(newCourse);
    }
}
