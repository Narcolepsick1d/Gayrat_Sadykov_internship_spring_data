package ru.sadikov.dz.magafondz;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sadikov.dz.magafondz.controllers.EmployeesController;

@SpringBootTest
public class testEmployeeController {

    @Autowired
    private EmployeesController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}