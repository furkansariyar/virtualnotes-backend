package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Note getNoteByNoteId(int noteId);
}
