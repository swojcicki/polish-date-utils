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
    update(date);
  }

  protected void update(LocalDate date) {
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

  public LocalDate firstWorkingDayBefore() {
    return firstWorkingDayBefore(of(date));
  }

  public LocalDate firstWorkingDayAfter() {
    return firstWorkingDayAfter(of(date));
  }

  protected LocalDate firstWorkingDayBefore(DayOff dayOff) {
    while (dayOff.isDayOff()) {
      dayOff.update(dayOff.date.minusDays(1));
    }
    return dayOff.date;
  }

  protected LocalDate firstWorkingDayAfter(DayOff dayOff) {
    while (dayOff.isDayOff()) {
      dayOff.update(dayOff.date.plusDays(1));
    }
    return dayOff.date;
  }

  public LocalDate plusWorkingDays(int plusWorkingDays) {
    return plusWorkingDays(of(date), plusWorkingDays);
  }

  protected LocalDate plusWorkingDays(DayOff dayOff, int plusWorkingDays) {
    for (int i = 0; i < plusWorkingDays; i++) {
      dayOff.update(dayOff.date.plusDays(1));
      dayOff.update(firstWorkingDayAfter(dayOff));
    }
    return dayOff.date;
  }

  public LocalDate minusWorkingDays(int minusWorkingDays) {
    return minusWorkingDays(of(date), minusWorkingDays);
  }

  protected LocalDate minusWorkingDays(DayOff dayOff, int minusWorkingDays) {
    for (int i = 0; i < minusWorkingDays; i++) {
      dayOff.update(dayOff.date.minusDays(1));
      dayOff.update(firstWorkingDayBefore(dayOff));
    }
    return dayOff.date;
  }

  public LocalDate findWorkingDayAfterDays(int plusDays) {
    return firstWorkingDayAfter(of(date.plusDays(plusDays)));
  }

  public LocalDate findWorkingDayBeforeDays(int minusDays) {
    return firstWorkingDayBefore(of(date.minusDays(minusDays)));
  }
}
