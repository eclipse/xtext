/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.InputStream;

/**
 * 
 * Abstract base class for file system access supporting {@link IFileSystemAccessExtension3}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public abstract class AbstractFileSystemAccess2 extends AbstractFileSystemAccess implements IFileSystemAccessExtension3{

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

	
}
