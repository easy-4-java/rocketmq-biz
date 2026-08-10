package org.apache.rocketmq.client.biz.event.handler.chain;

import org.apache.rocketmq.client.biz.event.RocketmqEvent;

/**
 * Resolves the appropriate {@link HandlerChain} for a given event.
 *
 * @param <T> the concrete event type
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see HandlerChain
 */
public interface HandlerChainResolver<T extends RocketmqEvent> {

	HandlerChain<T> getChain(T event , HandlerChain<T> originalChain);
	
}
