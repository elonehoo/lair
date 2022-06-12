package com.item.basic.hi.mapper;

import com.item.basic.hi.entity.po.Hi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HiMapper extends JpaRepository<Hi,String>, JpaSpecificationExecutor<Hi> {
  Hi findTopByOrderByViewTimeDesc();

  List<Hi> findAllByOrderByViewTimeAsc();
}
