package fr.xebia.xke.solid.isp.metier;

import fr.xebia.xke.solid.isp.model.DematerialisedOrder;
import fr.xebia.xke.solid.isp.model.MainOrder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BillingServiceTest {
    BillingService billingService;

    @Before
    public void setUp() {
        billingService = new BillingService();
    }

    @Test
    public void shouldChargeSNCF() {
        //Given
        MainOrder order = new MainOrder();
        order.setBillingAddress("SNCF");
        order.setUnitPrice(BigDecimal.valueOf(1));
        order.setQuantity(1);

        //When
        String actual = billingService.writeBill(order);

        //Then
        assertEquals("SNCF must pay 1 euros", actual);
    }

    @Test
    public void shouldChargeSFR() {
        //Given
        DematerialisedOrder order = new DematerialisedOrder();
        order.setBillingAddress("SFR");
        order.setUnitPrice(BigDecimal.valueOf(666));

        //When
        String actual = billingService.writeBill(order);

        //Then
        assertEquals("SFR must pay 666 euros", actual);
    }


}