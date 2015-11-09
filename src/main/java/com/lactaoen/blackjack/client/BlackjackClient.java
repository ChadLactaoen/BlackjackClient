package com.lactaoen.blackjack.client;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Chad Tomas
 */
public class BlackjackClient {

    private static final WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

    // TODO Change this URL if you're attempting to a hit a non-local server
    private static final String URL = "ws://localhost:8080/connect";

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // DO NOT EDIT ANY OF THE CODE IN THIS METHOD
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));

        SockJsClient sockJsClient = new SockJsClient(transports);
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        stompClient.connect(URL, headers, new BlackjackSessionHandler());
        Thread.sleep(60000);
    }
}
