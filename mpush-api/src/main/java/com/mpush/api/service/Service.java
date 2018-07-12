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

package com.mpush.api.service;

import java.util.concurrent.CompletableFuture;

/**
 * @author ohun@live.cn
 */
public interface Service {

    /**
     * 启动
     *
     * @param listener
     */
    void start(Listener listener);

    /**
     * 停止
     *
     * @param listener
     */
    void stop(Listener listener);

    /**
     * 启动
     *
     * @return
     */
    CompletableFuture<Boolean> start();

    /**
     * 停止
     *
     * @return
     */
    CompletableFuture<Boolean> stop();

    /**
     * 同步启动
     *
     * @return
     */
    boolean syncStart();

    /**
     * 同步停止
     *
     * @return
     */
    boolean syncStop();

    /**
     * 初始化
     */
    void init();

    /**
     * 是否启动
     *
     * @return
     */
    boolean isRunning();

}
