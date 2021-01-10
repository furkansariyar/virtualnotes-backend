package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    Note getNoteByNoteId(UUID noteId);
    List<Note> getNotesByTopic_TopicId(UUID topicId);
    List<Note> getNotesByUser_UserId(UUID userId);
    List<Note> getNotesByUser_UserIdAndTopic_TopicId(UUID userId, UUID topicId);

    List<Note> findAllByUser_UserIdAndNoteContains(UUID userId, String searchedText);
}
