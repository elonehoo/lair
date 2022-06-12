package com.item.basic.hi.entity.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InstallHi implements Serializable {
  private String name;

  @Override
  public String toString() {
    return "InstallHi{" +
      "name='" + name + '\'' +
      '}';
  }
}
