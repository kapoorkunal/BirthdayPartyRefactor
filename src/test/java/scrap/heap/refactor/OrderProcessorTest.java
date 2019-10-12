package scrap.heap.refactor;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import scrap.heap.refactor.domain.constants.OrderStatus;
import scrap.heap.refactor.domain.constants.OrderType;

public class OrderProcessorTest {

  @Test
  public void testAppHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
  }

  @Test
  public void testSuccessOrder() {
    OrderStatus orderStatus = OrderProcessor.buildOrder(
        OrderType.BALLOON, new String[]{"red", "mylar", "4"});

    assertThat(OrderStatus.SUCCESS, is(orderStatus));
  }

  @Test
  public void testFailOrder() {
    OrderStatus orderStatus = OrderProcessor.buildOrder(
        OrderType.BALLOON, new String[]{"mylar", "4"});

    assertThat(OrderStatus.FAIL, is(orderStatus));
  }
}
