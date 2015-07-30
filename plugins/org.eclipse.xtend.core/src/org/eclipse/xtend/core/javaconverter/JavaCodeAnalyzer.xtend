/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.javaconverter

import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.Block
import org.eclipse.jdt.core.dom.BodyDeclaration
import org.eclipse.jdt.core.dom.CompilationUnit
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.Statement
import org.eclipse.jdt.core.dom.TypeDeclaration
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author dhuebner - Initial contribution and API
 */
class JavaCodeAnalyzer {
	@Inject ASTParserFactory parserFactory

	def JavaParseResult<? extends ASTNode> determinateJavaType(String javaCode) {
		var ASTParser parser = parserFactory.createDefaultJavaParser(parserFactory.minParserApiLevel)

		parser.setSource(javaCode.toCharArray())
		parser.setStatementsRecovery(true)
		var CompilationUnit unit = parser.createAST(null) as CompilationUnit
		if (unit.types().size() > 0)
			return new JavaParseResult<CompilationUnit>(javaCode, ASTParser.K_COMPILATION_UNIT,
				Collections.singletonList(unit))
		parser.setSource(javaCode.toCharArray())
		parser.setStatementsRecovery(false)
		parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS)
		var ASTNode root = parser.createAST(null)
		if (root instanceof TypeDeclaration) {
			var List<BodyDeclaration> bodyDeclarations = root.bodyDeclarations()
			if (bodyDeclarations.size() > 0)
				return new JavaParseResult<BodyDeclaration>(javaCode, ASTParser.K_CLASS_BODY_DECLARATIONS,
					bodyDeclarations)
		}
		parser.setSource(javaCode.toCharArray())
		parser.setStatementsRecovery(false)
		parser.setKind(ASTParser.K_STATEMENTS)
		root = parser.createAST(null)
		if (root instanceof Block) {
			var List<Statement> statements = root.statements()
			if (statements.size() > 0)
				return new JavaParseResult<Statement>(javaCode, ASTParser.K_STATEMENTS, statements)
		}
		parser.setSource(javaCode.toCharArray())
		parser.setStatementsRecovery(false)
		parser.setKind(ASTParser.K_EXPRESSION)
		root = parser.createAST(null)
		if (root instanceof Expression) {
			return new JavaParseResult<Expression>(javaCode, ASTParser.K_EXPRESSION, Collections.singletonList(root))
		}
		return null
	}

	@Accessors(PUBLIC_GETTER)
	static final class JavaParseResult<T extends ASTNode> {
		String javaCode
		List<T> nodes
		int type

		new(String javaCode, int type, List<T> nodes) {
			this.javaCode = javaCode
			this.type = type
			this.nodes = nodes
		}

	}

}
