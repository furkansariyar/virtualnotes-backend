package co.sudoers.virtualnotes.service.impl;

import co.sudoers.virtualnotes.dto.*;
import co.sudoers.virtualnotes.entity.Note;
import co.sudoers.virtualnotes.entity.Topic;
import co.sudoers.virtualnotes.entity.User;
import co.sudoers.virtualnotes.repository.NoteRepository;
import co.sudoers.virtualnotes.service.NoteService;
import co.sudoers.virtualnotes.service.TopicService;
import co.sudoers.virtualnotes.service.UserService;
import co.sudoers.virtualnotes.util.mappers.NoteMapper;
import co.sudoers.virtualnotes.util.mappers.TopicMapper;
import co.sudoers.virtualnotes.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    private final TopicService topicService;
    private final TopicMapper topicMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper, TopicService topicService, TopicMapper topicMapper, UserService userService, UserMapper userMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
        this.topicService = topicService;
        this.topicMapper = topicMapper;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public GetNoteDto saveNote(CreateNoteDto createNoteDto) {
        // Get topic
        GetTopicDto getTopicDto = topicService.getTopic(createNoteDto.getTopicId());
        Topic topic = topicMapper.getTopicDtoToTopic(getTopicDto);
        // Get user
        GetUserDto getUserDto = userService.getUser(createNoteDto.getUserId());
        User user = userMapper.getUserDtoToUser(getUserDto);
        // Get note
        Note note = noteMapper.createNoteDtoToNote(createNoteDto);
        note.setTopic(topic);
        note.setUser(user);
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
        if (updateNoteDto.getTopicId() != 0) {
            note.setTopic(topicMapper.getTopicDtoToTopic(topicService.getTopic(updateNoteDto.getTopicId())));
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

    @Override
    public List<Note> getNotesByTopicId(int topicId) {
        return noteRepository.getNotesByTopic_TopicId(topicId);
    }

    @Override
    public List<GetNoteDto> getNoteDtosByTopicId(int topicId) {
        List<Note> noteList = noteRepository.getNotesByTopic_TopicId(topicId);
        return noteMapper.noteListToGetNoteDtoList(noteList);
    }

    @Override
    public List<Note> getNotesByUserId(int userId) {
        return noteRepository.getNotesByUser_UserId(userId);
    }

    @Override
    public List<GetNoteDto> getNoteDtosByUserId(int userId) {
        List<Note> noteList = noteRepository.getNotesByUser_UserId(userId);
        return noteMapper.noteListToGetNoteDtoList(noteList);
    }

    @Override
    public List<GetNoteDto> getNotesByUserIdAndTopicId(int userId, int topicId) {
        List<Note> noteList = noteRepository.getNotesByUser_UserIdAndTopic_TopicId(userId, topicId);
        return noteMapper.noteListToGetNoteDtoList(noteList);
    }

}
