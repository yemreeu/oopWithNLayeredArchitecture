package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Category;

public class JdbcCategoryDao implements CategoryDao{

    @Override
    public void add(Category category) {
        System.out.println("It has been added via JDBC!");
    }
}
