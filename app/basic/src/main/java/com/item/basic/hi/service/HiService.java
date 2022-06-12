package com.item.basic.hi.service;

import com.item.basic.hi.entity.dto.InstallHi;
import com.item.basic.hi.entity.po.Hi;
import com.item.basic.hi.entity.vo.PageView;

import java.util.List;

public interface HiService {
  Boolean install(InstallHi entity);

  PageView pageView();

  List<Hi> all();
}
