package ru.netology.homeworkjdata71.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.homeworkjdata71.entity.Contact;
import ru.netology.homeworkjdata71.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Contact> {
    @Query("select p from Persons p where p.cityOfLiving = :city")
    List<Persons> findMyCity(@Param("city") String city);

    @Query("select p from Persons p where p.contact.age < :age order by p.contact.age")
    List<Persons> findMyAge(Integer age);

    @Query("select p from Persons p where p.contact.name = :name and p.contact.surname = :surname")
    Optional<Persons> findMyNameSurname(String name, String surname);

    @Query("select p from Persons p where p.contact.name = :name")
    Optional<Persons> findMyUsername(String name);
}
