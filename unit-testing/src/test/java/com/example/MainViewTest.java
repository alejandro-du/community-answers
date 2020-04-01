package com.example;

import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class MainViewTest {

    @Test
    public void shouldShowErrorAndNoAgeOnNullDate() {
        MainView mainView = mock(MainView.class);
        doCallRealMethod().when(mainView).calculateAge(anyObject());

        mainView.calculateAge(null);
        verify(mainView).showError();
        verify(mainView, never()).showAge(anyObject());
    }

}
