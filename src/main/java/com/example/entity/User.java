package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private long uId;
  private String username;
  private String password;
  private String phone;
  private String token;
  private String avatarUrl;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

}
