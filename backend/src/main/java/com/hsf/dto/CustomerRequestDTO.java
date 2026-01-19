package com.hsf.dto;

import com.hsf.enums.CustomerLanguage;
import com.hsf.enums.WeekDays;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {

    private String name;
    private Long number;
    private CustomerLanguage language;
    private String notificationNumber;
    private String invoiceName;
    private WeekDays weekDays;

}
