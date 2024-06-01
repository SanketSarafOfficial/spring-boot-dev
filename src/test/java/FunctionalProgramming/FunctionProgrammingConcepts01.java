package FunctionalProgramming;

import org.springframework.util.StopWatch;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FunctionProgrammingConcepts01 {

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        // Write down your methods here
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
        printAllNumbersInList(List.of(11,12,13,14,15,16,17,18,19,20));
        printVarietyOfCourses(courses);

        // Write down your methods Above
        stopwatch.stop();
        long timeTaken = stopwatch.getTotalTimeMillis();
        System.out.println("Time Taken to be finish  = "+timeTaken+" ms");
    }

    public static void print(int numbers){
        System.out.println(numbers);
    }

    public static void printAllNumbersInList(List<Integer> numbers) {
        //structural approach

//        for(int ele : numbers){
//            System.out.println(ele);
//        }

        //method reference
//        numbers.forEach(System.out::println);

        //Understandable way of method reference
//        numbers.forEach(FunctionProgrammingConcepts01::print);

        //even numbers
//        numbers.stream().filter(ele-> ele % 2 ==0)
//                .forEach(System.out::println);

        //Odd Numbers

//        numbers.stream().filter(ele -> ele % 2 == 1)
//                .forEach(System.out::println);

        //squares of Even numbers

//        numbers.stream().filter(ele -> ele % 2 == 0)
//                .map(ele -> ele * ele)
//                .forEach(System.out::println);

        //squares of Even numbers using Math.pow

//        numbers.stream().filter(ele -> ele % 2 == 0)
//                .map(ele ->Math.pow(ele,2))
//                .forEach(System.out::println);

        // cube of odd number

//        numbers.stream().filter(ele -> ele % 2 != 0)
//                .map(ele -> ele * ele * ele)
//                .forEach(System.out::println);
    }

    public static void printVarietyOfCourses(List<String> courses){
        //print each course
//        courses.forEach(System.out::println);

        //print course containing word spring
//        courses.stream().filter(ele -> ele.contains("Spring"))
////                .forEach(System.out::println);

        //print courses which name has atleast 4 letters

//        courses.stream().filter(ele -> ele.length() <=4)
//                .forEach(System.out::println);

        // length of the courses

//        courses.forEach(ele-> System.out.println("course name is "+ele + " The course Length is "+ele.length()));

        //length of course using map

        courses.stream().map(String::length)
                .forEach(System.out::println);

    }
}
