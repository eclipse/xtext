/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.server

import com.google.inject.Guice
import io.typefox.lsapi.services.LanguageServer
import io.typefox.lsapi.services.json.LanguageServerLauncher
import java.net.InetSocketAddress
import org.eclipse.xtext.ide.server.ServerModule

/**
 * @author kosyakov - Initial contribution and API
 */
class SocketServerLauncher {

	def static void main(String[] args) {
		val injector = Guice.createInjector(new ServerModule)
		val languageServer = injector.getInstance(LanguageServer)
		val launcher = LanguageServerLauncher.newLoggingLauncher(
			languageServer,
			new InetSocketAddress('localhost', 5007)
		)
		launcher.launch
	}

}
