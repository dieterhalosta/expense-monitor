package org.fasttrackit.domain;

import java.time.LocalDate;

public class Payments {

    private long id;
    private LocalDate date;
    private String description;
    private Double amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "payments{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
