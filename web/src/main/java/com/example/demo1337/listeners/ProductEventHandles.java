package com.example.demo1337.listeners;

import com.example.demo1337.model.events.ProductCreatedEvent;
import com.example.demo1337.service.BooksService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandles {

    private final BooksService productService;

    public ProductEventHandles(BooksService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent event) {
        this.productService.refreshMaterializedView();
    }
}

