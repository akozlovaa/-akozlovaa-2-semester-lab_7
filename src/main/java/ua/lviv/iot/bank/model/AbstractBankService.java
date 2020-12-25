package ua.lviv.iot.bank.model;

public abstract class AbstractBankService extends AbstractBank {
  private int issueYear;
  private String customerName;
  private double interestRateInPercents;
  private String planName;
  private double maintenanceFeeInUsD;
  private ServiceType serviceType;
  private Integer id;

  public String myHeaders() {
    return "," + "issueYear,customerName,interestRateInPercents,planName,maintenanceFeeInUsD,serviceType";
  }

  public String toCSV() {
    return "," + issueYear + "," + customerName + "," + interestRateInPercents + ","
        + planName + "," + maintenanceFeeInUsD + "," + serviceType;
  }

  public int getIssueYear() {
	return issueYear;
  }

  public void setIssueYear(int issueYear) {
    this.issueYear = issueYear;
  }
  
  public String getCustomerName() {
	return customerName;
  }

  public void setCustomerName(String customerName) {
	this.customerName = customerName;
  }
  
  public double getInterestRateInPercents() {
	return interestRateInPercents;
  }

  public void setInterestRateInPercents(double interestRateInPercents) {
	this.interestRateInPercents = interestRateInPercents;
  }
	  
  public String getPlanName() {
	return planName;
  }

  public void setPlanName(String planName) {
	this.planName = planName;
  }
  
  public double getMaintenanceFeeInUsD() {
    return maintenanceFeeInUsD;
  }

  public void setMaintenanceFeeInUsD(double maintenanceFeeInUsD) {
    this.maintenanceFeeInUsD = maintenanceFeeInUsD;
  }

  public ServiceType getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AbstractBankService(String bankName, int issueYear, String customerName,
                                 double interestRateInPercents, String planName,
                                 double maintenanceFeeInUsD, ServiceType serviceType) {
	  super(bankName);
    this.issueYear = issueYear;
    this.customerName = customerName;
    this.interestRateInPercents = interestRateInPercents;
    this.planName = planName;
    this.maintenanceFeeInUsD = maintenanceFeeInUsD;
    this.serviceType = serviceType;
  }

  public AbstractBankService() {

  }
}
