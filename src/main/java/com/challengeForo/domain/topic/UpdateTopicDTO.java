package com.challengeForo.domain.topic;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicDTO(@NotNull Long id, String title, String message, String author, String course) {



}
