package stocksMonitor.entities;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String emitent;
    private Long amount;
    private BigDecimal cost;

    public Stock(String name, String emitent, Long amount, BigDecimal cost) {
        this.name = name;
        this.emitent = emitent;
        this.amount = amount;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emitent='" + emitent + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitent() {
        return emitent;
    }

    public void setEmitent(String emitent) {
        this.emitent = emitent;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
