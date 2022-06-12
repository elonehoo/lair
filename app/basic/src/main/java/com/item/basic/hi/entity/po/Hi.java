package com.item.basic.hi.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@Table(name = "hi")
@AllArgsConstructor
@Accessors(chain = true)
public class Hi {

  @Id
  @GeneratedValue(generator = "snowFlakeIdGenerator")
  @GenericGenerator(name = "snowFlakeIdGenerator", strategy = "com.item.basic.config.generationType.SnowFlakeIdGenerator")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "view_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date viewTime;


}
