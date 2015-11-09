package com.lactaoen.blackjack.client;

import com.lactaoen.blackjack.model.PlayerInfo;
import com.lactaoen.blackjack.model.wrapper.RegistrationWrapper;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;

/**
 * The handler for player information. This handler is utilized any time you
 * receive messages from the '/queue/player' subscription channel from the
 * server. This will occur when you register or unregister a player from the
 * server.
 *
 * @author Chad Tomas
 */
public class PlayerFrameHandler implements StompFrameHandler {

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return PlayerInfo.class;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        System.out.println("boop");
        // TODO Your custom implementation goes here
    }
}
