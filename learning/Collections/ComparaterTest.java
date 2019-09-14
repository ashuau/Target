package learning.Collections;


import java.util.*;

class Student implements Comparable<Student> {

    private int rollno;
    private String name;
    private int marks;



    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public Student(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        /*if (this.name.equals(o.name)) {
            return this.id - o.marks;
        }*/
        return this.rollno - o.rollno;
    }

    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    //or
   // static Comparator<Student> nameComparator = Comparator.comparing(o  -> o.getName());


    static Comparator<Student> marksComparator = (o1,o2) -> {
        return o1.getMarks() - o2.getMarks(); // or use this /*Comparator.comparing(o -> o.marks);*/
    };

    /*static Comparator <Student> idcompator = (o1, o2) -> {
         if (o1.name.equals(o2.name)) {
        return o1.rollno - o2.rollno;
    }
        return o1.rollno - o2.rollno;
    };*/

    static Comparator <Student> marksAndRoll = Comparator.comparing(Student::getMarks).thenComparing(Student::getRollno).reversed();
}

// Using Comparator
class StudentComparatorByRollAndName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        if (o1.getName().compareTo(o2.getName()) == 0 )
        {
            return o1.getRollno() - o2.getRollno();
        }
        return o1.getName().compareTo(o2.getName());
    }

}



public class ComparaterTest {
    public static void main(String[] args) {

        Student [] sArray = new Student[4];
        sArray[0] = new Student(1,"Prem",100);
        sArray[1] = new Student(2,"Alok", 180);
        sArray[2] = new Student(3,"Chandan",150);
        sArray[3]= new Student(4,"Alok", 150);

        Arrays.sort(sArray);
        System.out.println("Default Sorting of Student list:\n"+Arrays.toString(sArray));

        // sorting using name

       /* Arrays.sort(sArray,Student.nameComparator);
        System.out.println("Student list sorted by name:\n"+Arrays.toString(sArray));

        // sorting by marks by reverse order
        Comparator c = Collections.reverseOrder(Student.marksComparator);
        Arrays.sort(sArray,c);
        System.out.println("Student list sorted by Marks:\n"+Arrays.toString(sArray));

        // sorting by name and then roll
        Arrays.sort(sArray, new StudentComparatorByRollAndName());

        System.out.println("Student list sorted by name and then roll:\n"+Arrays.toString(sArray));*/

        Arrays.sort(sArray,Student.marksAndRoll);
        System.out.println(Arrays.toString(sArray));

       /* List <Student> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);

        Collections.sort(sList, new StudentComparator());*/

        /*for (Student s : sArray) {

            System.out.println(s);
        }*/




    }
}
