/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator

import com.google.common.io.ByteStreams
import com.google.common.io.CharStreams
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.InputStreamReader
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.generator.trace.TraceFileNameProvider
import org.eclipse.xtext.generator.trace.TraceRegionSerializer
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.util.RuntimeIOException
import java.io.ByteArrayOutputStream

/**
 * A file system access implementation that is based on EMF URIs and URIConverter
 * @since 2.9
 */
class URIBasedFileSystemAccess extends AbstractFileSystemAccess2 {
	
	static interface BeforeDelete {
		/**
		 * @return <code>true</code> if the file can be deleted, false otherwise
		 */
		def boolean beforeDelete(URI changed)
	}
	
	static interface BeforeWrite {
		def InputStream beforeWrite(URI changed, String outputCfgName, InputStream in)
	}
	
	static interface BeforeRead {
		def InputStream beforeRead(URI changed, InputStream in)
	}
	
	@Accessors URIConverter converter
	@Accessors URI baseDir
	@Accessors boolean generateTraces = false
	@Accessors IEncodingProvider encodingProvider = new IEncodingProvider.Runtime()
	@Accessors TraceRegionSerializer traceRegionSerializer
	@Accessors TraceFileNameProvider traceFileNameProvider
	@Accessors BeforeDelete beforeDelete = [true]
	@Accessors BeforeWrite beforeWrite = [$2]
	@Accessors BeforeRead beforeRead = [$1]
	
	public override void setPostProcessor(IFilePostProcessor filePostProcessor) {
		super.postProcessor = filePostProcessor
	}

	override getURI(String path, String outputConfiguration) {
		val outlet = pathes.get(outputConfiguration)
		if (outlet == null)
			throw new IllegalArgumentException("A slot with name '" + outputConfiguration + "' has not been configured.");
		val uri = URI.createURI(outlet + "/" + path)
		if (baseDir != null) {
			val resolved = uri.resolve(baseDir);
			return resolved
		} else {
			return uri;
		}
	}
	
	def String getEncoding(URI uri) {
		return encodingProvider.getEncoding(uri)
	}
	
	override generateFile(String fileName, String outputCfgName, CharSequence contents) {
		val uri = getURI(fileName, outputCfgName)
		if (!getOutputConfig(outputCfgName).isOverrideExistingResources && converter.exists(uri, emptyMap)) {
			return;
		}
		val encoding = getEncoding(uri)
		val postProcessed = postProcess(fileName, outputCfgName, contents, encoding)
		generateTrace(fileName, outputCfgName, postProcessed)
		val inStream = new ByteArrayInputStream(postProcessed.toString.getBytes(encoding))
		generateFile(fileName, outputCfgName, inStream)
	}
	
	protected def void generateTrace(String generatedFile, String outputConfigName, CharSequence contents) {
		if (isGenerateTraces && contents instanceof ITraceRegionProvider) {
			var String traceFileName = traceFileNameProvider.getTraceFromJava(generatedFile)
			val out = new ByteArrayOutputStream()
			var AbstractTraceRegion traceRegion = (contents as ITraceRegionProvider).getTraceRegion()
			traceRegionSerializer.writeTraceRegionTo(traceRegion, out)
			generateFile(traceFileName, outputConfigName, new ByteArrayInputStream(out.toByteArray))
		}
	}
	
	override generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		val uri = getURI(fileName, outputCfgName)
		val out = converter.createOutputStream(uri)
		try {
			val processedContent = beforeWrite.beforeWrite(uri, outputCfgName, content)
			ByteStreams.copy(processedContent, out);
		} finally {
			out.close
		}
	}
	
	override readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		val uri = getURI(fileName, outputCfgName)
		val input = converter.createInputStream(uri)
		return beforeRead.beforeRead(uri, input)
	}
	
	override readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		val uri = getURI(fileName, outputCfgName)
		val inputstream = readBinaryFile(fileName, outputCfgName)
		return CharStreams.toString(new InputStreamReader(inputstream, getEncoding(uri)))
	}
	
}