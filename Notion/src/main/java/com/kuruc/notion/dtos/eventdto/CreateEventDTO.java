package com.kuruc.notion.dtos.eventdto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventDTO {
  private String name;
  private LocalDateTime startsAt;
  private LocalDateTime endsAt;
}
