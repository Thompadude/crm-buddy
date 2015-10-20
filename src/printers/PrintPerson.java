package printers;

import persons.Person;

public class PrintPerson {

    public <T extends Person> void printName(T person) {
        System.out.println("Name: " + person.getName());
    }

    public <T extends Person> void printBirthday(T person) {
        System.out.println("Birthday: " + person.getBirthday());
    }

// TODO fixa print för family.

}