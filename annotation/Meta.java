package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
   String str();
    int value();
}

public class Meta {

//    @MyAnno(str = "Example of annotation", value=100)
//    public static void myMeth(){
//        Meta ob = new Meta();
//
//        try {
//            //get object type of Class
//            Class<?> c = ob.getClass();
//
//            Method m = c.getMethod("myMeth");
//
//            MyAnno anno = m.getAnnotation(MyAnno.class);
//
//            System.out.println(anno.str() + " " + anno.value());
//        }catch (NoSuchMethodException e){
//            System.out.println("Method not found");
//        }
//    }
//
//    public static void main(String[] args) {
//        myMeth();
//    }
}
