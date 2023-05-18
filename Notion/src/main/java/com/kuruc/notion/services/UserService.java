package com.kuruc.notion.services;

import com.kuruc.notion.dtos.userdto.CreateUserDTO;
import com.kuruc.notion.dtos.userdto.GetUserDTO;
import com.kuruc.notion.models.User;
import java.util.Optional;

public interface UserService {
  void createUser(CreateUserDTO dto);

  Optional<User> getUser(GetUserDTO dto);
}
