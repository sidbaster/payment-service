package com.payment.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "guid")
@ToString
public class Payment  {

    @Id
    @Column(columnDefinition = "uuid default gen_random_uuid()", name = "id")
    private UUID guid;

    @Column(name = "amount" , nullable = false)
    private BigDecimal amount;

    @Column(name = "currency" , nullable = false)
    private String currency;

    @Column(name = "status" , nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
