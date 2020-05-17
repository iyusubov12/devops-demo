package az.ingress.devopsdemo.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DevOpsApi.class)
public class DevOpsApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void sayHello() throws Exception {
        mvc.perform(get("/api/devops"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello DevOps"));
    }


}