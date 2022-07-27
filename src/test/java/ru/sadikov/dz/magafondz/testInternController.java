package ru.sadikov.dz.magafondz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import ru.sadikov.dz.magafondz.controllers.InternController;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class testInternController {
    @Autowired
    private InternController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
