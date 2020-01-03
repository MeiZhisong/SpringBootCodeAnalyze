/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;

/** 
 * 用于监听SpringApplication的run方法。
 *
 * @author Phillip Webb
 * @author Dave Syer
 * @author Andy Wilkinson
 * @since 1.0.0
 */
public interface SpringApplicationRunListener {

	/**
	 * 当run方法第一次启动的时候，立刻调用
	 */
	default void starting() {
	}

	/**
	 * 当环境已经准备完成的时候，立刻调用。但是在ApplicationContext被创建之前。
	 * @param environment 准备的环境
	 */
	default void environmentPrepared(ConfigurableEnvironment environment) {
	}

	/**
	 * 一旦，ApplicationContext被创建并且准备完成，就立刻调用。但是在资源加载之前。
	 * @param context 应用上下文
	 */
	default void contextPrepared(ConfigurableApplicationContext context) {
	}

	/**
	 * 应用上下文加载完成时，立刻调用。但是在它被刷新之前。
	 * @param context 应用上下文
	 */
	default void contextLoaded(ConfigurableApplicationContext context) {
	}

	/**
	 * 上下文已经被刷新并且应用程序已经启动了，但是CommandLineRunner和ApplicationRunner这时候还没有被调用。
	 * @param context 应用上下文
	 * @since 2.0.0
	 */
	default void started(ConfigurableApplicationContext context) {
	}

	/**
	 * 在run方法完成的时候，立刻调用。这时候应用上下文已经刷新完成并且所有的CommandLineRunner和ApplicationRunner已经被调用了
	 * @param context 应用上下文
	 * @since 2.0.0
	 */
	default void running(ConfigurableApplicationContext context) {
	}

	/**
	 * 在运行应用程序的时候，遇到错误时，被调用。
	 * @param context 应用上下文
	 * @param exception 异常
	 * @since 2.0.0
	 */
	default void failed(ConfigurableApplicationContext context, Throwable exception) {
	}

}
