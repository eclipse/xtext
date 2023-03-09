/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;

/**
 * A utility class for generating plain text files.
 */
public class TextFileAccess {
	private String path;

	protected CharSequence internalContents;

	public void setContent(StringConcatenationClient content) {
		StringConcatenation stringConcatenation = new StringConcatenation();
		stringConcatenation.append(content);
		internalContents = stringConcatenation;
	}

	public CharSequence getContent() {
		return internalContents.toString();
	}

	public String getContentString() {
		return getContent().toString();
	}

	public void writeTo(IFileSystemAccess2 fileSystemAccess) {
		if (fileSystemAccess != null) {
			fileSystemAccess.generateFile(path, getContent());
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
