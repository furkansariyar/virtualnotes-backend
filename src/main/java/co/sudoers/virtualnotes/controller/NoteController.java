package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.dto.UpdateNoteDto;
import co.sudoers.virtualnotes.service.NoteService;
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
@RequestMapping("/api/v1/note")
@Api(value = "Note APIs")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @ApiOperation(value = "Save Note Operation", response = GetNoteDto.class)
    @PostMapping("/saveNote")
    public ResponseEntity<GetNoteDto> saveNote(@Valid @RequestBody CreateNoteDto createNoteDto) {
        return ResponseEntity.ok(noteService.saveNote(createNoteDto));
    }

    @ApiOperation(value = "Get Note By Id", response = GetNoteDto.class)
    @GetMapping("/getNoteById/{noteId}")
    public ResponseEntity<GetNoteDto> getNote(@PathVariable("noteId") UUID noteId) {
        return ResponseEntity.ok(noteService.getNote(noteId));
    }

    @ApiOperation(value = "Update Note By Id", response = GetNoteDto.class)
    @PutMapping("/updateNoteById/{noteId}")
    public ResponseEntity<GetNoteDto> updateNote(@PathVariable("noteId") UUID noteId, @Valid @RequestBody UpdateNoteDto updateNoteDto) {
        return ResponseEntity.ok(noteService.updateNote(noteId, updateNoteDto));
    }

    @ApiOperation(value = "Delete Note By Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteNoteById/{noteId}")
    public void deleteNote(@PathVariable("noteId") UUID noteId) {
        noteService.deleteNote(noteId);
    }

    @ApiOperation(value = "Get Notes By Topic Id", response = GetNoteDto.class, responseContainer = "List")
    @GetMapping("/getNotesByTopicId/{topicId}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByTopicId(@PathVariable("topicId") UUID topicId) {
        return ResponseEntity.ok(noteService.getNoteDtosByTopicId(topicId));
    }

    @ApiOperation(value = "Get Notes By User Id")
    @GetMapping("/getNotesByUserId/{userId}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByUserId(@PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(noteService.getNoteDtosByUserId(userId));
    }

    @ApiOperation(value = "Get Notes By User Id and Topic Id")
    @GetMapping("/getNotesByUserIdAndTopicId/{userId}/{topicId}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByUserIdAndTopicId(@PathVariable("userId") UUID userId,
                                                                          @PathVariable("topicId") UUID topicId) {
        return ResponseEntity.ok(noteService.getNotesByUserIdAndTopicId(userId, topicId));
    }

    @ApiOperation(value = "Search Notes By User Id and Searched Text")
    @GetMapping("/searchNotes/{userId}/{searchedText}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByUserIdAndTopicId(@PathVariable("userId") UUID userId,
                                                                          @PathVariable("searchedText") String searchedText) {
        return ResponseEntity.ok(noteService.searchNotes(userId, searchedText));
    }

}
