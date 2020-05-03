package io.github.swojcicki.date;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created on: 01.05.2020 21:13 <br/>
 *
 * @author root
 */
public class Feast {

  protected LocalDate date;
  protected MoveableFeast moveableFeast;

  protected Feast(LocalDate date) {
    this.date = date;
    this.moveableFeast = MoveableFeast.of(date.getYear());
  }

  public boolean isNewYear() {
    return date.getMonth().equals(Month.JANUARY) && date.getDayOfMonth() == 1;
  }

  /**
   * pl. Święto Trzech Króli
   */
  public boolean isEpiphany() {
    return date.getMonth().equals(Month.JANUARY) && date.getDayOfMonth() == 6;
  }

  public boolean isAshWednesday(){
    return date.isEqual(moveableFeast.getAshWednesday());
  }

  public boolean isPalmSunday() {
    return date.isEqual(moveableFeast.getPalmSunday());
  }

  public boolean isEasterSunday() {
    return date.isEqual(moveableFeast.getEasterSunday());
  }

  public boolean isEasterMonday() {
    return date.isEqual(moveableFeast.getEasterMonday());
  }

  /**
   * pl. Boże Ciało
   */
  public boolean isCorpusChristi() {
    return date.isEqual(moveableFeast.getCorpusChristi());
  }

  /**
   * pl. Wniebowzięcie NMP
   */
  public boolean isAssumptionDay() {
    return date.getMonth().equals(Month.AUGUST) && date.getDayOfMonth() == 15;
  }

  /**
   * pl. Wszystkich Świętych
   */
  public boolean isAllSaintsDay() {
    return date.getMonth().equals(Month.NOVEMBER) && date.getDayOfMonth() == 1;
  }

  public boolean isChristmasDay() {
    return date.getMonth().equals(Month.DECEMBER) && date.getDayOfMonth() == 25;
  }

  public boolean isBoxingDay() {
    return date.getMonth().equals(Month.DECEMBER) && date.getDayOfMonth() == 26;
  }

  public boolean isChristmas() {
    return isChristmasDay() || isBoxingDay();
  }

  public boolean isEaster() {
    return isEasterSunday() || isEasterMonday();
  }


}
