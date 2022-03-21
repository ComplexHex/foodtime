package bean;

import java.util.Date;

public class TableFood {
    private Food food;
    private int he;
    private Date date;

    public TableFood(Food food, int he, Date date) {
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

    public Date getDate() {
        return date;
    }
}
