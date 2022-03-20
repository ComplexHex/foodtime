package dao;

import bean.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodDao {
    private DataSource dataSource = DataSource.getInstance();

    public Food getFoodById(int id) {
        List<Food> foodList = dataSource.getFoodList();
        for (Food food : foodList) {
            if (food.getId() == id) {
                return food;
            }
        }
        return Food.NULL_FOOD;
    }

    public List<Food> getFoodByName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException();

        List<Food> foods = dataSource.getFoodList();
        List<Food> result = new ArrayList<>();
        for (Food food : foods) {
            if (name.equals(food.getName())) {
                addFoodToResult(result, food);
            }
        }
        return result;
    }


    public void addFoodToResult(List<Food> result, Food food) {
        Food clone = food.clone();

        //skip bad users
        if (clone != Food.NULL_FOOD) {
            result.add(clone);
        }
    }
}
