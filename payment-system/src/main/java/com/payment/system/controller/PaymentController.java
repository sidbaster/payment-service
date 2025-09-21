package com.payment.system.controller;

import com.payment.system.entity.Payment;
import com.payment.system.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller for payment-service.
 */
@Controller
@RequestMapping("/payments")
public class PaymentController {

    /**
     * Receives payment by ID.
     *
     * @param id Payment ID
     * @return ResponseEntity with Payment
     */
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable String id) {
        return ResponseEntity.ok(PaymentService.getPaymentById(id));
    }

    /**
     * Receives a list of all payments.
     *
     * @return ResponseEntity with payment list
     */
    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        return ResponseEntity.ok(PaymentService.getPayments());
    }
}
