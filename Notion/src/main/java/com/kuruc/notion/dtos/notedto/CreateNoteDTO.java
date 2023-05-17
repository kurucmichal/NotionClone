package com.kuruc.notion.dtos.notedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteDTO {
  private String title;
  private String subtitle;
  private String description;
  private Object content;
}
