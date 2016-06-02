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
import io.typefox.lsapi.services.json.LanguageServerToJsonAdapter
import io.typefox.lsapi.services.json.LoggingJsonAdapter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.io.PrintWriter

/**
 * @author Sven Efftinge - Initial contribution and API
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

		val messageAcceptor = if (IS_DEBUG) {
				new LoggingJsonAdapter(languageServer) => [
					errorLog = new PrintWriter(System.err)
					messageLog = new PrintWriter(System.out)
				]
			} else {
				new LanguageServerToJsonAdapter(languageServer) => [
					protocol.addErrorListener [ p1, p2 |
						p2.printStackTrace(System.err)
					]
				]
			}
		messageAcceptor.connect(in, out)
		System.err.println("started.")
		messageAcceptor.join
		while (true) {
			Thread.sleep(10_000l)
		}
	}

	def static redirectStandardStreams() {
		System.setIn(new ByteArrayInputStream(newByteArrayOfSize(0)))
		val id = ServerLauncher.name + "-" + System.currentTimeMillis
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
