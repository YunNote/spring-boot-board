package io.study.springbootboard.api.user.domain;

import io.study.springbootboard.api.user.application.mapper.UserMapper;
import io.study.springbootboard.api.user.application.validate.UserValidator;
import io.study.springbootboard.api.user.application.wrapper.UserSigninWrapper;
import io.study.springbootboard.api.user.application.wrapper.UserSignupWrapper;
import io.study.springbootboard.api.user.domain.entity.User;
import io.study.springbootboard.api.user.domain.repository.UserQueryRepository;
import io.study.springbootboard.api.user.domain.repository.UserRepository;
import io.study.springbootboard.web.exception.types.UserNotMatchedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataproviderImpl implements  UserDataprovider{

   private final UserRepository userRepository;
   private final UserQueryRepository userQueryRepository;
   private final UserMapper userMapper;
   private final UserValidator userValidator;


   @Override
   public void loginBasicUser(UserSigninWrapper wrapper) {

      User user = userQueryRepository.findUsername(wrapper.getEmail())
              .orElseThrow(() ->  new UserNotMatchedException());

      user.loginValidate(userValidator, wrapper.getPassword());

   }

   @Override
   public void registed(UserSignupWrapper wrapper) {

      User user = userMapper.mapFrom(wrapper);
      user.validator(userValidator);

      userRepository.save(user);
   }
}
