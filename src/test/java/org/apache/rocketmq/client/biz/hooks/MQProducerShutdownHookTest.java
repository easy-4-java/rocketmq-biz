package org.apache.rocketmq.client.biz.hooks;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.rocketmq.client.producer.MQProducer;
import org.junit.Test;

/**
 * Tests for {@link MQProducerShutdownHook}.
 */
public class MQProducerShutdownHookTest {

    @Test
    public void shouldExtendThread() {
        MQProducerShutdownHook hook = new MQProducerShutdownHook(new StubProducer());
        assertTrue(hook instanceof Thread);
    }

    @Test
    public void shouldCallShutdownOnRun() {
        StubProducer producer = new StubProducer();
        MQProducerShutdownHook hook = new MQProducerShutdownHook(producer);
        hook.run();
        assertTrue(producer.shutdownCalled.get());
    }

    // Minimal stub for MQProducer
    private static class StubProducer implements MQProducer {
        final AtomicBoolean shutdownCalled = new AtomicBoolean(false);

        @Override public void start() {}
        @Override public void shutdown() { shutdownCalled.set(true); }
        @Override public java.util.List<org.apache.rocketmq.common.message.MessageQueue> fetchPublishMessageQueues(String t) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, long t) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.SendCallback cb) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.SendCallback cb, long t) { return null; }
        @Override public void sendOneway(org.apache.rocketmq.common.message.Message m) {}
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.common.message.MessageQueue mq) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.common.message.MessageQueue mq, long t) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.common.message.MessageQueue mq, org.apache.rocketmq.client.producer.SendCallback cb) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.common.message.MessageQueue mq, org.apache.rocketmq.client.producer.SendCallback cb, long t) { return null; }
        @Override public void sendOneway(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.common.message.MessageQueue mq) {}
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.MessageQueueSelector s, Object a) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.MessageQueueSelector s, Object a, long t) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.MessageQueueSelector s, Object a, org.apache.rocketmq.client.producer.SendCallback cb) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.MessageQueueSelector s, Object a, org.apache.rocketmq.client.producer.SendCallback cb, long t) { return null; }
        @Override public void sendOneway(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.MessageQueueSelector s, Object a) {}
        @Override public org.apache.rocketmq.client.producer.TransactionSendResult sendMessageInTransaction(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.LocalTransactionExecuter e, Object a) { return null; }
        @Override public java.util.concurrent.Future<org.apache.rocketmq.client.producer.SendResult> send(org.apache.rocketmq.common.message.Message m, org.apache.rocketmq.client.producer.MessageQueue mq, org.apache.rocketmq.client.producer.SendCallback cb, long t, boolean b) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(java.util.Collection<org.apache.rocketmq.common.message.Message> msgs) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(java.util.Collection<org.apache.rocketmq.common.message.Message> msgs, long t) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(java.util.Collection<org.apache.rocketmq.common.message.Message> msgs, org.apache.rocketmq.common.message.MessageQueue mq) { return null; }
        @Override public org.apache.rocketmq.client.producer.SendResult send(java.util.Collection<org.apache.rocketmq.common.message.Message> msgs, org.apache.rocketmq.common.message.MessageQueue mq, long t) { return null; }
        @Override public org.apache.rocketmq.client.producer.DefaultMQProducer getDefaultMQProducer() { return null; }
    }
}
