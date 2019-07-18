package taskA1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    Path path = Paths.get("src/main/resources/task_A1.html");
    Charset charset = Charset.forName("UTF-8");


    public static List<String> readFile(Path path, Charset charset) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(path, charset);
        String line;
        while ((line = reader.readLine()) != null) {
            String words[] = line.split(" ");
            if (words.length > 4 && words[4].equals("<tr")) {
                lines.add(line);
//                System.out.println(line.toString());
            }
        }
        return lines;
    }

    public static List<InputData> getOnlyValid(List<String> input) {
        return input
                .stream()
                .map(InputData::fromTextToParsed)
                .filter(i -> i != null)
                .collect(Collectors.toList());
    }

    public static void printFormatted(List<InputData> result) {
        result
                .stream()
                .map(InputData::toStringFormatted)
                .forEach(System.out::println);
    }
}
