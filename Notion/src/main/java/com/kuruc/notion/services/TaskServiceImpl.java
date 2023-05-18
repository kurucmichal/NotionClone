package com.kuruc.notion.services;

import com.kuruc.notion.dtos.taskdto.CreateTaskDTO;
import com.kuruc.notion.dtos.taskdto.DeleteTaskDTO;
import com.kuruc.notion.dtos.taskdto.ReadTaskDTO;
import com.kuruc.notion.dtos.taskdto.UpdateTaskDTO;
import com.kuruc.notion.exceptions.TaskNotFoundException;
import com.kuruc.notion.models.Task;
import com.kuruc.notion.repositories.TaskRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

  private TaskRepository taskRepository;

  @Override
  public void createTask(CreateTaskDTO dto) {
    var tempTask = Task.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .deadline(dto.getDeadline())
        .completed(Boolean.FALSE)
        .build();

    taskRepository.save(tempTask);
  }

  @Override
  public Task readTask(ReadTaskDTO dto) throws TaskNotFoundException {
    return taskRepository.findById(dto.getId()).orElseThrow(TaskNotFoundException::new);
  }

  @Override
  public List<Task> readAllTasks() {
    return taskRepository.findAll();
  }

  @Override
  public void updateTask(UpdateTaskDTO dto) throws TaskNotFoundException {
    var task = taskRepository.findById(dto.getId()).orElseThrow(TaskNotFoundException::new);
    BeanUtils.copyProperties(dto, task);
    taskRepository.save(task);
  }

  @Override
  public void deleteTask(DeleteTaskDTO dto) throws TaskNotFoundException {
    var task = taskRepository.findById(dto.getId()).orElseThrow(TaskNotFoundException::new);
    taskRepository.delete(task);
  }
}
