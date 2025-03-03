package FunctionInterface;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface DataSample{
    public void message(String Message);
}



class functionClaass{

    public static void main(String args[]){

        DataSample dataSample= messData -> System.out.println("message is working" + messData);
        dataSample.message("data");


        List<String> words = Arrays.asList("apple", "banana", "apple", "apple", "orange");
        Map<String,Long> data= words.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        data.entrySet().stream().forEach(e-> System.out.println("edat " + e.getKey() +" count is "+ e.getValue()));
    }
}
