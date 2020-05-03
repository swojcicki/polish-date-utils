package io.github.swojcicki.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created on: 01.05.2020 18:10 <br/>
 *
 * @author Slawek Wojcicki
 */
public class MoveableFeastTest {

  @Test
  public void ashWednesday_2020() {
    int year = 2020;
    LocalDate ashWednesday = MoveableFeast.of(year).getAshWednesday();
    Assertions.assertEquals(DayOfWeek.WEDNESDAY, ashWednesday.getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 2, 26), ashWednesday);
  }

  @Test
  public void palmSunday_2020() {
    int year = 2020;
    LocalDate palmSunday = MoveableFeast.of(year).getPalmSunday();
    Assertions.assertEquals(DayOfWeek.SUNDAY, palmSunday.getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 5), palmSunday);
  }

  @Test
  public void easterSunday_2020() {
    int year = 2020;
    LocalDate easterSunday = MoveableFeast.of(year).getEasterSunday();
    Assertions.assertEquals(DayOfWeek.SUNDAY, easterSunday.getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 12), easterSunday);
  }

  @Test
  public void easterMonday_2020() {
    int year = 2020;
    LocalDate easterMonday = MoveableFeast.of(year).getEasterMonday();
    Assertions.assertEquals(DayOfWeek.MONDAY, easterMonday.getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 13), easterMonday);
  }

  @Test
  public void misericordiaSunday_2020() {
    int year = 2020;
    LocalDate misericordiaSunday = MoveableFeast.of(year).getMisericordiaSunday();
    Assertions.assertEquals(DayOfWeek.SUNDAY, misericordiaSunday.getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 4, 19), misericordiaSunday);
  }

  @Test
  public void corpusChristi_2020() {
    int year = 2020;
    LocalDate corpusChristi = MoveableFeast.of(year).getCorpusChristi();
    Assertions.assertEquals(DayOfWeek.THURSDAY, corpusChristi.getDayOfWeek());
    Assertions.assertEquals(LocalDate.of(year, 6, 11), corpusChristi);
  }
}
