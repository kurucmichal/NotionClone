package com.kuruc.notion.services;

import com.kuruc.notion.dtos.notedto.CreateNoteDTO;
import com.kuruc.notion.dtos.notedto.DeleteNoteDTO;
import com.kuruc.notion.dtos.notedto.ReadNoteDTO;
import com.kuruc.notion.dtos.notedto.UpdateNoteDTO;
import com.kuruc.notion.exceptions.NoteNotFoundException;
import com.kuruc.notion.models.Note;
import com.kuruc.notion.repositories.NoteRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{
  private NoteRepository noteRepository;

  @Override
  public void createNote(CreateNoteDTO dto) {
    var tempNote = Note.builder()
        .title(dto.getTitle())
        .subtitle(dto.getSubtitle())
        .description(dto.getDescription())
        .content(dto.getContent())
        .uuid(UUID.randomUUID())
        .createdAt(LocalDateTime.now())
        .build();

    noteRepository.save(tempNote);
  }

  @Override
  public Note readNote(ReadNoteDTO dto) throws NoteNotFoundException {
    return noteRepository.findById(dto.getId()).orElseThrow(NoteNotFoundException::new);
  }
  @Override
  public List<Note> readAllNotes() {
    return noteRepository.findAll();
  }

  @Override
  public void updateNote(UpdateNoteDTO dto) throws NoteNotFoundException {
    var note = noteRepository.findById(dto.getId()).orElseThrow(NoteNotFoundException::new);
    BeanUtils.copyProperties(dto, note);
    noteRepository.save(note);
  }

  @Override
  public void deleteNote(DeleteNoteDTO dto) throws NoteNotFoundException {
    var note = noteRepository.findById(dto.getId()).orElseThrow(NoteNotFoundException::new);
    noteRepository.delete(note);
  }
}
