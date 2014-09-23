/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion

import com.google.inject.Inject
import java.util.Iterator
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTVisitor
import org.eclipse.jdt.core.dom.Annotation
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration
import org.eclipse.jdt.core.dom.ArrayAccess
import org.eclipse.jdt.core.dom.ArrayCreation
import org.eclipse.jdt.core.dom.ArrayInitializer
import org.eclipse.jdt.core.dom.ArrayType
import org.eclipse.jdt.core.dom.AssertStatement
import org.eclipse.jdt.core.dom.Assignment
import org.eclipse.jdt.core.dom.Block
import org.eclipse.jdt.core.dom.BlockComment
import org.eclipse.jdt.core.dom.BodyDeclaration
import org.eclipse.jdt.core.dom.BooleanLiteral
import org.eclipse.jdt.core.dom.BreakStatement
import org.eclipse.jdt.core.dom.CastExpression
import org.eclipse.jdt.core.dom.CatchClause
import org.eclipse.jdt.core.dom.CharacterLiteral
import org.eclipse.jdt.core.dom.ClassInstanceCreation
import org.eclipse.jdt.core.dom.CompilationUnit
import org.eclipse.jdt.core.dom.ConditionalExpression
import org.eclipse.jdt.core.dom.ConstructorInvocation
import org.eclipse.jdt.core.dom.ContinueStatement
import org.eclipse.jdt.core.dom.DoStatement
import org.eclipse.jdt.core.dom.EmptyStatement
import org.eclipse.jdt.core.dom.EnhancedForStatement
import org.eclipse.jdt.core.dom.EnumConstantDeclaration
import org.eclipse.jdt.core.dom.EnumDeclaration
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.ExpressionStatement
import org.eclipse.jdt.core.dom.FieldAccess
import org.eclipse.jdt.core.dom.FieldDeclaration
import org.eclipse.jdt.core.dom.ForStatement
import org.eclipse.jdt.core.dom.IExtendedModifier
import org.eclipse.jdt.core.dom.IfStatement
import org.eclipse.jdt.core.dom.ImportDeclaration
import org.eclipse.jdt.core.dom.InfixExpression
import org.eclipse.jdt.core.dom.Initializer
import org.eclipse.jdt.core.dom.InstanceofExpression
import org.eclipse.jdt.core.dom.Javadoc
import org.eclipse.jdt.core.dom.LabeledStatement
import org.eclipse.jdt.core.dom.LineComment
import org.eclipse.jdt.core.dom.MarkerAnnotation
import org.eclipse.jdt.core.dom.MemberRef
import org.eclipse.jdt.core.dom.MemberValuePair
import org.eclipse.jdt.core.dom.MethodDeclaration
import org.eclipse.jdt.core.dom.MethodInvocation
import org.eclipse.jdt.core.dom.MethodRef
import org.eclipse.jdt.core.dom.MethodRefParameter
import org.eclipse.jdt.core.dom.Modifier
import org.eclipse.jdt.core.dom.NormalAnnotation
import org.eclipse.jdt.core.dom.NullLiteral
import org.eclipse.jdt.core.dom.NumberLiteral
import org.eclipse.jdt.core.dom.PackageDeclaration
import org.eclipse.jdt.core.dom.ParameterizedType
import org.eclipse.jdt.core.dom.ParenthesizedExpression
import org.eclipse.jdt.core.dom.PostfixExpression
import org.eclipse.jdt.core.dom.PrefixExpression
import org.eclipse.jdt.core.dom.PrimitiveType
import org.eclipse.jdt.core.dom.QualifiedName
import org.eclipse.jdt.core.dom.QualifiedType
import org.eclipse.jdt.core.dom.ReturnStatement
import org.eclipse.jdt.core.dom.SimpleName
import org.eclipse.jdt.core.dom.SimpleType
import org.eclipse.jdt.core.dom.SingleMemberAnnotation
import org.eclipse.jdt.core.dom.SingleVariableDeclaration
import org.eclipse.jdt.core.dom.StringLiteral
import org.eclipse.jdt.core.dom.SuperConstructorInvocation
import org.eclipse.jdt.core.dom.SuperFieldAccess
import org.eclipse.jdt.core.dom.SuperMethodInvocation
import org.eclipse.jdt.core.dom.SwitchCase
import org.eclipse.jdt.core.dom.SwitchStatement
import org.eclipse.jdt.core.dom.SynchronizedStatement
import org.eclipse.jdt.core.dom.TagElement
import org.eclipse.jdt.core.dom.TextElement
import org.eclipse.jdt.core.dom.ThisExpression
import org.eclipse.jdt.core.dom.ThrowStatement
import org.eclipse.jdt.core.dom.TryStatement
import org.eclipse.jdt.core.dom.Type
import org.eclipse.jdt.core.dom.TypeDeclaration
import org.eclipse.jdt.core.dom.TypeDeclarationStatement
import org.eclipse.jdt.core.dom.TypeLiteral
import org.eclipse.jdt.core.dom.TypeParameter
import org.eclipse.jdt.core.dom.UnionType
import org.eclipse.jdt.core.dom.VariableDeclarationExpression
import org.eclipse.jdt.core.dom.VariableDeclarationFragment
import org.eclipse.jdt.core.dom.VariableDeclarationStatement
import org.eclipse.jdt.core.dom.WhileStatement
import org.eclipse.jdt.core.dom.WildcardType
import org.eclipse.xtext.conversion.IValueConverterService

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class JavaASTFlattener extends ASTVisitor {

	/**
	 * The string buffer into which the serialized representation of the AST is
	 * written.
	 */
	protected StringBuffer fBuffer;
	@Inject IValueConverterService converterService
	@Inject extension ASTFlattenerUtils

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
		this.fBuffer.toString()
	}

	/**
	 * Resets this printer so that it can be used again.
	 */
	def void reset() {
		this.fBuffer.setLength(0)
	}

	def appendModifieres(ASTNode node, Iterable<IExtendedModifier> ext) {
		appendModifieres(node, ext, null)
	}

	def appendModifieres(ASTNode node, Iterable<IExtendedModifier> ext, (ASTNode)=>StringBuffer callBack) {
		val appender = [IExtendedModifier p|(p as ASTNode).accept(this)]
		ext.filter[IExtendedModifier it|isAnnotation].forEach(appender)
		if (callBack != null) {
			callBack.apply(node)
		}
		ext.filter[IExtendedModifier it|isModifier].forEach(appender)
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

	override boolean visit(Assignment node) {
		node.getLeftHandSide().accept(this)
		appendToBuffer(node.getOperator().toString())
		node.getRightHandSide().accept(this)
		return false
	}

	override boolean visit(MarkerAnnotation node) {
		appendToBuffer("@")
		node.getTypeName().accept(this)
		appendSpaceToBuffer
		return false
	}

	override visit(CompilationUnit it) {
		if (package != null) {
			package.accept(this)
		}
		imports.appendAll
		types.appendAll
		return false
	}

	override visit(PackageDeclaration it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		annotations.appendAll(" ")
		appendToBuffer("package ")
		name.accept(this)
		appendLineWrapToBuffer
		return false
	}

	override visit(ParameterizedType it) {
		type.accept(this)
		typeArguments.appendTypeParameters
		return false
	}

	override visit(PrimitiveType it) {
		appendToBuffer(getPrimitiveTypeCode.toString())
		return false
	}

	override visit(BooleanLiteral it) {
		appendToBuffer(String.valueOf(booleanValue))
		return false
	}

	override visit(StringLiteral it) {
		appendToBuffer(converterService.toString(literalValue, "STRING"))
		return false
	}

	override visit(ImportDeclaration it) {
		appendToBuffer("import ")
		if (isStatic()) {
			appendToBuffer("static ")
		}
		name.accept(this)
		if (isOnDemand()) {
			appendToBuffer(".*")
		}
		appendLineWrapToBuffer
		return false
	}

	override visit(Initializer it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		appendModifieres(modifiers())
		getBody.accept(this)
		return false
	}

	override visit(TypeDeclaration it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		appendModifieres(modifiers())

		//TODO only static inner classes allowed
		if (!isInterface() && (parent instanceof TypeDeclaration) && !modifiers().filter(Modifier).exists[isStatic]) {
			appendToBuffer('static ')
		}

		if (modifiers().filter(Modifier).isPackageVisibility()) {
			appendToBuffer('package ')
		}
		if (isInterface()) {
			appendToBuffer("interface ")
		} else {
			appendToBuffer("class ")
		}
		name.accept(this)
		if (!typeParameters.isEmpty()) {
			typeParameters.appendTypeParameters
		}
		appendSpaceToBuffer
		if (getSuperclassType() != null) {
			appendToBuffer("extends ")
			getSuperclassType.accept(this)
			appendToBuffer(" ")
		}
		if (!superInterfaceTypes.isEmpty()) {
			if (isInterface())
				appendToBuffer("extends ")
			else
				appendToBuffer("implements ")
			superInterfaceTypes.appendAllSeparatedByComma
		}
		appendToBuffer("{")
		appendLineWrapToBuffer
		var BodyDeclaration prev
		for (BodyDeclaration body : bodyDeclarations() as Iterable<BodyDeclaration>) {
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
		appendLineWrapToBuffer
		return false
	}

	override visit(Javadoc it) {
		appendToBuffer("/** ")
		tags.appendAll
		appendToBuffer("\n */")
		appendLineWrapToBuffer
		return false
	}

	override visit(SimpleName it) {
		var convertedName = converterService.toString(identifier, "ID")
		appendToBuffer(convertedName)
		return false
	}

	override visit(QualifiedName it) {
		getQualifier.accept(this)
		appendToBuffer(".")
		name.accept(this)
		return false
	}

	override boolean visit(SimpleType node) {
		return true;
	}

	override visit(Modifier it) {
		var append = true
		switch keyword.toFlagValue {
			case Modifier.PUBLIC:
				if (parent instanceof TypeDeclaration || parent instanceof MethodDeclaration) {
					append = false
				}
			case Modifier.PRIVATE:
				if (parent instanceof FieldDeclaration) {
					append = false
				}
			case Modifier.FINAL:
				if (parent instanceof VariableDeclarationExpression || parent instanceof  VariableDeclarationStatement) {
					append = false
				}
			default:
				append = true
		}
		if (append) {
			var valueToAppend = keyword.toString
			if (it.keyword.toFlagValue == 0) {
				valueToAppend = 'package'
			}
			appendToBuffer(valueToAppend)
			appendSpaceToBuffer
		}
		return false
	}

	override visit(FieldDeclaration it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		appendModifieres(modifiers())
		if (modifiers().filter(Modifier).isPackageVisibility()) {
			appendToBuffer('package ')
		}
		type.accept(this)
		appendSpaceToBuffer
		fragments.appendAllSeparatedByComma
		appendLineWrapToBuffer
		return false
	}

	override visit(VariableDeclarationExpression it) {
		appendModifieres(modifiers())
		appendToBuffer(handleVariableDeclaration(modifiers()))
		appendSpaceToBuffer
		type.accept(this)
		appendToBuffer(" ")
		fragments.appendAllSeparatedByComma
		return false
	}

	override visit(VariableDeclarationFragment it) {
		name.accept(this)
		appendExtraDimensions(extraDimensions)
		if (getInitializer() != null) {
			appendToBuffer("=")
			getInitializer.accept(this)
		}
		return false
	}

	override boolean visit(ConditionalExpression node) {
		appendToBuffer("if (")
		node.getExpression().accept(this)
		appendToBuffer(") ")
		node.getThenExpression().accept(this)
		appendToBuffer(" else ")
		node.getElseExpression().accept(this)
		appendToBuffer(" ")
		return false
	}

	def private appendExtraDimensions(int extraDimensions) {
		for (var i = 0; i < extraDimensions; i++) {
			appendToBuffer("[]")
		}
	}

	override visit(VariableDeclarationStatement it) {
		val hasAnnotations = !modifiers().filter(Annotation).empty

		// TODO we can't add Annotations to a Variable declarations 
		if (hasAnnotations)
			appendToBuffer("/*FIXME can not add Annotation to Variable declaration. Java code: ")
		appendModifieres(modifiers(), [if(hasAnnotations) appendToBuffer("*/") appendLineWrapToBuffer])
		appendToBuffer(handleVariableDeclaration(modifiers()))
		appendSpaceToBuffer
		type.accept(this)
		appendToBuffer(" ")
		fragments.appendAllSeparatedByComma
		appendLineWrapToBuffer
		return false
	}

	def appendAllSeparatedByComma(Iterable<? extends ASTNode> iterable) {
		appendAll(iterable, ", ")
	}

	def appendAll(Iterable<? extends ASTNode> iterable) {
		if (iterable.empty)
			return
		else
			appendAll(iterable, "")
	}

	def appendAll(Iterable<? extends ASTNode> iterable, String separator) {
		iterable.forEach [ ASTNode it, counter |
			accept(this)
			if (counter < iterable.size - 1) {
				appendToBuffer(separator)
			}
		]
	}

	def appendTypeParameters(Iterable<TypeParameter> iterable) {
		appendToBuffer("<")
		appendAllSeparatedByComma(iterable)
		appendToBuffer(">")
	}

	override visit(MethodDeclaration it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		val afterAnnotationProcessingCallback = [ ASTNode node |
			if (node instanceof MethodDeclaration) {
				if (node.isOverrideMethode) {
					appendToBuffer("override ")
				} else {
					appendToBuffer("def ")
				}
			}
		]
		appendModifieres(modifiers(), afterAnnotationProcessingCallback)
		if (modifiers().filter(Modifier).isPackageVisibility()) {
			if (parent instanceof TypeDeclaration) {
				if (!(parent as TypeDeclaration).isInterface) {
					appendToBuffer('package ')
				}
			}
		}
		if (!typeParameters.isEmpty()) {
			typeParameters.appendTypeParameters
		}
		if (!isConstructor()) {
			if (getReturnType2() != null) {
				getReturnType2.accept(this)
			} else {
				appendToBuffer("void")
			}
			appendToBuffer(" ")
		}
		name.accept(this)
		appendToBuffer("(")
		parameters.appendAllSeparatedByComma
		appendToBuffer(")")
		appendExtraDimensions(extraDimensions)
		if (!thrownExceptions.isEmpty()) {
			appendToBuffer(" throws ")
			thrownExceptions.appendAllSeparatedByComma
			appendToBuffer(" ")
		}
		if (getBody() == null) {
			appendToBuffer(";")
		} else {
			getBody.accept(this)
		}
		return false
	}

	def boolean isPackageVisibility(Iterable<Modifier> modifier) {
		modifier.filter[public || private || protected].empty
	}

	override visit(SingleVariableDeclaration it) {
		appendModifieres(modifiers())
		type.accept(this)
		if (isVarargs()) {
			appendToBuffer("...")
		}
		appendToBuffer(" ")
		name.accept(this)
		appendExtraDimensions(extraDimensions)
		if (getInitializer() != null) {
			appendToBuffer("=")
			getInitializer.accept(this)
		}
		return false
	}

	override boolean visit(ClassInstanceCreation node) {
		if (node.getExpression() != null) {
			node.getExpression().accept(this)
			appendToBuffer(".")
		}
		appendToBuffer("new ")
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments)
		}
		node.getType().accept(this)
		appendToBuffer("(")
		for (var Iterator<Expression> it = node.arguments().iterator(); it.hasNext();) {
			var Expression e = it.next()
			e.accept(this)
			if (it.hasNext()) {
				appendToBuffer(",")
			}
		}
		appendToBuffer(")")
		if (node.getAnonymousClassDeclaration() != null) {
			node.getAnonymousClassDeclaration().accept(this)
		}
		return false
	}

	override visit(Block it) {
		appendToBuffer("{")
		appendLineWrapToBuffer
		statements.appendAll
		appendLineWrapToBuffer
		appendToBuffer("}")
		return false
	}

	override boolean visit(CastExpression node) {
		node.getExpression().accept(this)
		appendToBuffer(" as ")
		node.getType().accept(this)
		return false
	}

	override visit(ExpressionStatement it) {
		getExpression.accept(this)
		appendSpaceToBuffer
		return false
	}

	override visit(MethodInvocation it) {
		if (getExpression() != null) {
			getExpression.accept(this)
			appendToBuffer(".")
		}
		if (!typeArguments.isEmpty()) {
			typeArguments.appendTypeParameters
		}
		name.accept(this)
		appendToBuffer("(")
		arguments.appendAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	override visit(ForStatement it) {
		appendToBuffer("for (")
		initializers.appendAll("")
		appendToBuffer("; ")
		if (getExpression() != null) {
			getExpression.accept(this)
		}
		appendToBuffer("; ")
		updaters.appendAll
		appendToBuffer(") ")
		getBody.accept(this)
		return false

	}

	override visit(NullLiteral it) {
		appendToBuffer('null')
		return false
	}

	override visit(ThisExpression it) {
		if (getQualifier() != null) {
			getQualifier.accept(this)
			appendToBuffer(".")
		}
		appendToBuffer("this")
		return false
	}

	override boolean visit(IfStatement node) {
		appendToBuffer("if (")
		node.getExpression().accept(this)
		appendToBuffer(") ")
		node.getThenStatement().accept(this)
		node.getElseStatement()
		if (node.getElseStatement() != null) {
			appendToBuffer(" else ")
			node.getElseStatement().accept(this)
		}
		return false
	}

	override visit(FieldAccess it) {
		getExpression.accept(this)
		appendToBuffer(".")
		name.accept(this)
		return false
	}

	override boolean visit(InfixExpression node) {
		node.getLeftOperand().accept(this)
		appendToBuffer(' ')
		appendToBuffer(node.getOperator().toString())
		appendToBuffer(' ')
		node.getRightOperand().accept(this)
		val extendedOperands = node.extendedOperands()
		if (extendedOperands.size() != 0) {
			appendToBuffer(' ')
			extendedOperands.forEach [ Expression e |
				appendToBuffer(node.getOperator().toString()).append(' ')
				e.accept(this)
			]
		}
		return false
	}

	override boolean visit(InstanceofExpression node) {
		node.getLeftOperand().accept(this)
		appendToBuffer(" instanceof ")
		node.getRightOperand().accept(this)
		return false
	}

	override boolean visit(ReturnStatement node) {
		appendToBuffer("return")
		if (node.getExpression() != null) {
			appendToBuffer(" ")
			node.getExpression().accept(this)
		}
		return false
	}

	override visit(BlockComment node) {
		appendToBuffer("/* */")
		return false
	}

	override boolean visit(LineComment node) {
		appendToBuffer("//\n")
		return false
	}

	override boolean visit(ParenthesizedExpression node) {
		appendToBuffer("(")
		node.getExpression().accept(this)
		appendToBuffer(")")
		return false
	}

	override boolean visit(PostfixExpression node) {
		node.getOperand().accept(this)
		appendToBuffer(node.getOperator().toString())
		return false
	}

	override boolean visit(PrefixExpression node) {
		appendToBuffer(node.getOperator().toString())
		node.getOperand().accept(this)
		return false
	}

	override boolean visit(SingleMemberAnnotation node) {
		appendToBuffer("@")
		node.getTypeName().accept(this)
		appendToBuffer("(")
		node.getValue().accept(this)
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(SuperConstructorInvocation node) {
		if (node.getExpression() != null) {
			node.getExpression().accept(this)
			this.fBuffer.append(".")
		}
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments)
		}
		this.fBuffer.append("super(")
		node.arguments().appendAllSeparatedByComma
		this.fBuffer.append(")")
		return false
	}

	@Override override boolean visit(SuperFieldAccess node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
			this.fBuffer.append(".")
		}
		this.fBuffer.append("super.")
		node.getName().accept(this)
		return false
	}

	@Override override boolean visit(SuperMethodInvocation node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
			this.fBuffer.append(".")
		}
		this.fBuffer.append("super.")
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments)
		}
		node.getName().accept(this)
		this.fBuffer.append("(")
		node.arguments().appendAllSeparatedByComma
		this.fBuffer.append(")")
		return false
	}

	override boolean visit(TagElement node) {
		if (node.isNested()) {
			appendToBuffer("{")
		} else {
			appendToBuffer("\n * ")
		}
		var boolean previousRequiresWhiteSpace = false
		if (node.getTagName() != null) {
			appendToBuffer(node.getTagName())
			previousRequiresWhiteSpace = true
		}
		var boolean previousRequiresNewLine = false
		for (var Iterator<? extends ASTNode> it = node.fragments().iterator(); it.hasNext();) {
			var ASTNode e = it.next()
			var boolean currentIncludesWhiteSpace = e instanceof TextElement
			if (previousRequiresNewLine && currentIncludesWhiteSpace) {
				appendToBuffer("\n * ")
			}
			previousRequiresNewLine = currentIncludesWhiteSpace
			if (previousRequiresWhiteSpace && currentIncludesWhiteSpace) {
				appendToBuffer(" ")
			}
			e.accept(this)
			previousRequiresWhiteSpace = currentIncludesWhiteSpace && e instanceof TagElement
		}
		if (node.isNested()) {
			appendToBuffer("}")
		}
		return false
	}

	override boolean visit(TextElement node) {
		appendToBuffer(node.getText())
		return false
	}

	override boolean visit(TypeLiteral node) {
		node.getType().accept(this)
		appendToBuffer(".class")
		return false
	}

	override boolean visit(ThrowStatement node) {
		appendToBuffer("throw ")
		node.getExpression().accept(this)
		appendToBuffer(";")
		return false
	}

	override boolean visit(TryStatement node) {
		appendToBuffer("try ")
		if (node.getAST().apiLevel() >= AST.JLS4) {
			if (node.resources().isEmpty()) {
				appendToBuffer("(")
				for (var Iterator<VariableDeclarationExpression> _it = node.resources().iterator(); _it.hasNext();) {
					var VariableDeclarationExpression _var = _it.next()
					_var.accept(this)
					if (_it.hasNext()) {
						appendToBuffer(",")
					}
				}
				appendToBuffer(") ")
			}
		}

		node.getBody().accept(this)
		appendToBuffer(" ")
		for (var Iterator<CatchClause> _it = node.catchClauses().iterator(); _it.hasNext();) {
			var CatchClause cc = _it.next()
			cc.accept(this)
		}
		if (node.getFinally() != null) {
			appendToBuffer("finally ")
			node.getFinally().accept(this)
		}
		return false
	}

	override boolean visit(TypeParameter node) {
		node.getName().accept(this)
		if (!node.typeBounds().isEmpty()) {
			appendToBuffer(" extends ")
			for (var Iterator<Type> _it = node.typeBounds().iterator(); _it.hasNext();) {
				var Type t = _it.next()
				t.accept(this)
				if (_it.hasNext()) {
					appendToBuffer(" & ")
				}
			}
		}
		return false
	}

	override boolean visit(NumberLiteral node) {
		appendToBuffer(node.getToken())
		return false
	}

	override boolean visit(NormalAnnotation node) {
		appendToBuffer("@")
		node.getTypeName().accept(this)
		appendToBuffer("(")
		node.values().appendAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	override boolean visit(UnionType node) {
		for (var Iterator<Type> _it = node.types().iterator(); _it.hasNext();) {
			var Type t = _it.next()
			t.accept(this)
			if (_it.hasNext()) {
				appendToBuffer("|")
			}
		}
		return false
	}

	override boolean visit(CharacterLiteral node) {
		appendToBuffer(node.getEscapedValue())
		return false
	}

	override boolean visit(WildcardType node) {
		appendToBuffer("?")
		var Type bound = node.getBound()
		if (bound != null) {
			if (node.isUpperBound()) {
				appendToBuffer(" extends ")
			} else {
				appendToBuffer(" super ")
			}
			bound.accept(this)
		}
		return false
	}

	override boolean visit(MemberValuePair node) {
		node.getName().accept(this)
		appendToBuffer("=")
		node.getValue().accept(this)
		return false
	}

	override boolean visit(WhileStatement node) {
		appendToBuffer("while (")
		node.getExpression().accept(this)
		appendToBuffer(") ")
		node.getBody().accept(this)
		return false
	}

	/* Start self Converted part*/
	@Override override boolean visit(AnnotationTypeDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifieres(node, node.modifiers())
		this.fBuffer.append("@interface ")
		node.getName().accept(this)
		this.fBuffer.append(" {")
		node.bodyDeclarations().appendAll
		this.fBuffer.append("}")
		return false
	}

	@Override override boolean visit(AnnotationTypeMemberDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifieres(node, node.modifiers())
		node.getType().accept(this)
		this.fBuffer.append(" ")
		node.getName().accept(this)
		this.fBuffer.append("()")
		if (node.getDefault() != null) {
			this.fBuffer.append(" default ")
			node.getDefault().accept(this)
		}
		this.fBuffer.append(";")
		return false
	}

	@Override override boolean visit(AnonymousClassDeclaration node) {
		this.fBuffer.append("{")
		node.bodyDeclarations().appendAll
		this.fBuffer.append("}")
		return false
	}

	@Override override boolean visit(ArrayAccess node) {
		node.getArray().accept(this)
		this.fBuffer.append("[")
		node.getIndex().accept(this)
		this.fBuffer.append("]")
		return false
	}

	@Override override boolean visit(ArrayCreation node) {
		this.fBuffer.append("new ")
		var ArrayType at = node.getType()
		var int dims = at.getDimensions()
		var Type elementType = at.getElementType()
		elementType.accept(this)
		for (Expression e : node.dimensions() as Iterable<Expression>) {
			this.fBuffer.append("[")
			e.accept(this)
			this.fBuffer.append("]")
			dims--
		}
		for (var int i = 0; i < dims; i++) {
			this.fBuffer.append("[]")
		}
		if (node.getInitializer() != null) {
			node.getInitializer().accept(this)
		}
		return false
	}

	@Override override boolean visit(ArrayInitializer node) {
		this.fBuffer.append("{")
		node.expressions().appendAllSeparatedByComma
		this.fBuffer.append("}")
		return false
	}

	@Override override boolean visit(ArrayType node) {
		node.getComponentType().accept(this)
		this.fBuffer.append("[]")
		return false
	}

	@Override override boolean visit(AssertStatement node) {
		this.fBuffer.append("assert ")
		node.getExpression().accept(this)
		if (node.getMessage() != null) {
			this.fBuffer.append(" : ")
			node.getMessage().accept(this)
		}
		appendLineWrapToBuffer
		return false
	}

	@Override override boolean visit(BreakStatement node) {
		this.fBuffer.append("/* FIXME unsupported BreakStatement")
		appendLineWrapToBuffer
		if (node.getLabel() != null) {
			this.fBuffer.append(" ")
			node.getLabel().accept(this)
		}
		appendToBuffer("*/")
		return false
	}

	@Override override boolean visit(CatchClause node) {
		this.fBuffer.append("catch (")
		node.getException().accept(this)
		this.fBuffer.append(") ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(ConstructorInvocation node) {
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments())
		}
		this.fBuffer.append("this(")
		node.arguments().appendAllSeparatedByComma
		this.fBuffer.append(")")
		return false
	}

	@Override override boolean visit(ContinueStatement node) {
		this.fBuffer.append("/* FIXME Unsupported continue statement")
		appendLineWrapToBuffer
		if (node.getLabel() != null) {
			this.fBuffer.append(" ")
			node.getLabel().accept(this)
		}
		this.fBuffer.append(";")
		appendToBuffer("*/")
		return false
	}

	@Override override boolean visit(DoStatement node) {
		this.fBuffer.append("do ")
		node.getBody().accept(this)
		this.fBuffer.append(" while (")
		node.getExpression().accept(this)
		this.fBuffer.append(")")
		return false
	}

	@Override override boolean visit(EmptyStatement node) {
		appendSpaceToBuffer
		return false
	}

	@Override override boolean visit(EnhancedForStatement node) {
		this.fBuffer.append("for (")
		node.getParameter().accept(this)
		this.fBuffer.append(" : ")
		node.getExpression().accept(this)
		this.fBuffer.append(") ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(EnumConstantDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifieres(node, node.modifiers())
		node.getName().accept(this)
		if (!node.arguments().isEmpty()) {
			this.fBuffer.append("(")
			appendAllSeparatedByComma(node.arguments())
			this.fBuffer.append(")")
		}
		if (node.getAnonymousClassDeclaration() != null) {
			node.getAnonymousClassDeclaration().accept(this)
		}
		return false
	}

	@Override override boolean visit(EnumDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifieres(node, node.modifiers())
		this.fBuffer.append("enum ")
		node.getName().accept(this)
		this.fBuffer.append(" ")
		if (!node.superInterfaceTypes().isEmpty()) {
			this.fBuffer.append("implements ")
			node.superInterfaceTypes().appendAllSeparatedByComma
			this.fBuffer.append(" ")
		}
		this.fBuffer.append("{")
		node.enumConstants().appendAllSeparatedByComma

		if (!node.bodyDeclarations().isEmpty()) {
			this.fBuffer.append("; ")
			node.bodyDeclarations().appendAll
		}
		this.fBuffer.append("}")
		return false
	}

	@Override override boolean visit(LabeledStatement node) {
		node.getLabel().accept(this)
		this.fBuffer.append(": ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(MemberRef node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
		}
		this.fBuffer.append("#")
		node.getName().accept(this)
		return false
	}

	@Override override boolean visit(MethodRef node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
		}
		this.fBuffer.append("#")
		node.getName().accept(this)
		this.fBuffer.append("(")
		node.parameters().appendAllSeparatedByComma
		this.fBuffer.append(")")
		return false
	}

	@Override override boolean visit(MethodRefParameter node) {
		node.getType().accept(this)
		if (node.isVarargs()) {
			this.fBuffer.append("...")
		}
		if (node.getName() != null) {
			this.fBuffer.append(" ")
			node.getName().accept(this)
		}
		return false
	}

	@Override override boolean visit(QualifiedType node) {
		node.getQualifier().accept(this)
		this.fBuffer.append(".")
		node.getName().accept(this)
		return false
	}

	@Override override boolean visit(SwitchCase node) {
		if (node.isDefault()) {
			this.fBuffer.append("default :")
		} else {
			this.fBuffer.append("case ")
			node.getExpression().accept(this)
			this.fBuffer.append(":")
		}
		return false
	}

	@Override override boolean visit(SwitchStatement node) {
		this.fBuffer.append("switch (")
		node.getExpression().accept(this)
		this.fBuffer.append(") ")
		this.fBuffer.append("{")
		node.statements().appendAll
		this.fBuffer.append("}")
		return false
	}

	@Override override boolean visit(SynchronizedStatement node) {
		this.fBuffer.append("synchronized (")
		node.getExpression().accept(this)
		this.fBuffer.append(") ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(TypeDeclarationStatement node) {
		node.getDeclaration().accept(this)
		return false
	}

}
