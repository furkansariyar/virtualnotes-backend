package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.*;
import co.sudoers.virtualnotes.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/topic")
@Api(value = "Topic APIs")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @ApiOperation(value = "Save Topic Operation", response = GetTopicDto.class)
    @PostMapping("/saveTopic")
    public ResponseEntity<GetTopicDto> saveTopic(@Valid @RequestBody CreateTopicDto createTopicDto) {
        return ResponseEntity.ok(topicService.saveTopic(createTopicDto));
    }

    @ApiOperation(value = "Get Topic By Id", response = GetTopicDto.class)
    @GetMapping("/getTopicById/{topicId}")
    public ResponseEntity<GetTopicDto> getTopic(@PathVariable("topicId") UUID topicId) {
        return ResponseEntity.ok(topicService.getTopic(topicId));
    }

    @ApiOperation(value = "Update Topic By Id", response = GetTopicDto.class)
    @PutMapping("/updateTopicById/{topicId}")
    public ResponseEntity<GetTopicDto> updateTopic(@PathVariable("topicId") UUID topicId,
                                                   @Valid @RequestBody UpdateTopicDto updateTopicDto) {
        return ResponseEntity.ok(topicService.updateTopic(topicId, updateTopicDto));
    }

    @ApiOperation(value = "Delete Topic By Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteTopicById/{topicId}")
    public void deleteTopic(@PathVariable("topicId") UUID topicId) {
        topicService.deleteTopic(topicId);
    }

    @ApiOperation(value = "Get All Topics Operation")
    @GetMapping("/getAllTopics")
    public ResponseEntity<List<GetTopicDto>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    @ApiOperation(value = "Get All Topics By User Id")
    @GetMapping("/getAllTopicsByUserId/{userId}")
    public ResponseEntity<List<GetTopicDto>> getAllTopicsByUserId(@PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(topicService.getAllTopicsByUserId(userId));
    }

}
