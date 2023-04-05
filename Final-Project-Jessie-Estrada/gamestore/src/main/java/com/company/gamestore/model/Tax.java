package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "tax")
public class Tax {

    @Id
    private String state;

    private BigDecimal rate;

    public Tax(){}

    public Tax(String state, BigDecimal rate) {
        this.state = state;
        this.rate = rate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tax)) return false;
        Tax tax = (Tax) o;
        return Objects.equals(getState(), tax.getState()) && Objects.equals(getRate(), tax.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }

    @Override
    public String toString() {
        return "Tax{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
