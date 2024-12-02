import javax.swing.*;

/**
 * main class to start the Currency Converter application.
  */

public class CurrencyConverter_Main {

    public static void main(String[] args) {
        // runs  main window
        SwingUtilities.invokeLater(() -> {
            // create and show  main frame
            new ConverterFrame();
        });
    }
}
