package devdojo.exam.transactions.service;

import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.exceptions.BadRequestException;
import devdojo.exam.transactions.mapper.BankUserMapper;
import devdojo.exam.transactions.repository.BankUserRepository;
import devdojo.exam.transactions.requests.BankUserPostRequestBody;
import devdojo.exam.transactions.requests.BankUserPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankUserService {
    private final BankUserRepository bankUserRepository;

    public BankUser findByIdOrThrowBadRequestException(long id){
        return bankUserRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found."));
    }

    public List<BankUser> listAll(){
        return bankUserRepository.findAll();
    }

    public BankUser save(final BankUserPostRequestBody bankUserPostRequestBody){
        final var bankUser = BankUser.builder()
                .name(bankUserPostRequestBody.getName())
                .build();
        return bankUserRepository.save(bankUser);
    }

    public void delete(long id){
        bankUserRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(BankUserPutRequestBody bankUserPutRequestBody) {
        BankUser savedBankUser = findByIdOrThrowBadRequestException(bankUserPutRequestBody.getId());
        BankUser bankUser = BankUserMapper.INSTANCE.toBankUser(bankUserPutRequestBody);
        bankUser.setId(savedBankUser.getId());
        bankUserRepository.save(bankUser);
    }
}
