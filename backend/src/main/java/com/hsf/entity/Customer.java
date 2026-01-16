package com.hsf.entity;

import com.hsf.enums.CustomerLanguage;
import com.hsf.enums.WeekDays;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kunden")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "k_nr", nullable = false, unique = true)
    private Long number;

    @Column(name = "name_kunde", nullable = false, unique = true, length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "sprache", nullable = true)
    private CustomerLanguage language;

    @Column(name = "aviso_sms", length = 255)
    private String notificationNumber;

    @Column(name = "name_rechnung", length = 255)
    private String invoiceName;

    @Enumerated(EnumType.STRING)
    @Column(name = "plantag_id")
    private WeekDays weekDays;
}
