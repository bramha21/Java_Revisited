package collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableVsComparatorTest {

    @Test
    public void testComparable() {
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee(10, "Ashok", "HR"));
        listOfEmployees.add(new Employee(50, "Krishna", "DEV"));
        listOfEmployees.add(new Employee(80, "Vishal", "DEV"));
        listOfEmployees.add(new Employee(30, "Amit", "MANAGER"));
        listOfEmployees.add(new Employee(20, "Rahul", "HR"));

        System.out.println(listOfEmployees);
        Collections.sort(listOfEmployees);
        System.out.println(listOfEmployees);
        System.out.println("==== Comparable Testing Completed ==========");
    }

    @Test
    public void testComparator() {
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student(5, "Abhijit", 15));
        listOfStudents.add(new Student(1, "Jaywant", 17));
        listOfStudents.add(new Student(21, "Kiran", 14));
        listOfStudents.add(new Student(30, "Jagdish", 13));
        listOfStudents.add(new Student(12, "Suraj", 15));
        listOfStudents.add(new Student(9, "Nishant", 16));
        listOfStudents.add(new Student(4, "Atul", 14));

        System.out.println(listOfStudents);
//        Collections.sort(listOfStudents, new NameComparator());
        listOfStudents.sort(new NameComparator());
        System.out.println(listOfStudents);
//        Collections.sort(listOfStudents, new RollNoComparator());
        listOfStudents.sort(new RollNoComparator());
        System.out.println(listOfStudents);
        System.out.println("==== Comparator Testing Completed ==========");
    }
}
