package com.kafkaOne.microservicedealer.controller;

import com.google.gson.Gson;
import com.kafkaOne.microservicedealer.model.PaymentDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PaymentDtoControllerTest {

    @Autowired
    PaymentDtoController paymentDtoController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testExistence() throws Exception {
        assertNotNull(paymentDtoController, "PaymentDto Rest controller is null");
    }

    @Test
    public String produce() throws Exception {

        String paymentDtoJson = new Gson().toJson(PaymentDto.builder()
                .clientId(1L)
                .amount(1800)
                .build());
        mockMvc.perform(get("/payment"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(paymentDtoJson));
        return paymentDtoJson;
    }
}