package com.item.basic.hi.entity.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>The entity class that displays the core information of the database will be returned to the front-end page</p>
 * <p>Entity classes are constructed using annotations in lombok.</p>
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022-06-13
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageView {
  private Long count;

  private Date time;
}
