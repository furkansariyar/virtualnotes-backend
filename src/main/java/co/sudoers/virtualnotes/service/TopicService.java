package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateTopicDto;
import co.sudoers.virtualnotes.dto.GetTopicDto;
import co.sudoers.virtualnotes.dto.UpdateTopicDto;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    GetTopicDto saveTopic(CreateTopicDto createTopicDto);
    GetTopicDto getTopic(UUID topicId);
    GetTopicDto updateTopic(UUID topicId, UpdateTopicDto updateTopicDto);
    void deleteTopic(UUID topicId);

    List<GetTopicDto> getAllTopics();
}
