package ua.lviv.iot.bank.model;

public class Loan extends AbstractBankService {
  private LoanType loanType;

  @Override
  public String myHeaders() {
    return super.myHeaders() + "," + "loanType";
  }

  @Override
  public String toCSV() {
    return super.toCSV() + "," + loanType;
  }

  public LoanType getLoanType() {
    return loanType;
  }

  public void setLoanType(LoanType loanType) {
    this.loanType = loanType;
  }

  public Loan(String bankName, int issueYear, String customerName, double interestRateInPercents, String planName,
                 double maintenanceFeeInUsD, ServiceType serviceType, LoanType loanType) {
    super(bankName, issueYear, customerName, interestRateInPercents, planName, maintenanceFeeInUsD, serviceType);
    this.loanType = loanType;
  }
}
