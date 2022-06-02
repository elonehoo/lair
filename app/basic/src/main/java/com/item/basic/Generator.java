package com.item.basic;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.BiConsumer;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class Generator {

  private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
    .Builder("jdbc:mysql://localhost:3306/static", "root", "123456");

  private static BiConsumer<Function<String, String>, GlobalConfig.Builder> GLOBAL_CONFIG = (b,builder) -> {
    builder
      .author("Elone Hoo <huchengyea@163.com>")
      .outputDir(System.getProperty("user.dir") + "/app/basic/src/main/java")
      .fileOverride()
      .disableOpenDir()
      .dateType(DateType.TIME_PACK)
      .commentDate("yyyy-MM-dd");
  };

  public static void main(String[] args) {
    generator("user","user1","user2");
  }

  public static void generator(String ...tableName){
    for (String name : tableName) {
      FastAutoGenerator.create(DATA_SOURCE_CONFIG)
        .globalConfig(GLOBAL_CONFIG)
        .packageConfig(builder -> {
          builder.parent("com.item.basic." + name)// 设置父包名
            .entity("entity.po")
            .service("service")
            .serviceImpl("service.impl")
            .mapper("mapper")
            .xml("mapper.xml")
            .controller("controller")
            .pathInfo(Collections.singletonMap(OutputFile.controller,System.getProperty("user.dir") + "/app/web/src/main/java/com/item/web/controller/" + name + "Controller"))
            .build();
        })
        .strategyConfig(builder -> {
          builder.addInclude(name) // 设置需要生成的表名
            .addTablePrefix("t_", "c_")// 设置过滤表前缀
            .entityBuilder()
            .enableChainModel()
            .enableLombok()
            .enableTableFieldAnnotation()
            .naming(NamingStrategy.underline_to_camel)
            .build()
            .controllerBuilder()
            .enableRestStyle()
            .build()
            .serviceBuilder()
            .formatServiceFileName("%sService")
            .formatServiceImplFileName("%sServiceImp")
            .build()
            .mapperBuilder()
            .enableMapperAnnotation()
            .formatMapperFileName("%sMapper")
            .formatXmlFileName("%sMapperXml")
            .build();
        })
        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute();
    }

  }

  // 处理 all 情况
  protected static List<String> getTables(String tables) {
    return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
  }

}
