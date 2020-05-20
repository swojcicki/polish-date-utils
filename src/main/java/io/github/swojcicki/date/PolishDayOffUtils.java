package io.github.swojcicki.date;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created on: 01.05.2020 20:01 <br/>
 *
 * @author Slawek Wojcicki
 */
public final class PolishDayOffUtils {

  private PolishDayOffUtils() {
    throw new UnsupportedOperationException();
  }

  public static int getWorkingDays(int year) {
    LocalDate date = LocalDate.of(year, 1, 1);
    int workingDays = 0;
    while (date.getYear() == year) {
      workingDays = countWorkingDays(date, workingDays);
      date = date.plusDays(1);
    }
    return workingDays;
  }

  public static int getWorkingDays(int year, int month) {
    LocalDate date = LocalDate.of(year, month, 1);
    int workingDays = 0;
    while (date.getMonthValue() == month) {
      workingDays = countWorkingDays(date, workingDays);
      date = date.plusDays(1);
    }
    return workingDays;
  }

  public static int getWorkingDays(int year, Month month) {
    return getWorkingDays(year, month.getValue());
  }

  private static int countWorkingDays(LocalDate date, int workingDays) {
    PolishDayOff dayOff = PolishDayOff.of(date);
    if (!dayOff.isDayOff()) {
      workingDays++;
    } else if (dayOff.isPolishFeast() && dayOff.isSaturday()) {
      workingDays--;
    }
    return workingDays;
  }

}
