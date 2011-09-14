/*
Copyright 2011 WebDriver committers
Copyright 2011 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.openqa.selenium.android.server.handler;

import java.util.Map;

import org.openqa.selenium.android.ActivityController;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.DriverSessions;

public class NewSession extends org.openqa.selenium.remote.server.handler.NewSession {

  public NewSession(DriverSessions allSession) {
    super(allSession);
  }

  @Override
  public void setJsonParameters(Map<String, Object> allParameters)
      throws Exception {
    super.setJsonParameters(allParameters);
    ActivityController.getInstance().setCapabilities(new DesiredCapabilities(
        (Map<String, Object>) allParameters.get("desiredCapabilities")));
  }
  
}