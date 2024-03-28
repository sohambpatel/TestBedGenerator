package org.testbedgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CommandExecuterTest {
  /**
   * Method under test: {@link CommandExecuter#executeCommand(String)}
   */
  @Test
  void testExecuteCommand() throws IOException {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Process process = mock(Process.class);
      when(process.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
      Runtime runtime = mock(Runtime.class);
      when(runtime.exec(Mockito.<String>any())).thenReturn(process);
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);

      // Act
      String actualExecuteCommandResult = CommandExecuter.executeCommand("Command");

      // Assert
      verify(process).getInputStream();
      verify(runtime).exec(eq("Command"));
      mockRuntime.verify(Runtime::getRuntime);
      assertEquals("AXAXAXAX", actualExecuteCommandResult);
    }
  }
}
