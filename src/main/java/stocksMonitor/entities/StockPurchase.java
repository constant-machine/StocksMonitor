package stocksMonitor.entities;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "STOCKPURCHASES")
public class StockPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchases_generator")
    @SequenceGenerator(name = "purchases_generator", sequenceName = "PURCHASES_SEQUENCE", initialValue = 1, allocationSize = 1)
    private Long id;
    private String name;
    private String emitent;
    private Long amount;
    private BigDecimal cost;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User owner;

    public StockPurchase(String name, String emitent,
                         Long amount, BigDecimal cost, User userName) {
        this.name = name;
        this.emitent = emitent;
        this.amount = amount;
        this.cost = cost;
        this.owner = userName;
    }

    @Override
    public String toString() {
        return "StockPurchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emitent='" + emitent + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                ", userName=" + owner +
                '}';
    }

    public StockPurchase() {
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
