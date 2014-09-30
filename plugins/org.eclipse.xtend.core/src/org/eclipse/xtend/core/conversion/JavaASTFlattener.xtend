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
import java.util.List
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
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
import org.eclipse.jdt.core.dom.PrefixExpression.Operator
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

	@Inject IValueConverterService converterService
	@Inject extension ASTFlattenerUtils

	//	@Inject UnicodeAwarePostProcessor unicodeProcessor
	/**
	 * The string buffer into which the serialized representation of the AST is
	 * written.
	 */
	StringBuffer fBuffer;
	List<String> problems = newArrayList()
	int javaSourceKind = ASTParser.K_COMPILATION_UNIT
	final static int JLS = AST.JLS3

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
	 * Resets this flattener so that it can be used again.
	 */
	def void reset() {
		this.fBuffer.setLength(0)
		this.problems = newArrayList()
	}

	/**
	 * Returns a list of problems occured during conversion
	 */
	def getProblems() {
		this.problems
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

	def protected addProblem(ASTNode node, String string) {
		problems.add('''«string» (start: «node.startPosition», length: «node.length»)''')
	}

	override boolean visit(Assignment node) {
		val leftSide = node.getLeftHandSide()

		// Array write access
		if (leftSide instanceof ArrayAccess) {
			val arrayName = computeArrayName(leftSide)
			appendToBuffer("{ ")
			val valName = '''_wrVal_«arrayName»'''
			val idxName = '''_wrIndx_«arrayName»'''

			appendToBuffer('''val «valName»=''')
			leftSide.array.accept(this)
			appendToBuffer(''' val «idxName»=''')
			leftSide.getIndex().accept(this)
			appendToBuffer(''' «valName».set(«idxName»,''')
			node.rightHandSide.accept(this)
			appendToBuffer(")")
			if (node.needsReturnValue()) {
				appendToBuffer(''' «valName».get(«idxName»)''')
			}
			appendToBuffer("}")
		} else {
			leftSide.accept(this)
			appendToBuffer(node.getOperator().toString())
			node.getRightHandSide().accept(this)
		}
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
		appendToBuffer(escapedValue)
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
		if (modifiers().static) {
			appendToBuffer(" final Void static_initializer = {")
			appendLineWrapToBuffer
			getBody.accept(this)
			appendToBuffer("null }")
			appendLineWrapToBuffer
		} else {
			getBody.accept(this)
		}
		return false
	}

	override visit(TypeDeclaration it) {
		if (javaSourceKind == ASTParser.K_CLASS_BODY_DECLARATIONS && isDummyType(it)) {
			bodyDeclarations.appendAll
			return false;
		}
		if (isNotSupportedInnerType(it)) {
			appendToBuffer('''/* FIXME only static inner classes are allowed «it.name»*/''')
			addProblem("only static inner classes are allowed")
			return false
		}

		if (javadoc != null) {
			javadoc.accept(this)
		}
		appendModifieres(modifiers())

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
		var convertedName = converterService.toString(identifier, "ValidID")
		if ("it".equals(convertedName) && shouldConvertName(it)) {
			convertedName = "renamed_" + convertedName
		}
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
		if (hasAnnotations) {
			appendToBuffer("/*FIXME can not add Annotation to Variable declaration. Java code: ")
			addProblem("Annotation on Variable declaration is not supported.")
		}
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
				if (!node.isConstructor) {
					if (node.isOverrideMethode) {
						appendToBuffer("override ")
					} else {
						appendToBuffer("def ")
					}
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
		if (isConstructor()) {
			appendToBuffer(" new")
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
			name.accept(this)
		}
		appendToBuffer("(")
		parameters.appendAllSeparatedByComma
		appendToBuffer(")")
		appendExtraDimensions(extraDimensions)
		if (!thrownExceptions.isEmpty()) {
			appendToBuffer(" throws ")
			thrownExceptions.appendAllSeparatedByComma
			appendToBuffer(" ")
		}
		if (getBody() != null) {
			getBody.accept(this)
		}
		return false
	}

	override visit(SingleVariableDeclaration it) {
		if (parent instanceof MethodDeclaration) {
			appendModifieres(modifiers().filter[Object e|!(e instanceof Modifier && (e as Modifier).final)])
		} else {
			appendModifieres(modifiers())
		}
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
		if (isLambdaCase(node)) {
			appendToBuffer("[")
			val method = node.anonymousClassDeclaration.bodyDeclarations.get(0) as MethodDeclaration
			method.parameters.appendAllSeparatedByComma
			appendToBuffer("|")
			method.body.statements.appendAll
			appendToBuffer("]")
		} else {
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
		}
		return false
	}

	def isLambdaCase(ClassInstanceCreation creation) {
		val anonymousClazz = creation.anonymousClassDeclaration
		if (anonymousClazz != null && anonymousClazz.bodyDeclarations.size == 1) {
			val declaredMethod = anonymousClazz.bodyDeclarations.get(0)
			if (declaredMethod instanceof MethodDeclaration && creation.type.resolveBinding != null) {
				val methodBinding = (declaredMethod as MethodDeclaration).resolveBinding
				val overrides = findOverride(methodBinding, methodBinding.declaringClass)
				return overrides != null && Modifier.isAbstract(overrides.modifiers)
			}
		}
		return false
	}

	override visit(Block it) {
		appendToBuffer("{")
		appendLineWrapToBuffer
		statements.appendAll
		appendLineWrapToBuffer
		appendToBuffer("}")
		appendLineWrapToBuffer
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
		val stringConcats = countStringConcats(node)
		if (stringConcats > 0) {
			appendToBuffer("'''")
			if (stringConcats > 2) {
				appendLineWrapToBuffer
			}
			node.leftOperand.convertToRichString
			if (node.leftOperand instanceof StringLiteral && node.rightOperand instanceof StringLiteral) {
				appendLineWrapToBuffer
			}
			node.rightOperand.convertToRichString
			node.extendedOperands().fold(node.rightOperand) [ prevExpr, Expression currExpr |
				if (prevExpr instanceof StringLiteral && currExpr instanceof StringLiteral) {
					appendLineWrapToBuffer
				}
				convertToRichString(currExpr)
				return currExpr
			]

			appendToBuffer("'''")
		} else {
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
		}
		return false
	}

	def void convertToRichString(Expression expression) {
		if (expression instanceof StringLiteral) {
			appendToBuffer(expression.richTextValue)
		} else {
			appendToBuffer("«")
			expression.accept(this)
			appendToBuffer("»")
		}
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
		appendToBuffer(" ")
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
		val dummyAST = AST.newAST(JLS)
		val pfOperator = node.operator
		if (node.operand instanceof ArrayAccess) {
			val pfOperand = node.operand as ArrayAccess
			if (pfOperator == PostfixExpression.Operator.INCREMENT ||
				pfOperator == PostfixExpression.Operator.DECREMENT) {

				val arrayName = computeArrayName(pfOperand)
				val idxName = '''_tPreInx_«arrayName»'''
				val tempVarName = '''_tPostVal_«arrayName»'''

				appendToBuffer('''{ var «idxName»=''')
				pfOperand.index.accept(this)
				appendToBuffer(''' var  ''')
				val varDeclaration = dummyAST.newVariableDeclarationFragment
				varDeclaration.name = dummyAST.newSimpleName(tempVarName)
				val arrayAccess = ASTNode.copySubtree(dummyAST, pfOperand) as ArrayAccess
				arrayAccess.index = dummyAST.newSimpleName(idxName)
				varDeclaration.initializer = arrayAccess
				varDeclaration.accept(this)

				val infixOp = dummyAST.newInfixExpression
				infixOp.leftOperand = dummyAST.newSimpleName(tempVarName)
				if (node.operator == PostfixExpression.Operator.DECREMENT)
					infixOp.operator = InfixExpression.Operator.MINUS
				else {
					infixOp.operator = InfixExpression.Operator.PLUS
				}
				infixOp.rightOperand = dummyAST.newNumberLiteral("1")

				val assigment = dummyAST.newAssignment()
				val writeArray = ASTNode.copySubtree(dummyAST, pfOperand) as ArrayAccess
				writeArray.index = dummyAST.newSimpleName(idxName)
				assigment.leftHandSide = writeArray
				assigment.rightHandSide = ASTNode.copySubtree(dummyAST, infixOp) as Expression
				assigment.accept(this)
				appendToBuffer('''«tempVarName» }''')
				return false
			}
		}
		node.operand.accept(this)
		appendToBuffer(pfOperator.toString())
		return false
	}

	override boolean visit(PrefixExpression node) {
		val dummyAST = AST.newAST(JLS)
		if (node.operator == Operator.DECREMENT || node.operator == Operator.INCREMENT) {
			if (node.operand instanceof ArrayAccess) {
				val pfOperand = node.operand as ArrayAccess

				/*	
				val _tempIndex = (i = i - 1)
				ints.set(_tempIndex,ints.get(_tempIndex) - 1)
				ints.get(_tempIndex) */
				val arrayName = computeArrayName(pfOperand)
				val idxName = '''_tPreInx_«arrayName»'''
				var op = "-"
				if (node.operator == Operator.INCREMENT) {
					op = "+"
				}
				appendToBuffer('''{val «idxName»=''')
				pfOperand.index.accept(this)
				appendToBuffer(''' val «idxName»_res=«arrayName».get(«idxName»)«op»1''')
				appendToBuffer(''' «arrayName».set(«idxName», «idxName»_res)  «idxName»_res}''')
				return false
			} else {
				val assigment = dummyAST.newAssignment()
				val infixOp = dummyAST.newInfixExpression
				infixOp.leftOperand = ASTNode.copySubtree(dummyAST, node.operand) as Expression
				if (node.operator == Operator.DECREMENT) {
					infixOp.operator = InfixExpression.Operator.MINUS
				} else {
					infixOp.operator = InfixExpression.Operator.PLUS

				}
				infixOp.rightOperand = dummyAST.newNumberLiteral("1")
				assigment.leftHandSide = ASTNode.copySubtree(dummyAST, node.operand) as Expression
				assigment.rightHandSide = infixOp
				val parent = dummyAST.newParenthesizedExpression
				parent.expression = assigment
				parent.accept(this)
				return false
			}
		}
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
			appendToBuffer(".")
		}
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments)
		}
		appendToBuffer("super(")
		node.arguments().appendAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(SuperFieldAccess node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
			appendToBuffer(".")
		}
		appendToBuffer("super.")
		node.getName().accept(this)
		return false
	}

	@Override override boolean visit(SuperMethodInvocation node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
			appendToBuffer(".")
		}
		appendToBuffer("super.")
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments)
		}
		node.getName().accept(this)
		appendToBuffer("(")
		node.arguments().appendAllSeparatedByComma
		appendToBuffer(")")
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

			var boolean currentIncludesWhiteSpace = (e instanceof TextElement)
			if (previousRequiresNewLine && currentIncludesWhiteSpace) {
				appendToBuffer("\n * ")
			}
			previousRequiresNewLine = currentIncludesWhiteSpace
			if (previousRequiresWhiteSpace && !currentIncludesWhiteSpace) {
				appendToBuffer(" ")
			}
			e.accept(this)
			previousRequiresWhiteSpace = !currentIncludesWhiteSpace && !(e instanceof TagElement)
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

		// TryStatementnode.resources() not supported in Juno
		//		if (node.getAST().apiLevel() > AST.JLS3) {
		//			if (node.resources().isEmpty()) {
		//				appendToBuffer("(")
		//				for (var Iterator<VariableDeclarationExpression> _it = node.resources().iterator(); _it.hasNext();) {
		//					var VariableDeclarationExpression _var = _it.next()
		//					_var.accept(this)
		//					if (_it.hasNext()) {
		//						appendToBuffer(",")
		//					}
		//				}
		//				appendToBuffer(") ")
		//			}
		//		}
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
		var value = node.getToken()
		if (value.startsWith("0x") || value.startsWith("0X")) {
			val lastChar = value.charAt(value.length - 1)
			if (Character.isLetter(lastChar))
				value = value.substring(0, value.length - 1) + "#" + lastChar
		}
		appendToBuffer(value)
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

	// UnionType is Not available in Juno
	//	override boolean visit(UnionType node) {
	//		for (var Iterator<Type> _it = node.types().iterator(); _it.hasNext();) {
	//			var Type t = _it.next()
	//			t.accept(this)
	//			if (_it.hasNext()) {
	//				appendToBuffer("|")
	//			}
	//		}
	//		return false
	//	}
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
		appendToBuffer("annotation ")
		node.getName().accept(this)
		appendToBuffer(" {")
		appendLineWrapToBuffer
		node.bodyDeclarations().appendAll
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(AnnotationTypeMemberDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifieres(node, node.modifiers())
		node.getType().accept(this)
		appendToBuffer(" ")
		node.getName().accept(this)
		if (node.getDefault() != null) {
			appendToBuffer(" = ")
			node.getDefault().accept(this)
		}
		appendLineWrapToBuffer
		return false
	}

	@Override override boolean visit(AnonymousClassDeclaration node) {
		appendToBuffer("{")
		node.bodyDeclarations().appendAll
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(ArrayAccess node) {
		val arrayname = computeArrayName(node)

		//Write access is handled in visit(Assignment)
		appendToBuffer('''{val _rdIndx_«arrayname»=''')
		node.index.accept(this)
		appendSpaceToBuffer
		node.array.accept(this)
		appendToBuffer('''.get(_rdIndx_«arrayname»)}''')
		return false
	}

	def computeArrayName(ArrayAccess node) {
		switch array : node.array {
			SimpleName:
				array.identifier
			MethodInvocation:
				array.name.identifier
			default:
				"tmpNode"
		}
	}

	def isReadAccess(ArrayAccess access) {
		access.parent instanceof Assignment
	}

	@Override override boolean visit(ArrayCreation node) {
		var at = node.getType()
		var dims = at.getDimensions()
		if (dims > 1) {
			appendToBuffer('''/* FIXME Only one dimension arrays are supported. «node»*/''')
			node.addProblem("Only one dimension arrays are supported.")
			return false
		}
		if (node.getInitializer() != null) {
			node.getInitializer().accept(this)
		} else {
			appendToBuffer("newArrayOfSize(")
			(node.dimensions() as Iterable<Expression>).get(0).accept(this)
			appendToBuffer(")")
		}
		return false
	}

	@Override override boolean visit(ArrayInitializer node) {
		appendToBuffer("#[")
		node.expressions().appendAllSeparatedByComma
		appendToBuffer("]")
		return false
	}

	@Override override boolean visit(ArrayType node) {
		node.getComponentType().accept(this)
		appendToBuffer("[]")
		return false
	}

	@Override override boolean visit(AssertStatement node) {
		appendToBuffer("assert ")
		node.getExpression().accept(this)
		if (node.getMessage() != null) {
			appendToBuffer(" : ")
			node.getMessage().accept(this)
		}
		appendLineWrapToBuffer
		return false
	}

	@Override override boolean visit(BreakStatement node) {
		appendToBuffer("/* FIXME unsupported BreakStatement: break ")
		if (node.getLabel() != null) {
			appendToBuffer(" ")
			node.getLabel().accept(this)
		}
		appendToBuffer("*/")
		return false
	}

	@Override override boolean visit(CatchClause node) {
		appendToBuffer("catch (")
		node.getException().accept(this)
		appendToBuffer(") ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(ConstructorInvocation node) {
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments())
		}
		appendToBuffer("this(")
		node.arguments().appendAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(ContinueStatement node) {
		appendToBuffer("/* FIXME Unsupported continue statement: ")
		if (node.getLabel() != null) {
			appendToBuffer(" ")
			node.getLabel().accept(this)
		}
		appendToBuffer(";")
		appendToBuffer("*/")
		appendLineWrapToBuffer
		return false
	}

	@Override override boolean visit(DoStatement node) {
		appendToBuffer("do ")
		node.getBody().accept(this)
		appendToBuffer(" while (")
		node.getExpression().accept(this)
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(EmptyStatement node) {
		appendToBuffer(';')
		return false
	}

	@Override override boolean visit(EnhancedForStatement node) {
		appendToBuffer("for (")
		node.getParameter().accept(this)
		appendToBuffer(" : ")
		node.getExpression().accept(this)
		appendToBuffer(") ")
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
			appendToBuffer("(")
			appendAllSeparatedByComma(node.arguments())
			appendToBuffer(")")
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
		appendToBuffer("enum ")
		node.getName().accept(this)
		appendToBuffer(" ")
		if (!node.superInterfaceTypes().isEmpty()) {
			appendToBuffer("implements ")
			node.superInterfaceTypes().appendAllSeparatedByComma
			appendToBuffer(" ")
		}
		appendToBuffer("{")
		node.enumConstants().appendAllSeparatedByComma

		if (!node.bodyDeclarations().isEmpty()) {
			appendToBuffer("; ")
			node.bodyDeclarations().appendAll
		}
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(LabeledStatement node) {
		node.getLabel().accept(this)
		appendToBuffer(": ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(MemberRef node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
		}
		appendToBuffer("#")
		node.getName().accept(this)
		return false
	}

	@Override override boolean visit(MethodRef node) {
		if (node.getQualifier() != null) {
			node.getQualifier().accept(this)
		}
		appendToBuffer("#")
		node.getName().accept(this)
		appendToBuffer("(")
		node.parameters().appendAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(MethodRefParameter node) {
		node.getType().accept(this)
		if (node.isVarargs()) {
			appendToBuffer("...")
		}
		if (node.getName() != null) {
			appendToBuffer(" ")
			node.getName().accept(this)
		}
		return false
	}

	@Override override boolean visit(QualifiedType node) {
		node.getQualifier().accept(this)
		appendToBuffer(".")
		node.getName().accept(this)
		return false
	}

	@Override override boolean visit(SwitchCase node) {
		if (node.isDefault()) {
			appendToBuffer("default :")
		} else {
			appendToBuffer("case ")
			node.getExpression().accept(this)
			appendToBuffer(":")
		}
		return false
	}

	@Override override boolean visit(SwitchStatement node) {
		appendToBuffer("switch (")
		node.getExpression().accept(this)
		appendToBuffer(") ")
		appendToBuffer("{")
		node.statements().appendAll
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(SynchronizedStatement node) {
		appendToBuffer("synchronized (")
		node.getExpression().accept(this)
		appendToBuffer(") ")
		node.getBody().accept(this)
		return false
	}

	@Override override boolean visit(TypeDeclarationStatement node) {
		if (isNotSupportedInnerType(node)) {
			appendToBuffer('''/* only static inner classes are allowed «node»*/''')
			node.addProblem("only static inner classes are allowed")
			return false
		}
		node.getDeclaration().accept(this)
		return false
	}

	def void setJavaSourceKind(int i) {
		javaSourceKind = i
	}

}
