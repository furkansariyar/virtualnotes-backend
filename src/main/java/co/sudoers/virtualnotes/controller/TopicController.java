package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.*;
import co.sudoers.virtualnotes.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/saveTopic")
    public ResponseEntity<GetTopicDto> saveTopic(@Valid @RequestBody CreateTopicDto createTopicDto) {
        return ResponseEntity.ok(topicService.saveTopic(createTopicDto));
    }

    @GetMapping("/getTopicById/{topicId}")
    public ResponseEntity<GetTopicDto> getTopic(@PathVariable("topicId") int topicId) {
        return ResponseEntity.ok(topicService.getTopic(topicId));
    }

    @PutMapping("/updateTopicById/{topicId}")
    public ResponseEntity<GetTopicDto> updateTopic(@PathVariable("topicId") int topicId,
                                                   @Valid @RequestBody UpdateTopicDto updateTopicDto) {
        return ResponseEntity.ok(topicService.updateTopic(topicId, updateTopicDto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteTopicById/{topicId}")
    public void deleteTopic(@PathVariable("topicId") int topicId) {
        topicService.deleteTopic(topicId);
    }

    @GetMapping("/getAllTopics")
    public ResponseEntity<List<GetTopicDto>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

}
