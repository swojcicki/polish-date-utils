package io.github.swojcicki.date;

import java.time.LocalDate;

/**
 * Created on: 01.05.2020 20:48 <br/>
 *
 * @author Slawek Wojcicki
 */
public final class DayOffUtils {

  private DayOffUtils() {
    throw new UnsupportedOperationException();
  }

  public static LocalDate getFirstWorkDayBefore(LocalDate date, DayOff dayOff) {
    if (dayOff.isDayOff()) {
      date = date.minusDays(1);
      getFirstWorkDayBefore(date, dayOff);
    }
    return date;
  }

  public static LocalDate getFirstWorkDayAfter(LocalDate date, DayOff dayOff) {
    if (dayOff.isDayOff()) {
      date = date.plusDays(1);
      getFirstWorkDayAfter(date, dayOff);
    }
    return date;
  }
}
