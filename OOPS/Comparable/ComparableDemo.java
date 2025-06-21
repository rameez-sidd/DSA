package OOPS.Comparable;

import java.util.Arrays;

class Student implements Comparable<Student>{
    int rollno;
    float marks;

    public Student(int rollno, float marks){
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o){
        int diff = (int)(this.marks - o.marks);

        // if diff == 0 : both are equal
        // if diff < 0 : o is bigger else o is smaller

        return diff;
    }
    
    @Override
    public String toString(){
        return marks + "";
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        Student kunal = new Student(12, 89.76f);
        Student rahul = new Student(5, 99.52f);
        Student arpit = new Student(2, 95.68f);
        Student karan = new Student(13, 77.09f);
        Student sachin = new Student(9, 96.23f);


        // This will not work as the compiler does not know how to compare objects directly what to compare
        // if(kunal < rahul){
        //     System.out.println("Rahul has more marks than Kunal");
        // }


        // This is one use case
        if(kunal.compareTo(rahul) < 0){
            System.out.println("Rahul has more marks than Kunal");
        }

        Student[] list = {kunal, rahul, arpit, karan, sachin};
        System.out.println(Arrays.toString(list));


        // This is another use case, it will sort the students list based on the compareTo() method provided
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
    }
}
