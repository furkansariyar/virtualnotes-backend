package co.sudoers.virtualnotes.util.mappers;

import co.sudoers.virtualnotes.dto.CreateTopicDto;
import co.sudoers.virtualnotes.dto.GetTopicDto;
import co.sudoers.virtualnotes.entity.Topic;
import org.mapstruct.Mapper;

@Mapper
public interface TopicMapper {
    Topic createTopicDtoToTopic(CreateTopicDto createTopicDto);
    GetTopicDto topicToGetTopicDto(Topic topic);
    Topic getTopicDtoToTopic(GetTopicDto getTopicDto);
}
