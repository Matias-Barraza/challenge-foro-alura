package com.challengeForo.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "active_status")
    private Boolean activeStatus;

    private String author;
    private String course;


    public Topic(CreateTopicDTO createTopicDTO) {
        this.title = createTopicDTO.title();
        this.message = createTopicDTO.message();
        this.creationDate = LocalDateTime.now();
        this.activeStatus = true;
        this.author = createTopicDTO.author();
        this.course = createTopicDTO.course();
    }


    public void updateTopic(UpdateTopicDTO updateTopicDTO) {
        if (updateTopicDTO.title() != null) {
            this.title = updateTopicDTO.title();
        }
        if (updateTopicDTO.message() != null) {
            this.message = updateTopicDTO.message();
        }
        if (updateTopicDTO.author() != null) {
            this.author = updateTopicDTO.author();
        }
        if (updateTopicDTO.course() != null) {
            this.course = updateTopicDTO.course();
        }
    }

    public void closeTopic() {
        this.activeStatus = false;
    }

}