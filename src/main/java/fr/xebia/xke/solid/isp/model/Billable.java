package fr.xebia.xke.solid.isp.model;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 04/07/2015.
 */
public interface Billable {
    String getBillingAddress();

    void setBillingAddress(String billingAddress);

    BigDecimal getUnitPrice();

    void setUnitPrice(BigDecimal unitPrice);

    BigDecimal getAmount();
}
