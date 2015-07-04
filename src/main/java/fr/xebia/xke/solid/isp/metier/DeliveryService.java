package fr.xebia.xke.solid.isp.metier;


import fr.xebia.xke.solid.isp.model.Delivrable;

/**
 * Created by sbuisson on 14/06/2015.
 */
public class DeliveryService {


    public String processOrder(Delivrable order) {


        return "send " + order.getQuantity() + " " + order.getReferenceItem() + " to " + order.getDeliveryAddress();

    }
}
