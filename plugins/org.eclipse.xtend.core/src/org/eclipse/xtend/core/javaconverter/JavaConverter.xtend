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
import org.eclipse.jdt.core.ICompilationUnit
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.Block
import org.eclipse.xtend.core.javaconverter.ASTParserFactory.ASTParserWrapper
import org.eclipse.xtend.lib.annotations.AccessorType
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.xtend.lib.annotations.AccessorType.*

/**
 * Converts Java code or an ICompilationUnit to Xtend code<br>
 * 
 *  @author Dennis Hübner - Initial contribution and API
 */
class JavaConverter {
	@Inject ASTParserFactory astParserFactory
	@Inject Provider<JavaASTFlattener> astFlattenerProvider

	boolean fallbackConversionStartegy = false

	def ConversionResult toXtend(ICompilationUnit cu) {
		val parser = astParserFactory.createJavaParser(cu)
		val root = parser.createAST()
		return executeAstFlattener(cu.source, root, parser.targetLevel, false)
	}

	/**
	 * @param unitName some CU name e.g. Clazz. UnitName may not be <code>null</code>.<br>
	 * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
	 * @param javaSrc Java source code as String
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
	 * @throws IllegalArgumentException if unitName is <code>null</code> 
	 */
	def ConversionResult toXtend(String unitName, String javaSrc) {
		if (unitName == null)
			throw new IllegalArgumentException()
		internalToXtend(unitName, javaSrc, null, astParserFactory.createJavaParser(null))
	}

	/**
	 * @param unitName some CU name e.g. Clazz. UnitName may not be <code>null</code>.<br>
	 * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
	 * @param javaSrc Java source code as String
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
	 * @throws IllegalArgumentException if unitName is <code>null</code> 
	 */
	def ConversionResult toXtend(String unitName, String javaSrc, Object classPathContext) {
		if (unitName == null)
			throw new IllegalArgumentException()
		internalToXtend(unitName, javaSrc, null, astParserFactory.createJavaParser(classPathContext))
	}

	/**
	 * @param javaSrc Java class source code as String
	 * @param project JavaProject where the java source code comes from. If project is <code>null</code>, the parser will be<br>
	 * 			 configured with the system class loader to resolve bindings.
	 * @param imports imports to use 
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
	 */
	def ConversionResult bodyDeclarationToXtend(String javaSrc, String[] imports, Object classPathContext) {
		internalToXtend(null, javaSrc, imports, astParserFactory.createJavaParser(classPathContext))
	}

	/**
	 * @param javaSrc Java class source code as String
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
	 */
	def ConversionResult statementToXtend(String javaSrc, Object classPathContext) {
		val parser = astParserFactory.createJavaParser(classPathContext)
		parser.source = javaSrc.toCharArray
		parser.kind = ASTParser.K_STATEMENTS
		val root = parser.createAST()
		if (root instanceof Block) {
			return executeAstFlattener(javaSrc, root, parser.targetLevel, true)
		}
		return executeAstFlattener(javaSrc, root, parser.targetLevel, false)
	}

	/**
	 * @param javaSrc Java class source code as String
	 * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
	 */
	def ConversionResult expressionToXtend(String javaSrc, Object classPathContext) {
		val parser = astParserFactory.createJavaParser(classPathContext)
		parser.source = javaSrc.toCharArray
		parser.kind = ASTParser.K_EXPRESSION
		val root = parser.createAST()
		return executeAstFlattener(javaSrc, root, parser.targetLevel, false)
	}

	/**
	 * @param unitName some CU name e.g. Clazz. If unitName is null, a body declaration content is considered.<br>
	 * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
	 * @param javaSrc Java source code as String
	 * @param imports Additional imports to add
	 * @param parser ASTParser to use
	 */
	def private ConversionResult internalToXtend(String unitName, String javaSrc, String[] imports,
		ASTParserWrapper parser) {
		val javaSrcBuilder = new StringBuilder()
		if (imports != null) {
			imports.forEach[javaSrcBuilder.append("import " + it + ";")]
		}
		if (unitName == null) {
			parser.unitName = "MISSING"
			javaSrcBuilder.append('''class MISSING { «javaSrc» }''')
		} else {
			parser.unitName = unitName
			javaSrcBuilder.append(javaSrc)
		}
		parser.kind = ASTParser.K_COMPILATION_UNIT
		val preparedJavaSrc = javaSrcBuilder.toString
		parser.source = preparedJavaSrc.toCharArray
		val result = parser.createAST()
		return executeAstFlattener(preparedJavaSrc, result, parser.targetLevel, false)
	}

	/**
	 * @param  preparedJavaSource used to collect javadoc and comments
	 */
	private def executeAstFlattener(String preparedJavaSource, ASTNode parseResult, String targetLevel,
		boolean synteticBlock) {
		val astFlattener = astFlattenerProvider.get
		astFlattener.targetlevel = targetLevel
		astFlattener.useFallBackStrategy = fallbackConversionStartegy
		astFlattener.setJavaSources(preparedJavaSource)
		if (synteticBlock && parseResult instanceof Block) {
			astFlattener.acceptSyntaticBlock(parseResult as Block)
		} else {
			parseResult.accept(astFlattener)
		}
		return ConversionResult.create(astFlattener)
	}

	def JavaConverter useRobustSyntax() {
		this.fallbackConversionStartegy = true
		return this
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

}
