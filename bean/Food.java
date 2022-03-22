package bean;

public class Food {
    private String name;
    private final int id;
    private int carbohydrate;
    private int he;

    public static final Food NULL_FOOD = new Food();

    public Food(int id, String name, int he, int carbohydrate) {
        this.name = name;
        this.id = id;
        this.he = he;
        this.carbohydrate = carbohydrate;

    }

    public Food() {
        this(0, "", 0, 0);
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

        return new Food(newId, name, he, carbohydrate);
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

    public int getHe() {
        return he;
    }

    @Override
    public String toString() {
        return id + " - " + name + ", ХЕ - " + he + ", угл. в 100гр - " + carbohydrate;
    }
}
