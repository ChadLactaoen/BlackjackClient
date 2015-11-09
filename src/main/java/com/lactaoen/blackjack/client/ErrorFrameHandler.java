package com.lactaoen.blackjack.client;

import com.lactaoen.blackjack.model.wrapper.BlackjackErrorWrapper;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;

/**
 * The handler for incoming errors. This handler is utilized any time you
 * receive messages from the '/queue/errors' subscription channel from the
 * server. This will occur when you submit an invalid bet or action to the
 * server.
 *
 * @author Chad Tomas
 */
public class ErrorFrameHandler implements StompFrameHandler {

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return BlackjackErrorWrapper.class;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        System.out.println("loop");
        // TODO Your custom implementation goes here
    }
}
