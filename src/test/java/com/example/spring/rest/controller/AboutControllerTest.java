package com.example.spring.rest.controller;

import com.example.spring.rest.config.BaseControllerTest;
import org.junit.Test;

import static com.example.spring.rest.controller.ApiController.RESOURCE_ABOUT;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AboutControllerTest extends BaseControllerTest {

    @Test
    public void testAbout() throws Exception {
        mockMvc.perform(get(RESOURCE_ABOUT))
               .andExpect(status().isOk())
               .andExpect(content().contentType(jsonContentType))
               .andExpect(jsonPath("$.version", is("${version}")))
               .andExpect(jsonPath("$.buildTimestamp", containsString("${buildTimestamp}")));
    }
}