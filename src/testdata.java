import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class testdata {

    public static void main(String args[]) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "apricot", "kiwi");
        Map<Integer, List<String>> groupedWords =words.stream().collect(Collectors.groupingBy(word->word.length()));
        System.out.println("data we got");
        groupedWords.forEach((firstnamee,count)-> System.out.println(firstnamee+ " "+ count));
        String prefix = "ap";

        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith(prefix)).filter(word->!word.contains("p")).map(word->word.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Words with prefix '" + prefix + "': " + filteredWords);
    }

    public static List<String> filterByPrefix(List<String> words, String prefix) {
        return words.stream()
                .filter(word -> word.startsWith(prefix)).filter(word->!word.contains("p")).map(word->word.toUpperCase())
                .collect(Collectors.toList());
    }
}
