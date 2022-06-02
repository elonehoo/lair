package com.item.basic;

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

/**
 * <title>
 *   Code generator
 * </title>
 *
 * <div>
 *  Complete the automatic creation of basic business layered components through MyBatis Plus Generator,
 *  automatically correspond to the entity classes in the database,
 *  and complete the creation of each module.
 * </div>
 *
 * <div>
 *  Just modify 「SQL_URL」, 「SQL_USERNAME」 and 「SQL_PASSWORD」 and 「AUTHOR」,
 *  which is your private configuration,
 *  and then enter the name of the table to be created into the parameters
 *  of the 43rd line of code, run the program,
 *  you can achieve Automatic generation of code.
 * </div>
 *
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2020-06-02
 */
public class Generator {

  /**
   * address to connect to SQL
   */
  private static final String SQL_URL = "jdbc:mysql://localhost:3306/static";

  /**
   * connect to SQL account
   */
  private static final String SQL_USERNAME = "root";

  /**
   * connect to SQL password
   */
  private static final String SQL_PASSWORD = "123456";

  /**
   * author using the tool
   */
  private static final String AUTHOR = "Elone Hoo <huchengyea@163.com>";

  /**
   * the only entry to run the project
   */
  public static void main(String[] args) {
    generator("user","user1","user2");
  }

  /**
   * database configuration
   */
  private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
    .Builder(SQL_URL, SQL_USERNAME, SQL_PASSWORD);

  /**
   * global configuration
   */
  private static final BiConsumer<Function<String, String>, GlobalConfig.Builder> GLOBAL_CONFIG = (b, builder) -> {
    builder
      .author(AUTHOR)
      .outputDir(System.getProperty("user.dir") + "/app/basic/src/main/java") // output directory
      .disableOpenDir() // disable opening of output directory
      .dateType(DateType.TIME_PACK) // time type corresponding strategy
      .commentDate("yyyy-MM-dd"); // specify note date formatting
  };

  /**
   * the core of the code auto generator
   */
  public static void generator(String ...tableName){
    for (String name : tableName) {
      FastAutoGenerator.create(DATA_SOURCE_CONFIG)
        .globalConfig(GLOBAL_CONFIG)
        .packageConfig(builder -> {
          builder.parent("com.item.basic." + name)// set parent package name
            .entity("entity.po") // set entity package name
            .service("service") // set service package name
            .serviceImpl("service.impl") // set serviceImpl package name
            .mapper("mapper") // set mapper package name
            .xml("mapper.xml") // set xml package name
            .controller("controller") // set controller package name
            .pathInfo(Collections.singletonMap(OutputFile.controller,System.getProperty("user.dir") + "/app/web/src/main/java/com/item/web/controller/" + name + "Controller")) // set controller package address
            .build();
        })
        .strategyConfig(builder -> {
          builder.addInclude(name) // Set the name of the table to be generated
            .addTablePrefix("t_", "c_")// set filter table prefix
            .entityBuilder() // set entity configuration
            .enableChainModel() // open chain model
            .enableLombok() // open lombok
            .enableTableFieldAnnotation() // generate field annotations when generating entities are turned on
            .naming(NamingStrategy.underline_to_camel) // naming strategy for mapping database tables to entities
            .build()
            .controllerBuilder() // set controller configuration
            .enableRestStyle() // turn on generating @RestController controllers
            .build()
            .serviceBuilder() // set service configuration
            .formatServiceFileName("%sService") // format the name of the service interface file
            .formatServiceImplFileName("%sServiceImp") // format the name of the service implementation class file
            .build()
            .mapperBuilder() // set mapper configuration
            .enableMapperAnnotation() // turn on generating @Mapper annotations
            .formatMapperFileName("%sMapper") // format the name of the mapper interface file
            .formatXmlFileName("%sMapperXml") // format the name of the mapper xml file
            .build();
        })
        .templateEngine(new FreemarkerTemplateEngine()) // use Freemarker engine templates
        .execute();
    }

  }

}
