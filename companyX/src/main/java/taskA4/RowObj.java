package taskA4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RowObj {
    String date;
    double col2;
    double col5;


    public RowObj(String date, double col2, double col5) {
        this.date = date;
        this.col2 = col2;
        this.col5 = col5;
    }

    @Override
    public String toString() {
        return "RowObjUnfiltered{" +
                "date='" + date + '\'' +
                ", col2='" + col2 + '\'' +
                ", col5='" + col5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowObj rowObj = (RowObj) o;
        return Double.compare(rowObj.col2, col2) == 0 &&
                Double.compare(rowObj.col5, col5) == 0 &&
                Objects.equals(date, rowObj.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, col2, col5);
    }

    public static RowObj convert(RowObjUnfiltered rowObjUnfiltered) {
        RowObj result = new RowObj("", 0, 0);
        try {
            String d = rowObjUnfiltered.date;

            double r2 = Double.valueOf(rowObjUnfiltered.col2);
            double r5 = Double.valueOf(rowObjUnfiltered.col5);
            result = new RowObj(d, r2, r5);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static List<RowObj> createList(List<RowObjUnfiltered> rowObjUnfilteredList)  {
        List<RowObj> rowObjList = new ArrayList<>();
        for (RowObjUnfiltered r : rowObjUnfilteredList) {
            rowObjList.add(convert(r));
        }


        return rowObjList;
    }
}
