package com.app.store.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Simulated payment detail
 */
@Data
@Builder
public class PaymentDetailDTO {

    /**
     * Customer ID associated with the payment
     */
    private Long customerId;

    /**
     * Payment transaction ID for reference
     */
    private String transactionId;

    /**
     * Payment date and time
     */
    private Date paymentDate;

    /**
     * Total paid
     */
    private double totalPaid;

}
