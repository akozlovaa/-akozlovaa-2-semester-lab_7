package ua.lviv.iot.bank.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.bank.model.AbstractBankService;

import java.util.List;

public class BankServiceManagerTest extends BaseBankServiceManagerTest {

  private BankServiceManager bankServiceManager;

  @BeforeEach
  public void setUp() {
    bankServiceManager = new BankServiceManager();

    createAllServices();

    bankServiceManager.addServices(checkingAccounts);
    bankServiceManager.addServices(deposits);
    bankServiceManager.addServices(loans);
  }

  @Test
  public void testFindWithInterestRateInPercentsInRange() {
    List<AbstractBankService> service = bankServiceManager.findWithInterestRateInPercentsInRange(2.0, 15.0);
    assertEquals(3, service.size());

  }

}
