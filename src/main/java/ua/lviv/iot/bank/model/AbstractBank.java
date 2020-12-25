package ua.lviv.iot.bank.model;

public abstract class AbstractBank {
  private String bankName;

  public String myHeaders() {
    return "bankName";
  }

  public String toCSV() {
    return bankName;
  }

  public String getName() {
    return bankName;
  }

  public void setName(String bankName) {
    this.bankName = bankName;
  }

  public AbstractBank(String bankName) {
    super();
    this.bankName = bankName;
  }

  public AbstractBank() {

  }
}
