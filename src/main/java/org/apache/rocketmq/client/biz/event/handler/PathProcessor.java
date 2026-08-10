package org.apache.rocketmq.client.biz.event.handler;

import org.apache.rocketmq.client.biz.event.RocketmqEvent;

/**
 * Contract for associating a path pattern with an {@link EventHandler}.
 *
 * @param <T> the concrete event type
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see EventHandler
 */
public interface PathProcessor<T extends RocketmqEvent> {
	
	EventHandler<T> processPath(String path);

}
