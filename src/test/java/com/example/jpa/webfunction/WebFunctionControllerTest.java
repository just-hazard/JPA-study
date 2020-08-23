package com.example.jpa.webfunction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebFunctionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebFunctionRepository webFunctionRepository;

    @Test
    public void crud() throws Exception {

        WebFunction webFunction = new WebFunction();
        webFunction.setTitle("double");
        webFunctionRepository.save(webFunction);

        mockMvc.perform(get("/webfunctions/" + webFunction.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("double"));
    }

//    @Test
//    public void getWebFunctions() throws Exception {
//        WebFunction webFunction = new WebFunction();
//        webFunction.setTitle("test");
//        webFunctionRepository.save(webFunction);
//
//        mockMvc.perform(get("/webfunctions/")
//                    .param("page","3")
//                    .param("size","10")
//                    .param("sort","created,desc")
//                    .param("sort","title"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

    @Test
    public void findByTitleStartsWith() {
        WebFunction webFunction = new WebFunction();
        webFunction.setTitle("test");
    }

    public WebFunction createWebFunctions() {
        WebFunction webFunction = new WebFunction();
        webFunction.setTitle("F5");

        return webFunctionRepository.save(webFunction);
    }

    @Test
    public void updateTitle() {
        WebFunction F5 = createWebFunctions();

        int updateCount = webFunctionRepository.updateTitle("박경", F5.getId());
        assertThat(updateCount).isEqualTo(1);

        Optional<WebFunction> byId = webFunctionRepository.findById(F5.getId());
        WebFunction webFunction = byId.get();
        assertThat(webFunction.getTitle()).isEqualTo("박경");
    }

}