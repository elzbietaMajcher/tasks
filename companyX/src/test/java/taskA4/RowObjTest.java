package taskA4;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RowObjTest {

    RowObjUnfiltered actual = new RowObjUnfiltered("15.10.2017", "22.2", "333.0");
    RowObjUnfiltered actual1 = new RowObjUnfiltered("16.10.2017", "20.2", "300.0");

    @Test
    public void convert() throws ParseException {
        String date = "15.10.2017";

        RowObj expected = new RowObj(date, 22.2, 333.0);
        RowObj result = RowObj.convert(actual);

        System.out.println(expected.toString());
        System.out.println(result.toString());

        assert expected.equals(result);
    }


    @Test
    public void createList() throws ParseException {
        List<RowObjUnfiltered> actualList = new ArrayList<>();
        actualList.add(actual);
        actualList.add(actual1);

        RowObj expected = new RowObj("15.10.2017", 22.2, 333.0);
        RowObj expected2 = new RowObj("16.10.2017", 20.2, 300.0);
        List<RowObj> expectedList = new ArrayList<>();
        expectedList.add(expected);
        expectedList.add(expected2);

        List<RowObj> resultList = RowObj.createList(actualList);

        for (RowObj r: expectedList) {
            System.out.println(r);
        }

        for (RowObj r: resultList) {
            System.out.println(r);
        }

        assert expectedList.get(1).equals(resultList.get(1));
        assert expectedList.size() == resultList.size();
    }
}
