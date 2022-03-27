package annotation.service;

@Service(name = "SimpleServiceInterface")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("initService");
    }

    public void notInitService(){
        System.out.println('n');
    }
}
