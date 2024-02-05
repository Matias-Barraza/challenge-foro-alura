package com.challengeForo.domain.topic;

import java.time.LocalDateTime;

public record GetAllTopicsDTO(Long id, String title, String message, LocalDateTime creationDate, Boolean activeStatus, String author, String course) {

    public GetAllTopicsDTO(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getActiveStatus(),
                topic.getAuthor(),
                topic.getCourse()
        );
    }

}
