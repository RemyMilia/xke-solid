package fr.xebia.xke.solid.isp.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 14/06/2015.
 */
public class FreeOrder implements Order {
    private String referenceItem;
    private int quantity;
    private String deliveryAddress;

    public String getBillingAddress() {
        throw new NotImplementedException();
    }


    public void setBillingAddress(String facturationAddress) {
        throw new NotImplementedException();
    }


    public BigDecimal getMontant() {
        throw new NotImplementedException();
    }


    public void setUnitPrice(BigDecimal prixUnitaire) {
        throw new NotImplementedException();
    }


    public BigDecimal getUnitPrice() {
        return BigDecimal.ZERO;
    }

    public String getReferenceItem() {
        return referenceItem;
    }


    public void setReferenceItem(String referenceItem) {
        this.referenceItem = referenceItem;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getDeliveryAddress() {
        return deliveryAddress;
    }


    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


}
