package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws InterruptedException {


        class Person {
            private String name;
            private double  salary;
            private String gender;

            public Person(String name, int salary, String gender) {
                this.name = name;
                this.salary = salary;
                this.gender = gender;
            }

            public String getName() {
                return name;
            }

            public double getSalary() {
                return salary;
            }

            public String getGender() {
                return gender;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", salary=" + salary +
                        ", gender='" + gender + '\'' +
                        '}';
            }
        }

        // lista med 10 anställda

        List<Person> persons = List.of(
                new Person("Jovan",30000,"Male"),
                new Person("Nills",90,"Male"),
                new Person("Sara",2500,"Male"),
                new Person("Gunnar",4000,"Female"),
                new Person("Olivia",500,"Female"),
                new Person("Jesper",5000,"Male"),
                new Person("Karin",1000,"Female"),
                new Person("Daniel", 50,"Male"),
                new Person("Simona",3000,"Female"),
                new Person("Samuel", 150,"Male")
        );

        //  lista av snitt lönen hos både män och kvinnor

        Map<String, Double> averagePersonSalary = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getGender,Collectors.averagingDouble(pr -> pr.getSalary())));
        System.out.println(averagePersonSalary);


        // Kollar i listan vilken person som har högst lön

        persons
                .stream()
                .max(Comparator.comparing(Person::getSalary))
                .ifPresent(System.out::println);

        // Kollar i listan vilken person har lägst lön

        persons
                .stream()
                .min(Comparator.comparing(Person::getSalary))
                .ifPresent(System.out::println);



        // Bilfabrik med Factory Pattern


        // Expensive Car Audi

        CarFactory carFactory = new CarFactory();

        Car expensiveCar = carFactory.createCar(CarType.EXPENSIVE);

        expensiveCar.makeNoise();

      // Comfort Car Bmw

        CarFactory carFactory2 =  new CarFactory();

        Car comfortCar = carFactory2.createCar(CarType.COMFORT);

        comfortCar.makeNoise();

     // Electric Car MiniCooper

        CarFactory carFactory3 = new CarFactory();

        Car electricCar = carFactory3.createCar(CarType.ELECTRIC);

        electricCar.makeNoise();

        // Swedish Car Volvo

        CarFactory carFactory4 = new CarFactory();

        Car swedishCar = carFactory4.createCar(CarType.SWEDISH);

        swedishCar.makeNoise();




        // Uppgift 3 labboration: Skapa Lista med ord och plocka ut reguljära uttryck a, e, i, o, u, y

        Pattern pattern1 = Pattern.compile("[aeiouy].*[aeiouy]");

      List.of("alright","sten","docka","aye","yxa")
              .stream()
              .filter(word -> pattern1.matcher(word).find())
              .forEach(System.out::println);





        // Uppgift 4: Hitta primtal med hjälp av threads



        class PrimeNumberChecker implements Runnable {
            int start;
            int end;



            public PrimeNumberChecker(int start, int end) {
                this.start = start;
                this.end = end;



            }

            @Override
            public void run() {

                for (int p = start; p < end; p++) {
                   boolean primeCheck = true;

                    int count = 2;
                    while (count <= p / 2) {



                        if (p % count == 0) {
                           primeCheck = false;
                            break;
                        }
                        count ++;


                    }
                    if (primeCheck ){
                        System.out.println(p);
                    }

                }

            }
        }

        // Primtal mellan 0 - 350000  & 350000 - 500000

        Thread thread1 = new Thread( new PrimeNumberChecker(2,350000));
        Thread thread2 = new Thread(new PrimeNumberChecker(350001,500000));



       thread1.start();
       thread2.start();
       thread1.join();
       thread2.join();




    }
}
