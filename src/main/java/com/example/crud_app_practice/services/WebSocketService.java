package com.example.crud_app_practice.services;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
  private final SimpMessagingTemplate messagingTemplate;

  public WebSocketService(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  public void sendProductUpdate(Object payload) {
    messagingTemplate.convertAndSend("/topic/products",payload);
  }

  public void sendCategoryUpdate(Object payload) {
    messagingTemplate.convertAndSend("/topic/categories", payload);
  }
}
