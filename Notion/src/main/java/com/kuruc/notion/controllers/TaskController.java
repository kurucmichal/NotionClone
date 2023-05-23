package com.kuruc.notion.controllers;

import com.kuruc.notion.dtos.ResponseDTO;
import com.kuruc.notion.dtos.taskdto.CreateTaskDTO;
import com.kuruc.notion.dtos.taskdto.DeleteTaskDTO;
import com.kuruc.notion.dtos.taskdto.ReadTaskDTO;
import com.kuruc.notion.dtos.taskdto.UpdateTaskDTO;
import com.kuruc.notion.exceptions.TaskNotFoundException;
import com.kuruc.notion.services.TaskService;
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
@RequestMapping("task")
@AllArgsConstructor
public class TaskController {
  private static final String SUCCESS = "SUCCESS";
  private static final String TASK_NOT_FOUND = "TASK NOT FOUND";
  private static final String UNKNOWN_ERROR = "UNKNOWN ERROR";


  private TaskService taskService;

  @PostMapping("create")
  public ResponseEntity<ResponseDTO> createTask(@RequestBody CreateTaskDTO dto){
    var response = new ResponseDTO();
    try {
      taskService.createTask(dto);
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (Exception e) {
      log.error("CREATE TASK OPERATION FAILED::{}",dto.toString());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/read")
  public ResponseEntity<ResponseDTO> readTask(@RequestBody ReadTaskDTO dto){
    var response = new ResponseDTO();
    try {
      response.setData(taskService.readTask(dto));
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (TaskNotFoundException e){
      log.error("READ TASK OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getId());
      e.printStackTrace();
      response.setMessage(TASK_NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    catch (Exception e) {
      log.error("READ TASK OPERATION FAILED::{}",dto.getId());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/update")
  public ResponseEntity<ResponseDTO> updateTask(@RequestBody UpdateTaskDTO dto){
    var response = new ResponseDTO();
    try {
      taskService.updateTask(dto);
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (TaskNotFoundException e){
      log.error("UPDATE TASK OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getId());
      e.printStackTrace();
      response.setMessage(TASK_NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    catch (Exception e) {
      log.error("UPDATE TASK OPERATION FAILED::{}",dto.getId());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/delete")
  public ResponseEntity<ResponseDTO> deleteTask(@RequestBody DeleteTaskDTO dto){
    var response = new ResponseDTO();
    try {
      taskService.deleteTask(dto);
      response.setMessage(SUCCESS);
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (TaskNotFoundException e){
      log.error("DELETE TASK OPERATION FAILED ({})::{}",TASK_NOT_FOUND,dto.getId());
      e.printStackTrace();
      response.setMessage(TASK_NOT_FOUND);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    catch (Exception e) {
      log.error("DELETE TASK OPERATION FAILED::{}",dto.getId());
      e.printStackTrace();
      response.setMessage(e.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<ResponseDTO> readAllTasks(){
    var response = new ResponseDTO();
    try {
      response.setData(taskService.readAllTasks());
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (Exception e){
      log.error("GET ALL TASKS OPERATION FAILED");
      e.printStackTrace();
      response.setMessage(UNKNOWN_ERROR);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
  }
}
