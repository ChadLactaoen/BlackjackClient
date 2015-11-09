package com.lactaoen.blackjack.client.util;

import org.springframework.messaging.simp.stomp.StompHeaders;

public class StompHeaderUtil {

    /**
     * Configures STOMP headers to use destination.
     *
     * @param destination The destination endpoint
     * @return STOMP headers
     */
    public static StompHeaders configureHeaders(String destination) {
        StompHeaders headers = new StompHeaders();
        headers.setDestination(destination);
        return headers;
    }
}
