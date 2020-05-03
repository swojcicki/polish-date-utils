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
}
