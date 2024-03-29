package io.study.springbootboard.api.user.domain.event;

import lombok.Getter;

@Getter
public class SignupEvent {

   private final String email;

   public SignupEvent(String email) {
      this.email = email;
   }

   public static SignupEvent of(String email) {
      return new SignupEvent(email);
   }
}
