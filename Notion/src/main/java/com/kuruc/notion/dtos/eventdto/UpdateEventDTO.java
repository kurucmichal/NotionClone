package com.kuruc.notion.dtos.eventdto;

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
public class UpdateEventDTO {

  private UUID id;
  private String name;
  private LocalDateTime startsAt;
  private LocalDateTime endsAt;

}
