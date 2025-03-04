package Core.Lession1.HW4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Core.Lession1.HW4.Education.HIGHER;


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Stream<Person> streamAge = persons.stream();
        long personAge = streamAge.filter(person -> person.getAge() > 18).
                count();
        System.out.println("Количество совершенолетних " + personAge);


        Stream<Person> streamMen = persons.stream();
        List<String> listMen = streamMen.filter(person -> person.getAge() > 18).filter(person -> person.getSex() == Sex.MEN)
                .map(person -> person.getName() + person.getFamily()).collect(Collectors.toList());
        System.out.println(listMen);

        Stream<Person> worker = persons.stream();
        List<Person> listWorker = worker.filter(person -> person.getAge() > 16 && person.getAge() < 65)
                .filter(person -> person.getEducation() == HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(listWorker);


    }
}
