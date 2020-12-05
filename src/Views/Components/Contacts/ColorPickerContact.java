package Views.Components.Contacts;
import Views.Components.Error;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author derian_cordoba
 **/
public class ColorPickerContact {
    public void generateColorPicker() {
        JFrame colorPickerWindow = new JFrame("Please select a Color");
        colorPickerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container mainContainer = colorPickerWindow.getContentPane();
        final JButton colorSelectButton = new JButton("Select Color");

        ActionListener actionListener = actionEvent -> {
            Color initialBackgroundColor = colorSelectButton.getBackground();
            final JColorChooser colorChooser = new JColorChooser(initialBackgroundColor);
            final JLabel previewLabel = new JLabel("Sample Text", JLabel.CENTER);
            colorChooser.setPreviewPanel(previewLabel);
            colorChooser.updateUI();

            ActionListener okActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Color newColor = colorChooser.getColor();
                    if(newColor.equals(colorSelectButton.getForeground()))
                        new Error().generatedError("Failed to select expected color");
                    else
                        colorSelectButton.setBackground(colorChooser.getColor());
                }
            };

            ActionListener cancelActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    colorSelectButton.setBackground(Color.red);
                }
            };

            final JDialog windowDialog = JColorChooser.createDialog(null,
                    "Change Button Background", true, colorChooser,
                    okActionListener, cancelActionListener
            );
            Runnable showDialog = () -> windowDialog.setVisible(true);
            SwingUtilities.invokeLater(showDialog);
        };
        colorSelectButton.addActionListener(actionListener);
        mainContainer.add(colorSelectButton, BorderLayout.CENTER);
        colorPickerWindow.setSize(300, 100);
        colorPickerWindow.setVisible(true);
    }
}
