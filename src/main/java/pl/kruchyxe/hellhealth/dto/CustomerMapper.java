package pl.kruchyxe.hellhealth.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kruchyxe.hellhealth.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "firstname", target = "firstname", qualifiedByName = "firstname")
    @Mapping(source = "lastname", target = "lastname", qualifiedByName = "lastname")
    @Mapping(source = "age", target = "age", qualifiedByName = "age")
    @Mapping(source = "weight", target = "weight", qualifiedByName = "weight")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "gender")
    CustomerDto toDto(Customer customer);

    @Mapping(source = "firstname", target = "firstname", qualifiedByName = "firstname")
    @Mapping(source = "lastname", target = "lastname", qualifiedByName = "lastname")
    @Mapping(source = "age", target = "age", qualifiedByName = "age")
    @Mapping(source = "weight", target = "weight", qualifiedByName = "weight")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "gender")
    Customer toEntity(CustomerDto customerDto);

}
