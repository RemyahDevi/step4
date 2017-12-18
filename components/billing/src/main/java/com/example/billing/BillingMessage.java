package com.example.billing;

import java.io.Serializable;

class BillingMessage implements Serializable {

    private final String userId;
    private final int amount;

    public BillingMessage(String userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }
}
