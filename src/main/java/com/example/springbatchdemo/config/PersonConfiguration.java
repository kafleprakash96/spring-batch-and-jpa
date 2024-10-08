package com.example.springbatchdemo.config;

import com.example.springbatchdemo.utils.JobCompletionNotification;
import com.example.springbatchdemo.utils.PersonItemProcessor;
import com.example.springbatchdemo.utils.PersonItemWriter;
import com.example.springbatchdemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PersonConfiguration {

    @Autowired
    JobCompletionNotification listener;

    @Bean
    public FlatFileItemReader<Person> reader(){
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("person-data.csv"))
                .delimited()
                .names("firstName","lastName")
                .targetType(Person.class)
                .build();
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public PersonItemWriter writer(){
        return new PersonItemWriter();
    }

    @Bean
    public Job importPersonJob(JobRepository jobRepository,
                               Step step1){
        return new JobBuilder("importPersonJob",jobRepository)
                .start(step1)
                .listener(listener)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Person> reader,
                      PersonItemProcessor processor,
                      PersonItemWriter writer){
        return new StepBuilder("step1",jobRepository)
                .<Person,Person> chunk(5,transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
