package scrap.heap.refactor.domain;

import scrap.heap.refactor.domain.constants.Colors;
import scrap.heap.refactor.domain.constants.Material;

public class Balloon implements PlaceOrder<Balloon> {

  private Colors color;
  private Material material;
  private Integer number;

  public Colors getColor() {
    return color;
  }

  public Material getMaterial() {
    return material;
  }

  public Integer getNumber() {
    return number;
  }

  // no args constructor
  public Balloon() {
  }

  //all args constructor
  public Balloon(Colors color, Material material, Integer number) {
    this.color = color;
    this.material = material;
    this.number = number;
  }

  @Override
  public String toString() {
    return "Balloon{" +
        "color=" + color +
        ", material=" + material +
        ", number=" + number +
        '}';
  }

  //Using Builder Pattern to build object

  public static class BalloonBuilder {

    private Colors color;
    private Material material;
    private int number;

    public BalloonBuilder setBalloonColor(Colors color) {
      this.color = color;
      return this;
    }

    public BalloonBuilder setMaterial(Material material) {
      this.material = material;
      return this;
    }

    public BalloonBuilder setNumber(int number) {
      this.number = number;
      return this;
    }

    public Balloon createBalloon() {
      return new Balloon(color, material, number);
    }
  }
}
