package dao;

import bean.Food;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private static DataSource ourInstance = new DataSource();

    public static DataSource getInstance(){
        return ourInstance;
    }

    private DataSource(){

    }

    private List<Food> foodList = new LinkedList<>() {
        {
//            add(new Food("Чай", 1, 0));
//            add(new Food("Хлеб", 2, 27));
//            add(new Food("Сахар", 3, 100));
//            add(new Food("Колбаса", 4, 0));
//            add(new Food("Банан", 5, 30));
        }
    };

    public List<Food> getFoodList() {
        return foodList;
    }
}
