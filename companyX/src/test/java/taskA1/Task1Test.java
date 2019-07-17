package taskA1;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Task1Test {

    Path path = Paths.get("src/main/resources/task_A1.html");
    Charset charset = Charset.forName("UTF-8");


//    @Test
//    public void readFileHasAmountOfLines() throws IOException {
//        List<String> input = Task1.readFile(path, charset);
//        long numOfLines = 3;
//        //System.out.println(input);
//        Assert.assertEquals(numOfLines, input.size());
//    }

//    @Test
//    public void onlyValid3() throws IOException {
//        List<String> input = Task1.readFile(path, charset);
////      input.forEach(System.out::println);
//        List<InputData> collect = input
//                .stream()
//                .map(InputData::fromTextToParsed)
//                .filter(i -> i != null)
//                .collect(Collectors.toList());
////        System.out.println(collect.size());
////        collect.forEach(System.out::println);
//    }

    @Test
    public void onlyValid3() throws IOException {
        List<String> input = Task1.readFile(path, charset);
        List<InputData> result = Task1.getOnlyValid(input);
        long numOfLines = 3;
        //System.out.println(input);
        Assert.assertEquals(numOfLines, input.size());

    }

    @Test
    public void validOutput() throws IOException {
        List<String> input = Task1.readFile(path, charset);
        List<InputData> result = Task1.getOnlyValid(input);
        Task1.printFormated(result);

    }
}
