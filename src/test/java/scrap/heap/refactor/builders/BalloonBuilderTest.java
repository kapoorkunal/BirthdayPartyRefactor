package scrap.heap.refactor.builders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scrap.heap.refactor.domain.Balloon;
import scrap.heap.refactor.domain.constants.Colors;
import scrap.heap.refactor.domain.constants.Material;

public class BalloonBuilderTest {

  private Balloon.BalloonBuilder balloonBuilder;

  @Before
  public void setUp() {
    balloonBuilder = new Balloon.BalloonBuilder();
  }

  @Test
  public void testBalloonColor() {
    Balloon balloon = balloonBuilder.setBalloonColor(Colors.RED).createBalloon();
    assertNotNull("balloon not null", balloon);
    assertNotNull("color not null", balloon.getColor());
  }

  @Test
  public void testBalloonMaterial() {
    Balloon balloon = balloonBuilder.setMaterial(Material.MYLAR).createBalloon();
    assertNotNull("balloon not null", balloon);
    assertNotNull("material not null", balloon.getMaterial());
  }

  @Test
  public void testBalloonNumber() {
    Balloon balloon = balloonBuilder.setNumber(4).createBalloon();
    assertNotNull("balloon not null", balloon);
    assertNotNull("number not null", balloon.getNumber());
  }

  @Test
  public void testCreateBalloon() {
    Balloon balloon =
        balloonBuilder
            .setBalloonColor(Colors.RED)
            .setMaterial(Material.LATEX)
            .setNumber(10)
            .createBalloon();
    assertNotNull("balloon not null", balloon);
    assertNotNull("color not null", balloon.getColor());
    assertNotNull("number not null", balloon.getNumber());
    assertNotNull("material not null", balloon.getMaterial());
  }

  @Test
  public void testEmptyCreateBalloon() {
    Balloon balloon = balloonBuilder.createBalloon();
    assertNotNull("balloon not null", balloon);
    assertNull("color is null", balloon.getColor());
    assertThat("number is 0", balloon.getNumber(), is(0));
    assertNull("material is null", balloon.getMaterial());
  }

  @Test
  public void testPlaceOrder() {
    balloonBuilder =
        balloonBuilder.setBalloonColor(Colors.YELLOW).setMaterial(Material.LATEX).setNumber(20);
    try {
      balloonBuilder.createBalloon().placeOrder();
    } catch (Exception e) {
      Assert.fail("Failed creating balloon");
    }
  }
}
