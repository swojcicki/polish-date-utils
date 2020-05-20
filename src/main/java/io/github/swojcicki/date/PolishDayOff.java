package io.github.swojcicki.date;

import java.time.LocalDate;

/**
 * Created on: 01.05.2020 19:31 <br/>
 *
 * @author Slawek Wojcicki
 */
public class PolishDayOff extends DayOff {

  protected PolishFeast polishFeast;

  protected PolishDayOff(LocalDate date) {
    super(date);
    update(date);
  }

  @Override
  protected void update(LocalDate date) {
    super.date = date;
    this.polishFeast = PolishFeast.of(date);
  }

  public static PolishDayOff of(LocalDate date) {
    return new PolishDayOff(date);
  }

  @Override
  public boolean isDayOff() {
    return super.isDayOff() || isPolishFeast();
  }

  @Override
  public boolean isDayOffNoFreeSaturday() {
    return super.isDayOff() || isPolishFeast();
  }

  public boolean isPolishFeast() {
    return polishFeast.isNewYear()
      || polishFeast.isEpiphany()
      || polishFeast.isEaster()
      || polishFeast.isLabourDay()
      || polishFeast.isConstitutionDay()
      || polishFeast.isCorpusChristi()
      || polishFeast.isAssumptionDay()
      || polishFeast.isAllSaintsDay()
      || polishFeast.isIndependenceDay()
      || polishFeast.isChristmas();
  }

  @Override
  public LocalDate firstWorkingDayBefore() {
    return super.firstWorkingDayBefore(of(date));
  }

  @Override
  public LocalDate firstWorkingDayAfter() {
    return super.firstWorkingDayAfter(of(date));
  }

  @Override
  public LocalDate plusWorkingDays(int plusWorkingDays) {
    return super.plusWorkingDays(of(date), plusWorkingDays);
  }

  @Override
  public LocalDate minusWorkingDays(int minusWorkingDays) {
    return super.minusWorkingDays(of(date), minusWorkingDays);
  }

  @Override
  public LocalDate findWorkingDayAfterDays(int plusDays) {
    return super.firstWorkingDayAfter(of(date.plusDays(plusDays)));
  }

  @Override
  public LocalDate findWorkingDayBeforeDays(int minusDays) {
    return super.firstWorkingDayBefore(of(date.minusDays(minusDays)));
  }
}
