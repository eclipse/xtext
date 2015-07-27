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
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTParser

/** 
 * @author dhuebner - Initial contribution and API
 */
class ASTParserFactory {

	String complianceLevel = "1.6"

	def protected createDefaultJavaParser(String compilerCompliance) {
		val parser = ASTParser.newParser(asJLS(compilerCompliance))
		val options = JavaCore.getOptions()
		JavaCore.setComplianceOptions(compilerCompliance, options)
		options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.ENABLED)
		parser.compilerOptions = options
		return parser
	}

	def static int asJLS(String compilerCompliance) {
		switch (compilerCompliance) {
			case "1.7": 4
			case "1.8": 8
			default: AST.JLS3
		}
	}

	def defaultCompliancelevel() {
		return complianceLevel
	}

	/**
	 * @param compilerCompliance compliance level when differs from the {@link #defaultCompliancelevel()}
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
	 */
	def ASTParser createJavaParser(String compilerCompliance, Object context) {
		val parser = createDefaultJavaParser(compilerCompliance)
		provideCustomEnvironment(parser)
		return parser
	}

	/**
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
	 */
	def ASTParser createJavaParser(Object classPathContext) {
		createJavaParser(defaultCompliancelevel, classPathContext)
	}

	def ASTParser createJavaParser() {
		createJavaParser(defaultCompliancelevel, null)
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

}
