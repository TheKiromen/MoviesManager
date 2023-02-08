package com.dkrucze.MoviesManager.ControllerTests;

import com.dkrucze.MoviesManager.Web.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHomepage() {
    }

    @Test
    void shouldReturnAdminHomepage() {
    }

    @Test
    void shouldReturnLoginForm() {
    }
}