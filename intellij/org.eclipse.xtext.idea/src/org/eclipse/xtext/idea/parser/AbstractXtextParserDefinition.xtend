/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser

import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.lang.LanguageUtil
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import javax.inject.Provider
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.idea.lang.IElementTypeProvider
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.jetbrains.annotations.NotNull
import org.eclipse.xtext.psi.impl.PsiEObjectReference
import org.eclipse.xtext.psi.impl.PsiEObjectImpl

abstract class AbstractXtextParserDefinition implements ParserDefinition {
	
	@Inject
	private Provider<Lexer> lexerProvider; 
	
	@Inject
	private TokenTypeProvider tokenTypeProvider;
	
	@Inject
	private Provider<PsiParser> psiParserProvider;

	@Inject
	@Accessors(PROTECTED_GETTER)
	private IElementTypeProvider elementTypeProvider;
	
	@NotNull
	override Lexer createLexer(Project project) {
		return lexerProvider.get();
	}

	override IFileElementType getFileNodeType() {
		return elementTypeProvider.getFileType();
	}

	@NotNull
	override TokenSet getWhitespaceTokens() {
		return TokenSet.EMPTY;
	}

	@NotNull
	override TokenSet getCommentTokens() {
		return TokenSet.EMPTY;
	}

	@NotNull
	override TokenSet getStringLiteralElements() {
		return tokenTypeProvider.getStringLiteralTokens();
	}

	@NotNull
	override PsiParser createParser(Project project) {
		return psiParserProvider.get();
	}

	override SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
		return LanguageUtil.canStickTokensTogetherByLexer(left, right, lexerProvider.get)
	}
	
	override createElement(ASTNode node) {
		if (node.elementType.crossReference) {
			new PsiEObjectReference(node)
		} else {
			new PsiEObjectImpl(node)
		}
	}
	
	def protected boolean isCrossReference(IElementType type){
		if (type instanceof IGrammarAwareElementType) {
			type.grammarElement instanceof CrossReference 
		} else {
			false
		}
	}

}