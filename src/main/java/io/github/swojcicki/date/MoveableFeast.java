package io.github.swojcicki.date;

import java.time.LocalDate;

/**
 * Created on: 01.05.2020 17:49 <br/>
 *
 * @author Slawek Wojcicki
 */
public final class MoveableFeast {

  private LocalDate ashWednesday;
  private LocalDate palmSunday;
  private LocalDate easterSunday;
  private LocalDate easterMonday;
  private LocalDate misericordiaSunday;
  private LocalDate corpusChristi;

  private MoveableFeast(Easter easter) {
    this.easterSunday = easter.getDate();
    this.ashWednesday = easterSunday.minusDays(46);
    this.palmSunday = easterSunday.minusDays(7);
    this.easterMonday = easterSunday.plusDays(1);
    this.misericordiaSunday = easterSunday.plusDays(7);
    this.corpusChristi = easterSunday.plusDays(60);
  }

  public static MoveableFeast of(int year) {
    return new MoveableFeast(Easter.of(year));
  }

  public static MoveableFeast of(Easter easter) {
    return new MoveableFeast(easter);
  }

  /**
   * pl. Środa Popielcowa
   */
  public LocalDate getAshWednesday() {
    return ashWednesday;
  }

  public LocalDate getPalmSunday() {
    return palmSunday;
  }

  public LocalDate getEasterSunday() {
    return easterSunday;
  }

  public LocalDate getEasterMonday() {
    return easterMonday;
  }

  public LocalDate getMisericordiaSunday() {
    return misericordiaSunday;
  }

  /**
   * pl. Boże Ciało
   */
  public LocalDate getCorpusChristi() {
    return corpusChristi;
  }
}
