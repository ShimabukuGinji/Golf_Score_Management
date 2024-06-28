package com.example.golfscoremanagement.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class NewUserForm {

    @NotEmpty(message = "名前は必須です")
    private String name;

    @NotEmpty(message = "ニックネームは必須です")
    private String displayName;

    @NotEmpty(message = "ログインIDは必須です")
    private String loginId;

    @NotEmpty(message = "パスワードは必須です")
    private String password;

}
