package com.example.golfscoremanagement.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {

    @NotEmpty(message = "IDは必須です")
    private String loginId;

    @NotEmpty(message = "パスワードは必須です")
    private String password;
}
