/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.util.Strings

class IdeaPluginClassNames {
	
	def String toSimpleName(String name) {
		return Strings.lastToken(name, ".");
	}

	def String toPackageName(String name) {
		return Strings.skipLastToken(name, ".");
	}
	
	def String toJavaPath(String fullName) {
		return fullName.toPath + '.java'
	}
	
	def String toXtendPath(String fullName) {
		return fullName.toPath + '.xtend'
	}
	
	def String toPath(String fullName) {
		fullName.replace('.','/')
	}
	
	def getBasePackageName(Grammar grammar) {
		grammar.name.toPackageName+".idea"
	}
	
	def String getIdeaModuleName(Grammar it) {
		basePackageName+'.'+it.name.toSimpleName+'IdeaModule'
	}
	
	def String getStandaloneSetup(Grammar it) {
		name.toPackageName+'.'+it.name.toSimpleName+'StandaloneSetup'
	}
	
	def String getStandaloneSetupIdea(Grammar it) {
		basePackageName+'.'+it.name.toSimpleName+'StandaloneSetupIdea'
	}
	
	def String getIdeaSetup(Grammar it) {
		basePackageName+'.'+it.name.toSimpleName+'IdeaSetup'
	}
	
	def String getExtensionFactoryName(Grammar it) {
		basePackageName+'.'+it.name.toSimpleName+'ExtensionFactory'
	}
	
	def String getAbstractIdeaModuleName(Grammar it) {
		basePackageName+'.Abstract'+it.name.toSimpleName+'IdeaModule'
	}
	
	def String getFileTypeName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'FileType'
	}
	
	def String getAbstractFileTypeName(Grammar it) {
		basePackageName+'.lang.Abstract'+it.name.toSimpleName+'FileType'
	}
	
	def String getFileTypeFactoryName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'FileTypeFactory'
	}
	
	def String getLanguageName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'Language'
	}
	
	def String getCodeBlockModificationListenerName(Grammar it) {
		basePackageName+'.lang.psi.'+it.name.toSimpleName+'CodeBlockModificationListener'
	}
	
	def String getPsiParserName(Grammar it) {
		basePackageName+'.lang.parser.'+it.name.toSimpleName+'PsiParser'
	}
	
	def String getAntlrTokenFileProvider(Grammar it) {
		basePackageName+'.lang.parser.antlr.'+it.name.toSimpleName+'AntlrTokenFileProvider'
	}
	
	def String getPomDeclarationSearcherName(Grammar it) {
		basePackageName+'.lang.pom.'+it.name.toSimpleName+'PomDeclarationSearcher'
	}
	
	def String getSyntaxHighlighterFactoryName(Grammar it) {
		basePackageName+'.highlighting.'+it.name.toSimpleName+'SyntaxHighlighterFactory'
	}
	
	def String getSemanticHighlightVisitorName(Grammar it) {
		basePackageName+'.highlighting.'+it.name.toSimpleName+'SemanticHighlightVisitor'
	}
	
	def String getSuperParserDefinitionName(Grammar it) {
		'org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition'
	}
	
	def String getParserDefinitionName(Grammar it) {
		basePackageName+'.lang.parser.'+it.name.toSimpleName+'ParserDefinition'
	}
	
	def String getTokenTypeProviderName(Grammar it) {
		basePackageName+'.lang.parser.'+it.name.toSimpleName+'TokenTypeProvider'
	}
	
	def String getElementTypeProviderName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'ElementTypeProvider'
	}
	
	def String getGrammarAccessName(Grammar it) {
		name.toPackageName+'.services.'+it.name.toSimpleName+'GrammarAccess'
	}

	def String getPsiInternalLexerName(Grammar it) {
		basePackageName+'.parser.antlr.internal.PsiInternal'+it.name.toSimpleName+'Lexer'
	}
	
	def String getPsiInternalParserName(Grammar it) {
		basePackageName+'.parser.antlr.internal.PsiInternal'+it.name.toSimpleName+'Parser'
	}
	
	def String getTokens(Grammar it) {
		(basePackageName + '.parser.antlr.internal.PsiInternal' + it.name.toSimpleName).toPath + '.tokens'
	}
	
	def String getFileImplName(Grammar it) {
		psiImplPackageName+'.'+it.name.toSimpleName+'FileImpl'
	}
	
	def String getPsiPackageName(Grammar it) {
		basePackageName+'.lang.psi'
	}
	
	def String getPsiImplPackageName(Grammar it) {
		basePackageName+'.lang.psi.impl'
	}
	
	def String getInternalParserName(Grammar it) {
		it.name.toPackageName+'.parser.antlr.internal.Internal'+it.name.toSimpleName+'Parser'
	}
	
	def String getAntlrLexerName(Grammar it) {
		it.name.toPackageName+'.parser.antlr.internal.Internal'+it.name.toSimpleName+'Lexer'
	}
	
	def String getCompletionContributorSuperClass(Grammar it) {
		usedGrammars.head?.completionContributor ?: 'org.eclipse.xtext.idea.completion.AbstractCompletionContributor'
	}
	
	def String getCompletionContributor(Grammar it) {
		basePackageName +'.completion.'+ name.toSimpleName+'CompletionContributor'
	}
	
	def String getAbstractCompletionContributor(Grammar it) {
		basePackageName +'.completion.Abstract'+ name.toSimpleName+'CompletionContributor'
	}
	
	def String getFacetConfiguration(Grammar it) {
		basePackageName+'.facet.'+it.name.toSimpleName+'FacetConfiguration'
	}
	
	def String getFacetTypeName(Grammar it) {
		basePackageName+'.facet.'+it.name.toSimpleName+'FacetType'
	}
	
	def String baseColorSettingsPage(Grammar it) {
		basePackageName+'.highlighting.'+it.name.toSimpleName+'BaseColorSettingsPage'
	}
	
	def String colorSettingsPage(Grammar it) {
		baseColorSettingsPage.toPackageName+'.'+it.name.toSimpleName+'ColorSettingsPage'
	}
}