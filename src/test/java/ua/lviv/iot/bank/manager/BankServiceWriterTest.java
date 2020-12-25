package ua.lviv.iot.bank.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.bank.model.AbstractBankService;
import ua.lviv.iot.bank.writer.BankServiceWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BankServiceWriterTest extends BaseBankServiceManagerTest {


  @BeforeEach
  public void setUp() {
    createAllServices();
  }

  @Test
  void testBankServiceWriter() {
    try (Writer csvWriter = new FileWriter(new File("bankService.csv"))) {
      BankServiceWriter writer = new BankServiceWriter();
      writer.setCsvWriter(csvWriter);
      writer.writeToFile(loans);
      writer.writeToFile(deposits);
      writer.writeToFile(checkingAccounts);
    } catch (Exception e) {
      fail("test failed");
    }
  }

  @Test
  public void testProperTextFormatting() {
    try (Writer csvWriter = new StringWriter()) {
      BankServiceWriter writer = new BankServiceWriter();
      writer.setCsvWriter(csvWriter);

      writer.writeToFile(loans);
      writer.writeToFile(deposits);
      writer.writeToFile(checkingAccounts);

      String expectedOutput = "";
      for (AbstractBankService loan : loans) {
        expectedOutput += loan.myHeaders() + "\n" + loan.toCSV() + "\n";
      }
      for (AbstractBankService deposit : deposits) {
        expectedOutput += deposit.myHeaders() + "\n" + deposit.toCSV() + "\n";
      }
      for (AbstractBankService checkingAccount : checkingAccounts) {
        expectedOutput += checkingAccount.myHeaders() + "\n" + checkingAccount.toCSV() + "\n";
      }
      assertEquals(expectedOutput, csvWriter.toString());
    } catch (Exception e) {
      fail("the test failed unexpected - try to write to the file ");
    }
  }
}
