package org.testbedgenerator;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class SingletonFileHandlerTest {
  /**
   * Method under test: {@link SingletonFileHandler#getInstance()}
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SingletonFileHandler actualInstance = SingletonFileHandler.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
