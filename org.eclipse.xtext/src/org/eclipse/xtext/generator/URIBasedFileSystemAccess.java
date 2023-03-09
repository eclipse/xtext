/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;

/**
 * A file system access implementation that is based on EMF URIs and URIConverter
 * 
 * @since 2.9
 */
public class URIBasedFileSystemAccess extends AbstractFileSystemAccess2 {
	public interface BeforeDelete {
		/**
		 * @return <code>true</code> if the file can be deleted, false otherwise
		 */
		boolean beforeDelete(URI changed);
	}

	public interface BeforeWrite {
		InputStream beforeWrite(URI changed, String outputCfgName, InputStream in);
	}

	public interface BeforeRead {
		InputStream beforeRead(URI changed, InputStream in);
	}

	private URIConverter converter;
	private URI baseDir;
	private boolean generateTraces = false;
	private IEncodingProvider encodingProvider = new IEncodingProvider.Runtime();
	private TraceRegionSerializer traceRegionSerializer;
	private TraceFileNameProvider traceFileNameProvider;
	private URIBasedFileSystemAccess.BeforeDelete beforeDelete = (uri) -> true;
	private URIBasedFileSystemAccess.BeforeWrite beforeWrite = (uri, string, stream) -> stream;
	private URIBasedFileSystemAccess.BeforeRead beforeRead = (uri, stream) -> stream;

	@Override
	public void setPostProcessor(IFilePostProcessor filePostProcessor) {
		super.setPostProcessor(filePostProcessor);
	}

	@Override
	public URI getURI(String path, String outputConfiguration) {
		String outlet = getPathes().get(outputConfiguration);
		if (outlet == null) {
			throw new IllegalArgumentException(
					"A slot with name \'" + outputConfiguration + "\' has not been configured.");
		}
		URI uri = URI.createFileURI(outlet + File.separator + path);
		return baseDir != null ? uri.resolve(baseDir) : uri;
	}

	public String getEncoding(URI uri) {
		return encodingProvider.getEncoding(uri);
	}

	@Override
	public void generateFile(String fileName, String outputCfgName, CharSequence contents) {
		try {
			URI uri = getURI(fileName, outputCfgName);
			if (!getOutputConfig(outputCfgName).isOverrideExistingResources()
					&& converter.exists(uri, Collections.emptyMap())) {
				return;
			}
			String encoding = getEncoding(uri);
			CharSequence postProcessed = postProcess(fileName, outputCfgName, contents, encoding);
			generateTrace(fileName, outputCfgName, postProcessed);
			generateFile(fileName, outputCfgName,
					new ByteArrayInputStream(postProcessed.toString().getBytes(encoding)));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	protected void generateTrace(String generatedFile, String outputConfigName, CharSequence contents) {
		if (isGenerateTraces() && contents instanceof ITraceRegionProvider) {
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				traceRegionSerializer.writeTraceRegionTo(((ITraceRegionProvider) contents).getTraceRegion(), out);
				generateFile(traceFileNameProvider.getTraceFromJava(generatedFile), outputConfigName,
						new ByteArrayInputStream(out.toByteArray()));
			} catch (TraceNotFoundException e) {
				// do not re-throw
			} catch (IOException e) {
				throw new RuntimeIOException(e);
			}
		}
	}

	@Override
	public void generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		try {
			URI uri = getURI(fileName, outputCfgName);
			try (OutputStream out = converter.createOutputStream(uri)) {
				ByteStreams.copy(beforeWrite.beforeWrite(uri, outputCfgName, content), out);
			}
		} catch (IOException t) {
			throw new RuntimeIOException(t);
		}
	}

	@Override
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		try {
			URI uri = getURI(fileName, outputCfgName);
			return beforeRead.beforeRead(uri, converter.createInputStream(uri));
		} catch (IOException t) {
			throw new RuntimeIOException(t);
		}
	}

	@Override
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		try (InputStreamReader reader = new InputStreamReader(readBinaryFile(fileName, outputCfgName),
					getEncoding(getURI(fileName, outputCfgName)))) {
			return CharStreams.toString(reader);
		} catch (RuntimeIOException t) {
			throw t;
		} catch (IOException t) {
			throw new RuntimeIOException(t);
		}
	}

	public URIConverter getConverter() {
		return converter;
	}

	public void setConverter(URIConverter converter) {
		this.converter = converter;
	}

	public URI getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(URI baseDir) {
		this.baseDir = baseDir;
	}

	public boolean isGenerateTraces() {
		return generateTraces;
	}

	public void setGenerateTraces(boolean generateTraces) {
		this.generateTraces = generateTraces;
	}

	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}

	public void setEncodingProvider(IEncodingProvider encodingProvider) {
		this.encodingProvider = encodingProvider;
	}

	public TraceRegionSerializer getTraceRegionSerializer() {
		return traceRegionSerializer;
	}

	public void setTraceRegionSerializer(TraceRegionSerializer traceRegionSerializer) {
		this.traceRegionSerializer = traceRegionSerializer;
	}

	public TraceFileNameProvider getTraceFileNameProvider() {
		return traceFileNameProvider;
	}

	public void setTraceFileNameProvider(TraceFileNameProvider traceFileNameProvider) {
		this.traceFileNameProvider = traceFileNameProvider;
	}

	public URIBasedFileSystemAccess.BeforeDelete getBeforeDelete() {
		return beforeDelete;
	}

	public void setBeforeDelete(URIBasedFileSystemAccess.BeforeDelete beforeDelete) {
		this.beforeDelete = beforeDelete;
	}

	public URIBasedFileSystemAccess.BeforeWrite getBeforeWrite() {
		return beforeWrite;
	}

	public void setBeforeWrite(URIBasedFileSystemAccess.BeforeWrite beforeWrite) {
		this.beforeWrite = beforeWrite;
	}

	public URIBasedFileSystemAccess.BeforeRead getBeforeRead() {
		return beforeRead;
	}

	public void setBeforeRead(URIBasedFileSystemAccess.BeforeRead beforeRead) {
		this.beforeRead = beforeRead;
	}
}
