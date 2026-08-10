package org.apache.rocketmq.client.biz.event.handler;

/**
 * Contract for components that can be identified by a unique name.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 */
public interface Nameable {

	void setName(String name);
	
}
