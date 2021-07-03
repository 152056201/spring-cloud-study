package com.th.payment8002.controller;

import com.th.payment8002.service.PaymentService;
import com.yh.commons.entities.CommResult;
import com.yh.commons.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/add")
    public CommResult add(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        log.info("结果为:" + insert);
        if (insert > 0) {
            return new CommResult(200, "插入成功,serverPort=" + serverPort, payment.toString());
        } else {
            return new CommResult(400, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/find/{id}")
    public CommResult find(@PathVariable("id") Long id) {
        Payment byId = paymentService.getById(id);
        log.info("结果为:" + byId.toString());
        if (byId != null) {
            return new CommResult(200, "查询成功,serverPort=" + serverPort, byId);
        } else {
            return new CommResult(400, "查询失败，id=" + id, null);
        }
    }

    @GetMapping("/payment/lb")
    public String balance(){
        return serverPort;
    }
}
