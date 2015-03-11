/**
 * 
 */
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
