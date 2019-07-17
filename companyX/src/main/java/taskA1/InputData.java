package taskA1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InputData {

    Date date;
    String demand;
    String generation;
    String engine;
    String turbina;
    String fuel;
    String ciclo;
    String generacion;

    public InputData(Date date, String demand, String generation, String engine, String turbina, String fuel, String ciclo, String generacion) {
        this.date = date;
        this.demand = demand;
        this.generation = generation;
        this.engine = engine;
        this.turbina = turbina;
        this.fuel = fuel;
        this.ciclo = ciclo;
        this.generacion = generacion;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "date=" + date +
                ", demand='" + demand + '\'' +
                ", generation='" + generation + '\'' +
                ", engine='" + engine + '\'' +
                ", turbina='" + turbina + '\'' +
                ", fuel='" + fuel + '\'' +
                ", ciclo='" + ciclo + '\'' +
                ", generacion='" + generacion + '\'' +
                '}';
    }

    /**
     * @param input is a line from the text from the html
     * @return an object with parsed data or null
     */
    public static InputData fromTextToParsed(String input) {
        InputData inputData = null;
        try {
            List<String> parsedText = parsText(input);
            Date temp = parseDateText(parsedText.get(1));
            inputData = new InputData(temp, clean(parsedText.get(2)), clean(parsedText.get(3)), clean(parsedText.get(4)), clean(parsedText.get(5)), clean(parsedText.get(6)), clean2(parsedText.get(7)), clean3(parsedText.get(8)));

            //System.out.println("## v" + input + " --> " + inputData + "##");
        } catch (Exception e) {
//            System.err.println(e.getMessage());
            //System.out.println("## e" + input + " --> " + inputData + "##");
        }
        return inputData;
    }

    /**
     * parse txt to convert like
     * 2017/10/10</th>
     * 10102017T0000</
     * 10-10-2017</th>
     *
     * @param s
     * @return
     * @throws ParseException
     */
    private static Date parseDateText(String s) {

        Date date = null;
        try {
            try { //2017/10/10
                if (date == null)
                    date = new SimpleDateFormat("yyyy/MM/dd").parse(clean4(s));
            } finally {
            }

            try { // 10102017T0000
                if (date == null)
                    date = new SimpleDateFormat("ddMMyyyy7T0000").parse(clean4(s));
            } finally {
            }

            try { //10-10-2017
                if (date == null)
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(clean4(s));
            } finally {
            }
        } catch (Exception ec) {
        }
        return date;
    }


    //<tr class="primera odd"><th class="titulo ini" scope="row">2017/10/10</th>
    // <th class="titulo" scope="col">Demand (b.c)</th>
    // <th class="titulo" scope="col">Generation(1,234.56)</th>
    // <th class="titulo" scope="col">Motores diesel</th>
    // <th class="titulo" scope="col">Turbina de gas</th><th

    public static String clean4(String s) {
        return s.replace("class=\"titulo ini\" scope=\"row\">", "")
                .replace("</th>", "")
                .trim();
    }
// TODO rename method names

    private static String clean3(String s) {
        return s.replace("class=\"titulo\" scope=\"col\">", "")
                .replace("</th> </tr>", "")
                .trim();
    }

    private static String clean2(String s) {
        return s.replace("class=\"titulo\" scope=\"col\">", "")
                .replace("</sup></th>", "")
                .trim();
    }

    private static String clean(String s) {
        return s.replace("class=\"titulo\" scope=\"col\">", "")
                .replace("</th>", "")
                .trim();
    }

    public static List<String> parsText(String input) {
        return Arrays.asList(input.split("<th"));
    }

    public static List<InputData> createListOfInputData(List<String> onlyValid){
        List<InputData> inputDataList = new ArrayList<>();
        for (String o : onlyValid ) {
            InputData object = fromTextToParsed(o);
            inputDataList.add(object);
        }
        return inputDataList;
    }
}
