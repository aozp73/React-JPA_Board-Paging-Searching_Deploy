package com.example.demo.module.user.in_dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login_InDTO {

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "패스워드를 입력해주세요")
    private String password;
}
