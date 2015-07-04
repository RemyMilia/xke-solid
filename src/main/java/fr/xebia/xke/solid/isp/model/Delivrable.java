package fr.xebia.xke.solid.isp.model;

/**
 * Created by sbuisson on 04/07/2015.
 */
public interface Delivrable {
    String getReferenceItem();

    void setReferenceItem(String referenceItem);

    int getQuantity();

    void setQuantity(int quantity);

    String getDeliveryAddress();

    void setDeliveryAddress(String deliveryAddress);
}
