package ua.lviv.iot.bank.manager;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.bank.model.AbstractBankService;
import ua.lviv.iot.bank.model.SortType;

public class BankServiceManagerUtils {

  public static final SortByIssueYear SERVICE_BY_ISSUE_YEAR_SORTED
      = new SortByIssueYear();

  public static void sortByIssueYearAscending(List<AbstractBankService> services,
                                                     SortType sortType) {
    services.sort(sortType == SortType.ASCENDING ? SERVICE_BY_ISSUE_YEAR_SORTED :
        SERVICE_BY_ISSUE_YEAR_SORTED.reversed());
  }

  public static void sortByIssueYearDescending(List<AbstractBankService> services,
                                                      SortType sortType) {
    services.sort(sortType == SortType.ASCENDING ? SERVICE_BY_ISSUE_YEAR_SORTED :
        SERVICE_BY_ISSUE_YEAR_SORTED.reversed());
  }

  public static void sortByMaintenanceFeeInUsDAscending(List<AbstractBankService> services,
                                                        SortType sortType) {
    Comparator<AbstractBankService> comparator
        = (firstAbstractBankService, secondAbstractBankService) ->
        (int) (firstAbstractBankService
            .getMaintenanceFeeInUsD() - secondAbstractBankService.getMaintenanceFeeInUsD());
    services.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());

  }

  public static void sortByMaintenanceFeeInUsDDescending(List<AbstractBankService> services,
                                                         SortType sortType) {
    Comparator<AbstractBankService> comparator =
        Comparator.comparing(AbstractBankService::getMaintenanceFeeInUsD);

    services.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());

  }

  public static void sortByInterestRateInPercentsAscending(List<AbstractBankService> services,
                                            SortType sortType) {
    Comparator<AbstractBankService> comparator = new Comparator<AbstractBankService>() {
      @Override
      public int compare(AbstractBankService firstAbstractBankService,
                         AbstractBankService secondAbstractBankService) {
        return (int) (firstAbstractBankService
            .getInterestRateInPercents() - secondAbstractBankService.getInterestRateInPercents());

      }
    };

    services.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
  }

  public static void sortByInterestRateInPercentsDescending(List<AbstractBankService> services,
                                             SortType sortType) {
    Comparator<AbstractBankService> comparator = new Comparator<AbstractBankService>() {
      @Override
      public int compare(AbstractBankService firstAbstractBankService,
                         AbstractBankService secondAbstractBankService) {
        return (int) (firstAbstractBankService
            .getInterestRateInPercents() - secondAbstractBankService.getInterestRateInPercents());

      }
    };

    services.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
  }

  static class SortByIssueYear implements Comparator<AbstractBankService>,
      Serializable {

    @Override
    public int compare(AbstractBankService firstAbstractBankService,
                       AbstractBankService secondAbstractBankService) {
      return firstAbstractBankService
          .getIssueYear() - secondAbstractBankService.getIssueYear();
    }
  }
}
