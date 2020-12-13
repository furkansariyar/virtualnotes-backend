package co.sudoers.virtualnotes.repository;

import co.sudoers.virtualnotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Note getNoteByNoteId(int noteId);
    List<Note> getNotesByTopic_TopicId(int topicId);
    List<Note> getNotesByUser_UserId(int userId);
    List<Note> getNotesByUser_UserIdAndTopic_TopicId(int userId, int topicId);
}
