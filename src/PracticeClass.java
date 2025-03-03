import javax.sound.sampled.EnumControl;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class A{
    public void display(){
        System.out.println("data is froom A");
    }

    public void display1(){
        System.out.println("data is froom A");
    }
}

class B extends A{
    public void display(){
        System.out.println("data is froom B");
    }
    public void display2(){
        System.out.println("data is froom B");
    }
}
class Person {
    public String name;
    public  int age;

    public List<String> getNumber() {
        return number;
    }

    public void setNumber(List<String> number) {
        this.number = number;
    }

    public List<String> number;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age, List<String> number) {
        this.name = name;
        this.age = age;
        this.number=number;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        Person person =(Person) obj;
        return age==person.age && name.equals(person.getName());
    }
}

public class PracticeClass {


    public static void main(String args[]){
        List<Integer> data_ages= new ArrayList<>(Arrays.asList(15,54,6,484,213));
        List<Integer> second_int_Data=new ArrayList<>();
        second_int_Data=Arrays.asList(54,49,34,6,42);

        second_int_Data.stream().mapToInt(Integer::intValue).sum();
        System.out.println(second_int_Data);
        List<Integer> result_data=List.of(data_ages,second_int_Data).stream().flatMap(List::stream)
                .distinct().sorted().collect(Collectors.toList());
        System.out.println("data is acesing :");
             result_data.stream().forEach(num-> System.out.print(num));

//   for class check
        A a= new B();
        a.display();

        List<Person> persons = Arrays.asList(
                new Person("Charlie", 25,Arrays.asList("123456890", "9876543210", "5678901234")),
                new Person("Bo1b", 30,Arrays.asList("123456890", "9876543210", "5678901234")),
                new Person("Charlie3", 20,Arrays.asList("124567890", "976543210", "5678901234")),
                new Person("bob", 230,Arrays.asList("123467890", "9876553210", "5678901234")),
                new Person("Bofb", 20,Arrays.asList("12345690", "9876543210", "5678901234")),
                new Person("s", 20,Arrays.asList("123456790", "9876543210", "5678901234")),
                new Person("Amanda", 240,Arrays.asList("1234567890", "9836543210", "5678901234"))
        );

//        Map<String, List<String>> numberToPersonsMap = persons.stream()
//                .flatMap(person -> person.getNumber().stream()
//                        .map(number -> Map.entry(number, person.getName()))) // Pair each number with the person's name
//                .collect(Collectors.groupingBy(
//                        Map.Entry::getKey,
//                        Collectors.mapping(Map.Entry::getValue,Collectors.toList())// Value: list of names sharing the number
//                ));
//        System.out.println(numberToPersonsMap);


        Map<String, List<String>> numberToPersonsMap = persons.stream().flatMap(person -> person.getNumber()
                .stream().map(number ->Map.entry(number,person.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.mapping(Map.Entry::getValue,Collectors.toList())));



        Map<String, List<String>> data_after_sort=   numberToPersonsMap.entrySet().stream().filter(entity->entity.getValue().size()>1)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

                data_after_sort.entrySet().stream().forEach(data-> System.out.println("data for sorting"+ data.getKey()));

        List<Integer> numbers = Arrays.asList(2, 4, 15, 3, 8, 12);
//        numbers.stream().filter(n->n>10).map(n->n*n).forEach(n->System.out.print(n + " "));
//        List<Integer> numbers = Arrays.asList(2, 4, 15, 3, 8, 12);
//        Optional<Integer> max_value= numbers.stream().max(Integer::compareTo).get().describeConstable();
//        List<Person> data_after_sort1= persons.stream().collect(Collectors.groupingBy(Person::getName)).entrySet().stream().flatMap(entity->entity.getValue().stream()).collect(Collectors.toList());
//        System.out.println(data_after_sort1);
            numbers.stream().filter(e->e%2==0).mapToInt(Integer::intValue).sum();




        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
            
        List<String> words = Arrays.asList("apple", "banana", "apple", "apple", "orange");
       Map<String,Long>data= words.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
data.entrySet().stream().forEach(e-> System.out.println("edat " + e.getKey() +" count is "+ e.getValue()));
//    persons.stream().sorted(Comparator.comparing(Person::getAge)).forEach(x-> System.out.println(x.getName()));
        persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).limit(2).forEach(x-> System.out.println(x.getName()));



        String dataChanger ="data is the main value that we gona use is";

        Map<String,Long> dataTransfer=Arrays.stream(dataChanger.split("\\s")).collect(Collectors.groupingBy(w->w,Collectors.counting()));

        dataTransfer.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).forEach(e-> System.out.println(e.getKey()+" data "+e.getValue()));
   /// map sorting

        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Banana");
        map.put(1, "Apple");
        map.put(2, "Cherry");

        // Sort by keys using stream
        LinkedHashMap<Integer, String> sortedByKey = map.entrySet()
                .stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())) // Sorting by key
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        
        System.out.println(sortedByKey);


    }
}
