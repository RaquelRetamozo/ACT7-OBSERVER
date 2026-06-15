import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Editor {
    public EventManager events = new EventManager();
    private File file;


    public void openFile(String path){
        this.file = new File(path);
        events.notify("Notificamos que se abrió el archivo " , this.file.getName());
    }

    public void saveFile() throws IOException {
        FileWriter escritor = new FileWriter(this.file);
        escritor.write("Ya se acerca el fin del ciclo");
        escritor.close();
        events.notify("Notificamos que escribió en el archivo" , this.file.getName());
    }
}
