package annotation.service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AnnotationProcessor {
    static Map<String, Object> serviceMap = new HashMap<>();

    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            System.out.println("true");
            Method[] m = service.getDeclaredMethods();
            for (Method method : m) {
                System.out.println(method.getName());
            }
        } else System.out.println("false");
        System.out.println(service.getAnnotation(Service.class));
    }

   
    static void loadService(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> cl = Class.forName(className);
        if (cl.isAnnotationPresent(Service.class)) {
            Object serviceObj = cl.newInstance();
            serviceMap.put(className, serviceObj);

            Method[] methods = serviceObj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    try {
                        method.invoke(serviceObj);
                    } catch (Exception e) {
                        Init ann = method.getAnnotation(Init.class);
                        if (ann.supressException()) {
                            System.err.println(e.getMessage());
                        } else {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        inspectService(SimpleService.class);
//        inspectService(LazyService.class);
//        inspectService(String.class);

        loadService("annotation.service.SimpleService");
        loadService("annotation.service.LazyService");
        loadService("java.lang.String");

        for (Map.Entry<String, Object> m : serviceMap.entrySet()) {
            System.out.println(m.getKey() + m.getValue());
        }
    }
}
