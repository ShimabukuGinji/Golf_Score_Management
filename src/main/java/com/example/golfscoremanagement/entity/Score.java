package com.example.golfscoremanagement.entity;

public record Score(int id, int userId, String playDate, int courseId, int holeScoreId, String note) {
}
