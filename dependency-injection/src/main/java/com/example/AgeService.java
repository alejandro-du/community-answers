package com.example;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeService {

    public int getAgeByBirthDate(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears();
    }

}
