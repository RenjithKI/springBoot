package com.salimatech.zazie.controller;

import com.salimatech.zazie.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
@AutoConfigureMockMvc
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mvc;


    @Before
    public void setup() {
    }


    @Test
    public void fibonacciRecursiveValidRequest() throws Exception {
        this.mvc.perform(get("/fibonacci/?number=2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[0,1,1]")));


    }

    @Test
    public void fibonacciRecursiveMissingParam() throws Exception {
        this.mvc.perform(get("/fibonacci").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());


    }

}