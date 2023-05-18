package com.kuruc.notion.services;

import com.kuruc.notion.dtos.taskdto.CreateTaskDTO;
import com.kuruc.notion.dtos.taskdto.DeleteTaskDTO;
import com.kuruc.notion.dtos.taskdto.ReadTaskDTO;
import com.kuruc.notion.dtos.taskdto.UpdateTaskDTO;
import com.kuruc.notion.exceptions.TaskNotFoundException;
import com.kuruc.notion.models.Task;
import java.util.List;

public interface TaskService {
  void createTask(CreateTaskDTO dto);
  Task readTask(ReadTaskDTO dto) throws TaskNotFoundException;
  List<Task> readAllTasks();
  void updateTask(UpdateTaskDTO dto) throws TaskNotFoundException;
  void deleteTask(DeleteTaskDTO dto) throws TaskNotFoundException;
}
