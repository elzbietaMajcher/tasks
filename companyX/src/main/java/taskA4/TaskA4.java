package taskA4;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskA4 {

    public static final String filePath = "src/main/resources/Desequilibre_Charges_2017-10-15_2017-11-14 (2).xls";

    public static void main(String[] args) throws IOException, InvalidFormatException, ParseException {

        List<RowObjUnfiltered> unfiltredList = create();
        for (RowObjUnfiltered r : unfiltredList
        ) {
            System.out.println(r);
        }

        List<RowObj> list = RowObj.createList(unfiltredList);
        for (RowObj r : list
        ) {
            System.out.println(r);
        }
        printInfo(list);

    }

    public static List<RowObjUnfiltered> create() throws IOException, InvalidFormatException, ParseException {
        Workbook workbook = WorkbookFactory.create(new File(filePath));
        DataFormatter dataFormatter = new DataFormatter();
        Sheet sheet = workbook.getSheetAt(1); // get sheet NORTH


        List<RowObjUnfiltered> rowObjUnfilteredList = new ArrayList<>();
        for (Row row : sheet) {

            if (row.getRowNum() < 4)
                continue;


            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                //System.out.print(cellValue + "\t");
            }

            String date = String.valueOf(row.getCell(0));
            String col2 = String.valueOf(row.getCell(2));
            String col5 = String.valueOf(row.getCell(5));
            RowObjUnfiltered rowObjUnfiltered = new RowObjUnfiltered(date, col2, col5);
            rowObjUnfilteredList.add(rowObjUnfiltered);
        }
        //System.out.println(rowObjUnfilteredList);
        workbook.close();
        return rowObjUnfilteredList;
    }

    public static Date stringToDate(String s) throws ParseException {
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
        Date date = formatter1.parse(s);
        return date;
    }

    public static double calculateRow2(List<RowObj> rowObjList) {
        double sum = 0;
        for (RowObj r : rowObjList) {
            sum = sum + r.col2;
        }
        return sum;
    }

    public static double calculateRow5(List<RowObj> rowObjList) {
        double sum = 0;
        for (RowObj r : rowObjList) {
            sum = sum + r.col5;
        }
        return sum;
    }

    public static double calculateAverage(double sum, int numOfDays) {
        return sum / numOfDays;
    }

    public static void printInfo(List<RowObj> list) {


        String start_date = list.get(0).date;
        String end_date = list.get(list.size() - 1).date;

        double sum1 = calculateRow2(list);
        double sum2 = calculateRow5(list);

        double average1 = calculateAverage(sum1, list.size());
        double average2 = calculateAverage(sum2, list.size());

        DecimalFormat df = new DecimalFormat("#.##");

        String info1 = "Net imbalances through the ALIZES service: " + start_date + " - " + end_date +
                " SUM: " + df.format(sum1) + " AVG: " + df.format(average1);

        String info2 = "Imbalances cashed out through sells at marginal price (kWh 25°C): " + start_date + " - " + end_date +
                " SUM: " + df.format(sum2) + " AVG: " + df.format(average2);

        System.out.println(info1);
        System.out.println(info2);
    }

}
