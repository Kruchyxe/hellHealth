package pl.kruchyxe.hellhealth.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kruchyxe.hellhealth.model.GroceryList;
import pl.kruchyxe.hellhealth.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "firstname", target = "firstname", qualifiedByName = "firstname")
    @Mapping(source = "lastname", target = "lastname", qualifiedByName = "lastname")
    @Mapping(source = "age", target = "age", qualifiedByName = "age")
    @Mapping(source = "weight", target = "weight", qualifiedByName = "weight")
    UserDto toDto(User user);

    @Mapping(source = "firstname", target = "firstname", qualifiedByName = "firstname")
    @Mapping(source = "lastname", target = "lastname", qualifiedByName = "lastname")
    @Mapping(source = "age", target = "age", qualifiedByName = "age")
    @Mapping(source = "weight", target = "weight", qualifiedByName = "weight")
    User toEntity(UserDto userDto);

}
