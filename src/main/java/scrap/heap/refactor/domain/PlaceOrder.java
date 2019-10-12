package scrap.heap.refactor.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface PlaceOrder<T> {

  default <T> void placeOrder()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    // calling implementing class using java reflection.
    Class<?> c = getClass();
    Method method;
    method = c.getDeclaredMethod("toString");
    System.out.println(method.invoke(this).toString());
  }
}
