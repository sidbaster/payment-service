package com.payment.system.controller;

import com.payment.system.entity.Payment;
import com.payment.system.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

/**
 * Controller for payment-service.
 */
@Controller
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository paymentRepository;
    /**
     * Receives payment by ID.
     *
     * @param id Payment ID
     * @return ResponseEntity with Payment
     */
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable String id) {
        if (paymentRepository.findById(UUID.fromString(id)).isPresent())
            return ResponseEntity.ok(paymentRepository.findById(UUID.fromString(id)).get());
        else
            return ResponseEntity.notFound().build();
    }

    /**
     * Receives a list of all payments.
     *
     * @return ResponseEntity with payment list
     */
    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        return ResponseEntity.ok(paymentRepository.findAll());
    }
}
