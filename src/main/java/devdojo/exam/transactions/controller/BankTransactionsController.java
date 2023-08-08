package devdojo.exam.transactions.controller;


import devdojo.exam.transactions.repository.BankUserRepository;
import devdojo.exam.transactions.service.BankUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class BankTransactionsController {

    private final BankUserService bankUserService;
}
