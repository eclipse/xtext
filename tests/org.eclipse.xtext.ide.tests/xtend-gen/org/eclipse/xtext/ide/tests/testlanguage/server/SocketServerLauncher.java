/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.typefox.lsapi.services.LanguageServer;
import io.typefox.lsapi.services.json.LanguageServerLauncher;
import java.net.InetSocketAddress;
import org.eclipse.xtext.ide.server.ServerModule;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SocketServerLauncher {
  public static void main(final String[] args) {
    ServerModule _serverModule = new ServerModule();
    final Injector injector = Guice.createInjector(_serverModule);
    final LanguageServer languageServer = injector.<LanguageServer>getInstance(LanguageServer.class);
    InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 5007);
    final LanguageServerLauncher launcher = LanguageServerLauncher.newLoggingLauncher(languageServer, _inetSocketAddress);
    launcher.launch();
  }
}
