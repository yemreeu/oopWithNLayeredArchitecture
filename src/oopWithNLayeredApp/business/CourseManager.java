package oopWithNLayeredApp.business;

import oopWithNLayeredApp.dataAccess.CourseDao;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.logging.Logger;

public class CourseManager {
    private CourseDao courseDao;
    private Course[] courses;
    private Logger[] loggers;

    public CourseManager(CourseDao courseDao, Course[] courses, Logger[] loggers) {
        this.courseDao = courseDao;
        this.courses = courses;
        this.loggers = loggers;
    }

    public void addCourse(Course course) throws Exception {
        if (course.getCoursePrice()<0){
            throw new Exception("Course prices could not be lower than 0!");
        }
        for(Course currentCourse: courses ){
            if (currentCourse != course){
                if (currentCourse.getCourseName() == course.getCourseName()){
                    throw new Exception("Name of the courses could not be the same!");
                }
            }
        }
        for (Course currentCourse: courses){
            if (currentCourse != course){
                if (currentCourse.getId() == course.getId()){
                    throw new Exception("Id of the courses could not be the same");
                }
            }
        }
        courseDao.add(course);
        for (Logger logger: loggers){
            logger.log(course.getCourseName());
        }
    }
}
