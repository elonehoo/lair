package com.item.basic.hi.service.implement;

import com.item.basic.hi.entity.dto.InstallHi;
import com.item.basic.hi.entity.vo.PageView;
import com.item.basic.hi.service.HiService;
import com.item.basic.hi.entity.po.Hi;
import com.item.basic.hi.mapper.HiMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class HiServiceImplement implements HiService {

  @Resource
  private HiMapper hi;

  @Override
  @Transactional
  public Boolean install(InstallHi entity) {
    Hi hoo = hi.save(new Hi().setViewTime(new Date()).setName(entity.getName()));
    return hoo != null;
  }

  @Override
  @Transactional
  public PageView pageView() {
    return new PageView().setCount(hi.count()).setTime(hi.findTopByOrderByViewTimeDesc() == null ? new Date() : hi.findTopByOrderByViewTimeDesc().getViewTime());
  }

  @Override
  public List<Hi> all() {
    return hi.findAllByOrderByViewTimeAsc();
  }
}
