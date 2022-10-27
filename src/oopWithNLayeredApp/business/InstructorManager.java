package oopWithNLayeredApp.business;

import oopWithNLayeredApp.dataAccess.InstructorDao;
import oopWithNLayeredApp.entities.Instructor;
import oopWithNLayeredApp.logging.Logger;

public class InstructorManager {
    private Instructor[] instructors;
    private Logger[] loggers;
    private InstructorDao instructorDao;

    public InstructorManager(Instructor[] instructors, Logger[] loggers, InstructorDao instructorDao) {
        this.instructors = instructors;
        this.loggers = loggers;
        this.instructorDao = instructorDao;
    }

    public void addInstructor(Instructor instructor) throws Exception {
        for (Instructor instructor1: instructors){
            if (instructor1 != instructor){
                if (instructor1.getInstructorName() == instructor.getInstructorName()){
                    throw new Exception("Instructor names cannot be the same!");
                }
            }
        }
        instructorDao.add(instructor);
        for (Logger logger:loggers){
            logger.log(instructor.getInstructorName());
        }
    }
}
