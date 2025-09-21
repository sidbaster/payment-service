package com.payment.system.service;

import com.payment.system.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public final class PaymentService {

    private PaymentService() {}

    private static final Map<Long, Payment> payments;

    static {
        payments = new HashMap<>();
        payments.put(1L, new Payment(1L,"ipko", 2345L));
        payments.put(2L, new Payment(2L,"bankuk", 7688L));
        payments.put(3L, new Payment(3L,"jpmorgan", 4545L));
        payments.put(4L, new Payment(4L,"goldbank", 3456L));
        payments.put(5L, new Payment(5L,"paysend", 9876L));
    }

    public static Payment getPaymentById(String id) {
        return payments.get(Long.parseLong(id));
    }

    public static List<Payment> getPayments() {
        return new ArrayList<>(payments.values());
    }
}
