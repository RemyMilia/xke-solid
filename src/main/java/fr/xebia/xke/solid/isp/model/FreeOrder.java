package fr.xebia.xke.solid.isp.model;

/**
 * Created by sbuisson on 14/06/2015.
 */
public class FreeOrder implements Delivrable {
    private String referenceItem;
    private int quantity;
    private String deliveryAddress;

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
