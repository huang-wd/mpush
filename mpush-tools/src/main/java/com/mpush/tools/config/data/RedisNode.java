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
 */

package com.mpush.tools.config.data;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * redis 相关的配置信息
 *
 * @author
 */
@Data
@NoArgsConstructor
public class RedisNode {
    public String host;
    public int port;

    public RedisNode(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static RedisNode from(String config) {
        String[] array = config.split(":");
        if (array.length == 2) {
            return new RedisNode(array[0], Integer.parseInt(array[1]));
        } else {
            return new RedisNode(array[0], Integer.parseInt(array[1]));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedisNode server = (RedisNode) o;
        if (port != server.port) {
            return false;
        }
        return host.equals(server.host);
    }
}
