package com.example.golfscoremanagement.form;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String scoreHole1;

    //@NotEmpty
    private String scoreHole2;

    //@NotEmpty
    private String scoreHole3;

    //@NotEmpty
    private String scoreHole4;

    //@NotEmpty
    private String scoreHole5;

    //@NotEmpty
    private String scoreHole6;

    //@NotEmpty
    private String scoreHole7;

    //@NotEmpty
    private String scoreHole8;

    //@NotEmpty
    private String scoreHole9;

    //@NotEmpty
    private String scoreHole10;

    //@NotEmpty
    private String scoreHole11;

    //@NotEmpty
    private String scoreHole12;

    //@NotEmpty
    private String scoreHole13;

    //@NotEmpty
    private String scoreHole14;

    //@NotEmpty
    private String scoreHole15;

    //@NotEmpty
    private String scoreHole16;

    //@NotEmpty
    private String scoreHole17;

    //@NotEmpty
    private String scoreHole18;

    private String score1_9;
    private String score10_18;
    private String score;

    //パット
    //@NotEmpty
    private String patHole1;

    //@NotEmpty
    private String patHole2;

    //@NotEmpty
    private String patHole3;

    //@NotEmpty
    private String patHole4;

    //@NotEmpty
    private String patHole5;

    //@NotEmpty
    private String patHole6;

    //@NotEmpty
    private String patHole7;

    //@NotEmpty
    private String patHole8;

    //@NotEmpty
    private String patHole9;

    //@NotEmpty
    private String patHole10;

    //@NotEmpty
    private String patHole11;

    //@NotEmpty
    private String patHole12;

    //@NotEmpty
    private String patHole13;

    //@NotEmpty
    private String patHole14;

    //@NotEmpty
    private String patHole15;

    //@NotEmpty
    private String patHole16;

    //@NotEmpty
    private String patHole17;

    //@NotEmpty
    private String patHole18;

    private String pat1_9;
    private String pat10_18;
    private String pat;

    //メモ・備考
    private String note;
}
