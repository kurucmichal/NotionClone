package com.kuruc.notion.models;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
  private String name;

  @Id
  private UUID uuid;
  private LocalDateTime deadline;
  private Boolean completed;

}
