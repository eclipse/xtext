/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.InputStream;

import org.eclipse.xtext.util.RuntimeIOException;

/**
 * This class extends {@link IFileSystemAccess} with the capability to write binary files.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 */
public interface IFileSystemAccessExtension3 {

	/**
	 * Writes binary data to disk. For writing text, it is recommended to use
	 * {@link IFileSystemAccess#generateFile(String, String, CharSequence)}
	 */
	void generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException;

	/**
	 * Writes binary data to disk. For writing text, it is recommended to use
	 * {@link IFileSystemAccess#generateFile(String, CharSequence)}
	 */
	void generateFile(String fileName, InputStream content) throws RuntimeIOException;

	/**
	 * Creates an InputStream to read a binary file from disk. For text files, use {@link #readTextFile(String, String)}
	 * .
	 */
	InputStream readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException;

	/**
	 * Creates an InputStream to read a binary file from disk. For text files, use {@link #readTextFile(String)}.
	 */
	InputStream readBinaryFile(String fileName) throws RuntimeIOException;

	/**
	 * Reads a text file from disk. To read a binary file, use {@link #readBinaryFile(String, String)}.
	 */
	CharSequence readTextFile(String fileName, String outputCfgName) throws RuntimeIOException;

	/**
	 * Reads a text file from disk. To read a binary file, use {@link #readBinaryFile(String)}.
	 */
	CharSequence readTextFile(String fileName) throws RuntimeIOException;
}