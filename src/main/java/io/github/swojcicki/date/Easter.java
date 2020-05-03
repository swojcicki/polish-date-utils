package io.github.swojcicki.date;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created on: 01.05.2020 13:28 <br/>
 *
 * @author Slawek Wojcicki
 */
public final class Easter {

  public static final int ALGORITHM_FIRST_VALID_YEAR = 1583;
  private static final int MARCH_DAYS_NUMBER = 31;

  private int year;
  private LocalDate easter;

  private Easter(int year) {
    this.year = year;
    this.easter = calculateEaster();
  }

  public static Easter of(int year) {
    return new Easter(year);
  }

  public LocalDate getDate() {
    return easter;
  }

  public int getYear() {
    return year;
  }

  private LocalDate calculateEaster() {
    if (year < ALGORITHM_FIRST_VALID_YEAR) {
      throw new IllegalArgumentException("Algorithm invalid before April " + ALGORITHM_FIRST_VALID_YEAR);
    }

    int golden = (year % 19) + 1;           /* E1: metonic cycle */
    int century = (year / 100) + 1;         /* E2: e.g. 1984 was in 20th C */
    int x = (3 * century / 4) - 12;         /* E3: leap year correction */
    int z = ((8 * century + 5) / 25) - 5;   /* E4: sync with moon's orbit */
    int d = (5 * year / 4) - x - 10;
    int epact = (11 * golden + 20 + z - x) % 30; /* E5: epact */
    if ((epact == 25 && golden > 11) || epact == 24) {
      epact++;
    }
    int n = 44 - epact;
    if (n < 21) { /* E6: */
      n += 30;
    }
    n += 7 - ((d + n) % 7);
    if (n > MARCH_DAYS_NUMBER) { /* E7: */
      return LocalDate.of(year, Month.APRIL, n - MARCH_DAYS_NUMBER); /* April */
    } else {
      return LocalDate.of(year, Month.MARCH, n);  /* March */
    }
  }
}
