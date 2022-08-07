package ru.sadikov.dz.magafondz;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import ru.sadikov.dz.magafondz.models.Employee;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest
@AutoConfigureMockMvc

public class AppControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  @Test
    public void testDiplayEmployees() throws JsonProcessingException ,Exception {
    String name = "Garik";
    String surname="sadikov";
    String jobTitle="test";
    Employee employee = new Employee(name,surname,jobTitle);
    ResultActions resultActions  = mockMvc.perform(put("http://localhost:8080/api/employees")
            .contentType("application/json")
            .contentType(objectMapper.writeValueAsString(employee)));

    resultActions.andDo(print());

    resultActions.andExpect(jsonPath("name",is(name)));
    resultActions.andExpect(jsonPath("surname",is(surname)));
    resultActions.andExpect(jsonPath("jobTitle",is(jobTitle)));

  }

    }

