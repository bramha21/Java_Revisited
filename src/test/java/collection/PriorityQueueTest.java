package collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    @Test
    public void testPriorityQueueWithString() {
        //By default its min heap
        PriorityQueue<String> p = new PriorityQueue<>();
        p.add("A");
        p.add("H");
        p.add("Z");
        p.add("Y");
        p.add("E");
        p.add("C");

        System.out.println(p);

        //Changed it to max heap
        PriorityQueue<String> p1 = new PriorityQueue<>(Comparator.reverseOrder());
        p1.add("A");
        p1.add("H");
        p1.add("Z");
        p1.add("Y");
        p1.add("E");
        p1.add("C");

        System.out.println(p1);
    }


    @Test
    public void testPriorityQueueWithEmployee() {
        //this is natural order
        PriorityQueue<Employee> empQueueDefaultOrder = new PriorityQueue<>();
        empQueueDefaultOrder.add(new Employee(10, "Ashok", "HR"));
        empQueueDefaultOrder.add(new Employee(50, "Krishna", "DEV"));
        empQueueDefaultOrder.add(new Employee(80, "Vishal", "DEV"));
        empQueueDefaultOrder.add(new Employee(30, "Amit", "MANAGER"));
        empQueueDefaultOrder.add(new Employee(20, "Rahul", "HR"));
        System.out.println(empQueueDefaultOrder);

        //reverse the natural order
        PriorityQueue<Employee> empQueueReverseOrder = new PriorityQueue<>(Comparator.reverseOrder());
        empQueueReverseOrder.add(new Employee(10, "Ashok", "HR"));
        empQueueReverseOrder.add(new Employee(50, "Krishna", "DEV"));
        empQueueReverseOrder.add(new Employee(80, "Vishal", "DEV"));
        empQueueReverseOrder.add(new Employee(30, "Amit", "MANAGER"));
        empQueueReverseOrder.add(new Employee(20, "Rahul", "HR"));
        System.out.println(empQueueReverseOrder);

        //Provided custom comparator for priority calculation
//        PriorityQueue<Employee> empQueueCustomOrder = new PriorityQueue<>((x,y)-> x.getEmpName().compareTo(y.getEmpName()));
        PriorityQueue<Employee> empQueueCustomOrder = new PriorityQueue<>(Comparator.comparing(Employee::getEmpName));
        empQueueCustomOrder.add(new Employee(10, "Ashok", "HR"));
        empQueueCustomOrder.add(new Employee(50, "Krishna", "DEV"));
        empQueueCustomOrder.add(new Employee(80, "Vishal", "DEV"));
        empQueueCustomOrder.add(new Employee(30, "Amit", "MANAGER"));
        empQueueCustomOrder.add(new Employee(20, "Rahul", "HR"));

        System.out.println(empQueueCustomOrder);
    }
}
