/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion

import com.google.inject.Inject
import java.net.URLClassLoader
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.dom.ASTParser

import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IJavaProject

/**
 * Converts Java code or an ICompilationUnit to Xtend code<br>
 * 
 *  @author Dennis Hübner - Initial contribution and API
 */
class JavaConverter {
	final static int JLS = JavaASTFlattener.JLS

	/*TODO Refactor this class. Remove state, extract common logic. */
	@Inject JavaASTFlattener astFlattener
	String complianceLevel = "1.5"
	boolean fallbackConversionStartegy = false

	def ConversionResult toXtend(ICompilationUnit cu) {
		val parser = ASTParser.newParser(JLS)
		val options = JavaCore.getOptions()
		JavaCore.setComplianceOptions(complianceLevel, options)
		parser.compilerOptions = options
		parser.statementsRecovery = true
		parser.resolveBindings = true
		parser.bindingsRecovery = true
		parser.source = cu
		astFlattener.reset
		astFlattener.useFallBackStrategy = fallbackConversionStartegy
		astFlattener.setJavaSources(cu.source)
		parser.createAST(null).accept(astFlattener)
		val result = ConversionResult.create(astFlattener)
		return result

	}

	/**
 	* @param unitName some CU name e.g. Clazz. UnitName may not be <code>null</code>.<br>
 	* 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
 	* @param javaSrc Java source code as String
 	* @throws IllegalArgumentException if unitName is <code>null</code> 
 	*/
	def ConversionResult toXtend(String unitName, String javaSrc) {
		if (unitName == null)
			throw new IllegalArgumentException()
		internalToXtend(unitName, javaSrc, null)
	}

	/**
	* @param javaSrc Java class source code as String
 	* @param project JavaProject where the java source code comes from. If project is <code>null</code>, the parser will be<br>
 	* 			 configured with the system class loader to resolve bindings.
	*/
	def ConversionResult bodyDeclarationToXtend(String javaSrc, IJavaProject project) {
		internalToXtend(null, javaSrc, null)
	}

	/**
 	* @param unitName some CU name e.g. Clazz. If unitName is null, a body declaration content is considered.<br>
 	* 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
 	* @param javaSrc Java source code as String
 	* @param proj JavaProject where the java source code comes from
 	*/
	def private ConversionResult internalToXtend(String unitName, String javaSrc, IJavaProject proj) {
		val parser = ASTParser.newParser(JLS)
		val options = JavaCore.getOptions()
		JavaCore.setComplianceOptions(complianceLevel, options)
		parser.compilerOptions = options
		parser.statementsRecovery = true
		parser.resolveBindings = true
		parser.bindingsRecovery = true
		if (proj != null) {
			parser.project = proj;
		} else {
			val sysClassLoader = ClassLoader.getSystemClassLoader();
			val cpEntries = (sysClassLoader as URLClassLoader).getURLs().map[file]
			parser.setEnvironment(cpEntries, null, null, true)
		}
		parser.kind = ASTParser.K_COMPILATION_UNIT
		var preparedJavaSource = javaSrc
		if (unitName == null) {
			parser.unitName = "MISSING"
			preparedJavaSource = "class MISSING {" + javaSrc + "}"
		} else {
			parser.unitName = unitName
		}
		parser.source = preparedJavaSource.toCharArray

		astFlattener.reset
		astFlattener.useFallBackStrategy = fallbackConversionStartegy
		astFlattener.setJavaSources(preparedJavaSource)
		parser.createAST(null).accept(astFlattener)
		return ConversionResult.create(astFlattener)
	}

	static class ConversionResult {
		String xtendCode
		Iterable<String> problems = newArrayList()

		def getXtendCode() {
			xtendCode
		}

		def getProblems() {
			problems
		}

		def static create(JavaASTFlattener flattener) {
			val result = new ConversionResult
			result.xtendCode = flattener.result
			if (flattener.problems != null)
				result.problems = flattener.problems
			return result
		}

	}

	def JavaConverter useRobustSyntax() {
		this.fallbackConversionStartegy = true
		return this
	}

}
