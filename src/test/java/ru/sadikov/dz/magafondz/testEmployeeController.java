package ru.sadikov.dz.magafondz;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sadikov.dz.magafondz.controllers.EmployeeController;

@SpringBootTest
public class testEmployeeController {

    @Autowired
    private EmployeeController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}