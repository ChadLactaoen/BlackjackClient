package com.lactaoen.blackjack.client;

import com.lactaoen.blackjack.client.util.JsonUtils;
import com.lactaoen.blackjack.model.wrapper.RegistrationWrapper;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * @author Chad Tomas
 */
public class BlackjackClient {

    private static final WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

    // TODO Change this URL if you're attempting to a hit a non-local server
    private static final String URL = "ws://localhost:8080/connect";

    // TODO Change to your own name. This is the name you will use to register with the server
    private static final String NAME = UUID.randomUUID().toString().substring(0, 6);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // DO NOT EDIT ANY OF THE CODE IN THIS METHOD
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        // transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient = new SockJsClient(transports);
        sockJsClient.setMessageCodec(new Jackson2SockJsMessageCodec());
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        //stompClient.setMessageConverter(new StringMessageConverter());

        ListenableFuture<StompSession> f = stompClient.connect(URL, headers, new BlackjackSessionHandler());
        StompSession stompSession = f.get();
        subscribePlayer(stompSession);
        System.out.println("Got h");
        Thread.sleep(60000);
    }

    private static void subscribePlayer(StompSession session) {
        session.subscribe("/user/queue/player", new PlayerFrameHandler());
        session.send("/app/register", org.springframework.util.SerializationUtils.serialize("{'name' : '" + NAME + "'}"));
    }
}
