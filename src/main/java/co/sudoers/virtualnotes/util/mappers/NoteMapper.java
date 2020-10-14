package co.sudoers.virtualnotes.util.mappers;

import co.sudoers.virtualnotes.dto.CreateNoteDto;
import co.sudoers.virtualnotes.dto.GetNoteDto;
import co.sudoers.virtualnotes.entity.Note;
import org.mapstruct.Mapper;

@Mapper
public interface NoteMapper {
    Note createNoteDtoToNote(CreateNoteDto createNoteDto);
    GetNoteDto noteToGetNoteDto(Note note);
}
