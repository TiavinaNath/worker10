package com.example.demo.endpoint.event.model;

import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_1;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_2;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_3;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_4;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_5;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_6;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_7;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_8;
import static com.example.demo.endpoint.event.EventStack.EVENT_STACK_9;
import static java.lang.Math.random;

import com.example.demo.PojaGenerated;
import com.example.demo.endpoint.event.EventStack;
import java.io.Serializable;
import java.time.Duration;
import lombok.Getter;
import lombok.Setter;

@PojaGenerated
public abstract class PojaEvent implements Serializable {

  @Getter @Setter protected int attemptNb;

  public abstract Duration maxConsumerDuration();

  public Duration eventHandlerInitMaxDuration() {
    return Duration.ofSeconds(90); // note(init-visibility)
  }

  private Duration randomConsumerBackoffBetweenRetries() {
    return Duration.ofSeconds((int) (random() * maxConsumerBackoffBetweenRetries().toSeconds()));
  }

  public abstract Duration maxConsumerBackoffBetweenRetries();

  public final Duration randomVisibilityTimeout() {
    return Duration.ofSeconds(
        eventHandlerInitMaxDuration().toSeconds()
            + maxConsumerDuration().toSeconds()
            + randomConsumerBackoffBetweenRetries().toSeconds());
  }

  public EventStack getEventStack() {
    return EVENT_STACK_1;
  }

  public String getEventSource() {
    if (getEventStack().equals(EVENT_STACK_1)) return "com.example.demo.event1";
    if (getEventStack().equals(EVENT_STACK_2)) return "com.example.demo.event2";
    if (getEventStack().equals(EVENT_STACK_3)) return "com.example.demo.event3";
    if (getEventStack().equals(EVENT_STACK_4)) return "com.example.demo.event4";
    if (getEventStack().equals(EVENT_STACK_5)) return "com.example.demo.event5";
    if (getEventStack().equals(EVENT_STACK_6)) return "com.example.demo.event6";
    if (getEventStack().equals(EVENT_STACK_7)) return "com.example.demo.event7";
    if (getEventStack().equals(EVENT_STACK_8)) return "com.example.demo.event8";
    if (getEventStack().equals(EVENT_STACK_9)) return "com.example.demo.event9";
    return "com.example.demo.event10";
  }
}
