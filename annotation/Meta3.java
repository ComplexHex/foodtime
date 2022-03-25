package annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3 {
    String str() default "Test";
    int value() default 9000;
}

public class Meta3 {

    public static void myMeth() {
        Meta3 meta3 = new Meta3();

        try {
            Class<?> c = meta3.getClass();

            Method m = c.getMethod("myMeth");

            MyAnno3 anno = m.getAnnotation(MyAnno3.class);

            System.out.println(anno.str() + " " + anno.value());


        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }

}
