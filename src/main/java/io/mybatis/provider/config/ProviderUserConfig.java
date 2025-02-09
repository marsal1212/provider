/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.mybatis.provider.config;

import io.mybatis.config.defaults.UserConfig;

/**
 * mybatis-provider 用户配置，优先级高于版本配置，可以覆盖版本默认值
 * <p>
 * 可以通过 provider.properties 属性指定自定义的配置路径或文件名
 *
 * @author liuzh
 */
public class ProviderUserConfig extends UserConfig {
  @Override
  protected String getConfigKey() {
    return "io.mybatis.provider.properties";
  }

  @Override
  protected String getConfigName() {
    return "mybatis-provider";
  }

}
