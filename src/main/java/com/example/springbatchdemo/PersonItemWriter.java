package com.example.springbatchdemo;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.List;

public class PersonItemWriter implements ItemWriter<Person> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void write(Chunk<? extends Person> chunk) throws Exception {

        List<? extends Person> personList = chunk.getItems();
        System.out.println(personList);

        personRepository.saveAll(personList);

    }
}
