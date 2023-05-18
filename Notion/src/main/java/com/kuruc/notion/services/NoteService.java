package com.kuruc.notion.services;

import com.kuruc.notion.dtos.notedto.CreateNoteDTO;
import com.kuruc.notion.dtos.notedto.DeleteNoteDTO;
import com.kuruc.notion.dtos.notedto.ReadNoteDTO;
import com.kuruc.notion.dtos.notedto.UpdateNoteDTO;
import com.kuruc.notion.exceptions.NoteNotFoundException;
import com.kuruc.notion.models.Note;
import java.util.List;

public interface NoteService {

  void createNote(CreateNoteDTO dto);

  Note readNote(ReadNoteDTO dto) throws NoteNotFoundException;

  List<Note> readAllNotes();

  void updateNote(UpdateNoteDTO dto) throws NoteNotFoundException;

  void deleteNote(DeleteNoteDTO dto) throws NoteNotFoundException;
}
