package com.payment.system.entity;

import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Payment  {

    @Id
    @Column(columnDefinition = "uuid default gen_random_uuid()", name = "id")
    private UUID guid;

    @Column(name = "currency" , nullable = false)
    private String currency;

    @Column(name = "amount" , nullable = false)
    private BigDecimal amount;

    @Column(name = "status" , nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
