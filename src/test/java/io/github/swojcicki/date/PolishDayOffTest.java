package io.github.swojcicki.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Created on: 19.05.2020 10:06 <br/>
 *
 * @author Slawek Wojcicki
 */
public class PolishDayOffTest {

  @Test
  public void firstWorkingDayAfter_4_jan() {
    LocalDate expected = LocalDate.of(2020, 1, 7);
    LocalDate actual = PolishDayOff.of(LocalDate.of(2020, 1, 4)).firstWorkingDayAfter();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void firstWorkingDayBefore_6_jan() {
    LocalDate expected = LocalDate.of(2020, 1, 3);
    LocalDate actual = PolishDayOff.of(LocalDate.of(2020, 1, 6)).firstWorkingDayBefore();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void plusWorkingDays_loOrEqZero() {
    Assertions.assertEquals(LocalDate.now(),
      PolishDayOff.of(LocalDate.now()).plusWorkingDays(0));
    Assertions.assertEquals(LocalDate.now(),
      PolishDayOff.of(LocalDate.now()).plusWorkingDays(-1));
  }

  @Test
  public void plusWorkingDays_3_Jan_2_days() {
    Assertions.assertEquals(LocalDate.of(2020, 1, 8),
      PolishDayOff.of(LocalDate.of(2020, 1, 3)).plusWorkingDays(2));
  }

  @Test
  public void minusWorkingDays_7_Jan_2_days() {
    Assertions.assertEquals(LocalDate.of(2020, 1, 2),
      PolishDayOff.of(LocalDate.of(2020, 1, 7)).minusWorkingDays(2));
  }

  @Test
  public void courtDeadlines() {
    try (Stream<String> stream = Files.lines(Paths.get("src", "test", "resources", "court.csv"))) {
      stream
        .filter(line -> !line.trim().startsWith("#"))
        .forEach(line -> assertLine(line, 7, 7));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void admDeadlines() {
    try (Stream<String> stream = Files.lines(Paths.get("src", "test", "resources", "adm.csv"))) {
      stream
        .filter(line -> !line.trim().startsWith("#"))
        .forEach(line -> assertLine(line, 7, 6));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void assertLine(String line, int noticeDays, int returnDays) {
    String[] dates = line.split(";");
    LocalDate firstNoticeDate = LocalDate.parse(dates[0]);
    LocalDate secondNotice = PolishDayOff.of(firstNoticeDate).findWorkingDayAfterDays(noticeDays);
    LocalDate secondNoticeRealisation = PolishDayOff.of(secondNotice).findWorkingDayAfterDays(1);
    LocalDate storageDate = PolishDayOff.of(secondNoticeRealisation).findWorkingDayAfterDays(returnDays);
    LocalDate returnDate = PolishDayOff.of(storageDate).findWorkingDayAfterDays(1);

    Assertions.assertEquals(LocalDate.parse(dates[1]), secondNoticeRealisation, "Second notice realisation date wrong for " + firstNoticeDate);
    Assertions.assertEquals(LocalDate.parse(dates[2]), storageDate, "Storage date wrong for " + firstNoticeDate);
    Assertions.assertEquals(LocalDate.parse(dates[3]), returnDate, "Return date wrong for " + firstNoticeDate);
  }


}
