//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
import java.util.stream.Collectors;



class Employ {
    public String name;
    public int age;
    public int salary;

    Employ(String name, int age,int salary) {
        this.age = age;
        this.name = name;
        this.salary=salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public int getSalary(){
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> we = new ArrayList<>();
        List<Integer> non_dublicate = Arrays.asList(1, 324, 4, 3, 2, 54, 6);
        Optional<Integer> asn= non_dublicate.stream().filter(x->x>2).min(Comparator.naturalOrder());
        System.out.println("we have it asn ::"+asn.get());


        // on string
        List<String> fruit=Arrays.asList("apple","mango","orange","graph");
        fruit.stream().map(String::toUpperCase).filter(x->x.length()>4).map(x->x.substring(0,1)+"2"+x.substring(2)).forEach(s-> System.out.println("data after all opration ::"+s));
fruit.stream().map(String::toUpperCase).filter(x->x.length()>2).map(x->x.substring(0,1)+"2"+x.substring(2)).forEach(s-> System.out.println("data after retry "+s));

//        List<Integer> noi=non_dublicate.stream().filter(num->num%2==0).map(num->num*num).collect(Collectors.toList());
        List<Integer> noi = non_dublicate.stream().map(num -> {
                    if (num % 2 != 0) {
                        num*=num;
                    }
                    return num;
                }
        ).collect(Collectors.toList());
        Employ e1 = new Employ("harsh", 23,13231);
        Employ e3 = new Employ("harsh", 3,3453453);
        Employ e2 = new Employ("ha", 21,46456);
        Employ e4 = new Employ("ha", 211,464);
        List<Employ> employsList = Arrays.asList(e1, e2, e3,e4);

        employsList.stream().filter(e -> e.getAge()>20).sorted(Comparator.comparing(Employ::getAge)).forEach(e -> System.out.println(e.getName()));
        employsList.stream().sorted(Comparator.comparing(Employ::getAge).thenComparing(Employ::getName)).forEach(e-> System.out.println(STR."name \{e.getName()} :: age \{e.getAge()}"));
//        this for sorting for age then name
//        List<Employ> employs = employsList.stream().sorted(Comparator.comparing(Employ::getAge).reversed().thenComparing(Employ::getName)).collect(Collectors.toList());

        // find the average age and the total salary of people older than 30.
        OptionalDouble avg= employsList.stream().filter(employ -> employ.getAge()>21).mapToInt(Employ::getSalary).average();
//        Map<String, Long> productCountByCategory= employsList.stream().collect(Collectors.groupingBy(Employ::getName,Collectors.counting()));

        Map<String, Double> averageSalaryByName = employsList.stream()
                .filter(emp -> emp.getSalary() > 1000) // Filter by salary greater than 1000
                .collect(Collectors.groupingBy(Employ::getName, Collectors.averagingDouble(Employ::getSalary))) // Group by name and calculate the average salary
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1000) // Filter only those having average salary greater than 1000
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // Collect into a map

        Map<String, Double> averageSalaryByName1= employsList.stream()
                .collect(Collectors.groupingBy(Employ::getName,Collectors.averagingDouble(Employ::getSalary)))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        employsList.stream()
                .filter(emp->emp.getSalary()>1000)
                .collect(Collectors.groupingBy(Employ::getName,Collectors.averagingDouble(Employ::getSalary)))
                .forEach((name, salary) -> System.out.println("Name: " + name + ", Average Salary: " + salary));

        System.out.println(averageSalaryByName);
        averageSalaryByName.forEach((name ,age)-> System.out.println("name of the persone "+name +" and age is "+age));
        System.out.println(noi);

        String test ="it is my interview for today what i have lerar will reflect here";
        Map<String,Long>Test_array =Arrays.stream(test.split("\\s+")).map(String::toLowerCase).collect(Collectors.groupingBy(w->w,Collectors.counting()));
        Test_array.entrySet().stream().sorted((entry1,entry2)->entry2.getValue().compareTo(entry1.getValue())).limit(2).forEach(entry->System.out.println(entry));

//        Test_array.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).limit(2).forEach(entry -> System.out.println(entry));
    }
}