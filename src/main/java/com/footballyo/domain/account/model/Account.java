package com.footballyo.domain.account.model;

import com.footballyo.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String email;
    private String password;


    private String name;
    private String nickname;
    private int age;
    private String birthday;
    private String gender; //?
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime joinDate;
    private LocalDateTime lastLoginDate;


}
