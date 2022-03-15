package ru.netology.homeworkjdata71.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.homeworkjdata71.entity.Persons;
import ru.netology.homeworkjdata71.service.MyService;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @Secured("ROLE_READ")
    @GetMapping("/persons/by-name-surname")
    public Optional<Persons> getPersonsByNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return myService.getPersonsByNameSurname(name, surname);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/persons/by-age")
    public List<Persons> getPersonsByAge(@RequestParam(value = "age") Integer age) {
        return myService.getPersonsByAge(age);
    }

    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam(value = "city") String city) {
        return myService.getPersonsByCity(city);
    }

    @PreAuthorize("#name == authentication.principal.username")
    @GetMapping("/persons/by-username")
    public Optional<Persons> getPersonsByUsername(@RequestParam("name") String name) {
        return myService.getPersonsByUsername(name);
    }
}
