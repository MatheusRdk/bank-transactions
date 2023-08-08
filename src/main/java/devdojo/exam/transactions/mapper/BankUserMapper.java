package devdojo.exam.transactions.mapper;

import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.requests.BankUserPostRequestBody;
import devdojo.exam.transactions.requests.BankUserPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class BankUserMapper {
    public static final BankUserMapper INSTANCE = Mappers.getMapper(BankUserMapper.class);

    public abstract BankUser toBankUser(BankUserPostRequestBody bankUserPostRequestBody);

    public abstract BankUser toBankUser(BankUserPutRequestBody bankUserPutRequestBody);
}
