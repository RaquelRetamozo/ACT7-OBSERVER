import java.io.IOException;
import java.util.HashMap;

public class EventManager {
    private HashMap<String, EventListener> listeners = new HashMap<>();

    public void subscribe(String eventType, EventListener listener){
        listeners.put(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListener listener){
        listeners.remove(eventType, listener);
    }

    public void notify(String eventType, String data){
        listeners.forEach((et, lstr) ->
                {
                    try {
                        lstr.update(data);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
