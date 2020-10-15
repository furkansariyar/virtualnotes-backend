package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateTopicDto;
import co.sudoers.virtualnotes.dto.GetTopicDto;
import co.sudoers.virtualnotes.dto.UpdateTopicDto;

import java.util.List;

public interface TopicService {
    GetTopicDto saveTopic(CreateTopicDto createTopicDto);
    GetTopicDto getTopic(int topicId);
    GetTopicDto updateTopic(int topicId, UpdateTopicDto updateTopicDto);
    void deleteTopic(int topicId);

    List<GetTopicDto> getAllTopics();
}
