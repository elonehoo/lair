package com.item.web.controller;

import com.item.basic.hi.entity.dto.InstallHi;
import com.item.basic.hi.entity.po.Hi;
import com.item.basic.hi.entity.vo.PageView;
import com.item.basic.hi.service.HiService;
import com.restful.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *<p>Initialized web interface</p>
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022-06-13
 */
@RestController
@CrossOrigin
@RequestMapping("/hi")
public class HiController {
  @Resource
  private HiService hiService;

  /**
   * <p>Enter the name to store the data into the database</p>
   * @param entity The entity to be saved
   * @return Whether the save is successful
   */
  @PostMapping("/")
  public Result install(@RequestBody InstallHi entity){
    if (hiService.install(entity)) {
      return Result.success(true);
    }else {
      return Result.internalServerError(false);
    }
  }

  /**
   * <p>Get the number of views and the time of the last view</p>
   * @return The page view information
   */
  @GetMapping("/")
  public Result pageView(){
    PageView data = hiService.pageView();
    return Result.success(data);
  }

  /**
   * <p>Get all the views</p>
   * @return The list of views
   */
  @GetMapping("/all")
  public Result all(){
    List<Hi> lists = hiService.all();
    return Result.success(lists);
  }


}
