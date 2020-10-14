package co.sudoers.virtualnotes.service;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.dto.UpdateNoteDto;

public interface NoteService {
    GetNoteDto saveNote(CreateNoteDto createNoteDto);
    GetNoteDto getNote(int noteId);
    GetNoteDto updateNote(int noteId, UpdateNoteDto updateNoteDto);
    void deleteNote(int noteId);
}
