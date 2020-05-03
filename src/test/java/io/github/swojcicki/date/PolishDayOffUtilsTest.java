package io.github.swojcicki.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.stream.IntStream;

/**
 * Created on: 01.05.2020 21:42 <br/>
 *
 * @author root
 */
public class PolishDayOffUtilsTest {

  @Test
  public void january_2020() {
    Assertions.assertEquals(21, PolishDayOffUtils.getWorkingDays(2020, 1));
  }

  @Test
  public void april_2020() {
    Assertions.assertEquals(21, PolishDayOffUtils.getWorkingDays(2020, Month.APRIL));
  }

  @Test
  public void year_2020() {
    Assertions.assertEquals(253, PolishDayOffUtils.getWorkingDays(2020));
  }

  @Test
  public void years() {
    IntStream.range(2018, 2029)
      .mapToObj(y -> (y + " " + PolishDayOffUtils.getWorkingDays(y)))
      .forEach(System.out::println);
  }
}
