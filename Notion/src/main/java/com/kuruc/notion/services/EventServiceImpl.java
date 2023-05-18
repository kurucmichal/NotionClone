package com.kuruc.notion.services;

import com.kuruc.notion.dtos.eventdto.CreateEventDTO;
import com.kuruc.notion.dtos.eventdto.DeleteEventDTO;
import com.kuruc.notion.dtos.eventdto.ReadEventDTO;
import com.kuruc.notion.dtos.eventdto.UpdateEventDTO;
import com.kuruc.notion.exceptions.EventNotFoundException;
import com.kuruc.notion.models.Event;
import com.kuruc.notion.repositories.EventRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
  private EventRepository eventRepository;

  @Override
  public void createEvent(CreateEventDTO dto) {
    var tempEvent = Event.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .startsAt(dto.getStartsAt())
        .endsAt(dto.getEndsAt())
        .build();

    eventRepository.save(tempEvent);
  }

  @Override
  public Event readEvent(ReadEventDTO dto) throws EventNotFoundException {
    return eventRepository.findById(dto.getId()).orElseThrow(EventNotFoundException::new);
  }

  @Override
  public List<Event> readAllEvents() {
    return eventRepository.findAll();
  }

  @Override
  public void updateEvent(UpdateEventDTO dto) throws EventNotFoundException {
    var event = eventRepository.findById(dto.getId()).orElseThrow(EventNotFoundException::new);
    BeanUtils.copyProperties(dto, event);
    eventRepository.save(event);
  }

  @Override
  public void deleteEvent(DeleteEventDTO dto) throws EventNotFoundException {
    var event = eventRepository.findById(dto.getId()).orElseThrow(EventNotFoundException::new);
    eventRepository.delete(event);
  }
}
