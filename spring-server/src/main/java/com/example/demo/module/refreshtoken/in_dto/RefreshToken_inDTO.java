package com.example.demo.module.refreshtoken.in_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken_inDTO {

    @NotBlank
    String refreshToken;
}
