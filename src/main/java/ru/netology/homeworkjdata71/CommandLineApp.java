package ru.netology.homeworkjdata71;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.netology.homeworkjdata71.entity.Contact;
import ru.netology.homeworkjdata71.entity.Persons;
import ru.netology.homeworkjdata71.repository.MyRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class CommandLineApp implements CommandLineRunner {
    @Autowired
    private MyRepository myRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Ivan", "Vasiliy", "Sidor", "Alexey");
        var surnames = List.of("Ivanov", "Pupkin", "Kuzmin", "Yagudin");
        var ages = List.of(24, 31, 16, 42);
        var phoneNumbers = List.of("495-1234567", "49-1234567", "495-7778899", "777-7777777");
        var cityOfLivings = List.of("Moscow", "Colonge", "Moscow", "NewVasyuki");

        IntStream.range(0, names.size())
                .forEach(i -> {
                    var person = Persons.builder()
                            .contact(Contact.builder()
                                    .age(ages.get(i))
                                    .name(names.get(i))
                                    .surname(surnames.get(i))
                                    .build())
                            .cityOfLiving(cityOfLivings.get(i))
                            .phoneNumber(phoneNumbers.get(i))
                            .build();

                    myRepository.getPersonRepository().save(person);
                });
    }
}
