/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion

import java.util.List
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTVisitor
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration
import org.eclipse.jdt.core.dom.Annotation
import org.eclipse.jdt.core.dom.Block
import org.eclipse.jdt.core.dom.BodyDeclaration
import org.eclipse.jdt.core.dom.BooleanLiteral
import org.eclipse.jdt.core.dom.CompilationUnit
import org.eclipse.jdt.core.dom.EnumConstantDeclaration
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.ExpressionStatement
import org.eclipse.jdt.core.dom.FieldAccess
import org.eclipse.jdt.core.dom.FieldDeclaration
import org.eclipse.jdt.core.dom.ForStatement
import org.eclipse.jdt.core.dom.IExtendedModifier
import org.eclipse.jdt.core.dom.ImportDeclaration
import org.eclipse.jdt.core.dom.Initializer
import org.eclipse.jdt.core.dom.Javadoc
import org.eclipse.jdt.core.dom.MarkerAnnotation
import org.eclipse.jdt.core.dom.MethodDeclaration
import org.eclipse.jdt.core.dom.MethodInvocation
import org.eclipse.jdt.core.dom.Modifier
import org.eclipse.jdt.core.dom.Name
import org.eclipse.jdt.core.dom.NullLiteral
import org.eclipse.jdt.core.dom.PackageDeclaration
import org.eclipse.jdt.core.dom.ParameterizedType
import org.eclipse.jdt.core.dom.PrimitiveType
import org.eclipse.jdt.core.dom.QualifiedName
import org.eclipse.jdt.core.dom.SimpleName
import org.eclipse.jdt.core.dom.SingleVariableDeclaration
import org.eclipse.jdt.core.dom.Statement
import org.eclipse.jdt.core.dom.StringLiteral
import org.eclipse.jdt.core.dom.TagElement
import org.eclipse.jdt.core.dom.ThisExpression
import org.eclipse.jdt.core.dom.Type
import org.eclipse.jdt.core.dom.TypeDeclaration
import org.eclipse.jdt.core.dom.TypeParameter
import org.eclipse.jdt.core.dom.VariableDeclarationExpression
import org.eclipse.jdt.core.dom.VariableDeclarationFragment
import org.eclipse.jdt.core.dom.VariableDeclarationStatement

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class XtendASTFlattener extends ASTVisitor {

	/**
	 * The string buffer into which the serialized representation of the AST is
	 * written.
	 */
	protected StringBuffer fBuffer;

	/**
	 * Creates a new AST printer.
	 */
	new() {
		this.fBuffer = new StringBuffer()
	}

	/**
	 * Returns the string accumulated in the visit.
	 *
	 * @return the serialized
	 */
	def String getResult() {
		return this.fBuffer.toString()
	}

	/**
	 * Resets this printer so that it can be used again.
	 */
	def void reset() {
		this.fBuffer.setLength(0)
	}

	override visit(CompilationUnit node) {
		if (node.getPackage() != null) {
			node.getPackage().accept(this)
		}
		node.imports().forEach[ImportDeclaration id|id.accept(this)]
		node.types().forEach[AbstractTypeDeclaration td|td.accept(this)]
		return false;
	}

	override visit(PackageDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		node.annotations().forEach[Annotation it|accept(this) appendSpaceToBuffer]
		appendToBuffer("package ")
		node.getName().accept(this)
		appendLineWrapToBuffer
		false;
	}

	override visit(ParameterizedType node) {
		node.getType().accept(this)
		appendToBuffer("<")
		node.typeArguments().forEach[Type it, counter|accept(this)
			if (counter < node.typeArguments().size - 1) {
				appendToBuffer(", ")
			}]
		appendToBuffer(">")
		return false;
	}

	override visit(PrimitiveType node) {
		appendToBuffer(node.getPrimitiveTypeCode().toString())
		false
	}

	override visit(BooleanLiteral node) {
		appendToBuffer(String.valueOf(node.booleanValue))
		false
	}

	override visit(ImportDeclaration node) {
		appendToBuffer("import ")
		if (node.isStatic()) {
			appendToBuffer("static ")
		}
		node.getName().accept(this)
		if (node.isOnDemand()) {
			appendToBuffer(".*")
		}
		appendLineWrapToBuffer
		false
	}

	override visit(Initializer node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		printModifiers(node.modifiers())
		node.getBody().accept(this)
		false;
	}

	override visit(TypeDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		printModifiers(node.modifiers())
		if (node.isInterface()) {
			appendToBuffer("interface ")
		} else {
			appendToBuffer("class ")
		}
		node.getName().accept(this)
		if (!node.typeParameters().isEmpty()) {
			appendToBuffer("<")
			node.typeParameters().forEach[TypeParameter tp, counter|tp.accept(this)
				if (counter < node.typeParameters().size - 1) {
					appendToBuffer(",")
				}]
			appendToBuffer(">")
		}
		appendSpaceToBuffer
		if (node.getSuperclassType() != null) {
			appendToBuffer("extends ")
			node.getSuperclassType().accept(this)
			appendToBuffer(" ")
		}
		if (!node.superInterfaceTypes().isEmpty()) {
			if (node.isInterface())
				appendToBuffer("extends ")
			else
				appendToBuffer("implements ")
			node.superInterfaceTypes().forEach[Type it, Integer counter|accept(this)
				if (counter < node.typeParameters().size - 1) {
					appendToBuffer(", ")
				}]
		}
		appendToBuffer("{")
		appendLineWrapToBuffer
		var BodyDeclaration prev
		for (BodyDeclaration body : node.bodyDeclarations() as List<BodyDeclaration>) {
			if (prev instanceof EnumConstantDeclaration) {
				if (body instanceof EnumConstantDeclaration) {
					appendToBuffer(", ")
				} else {
					appendToBuffer("; ")
				}
			}
			body.accept(this)
			prev = body
		}
		appendLineWrapToBuffer
		appendToBuffer("}")
		false;
	}

	override visit(Javadoc node) {
		appendToBuffer("/** ")
		node.tags.forEach[TagElement it|accept(this)]
		appendToBuffer("\n */")
		false
	}

	override visit(SimpleName node) {
		if (node.isKeyword)
			appendToBuffer('_')
		appendToBuffer(node.getIdentifier())
		false
	}

	def isKeyword(SimpleName name) {
		'it' == name.identifier
	}

	override visit(QualifiedName node) {
		node.getQualifier().accept(this)
		appendToBuffer(".")
		node.getName().accept(this)
		return false;
	}

	override visit(Modifier node) {
		var append = true
		switch node.keyword.toFlagValue {
			case Modifier.PUBLIC:
				if (node.parent instanceof TypeDeclaration || node.parent instanceof MethodDeclaration) {
					append = false
				}
			case Modifier.PRIVATE:
				if (node.parent instanceof FieldDeclaration) {
					append = false
				}
			default:
				append = true
		}
		if (append) {
			appendToBuffer(node.keyword.toString)
			appendSpaceToBuffer
		}
		false
	}

	override visit(FieldDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		printModifiers(node.modifiers())
		node.getType().accept(this)
		appendSpaceToBuffer
		node.fragments().forEach [ VariableDeclarationFragment it, counter |
			accept(this)
			if (counter < node.fragments().size - 1) {
				appendToBuffer(", ")
			}
		]
		appendLineWrapToBuffer
		false
	}

	override visit(VariableDeclarationExpression node) {
		printModifiers(node.modifiers())
		appendToBuffer('var ')
		node.getType().accept(this)
		appendToBuffer(" ")
		node.fragments().forEach [ VariableDeclarationFragment it, counter |
			accept(this)
			if (counter < node.fragments().size - 1) {
				appendToBuffer(", ")
			}
		]
		false;
	}

	override visit(VariableDeclarationFragment node) {
		node.getName().accept(this)
		appendExtraDimensions(node.extraDimensions)
		if (node.getInitializer() != null) {
			appendToBuffer("=")
			node.getInitializer().accept(this)
		}
		return false;
	}

	def private appendExtraDimensions(int extraDimensions) {
		for (var i = 0; i < extraDimensions; i++) {
			appendToBuffer("[]")
		}
	}

	override visit(VariableDeclarationStatement node) {
		printModifiers(node.modifiers())
		appendToBuffer("var ")
		node.getType().accept(this)
		appendToBuffer(" ")
		node.fragments().forEach [ VariableDeclarationFragment it, counter |
			accept(this)
			if (counter < node.fragments().size - 1) {
				appendToBuffer(", ")
			}
		]
		appendToBuffer(";")
		return false;
	}

	override visit(MethodDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		printModifiers(node.modifiers().filter[isAnnotation])
		if (node.isOverrideMethode) {
			appendToBuffer("override ")
		} else {
			appendToBuffer("def ")
		}
		printModifiers(node.modifiers().filter[isModifier])
		if (!node.typeParameters().isEmpty()) {
			appendToBuffer("<")
			node.typeParameters().forEach[TypeParameter it, counter|accept(this)
				if (counter < node.typeParameters().size - 1) {
					appendToBuffer(", ")
				}]
			appendToBuffer("> ")
		}

		if (!node.isConstructor()) {
			if (node.getReturnType2() != null) {
				node.getReturnType2().accept(this)
			} else {

				// methods really ought to have a return type
				appendToBuffer("void")
			}
			appendToBuffer(" ")
		}
		node.getName().accept(this)
		appendToBuffer("(")
		node.parameters().forEach[SingleVariableDeclaration it, counter|accept(this)
			if (counter < node.parameters().size - 1) {
				appendToBuffer(", ")
			}]

		appendToBuffer(")")
		appendExtraDimensions(node.extraDimensions)
		if (!node.thrownExceptions().isEmpty()) {
			appendToBuffer(" throws ")
			node.thrownExceptions().forEach[Name it, counter|accept(this)
				if (counter < node.thrownExceptions().size - 1) {
					appendToBuffer(", ")
				}]
			appendToBuffer(" ")
		}
		if (node.getBody() == null) {
			appendToBuffer(";")
		} else {
			node.getBody().accept(this)
		}
		return false;
	}

	override visit(SingleVariableDeclaration node) {
		printModifiers(node.modifiers())
		node.getType().accept(this)
		if (node.isVarargs()) {
			appendToBuffer("...")
		}
		appendToBuffer(" ")
		node.getName().accept(this)
		appendExtraDimensions(node.extraDimensions)
		if (node.getInitializer() != null) {
			appendToBuffer("=")
			node.getInitializer().accept(this)
		}
		return false;
	}

	override visit(Block node) {
		appendToBuffer("{")
		appendLineWrapToBuffer
		node.statements().forEach [ Statement it |
			accept(this)
		]
		appendLineWrapToBuffer
		appendToBuffer("}")
		false
	}

	override visit(ExpressionStatement node) {
		node.getExpression().accept(this)
		appendSpaceToBuffer
		false
	}

	override visit(MethodInvocation node) {
		if (node.getExpression() != null) {
			node.getExpression().accept(this)
			appendToBuffer(".")
		}
		if (!node.typeArguments().isEmpty()) {
			appendToBuffer("<")
			node.typeArguments().forEach[Type it, counter|accept(this)
				if (counter < node.typeArguments().size - 1) {
					appendToBuffer(", ")
				}]
			appendToBuffer(">")
		}
		node.getName().accept(this)
		appendToBuffer("(")
		node.arguments().forEach[Expression it, counter|accept(this)
			if (counter < node.arguments().size - 1) {
				appendToBuffer(", ")
			}]
		appendToBuffer(")")
		return false;
	}

	override visit(ForStatement node) {
		appendToBuffer("for (")
		node.initializers().forEach [ Expression it |
			accept(this)
		]
		appendToBuffer("; ")
		if (node.getExpression() != null) {
			node.getExpression().accept(this)
		}
		appendToBuffer("; ")
		node.updaters().forEach [ Expression it |
			accept(this)
		]
		appendToBuffer(") ")
		node.getBody().accept(this)
		return false;

	}

	override visit(NullLiteral node) {
		appendToBuffer('null')
		false
	}

	override visit(ThisExpression node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
			appendToBuffer(".")
		}
		appendToBuffer("this")
		false
	}

	override visit(FieldAccess node) {
		node.getExpression().accept(this)
		appendToBuffer(".")
		node.getName().accept(this)
		return false;
	}

	override visit(MarkerAnnotation node) {
		false
	}

	def private isOverrideMethode(MethodDeclaration declaration) {
		!declaration.modifiers().filter(Annotation).filter [
			"Override" == typeName.toString
		].empty
	}

	override visit(StringLiteral node) {
		appendToBuffer('\'')
		appendToBuffer(node.literalValue)
		appendToBuffer('\'')
		false
	}

	def printModifiers(Iterable<IExtendedModifier> ext) {
		ext.forEach [ IExtendedModifier p |
			(p as ASTNode).accept(this)
		]
	}

	def private appendSpaceToBuffer() {
		appendToBuffer(" ")
	}

	def private appendLineWrapToBuffer() {
		appendToBuffer("\n")
	}

	def private appendToBuffer(String string) {
		fBuffer.append(string)
	}
}
