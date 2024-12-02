
import javax.swing.*;
import java.awt.*;

/**
 * class to create  header panel with the title of the application.
 */
public class HeaderPanel extends JPanel {

    public HeaderPanel() {
        // create a label to show the title of  Currency Converter.
        JLabel titleLabel = new JLabel("Currency Converter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // set title font style and size
        titleLabel.setForeground(Color.BLACK);  // set title text color

        // add title label in panel.
        add(titleLabel);  // display title in panel
    }
}
