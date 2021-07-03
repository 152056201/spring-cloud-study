package com.yh.payment.paymentprovider.service.impl;

import com.yh.commons.entities.Payment;
import com.yh.payment.paymentprovider.dao.PaymentDao;
import com.yh.payment.paymentprovider.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
