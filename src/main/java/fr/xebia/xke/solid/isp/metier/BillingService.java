package fr.xebia.xke.solid.isp.metier;


import fr.xebia.xke.solid.isp.model.Order;

import java.math.BigDecimal;

/**
 * Created by sbuisson on 14/06/2015.
 */
public class BillingService {

    public String writeBill(Order order) {

        BigDecimal montant = order.getPrixUnitaire().multiply(BigDecimal.valueOf(order.getQuantity()));
        return order.getFacturationAddress() + " must pay " + montant + " euros";
    }
}
