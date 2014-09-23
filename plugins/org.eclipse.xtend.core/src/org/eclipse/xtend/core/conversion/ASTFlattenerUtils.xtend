/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion

import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.Annotation
import org.eclipse.jdt.core.dom.MethodDeclaration
import org.eclipse.jdt.core.dom.Modifier
import org.eclipse.jdt.core.dom.VariableDeclarationStatement

/**
 * @author dhuebner - Initial contribution and API
 */
class ASTFlattenerUtils {

	def isOverrideMethode(MethodDeclaration declaration) {
		!declaration.modifiers().filter(Annotation).filter [
			//TODO try to resolve super type
			"Override" == typeName.toString
		].empty
	}

	def handleVariableDeclaration(Iterable<? extends ASTNode> modifier) {
		if (modifier.filter(Modifier).isFinal) {
			return 'val'
		} else {
			return 'var'
		}
	}

	def boolean isFinal(Iterable<Modifier> modifier) {
		modifier.exists[isFinal]
	}

	def canHandleAnnotation(ASTNode node) {
		if (node instanceof VariableDeclarationStatement) {
			return false
		}
		return true
	}
}
