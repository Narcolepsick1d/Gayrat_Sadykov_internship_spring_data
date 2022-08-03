package ru.sadikov.dz.magafondz;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.sadikov.dz.magafondz.Reprository.EmployeeRepository;
import ru.sadikov.dz.magafondz.models.Employee;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeRepository repository; // mock the repository

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void exampleTest() throws Exception {
        final int userId = 1;
        Employee mockedUser = new Employee( "kiril", "generov","ceo");
        Mockito.doReturn(mockedUser).when(repository).findById(userId);

        final String expectedResponseContent = objectMapper.writeValueAsString(mockedUser);

        this.mvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseContent ));

        verify(repository).findById(userId); // verify that the repository was called correctly
    }
}
