/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.lang.ASTFactory
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiBuilderFactory
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.TokenType
import com.intellij.psi.impl.source.DummyHolderFactory
import com.intellij.psi.impl.source.tree.RecursiveTreeElementVisitor
import com.intellij.psi.impl.source.tree.TreeElement
import com.intellij.util.IncorrectOperationException
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.parser.antlr.TokenSourceProvider
import org.eclipse.xtext.psi.PsiEObjectFactory
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

import static org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY

import static extension com.intellij.psi.impl.source.codeStyle.CodeEditUtil.*
import static extension java.util.regex.Pattern.*
import static extension org.eclipse.xtext.parser.antlr.TokenTool.*

@Singleton
class PsiEObjectFactoryImpl implements PsiEObjectFactory {

	@Inject
	extension ParserDefinition parserDefinition

	@Inject
	extension ITokenDefProvider tokenDefProvider

	@Inject
	extension TokenSourceProvider tokenSourceProvider
	
	override createLeafIdentifier(String name, ASTNode context) {
		name.assertToken(context.elementType as IGrammarAwareElementType)
		ASTFactory.leaf(context.elementType, name) => [
			nodeGenerated = true
		]
	}
	
	override createCompositeIdentifier(String name, String currentName, extension ASTNode context) {
		val builder = name.createNameBuilder(currentName, context)
		val contentElement = psi.project.createParser.parse(elementType, builder) as TreeElement => [
			assertNode
			nodeGeneratedRecursively = true
		]
		DummyHolderFactory.createHolder(context.psi.manager, contentElement, psi.context).treeElement
	}

	protected def createNameBuilder(String name, String currentName, ASTNode context) {
		val text = context.text.replaceFirst(currentName.quote, name)
		PsiBuilderFactory.instance.createBuilder(parserDefinition, context.psi.project.createLexer, text) => [
			putUserData(LOOK_AHEAD_KEY, context.getUserData(LOOK_AHEAD_KEY))
		]
	}

	def protected void assertNode(TreeElement treeElement) {
		treeElement.acceptTree([ TreeElement element |
			if (element.elementType == TokenType.ERROR_ELEMENT) {
				val errorElement = element as PsiErrorElement
				throw new IncorrectOperationException(errorElement.errorDescription)
			}
			true
		] as RecursiveTreeElementVisitor)
	}

	def protected void assertToken(String name, IGrammarAwareElementType elementType) {
		val ruleName = elementType.grammarElement.ruleName
		val tokenSource = name.createTokenSource
		var token = tokenSource.nextToken
		if (name != token.text) {
			throw new IncorrectOperationException('''The value '«name»' is an invalid «ruleName»''')
		}

		val lexerRuleName = tokenDefMap.get(token.type).lexerRuleName
		if (ruleName != lexerRuleName) {
			throw new IncorrectOperationException('''The value '«name»' is an invalid «ruleName»''')
		}
	}
	
	protected def dispatch String getRuleName(Void it) {
		throw new IllegalStateException("Unexpected grammar element: "+ it)
	}
	
	protected def dispatch String getRuleName(EObject it) {
		throw new IllegalStateException("Unexpected grammar element: "+ it)
	}
	
	protected def dispatch String getRuleName(RuleCall it) {
		rule.name
	}
	
	protected def dispatch String getRuleName(CrossReference it) {
		terminal.ruleName
	}
	
}