package com.item.basic.hi.service.implement;

import com.item.basic.hi.entity.dto.InstallHi;
import com.item.basic.hi.entity.vo.PageView;
import com.item.basic.hi.service.HiService;
import com.item.basic.hi.entity.po.Hi;
import com.item.basic.hi.mapper.HiMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 *<p>Specific business operations and logic writing will be implemented here.</p>
 * @author Elone Hoo <huchengyea@163.com>
 */
@Service
public class HiServiceImplement implements HiService {

  @Resource
  private HiMapper hi;

  /**
   * <p>Enter the name to store the data into the database</p>
   * @param entity The entity to be saved
   * @return Whether the save is successful
   */
  @Override
  @Transactional
  public Boolean install(InstallHi entity) {
    Hi hoo = hi.save(new Hi().setViewTime(new Date()).setName(entity.getName()));
    return hoo != null;
  }

  /**
   * <p>Get the number of views and the time of the last view</p>
   * @return The page view information
   */
  @Override
  @Transactional
  public PageView pageView() {
    return new PageView().setCount(hi.count()).setTime(hi.findTopByOrderByViewTimeDesc() == null ? new Date() : hi.findTopByOrderByViewTimeDesc().getViewTime());
  }

  /**
   * <p>Get all the views</p>
   * @return The list of views
   */
  @Override
  @Transactional
  public List<Hi> all() {
    return hi.findAllByOrderByViewTimeAsc();
  }
}
