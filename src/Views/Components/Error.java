package Views.Components;
import static javax.swing.JOptionPane.*;

public class Error {
    public void generatedError(String err) {
        if(!err.isEmpty())
            showConfirmDialog(null, err, "An error has occurred", CLOSED_OPTION);
    }
}
