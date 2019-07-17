package taskB3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CurrencyInformation {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        String filePath = "src/main/resources/task_B3.json";

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            JSONArray currency = (JSONArray) obj;
            currency.forEach(o -> System.out.println(createCurrencyByParsing((JSONObject) o)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Currency createCurrencyByParsing(JSONObject jsonObject) {
        JSONObject currencyObject = (JSONObject) jsonObject.get("currency");
        String name = (String) currencyObject.get("name");
        String price_usd = (String) currencyObject.get("price_usd");
        Currency currency = new Currency(name, price_usd);
        return currency;
    }
}