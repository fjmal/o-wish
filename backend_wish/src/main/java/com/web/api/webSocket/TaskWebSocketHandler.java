package com.web.api.webSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.server.standard.SpringConfigurator;

@ServerEndpoint(value = "/webSocket/owish", configurator = SpringConfigurator.class)
public class TaskWebSocketHandler implements WebSocketHandler {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	private static final Logger LOG = Logger.getLogger(TaskWebSocketHandler.class.getName());

	@OnMessage
	public String onMessage(String message) {
		if (message != null) {
			for (Session session : clients) {

				try {
					session.getBasicRemote().sendText(message);
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}

			}
		}
		return message;

	}

	@OnOpen
	public void onOpen(Session session) {
		LOG.info("Connection opened ...");
		clients.add(session);
	}

	@OnClose
	public void onClose(CloseReason reason, Session session) {
		LOG.info("Connection closed ...");
		clients.remove(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1) throws Exception {

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession arg0) throws Exception {

	}

	@Override
	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1) throws Exception {

	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}