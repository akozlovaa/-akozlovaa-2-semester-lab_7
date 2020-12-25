package ua.lviv.iot.bank.manager;


import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.bank.model.AbstractBankService;


public class BankServiceManager {

  private List<AbstractBankService> services = new LinkedList<>();

  public void addServices(List<AbstractBankService> services) {

    this.services.addAll(services);
  }

  public void addService(AbstractBankService services) {

    this.services.add(services);
  }

  public List<AbstractBankService> findWithInterestRateInPercentsInRange(double minInterestRate, double maxInterestRate) {

    LinkedList<AbstractBankService> result = new LinkedList<>();
    for (AbstractBankService service : services) {
      if (service.getInterestRateInPercents() > minInterestRate && service.getInterestRateInPercents() < maxInterestRate) {
        result.add(service);
      }
    }
    return result;
  }
}
