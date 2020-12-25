package ua.lviv.iot.bank.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.bank.model.*;

public abstract class BaseBankServiceManagerTest {
  protected List<AbstractBankService> deposits;
  protected List<AbstractBankService> checkingAccounts;
  protected List<AbstractBankService> loans;

  public void createDeposits() {
    deposits = new LinkedList<AbstractBankService>();
    deposits.add(new Deposit("Monobank", 2020, "Andriian", 1.7d,
        "Iron", 0.0d, ServiceType.INVESTMENT, 500.0d));

    deposits.add(new Deposit("BoA", 2018, "Andrew", 3.5d,
        "Gold", 13.5d, ServiceType.COMMERCIAL, 10000.0d));
  }

  public void createCheckingAccounts() {
    checkingAccounts = new LinkedList<AbstractBankService>();
    checkingAccounts.add(new CheckingAccount("NBC", 2013, "Maksym", 0.2d,
        "Black", 8.75d, ServiceType.COMMERCIAL, 600.0d));
    checkingAccounts.add(new CheckingAccount("JPMorgan", 2021, "Jay", 0.3d,
        "Platinum", 50.0, ServiceType.INVESTMENT, 250000.0d));
  }

  public void createLoans() {
    loans = new LinkedList<AbstractBankService>();
    loans.add(new Loan("Privatbank", 2016, "Vasyl", 25.0d,
        "Dlia Vyplat", 68.0d, ServiceType.COMMERCIAL, LoanType.PERSONAL));
    loans.add(new Loan("Morgan Stanley", 2020, "Jon", 4.2d,
        "Silver", 5.0, ServiceType.INVESTMENT, LoanType.LONG_TERM));
    loans.add(new Loan("Goldman Sachs", 2019, "Mat", 5.0d,
        "Classic", 15.0d, ServiceType.INVESTMENT, LoanType.BUSINESS));
  }

  public void createAllServices() {
    createDeposits();
    createCheckingAccounts();
    createLoans();
  }
}
