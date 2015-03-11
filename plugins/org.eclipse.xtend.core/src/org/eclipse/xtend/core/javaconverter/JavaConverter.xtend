/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.javaconverter

import com.google.inject.Inject
import com.google.inject.Provider
import java.net.URLClassLoader
import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.Block
import org.eclipse.jdt.core.dom.Statement
import org.eclipse.xtend.lib.annotations.AccessorType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ui.util.ClipboardUtil.JavaImportData
import org.eclipse.xtext.xbase.conversion.IJavaCodeConverter

import static extension org.eclipse.xtend.lib.annotations.AccessorType.*

/**
 * Converts Java code or an ICompilationUnit to Xtend code<br>
 * 
 *  @author Dennis Hübner - Initial contribution and API
 */
class JavaConverter implements IJavaCodeConverter {
	@Inject JavaCodeAnalyzer javaAnalyzer
	@Inject Provider<JavaASTFlattener> astFlattenerProvider

	boolean fallbackConversionStartegy = false

	def ConversionResult toXtend(ICompilationUnit cu) {
		val parser = javaAnalyzer.createDefaultJavaParser()
		parser.statementsRecovery = true
		parser.resolveBindings = true
		parser.bindingsRecovery = true
		parser.source = cu
		val root = parser.createAST(null)
		return executeAstFlattener(cu.source, Collections.singleton(root))

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
		internalToXtend(unitName, javaSrc, null, null)
	}

	/**
	 * @param javaSrc Java class source code as String
	 * @param project JavaProject where the java source code comes from. If project is <code>null</code>, the parser will be<br>
	 * 			 configured with the system class loader to resolve bindings.
	 */
	def ConversionResult bodyDeclarationToXtend(String javaSrc, JavaImportData additionalImports,
		IJavaProject project) {
		internalToXtend(null, javaSrc, additionalImports, project)
	}

	/**
	 * @param javaSrc Java class source code as String
	 */
	def ConversionResult statementToXtend(String javaSrc) {
		val parser = javaAnalyzer.createDefaultJavaParser
		parser.source = javaSrc.toCharArray
		parser.kind = ASTParser.K_STATEMENTS
		val root = parser.createAST(null)
		if (root instanceof Block) {
			var List<Statement> statements = root.statements()
			return executeAstFlattener(javaSrc, statements)
		}
		return executeAstFlattener(javaSrc, Collections.singleton(root))
	}
	/**
	 * @param javaSrc Java class source code as String
	 */
	def ConversionResult expressionToXtend(String javaSrc) {
		val parser = javaAnalyzer.createDefaultJavaParser
		parser.source = javaSrc.toCharArray
		parser.kind = ASTParser.K_EXPRESSION
		val root = parser.createAST(null)
		return executeAstFlattener(javaSrc, Collections.singleton(root))
	}

	/**
	 * @param unitName some CU name e.g. Clazz. If unitName is null, a body declaration content is considered.<br>
	 * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
	 * @param javaSrc Java source code as String
	 * @param proj JavaProject where the java source code comes from
	 */
	def private ConversionResult internalToXtend(String unitName, String javaSrc, JavaImportData additionalImports,
		IJavaProject proj) {
		val parser = javaAnalyzer.createDefaultJavaParser
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
		val javaSrcBuilder = new StringBuilder()
		if (additionalImports != null) {
			additionalImports.getImports().forEach[javaSrcBuilder.append("import " + it + ";")]
		}
		if (unitName == null) {
			parser.unitName = "MISSING"
			javaSrcBuilder.append('''class MISSING { «javaSrc»}''')
		} else {
			parser.unitName = unitName
			javaSrcBuilder.append(javaSrc)
		}
		parser.kind = ASTParser.K_COMPILATION_UNIT
		val preparedJavaSrc = javaSrcBuilder.toString
		parser.source = preparedJavaSrc.toCharArray
		val result = parser.createAST(null)
		return executeAstFlattener(preparedJavaSrc, Collections.singleton(result))
	}

	/**
	 * @param  preparedJavaSource used to collect javadoc and comments
	 */
	private def executeAstFlattener(String preparedJavaSource, Collection<? extends ASTNode> parseResult) {
		val astFlattener = astFlattenerProvider.get
		astFlattener.useFallBackStrategy = fallbackConversionStartegy
		astFlattener.setJavaSources(preparedJavaSource)
		for (ASTNode node : parseResult) {
			node.accept(astFlattener)
		}
		return ConversionResult.create(astFlattener)
	}

	@Accessors(AccessorType.PUBLIC_GETTER)
	static class ConversionResult {
		String xtendCode
		Iterable<String> problems = newArrayList()

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

	override isCompatibleTargetObject(String javaToConvert, EObject targetElement) {
		false
	}

}
