package com.example.springbatchdemo;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {
    @Override
    public Person process(Person person) throws Exception {

        String firstName = person.getFirstName().toUpperCase();
        String lastName = person.getLastName().toUpperCase();

        Person updatedPerson = new Person(firstName,lastName);
        System.out.println("Converting <<< " + person + " >>> to uppercase " + updatedPerson );

        return updatedPerson;
    }
}
