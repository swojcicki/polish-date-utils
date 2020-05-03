package io.github.swojcicki.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created on: 01.05.2020 20:35 <br/>
 *
 * @author Slawek Wojcicki
 */
public class DayOff {

  protected LocalDate date;
  protected DayOff(LocalDate date) {
    this.date = date;
  }

  public static DayOff of(LocalDate date) {
    return new DayOff(date);
  }

  public boolean isSunday() {
    return date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
  }

  public boolean isSaturday() {
    return date.getDayOfWeek().equals(DayOfWeek.SATURDAY);
  }

  public boolean isWeekend() {
    return isSaturday() || isSunday();
  }

  public boolean isDayOff() {
    return isWeekend() || isAnotherDayOff();
  }

  public boolean isDayOffNoFreeSaturday() {
    return isSunday() || isAnotherDayOff();
  }

  /**
   * You can override this method.
   */
  public boolean isAnotherDayOff() {
    return false;
  }

}
