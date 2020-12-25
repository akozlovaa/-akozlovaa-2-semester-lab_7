package ua.lviv.iot.bank.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.bank.model.AbstractBankService;

public class BankServiceWriter {

  private Writer csvWriter;

  public void setCsvWriter(Writer csvWriter) {
    this.csvWriter = csvWriter;
  }

  public void writeToFile(List<AbstractBankService> services) throws IOException {
    for (AbstractBankService service : services) {
      csvWriter.write(service.myHeaders());
      csvWriter.write("\n");
      csvWriter.write(service.toCSV());
      csvWriter.write("\n");
      csvWriter.flush();
    }
  }
}
