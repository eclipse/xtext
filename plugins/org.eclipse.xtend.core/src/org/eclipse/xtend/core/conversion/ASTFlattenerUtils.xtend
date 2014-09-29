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
import org.eclipse.jdt.core.dom.Assignment
import org.eclipse.jdt.core.dom.Block
import org.eclipse.jdt.core.dom.FieldAccess
import org.eclipse.jdt.core.dom.FieldDeclaration
import org.eclipse.jdt.core.dom.IExtendedModifier
import org.eclipse.jdt.core.dom.IMethodBinding
import org.eclipse.jdt.core.dom.ITypeBinding
import org.eclipse.jdt.core.dom.MethodDeclaration
import org.eclipse.jdt.core.dom.Modifier
import org.eclipse.jdt.core.dom.ReturnStatement
import org.eclipse.jdt.core.dom.SimpleName
import org.eclipse.jdt.core.dom.Statement
import org.eclipse.jdt.core.dom.StringLiteral
import org.eclipse.jdt.core.dom.TypeDeclaration
import org.eclipse.jdt.core.dom.TypeDeclarationStatement
import org.eclipse.jdt.core.dom.VariableDeclarationFragment
import org.eclipse.jdt.core.dom.VariableDeclarationStatement

/**
 * @author dhuebner - Initial contribution and API
 */
class ASTFlattenerUtils {

	def boolean isDummyType(TypeDeclaration it) {
		return "MISSING".equals(getName().getIdentifier()) && !isInterface() && getModifiers() == 0
	}

	def boolean isOverrideMethode(MethodDeclaration declaration) {
		if (!declaration.modifiers().filter(Annotation).filter [
			"Override" == typeName.toString
		].empty) {
			return true
		}
		val iMethodBinding = declaration.resolveBinding
		if (iMethodBinding != null) {
			return checkOverride(iMethodBinding, iMethodBinding.declaringClass)
		}
		return false
	}

	def boolean checkOverride(IMethodBinding method, ITypeBinding type) {
		val superclass = type.superclass
		var overrides = false
		if (superclass != null) {
			if (superclass.declaredMethods.exists[method.overrides(it)]) {
				overrides = true
			} else {
				overrides = checkOverride(method, superclass)
			}
		}
		if (!overrides) {
			for (ITypeBinding interfaze : type.interfaces) {
				if (interfaze.declaredMethods.exists[method.overrides(it)] || checkOverride(method, interfaze)) {
					return true
				}
			}
		}
		return overrides
	}

	def handleVariableDeclaration(Iterable<? extends ASTNode> modifier) {
		if (modifier.filter(Modifier).isFinal) {
			return 'val'
		} else {
			return 'var'
		}
	}

	def boolean isNotSupportedInnerType(TypeDeclaration it) {
		!isInterface() && (parent instanceof TypeDeclaration || parent instanceof Block ) &&
			!modifiers().filter(Modifier).exists[isStatic]
	}

	def boolean isNotSupportedInnerType(TypeDeclarationStatement it) {
		( parent instanceof Block )
	}

	def boolean isFinal(Iterable<Modifier> modifiers) {
		modifiers.filter(Modifier).exists[isFinal]
	}

	def boolean isStatic(Iterable<IExtendedModifier> modifiers) {
		modifiers.filter(Modifier).exists[isStatic]
	}

	def boolean isPackageVisibility(Iterable<Modifier> modifier) {
		modifier.filter[public || private || protected].empty
	}

	def canHandleAnnotation(ASTNode node) {
		if (node instanceof VariableDeclarationStatement) {
			return false
		}
		return true
	}

	def shouldConvertName(SimpleName it) {
		return (parent instanceof FieldAccess ||
			( parent instanceof VariableDeclarationFragment && parent.parent instanceof FieldDeclaration))
	}

	def boolean needsReturnValue(Assignment node) {
		(node.parent != null) && (!(node.parent instanceof Statement) || (node.parent instanceof ReturnStatement))
	}

	def richTextValue(StringLiteral literal) {
		val escVal = literal.escapedValue
		val value = escVal.substring(1, escVal.length - 1)

		// some one may use opening « and closing » in different string literals 
		var result = value.replaceAll("«", "«\"«\"» ")
		result = result.replaceAll("((?!\").)(»)", "$1«\"$2\"»")
		result = result.replaceAll("(''')", "«\"$1\"»")
		if(result.endsWith("'")) {
			result = result.concat("«»")
		}
		return result
	}
}
