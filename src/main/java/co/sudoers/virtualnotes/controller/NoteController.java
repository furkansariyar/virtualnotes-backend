package co.sudoers.virtualnotes.controller;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.dto.UpdateNoteDto;
import co.sudoers.virtualnotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/saveNote")
    public ResponseEntity<GetNoteDto> saveNote(@Valid @RequestBody CreateNoteDto createNoteDto) {
        return ResponseEntity.ok(noteService.saveNote(createNoteDto));
    }

    @GetMapping("/getNoteById/{noteId}")
    public ResponseEntity<GetNoteDto> getNote(@PathVariable("noteId") int noteId) {
        return ResponseEntity.ok(noteService.getNote(noteId));
    }

    @PutMapping("/updateNoteById/{noteId}")
    public ResponseEntity<GetNoteDto> updateNote(@PathVariable("noteId") int noteId, @Valid @RequestBody UpdateNoteDto updateNoteDto) {
        return ResponseEntity.ok(noteService.updateNote(noteId, updateNoteDto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteNoteById/{noteId}")
    public void deleteNote(@PathVariable("noteId") int noteId) {
        noteService.deleteNote(noteId);
    }

    @GetMapping("/getNotesByTopicId/{topicId}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByTopicId(@PathVariable("topicId") int topicId) {
        return ResponseEntity.ok(noteService.getNoteDtosByTopicId(topicId));
    }

    @GetMapping("/getNotesByUserId/{userId}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByUserId(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(noteService.getNoteDtosByUserId(userId));
    }

    @GetMapping("/getNotesByUserIdAndTopicId/{userId}/{topicId}")
    public ResponseEntity<List<GetNoteDto>> getAllNotesByUserIdAndTopicId(@PathVariable("userId") int userId,
                                                                          @PathVariable("topicId") int topicId) {
        return ResponseEntity.ok(noteService.getNotesByUserIdAndTopicId(userId, topicId));
    }

}
