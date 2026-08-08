package org.apache.rocketmq.client.biz.hooks;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.rocketmq.client.consumer.MQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.common.message.MessageQueue;
import org.junit.Test;

/**
 * Tests for {@link MQPushConsumerShutdownHook}.
 */
public class MQPushConsumerShutdownHookTest {

    @Test
    public void shouldExtendThread() {
        MQPushConsumerShutdownHook hook = new MQPushConsumerShutdownHook(new StubConsumer());
        assertTrue(hook instanceof Thread);
    }

    @Test
    public void shouldCallShutdownOnRun() {
        StubConsumer consumer = new StubConsumer();
        MQPushConsumerShutdownHook hook = new MQPushConsumerShutdownHook(consumer);
        hook.run();
        assertTrue(consumer.shutdownCalled.get());
    }

    // Minimal stub for MQPushConsumer
    private static class StubConsumer implements MQPushConsumer {
        final AtomicBoolean shutdownCalled = new AtomicBoolean(false);

        @Override public void start() {}
        @Override public void shutdown() { shutdownCalled.set(true); }
        @Override public void subscribe(String t, String sub) {}
        @Override public void unsubscribe(String t) {}
        @Override public void registerMessageListener(MessageListenerConcurrently l) {}
        @Override public void registerMessageListener(MessageListenerOrderly l) {}
        @Override public Set<MessageQueue> fetchSubscribeMessageQueues(String t) { return null; }
        @Override public void updateCorePoolSize(int s) {}
        @Override public void suspend() {}
        @Override public void suspend(long t) {}
        @Override public void resume() {}
    }
}
