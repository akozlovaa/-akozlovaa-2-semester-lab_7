package ua.lviv.iot.bank.model;

public class CheckingAccount extends AbstractBankService {
  private double balanceInUsD;

  @Override
  public String myHeaders() {
    return super.myHeaders() + "," + "balanceInUsD";
  }

  @Override
  public String toCSV() {
    return super.toCSV() + "," + balanceInUsD;
  }

  public double getBalanceInUsD() {
    return balanceInUsD;
  }

  public void setBalanceInUsD(int balanceInUsD) {
    this.balanceInUsD = balanceInUsD;
  }

  public CheckingAccount(String bankName, int issueYear, String customerName, double interestRateInPercents, String planName,
                        double maintenanceFeeInUsD, ServiceType serviceType, double balanceInUsD) {
    super(bankName, issueYear, customerName, interestRateInPercents, planName, maintenanceFeeInUsD, serviceType);
    this.balanceInUsD = balanceInUsD;
  }
}
