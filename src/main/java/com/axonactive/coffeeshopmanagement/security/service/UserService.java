package com.axonactive.coffeeshopmanagement.security.service;

import com.axonactive.coffeeshopmanagement.security.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
