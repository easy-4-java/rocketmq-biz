package org.apache.rocketmq.client.biz.event.handler.chain;

import org.apache.rocketmq.client.biz.event.RocketmqEvent;

/**
 * Contract for a chain of {@link EventHandler}s that process an event sequentially.
 *
 * @param <T> the concrete event type
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see EventHandler
 */
public interface HandlerChain<T extends RocketmqEvent>{

	void doHandler(T event) throws Exception;
	
}
