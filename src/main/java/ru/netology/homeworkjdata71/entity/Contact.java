package ru.netology.homeworkjdata71.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Contact implements Serializable {
    @Column(length = 20)
    private String name;

    @Column(length = 40)
    private String surname;

    @Column
    private Integer age;
}
