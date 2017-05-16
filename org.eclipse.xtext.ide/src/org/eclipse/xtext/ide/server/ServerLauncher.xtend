/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Guice
import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.io.PrintWriter
import java.sql.Timestamp
import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.services.LanguageClient

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
class ServerLauncher {

	private static boolean IS_DEBUG = false

	def static void main(String[] args) {
		IS_DEBUG = args.exists[it == 'debug']
		val stdin = System.in
		val stdout = System.out
		redirectStandardStreams()
		val launcher = Guice.createInjector(new ServerModule).getInstance(ServerLauncher)
		launcher.start(stdin, stdout)
	}

	@Inject LanguageServerImpl languageServer

	def void start(InputStream in, OutputStream out) {
		System.err.println("Starting Xtext Language Server.")
		val launcher = Launcher.createLauncher(languageServer, LanguageClient, in, out, true, new PrintWriter(System.out))
		languageServer.connect(launcher.remoteProxy)
		val future = launcher.startListening
		System.err.println("started.")
		while (!future.done) {
			Thread.sleep(10_000l)
		}
	}

	def static redirectStandardStreams() {
		System.setIn(new ByteArrayInputStream(newByteArrayOfSize(0)))
		val id = (ServerLauncher.name + "-" + new Timestamp(System.currentTimeMillis)).replace(" ", "_")
		if (IS_DEBUG) {
			val stdFileOut = new FileOutputStream("out-" + id + ".log")
			System.setOut(new PrintStream(stdFileOut))
			val stdFileErr = new FileOutputStream("error-" + id + ".log")
			System.setErr(new PrintStream(stdFileErr))
		} else {
			System.setOut(new PrintStream(new ByteArrayOutputStream()))
			System.setErr(new PrintStream(new ByteArrayOutputStream()))
		}
	}

}
