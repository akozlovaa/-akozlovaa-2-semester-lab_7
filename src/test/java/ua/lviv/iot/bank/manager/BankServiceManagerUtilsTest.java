package ua.lviv.iot.bank.manager;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.bank.model.SortType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankServiceManagerUtilsTest extends BaseBankServiceManagerTest {

  @Test
  public void testSortByIssueYearAscending() {
    createAllServices();
    BankServiceManagerUtils.sortByIssueYearAscending(loans, SortType.ASCENDING);
    assertEquals(2016, loans.get(0).getIssueYear());
  }

  @Test
  public void testSortByIssueYearDescending() {
    createAllServices();
    BankServiceManagerUtils.sortByIssueYearDescending(deposits, SortType.DESCENDING);
    assertEquals(2020, deposits.get(0).getIssueYear());
  }

  @Test
  public void testSortByMaintenanceFeeInUsDAscending() {
    createAllServices();
    BankServiceManagerUtils.sortByMaintenanceFeeInUsDAscending(checkingAccounts, SortType.ASCENDING);
    assertEquals(8.75d, checkingAccounts.get(0).getMaintenanceFeeInUsD());
  }

  @Test
  public void testSortByMaintenanceFeeInUsDDescending() {
    createAllServices();
    BankServiceManagerUtils.sortByMaintenanceFeeInUsDDescending(checkingAccounts, SortType.DESCENDING);
    assertEquals(50.0d, checkingAccounts.get(0).getMaintenanceFeeInUsD());
  }

  @Test
  public void testSortByInterestRateInPercentsAscending() {
    createAllServices();
    BankServiceManagerUtils.sortByInterestRateInPercentsAscending(loans, SortType.ASCENDING);
    assertEquals(4.2d, loans.get(0).getInterestRateInPercents());

  }

  @Test
  public void testSortByInterestRateInPercentsDescending() {
    createAllServices();
    BankServiceManagerUtils.sortByInterestRateInPercentsDescending(loans, SortType.DESCENDING);
    assertEquals(25.0d, loans.get(0).getInterestRateInPercents());
  }


}
