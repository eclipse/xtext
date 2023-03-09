/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static com.google.common.collect.Maps.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.io.ByteStreams;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 * @since 2.0
 */
public class InMemoryFileSystemAccess extends AbstractFileSystemAccess2 {

	private Map<String, Object> files = newTreeMap(); // the TreeMap sorts all files by name
	
	private String textFileEnconding;
	
	@Override
	public void generateFile(String fileName, String outputConfigName, CharSequence contents) {
		String encoding = getTextFileEncoding();
		if (encoding != null)
			contents = postProcess(fileName, outputConfigName, contents, encoding);
		else
			contents = postProcess(fileName, outputConfigName, contents);
		files.put(getFileName(fileName, outputConfigName), contents);
	}
	
	/**
	 * @since 2.4
	 */
	public String getTextFileEncoding() {
		return textFileEnconding;
	}
	
	/**
	 * @since 2.4
	 */
	public void setTextFileEnconding(String textFileEnconding) {
		this.textFileEnconding = textFileEnconding;
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public void setPostProcessor(IFilePostProcessor postProcessor) {
		super.setPostProcessor(postProcessor);
	}

	/**
	 * @since 2.4
	 */
	protected String getFileName(String fileName, String outputConfigName) {
		return outputConfigName+fileName;
	}

	@Override
	public void deleteFile(String fileName, String outputConfigName) {
		files.remove(getFileName(fileName, outputConfigName));
	}

	/**
	 * @since 2.4
	 */
	public Map<String, CharSequence> getTextFiles() {
		Map<String, CharSequence> result = newLinkedHashMap();
		for (Map.Entry<String, Object> e : files.entrySet())
			if (e.getValue() instanceof CharSequence)
				result.put(e.getKey(), ((CharSequence) e.getValue()));
		return result;
	}

	/**
	 * @since 2.4
	 */
	public Map<String, byte[]> getBinaryFiles() {
		Map<String, byte[]> result = newLinkedHashMap();
		for (Map.Entry<String, Object> e : files.entrySet())
			if (e.getValue() instanceof byte[])
				result.put(e.getKey(), ((byte[]) e.getValue()));
		return result;
	}

	/**
	 * @since 2.4
	 */
	public Map<String, Object> getAllFiles() {
		return files;
	}

	/**
	 * use {@link #getTextFiles()} or {@link #getAllFiles()}.
	 */
	@Deprecated
	public Map<String, CharSequence> getFiles() {
		return getTextFiles();
	}

	/**
	 * @since 2.3
	 */
	@Override
	public URI getURI(String fileName, String outputConfiguration) {
		return URI.createURI("memory:/" + outputConfiguration + "/" + fileName);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public void generateFile(String fileName, String outputCfgName, InputStream content) {
		try {
			try {
				byte[] byteArray = ByteStreams.toByteArray(content);
				files.put(getFileName(fileName, outputCfgName), byteArray);
			} finally {
				content.close();
			}
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.4
	 */
	@Override
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		String name = getFileName(fileName, outputCfgName);
		Object contents = files.get(name);
		if (contents == null)
			throw new RuntimeIOException("File not found: " + name);
		if (contents instanceof byte[])
			return new ByteArrayInputStream((byte[]) contents);
		if (contents instanceof CharSequence)
			return new StringInputStream(contents.toString());
		throw new RuntimeIOException("Unknown File Data Type: " + contents.getClass() + " File: " + name);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		String name = getFileName(fileName, outputCfgName);
		Object contents = files.get(name);
		if (contents == null)
			throw new RuntimeIOException("File not found: " + name);
		if (contents instanceof CharSequence)
			return (CharSequence) contents;
		if (contents instanceof byte[])
			throw new RuntimeIOException("Can not read a binary file using readTextFile(). File: " + name);
		throw new RuntimeIOException("Unknown File Data Type: " + contents.getClass() + " File: " + name);
	}

}
