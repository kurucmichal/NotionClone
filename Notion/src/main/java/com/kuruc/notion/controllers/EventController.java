package com.kuruc.notion.controllers;

import com.kuruc.notion.dtos.ResponseDTO;
import com.kuruc.notion.dtos.eventdto.CreateEventDTO;
import com.kuruc.notion.dtos.eventdto.DeleteEventDTO;
import com.kuruc.notion.dtos.eventdto.ReadEventDTO;
import com.kuruc.notion.dtos.eventdto.UpdateEventDTO;
import com.kuruc.notion.exceptions.EventNotFoundException;
import com.kuruc.notion.services.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("event")
@AllArgsConstructor
public class EventController {
  private static final String SUCCESS = "SUCCESS";
  private static final String TASK_NOT_FOUND = "EVENT NOT FOUND";
  private static final String UNKNOWN_ERROR = "UNKNOWN ERROR";


  private EventService eventService;

  @PostMapping("create")
  public ResponseEntity<ResponseDTO> createEvent(@RequestBody CreateEventDTO dto){
    var response = new ResponseDTO();
    try {
      eventService.createEvent(dto);
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (Exception e) {
      log.error("CREATE EVENT OPERATION FAILED::{}",dto.toString());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/read")
  public ResponseEntity<ResponseDTO> readEvent(@RequestBody ReadEventDTO dto){
    var response = new ResponseDTO();
    try {
      response.setData(eventService.readEvent(dto));
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (EventNotFoundException e){
      log.error("READ EVENT OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getId());
      e.printStackTrace();
      response.setMessage(TASK_NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    catch (Exception e) {
      log.error("READ EVENT OPERATION FAILED::{}",dto.getId());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/update")
  public ResponseEntity<ResponseDTO> updateEvent(@RequestBody UpdateEventDTO dto){
    var response = new ResponseDTO();
    try {
      eventService.updateEvent(dto);
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (EventNotFoundException e){
      log.error("UPDATE EVENT OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getId());
      e.printStackTrace();
      response.setMessage(TASK_NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    catch (Exception e) {
      log.error("UPDATE EVENT OPERATION FAILED::{}",dto.getId());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/delete")
  public ResponseEntity<ResponseDTO> deleteEvent(@RequestBody DeleteEventDTO dto){
    var response = new ResponseDTO();
    try {
      eventService.deleteEvent(dto);
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (EventNotFoundException e){
      log.error("DELETE EVENT OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getId());
      e.printStackTrace();
      response.setMessage(TASK_NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    catch (Exception e) {
      log.error("DELETE EVENT OPERATION FAILED::{}",dto.getId());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<ResponseDTO> readAllEvents(){
    var response = new ResponseDTO();
    try {
      response.setData(eventService.readAllEvents());
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (Exception e){
      log.error("GET ALL EVENTS OPERATION FAILED");
      e.printStackTrace();
      response.setMessage(UNKNOWN_ERROR);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
  }
}
