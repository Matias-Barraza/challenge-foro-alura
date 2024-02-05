package com.challengeForo.domain.topic;

import java.time.LocalDateTime;

public record AnswerReadTopic(Long id, String title, String message, LocalDateTime creationDate, Boolean activeStatus, String author, String course) {



}
