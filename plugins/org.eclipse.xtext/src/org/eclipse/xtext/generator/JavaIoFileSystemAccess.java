/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.RuntimeIOException;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @author Moritz Eysholdt
 */
public class JavaIoFileSystemAccess extends AbstractFileSystemAccess {

	@Inject
	private IEncodingProvider encodingProvider;

	@Inject
	private IResourceServiceProvider.Registry registry;

	public JavaIoFileSystemAccess() {
	}

	/**
	 * @since 2.3
	 */
	public JavaIoFileSystemAccess(IResourceServiceProvider.Registry registry, IEncodingProvider encodingProvider) {
		this.registry = registry;
		this.encodingProvider = encodingProvider;
	}

	public void generateFile(String fileName, String outputConfigName, CharSequence contents) throws RuntimeIOException {
		File file = getFile(fileName, outputConfigName);
		try {
			createFolder(file.getParentFile());
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), getEncoding(getURI(fileName,
					outputConfigName)));
			try {
				writer.append(postProcess(fileName, outputConfigName, contents));
			} finally {
				writer.close();
			}
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.3
	 */
	protected String getEncoding(URI fileURI) {
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(fileURI);
		if (resourceServiceProvider != null)
			return resourceServiceProvider.getEncodingProvider().getEncoding(fileURI);
		else
			return encodingProvider.getEncoding(fileURI);
	}

	/**
	 * @since 2.1
	 */
	protected File getFile(String fileName, String outputConfigName) {
		String outlet = getPathes().get(outputConfigName);
		if (outlet == null)
			throw new IllegalArgumentException("A slot with name '" + outputConfigName + "' has not been configured.");
		String pathName = toSystemFileName(outlet + "/" + fileName);
		File file = new File(pathName).getAbsoluteFile();
		return file;
	}

	protected void createFolder(File parent) {
		if (parent != null && !parent.exists() && !parent.mkdirs())
			throw new RuntimeIOException("Could not create directory " + parent);
	}

	@Override
	public void deleteFile(String fileName, String outputConfiguration) {
		File file = getFile(fileName, outputConfiguration);
		if (file.exists())
			file.delete();
	}

	protected String toSystemFileName(String fileName) {
		return fileName.replace("/", File.separator);
	}

	/**
	 * @since 2.3
	 */
	public URI getURI(String fileName, String outputConfiguration) {
		return URI.createURI(getFile(fileName, outputConfiguration).toURI().toString());
	}

	/**
	 * @since 2.4
	 */
	public void generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		File file = getFile(fileName, outputCfgName);
		try {
			createFolder(file.getParentFile());
			OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			try {
				ByteStreams.copy(content, out);
			} finally {
				try {
					out.close();
				} finally {
					content.close();
				}
			}
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.4
	 */
	public InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		File file = getFile(fileName, outputCfgName);
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeIOException(e);
		}
	}

	/**
	 * @since 2.4
	 */
	public CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		try {
			File file = getFile(fileName, outputCfgName);
			String encoding = getEncoding(getURI(fileName, outputCfgName));
			return new String(Files.toByteArray(file), encoding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeIOException(e);
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}
}
