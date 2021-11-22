package com.kafkaOne.microservicedealer.controller;

import com.kafkaOne.microservicedealer.model.PaymentDto;
import com.kafkaOne.microservicedealer.service.PaymentDtoService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Api(value = "hello")
public class PaymentDtoController {

    private PaymentDtoService paymentDtoService;

    @Autowired
    public PaymentDtoController(PaymentDtoService paymentDtoService) {
        this.paymentDtoService = paymentDtoService;
    }

    @GetMapping
    @ApiOperation(value = "Отправка PaymentDto в microservice-integrator")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешная отправка ID клиента и суммы платежа"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public String produce(@ApiParam(name = "clientId", value = "ID банковского аккаунта, который необходимо отправить")
                              @RequestParam(value = "clientId", required = false) Long clientId,
                          @ApiParam(name = "amount", value = "сумма платежа")
                          @RequestParam(value = "amount", required = false) Integer amount) {
        if(clientId==null || amount==null){
            clientId = 1L; amount = 16000;
        }
        PaymentDto paymentDto = new PaymentDto(clientId, amount);
        //paymentDtoService.produce(paymentDto);
        return paymentDto.toString();
    }
}
