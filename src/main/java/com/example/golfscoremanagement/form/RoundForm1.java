package com.example.golfscoremanagement.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RoundForm1 {

    //日付
    @NotEmpty(message = "PASSは必須です")
    private String playDateYear;

    @NotEmpty(message = "PASSは必須です")
    private String playDateMonth;

    @NotEmpty(message = "PASSは必須です")
    private String playDateDay;

    //コース
    @NotEmpty
    private String courseId;
}
