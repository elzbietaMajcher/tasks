package taskA4;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TaskA4Test {

    @Test
    public void calculateRow2Test() {
        RowObj obj = new RowObj("16.10.2017", 22.2, 333.0);
        RowObj obj2 = new RowObj("16.10.2017", 20.2, 300.0);
        List<RowObj> list = new ArrayList<>();
        list.add(obj);
        list.add(obj2);

        double expected = 42.4d;
        double result = TaskA4.calculateRow2(list);

        Assert.assertEquals(expected, result, 0);

    }

    @Test
    public void calculateAverageTest() {
        RowObj obj = new RowObj("16.10.2017", 22.2, 333.0);
        RowObj obj2 = new RowObj("16.10.2017", 20.2, 300.0);
        RowObj obj3 = new RowObj("16.10.2017", 20.0, 300.0);
        List<RowObj> list = new ArrayList<>();
        list.add(obj);
        list.add(obj2);
        list.add(obj3);
        double expected = 20.8d;
        double sum = TaskA4.calculateRow2(list);

        double result = TaskA4.calculateAverage(sum, list.size());

        Assert.assertEquals(expected, result, 0);
    }

    @Test
    public void printResult () throws ParseException, InvalidFormatException, IOException {
        List<RowObjUnfiltered> unfiltredList = TaskA4.create(); // data are not the same
        for (RowObjUnfiltered r : unfiltredList
        ) {
            System.out.println(r);
        }

        List<RowObj> list = RowObj.createList(unfiltredList);
        for (RowObj r : list
        ) {
            System.out.println(r);
        }
        TaskA4.printInfo(list);

    }
}