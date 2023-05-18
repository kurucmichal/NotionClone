package com.kuruc.notion.services;

import com.kuruc.notion.dtos.eventdto.CreateEventDTO;
import com.kuruc.notion.dtos.eventdto.DeleteEventDTO;
import com.kuruc.notion.dtos.eventdto.ReadEventDTO;
import com.kuruc.notion.dtos.eventdto.UpdateEventDTO;
import com.kuruc.notion.exceptions.EventNotFoundException;
import com.kuruc.notion.models.Event;
import java.util.List;

public interface EventService {

  void createEvent(CreateEventDTO dto);

  Event readEvent(ReadEventDTO dto) throws EventNotFoundException;

  List<Event> readAllEvents();

  void updateEvent(UpdateEventDTO dto) throws EventNotFoundException;

  void deleteEvent(DeleteEventDTO dto) throws EventNotFoundException;
}
