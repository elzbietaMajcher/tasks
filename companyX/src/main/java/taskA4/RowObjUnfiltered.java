package taskA4;

public class RowObjUnfiltered {
    String date;
    String col2;
    String col5;


    public RowObjUnfiltered(String date, String col2, String col5) {
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
}
