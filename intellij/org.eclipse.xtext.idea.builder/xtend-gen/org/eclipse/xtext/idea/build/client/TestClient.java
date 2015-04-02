package org.eclipse.xtext.idea.build.client;

import org.eclipse.xtext.idea.build.client.DaemonConnector;

@SuppressWarnings("all")
public class TestClient {
  public static void main(final String[] args) {
    DaemonConnector _daemonConnector = new DaemonConnector();
    _daemonConnector.connect();
  }
}
