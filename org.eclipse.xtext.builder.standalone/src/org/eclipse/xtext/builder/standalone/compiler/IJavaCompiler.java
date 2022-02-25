/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import java.io.File;

/**
 * @author Dennis Huebner
 * 
 */
public interface IJavaCompiler {

	CompilationResult compile(Iterable<String> sourceRoots, File outputClassDirectory);

	void setClassPath(Iterable<String> classPath);

	CompilerConfiguration getConfiguration();

	public enum CompilationResult {
		SUCCEEDED, SKIPPED, FAILED
	}
}
