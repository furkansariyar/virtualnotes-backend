package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.dto.UpdateNoteDto;
import co.sudoers.virtualnotes.entity.Note;

import java.util.List;

public interface NoteService {
    GetNoteDto saveNote(CreateNoteDto createNoteDto);
    GetNoteDto getNote(int noteId);
    GetNoteDto updateNote(int noteId, UpdateNoteDto updateNoteDto);
    void deleteNote(int noteId);

    List<Note> getNotesByTopicId(int topicId);
    List<GetNoteDto> getNoteDtosByTopicId(int topicId);

    List<Note> getNotesByUserId(int userId);
    List<GetNoteDto> getNoteDtosByUserId(int userId);

    List<GetNoteDto> getNotesByUserIdAndTopicId(int userId, int topicId);
}
