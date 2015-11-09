package com.lactaoen.blackjack.client;

import com.lactaoen.blackjack.model.wrapper.GameInfoWrapper;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;

/**
 * The handler for game information. This handler is utilized any time you
 * receive messages from the 'topic/game' subscription channel from the
 * server. This will occur when a player sends a bet or hand action.
 *
 * @author Chad Tomas
 */
public class GameFrameHandler implements StompFrameHandler {

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return GameInfoWrapper.class;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        System.out.println("Got here");
        // TODO Your custom implementation goes here
    }
}
