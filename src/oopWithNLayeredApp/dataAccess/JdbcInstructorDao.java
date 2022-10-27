package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Instructor;

public class JdbcInstructorDao implements InstructorDao{

    @Override
    public void add(Instructor instructor) {
        System.out.println("It has been added via JDBC!");
    }
}
