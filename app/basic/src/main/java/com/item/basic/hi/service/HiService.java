package com.item.basic.hi.service;

import com.item.basic.hi.entity.dto.InstallHi;
import com.item.basic.hi.entity.po.Hi;
import com.item.basic.hi.entity.vo.PageView;

import java.util.List;

/**
 * <p>The specific business operations and the throwing interface written by the logic will be implemented here.</p>
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022-06-13
 */
public interface HiService {
  /**
   * <p>Enter the name to store the data into the database</p>
   * @param entity The entity to be saved
   * @return Whether the save is successful
   */
  Boolean install(InstallHi entity);

  /**
   * <p>Get the number of views and the time of the last view</p>
   * @return The page view information
   */
  PageView pageView();

  /**
   * <p>Get all the views</p>
   * @return The list of views
   */
  List<Hi> all();
}
