package annotation.service;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            System.out.println("true");
            Method[] m = service.getDeclaredMethods();
            for (Method method:m){
                System.out.println(method.getName());
            }
        } else System.out.println("false");
        System.out.println(service.getAnnotation(Service.class));
    }


    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }
}
