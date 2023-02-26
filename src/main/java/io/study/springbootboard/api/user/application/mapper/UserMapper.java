package io.study.springbootboard.api.user.application.mapper;

import io.study.springbootboard.api.user.application.wrapper.UserSignupWrapper;
import io.study.springbootboard.api.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

   private final PasswordEncoder passwordEncoder;

   public User mapFrom(UserSignupWrapper wrapper) {

      String encryptPassword = passwordEncoder.encode(wrapper.getPassword());

      return User.generatedBasicUser(wrapper.getEmail(), encryptPassword);
   }
}
