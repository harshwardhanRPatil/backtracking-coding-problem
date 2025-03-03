package Core_Java;


import org.w3c.dom.css.Counter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class A{
    void demo(){
        System.out.println("A.1");
    }
    void demo2(){
        System.out.println("A.2");
    }
}
class B extends A{
    @Override
    void demo(){
        System.out.println("B.1");
    }
    @Override
    void demo2(){
        System.out.println("B.2");
    }
    void demo3(){
        System.out.println("A.3");
    }
}
class ClassConcept {

    public static void main(String args[]) {
     String s="harshwardhan is good in sport, is also good in acadamic";

        Map<String, Long> data=Arrays.stream(s.split("\\s")).collect(Collectors.groupingBy(s1 -> s1, Collectors.counting()));
        data.entrySet().stream().forEach(e-> System.out.println(e.getKey() +"=" +e.getValue()));

    }
}