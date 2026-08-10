package org.apache.rocketmq.client.biz.hooks;

import org.apache.rocketmq.client.consumer.MQPushConsumer;

/**
 * JVM shutdown hook that gracefully shuts down a RocketMQ {@link MQPushConsumer}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see org.apache.rocketmq.client.consumer.MQPushConsumer
 */
public class MQPushConsumerShutdownHook extends Thread{
	
	private MQPushConsumer consumer;
	
	public MQPushConsumerShutdownHook(MQPushConsumer consumer) {
		this.consumer = consumer;
	}
	
	@Override
	public void run() {
		consumer.shutdown();
	}
	
}
