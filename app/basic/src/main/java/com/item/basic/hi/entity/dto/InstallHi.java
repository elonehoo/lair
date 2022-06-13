package com.item.basic.hi.entity.dto;

import lombok.*;

import java.io.Serializable;

/**
 * <p>an initial insert template</p>
 * <p>Entity classes are constructed using annotations in lombok.</p>
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022-06-13
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InstallHi implements Serializable {
  private String name;

}
