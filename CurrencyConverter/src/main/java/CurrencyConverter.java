
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * class to handle currency conversion logic.
 */
public class CurrencyConverter {
    // API endpoint to get exchange rates
    static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    // method to convert currency based on selected base and target currency
    public double convertCurrency(String baseCurrency, String targetCurrency, double amount) throws Exception {
        // construct  URL to exchange rates for  base currency
        String urlStr = API_URL + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");  // use GET to fetch data from  API

        // check if  response is successful
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Failed to fetch exchange rate. HTTP response code: " + responseCode);
        }

        // read  API response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);  // append each line of response
        }
        in.close();  // close the reader

        // parse the response of JSON object
        JSONObject jsonResponse = new JSONObject(response.toString());

        // check if target currency is in  response
        if (!jsonResponse.getJSONObject("rates").has(targetCurrency)) {
            throw new Exception("Target currency not found in exchange rates.");
        }

        // get exchange rate for  target currency
        double exchangeRate = jsonResponse.getJSONObject("rates").getDouble(targetCurrency);

        // calculate and return  converted amount
        return amount * exchangeRate;
    }
}
