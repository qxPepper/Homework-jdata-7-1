package ru.netology.homeworkjdata71.service;

import org.springframework.stereotype.Service;
import ru.netology.homeworkjdata71.entity.Persons;
import ru.netology.homeworkjdata71.repository.MyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {
    private final MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Persons> getPersonsByCity(String city) {
        return myRepository.getPersonsByCity(city);
    }

    public List<Persons> getPersonsByAge(Integer age) {
        return myRepository.getPersonsByAge(age);
    }

    public Optional<Persons> getPersonsByNameSurname(String name, String surname) {
        return myRepository.getPersonsByNameSurname(name, surname);
    }

    public Optional<Persons> getPersonsByUsername(String name) {
        return myRepository.getPersonsByUsername(name);
    }
}
