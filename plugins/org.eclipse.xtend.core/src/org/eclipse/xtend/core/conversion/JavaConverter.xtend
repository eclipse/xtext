/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.core.runtime.IProgressMonitor

/**
 * @author Dennis Hübner - Initial contribution and API
 */
class JavaConverter {
	
	def String toXtend(String javaSrc, IProgressMonitor progressMonitor) {
		val parser = ASTParser.newParser(AST.JLS3)
		parser.source = javaSrc.toCharArray
		return doConvert(parser.createAST(progressMonitor))
	}

	def protected doConvert(ASTNode ast) {
		val flattener = new XtendASTFlattener
		ast.accept(flattener)
		return flattener.result
	}

}
