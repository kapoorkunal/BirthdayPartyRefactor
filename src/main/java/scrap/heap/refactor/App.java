package scrap.heap.refactor;

import scrap.heap.refactor.domain.constants.OrderType;

public class App {

  public String getGreeting() {
    return "Hello world.";
  }

  public static void main(String[] args) {

    OrderProcessor.buildOrder(OrderType.BALLOON, new String[]{"red", "mylar", "4"});
    OrderProcessor
        .buildOrder(OrderType.CAKE,
            new String[]{"chocolate", "chocolate", "circle", "large", "brown"});

    OrderProcessor.buildOrder(OrderType.BALLOON, new String[]{"yellow", "mylar", "4"});
    OrderProcessor
        .buildOrder(OrderType.CAKE,
            new String[]{"Vanilla", "chocolate", "square", "med", "brown"});

    System.out.println(OrderProcessor.buildOrder(OrderType.BALLOON, new String[]{"blue", "latex", "7"}));
    System.out.println(OrderProcessor
        .buildOrder(OrderType.CAKE,
            new String[]{"vanilla", "vanilla", "square", "small", "yellow"}));
  }

}
