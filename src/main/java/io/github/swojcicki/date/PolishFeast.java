package io.github.swojcicki.date;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created on: 01.05.2020 18:18 <br/>
 *
 * @author Slawek Wojcicki
 */
public class PolishFeast extends Feast {

  protected PolishFeast(LocalDate date) {
    super(date);
  }

  public static PolishFeast of(LocalDate date) {
    return new PolishFeast(date);
  }

  /**
   * pl. Święto Pracy
   */
  public boolean isLabourDay() {
    return date.getMonth().equals(Month.MAY) && date.getDayOfMonth() == 1;
  }

  /**
   * pl. Święto Konstytucji
   */
  public boolean isConstitutionDay() {
    return date.getMonth().equals(Month.MAY) && date.getDayOfMonth() == 3;
  }

  /**
   * pl. Dzień Niepodległości
   */
  public boolean isIndependenceDay() {
    return date.getMonth().equals(Month.NOVEMBER) && date.getDayOfMonth() == 11;
  }

}
