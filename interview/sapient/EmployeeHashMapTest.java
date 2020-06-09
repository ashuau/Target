package interview.sapient;


import java.util.HashMap;
import java.util.Map;

class Employee {

    private int id;
    private String name;
    private int age;

    Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        return true;
    }

    public String toString() {
        return this.id + "#" + this.name;
    }
}
public class EmployeeHashMapTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,"prem",25);
        Employee e2 = new Employee(2,"Alok",30);
        Employee e3 = new Employee(3,"Chandan",30);

        Map <Employee,String> map = new HashMap<>();
        map.put(e1,"1");
        map.put(e2,"2");
        map.put(e3,"3");

        System.out.println(map.size());
        System.out.println(map);
    }
}
