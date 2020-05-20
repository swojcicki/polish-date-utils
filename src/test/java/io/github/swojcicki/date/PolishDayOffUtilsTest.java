package io.github.swojcicki.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.stream.IntStream;

/**
 * Created on: 01.05.2020 21:42 <br/>
 *
 * @author Slawek Wojcicki
 */
public class PolishDayOffUtilsTest {

  @Test
  public void getWorkingDays_january_2020() {
    Assertions.assertEquals(21, PolishDayOffUtils.getWorkingDays(2020, 1));
  }

  @Test
  public void getWorkingDays_april_2020() {
    Assertions.assertEquals(21, PolishDayOffUtils.getWorkingDays(2020, Month.APRIL));
  }

  @Test
  public void getWorkingDays_year_2020() {
    Assertions.assertEquals(253, PolishDayOffUtils.getWorkingDays(2020));
  }

  @Test
  @Disabled("Test method for printing working days in years")
  public void getWorkingDays_years() {
    IntStream.range(2018, 2029)
      .mapToObj(y -> (y + " " + PolishDayOffUtils.getWorkingDays(y)))
      .forEach(System.out::println);
  }
}
