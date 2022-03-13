package com.faz.idb.mapper;

import com.faz.idb.dto.AbstractUserDto;
import com.faz.idb.dto.AdviserDto;
import com.faz.idb.dto.CustomerDto;
import com.faz.idb.models.AbstractUser;
import com.faz.idb.models.Adviser;
import com.faz.idb.models.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


/**
 * @author FAZLIU Arber
 * @date 04.03.22
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface AbstractUserMapper {
    AbstractUserMapper INSTANCE = Mappers.getMapper(AbstractUserMapper.class);

    /**
     * @param userDto dto to map
     * @return Account entity
     */

    @SubclassMapping(source = CustomerDto.class, target = Customer.class)
    @SubclassMapping(source = AdviserDto.class, target = Adviser.class)
    AbstractUser toEntity(AbstractUserDto userDto);


    /**
     * @param user entity to map to an AccountDto
     * @return AbstractUser entity
     */

    @SubclassMapping(source = Customer.class, target = CustomerDto.class)
    @SubclassMapping(source = Adviser.class, target = AdviserDto.class)
    AbstractUserDto toDto(AbstractUser user);

    /**
     * @param dto that will be converted to entity
     * @return Customer entity
     */
    Customer customerDtoToEntity(CustomerDto dto);

    /**
     * @param customer dto to map
     * @return Customer entity
     */
    CustomerDto customerToDto(Customer customer);

    /**
     * @param dto dto that wille converted to entity
     * @return Adviser entity
     */
    Adviser adviserDtoToEntity(AdviserDto dto);

    /**
     * @param adviser dto to map
     * @return Adviser entity
     */
    AdviserDto adviserToDto(Adviser adviser);
}
