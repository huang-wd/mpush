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

import com.mpush.api.protocol.Packet;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

/**
 * 连接
 *
 * @author ohun@live.cn (夜色)
 */
public interface Connection {
    byte STATUS_NEW = 0;
    byte STATUS_CONNECTED = 1;
    byte STATUS_DISCONNECTED = 2;

    /**
     * 初始化
     *
     * @param channel
     * @param security
     */
    void init(Channel channel, boolean security);

    /**
     * session
     *
     * @return
     */
    SessionContext getSessionContext();

    /**
     * 设置session
     *
     * @param context
     */
    void setSessionContext(SessionContext context);

    /**
     * 发送消息
     *
     * @param packet
     * @return
     */
    ChannelFuture send(Packet packet);

    /**
     * 发送消息
     *
     * @param packet
     * @param listener
     * @return
     */
    ChannelFuture send(Packet packet, ChannelFutureListener listener);

    /**
     * 获取连接ID
     *
     * @return
     */
    String getId();

    /**
     * 关闭连接
     *
     * @return
     */
    ChannelFuture close();

    /**
     *
     * @return
     */
    boolean isConnected();

    boolean isReadTimeout();

    boolean isWriteTimeout();

    void updateLastReadTime();

    void updateLastWriteTime();

    Channel getChannel();

}
