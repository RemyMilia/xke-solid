package fr.xebia.xke.solid.isp.metier;

import fr.xebia.xke.solid.isp.model.MainOrder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by sbuisson on 29/06/2015.
 */
public class MainOrderTest {

    @Test
    public void shouldHaveAmount() {

        //Given
        MainOrder order = new MainOrder();
        order.setUnitPrice(BigDecimal.valueOf(3));
        order.setQuantity(4);

        //When
        BigDecimal actual = order.getAmount();

        //Then
        assertEquals(BigDecimal.valueOf(12), actual);
    }
}
