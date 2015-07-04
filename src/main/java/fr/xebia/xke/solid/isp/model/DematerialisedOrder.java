package fr.xebia.xke.solid.isp.model;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 19/06/2015.
 */
public class DematerialisedOrder implements Billable {

    private String referenceItem;
    private String billingAddress;
    private BigDecimal prixUnitaire;


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

    public BigDecimal getAmount() {
        return prixUnitaire;
    }

    public BigDecimal getUnitPrice() {
        return prixUnitaire;
    }

    public void setUnitPrice(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
