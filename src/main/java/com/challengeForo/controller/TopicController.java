package com.challengeForo.controller;

import com.challengeForo.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/topics")
public class TopicController {

    private final ITopicRepository iTopicRepository;

    @PostMapping
    public ResponseEntity<AnswerCreateTopic> createTopic(@RequestBody @Valid CreateTopicDTO createTopicDTO, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = iTopicRepository.save(new Topic(createTopicDTO));
        AnswerCreateTopic answerCreateTopic = new AnswerCreateTopic(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getActiveStatus(), topic.getAuthor(), topic.getCourse());
        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(answerCreateTopic);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AnswerReadTopic> singleTopic(@PathVariable Long id) {
        Topic topic = iTopicRepository.getReferenceById(id);
        AnswerReadTopic answerReadTopic = new AnswerReadTopic(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getActiveStatus(), topic.getAuthor(), topic.getCourse());
        return ResponseEntity.ok(answerReadTopic);
    }


    @GetMapping
    public ResponseEntity<Page<GetAllTopicsDTO>> allTopics(@PageableDefault(size = 5) Pageable pagination) {
        return ResponseEntity.ok(iTopicRepository.findByActiveStatusTrue(pagination).map(GetAllTopicsDTO::new));
    }


    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid UpdateTopicDTO updateTopicDTO) {
        Topic topic = iTopicRepository.getReferenceById(updateTopicDTO.id());
        topic.updateTopic(updateTopicDTO);
        return ResponseEntity.ok(new AnswerUpdateTopic(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getAuthor(), topic.getCourse()));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Topic topic = iTopicRepository.getReferenceById(id);
        topic.closeTopic();
        return ResponseEntity.noContent().build();
    }


}
