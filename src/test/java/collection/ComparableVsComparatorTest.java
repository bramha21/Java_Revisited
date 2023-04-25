package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComparableVsComparatorTest {

    @Test
    public void testComparable() {
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee(10, "Ashok", "HR"));
        listOfEmployees.add(new Employee(50, "Krishna", "DEV"));
        listOfEmployees.add(new Employee(80, "Vishal", "DEV"));
        listOfEmployees.add(new Employee(30, "Amit", "MANAGER"));
        listOfEmployees.add(new Employee(20, "Rahul", "HR"));

        List<Integer> expectedEmpIdList = List.of(10,20,30,50,80);

        List<Integer> empIdList = listOfEmployees.stream().map(Employee::getEmpId).collect(Collectors.toList());
        Collections.sort(listOfEmployees);
        List<Integer> empIdListAfterSort = listOfEmployees.stream().map(Employee::getEmpId).collect(Collectors.toList());
        Assertions.assertNotEquals(empIdList,empIdListAfterSort);
        Assertions.assertEquals(expectedEmpIdList, empIdListAfterSort);
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

        List<Student> expectedListAfterNameSorting = new ArrayList<>();
        expectedListAfterNameSorting.add(new Student(5, "Abhijit", 15));
        expectedListAfterNameSorting.add(new Student(4, "Atul", 14));
        expectedListAfterNameSorting.add(new Student(30, "Jagdish", 13));
        expectedListAfterNameSorting.add(new Student(1, "Jaywant", 17));
        expectedListAfterNameSorting.add(new Student(21, "Kiran", 14));
        expectedListAfterNameSorting.add(new Student(9, "Nishant", 16));
        expectedListAfterNameSorting.add(new Student(12, "Suraj", 15));

        List<Student> expectedListAfterRollNoSorting = new ArrayList<>();
        expectedListAfterRollNoSorting.add(new Student(1, "Jaywant", 17));
        expectedListAfterRollNoSorting.add(new Student(4, "Atul", 14));
        expectedListAfterRollNoSorting.add(new Student(5, "Abhijit", 15));
        expectedListAfterRollNoSorting.add(new Student(9, "Nishant", 16));
        expectedListAfterRollNoSorting.add(new Student(12, "Suraj", 15));
        expectedListAfterRollNoSorting.add(new Student(21, "Kiran", 14));
        expectedListAfterRollNoSorting.add(new Student(30, "Jagdish", 13));

        List<Student> originalStudentList = new ArrayList<>(listOfStudents);

//        Collections.sort(listOfStudents, new NameComparator());
        listOfStudents.sort(new NameComparator());
        Assertions.assertNotEquals(originalStudentList, listOfStudents);
        Assertions.assertEquals(expectedListAfterNameSorting, listOfStudents);

//        Collections.sort(listOfStudents, new RollNoComparator());
        listOfStudents.sort(new RollNoComparator());
        Assertions.assertNotEquals(originalStudentList, listOfStudents);
        Assertions.assertEquals(expectedListAfterRollNoSorting, listOfStudents);
    }
}
