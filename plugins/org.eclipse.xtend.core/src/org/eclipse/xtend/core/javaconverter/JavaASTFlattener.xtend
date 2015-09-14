/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.javaconverter

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Iterator
import java.util.List
import java.util.Map
import java.util.Set
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
import org.eclipse.jdt.core.dom.Comment
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
import org.eclipse.jdt.core.dom.Statement
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
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.conversion.IValueConverterService

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class JavaASTFlattener extends ASTVisitor {

	@Inject IValueConverterService converterService
	@Inject extension ASTFlattenerUtils

	List<String> problems = newArrayList
	Set<Comment> assignedComments = newHashSet

	/**
	 * The string buffer into which the serialized representation of the AST is
	 * written.
	 */
	StringBuffer fBuffer
	String javaSources

	int indentation = 0
	boolean fallBackStrategy = false

	String targetApiLevel

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
	 * Returns a list of problems occured during conversion
	 */
	def getProblems() {
		this.problems
	}

	def acceptSyntaticBlock(Block node) {
		val childrenCount = node.statements.size
		if (childrenCount > 0) {
			node.statements.forEach [ ASTNode child, counter |
				child.accept(this)
				appendLineWrapToBuffer
			]
		}
	}

	def private decreaseIndent() {
		if (indentation > 0)
			this.indentation--
	}

	def private increaseIndent() {
		this.indentation++
	}

	private def boolean notAssigned(Comment comment) {
		!assignedComments.contains(comment)
	}

	def java8orHigher() {
		ASTParserFactory.asJLS(targetApiLevel) >= 8
	}

	def appendModifiers(ASTNode node, Iterable<IExtendedModifier> ext) {
		appendModifiers(node, ext, null)
	}

	def appendModifiers(ASTNode node, Iterable<IExtendedModifier> ext, (ASTNode)=>StringBuffer callBack) {
		val appender = [IExtendedModifier p|(p as ASTNode).accept(this)]
		ext.filter[isAnnotation && (it as Annotation).typeName.toString != "Override"].forEach(appender)
		if (callBack != null) {
			callBack.apply(node)
		}
		ext.filter[isModifier && (it as Modifier).keyword.toString != "default"].forEach(appender)
	}

	def private appendSpaceToBuffer() {
		appendToBuffer(" ")
	}

	def private appendLineWrapToBuffer() {
		appendToBuffer(nl())
		appendToBuffer("\t" * indentation)
	}

	def protected nl() {
		return StringConcatenation.DEFAULT_LINE_DELIMITER
	}

	def operator_multiply(String string, int i) {
		var retVal = ""
		var counter = 0
		while (counter < i) {
			counter++
			retVal = retVal + string
		}
		retVal
	}

	def private appendToBuffer(String string) {
		fBuffer.append(string)
	}

	def protected addProblem(ASTNode node, String string) {
		problems.add('''«string» (start: «node.startPosition», length: «node.length»)''')
	}

	override boolean visit(Assignment node) {
		val leftSide = node.getLeftHandSide()
		var Type type = null
		// Array write access
		if (leftSide instanceof ArrayAccess) {
			if (leftSide.array instanceof SimpleName)
				type = findDeclaredType(leftSide.array as SimpleName)
			node.handleAssignment(leftSide, type)
		} else {
			if (leftSide instanceof SimpleName)
				type = findDeclaredType(leftSide)
			node.handleAssignment(leftSide, type)
		}
		return false
	}
	
	def void handleAssignment(Assignment node, ASTNode leftSide, Type type) {
		leftSide.accept(this)
		appendToBuffer(node.getOperator().toString())
		node.handleRightHandSide(type)
	}

	def void handleAssignment(Assignment node, ArrayAccess leftSide, Type type) {
		val arrayName = computeArrayName(leftSide)
		appendToBuffer("{ ")
		val valName = '''_wrVal_«arrayName»'''
		var idxName = '''_wrIndx_«arrayName»'''

		appendToBuffer('''val «valName»=''')
		leftSide.array.accept(this)
		if (!leftSide.index.isConstantArrayIndex) {
			appendToBuffer(''' val «idxName»=''')
			leftSide.getIndex().accept(this)
			appendToBuffer(''' «valName».set(«idxName»,''')
		} else {
			appendToBuffer(''' «valName».set(''')
			leftSide.index.accept(this)
			appendToBuffer(",")
		}
		node.handleRightHandSide(type)
		appendToBuffer(")")
		if (node.needsReturnValue()) {
			appendToBuffer(''' «valName».get(''')
			if (!leftSide.index.isConstantArrayIndex) {
				appendToBuffer('''«idxName»''')
			} else {
				leftSide.getIndex().accept(this)
			}
			appendToBuffer(')')
		}
		appendToBuffer("}")
	}
	
	def handleRightHandSide(Assignment a, Type type) {
		if (type.needPrimitiveCast) {
			appendToBuffer('(')
			a.getRightHandSide().accept(this)
			appendToBuffer(''') as «type»''')
		} else {
			a.getRightHandSide().accept(this)
		}
	}

	override boolean visit(MarkerAnnotation node) {
		appendToBuffer("@")
		node.getTypeName().accept(this)
		appendSpaceToBuffer
		return false
	}

	override visit(CompilationUnit it) {
		if (!types.head.isDummyType) {
			package?.accept(this)
			imports.visitAll
		}
		types.visitAll
		return false
	}

	override visit(PackageDeclaration it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		annotations.visitAll(" ")
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

		// octal syntax \0, 1, 2, 3, 4, 5, 6, or 7 convert to \u000x
		// octal syntax \123 convert is not yet handled
		val handleOctal = escapedValue.replaceAll("\\\\([01234567])", "\\u000$1")
		appendToBuffer(handleOctal)
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
		appendModifiers(modifiers())
		if (modifiers().static) {
			if (it.parent instanceof TypeDeclaration && (it.parent as TypeDeclaration).fields.filter [
				modifiers().static && modifiers().final
			].forall [ f |
				f.fragments.forall[VariableDeclarationFragment fragment|!getBody().isAssignedInBody(fragment)]
			]) {
				appendToBuffer(" final Void static_initializer = {")
				appendLineWrapToBuffer
				getBody.accept(this)
				appendToBuffer("null }")
				appendLineWrapToBuffer
			} else {
				addProblem("Static initializer is not fully supported")
				appendToBuffer("{/*FIXME ")
				getBody.accept(this)
				appendToBuffer("*/}")
			}
		} else {
			if (parent instanceof AnonymousClassDeclaration) {
				addProblem('''Initializer is not supported in «ASTNode.nodeClassForType(parent.nodeType).simpleName»''')
			}
			getBody.accept(this)
		}
		return false
	}

	override visit(TypeDeclaration it) {
		if (isDummyType(it)) {
			bodyDeclarations.visitAll(nl())
			return false;
		}
		if (isNotSupportedInnerType(it)) {
			appendToBuffer('''/* FIXME Non-static inner classes are not supported.*/''')
			addProblem("Non-static inner classes are not supported.")
		}

		if (javadoc != null) {
			javadoc.accept(this)
		}
		appendModifiers(modifiers())

		if (isInterface()) {
			appendToBuffer("interface ")
		} else {
			if (modifiers().filter(Modifier).isPackageVisibility()) {
				appendToBuffer('package ')
			}
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
			appendSpaceToBuffer
		}
		if (!superInterfaceTypes.isEmpty()) {
			if (isInterface())
				appendToBuffer("extends ")
			else
				appendToBuffer("implements ")
			superInterfaceTypes.visitAllSeparatedByComma
		}
		appendToBuffer("{")
		increaseIndent
		var BodyDeclaration prev
		for (BodyDeclaration body : bodyDeclarations() as Iterable<BodyDeclaration>) {
			if (prev instanceof EnumConstantDeclaration) {
				if (body instanceof EnumConstantDeclaration) {
					appendToBuffer(", ")
				} else {
					appendToBuffer("; ")
				}
			}
			appendLineWrapToBuffer
			body.accept(this)
			prev = body
		}
		if (it.root instanceof CompilationUnit) {
			val cu = it.root as CompilationUnit
			cu.unAssignedComments.forEach [
				accept(this)
				assignedComments.add(it)
			]
		}
		decreaseIndent
		appendLineWrapToBuffer
		appendToBuffer("}")
		return false
	}

	def private Iterable<Comment> unAssignedComments(CompilationUnit cu) {
		cu.commentList.filter[Comment c|!(c.docComment && c.parent != null) && c.notAssigned]
	}

	override visit(Javadoc it) {
		appendToBuffer("/** ")
		tags.visitAll
		appendLineWrapToBuffer
		appendToBuffer(" */")
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
		if (fallBackStrategy && isStaticMemberCall &&
			!(parent instanceof SimpleType || parent instanceof ImportDeclaration)) {
			appendToBuffer("::")
		} else {
			appendToBuffer(".")
		}
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
				if (parent instanceof VariableDeclarationExpression || parent instanceof VariableDeclarationStatement) {
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
		fragments.forEach [ VariableDeclarationFragment frag |
			appendModifiers(modifiers())
			if (modifiers().filter(Modifier).isPackageVisibility()) {
				if (parent instanceof TypeDeclaration) {
					if (!(parent as TypeDeclaration).isInterface) {
						appendToBuffer('package ')
					}
				}
			}
			type.accept(this)
			appendExtraDimensions(frag.getExtraDimensions())
			appendSpaceToBuffer
			frag.accept(this)
		]
		return false
	}

	override visit(VariableDeclarationExpression it) {
		fragments.forEach [ VariableDeclarationFragment frag, counter |
			appendModifiers(modifiers())
			appendToBuffer(handleVariableDeclaration(modifiers()))
			appendSpaceToBuffer
			type.accept(this)
			appendSpaceToBuffer
			frag.accept(this)
			if (counter < fragments.size - 1) {
				appendToBuffer(",")
				appendSpaceToBuffer
			}
		]

		return false
	}

	override visit(VariableDeclarationFragment it) {
		name.accept(this)
		if (getInitializer() != null) {
			appendToBuffer("=")
			val type = findDeclaredType(name)
			if (type.needPrimitiveCast) {
				appendToBuffer('(')
				getInitializer.accept(this)
				appendToBuffer(''') as «type»''')
			} else {
				getInitializer.accept(this)
			}
		} else if (parent instanceof VariableDeclarationStatement) {
			if ((parent as VariableDeclarationStatement).modifiers().isFinal) {
				appendToBuffer("/* FIXME empty initializer for final variable is not supported */")
				addProblem("Empty initializer for final variables is not supported.")
			}
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
		appendSpaceToBuffer
		return false
	}

	def private appendExtraDimensions(int extraDimensions) {
		appendToBuffer("[]" * extraDimensions)
	}

	override visit(VariableDeclarationStatement it) {
		val hasAnnotations = !modifiers().filter(Annotation).empty
		fragments.forEach [ VariableDeclarationFragment frag |
			if (hasAnnotations) {
				appendToBuffer("/*FIXME Cannot add Annotation to Variable declaration. Java code: ")
			}
			appendModifiers(modifiers(), [
				if (hasAnnotations) {
					appendToBuffer("*/")
					appendLineWrapToBuffer
				}
			])
			appendToBuffer(handleVariableDeclaration(modifiers()))
			appendSpaceToBuffer
			if (!type.isMissingType()) {
				type.accept(this)
			}
			appendExtraDimensions(frag.getExtraDimensions())
			appendSpaceToBuffer
			frag.accept(this)
			appendSpaceToBuffer
		]
		return false
	}

	def boolean isMissingType(Type type) {
		if (type instanceof SimpleType) {
			if (type.name.isSimpleName) {
				return "MISSING".equals((type.name as SimpleName).identifier)
			}
		}
		return false
	}

	def visitAllSeparatedByComma(Iterable<? extends ASTNode> iterable) {
		visitAll(iterable, ", ")
	}

	def visitAll(Iterable<? extends ASTNode> iterable) {
		if (iterable.empty)
			return
		else
			visitAll(iterable, null)
	}

	def visitAll(Iterable<? extends ASTNode> iterable, String separator) {
		iterable.forEach [ ASTNode node, counter |
			node.accept(this)
			if (separator != null && counter < iterable.size - 1) {
				appendToBuffer(separator)
			}
		]
	}

	def appendTypeParameters(Iterable<TypeParameter> iterable) {
		if (iterable.isEmpty)
			return; // "diamond operator" java7
		appendToBuffer("<")
		visitAllSeparatedByComma(iterable)
		appendToBuffer(">")
	}

	override visit(MethodDeclaration it) {
		if (javadoc != null) {
			javadoc.accept(this)
		}
		val afterAnnotationProcessingCallback = [ ASTNode node |
			if (node instanceof MethodDeclaration) {
				if (!node.isConstructor) {
					if (node.isOverrideMethod) {
						appendToBuffer("override ")
					} else {
						appendToBuffer("def ")
					}
				}
			}
		]
		appendModifiers(modifiers(), afterAnnotationProcessingCallback)
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
			if (isConstructor) {
				addProblem("Type parameters for constructors are not supported")
			}
			typeParameters.appendTypeParameters
		}
		if (!isConstructor()) {
			if (getReturnType2() != null) {
				getReturnType2.accept(this)
			} else {
				appendToBuffer("void")
			}
			appendSpaceToBuffer
			name.accept(this)
		}
		appendToBuffer("(")
		parameters.reverseView.forEach [ SingleVariableDeclaration p |
			if (body.isAssignedInBody(p.name)) {
				val varFrag = p.getAST().newVariableDeclarationFragment
				varFrag.name = p.getAST().newSimpleName(p.name.toString)
				p.name = p.getAST().newSimpleName(p.name + "_finalParam_")
				varFrag.initializer = p.getAST().newSimpleName(p.name.toString)
				val varDecl = p.getAST().newVariableDeclarationStatement(varFrag)
				val typeCopy = p.getAST().createInstance(SimpleType) as Type
				varDecl.type = typeCopy
				body.statements.add(0, varDecl)
			}
		]
		parameters.visitAllSeparatedByComma
		appendToBuffer(")")
		appendExtraDimensions(getExtraDimensions())
		var List<? extends ASTNode> throwsTypes = newArrayList
		if (!java8orHigher()) {
			throwsTypes = thrownExceptions
		} else {
			throwsTypes = it.genericChildListProperty('thrownExceptionTypes')
		}
		if (!throwsTypes.isEmpty()) {
			appendToBuffer(" throws ")
			throwsTypes.visitAllSeparatedByComma
		}
		appendSpaceToBuffer
		if (getBody() != null) {
			getBody.accept(this)
		} else {
			appendLineWrapToBuffer
		}
		return false
	}

	override visit(SingleVariableDeclaration it) {
		if (parent instanceof MethodDeclaration || parent instanceof CatchClause ||
			parent instanceof EnhancedForStatement) {
			appendModifiers(modifiers().filter(IExtendedModifier).filter[annotation])
		} else {
			appendModifiers(modifiers())
		}
		type.accept(this)
		appendExtraDimensions(getExtraDimensions())
		if (isVarargs()) {
			appendToBuffer("...")
		}
		appendSpaceToBuffer
		name.accept(this)
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
			if (fallBackStrategy) {
				appendToBuffer("(")
			}
			appendToBuffer("[")
			val method = node.anonymousClassDeclaration.bodyDeclarations.get(0) as MethodDeclaration
			if (!method.parameters.empty) {
				method.parameters.visitAllSeparatedByComma
				appendToBuffer("|")
			} else if (fallBackStrategy) {
				appendToBuffer("|")
			}
			method.body.statements.visitAll
			appendToBuffer("]")
			if (fallBackStrategy) {
				appendToBuffer(" as ")
				if (!node.typeArguments().isEmpty()) {
					appendTypeParameters(node.typeArguments)
				}
				node.getType().accept(this)
				appendToBuffer(")")
			}
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

	override visit(Block node) {
		appendToBuffer("{")
		increaseIndent
		if (!node.statements.empty) {
			node.statements.forEach [ ASTNode child, counter |
				appendLineWrapToBuffer
				child.accept(this)
			]
		}
		// collect orphaned comments
		if (node.root instanceof CompilationUnit) {
			val cu = node.root as CompilationUnit
			cu.unAssignedComments.filter [
				startPosition < node.startPosition + node.length
			].forEach [
				if (!(it instanceof LineComment)) {
					appendLineWrapToBuffer
				}
				accept(this)
				assignedComments.add(it)
			]
		}
		decreaseIndent
		appendLineWrapToBuffer
		appendToBuffer("}")

		return false
	}

	override boolean visit(CastExpression node) {
		val parantesis = !(node.parent instanceof Assignment)
		if(parantesis)
			appendToBuffer('(')
		node.getExpression().accept(this)
		appendToBuffer(" as ")
		node.getType().accept(this)
		if(parantesis)
			appendToBuffer(')')
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
			if (fallBackStrategy && isStaticMemberCall) {
				appendToBuffer("::")
			} else {
				appendToBuffer(".")
			}
		}
		if (!typeArguments.isEmpty()) {
			typeArguments.appendTypeParameters
		}
		name.accept(this)
		appendToBuffer("(")
		arguments.visitAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	override visit(ForStatement it) {
		appendToBuffer("for (")
		initializers.visitAll
		appendToBuffer("; ")
		if (getExpression() != null) {
			getExpression.accept(this)
		}
		appendToBuffer("; ")
		updaters.visitAll
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
		if (node.getElseStatement() != null) {
			appendToBuffer(" else ")
			node.getElseStatement().accept(this)
		}
		return false
	}

	override visit(FieldAccess it) {
		getExpression.accept(this)
		if (fallBackStrategy && isStaticMemberCall) {
			appendToBuffer("::")
		} else {
			appendToBuffer(".")
		}
		name.accept(this)
		return false
	}

	override boolean visit(InfixExpression node) {
		val useRichString = node.canConvertToRichText
		if (useRichString) {
			val firstEntrance = !(node.parent instanceof InfixExpression)
			if (firstEntrance) {
				appendToBuffer("'''")
			}
			node.leftOperand.appendAsRichString
			node.rightOperand.appendAsRichString
			node.extendedOperands().fold(node.rightOperand) [ prevExpr, Expression currExpr |
				currExpr.appendAsRichString
				return currExpr
			]
			if (firstEntrance) {
				appendToBuffer("'''")
				if (fallBackStrategy) {
					appendToBuffer(".toString")
				}
			}
		} else {
			node.getLeftOperand().accept(this)
			val operator = node.getOperator()
			node.handleInfixRightSide(operator, node.getRightOperand())
			val extendedOperands = node.extendedOperands()
			if (extendedOperands.size() != 0) {
				extendedOperands.forEach [ Expression e |
					node.handleInfixRightSide(operator, e)
				]
			}
		}
		return false
	}

	def handleInfixRightSide(InfixExpression infixParent, InfixExpression.Operator operator, Expression rightSide) {
		switch operator {
			case InfixExpression.Operator.XOR:
				if (isBooleanInvolved(infixParent)) {
					appendToBuffer(".xor(")
					rightSide.accept(this)
					appendToBuffer(")")
				} else {
					appendToBuffer(".bitwiseXor(")
					rightSide.accept(this)
					appendToBuffer(")")
				}
			case InfixExpression.Operator.AND,
			case InfixExpression.Operator.OR: {
				if (!isBooleanInvolved(infixParent)) {
					appendToBuffer('''.bitwise«if(operator == InfixExpression.Operator.AND) "And" else "Or"»(''')
					rightSide.accept(this)
					appendToBuffer(")")
				} else {
					appendSpaceToBuffer
					appendToBuffer(operator.toString() * 2)
					appendSpaceToBuffer
					rightSide.accept(this)
				}
			}
			case InfixExpression.Operator.EQUALS: {
				appendToBuffer(' === ')
				rightSide.accept(this)
			}
			case InfixExpression.Operator.NOT_EQUALS: {
				appendToBuffer(' !== ')
				rightSide.accept(this)
			}
			default: {
				appendSpaceToBuffer
				appendToBuffer(operator.toString())
				appendSpaceToBuffer
				rightSide.accept(this)
			}
		}
	}

	def boolean isBooleanInvolved(InfixExpression it) {
		return leftOperand.isBooleanType || rightOperand.isBooleanType
	}

	def boolean isBooleanType(Expression expression) {
		if (expression instanceof BooleanLiteral) {
			return true
		}
		if (expression instanceof SimpleName) {
			val declType = findDeclaredType(expression)
			if (declType != null) {
				switch declType {
					case declType.isPrimitiveType: {
						return (declType as PrimitiveType).getPrimitiveTypeCode == PrimitiveType.BOOLEAN
					}
				}
			}
		}
		return false
	}

	def void appendAsRichString(Expression expression) {
		if (expression instanceof StringLiteral) {
			appendToBuffer(expression.richTextValue)
		} else {
			val stringConcat = (expression instanceof InfixExpression) &&
				canConvertToRichText(expression as InfixExpression)
			if(!stringConcat) appendToBuffer("«")
			expression.accept(this)
			if(!stringConcat) appendToBuffer("»")
		}
	}

	def richTextValue(StringLiteral literal) {
		var value = literal.literalValue

		// FIXME append only on latest string in concatenation 
		if (value.endsWith("'")) {
			value = value.concat("«»")
		}
		return value
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
			appendSpaceToBuffer
			node.getExpression().accept(this)
			appendSpaceToBuffer
		} else {
			val parent = node.parent
			val boolean isIfElse = (parent instanceof IfStatement && (parent as IfStatement).elseStatement !== null)
			if (!isIfElse && !(parent instanceof SwitchStatement)) {
				appendToBuffer(';')
			}
		}
		return false
	}

	override visit(BlockComment node) {
		if (javaSources != null) {
			appendToBuffer(node.commentContent)
			if(node.shouldWrap) appendLineWrapToBuffer
		}
		return false
	}

	def private boolean shouldWrap(BlockComment comment) {
		val index = comment.startPosition + comment.length
		if (index < javaSources.length) {
			val char charAfterComment = javaSources.charAt(index)
			if (charAfterComment == Character.valueOf('\n') || charAfterComment == Character.valueOf('\r'))
				return true
		}
		return false
	}

	def private commentContent(Comment comment) {
		javaSources.substring(comment.startPosition, comment.startPosition + comment.length)
	}

	override boolean visit(LineComment node) {
		if (javaSources != null) {
			appendToBuffer(node.commentContent)
		}
		appendLineWrapToBuffer
		return false
	}

	override boolean visit(ParenthesizedExpression node) {
		appendToBuffer("(")
		node.getExpression().accept(this)
		appendToBuffer(")")
		return false
	}

	override boolean visit(PostfixExpression node) {
		val dummyAST = AST.newAST(node.AST.apiLevel)
		val pfOperator = node.operator
		if (node.operand instanceof ArrayAccess) {
			val pfOperand = node.operand as ArrayAccess
			if (pfOperator == PostfixExpression.Operator.INCREMENT ||
				pfOperator == PostfixExpression.Operator.DECREMENT) {

				val arrayName = computeArrayName(pfOperand)
				val idxName = '''_postIndx_«arrayName»'''
				val tempVarName = '''_postVal_«arrayName»'''

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
				appendToBuffer('''«if(needsReturnValue(node)) tempVarName» }''')
				return false
			}
		}
		node.operand.accept(this)
		appendToBuffer(pfOperator.toString())
		return false
	}

	override boolean visit(PrefixExpression node) {
		val operand = node.operand
		switch (node.operator) {
			case Operator.DECREMENT,
			case Operator.INCREMENT: {
				if (operand instanceof ArrayAccess) {
					/*	
					 * val _tempIndex = (i = i - 1)
					 * ints.set(_tempIndex,ints.get(_tempIndex) - 1)
					 ints.get(_tempIndex) */
					val arrayName = computeArrayName(operand)
					val idxName = '''_tPreInx_«arrayName»'''
					var op = "-"
					if (node.operator == Operator.INCREMENT) {
						op = "+"
					}
					appendToBuffer('''{val «idxName»=''')
					operand.index.accept(this)
					appendToBuffer(''' val «idxName»_res=«arrayName».get(«idxName»)«op»1''')
					appendToBuffer(''' «arrayName».set(«idxName», «idxName»_res)  «idxName»_res}''')
					return false
				} else {
					val dummyAST = AST.newAST(node.AST.apiLevel)
					val assigment = dummyAST.newAssignment()
					val infixOp = dummyAST.newInfixExpression
					infixOp.leftOperand = ASTNode.copySubtree(dummyAST, operand) as Expression
					if (node.operator == Operator.DECREMENT) {
						infixOp.operator = InfixExpression.Operator.MINUS
					} else {
						infixOp.operator = InfixExpression.Operator.PLUS
					}
					infixOp.rightOperand = dummyAST.newNumberLiteral("1")
					val leftSide = ASTNode.copySubtree(dummyAST, operand) as Expression
					assigment.leftHandSide = leftSide
					assigment.rightHandSide = infixOp
					appendToBuffer('{')
					var Type type = null
					if (operand instanceof SimpleName) {
						type = findDeclaredType(operand)
					}
					assigment.handleAssignment(leftSide, type)
					appendToBuffer('}')
					return false
				}
			}
			case Operator.COMPLEMENT: {
				node.getOperand().accept(this)
				appendToBuffer(".bitwiseNot")
			}
			default: {
				appendToBuffer(node.getOperator().toString())
				node.getOperand().accept(this)
			}
		}
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
		node.arguments().visitAllSeparatedByComma
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
		node.arguments().visitAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	override boolean visit(TagElement node) {
		if (node.isNested()) {
			appendToBuffer("{")
		} else {
			appendLineWrapToBuffer
			appendToBuffer(" * ")
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
				appendLineWrapToBuffer
				appendToBuffer(" * ")
			}
			previousRequiresNewLine = currentIncludesWhiteSpace
			if (previousRequiresWhiteSpace && !currentIncludesWhiteSpace) {
				appendSpaceToBuffer
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
		if(fallBackStrategy) appendToBuffer("typeof(")
		node.getType().accept(this)
		if(fallBackStrategy) appendToBuffer(")")
		return false
	}

	override boolean visit(ThrowStatement node) {
		appendToBuffer("throw ")
		node.getExpression().accept(this)
		if(!(node.parent instanceof Block)){
			appendToBuffer(';')
		}
		return false
	}

	override boolean visit(TryStatement node) {
		appendToBuffer("try ")
		val resources = node.genericChildListProperty("resources")
		// Java7 try with resource
		if (!resources.nullOrEmpty) {
			appendToBuffer("(")
			for (child : resources) {
				child.accept(this)
			}
			appendToBuffer(")")
			node.addProblem("Try with resource is not yet supported.")
		}
		node.getBody().accept(this)
		node.catchClauses.forEach[(it as ASTNode).accept(this)]

		if (node.getFinally() != null) {
			appendToBuffer(" finally ")
			node.getFinally().accept(this)
		} else {
			appendLineWrapToBuffer
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
			if ('l' == lastChar.toString.toLowerCase) {
				value = value.substring(0, value.length - 1) + "#" + lastChar
			}
			val binExponent = value.indexOf('p')
			if (binExponent >= 2) {
				if (value.endsWith('f')) {
					value = Float.valueOf(value).toString + "f"
				} else {
					value = Double.valueOf(value).toString
				}
			}
		}
		appendToBuffer(value)
		return false
	}

	override boolean visit(NormalAnnotation node) {
		appendToBuffer("@")
		node.getTypeName().accept(this)
		appendToBuffer("(")
		node.values().visitAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	override boolean visit(CharacterLiteral node) {
		appendToBuffer('''Character.valueOf(«node.getEscapedValue()»).charValue''')
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
		appendModifiers(node, node.modifiers())
		appendToBuffer("annotation ")
		node.getName().accept(this)
		appendToBuffer(" {")
		appendLineWrapToBuffer
		node.bodyDeclarations().visitAll
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(AnnotationTypeMemberDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifiers(node, node.modifiers())
		node.getType().accept(this)
		appendSpaceToBuffer
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
		increaseIndent
		appendLineWrapToBuffer
		node.bodyDeclarations().visitAll
		decreaseIndent
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(ArrayAccess node) {
		if (node.index instanceof NumberLiteral) {
			node.array.accept(this)
			appendToBuffer(".get(")
			node.index.accept(this)
			appendToBuffer(")")
		} else {
			val arrayname = computeArrayName(node)

			// Write access is handled in visit(Assignment)
			appendToBuffer('''{val _rdIndx_«arrayname»=''')
			node.index.accept(this)
			appendSpaceToBuffer
			node.array.accept(this)
			appendToBuffer('''.get(_rdIndx_«arrayname»)}''')
		}
		return false
	}

	def String computeArrayName(ArrayAccess node) {
		switch array : node.array {
			SimpleName:
				array.identifier
			MethodInvocation:
				array.name.identifier
			ArrayAccess:
				"_" + computeArrayName(array)
			default:
				"tmpNode"
		}
	}

	@Override override boolean visit(ArrayCreation node) {
		var at = node.getType()
		var dims = at.getDimensions()
		if (dims > 1) {
			appendToBuffer('''/* FIXME Only one dimensional arrays are supported. «node»*/''')
			node.addProblem("Only one dimension arrays are supported.")
			return false
		}
		if (node.getInitializer() != null) {
			if(fallBackStrategy) appendToBuffer('(')
			node.getInitializer().accept(this)
			if (fallBackStrategy) {
				appendToBuffer(' as ')
				at.accept(this)
				appendToBuffer(')')
			}
		} else {
			appendToBuffer(
				'''new«if (node.type.elementType.isPrimitiveType) {
					(node.type.elementType as PrimitiveType).primitiveTypeCode.toString.toFirstUpper
				}»ArrayOfSize(''')
			(node.dimensions() as Iterable<Expression>).get(0).accept(this)
			appendToBuffer(")")
		}
		return false
	}

	@Override override boolean visit(ArrayInitializer node) {
		appendToBuffer("#[")
		node.expressions().visitAllSeparatedByComma
		appendToBuffer("]")
		return false
	}

	@Override override boolean visit(ArrayType node) {
		if (!java8orHigher) {
			node.getComponentType().accept(this)
			appendToBuffer("[]")
		} else {
			// Java8 and higher
			node.genericChildProperty("elementType")?.accept(this)
			var dimensions = node.genericChildListProperty("dimensions")
			if (!dimensions.nullOrEmpty) {
				dimensions.forEach [ dim |
					dim.genericChildListProperty("annotations")?.visitAll
					appendToBuffer("[]")
				]
			}
		}
		return false
	}

	@Override override boolean visit(AssertStatement node) {
		appendToBuffer("if(!(")
		node.getExpression().accept(this)
		appendToBuffer(")) {")
		appendToBuffer("throw new AssertionError(")
		if (node.getMessage() != null) {
			node.getMessage().accept(this)
		}
		appendToBuffer(")}")
		return false
	}

	@Override override boolean visit(BreakStatement node) {
		appendToBuffer('''/* FIXME Unsupported BreakStatement */ break''')
		node.addProblem("Break statement is not supported")
		if (node.getLabel() != null) {
			appendSpaceToBuffer
			node.getLabel().accept(this)
		}
		return false
	}

	@Override override boolean visit(CatchClause node) {
		if (node.exception.type.nodeType === 84) {
			// Java7 multi catch
			node.exception.type.genericChildListProperty("types")?.forEach [ child, index |
				appendToBuffer(" catch (")
				child.accept(this)
				appendSpaceToBuffer
				appendToBuffer(node.exception.name.toSimpleName)
				appendToBuffer(") ")
				node.body.accept(this)
			]
		} else {
			appendToBuffer(" catch (")
			node.getException().accept(this)
			appendToBuffer(") ")
			node.getBody().accept(this)
		}
		return false
	}

	@Override override boolean visit(ConstructorInvocation node) {
		if (!node.typeArguments().isEmpty()) {
			appendTypeParameters(node.typeArguments())
		}
		appendToBuffer("this(")
		node.arguments().visitAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(ContinueStatement node) {
		appendToBuffer("/* FIXME Unsupported continue statement */ continue")
		node.addProblem("Continue statement is not supported")
		if (node.getLabel() != null) {
			appendSpaceToBuffer
			node.getLabel().accept(this)
		}
		appendToBuffer(";")
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
		appendModifiers(node, node.modifiers())
		node.getName().accept(this)
		if (!node.arguments().isEmpty()) {
			node.addProblem("Enum constant cannot have any arguments")
			appendToBuffer("(")
			visitAllSeparatedByComma(node.arguments())
			appendToBuffer(")")
		}
		if (node.getAnonymousClassDeclaration() != null) {
			node.addProblem("Enum constant cannot have any anonymous class declarations")
			node.getAnonymousClassDeclaration().accept(this)
		}
		return false
	}

	@Override override boolean visit(EnumDeclaration node) {
		if (node.getJavadoc() != null) {
			node.getJavadoc().accept(this)
		}
		appendModifiers(node, node.modifiers())
		if (node.modifiers().filter(Modifier).isPackageVisibility()) {
			appendToBuffer('package ')
		}
		appendToBuffer("enum ")
		node.getName().accept(this)
		appendSpaceToBuffer
		if (!node.superInterfaceTypes().isEmpty()) {
			node.addProblem("Enum cannot have a supertype")
			appendToBuffer("implements ")
			node.superInterfaceTypes().visitAllSeparatedByComma
			appendSpaceToBuffer
		}
		appendToBuffer("{")
		increaseIndent
		appendLineWrapToBuffer
		node.enumConstants().visitAllSeparatedByComma

		if (!node.bodyDeclarations().isEmpty()) {
			node.addProblem("Enum cannot have any body declaration statements")
			appendToBuffer(";")
			appendLineWrapToBuffer
			node.bodyDeclarations().visitAll
		}
		decreaseIndent
		appendToBuffer("}")
		return false
	}

	@Override override boolean visit(LabeledStatement node) {
		node.addProblem("LabeledStatements are not supported")
		appendToBuffer("/*")
		node.getLabel().accept(this)
		appendToBuffer(": */")
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
		node.parameters().visitAllSeparatedByComma
		appendToBuffer(")")
		return false
	}

	@Override override boolean visit(MethodRefParameter node) {
		node.getType().accept(this)
		if (node.isVarargs()) {
			appendToBuffer("...")
		}
		if (node.getName() != null) {
			appendSpaceToBuffer
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
		appendLineWrapToBuffer
		if (node.isDefault()) {
			appendToBuffer("default ")
		} else {
			appendToBuffer("case ")
			node.getExpression().accept(this)
		}
		return false
	}

	@Override override boolean visit(SwitchStatement node) {
		appendLineWrapToBuffer
		appendToBuffer("switch (")
		node.getExpression().accept(this)
		appendToBuffer(") ")
		appendToBuffer("{")
		increaseIndent
		val foldedCases = node.statements.fold(
			newLinkedHashMap, [ Map<SwitchCase, ArrayList<Statement>> map, Statement currStatement |
				if (currStatement instanceof SwitchCase) {
					map.put(currStatement, newArrayList)
				} else {
					map.get(map.keySet.last).add(currStatement)
				}
				return map
			])
		foldedCases.forEach [ switchCase, statements |
			switchCase.accept(this)
			val isLastCase = switchCase.equals(foldedCases.keySet.last)

			if (statements.empty && !isLastCase) { // fall-through
				appendToBuffer(',')
			} else {
				appendToBuffer(':')
				val probablyReturns = (statements.last instanceof ReturnStatement) ||
					(statements.last instanceof Block) &&
						((statements.last as Block).statements.last instanceof ReturnStatement)
				if (!isLastCase && !(probablyReturns)) {
							appendToBuffer('''/* FIXME unsupported fall-through */''')
							node.addProblem("Unsupported fall-through case in switch expression")
						}
					}

			val surround = (isLastCase && statements.empty) ||
				(!statements.empty && !(statements.get(0) instanceof Block))

			if (surround) {
				appendToBuffer("{")
				increaseIndent
				appendLineWrapToBuffer
			}
			statements.visitAll
			if (surround) {
				decreaseIndent
				appendLineWrapToBuffer
				appendToBuffer("}")
			}

		]
		decreaseIndent
		appendLineWrapToBuffer
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
			appendToBuffer('''/*FIXME Non-static inner classes are not supported. */''')
			node.addProblem("Non-static inner classes are not supported.")
		}
		node.getDeclaration().accept(this)
		return false
	}

	override preVisit(ASTNode node) {
		if (node instanceof Comment || node instanceof TagElement || node instanceof TextElement) {
			return
		}
		if (node.root instanceof CompilationUnit) {
			val cu = node.root as CompilationUnit
			cu.unAssignedComments.filter [
				startPosition < node.startPosition
			].forEach [
				accept(this)
				assignedComments.add(it)
			]
		}
	}

	override preVisit2(ASTNode node) {
		if (node.nodeType === 86) {
			// Java8 Lambda
			preVisit(node)
			handleLambdaExpression(node)
			return false
		}
		return super.preVisit2(node)
	}

	def handleLambdaExpression(ASTNode node) {
		appendToBuffer('[')
		val params = node.genericChildListProperty("parameters")
		if (!params.nullOrEmpty) {
			params.visitAllSeparatedByComma
			appendToBuffer(" | ")
		}
		node.genericChildProperty("body")?.accept(this)
		appendToBuffer(']')
		return false
	}

	def setJavaSources(String javaSources) {
		this.javaSources = javaSources
	}

	/**
	 * @param fallBackStrategy - if <code>true</code> ASTFlattener uses a strategy which is less error prone,<br>
	 *  but in fact may produces more noisy syntax.
	 */
	def useFallBackStrategy(boolean fallBackStrategy) {
		this.fallBackStrategy = fallBackStrategy
	}

	def setTargetlevel(String targetApiLevel) {
		this.targetApiLevel = targetApiLevel
	}

}
