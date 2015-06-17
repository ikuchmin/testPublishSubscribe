import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ikuchmin on 17.06.15.
 */
public class Publisher {
    List<WeakReference<SubscriberListener>> listeners;

    public Publisher() {
        listeners = new CopyOnWriteArrayList<>();
    }

    public void subscribe(SubscriberListener listener) {
        listeners.add(new WeakReference<SubscriberListener>(listener));
    }

    public void publish(String str) {
        List<WeakReference<SubscriberListener>> corruptedListeners = new ArrayList<>();
        for (WeakReference<SubscriberListener> wrListener : listeners) {
            SubscriberListener listener = wrListener.get();
            if (listener != null)
                listener.publish(str);
            else
                corruptedListeners.add(wrListener);

            listeners.removeAll(corruptedListeners);

            System.out.println("Count listeners: " + listeners.size());
        }
    }
}
