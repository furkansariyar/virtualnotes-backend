package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.dto.UpdateNoteDto;
import co.sudoers.virtualnotes.entity.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    GetNoteDto saveNote(CreateNoteDto createNoteDto);
    GetNoteDto getNote(UUID noteId);
    GetNoteDto updateNote(UUID noteId, UpdateNoteDto updateNoteDto);
    void deleteNote(UUID noteId);

    List<Note> getNotesByTopicId(UUID topicId);
    List<GetNoteDto> getNoteDtosByTopicId(UUID topicId);

    List<Note> getNotesByUserId(UUID userId);
    List<GetNoteDto> getNoteDtosByUserId(UUID userId);

    List<GetNoteDto> getNotesByUserIdAndTopicId(UUID userId, UUID topicId);
}
