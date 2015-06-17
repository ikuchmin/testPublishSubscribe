import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ikuchmin on 17.06.15.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new Subscriber(publisher);
        Subscriber subscriber2 = new Subscriber(publisher);
        Subscriber subscriber3 = new Subscriber(publisher);
        Subscriber subscriber4 = new Subscriber(publisher);
        Subscriber subscriber5 = new Subscriber(publisher);
        Subscriber subscriber6 = new Subscriber(publisher);


        while (true) {
            publisher.publish("Message1");
            publisher.publish("Message2");
            publisher.publish("Message3");
            publisher.publish("Message4");
        }
    }
}
