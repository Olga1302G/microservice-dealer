package com.kafkaOne.microservicedealer.service;

import com.kafkaOne.microservicedealer.model.PaymentDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentDtoServiceImpl implements PaymentDtoService{

    private final KafkaTemplate<String, PaymentDto> kafkaTemplate;

    @Autowired
    public PaymentDtoServiceImpl(KafkaTemplate<String, PaymentDto> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produce(PaymentDto paymentDto){
        System.out.println("Producing the message: "+paymentDto);
        kafkaTemplate.send("server.payment", paymentDto);

    }


}
