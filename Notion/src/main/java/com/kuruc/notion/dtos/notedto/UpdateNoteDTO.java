package com.kuruc.notion.dtos.notedto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNoteDTO {
  private UUID id;
  private String title;
  private String subtitle;
  private String description;
  private Object content;
}
