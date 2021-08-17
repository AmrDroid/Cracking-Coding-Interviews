package amazon;

import java.util.*;

public class SortingWithEmployeObjects {

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<>();

        emps.add(new Employee(2001, "Modi", 55));
        emps.add(new Employee(1901, "Trumph", 57));
        emps.add(new Employee(1950, "Boris Johnson", 56));

        System.out.println("Before sorting custom list of employees : ");
        Iterator<Employee> it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Collections.sort(emps);

        System.out.println("After sorting custom list of employees in natural order: ");
        it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Collections.sort(emps, Collections.reverseOrder());

        System.out.println("After sorting custom list of employees in decendng order: ");
        it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
}



 static class Employee implements Comparable<Employee> {

     private int id;
     private String name;
     private int age;

     public Employee(int id, String name, int age) {
         super();
         this.id = id;
         this.name = name;
         this.age = age;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

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

     @Override
     public int compareTo(Employee o) {

         if (o.getId() > this.getId()) {
             return 1;
         } else if (o.getId() < this.getId()) {
             return -1;
         }

         return 0;

     }

     @Override
     public String toString() {
         return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
     }

 }}
