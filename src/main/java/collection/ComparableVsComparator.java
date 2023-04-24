package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableVsComparator {

}

class Employee implements Comparable<Employee> {
    private int empId;
    private String empName;
    private String department;

    public Employee(int empId, String empName, String department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + empId + "_"+ empName +"_"+ department + "}";
    }

    @Override
    public int compareTo(Employee o) {
        //normal way
        /*if (empId == o.getEmpId())
            return 0;
        else if (empId > o.getEmpId())
            return 1;
        else
            return -1;*/

        return Integer.compare(empId, o.getEmpId());
    }
}

record Student (int rollNo, String name, int age) {
    @Override
    public String toString() {
        return "Student{" + rollNo +
                "_" + name +
                "_" + age +
                '}';
    }
}

class RollNoComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        //Normal way
        /*if(o1.rollNo() == o2.rollNo())
            return 0;
        else if (o1.rollNo() > o2.rollNo())
            return 1;
        else
            return -1;*/

        return Integer.compare(o1.rollNo(), o2.rollNo());
    }
}

class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name().compareTo(o2.name());
    }
}