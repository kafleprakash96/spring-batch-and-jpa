package com.example.springbatchdemo.utils;

import com.example.springbatchdemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {

    private static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);
    @Override
    public Person process(Person person) throws Exception {
        logger.info("Processing person info. Converting to Upper Case");
        if(person != null){
            logger.info("Successfully fetched person info");
            String firstName = convertToUpperCase(person.getFirstName());
            String lastName = convertToUpperCase(person.getLastName());
            return new Person(firstName,lastName);
        }else{
            logger.info("Data not found in input file");
        }
        return null;
    }

    public String convertToUpperCase(String name){
        return name.toUpperCase();
    }
}
