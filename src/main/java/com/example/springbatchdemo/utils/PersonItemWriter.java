package com.example.springbatchdemo.utils;

import com.example.springbatchdemo.repo.PersonRepository;
import com.example.springbatchdemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonItemWriter implements ItemWriter<Person> {

    private static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public void write(Chunk<? extends Person> chunk) throws Exception {

        List<? extends Person> personList = chunk.getItems();

        logger.info("Starting to save {} person record to the database.", personList.size());

        personList.forEach( person -> {
            logger.info("Preparing to save person record:{} {}. ", person.getFirstName(),person.getLastName());
                }
        );

        personRepository.saveAll(personList);

        logger.info("Successfully saved updated info database");


    }
}
