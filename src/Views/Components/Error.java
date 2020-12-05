package Views.Components;
import static javax.swing.JOptionPane.*;

public class Error {
    public void generatedError(String err) {
        if(!err.isEmpty())
            showMessageDialog(null, err, "An error has occurred", ERROR_MESSAGE);
        else
            showMessageDialog(null, "A generalized category error has occurred", "An error has occurred", ERROR_MESSAGE);
    }
}
