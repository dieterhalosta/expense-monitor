package org.fasttrackit.transfer;

import java.time.LocalDate;

public class CreatePaymentRequest {

    private LocalDate date;
    private String description;
    private double amount;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CreatePaymentRequest{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
