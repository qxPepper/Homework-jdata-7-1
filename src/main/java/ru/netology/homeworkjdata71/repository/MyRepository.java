package ru.netology.homeworkjdata71.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.netology.homeworkjdata71.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public class MyRepository {
    @Autowired
    private PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return personRepository.findMyCity(city);
    }

    public List<Persons> getPersonsByAge(Integer age) {
        return personRepository.findMyAge(age);
    }

    public Optional<Persons> getPersonsByNameSurname(String name, String surname) {
        return personRepository.findMyNameSurname(name, surname);
    }

    public Optional<Persons> getPersonsByUsername(String name) {
        return personRepository.findMyUsername(name);
    }
}
