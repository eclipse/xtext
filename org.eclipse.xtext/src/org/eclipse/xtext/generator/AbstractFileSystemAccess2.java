/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.RuntimeIOException;

/**
 * Abstract base class for file system access supporting {@link IFileSystemAccess2}.
 *
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public abstract class AbstractFileSystemAccess2 extends AbstractFileSystemAccess implements IFileSystemAccess2 {

	/**
	 * @since 2.4
	 */
	@Override
	public void generateFile(String fileName, InputStream content) {
		generateFile(fileName, DEFAULT_OUTPUT, content);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public InputStream readBinaryFile(String fileName) {
		return readBinaryFile(fileName, DEFAULT_OUTPUT);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public CharSequence readTextFile(String fileName) {
		return readTextFile(fileName, DEFAULT_OUTPUT);
	}


	/**
	 * Sets the context to further configure this file system access instance.
	 *
	 * @param context a context from which project configuration can be obtained. Supported context types
	 * 	depend on the concrete implementation, but {@link Resource} is usually a good fit.
	 *
	 * @since 2.8
	 */
	public void setContext(Object context) {
		// do nothing
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	public boolean isFile(String path) throws RuntimeIOException {
		return isFile(path, DEFAULT_OUTPUT);
	}

	/**
	 * @since 2.9
	 */
	@Override
	public boolean isFile(String path, String outputConfigurationName) throws RuntimeIOException {
		InputStream is = null;
		try {
			is = readBinaryFile(path, outputConfigurationName);
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeIOException(e);
				}
			}
			return is!=null; // no exception => file exists
		} catch (RuntimeIOException e) {
			return false;
		}
	}

}
