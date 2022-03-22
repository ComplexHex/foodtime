package foodtime;

import bean.Food;
import bean.TableFood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestFood {
    private List<Food> foods = new ArrayList<>();
    private List<TableFood> tableFoods;
    private Date date;
    private int weight;

    {
        foods.add(new Food(1,"Чай",  0));
        foods.add(new Food(2,"Хлеб",  27));
        foods.add(new Food(3,"Сахар",  100));
        foods.add(new Food(4,"Колбаса",  0));
        foods.add(new Food(5,"Банан",  30));
    }

    public void setUpFood(){
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i));
        }
    }

    public void chooseFood(){
        System.out.println("Выберите номер еды и напишите массу в граммах. Пример: 2 25");

       try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           String line = null;
           while ((line = reader.readLine()) != null){
               String[] params = line.split(" ");

               if (params.length != 2){
                   continue;
               }

               String food = params[0];
               String weight = params[1];

           }
       }catch (IOException e){
           e.printStackTrace();
       }
    }


    public static void main(String[] args) {
        TestFood testFood = new TestFood();
        testFood.setUpFood();
    }

}
