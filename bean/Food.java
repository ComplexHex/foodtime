package bean;

public class Food {
    private String name;
    private final int id;
    private int carbohydrate;

    public static final Food NULL_FOOD = new Food();

    public Food(String name, int id, int carbohydrate) {
        this.name = name;
        this.id = id;
        this.carbohydrate = carbohydrate;

    }

    public Food() {
    this("", 0,0);
    }

    public Food clone() {
        try {
            return (Food) super.clone();
        } catch (CloneNotSupportedException ignored) {
            return NULL_FOOD;
        }
    }

    public Food clone(int newId) {
        if (this == NULL_FOOD) return NULL_FOOD;

        return new Food(name, newId, carbohydrate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "Еда - " + name + ", номер - " + id + ", углеводы - " + carbohydrate;
    }
}
