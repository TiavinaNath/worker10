package com.example.demo.endpoint.event;

import static java.lang.System.getenv;

import com.example.demo.PojaGenerated;
import lombok.Getter;

@PojaGenerated
public enum EventStack {
  EVENT_STACK_1(getenv("AWS_EVENT_STACK_1_SQS_QUEUE_URL")),
  EVENT_STACK_2(getenv("AWS_EVENT_STACK_2_SQS_QUEUE_URL")),
  EVENT_STACK_3(getenv("AWS_EVENT_STACK_3_SQS_QUEUE_URL")),
  EVENT_STACK_4(getenv("AWS_EVENT_STACK_4_SQS_QUEUE_URL")),
  EVENT_STACK_5(getenv("AWS_EVENT_STACK_5_SQS_QUEUE_URL")),
  EVENT_STACK_6(getenv("AWS_EVENT_STACK_6_SQS_QUEUE_URL")),
  EVENT_STACK_7(getenv("AWS_EVENT_STACK_7_SQS_QUEUE_URL")),
  EVENT_STACK_8(getenv("AWS_EVENT_STACK_8_SQS_QUEUE_URL")),
  EVENT_STACK_9(getenv("AWS_EVENT_STACK_9_SQS_QUEUE_URL")),
  EVENT_STACK_10(getenv("AWS_EVENT_STACK_10_SQS_QUEUE_URL"));

  @Getter private final String sqsQueueUrl;

  EventStack(String sqsQueueUrl) {
    this.sqsQueueUrl = sqsQueueUrl;
  }
}
