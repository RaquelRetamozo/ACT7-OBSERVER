import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventManager {
    private HashMap<String, EventListener> listeners = new HashMap<>();
    //Agrega un pool de hilos reutilizables
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void subscribe(String eventType, EventListener listener){
        listeners.put(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListener listener){
        listeners.remove(eventType, listener);
    }

    public void notify(String eventType, String data){
        listeners.forEach((et, lstr) ->
                executor.submit(() -> {   //Agregado envuelve en executor.submit cada listener se notifica en un hilo separado de dorme asincrona
                    try {
                        lstr.update(data);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
    }
    //Metodo Agregado que cierra el pool de hilos ordenadamente ya no se necesita
    public void shutdown(){
        executor.shutdown();
    }
}
