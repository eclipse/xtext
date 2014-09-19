/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser

/**
 * @author Dennis Hübner - Initial contribution and API
 */
class JavaConverter {
	@Inject Provider<JavaASTFlattener> flattenerProvider

	def String toXtend(String javaSrc) {
		toXtend(javaSrc, ASTParser.K_COMPILATION_UNIT)
	}

	def String toXtend(String javaSrc, int javaSourceKind) {
		val parser = ASTParser.newParser(AST.JLS3)
		parser.statementsRecovery = true
		parser.bindingsRecovery = true
		parser.kind = javaSourceKind
		parser.source = javaSrc.toCharArray
		return doConvert(parser.createAST(null))
	}

	def protected doConvert(ASTNode ast) {
		val flattener = flattenerProvider.get()
		ast.accept(flattener)
		return flattener.result
	}

}
