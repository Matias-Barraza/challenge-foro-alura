package com.challengeForo.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findByActiveStatusTrue(Pageable pagination);

    Boolean existsByTitleAndMessage(String title, String message);

}
