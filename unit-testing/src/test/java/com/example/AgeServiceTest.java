package com.example;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgeServiceTest {

    @Test
    public void shouldReturnCorrectAge() {
        AgeService ageService = new AgeService();
        int expectedAge = 44;
        LocalDate date = LocalDate.now().minusYears(expectedAge);

        int actualAge = ageService.getAgeByBirthDate(date);
        assertThat(actualAge, is(expectedAge));
    }

}
