/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.common.io.ByteStreams
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import java.io.ByteArrayInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.io.PrintWriter
import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
class ServerLauncher {

	public static val LOG = '-log'
	public static val TRACE = '-trace'
	public static val NO_VALIDATE = '-noValidate'

	def static void main(String[] args) {
		launch(ServerLauncher.name, args, new ServerModule)
	}

	def static void launch(String prefix, String[] args, Module... modules) {
		val launchArgs = createLaunchArgs(prefix, args)

		val launcher = Guice.createInjector(modules).getInstance(ServerLauncher)
		launcher.start(launchArgs)
	}

	@Inject LanguageServerImpl languageServer

	def void start(LaunchArgs it) {
		println("Xtext Language Server is starting.")
		val launcher = Launcher.createLauncher(languageServer, LanguageClient, in, out, validate, trace)
		languageServer.connect(launcher.remoteProxy)
		val future = launcher.startListening
		println("Xtext Language Server has been started.")
		while (!future.done) {
			Thread.sleep(10_000l)
		}
	}

	def static LaunchArgs createLaunchArgs(String prefix, String[] args) {
		val launchArgs = new LaunchArgs
		launchArgs.in = System.in
		launchArgs.out = System.out
		redirectStandardStreams(prefix, args)
		launchArgs.trace = args.trace
		launchArgs.validate = args.shouldValidate
		return launchArgs
	}

	def static PrintWriter getTrace(String[] args) {
		if (shouldTrace(args))
			return createTrace
	}

	def static PrintWriter createTrace() {
		return new PrintWriter(System.out)
	}

	def static redirectStandardStreams(String prefix, String[] args) {
		if (shouldLogStandardStreams(args)) {
			logStandardStreams(prefix)
		} else {
			silentStandardStreams
		}
	}

	def static boolean shouldValidate(String[] args) {
		return !args.testArg(NO_VALIDATE)
	}

	def static boolean shouldTrace(String[] args) {
		return args.testArg(TRACE)
	}

	def static boolean shouldLogStandardStreams(String[] args) {
		return args.testArg(ServerLauncher.LOG, 'debug')
	}

	def static boolean testArg(String[] args, String ... values) {
		return args.exists[arg|arg.testArg(values)]
	}

	def static boolean testArg(String arg, String ... values) {
		return values.exists[value|value == arg]
	}

	def static void logStandardStreams(String prefix) {
		val stdFileOut = new FileOutputStream(prefix + "-debug.log")
		redirectStandardStreams(stdFileOut)
	}

	def static void silentStandardStreams() {
		redirectStandardStreams(ServerLauncher.silentOut)
	}

	def static void redirectStandardStreams(OutputStream out) {
		redirectStandardStreams(ServerLauncher.silentIn, out)
	}

	def static void redirectStandardStreams(InputStream in, OutputStream out) {
		System.setIn(in)
		System.setOut(new PrintStream(out))
	}

	def static OutputStream silentOut() {
		ByteStreams.nullOutputStream
	}

	def static InputStream silentIn() {
		new ByteArrayInputStream(newByteArrayOfSize(0))
	}

}

@Accessors
class LaunchArgs {
	InputStream in
	OutputStream out
	PrintWriter trace
	boolean validate
}
