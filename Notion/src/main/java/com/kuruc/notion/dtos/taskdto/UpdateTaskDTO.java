package com.kuruc.notion.dtos.taskdto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDTO {
  private UUID id;
  private String name;
  private LocalDateTime deadline;
  private Boolean completed;
}
