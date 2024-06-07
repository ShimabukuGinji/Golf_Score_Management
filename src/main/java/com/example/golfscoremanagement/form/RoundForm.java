package com.example.golfscoremanagement.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class RoundForm {

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

    //スコア
    @NotNull
    @Positive
    private String scoreHole1;

    @NotNull
    @Positive
    private String scoreHole2;

    @NotNull
    @Positive
    private String scoreHole3;

    @NotNull
    @Positive
    private String scoreHole4;

    @NotNull
    @Positive
    private String scoreHole5;

    @NotNull
    @Positive
    private String scoreHole6;

    @NotNull
    @Positive
    private String scoreHole7;

    @NotNull
    @Positive
    private String scoreHole8;

    @NotNull
    @Positive
    private String scoreHole9;

    @NotNull
    @Positive
    private String scoreHole10;

    @NotNull
    @Positive
    private String scoreHole11;

    @NotNull
    @Positive
    private String scoreHole12;

    @NotNull
    @Positive
    private String scoreHole13;

    @NotNull
    @Positive
    private String scoreHole14;

    @NotNull
    @Positive
    private String scoreHole15;

    @NotNull
    @Positive
    private String scoreHole16;

    @NotNull
    @Positive
    private String scoreHole17;

    @NotNull
    @Positive
    private String scoreHole18;

    private String scoreIn;
    private String scoreOut;
    private String score;

    //パット
    @NotNull
    @PositiveOrZero
    private String patHole1;

    @NotNull
    @PositiveOrZero
    private String patHole2;

    @NotNull
    @PositiveOrZero
    private String patHole3;

    @NotNull
    @PositiveOrZero
    private String patHole4;

    @NotNull
    @PositiveOrZero
    private String patHole5;

    @NotNull
    @PositiveOrZero
    private String patHole6;

    @NotNull
    @PositiveOrZero
    private String patHole7;

    @NotNull
    @PositiveOrZero
    private String patHole8;

    @NotNull
    @PositiveOrZero
    private String patHole9;

    @NotNull
    @PositiveOrZero
    private String patHole10;

    @NotNull
    @PositiveOrZero
    private String patHole11;

    @NotNull
    @PositiveOrZero
    private String patHole12;

    @NotNull
    @PositiveOrZero
    private String patHole13;

    @NotNull
    @PositiveOrZero
    private String patHole14;

    @NotNull
    @PositiveOrZero
    private String patHole15;

    @NotNull
    @PositiveOrZero
    private String patHole16;

    @NotNull
    @PositiveOrZero
    private String patHole17;

    @NotNull
    @PositiveOrZero
    private String patHole18;

    private String patIn;
    private String patOut;
    private String pat;

    //メモ・備考
    private String note;
}
