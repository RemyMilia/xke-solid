package fr.xebia.xke.solid.isp.metier;


import fr.xebia.xke.solid.isp.model.FreeOrder;
import fr.xebia.xke.solid.isp.model.MainOrder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeliveryServiceTest {
    DeliveryService deliveryService;

    @Before
    public void setUp() {
        deliveryService = new DeliveryService();
    }

    @Test
    public void shouldDeliverOrderOfPonyToHaussman() {

        //Given
        MainOrder order = new MainOrder();
        order.setReferenceItem("Pony");
        order.setQuantity(3);
        order.setDeliveryAddress("156 Bd Haussman");


        //When
        String actual = deliveryService.processOrder(order);

        //Assert
        assertEquals("send 3 Pony to 156 Bd Haussman", actual);
    }


    @Test
    public void shouldDeliverOrderOfAgilistToDjerba() {

        //Given
        FreeOrder holiday = new FreeOrder();
        holiday.setQuantity(120);
        holiday.setReferenceItem("Xebians");
        holiday.setDeliveryAddress("Djerba");

        //When
        String actual = deliveryService.processOrder(holiday);

        //Assert
        assertEquals("send 120 Xebians to Djerba", actual);
    }


}