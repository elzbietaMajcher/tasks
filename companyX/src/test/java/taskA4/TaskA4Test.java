package taskA4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskA4Test {

    @Test
    public void calculateRow2() {
        RowObj obj = new RowObj("16.10.2017", 22.2, 333.0);
        RowObj obj2 = new RowObj("16.10.2017", 20.2, 300.0);
        List<RowObj> list = new ArrayList<>();
        list.add(obj);
        list.add(obj2);

        double expected = 42.4d;
        double result = TaskA4.calculateRow2(list);

        Assert.assertEquals(expected,result,0);

    }

    @Test
    public void calculateAverage() {
    }
}