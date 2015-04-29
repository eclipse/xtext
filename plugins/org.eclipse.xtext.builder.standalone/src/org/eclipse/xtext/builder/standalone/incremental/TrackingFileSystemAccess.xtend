/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.inject.Inject
import java.io.InputStream
import java.util.List
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.generator.trace.TraceFileNameProvider
import org.eclipse.xtext.util.RuntimeIOException

/**
 * TODO: It'd be nicer to add the event notification to JavaIoFileSystemAccess directly.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
class TrackingFileSystemAccess extends JavaIoFileSystemAccess {

	@Inject TraceFileNameProvider traceFileNameProvider

	val JavaIoFileSystemAccess delegate

	List<Listener> listeners = newArrayList

	new(JavaIoFileSystemAccess delegate) {
		this.delegate = delegate
		outputConfigurations = delegate.outputConfigurations
	}

	def void addListener(Listener listener) {
		listeners.add(listener)
	}

	def void removeListener(Listener listener) {
		listeners.remove(listener)
	}

	override void generateFile(
		String fileName,
		String outputConfigName,
		CharSequence contents
	) throws RuntimeIOException {
		delegate.generateFile(fileName, outputConfigName, contents)
		fireFileAdded(fileName, outputConfigName)
	}

	override generateTrace(String fileName, String outputConfigName, CharSequence contents) {
		delegate.generateTrace(fileName, outputConfigName, contents)
		fireFileAdded(traceFileNameProvider.getTraceFromJava(fileName), outputConfigName)
	}

	override generateFile(String fileName, CharSequence contents) {
		delegate.generateFile(fileName, contents)
		fireFileAdded(fileName, DEFAULT_OUTPUT)
	}

	override generateFile(String fileName, InputStream content) {
		delegate.generateFile(fileName, content)
		fireFileAdded(fileName, DEFAULT_OUTPUT)
	}

	override generateFile(String fileName, String outputConfigName, InputStream content) throws RuntimeIOException {
		delegate.generateFile(fileName, outputConfigName, content)
		fireFileAdded(fileName, outputConfigName)
	}

	override void deleteFile(String fileName, String outputConfiguration) {
		delegate.deleteFile(fileName, outputConfiguration)
		fireFileDeleted(fileName, outputConfiguration)
	}

	override deleteFile(String fileName) {
		delegate.deleteFile(fileName)
		fireFileDeleted(fileName, DEFAULT_OUTPUT)
	}

	def protected void fireFileAdded(String fileName, String outputConfigName) {
		val outputConfig = outputConfigurations.get(outputConfigName)
		listeners.forEach [
			fileAdded(fileName, outputConfig.outputDirectory)
		]
	}

	def protected void fireFileDeleted(String fileName, String outputConfigName) {
		val outputConfig = outputConfigurations.get(outputConfigName)
		listeners.forEach [
			fileDeleted(fileName, outputConfig.outputDirectory)
		]
	}

	static interface Listener {
		def void fileAdded(String outputDir, String fileName)

		def void fileDeleted(String outputDir, String fileName)
	}
}