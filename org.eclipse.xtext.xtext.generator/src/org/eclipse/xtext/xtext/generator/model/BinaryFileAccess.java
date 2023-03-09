/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import org.eclipse.xtext.generator.IFileSystemAccess2;

/**
 * A utility class for generating binary files.
 */
public class BinaryFileAccess {
	private String path;

	protected byte[] internalContents;

	public void setContent(byte[] content) {
		this.internalContents = content;
	}

	public byte[] getContent() {
		return Arrays.copyOf(internalContents, internalContents.length);
	}

	public void writeTo(IFileSystemAccess2 fileSystemAccess) {
		if (fileSystemAccess != null) {
			fileSystemAccess.generateFile(path, new ByteArrayInputStream(internalContents));
		}
	}

	public boolean existIn(IXtextGeneratorFileSystemAccess fileSystemAccess) {
		if (fileSystemAccess == null) {
			return false;
		}
		return fileSystemAccess.isFile(path);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
