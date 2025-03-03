//import java.util.;
import java.util.Arrays;
//import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.IntStream;
class Emp{
    int age;
    int salary;
    String deartment;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDeartment() {
        return deartment;
    }

    public void setDeartment(String deartment) {
        this.deartment = deartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class streamClass {
    public static void main(String args[]) {
        int[] age = {1, 2, 4, 5};
//        Integer[] A={1,23,3};
        Integer[] ages=Arrays.stream(age).boxed().toArray(Integer[]::new);
        Arrays.sort(ages, Collections.reverseOrder());
        System.out.println(ages[0]);
        Arrays.stream(age).boxed().sorted((a,b)->Integer.compare(b,a))
                .limit(2).mapToInt(Integer::intValue).forEach(System.out::println);

    }
}