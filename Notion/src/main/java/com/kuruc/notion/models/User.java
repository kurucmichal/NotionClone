package com.kuruc.notion.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  @Id
  private UUID id;

  private String name;
  private String email;
  private String token;
//  private UUID salt;

}
