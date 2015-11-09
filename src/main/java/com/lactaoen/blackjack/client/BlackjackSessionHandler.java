package com.lactaoen.blackjack.client;

import com.lactaoen.blackjack.client.util.StompHeaderUtil;
import com.lactaoen.blackjack.model.wrapper.BetWrapper;
import com.lactaoen.blackjack.model.wrapper.RegistrationWrapper;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.util.UUID;

/**
 * @author Chad Tomas
 */
public class BlackjackSessionHandler extends StompSessionHandlerAdapter {

    // TODO Change to your own name. This is the name you will use to register with the server
    private static final String NAME = UUID.randomUUID().toString().substring(0, 6);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        BlackjackFrameHandler blackjackHandler = new BlackjackFrameHandler(session);

        // Subscribe to the player channel
        session.subscribe("/user/queue/player", blackjackHandler);
        // Subscribe to the error channel
        session.subscribe("/user/queue/errors", blackjackHandler);
        // Subscribe to the game channel for game event messages
        session.subscribe("/topic/game", blackjackHandler);

        // Sends name and tries to register into the game. Handle the response in BlackjackFrameHandler class
        session.send(StompHeaderUtil.configureHeaders("/app/register"), new RegistrationWrapper(NAME));
    }


}
