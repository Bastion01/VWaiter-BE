package com.vwaiter.common;

/**
 * CREATED - just created
 * AWAITING_CONFIRMATION - till waiter confirmation, could not be modified after
 * IN_PROGRESS - after confirmation while cooking
 * DELIVERED - after delivery
 * AWAITING_PAYMENT - after "schet pozhaluista"
 * PAID - after payment
 */
public enum OrderStatus {
    CREATED,
    AWAITING_CONFIRMATION,
    IN_PROGRESS,
    COMPLETED,
    AWAITING_PAYMENT,
    PAID
}
