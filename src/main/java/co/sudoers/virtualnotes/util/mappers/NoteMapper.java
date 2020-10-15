package co.sudoers.virtualnotes.util.mappers;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.entity.Note;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
    Note createNoteDtoToNote(CreateNoteDto createNoteDto);
    GetNoteDto noteToGetNoteDto(Note note);

    List<GetNoteDto> noteListToGetNoteDtoList(List<Note> noteList);
    List<Note> getNoteDtoListToNoteList(List<GetNoteDto> getNoteDtoList);
}
