package com.kafkaOne.microservicedealer.service;

import com.kafkaOne.microservicedealer.model.PaymentDto;

public interface PaymentDtoService {

    void produce(PaymentDto paymentDto);

}
