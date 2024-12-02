
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *class to create panel where users can put currency details and convert currency.
 */
public class ConverterPanel extends JPanel {
   static JComboBox<String> baseCurrencyBox;  // dropdown for selecting  base currency
   static JComboBox<String> targetCurrencyBox;  // dropdown for selecting target currency
    static JTextField amountField;  // text field for enter amount
    static CurrencyConverter currencyConverter;  // instance to handle  currency conversion

    //converter panel constructor
    public ConverterPanel() {
        // set layout to arrange component in grid
        setLayout(new GridLayout(4, 2, 10, 10));  // grid layout wih rows and column
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // add padding

        // list of currencies for user to choose
        String[] currencies = {"USD", "EUR", "GBP", "INR", "JPY", "AUD", "CAD", "CHF", "CNY", "NZD"};

        // create and add labels, dropdowns, text field, and button component
        JLabel baseCurrencyLabel = new JLabel("Base Currency:");
        baseCurrencyLabel.setFont(new Font("Arial", Font.PLAIN, 18));  // base label text style
        baseCurrencyBox = new JComboBox<>(currencies);  // dropdown for base currency
        baseCurrencyBox.setFont(new Font("Arial", Font.PLAIN, 15));  // Set smaller font size
        baseCurrencyBox.setPreferredSize(new Dimension(100, 20));  // Set a smaller size for the dropdown

        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
        targetCurrencyLabel.setFont(new Font("Arial", Font.PLAIN, 18));  // target label text style
        targetCurrencyBox = new JComboBox<>(currencies);  // dropdown for target currency
        targetCurrencyBox.setFont(new Font("Arial", Font.PLAIN, 15));  // Set smaller font size
        targetCurrencyBox.setPreferredSize(new Dimension(100, 20));  // Set a smaller size for the dropdown

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Arial",Font.PLAIN, 18));  // amount label text style
        amountField = new JTextField();  // text field to enter amount

        // create Convert button and add action listener
        JButton convertButton = new JButton("Convert");
        convertButton.setFont(new Font("Arial", Font.BOLD, 30));  // button text style
        convertButton.setForeground(Color.WHITE);  // button text color
        convertButton.setBackground(new Color(0, 200, 100));  // button background color
        convertButton.setPreferredSize(new Dimension(100, 20));  // Set smaller size for the button
        convertButton.addActionListener(new ConvertButtonListener());  // action when clicked

        // add all components in panel
        add(baseCurrencyLabel);  // add base currency label
        add(baseCurrencyBox);  // add base currency dropdown
        add(targetCurrencyLabel);  // add target currency label
        add(targetCurrencyBox);  // add target currency dropdown
        add(amountLabel);  // add amount label
        add(amountField);  // add amount text field
        add(convertButton);  // add the Convert button

        // instance of CurrencyConverter class to handle conversion logic
        currencyConverter = new CurrencyConverter();
    }

    // action listener to handle click event in Convert button
    public static class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get selected currencies and entered amount
            String baseCurrency = (String) baseCurrencyBox.getSelectedItem();
            String targetCurrency = (String) targetCurrencyBox.getSelectedItem();
            String amountText = amountField.getText();

            try {
                // try to convert enter amount to a number
                double amount = Double.parseDouble(amountText);
                // perform  conversion and get  convert amount
                double convertedAmount = currencyConverter.convertCurrency(baseCurrency, targetCurrency, amount);

                // show result in a dialog box
                JOptionPane.showMessageDialog(null,
                        String.format("Converted Amount: %.2f %s", convertedAmount, targetCurrency),
                        "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                // if amount is invalid show  error message
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                // handle other errors and show  error message
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
