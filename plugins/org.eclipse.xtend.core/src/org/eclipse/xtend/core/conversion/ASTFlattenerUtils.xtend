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
import org.eclipse.jdt.core.dom.InfixExpression
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
import org.eclipse.jdt.core.dom.ClassInstanceCreation

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
			return findOverride(iMethodBinding, iMethodBinding.declaringClass) != null
		}
		return false
	}

	def IMethodBinding findOverride(IMethodBinding method, ITypeBinding type) {
		findOverride(method, type, false)
	}

	def IMethodBinding findOverride(IMethodBinding method, ITypeBinding type, boolean onlyPrimarylevel) {
		val superclass = type.superclass
		var IMethodBinding overridden = null
		if (superclass != null) {
			overridden = internalFindOverride(method, superclass, onlyPrimarylevel)
		}
		if (overridden == null) {
			for (ITypeBinding interfaze : type.interfaces) {
				overridden = internalFindOverride(method, interfaze, onlyPrimarylevel)
				if (overridden != null) {
					return overridden
				}
			}
		}
		return overridden
	}

	def private internalFindOverride(IMethodBinding method, ITypeBinding superType, boolean onlyPrimarylevel) {
		val superClassOverride = superType.declaredMethods.filter[method.overrides(it)]
		if (superClassOverride.size == 1) {
			return superClassOverride.get(0)
		} else if (!onlyPrimarylevel) {
			return findOverride(method, superType)
		} else {
			return null
		}
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

	def isLambdaCase(ClassInstanceCreation creation) {
		val anonymousClazz = creation.anonymousClassDeclaration
		if (anonymousClazz != null && anonymousClazz.bodyDeclarations.size == 1) {
			val declaredMethod = anonymousClazz.bodyDeclarations.get(0)
			if (declaredMethod instanceof MethodDeclaration && creation.type.resolveBinding != null) {
				val methodBinding = (declaredMethod as MethodDeclaration).resolveBinding
				if (methodBinding != null) {
					val overrides = findOverride(methodBinding, methodBinding.declaringClass, true)
					return overrides != null && Modifier.isAbstract(overrides.modifiers)
				}
			}
		}
		return false
	}

	def boolean needsReturnValue(ASTNode node) {
		(node.parent != null) && (!(node.parent instanceof Statement) || (node.parent instanceof ReturnStatement))
	}

	def int countStringConcats(InfixExpression node) {
		var concats = 0
		if (node.getOperator() == InfixExpression.Operator.PLUS) {
			if (node.getLeftOperand() instanceof StringLiteral)
				concats++
			else if (node.getLeftOperand() instanceof InfixExpression)
				concats = concats + countStringConcats(node.getLeftOperand() as InfixExpression)
			if (node.getRightOperand() instanceof StringLiteral)
				concats++
			else if (node.getRightOperand() instanceof InfixExpression)
				concats = concats + countStringConcats(node.getRightOperand() as InfixExpression)
			concats = concats + node.extendedOperands().filter[e|e instanceof StringLiteral].size
		}
		return concats
	}

	def richTextValue(StringLiteral literal) {
		val value = literal.literalValue

		// some one may use opening « and closing » in different string literals 
		var result = value.replaceAll("«", "«\"«\"» ")
		result = result.replaceAll("((?!\").)(»)", "$1«\"$2\"»")
		result = result.replaceAll("(''')", "«\"$1\"»")
		if (result.endsWith("'")) {
			result = result.concat("«»")
		}
		return result
	}
}
