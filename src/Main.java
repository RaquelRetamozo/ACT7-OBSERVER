import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hola usil");
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener("log.txt", "Hola Logging");
        editor.events.subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener("rjru@gmail.com", "Esto debe cambiar");
        editor.events.subscribe("save", emailAlerts);

        long inicio = System.currentTimeMillis(); // INICIO

        editor.openFile("C:/Users/RAQUEL/Downloads/PatronObserver/doc.txt");
        editor.saveFile();
        editor.openFile("C:/Users/RAQUEL/Downloads/PatronObserver/doc.txt");
        editor.saveFile();
        editor.events.shutdown(); // Agregado

        long fin = System.currentTimeMillis(); // FIN
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
    }
}