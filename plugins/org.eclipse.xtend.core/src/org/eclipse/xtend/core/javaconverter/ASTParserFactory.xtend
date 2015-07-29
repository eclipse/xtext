/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.javaconverter

import java.io.File
import java.net.URLClassLoader
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.xtend.lib.annotations.Data

/** 
 * @author dhuebner - Initial contribution and API
 */
class ASTParserFactory {

	protected final String minParserApiLevel = "1.6"

	def final protected createDefaultJavaParser(String javaVersion) {
		var ASTParser parser
		val options = JavaCore.getOptions()
		try {
			parser = ASTParser.newParser(asJLS(javaVersion))
			JavaCore.setComplianceOptions(javaVersion, options)
		} catch (IllegalArgumentException e) {
			parser = ASTParser.newParser(asJLS(minParserApiLevel))
			JavaCore.setComplianceOptions(minParserApiLevel, options)
		}

		options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.ENABLED)
		parser.compilerOptions = options
		parser.statementsRecovery = true
		parser.resolveBindings = true
		parser.bindingsRecovery = true
		return parser
	}

	def static int asJLS(String javaVersion) {
		switch (javaVersion) {
			case "1.7": 4
			case "1.8": 8
			default: 3
		}
	}

	/**
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject or Module or null)
	 */
	def ASTParserWrapper createJavaParser(Object context) {
		var targetJavaVersion = System.getProperty("java.specification.version");
		if (targetJavaVersion === null) {
			targetJavaVersion = minParserApiLevel
		}
		val parser = createDefaultJavaParser(targetJavaVersion)
		provideCustomEnvironment(parser)
		return new ASTParserWrapper(targetJavaVersion, parser)
	}

	/**
	 * Will be called when the environment can not be derived from a context in {@link #createJavaParser(String, Object)} 
	 * {@link ASTParser#setEnvironment(String[], String[], String[], boolean)}
	 */
	protected def provideCustomEnvironment(ASTParser parser) {
		val sysClassLoader = ClassLoader.getSystemClassLoader()
		// filter not existing CP entries, otherwise ASTParser will fail on getClasspath() call
		val cpEntries = (sysClassLoader as URLClassLoader).getURLs().map[file].filter[new File(it).exists]
		parser.setEnvironment(cpEntries, null, null, true)
	}

	@Data
	static class ASTParserWrapper {
		String targetLevel
		ASTParser parser

		def createAST() {
			parser.createAST(null)
		}

		def setKind(int i) {
			parser.kind = i
		}

		def setSource(char[] cs) {
			parser.source = cs
		}

		def setUnitName(String string) {
			parser.unitName = string
		}

	}
}
