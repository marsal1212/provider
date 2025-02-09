package io.mybatis.provider;

import io.mybatis.config.ConfigHelper;
import io.mybatis.provider.util.ServiceLoaderUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 默认提供的样式，自己可以通过 SPI 扩展
 */
public interface Style {
  /**
   * 默认配置对应的 key
   */
  String DEFAULT_STYLE_KEY = "mybatis.provider.style";

  /**
   * 不做转换
   */
  String NORMAL = "normal";

  /**
   * 驼峰转下划线
   */
  String LOWER_UNDERSCORE = "lower_underscore";

  /**
   * 转小写
   */
  String LOWER = "lower";

  /**
   * 转大写
   */
  String UPPER = "upper";

  /**
   * 驼峰转大写下划线
   */
  String UPPER_UNDERSCORE = "upper_underscore";

  /**
   * 获取样式名，如默认提供的 normal, underline, lower, upper, upperUnderline
   */
  String getStyle();

  /**
   * 转换表名
   *
   * @param entityClass 实体类
   * @return 对应的表名
   */
  String tableName(Class<?> entityClass);

  /**
   * 转换列名
   *
   * @param entityTable
   * @param field
   * @return
   */
  String columnName(EntityTable entityTable, EntityField field);

  /**
   * 初始化样式信息
   */
  Map<String, Style> styleMap = new HashMap() {
    {
      List<Style> instances = ServiceLoaderUtil.getInstances(Style.class);
      for (Style instance : instances) {
        put(instance.getStyle(), instance);
      }
    }
  };

  /**
   * 获取样式
   *
   * @param style 样式名
   */
  static Style getStyle(String style) {
    if(style == null || style.isEmpty()) {
      style = ConfigHelper.getStr(DEFAULT_STYLE_KEY);
    }
    if (styleMap.containsKey(style)) {
      return styleMap.get(style);
    } else {
      throw new IllegalArgumentException("illegal style：" + style);
    }
  }

}
