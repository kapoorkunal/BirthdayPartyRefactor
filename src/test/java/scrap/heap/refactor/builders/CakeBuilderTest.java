package scrap.heap.refactor.builders;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scrap.heap.refactor.domain.Cake;
import scrap.heap.refactor.domain.constants.Colors;
import scrap.heap.refactor.domain.constants.Flavors;
import scrap.heap.refactor.domain.constants.Shapes;
import scrap.heap.refactor.domain.constants.Sizes;

public class CakeBuilderTest {

  private Cake.CakeBuilder cakeBuilder;

  @Before
  public void setUp() {
    cakeBuilder = new Cake.CakeBuilder();
  }

  @Test
  public void testCakeFrostingFlavor() {
    cakeBuilder.setFrostingFlavor(Flavors.VANILLA).createCake();
    assertNotNull(cakeBuilder);
  }

  @Test
  public void testCakeFlavor() {
    cakeBuilder.setFlavor(Flavors.VANILLA).createCake();
    assertNotNull(cakeBuilder);
  }

  @Test
  public void testCakeShape() {
    cakeBuilder.setShape(Shapes.SQUARE).createCake();
    assertNotNull(cakeBuilder);
  }

  @Test
  public void testCakeSize() {
    cakeBuilder.setSize(Sizes.SMALL).createCake();
    assertNotNull(cakeBuilder);
  }

  @Test
  public void testCakeColor() {
    cakeBuilder.setCakeColor(Colors.BLUE).createCake();
    assertNotNull(cakeBuilder);
  }

  @Test
  public void testCreateCake() {
    this.cakeBuilder
        .setCakeColor(Colors.RED)
        .setFlavor(Flavors.CHOCOLATE)
        .setFrostingFlavor(Flavors.CHOCOLATE)
        .setShape(Shapes.CIRCLE)
        .setSize(Sizes.LARGE);
    Cake cake = cakeBuilder.createCake();
    assertNotNull("not null flavor", cake.getFlavor());
    assertNotNull("not null frosting", cake.getFrostingFlavor());
    assertNotNull("not null shape", cake.getShape());
    assertNotNull("not null size", cake.getSize());
    assertNotNull("not null color", cake.getCakeColor());
  }

  @Test
  public void testEmptyCake() {
    Cake cake = cakeBuilder.createCake();
    assertNull("null flavor", cake.getFlavor());
    assertNull("null frosting", cake.getFrostingFlavor());
    assertNull("null shape", cake.getShape());
    assertNull("null size", cake.getSize());
    assertNull("null color", cake.getCakeColor());
  }

  @Test
  public void testPlaceOrder() {
    this.cakeBuilder
        .setCakeColor(Colors.BROWN)
        .setFlavor(Flavors.CHOCOLATE)
        .setFrostingFlavor(Flavors.VANILLA)
        .setShape(Shapes.CIRCLE)
        .setSize(Sizes.SMALL);
    try {
      cakeBuilder.createCake().placeOrder();
    } catch (ReflectiveOperationException e) {
      Assert.fail("Failed creating cake");
    }
  }
}
