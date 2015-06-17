/**
 * Created by ikuchmin on 17.06.15.
 */
public class Subscriber{

    private String message;

    public Subscriber(Publisher publisher) {
        publisher.subscribe(new SubscriberListener() {
            @Override
            public void publish(String str) {
//                System.out.println("String " + str + " class: " + this);
            }
        });
    }

//    @Override
//    public void run() {
//        while (true){
//            System.out.println(message);
//            try {
//                Thread.sleep(100L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
