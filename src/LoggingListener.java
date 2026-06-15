import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggingListener implements EventListener{
    private File log;
    private String message;

    public LoggingListener(String log_filename, String message){
        this.log = new File(log_filename);
        this.message = message;
    }

    @Override
    public void update(String filename) throws IOException {
        System.out.println("Guardando en Archivo ...");
        FileWriter escritor = new FileWriter(this.log);
        escritor.write("Actualización clase EmailAlertsListener");
        escritor.close();
    }
}
