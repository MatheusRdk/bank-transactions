package devdojo.exam.transactions.controller;

import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.requests.BankUserPostRequestBody;
import devdojo.exam.transactions.requests.BankUserPutRequestBody;
import devdojo.exam.transactions.service.BankUserService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Log4j2
@RequiredArgsConstructor //
public class BankUserController {

    private final BankUserService bankUserService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<BankUser>> listAll(){
        return new ResponseEntity<>(bankUserService.listAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankUser> save(@RequestBody BankUserPostRequestBody bankUserPostRequestBody){
        return new ResponseEntity<>(bankUserService.save(bankUserPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        bankUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody BankUserPutRequestBody bankUserPutRequestBody){
        bankUserService.replace(bankUserPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
