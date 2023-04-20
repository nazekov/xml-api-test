package com.example.demoxml.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    Long id;

    BigDecimal amount;

    BigDecimal commission;

    Integer currency;

    Integer status;
}
