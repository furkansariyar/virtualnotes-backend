package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    Topic getTopicByTopicId(int topicId);
}
