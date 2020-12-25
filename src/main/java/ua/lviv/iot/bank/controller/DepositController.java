package ua.lviv.iot.bank.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.bank.model.Deposit;

@RequestMapping("/deposits")
@RestController
public class DepositController {

  private Map<Integer, Deposit> deposits = new HashMap<>();

  private AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<Deposit> getDeposits() {
    return new LinkedList<Deposit>(deposits.values());
  }
  

  @GetMapping(path = {"/{id}"})
  public ResponseEntity<Deposit> getDeposit(final @PathVariable("id") Integer depositId) {

    Deposit deposit;
    ResponseEntity<Deposit> status = (deposit = deposits.get(depositId)) == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(deposit, HttpStatus.OK);
    return status;

  }

  @PostMapping
  public Deposit createDeposit(final @RequestBody Deposit deposit) {
    deposit.setId(idCounter.incrementAndGet());
    deposits.put(deposit.getId(), deposit);
    return deposit;
  }

  @DeleteMapping(path = {"/{id}"})
  public ResponseEntity<Deposit> deleteDeposit(@PathVariable("id") Integer depositId) {
    HttpStatus status = deposits.remove(depositId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

    return ResponseEntity.status(status).build();
  }

  @PutMapping(path = {"/{id}"})
  public ResponseEntity<Deposit> updateDeposit(final @PathVariable("id") Integer depositId,
                                           final @RequestBody Deposit deposit) {
    deposit.setId(depositId);
    Deposit oldDeposit = deposits.replace(depositId, deposit);
    ResponseEntity<Deposit> status = oldDeposit == null
        ? new ResponseEntity<Deposit>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<Deposit>(oldDeposit, HttpStatus.OK);
    return status;
  }

}
