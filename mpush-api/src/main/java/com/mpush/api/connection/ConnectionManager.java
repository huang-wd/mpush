/*
 * (C) Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   ohun@live.cn (夜色)
 */

package com.mpush.api.connection;

import io.netty.channel.Channel;

/**
 * Connection/ConnectionManager主要负责链接管理，定时检查链接空闲情况，是否读写超时，如果链接断开发出相应的事件给路由中心去处理
 *
 * @author ohun@live.cn (夜色)
 */
public interface ConnectionManager {

    /**
     * 获取connection
     *
     * @param channel
     * @return
     */
    Connection get(Channel channel);

    /**
     * 关闭
     *
     * @param channel
     * @return
     */
    Connection removeAndClose(Channel channel);

    /**
     * 添加连接
     *
     * @param connection
     */
    void add(Connection connection);

    /**
     * 获取连接总数
     *
     * @return
     */
    int getConnNum();

    /**
     * 初始化
     */
    void init();

    /**
     * 销毁
     */
    void destroy();
}
