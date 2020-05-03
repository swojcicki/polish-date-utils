package io.github.swojcicki.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created on: 01.05.2020 13:40 <br/>
 *
 * @author Slawek Wojcicki
 */
public class EasterTest {

  @Test
  public void easter_1582() {
    int year = Easter.ALGORITHM_FIRST_VALID_YEAR - 1;
    Exception exception = Assertions.assertThrows(
      IllegalArgumentException.class, () -> Easter.of(year));
    Assertions.assertEquals("Algorithm invalid before April 1583", exception.getMessage());
  }

  @Test
  public void easter_1583_in_april() {
    int year = Easter.ALGORITHM_FIRST_VALID_YEAR;
    Easter easter = Easter.of(year);
    Assertions.assertEquals(DayOfWeek.SUNDAY, easter.getDate().getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 10), easter.getDate());
    Assertions.assertEquals(year, easter.getYear());
  }

  @Test
  public void easter_2020_in_april() {
    int year = 2020;
    Easter easter = Easter.of(year);
    Assertions.assertEquals(DayOfWeek.SUNDAY, easter.getDate().getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 12), easter.getDate());
    Assertions.assertEquals(year, easter.getYear());
  }

  @Test
  public void easter_2024_in_march() {
    int year = 2024;
    Easter easter = Easter.of(year);
    Assertions.assertEquals(DayOfWeek.SUNDAY, easter.getDate().getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 3, 31), easter.getDate());
    Assertions.assertEquals(year, easter.getYear());
  }

  @Test
  public void easter_2170_in_april() {
    int year = 2170;
    Easter easter = Easter.of(year);
    Assertions.assertEquals(DayOfWeek.SUNDAY, easter.getDate().getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 1), easter.getDate());
    Assertions.assertEquals(year, easter.getYear());
  }

  @Test
  public void easter_4099() {
    int year = 4099;
    Easter easter = Easter.of(year);
    Assertions.assertEquals(DayOfWeek.SUNDAY, easter.getDate().getDayOfWeek());
  }

  /**
   * Some algorithms are for years between 1583 and 4099, but this work fine for 4200.
   */
  @Test
  public void easter_4200() {
    int year = 4200;
    Easter easter = Easter.of(year);
    Assertions.assertEquals(DayOfWeek.SUNDAY, easter.getDate().getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 20), easter.getDate()); // from internet
    Assertions.assertEquals(year, easter.getYear());
  }
}
