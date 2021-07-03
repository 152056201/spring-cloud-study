package com.yh.payment.paymentprovider.service;

import com.yh.commons.entities.Payment;

public interface PaymentService {
    public int insert(Payment payment);

    public Payment getById(Long id);
}
