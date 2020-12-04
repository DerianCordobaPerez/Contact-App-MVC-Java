package Views.Components.Contacts;
import Views.Components.Error;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author derian_cordoba
 **/


/**
 * @param -> method to select the priority color of contact order
 **/
public class ColorPickerContact {
    private JFrame colorPickerWindow;
    public void generateColorPicker() {
        this.colorPickerWindow = new JFrame("Please select a Color");
        this.colorPickerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container mainContainer = this.colorPickerWindow.getContentPane();
        final JButton colorSelectButton = new JButton("Select Color");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
                Runnable showDialog = new Runnable() {
                    @Override
                    public void run() {
                        windowDialog.setVisible(true);
                    }
                };
                SwingUtilities.invokeLater(showDialog);
            }
        };
        colorSelectButton.addActionListener(actionListener);
        mainContainer.add(colorSelectButton, BorderLayout.CENTER);
        this.colorPickerWindow.setSize(300, 100);
        this.colorPickerWindow.setVisible(true);
    }
}
