package org.testbedgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OllamaGenAIRESTHandlerTest {
    /**
     * Method under test:
     * {@link OllamaGenAIRESTHandler#OllamaGenAIRESTHandler(String, String)}
     */
    @Test
    void testNewOllamaGenAIRESTHandler() {
        // Arrange and Act
        OllamaGenAIRESTHandler actualOllamaGenAIRESTHandler = new OllamaGenAIRESTHandler("https://example.org/example",
                "Ollamamodelname");

        // Assert
        assertEquals("Ollamamodelname", actualOllamaGenAIRESTHandler.OLLAMAMODELNAME);
        assertEquals("https://example.org/example", actualOllamaGenAIRESTHandler.OLLAMAURL);
    }
}
