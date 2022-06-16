package com.axonactive.coffeeshopmanagement.security.service.mapper;

import com.axonactive.coffeeshopmanagement.security.entity.User;
import com.axonactive.coffeeshopmanagement.security.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toDto(User user);

    List<UserDTO> toDtos(List<User> users);
}
