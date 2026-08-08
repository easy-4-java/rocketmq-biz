package org.apache.rocketmq.client.biz.exception;

import static org.junit.Assert.*;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.ResponseCode;
import org.junit.Test;

/**
 * Tests for {@link RocketMQException}.
 */
public class RocketMQExceptionTest {

    @Test
    public void shouldCreateWithResponseCodeAndMessage() {
        RocketMQException ex = new RocketMQException(ResponseCode.TOPIC_NOT_EXIST.getCode(), "topic missing");
        assertEquals("topic missing", ex.getErrorMessage());
        assertEquals(ResponseCode.TOPIC_NOT_EXIST.getCode(), ex.getResponseCode());
    }

    @Test
    public void shouldCreateWithException() {
        Exception cause = new RuntimeException("cause");
        RocketMQException ex = new RocketMQException(cause);
        assertEquals("cause", ex.getErrorMessage());
    }

    @Test
    public void shouldCreateWithErrorMessage() {
        RocketMQException ex = new RocketMQException("something failed");
        assertEquals("something failed", ex.getErrorMessage());
    }

    @Test
    public void shouldCreateWithErrorMessageAndCause() {
        Throwable cause = new RuntimeException("root");
        RocketMQException ex = new RocketMQException("error", cause);
        assertEquals("error", ex.getErrorMessage());
        assertSame(cause, ex.getCause());
    }

    @Test
    public void shouldBeMQClientException() {
        RocketMQException ex = new RocketMQException("test");
        assertTrue(ex instanceof MQClientException);
    }
}
