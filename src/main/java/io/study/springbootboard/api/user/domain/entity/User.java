package io.study.springbootboard.api.user.domain.entity;


import io.study.springbootboard.web.base.entity.BaseEntity;
import io.study.springbootboard.web.base.types.Authority;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String email;
   private String password;

   @Enumerated(EnumType.STRING)
   private Authority authority;
}