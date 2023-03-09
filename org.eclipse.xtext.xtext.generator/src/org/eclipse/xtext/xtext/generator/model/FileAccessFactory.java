/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xtext.generator.CodeConfig;

import com.google.inject.Inject;

/**
 * Factory for creating text files, Java files, and Xtend files.
 */
public class FileAccessFactory {
	@Inject
	private CodeConfig codeConfig;

	public TextFileAccess createTextFile() {
		return new TextFileAccess();
	}

	public TextFileAccess createTextFile(String path) {
		TextFileAccess result = createTextFile();
		result.setPath(path);
		return result;
	}

	public TextFileAccess createTextFile(String path, StringConcatenationClient content) {
		TextFileAccess result = createTextFile(path);
		result.setContent(content);
		return result;
	}

	public JavaFileAccess createJavaFile(TypeReference typeRef) {
		return new JavaFileAccess(typeRef, codeConfig);
	}

	public JavaFileAccess createJavaFile(TypeReference typeRef, StringConcatenationClient content) {
		JavaFileAccess result = createJavaFile(typeRef);
		result.setContent(content);
		return result;
	}

	public XtendFileAccess createXtendFile(TypeReference typeRef) {
		return new XtendFileAccess(typeRef, codeConfig);
	}

	public XtendFileAccess createXtendFile(TypeReference typeRef, StringConcatenationClient content) {
		XtendFileAccess result = createXtendFile(typeRef);
		result.setContent(content);
		return result;
	}

	public GeneratedJavaFileAccess createGeneratedJavaFile(TypeReference typeRef) {
		return new GeneratedJavaFileAccess(typeRef, codeConfig);
	}

	public BinaryFileAccess createBinaryFile() {
		return new BinaryFileAccess();
	}

	public BinaryFileAccess createBinaryFile(String path) {
		BinaryFileAccess result = createBinaryFile();
		result.setPath(path);
		return result;
	}
}
