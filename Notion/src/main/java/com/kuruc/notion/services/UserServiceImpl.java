package com.kuruc.notion.services;

import com.kuruc.notion.dtos.userdto.CreateUserDTO;
import com.kuruc.notion.dtos.userdto.GetUserDTO;
import com.kuruc.notion.models.User;
import com.kuruc.notion.repositories.UserRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
  private UserRepository userRepository;

  @Override
  public void createUser(CreateUserDTO dto) {
    var tempUser = User.builder()
        .id(UUID.randomUUID())
        .name(dto.getName())
        .email(dto.getEmail())
        .token(dto.getPassword())
        .build();

    userRepository.save(tempUser);
  }

  @Override
  public Optional<User> getUser(GetUserDTO dto) {
    return userRepository.findByEmail(dto.getEmail());
  }
}
