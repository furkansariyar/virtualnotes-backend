package co.sudoers.virtualnotes.util;

import co.sudoers.virtualnotes.dto.GetTopicDto;
import co.sudoers.virtualnotes.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Util {

    @Autowired
    private static TopicService topicService;

    public UUID getRandomUUID() {
        return UUID.randomUUID();
    }

    public static Boolean topicIsExist(UUID topicId) {
        List<GetTopicDto> allTopics = topicService.getAllTopics();
        for (GetTopicDto topic : allTopics) {
            if (topic.getTopicId() == topicId) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
