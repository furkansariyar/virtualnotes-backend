package co.sudoers.virtualnotes.service.impl;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.dto.UpdateNoteDto;
import co.sudoers.virtualnotes.entity.Note;
import co.sudoers.virtualnotes.repository.NoteRepository;
import co.sudoers.virtualnotes.service.NoteService;
import co.sudoers.virtualnotes.util.mappers.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public GetNoteDto saveNote(CreateNoteDto createNoteDto) {
        Note note = noteMapper.createNoteDtoToNote(createNoteDto);
        note = noteRepository.save(note);
        return noteMapper.noteToGetNoteDto(note);
    }

    @Override
    public GetNoteDto getNote(int noteId) {
        Note note = noteRepository.getNoteByNoteId(noteId);
        if (note == null) {
            throw new IllegalArgumentException("Note Id is not exist");
        }
        return noteMapper.noteToGetNoteDto(note);
    }

    @Override
    public GetNoteDto updateNote(int noteId, UpdateNoteDto updateNoteDto) {
        Note note = noteRepository.getNoteByNoteId(noteId);
        if (note == null) {
            throw new IllegalArgumentException("Note Id is not exist");
        }
        if (updateNoteDto.getNote() != null) {
            note.setNote(updateNoteDto.getNote());
        }
        if (updateNoteDto.getTopic() != null) {
            note.setTopic(updateNoteDto.getTopic());
        }
        noteRepository.save(note);
        return getNote(noteId);
    }

    @Override
    public void deleteNote(int noteId) {
        Note note = noteRepository.getNoteByNoteId(noteId);
        if (note == null) {
            throw new IllegalArgumentException("Note Id is not exist");
        }
        noteRepository.delete(note);
    }
}
