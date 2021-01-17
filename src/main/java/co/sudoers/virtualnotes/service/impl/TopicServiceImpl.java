package co.sudoers.virtualnotes.service.impl;

import co.sudoers.virtualnotes.dto.*;
import co.sudoers.virtualnotes.entity.Note;
import co.sudoers.virtualnotes.entity.Topic;
import co.sudoers.virtualnotes.repository.TopicRepository;
import co.sudoers.virtualnotes.service.NoteService;
import co.sudoers.virtualnotes.service.TopicService;
import co.sudoers.virtualnotes.util.mappers.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final NoteService noteService;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository, TopicMapper topicMapper, @Lazy NoteService noteService) {
        this.topicRepository = topicRepository;
        this.topicMapper = topicMapper;
        this.noteService = noteService;
    }

    @Override
    public GetTopicDto saveTopic(CreateTopicDto createTopicDto) {
        Topic topic = topicMapper.createTopicDtoToTopic(createTopicDto);
        topic = topicRepository.save(topic);
        return topicMapper.topicToGetTopicDto(topic);
    }

    @Override
    public GetTopicDto getTopic(UUID topicId) {
        Topic topic = topicRepository.getTopicByTopicId(topicId);
        if (topic == null) {
            throw new IllegalArgumentException("Topic Id is not exist");
        }
        return topicMapper.topicToGetTopicDto(topic);
    }

    @Override
    public GetTopicDto updateTopic(UUID topicId, UpdateTopicDto updateTopicDto) {
        Topic topic = topicRepository.getTopicByTopicId(topicId);
        if (topic == null) {
            throw new IllegalArgumentException("Topic Id is not exist");
        }
        if (updateTopicDto.getTopicName() != null) {
            topic.setTopicName(updateTopicDto.getTopicName());
        }
        topic = topicRepository.save(topic);
        return topicMapper.topicToGetTopicDto(topic);
    }

    @Override
    public void deleteTopic(UUID topicId) {
        Topic topic = topicRepository.getTopicByTopicId(topicId);
        if (topic == null) {
            throw new IllegalArgumentException("Topic Id is not exist");
        }
        // TODO: 15.10.2020 manuel olarak baglantılı noteları sildim, otomatik yapmayı dene. 
        // Set related notes' topic value to null
        List<Note> noteList = noteService.getNotesByTopicId(topicId);
        for (Note note : noteList) {
            note.setTopic(null);
        }
        // Delete topic
        topicRepository.delete(topic);
    }

    @Override
    public List<GetTopicDto> getAllTopics() {
        List<Topic> topicList = topicRepository.findAll();
        return topicMapper.topicListToGetTopicDtoList(topicList);
    }

    @Override
    public List<GetTopicDto> getAllTopicsByUserId(UUID userId) {
        List<Note> userNoteList = this.noteService.getNotesByUserId(userId);
        List<GetTopicDto> getTopicDtoList = new ArrayList<>();
        List<UUID> idList = new ArrayList<>();
        for (Note note : userNoteList) {
            if (idList.size() == 0) {
                idList.add(note.getTopic().getTopicId());
                getTopicDtoList.add(topicMapper.topicToGetTopicDto(note.getTopic()));
            } else if(!idList.contains(note.getTopic().getTopicId())) {
                getTopicDtoList.add(topicMapper.topicToGetTopicDto(note.getTopic()));
                idList.add(note.getTopic().getTopicId());
            }
        }
        return getTopicDtoList;
    }

    @Override
    public List<UUID> searchTopics(List<GetTopicDto> topics, String searchedText) {
        List<Topic> foundTopics = topicRepository.findAllByTopicNameContains(searchedText);
        List<UUID> foundTopicsIDs = foundTopics.stream()
                .map(Topic::getTopicId)
                .collect(Collectors.toList());
        List<UUID> userTopicsIDs = topics.stream()
                .map(GetTopicDto::getTopicId)
                .collect(Collectors.toList());
        List<UUID> returnedTopicIdList = new ArrayList<>();
        for (UUID foundTopicsID : foundTopicsIDs) {
            if (userTopicsIDs.contains(foundTopicsID)) {
                returnedTopicIdList.add(foundTopicsID);
            }
        }
        return returnedTopicIdList;
    }
}
