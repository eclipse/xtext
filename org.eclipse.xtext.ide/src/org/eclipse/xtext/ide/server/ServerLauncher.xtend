/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.common.io.ByteStreams
import com.google.inject.Guice
import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.io.PrintWriter
import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.services.LanguageClient

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
class ServerLauncher {

	public static val OPTION_PREFIX = '-Dorg.eclipse.xtext.ide.server.'
	public static val LOG_STANDARD_STREAMS = OPTION_PREFIX + 'logStandardStreams'
	public static val TRACE = OPTION_PREFIX + 'trace'

	def static void main(String[] args) {
		val stdin = System.in
		val stdout = System.out
		redirectStandardStreams(args)
		val trace = args.trace

		val launcher = Guice.createInjector(new ServerModule).getInstance(ServerLauncher)
		launcher.start(stdin, stdout, trace)
	}

	@Inject LanguageServerImpl languageServer

	def void start(InputStream in, OutputStream out, PrintWriter trace) {
		println("Xtext Language Server is starting.")
		val launcher = Launcher.createLauncher(languageServer, LanguageClient, in, out, true, trace)
		languageServer.connect(launcher.remoteProxy)
		val future = launcher.startListening
		println("Xtext Language Server has been started.")
		while (!future.done) {
			Thread.sleep(10_000l)
		}
	}

	def static PrintWriter getTrace(String[] args) {
		if (shouldTrace(args))
			return createTrace
	}

	def static PrintWriter createTrace() {
		return new PrintWriter(System.out)
	}

	def static redirectStandardStreams(String[] args) {
		redirectStandardStreams(ServerLauncher.name, args)
	}

	def static redirectStandardStreams(String prefix, String[] args) {
		if (shouldLogStandardStreams(args)) {
			logStandardStreams(prefix)
		} else {
			silentStandardStreams
		}
	}

	def static boolean shouldTrace(String[] args) {
		return args.testArg(TRACE)
	}

	def static boolean shouldLogStandardStreams(String[] args) {
		return args.testArg(LOG_STANDARD_STREAMS, 'debug')
	}

	def static boolean testArg(String[] args, String ... values) {
		return args.exists[testArg(values)]
	}

	def static boolean testArg(String arg, String ... values) {
		return values.exists[value|value === arg]
	}

	def static void logStandardStreams(String prefix) {
		val stdFileOut = new FileOutputStream(prefix + "-debug.log")
		val stdFileErr = new FileOutputStream(prefix + "-error.log")
		redirectStandardStreams(stdFileOut, stdFileErr)
	}

	def static void silentStandardStreams() {
		redirectStandardStreams(ServerLauncher.silentOut, ServerLauncher.silentOut)
	}

	def static void redirectStandardStreams(OutputStream out, OutputStream err) {
		redirectStandardStreams(ServerLauncher.silentIn, out, err)
	}

	def static void redirectStandardStreams(InputStream in, OutputStream out, OutputStream err) {
		System.setIn(in)
		System.setOut(new PrintStream(out))
		System.setErr(new PrintStream(err))
	}

	def static OutputStream silentOut() {
		ByteStreams.nullOutputStream
	}

	def static InputStream silentIn() {
		new ByteArrayInputStream(newByteArrayOfSize(0))
	}

}
