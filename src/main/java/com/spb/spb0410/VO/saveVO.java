package com.spb.spb0410.VO;

public class saveVO {

    // generate several iD
    private Long id;
    private int quantity;

    // get set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "saveVO [id=" + id + ", quantity=" + quantity + "]";
    }

}
