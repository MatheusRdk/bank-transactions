package devdojo.exam.transactions.controller;


import devdojo.exam.transactions.domain.BankTransaction;
import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.service.BankService;
import devdojo.exam.transactions.service.BankUserService;
import devdojo.exam.transactions.util.StringObjectMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("transactions")
public class BankTransactionsController {

    private final String file = "resources/transactions.json";
    private final BankService bankService;
    private final BankUserService bankUserService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Map<String, Object>>> findByUser(@PathVariable long id) throws IOException {
        List<BankTransaction> transactions = bankService.getTransactions(file);
        BankUser bankUser = bankUserService.findByIdOrThrowBadRequestException(id);
        List<Map<String, Object>> customResponse = new ArrayList<>();

        for (BankTransaction transaction : transactions) {
            if(bankUser.getTransactionsEncodedKeys().contains(transaction.getEncodedKey())){
                Map<String, Object> customTransaction = StringObjectMap.getStringObjectMap(transaction);
                customResponse.add(customTransaction);
            }
        }
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getAll() throws IOException {
        List<BankTransaction> transactions = bankService.getTransactions(file);
        List<Map<String, Object>> customResponse = new ArrayList<>();

        for (BankTransaction transaction : transactions) {
            Map<String, Object> customTransaction = StringObjectMap.getStringObjectMap(transaction);
            customResponse.add(customTransaction);
        }

        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/random/{id}")
    public ResponseEntity<Void> saveRandomTransaction(@PathVariable long id) throws IOException {
        BankUser bankUser = bankUserService.findByIdOrThrowBadRequestException(id);
        bankService.randomTransactionToUser(bankUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
