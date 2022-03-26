package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {}

public class Marker {

    @MyMarker
    public static void myMeth(){
        Marker ob = new Marker();

        try {
            Method method = ob.getClass().getMethod("myMeth");

            if (method.isAnnotationPresent(MyMarker.class)){
                System.out.println("Marker is here");
            }

        }catch (NoSuchMethodException e){
            System.out.println("Marker is not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
