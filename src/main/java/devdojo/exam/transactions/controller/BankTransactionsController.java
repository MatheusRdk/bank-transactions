package devdojo.exam.transactions.controller;


import devdojo.exam.transactions.domain.BankTransaction;
import devdojo.exam.transactions.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("transactions")
public class BankTransactionsController {

    private final BankService bankService;

    @GetMapping(path = "/{accountId}")
    @PreAuthorize("principal.accountId == #accountId")
    public ResponseEntity<List<BankTransaction>> findByUser(@PathVariable long accountId) throws IOException {
        return bankService.responseForAccountId(accountId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<List<BankTransaction>> getAll() throws IOException {
        return bankService.responseAll();
    }
}
