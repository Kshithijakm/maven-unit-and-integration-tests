package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppIntegrationIT {
    @Test
    public void testIntegration() {
        MessageService service = new MessageService();
        App app = new App(service);
        
        // This is integration: Testing if App correctly calls MessageService
        assertEquals("Hello from the Service!", app.getFullMessage());
    }
}
