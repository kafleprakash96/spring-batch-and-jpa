package com.example.springbatchdemo.repo;

import com.example.springbatchdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
