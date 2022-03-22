package foodtime;

import bean.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestFood {
    private List<Food> foods = new ArrayList<>();
    private List<TableFood> tableFoods = new ArrayList<>();
    private DateFormat date = new SimpleDateFormat("H:m:s d.M.yyyy");
    private int weight;

    {
        foods.add(new Food(1, "Чай", 0,0));
        foods.add(new Food(2, "Хлеб", 1, 20));
        foods.add(new Food(3, "Сахар", 10, 100));
        foods.add(new Food(4, "Колбаса", 0, 100));
        foods.add(new Food(5, "Банан", 1,70));
        foods.add(new Food(6, "Греча", 1,50));
    }

    public void setUpFood() {
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i));
        }
    }

    public void chooseFood() {
        Food foodToTable = null;

        System.out.println("Выберите номер еды и напишите количество ХЕ. Пример: 2 1");


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while (!Objects.equals(line = reader.readLine(), "exit")) {
                String[] params = line.split(" ");

                if (params.length != 2) {
                    continue;
                }

                int foodId = Integer.parseInt(params[0]);
                int he = Integer.parseInt(params[1]);

                for (Food food1 : foods) {
                    if (foodId == food1.getId()) {
                        foodToTable = food1;
                    }
                }


                tableFoods.add(new TableFood(foodToTable, he, date));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTableFood(){
        for (TableFood tableFood :tableFoods){
            System.out.println(tableFood);
        }
    }


    public static void main(String[] args) {
        TestFood testFood = new TestFood();
        testFood.setUpFood();
        testFood.chooseFood();
        testFood.printTableFood();
    }

    private class TableFood {
        private Food food;
        private int he;
        private DateFormat date;

        public TableFood(Food food, int he, DateFormat date) {
            this.food = food;
            this.he = he;
            this.date = date;
        }

        public Food getFood() {
            return food;
        }

        public int getHe() {
            return he;
        }

        public String getDate() {
            String pattern = "HH:mm dd.MM";
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            Date today = Calendar.getInstance().getTime();
            String todayAsString = dateFormat.format(today);


            return todayAsString;
        }

        @Override
        public String toString() {
            return food.getName() + " " + food.getHe() + "ХЕ - " + getDate();
        }
    }

}
