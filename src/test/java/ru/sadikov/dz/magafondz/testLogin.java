package ru.sadikov.dz.magafondz;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class testLogin {
@Autowired
private MockMvc mock;
   private String baseUrl="http://localhost:8080";
   @Test
    void expect_LogsInSuccess() throws Exception{
       mock.perform(post(baseUrl+"/login").param("username","mishax2ov@gmail.com")
               .param("password","123456789")).andExpect(redirectedUrl(null));

   }
}
