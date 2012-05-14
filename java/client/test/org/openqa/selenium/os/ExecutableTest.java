package org.openqa.selenium.os;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.internal.Executable;

import java.io.File;

public class ExecutableTest {

  private String executableName = Platform.getCurrent().is(Platform.MAC) ?
      "/Applications/Firefox.app/Contents/Resources/firefox" : "firefox";

  @Test
  public void testEnvironmentDiscovery() {
    if (CommandLine.find(executableName) == null) {
      System.out.println("Skipping test: no firefox present");
      return;
    }

    Executable env = new Executable(null);
    File exe = env.getFile();
    assertNotNull(exe);
    assertFalse(exe.isDirectory());
  }
}