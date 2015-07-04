package fr.xebia.xke.solid.isp.metier;


import fr.xebia.xke.solid.isp.model.Billable;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 14/06/2015.
 */
public class BillingService {

    public String writeBill(Billable order) {

        BigDecimal amount = order.getAmount();
        return order.getBillingAddress() + " must pay " + amount + " euros";
    }
}
