package com.item.web.controller;

import com.item.basic.hi.entity.dto.InstallHi;
import com.item.basic.hi.entity.po.Hi;
import com.item.basic.hi.entity.vo.PageView;
import com.item.basic.hi.service.HiService;
import com.restful.Result;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hi")
public class HiController {
  @Resource
  private HiService hiService;

  @PostMapping("/")
  public Result install(@RequestBody InstallHi entity){
    if (hiService.install(entity)) {
      return Result.success(true);
    }else {
      return Result.internalServerError(false);
    }
  }

  @GetMapping("/")
  public Result pageView(){
    PageView data = hiService.pageView();
    return Result.success(data);
  }

  @GetMapping("/all")
  public Result all(){
    List<Hi> lists = hiService.all();
    return Result.success(lists);
  }


}
