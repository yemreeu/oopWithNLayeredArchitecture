package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Course;

public class JdbcCourseDao implements CourseDao{

    @Override
    public void add(Course course) {
        System.out.println("It has been added via JDBC!");
    }
}
