package Views.Components;

import javax.swing.*;

public class Success {
    public void generatedSuccess(String message) {
        if(!message.isEmpty())
            JOptionPane.showMessageDialog(null, message, "Everything has gone well", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "The action performed has been completed successfully", "Everything has gone well", JOptionPane.INFORMATION_MESSAGE);
    }
}
