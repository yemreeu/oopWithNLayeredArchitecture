package oopWithNLayeredApp.business;

import oopWithNLayeredApp.dataAccess.CategoryDao;
import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.logging.Logger;

public class CategoryManager {
    private CategoryDao categoryDao;
    private Logger[] loggers;
    private Category[] categories;

    public CategoryManager(CategoryDao categoryDao, Logger[] loggers, Category[] categories) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
        this.categories = categories;
    }

    public void addCategory(Category category) throws Exception {
        for (Category currentCategory : categories) {
            if (currentCategory != category){
                if (currentCategory.getCategoryName() == category.getCategoryName()){
                    throw new Exception("Category can not be the same!");
                }
            }

        }
        for(Category currentCategory : categories){
            if (currentCategory != category){
                if (currentCategory.getId() == category.getId()){
                    throw new Exception("ID of the categories can not be the same");
                }
            }
        }
        categoryDao.add(category);
        for (Logger logger: loggers) {
            logger.log(category.getCategoryName());
        }

    }
}
