package scrap.heap.refactor;

import scrap.heap.refactor.domain.Balloon;
import scrap.heap.refactor.domain.Cake;
import scrap.heap.refactor.domain.constants.Colors;
import scrap.heap.refactor.domain.constants.Flavors;
import scrap.heap.refactor.domain.constants.Material;
import scrap.heap.refactor.domain.constants.OrderStatus;
import scrap.heap.refactor.domain.constants.OrderType;
import scrap.heap.refactor.domain.constants.Shapes;
import scrap.heap.refactor.domain.constants.Sizes;

//this class can be expanded for any types of order
public class OrderProcessor {

  public static OrderStatus buildOrder(OrderType orderType, String[] options) {
    switch (orderType) {
      case CAKE:
        try {
          new Cake.CakeBuilder()
              .setFlavor(Flavors.valueOf(options[0].toUpperCase()))
              .setFrostingFlavor(Flavors.valueOf(options[1].toUpperCase()))
              .setShape(Shapes.valueOf(options[2].toUpperCase()))
              .setSize(Sizes.valueOf(options[3].toUpperCase()))
              .setCakeColor(Colors.valueOf(options[4].toUpperCase()))
              .createCake()
              .placeOrder();
        } catch (Exception e) {
          System.out.println("bad luck, try again " + e.getMessage());
        }
        break;
      case BALLOON:
        try {
          new Balloon.BalloonBuilder()
              .setBalloonColor(Colors.valueOf(options[0].toUpperCase()))
              .setMaterial(Material.valueOf(options[1].toUpperCase()))
              .setNumber(Integer.parseInt(options[2].toUpperCase()))
              .createBalloon()
              .placeOrder();

        } catch (Exception e) {
          System.out.println("bad luck, try again " + e.getMessage());
          return OrderStatus.FAIL;
        }
        break;
    }
    return OrderStatus.SUCCESS;
  }
}
