package com.example.crud_app_practice.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.crud_app_practice.models.Product;

@Controller
public class WebSocketController {

  @MessageMapping("/product.notify") // client sends to /app/product.notify
  @SendTo("/topic/products") // server sends to /topic/products)
  public Product notifyProduct(Product payload) {
    // This method can be used to trigger notifications or handle product-related messages
    // Actual logic might involve sending specific product data.
    return payload;
  }
}
