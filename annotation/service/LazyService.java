package annotation.service;

@Service(name = "LazyServiceInterface")
public class LazyService {

    @Init
    public void lazyInit() throws Exception {

        System.out.println("lazyInit");

    }
}
