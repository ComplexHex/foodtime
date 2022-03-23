package annotation;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
    String str();

    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

@What(description = "Annotation test class")
@MyAnno2(str = "Meta2", val = 99)
class Meta2 {

    @What(description = "Annotation test of method")
    @MyAnno2(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            Annotation annos[] = ob.getClass().getAnnotations();

            System.out.println("All annotations for class Meta2:");
            for (Annotation a : annos){
                System.out.println(a);

                System.out.println();

                Method m = ob.getClass().getMethod("myMeth");
                annos = m.getAnnotations();

                System.out.println("All annotationa for method myMeth");
                for (Annotation a1 : annos){
                    System.out.println(a1);

                }


            }



        }catch (NoSuchMethodException e){
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }


}
