import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.ListView;

public class WorkThreads extends Thread
{
	private ListView<String> list = null;
	 
    public WorkThreads(ListView<String> list, int count) {
        setDaemon(true);
        setName("Thread " + count);
        this.list = list;
    }
 
    @Override
    public void run() {
 
        while (!this.isInterrupted()) {
             
            // UI updaten
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    // entsprechende UI Komponente updaten
                    list.getItems().add(0, getName() + " sagt Hallo!");
                }
            });
 
            // Thread schlafen
            try {
                // fuer 3 Sekunden
                sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
 
    }
 
}