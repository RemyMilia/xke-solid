package fr.xebia.xke.solid.isp.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 19/06/2015.
 */
public class DematerialisedOrder implements Order {

    private String referenceItem;
    private String facturationAddress;
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

    public String getFacturationAddress() {
        return facturationAddress;
    }

    public void setFacturationAddress(String facturationAddress) {
        this.facturationAddress = facturationAddress;
    }

    public BigDecimal getMontant() {
        return prixUnitaire;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
