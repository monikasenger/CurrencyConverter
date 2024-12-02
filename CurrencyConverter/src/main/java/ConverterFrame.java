
import javax.swing.*;
import java.awt.*;

/**
 * class to create main window frame ofCurrency Converter.
 */
public class ConverterFrame extends JFrame {

    public ConverterFrame() {
        // set  title, size, and close behavior for  main window.
        setTitle("Currency Converter");  //  title of  window
        setSize(500, 400);  // size of  window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // close the app when window is closed
        setLayout(new BorderLayout());  // arrange components in a border layout

        // add  header panel and  converter panel
        add(new HeaderPanel(), BorderLayout.NORTH);  //header at the top of frame
        add(new ConverterPanel(), BorderLayout.CENTER);  // converter form in the center of frame

        // center the window on the screen and display it.
        setLocationRelativeTo(null);  // center the window
        setVisible(true);  //show the window to the user
    }
}
