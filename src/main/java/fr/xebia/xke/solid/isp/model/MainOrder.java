package fr.xebia.xke.solid.isp.model;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 14/06/2015.
 */
public class MainOrder implements Delivrable, Billable {

    private String referenceItem;
    private int quantity;
    private String deliveryAddress;
    private String billingAddress;
    private BigDecimal unitPrice;

    @Override
    public String getReferenceItem() {
        return referenceItem;
    }

    @Override
    public void setReferenceItem(String referenceItem) {
        this.referenceItem = referenceItem;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String getBillingAddress() {
        return billingAddress;
    }

    @Override
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public BigDecimal getAmount() {
        return getUnitPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }

}
