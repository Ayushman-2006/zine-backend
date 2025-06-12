package com.dev.zine.model;



import jakarta.persistence.*;



import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="inventory_items")


public class InventoryItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private long id;

    @Column(name = "item_name")
    private String name;


    @Column(name = "item_count")
    private int count;

    @Column(name = "item_price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_name")
    private Categories category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
