package devdojo.exam.transactions.controller;


import devdojo.exam.transactions.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("transactions")
public class BankTransactionsController {

    private final BankService bankService;

    @GetMapping(path = "/{accountId}")
    public ResponseEntity<List<Map<String, Object>>> findByUser(@PathVariable long accountId) throws IOException {
        return bankService.customReponseForAccountId(accountId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<List<Map<String, Object>>> getAll() throws IOException {
        return bankService.customReponseAll();
    }
}
