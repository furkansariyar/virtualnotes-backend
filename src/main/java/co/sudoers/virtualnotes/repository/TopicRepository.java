package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
    Topic getTopicByTopicId(UUID topicId);

    List<Topic> findAllByTopicNameContains(String searchedText);
}
