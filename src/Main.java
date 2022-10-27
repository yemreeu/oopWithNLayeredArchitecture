import oopWithNLayeredApp.business.CategoryManager;
import oopWithNLayeredApp.business.CourseManager;
import oopWithNLayeredApp.business.InstructorManager;
import oopWithNLayeredApp.dataAccess.HibernateCategoryDao;
import oopWithNLayeredApp.dataAccess.HibernateInstructorDao;
import oopWithNLayeredApp.dataAccess.JdbcCourseDao;
import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.entities.Instructor;
import oopWithNLayeredApp.logging.DatabaseLogger;
import oopWithNLayeredApp.logging.FileLogger;
import oopWithNLayeredApp.logging.Logger;
import oopWithNLayeredApp.logging.MailLogger;

public class Main {
    public static void main(String[] args) throws Exception {

        Category category1 = new Category(0,"Programming");
        Category category2 = new Category(1,"Science");
        Category category3 = new Category(2,"Math");

        Instructor instructor1 = new Instructor("0123456789","Steve Jobs");
        Instructor instructor2 = new Instructor("9875465612","Yunus Emre Uyanık");
        Instructor instructor3 = new Instructor("46565487","Albert Einstein");

        Course course1 = new Course(0,"Java Programming",10,category1,instructor1);
        Course course2 = new Course(1,"Science",50,category2,instructor3);
        Course course3 = new Course(2,"Basic Mathematics",5,category3,instructor2);

        Instructor[] instructors = {instructor1,instructor2,instructor3};
        Course[] courses = {course1,course2,course3};
        Category[] categories = {category1,category2,category3};
        Logger[] loggers = {new DatabaseLogger(),new FileLogger(),new MailLogger()};

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(),loggers,categories);
        CourseManager courseManager = new CourseManager(new JdbcCourseDao(),courses,loggers);
        InstructorManager instructorManager = new InstructorManager(instructors,loggers,new HibernateInstructorDao());

        /*
        for(Instructor instructor: instructors){
            instructorManager.addInstructor(instructor);
        }
        for (Category category: categories){
            categoryManager.addCategory(category);
        }
        for (Course course:courses){
            courseManager.addCourse(course);
        }
        */

        System.out.println("**********************************************");
        System.out.println("Contents: ");
        System.out.println();
        for (Course course:courses){

            System.out.println("Course name: " + course.getCourseName() + "\nCourse Id: " + course.getId()+
                    "\nCourse price: " + course.getCoursePrice()+
                    "\nCourse Category: " + course.getCategory().getCategoryName()
                    + "\nInstructor of the course:  " + course.getInstructor().getInstructorName());
            System.out.println();
        }
    }
}