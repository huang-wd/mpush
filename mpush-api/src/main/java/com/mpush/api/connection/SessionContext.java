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


import com.mpush.api.router.ClientClassifier;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by ohun on 2015/12/22.
 *
 * @author ohun@live.cn
 */
@Data
@Accessors(chain = true)
public final class SessionContext {
    public String osName;
    public String osVersion;
    public String clientVersion;
    public String deviceId;
    public String userId;
    public String tags;
    /**
     * 10s
     */
    public int heartbeat = 10000;
    public Cipher cipher;
    private byte clientType;

    public boolean handshakeOk() {
        return deviceId != null && deviceId.length() > 0;
    }

    public int getClientType() {
        if (clientType == 0) {
            clientType = (byte) ClientClassifier.I.getClientType(osName);
        }
        return clientType;
    }

    public boolean isSecurity() {
        return cipher != null;
    }

    @Override
    public String toString() {
        if (userId == null && deviceId == null) {
            return "";
        }

        return "{" +
                "osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", userId='" + userId + '\'' +
                ", tags='" + tags + '\'' +
                ", heartbeat=" + heartbeat +
                '}';
    }
}
