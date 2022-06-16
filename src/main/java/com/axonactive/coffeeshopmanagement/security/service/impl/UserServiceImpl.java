package com.axonactive.coffeeshopmanagement.security.service.impl;

import com.axonactive.coffeeshopmanagement.security.repository.UserRepository;
import com.axonactive.coffeeshopmanagement.security.service.UserService;
import com.axonactive.coffeeshopmanagement.security.service.dto.UserDTO;
import com.axonactive.coffeeshopmanagement.security.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.toDtos(userRepository.findAll());
    }
}
