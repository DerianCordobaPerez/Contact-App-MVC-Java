package Views.Components;
import static javax.swing.JOptionPane.*;

public class Error {
    public void generatedError(String message) {
        if(!message.isEmpty())
            showMessageDialog(null, message, "An error has occurred", ERROR_MESSAGE);
        else
            showMessageDialog(null, "A generalized category error has occurred", "An error has occurred", ERROR_MESSAGE);
    }
}
