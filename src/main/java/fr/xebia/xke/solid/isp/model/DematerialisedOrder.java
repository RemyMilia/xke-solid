package fr.xebia.xke.solid.isp.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 19/06/2015.
 */
public class DematerialisedOrder implements Order {

    private String referenceItem;
    private String billingAddress;
    private BigDecimal prixUnitaire;


    public String getDeliveryAddress() {
        throw new NotImplementedException();
    }

    public void setDeliveryAddress(String deliveryAddress) {
        throw new NotImplementedException();
    }


    public void setQuantity(int quantity) {
        throw new NotImplementedException();
    }


    public int getQuantity() {
        return 1;
    }


    public String getReferenceItem() {
        return referenceItem;
    }

    public void setReferenceItem(String referenceItem) {
        this.referenceItem = referenceItem;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BigDecimal getMontant() {
        return prixUnitaire;
    }

    public BigDecimal getUnitPrice() {
        return prixUnitaire;
    }

    public void setUnitPrice(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
