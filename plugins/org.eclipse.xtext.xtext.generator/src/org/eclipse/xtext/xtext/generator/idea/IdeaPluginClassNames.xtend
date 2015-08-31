/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.idea

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

class IdeaPluginClassNames {
	@Inject extension XtextGeneratorNaming

	def String toPath(String fullName) {
		fullName.replace('.', '/')
	}

	def TypeReference getIdeaSetup(Grammar it) {
		new TypeReference(ideaBasePackage, simpleName + 'IdeaSetup')
	}

	def TypeReference getExtensionFactory(Grammar it) {
		new TypeReference(ideaBasePackage, simpleName + 'ExtensionFactory')
	}

	def TypeReference getAbstractIdeaModule(Grammar it) {
		new TypeReference(ideaBasePackage, 'Abstract' + simpleName + 'IdeaModule')
	}
	
	def TypeReference getFileType(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang', simpleName + 'FileType')
	}

	def TypeReference getAbstractFileType(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang', 'Abstract' + simpleName + 'FileType')
	}

	def TypeReference getFileTypeFactory(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang', simpleName + 'FileTypeFactory')
	}

	def TypeReference getIdeaLanguage(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang', simpleName + 'Language')
	}

	def TypeReference getCodeBlockModificationListener(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang.psi', simpleName + 'CodeBlockModificationListener')
	}

	def TypeReference getPsiParser(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang.parser', simpleName + 'PsiParser')
	}

	def TypeReference getAntlrTokenFileProvider(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang.parser.antlr', simpleName + 'AntlrTokenFileProvider')
	}

	def TypeReference getPomDeclarationSearcher(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang.pom', simpleName + 'PomDeclarationSearcher')
	}

	def TypeReference getSyntaxHighlighterFactory(Grammar it) {
		new TypeReference(ideaBasePackage + '.highlighting', simpleName + 'SyntaxHighlighterFactory')
	}

	def TypeReference getSemanticHighlightVisitor(Grammar it) {
		new TypeReference(ideaBasePackage + '.highlighting', simpleName + 'SemanticHighlightVisitor')
	}

	def TypeReference getSuperParserDefinition(Grammar it) {
		'org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition'.typeRef
	}

	def TypeReference getParserDefinition(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang.parser', simpleName + 'ParserDefinition')
	}

	def TypeReference getTokenTypeProvider(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang.parser', simpleName + 'TokenTypeProvider')
	}

	def TypeReference getElementTypeProvider(Grammar it) {
		new TypeReference(ideaBasePackage + '.lang', simpleName + 'ElementTypeProvider')
	}

	def TypeReference getPsiInternalLexer(Grammar it) {
		new TypeReference(ideaBasePackage + '.parser.antlr.internal', 'PsiInternal' + simpleName + 'Lexer')
	}

	def TypeReference getPsiInternalParser(Grammar it) {
		new TypeReference(ideaBasePackage + '.parser.antlr.internal', 'PsiInternal' + simpleName + 'Parser')
	}

	def String getTokens(Grammar it) {
		(ideaBasePackage + '.parser.antlr.internal.PsiInternal' + simpleName).toPath + '.tokens'
	}

	def TypeReference getFileImpl(Grammar it) {
		new TypeReference(psiImplPackageName, simpleName + 'FileImpl')
	}

	def String getPsiPackageName(Grammar it) {
		ideaBasePackage + '.lang.psi'
	}

	def String getPsiImplPackageName(Grammar it) {
		ideaBasePackage + '.lang.psi.impl'
	}

	def TypeReference getInternalParser(Grammar it) {
		new TypeReference(namespace + '.parser.antlr.internal', 'Internal' + simpleName + 'Parser')
	}

	def TypeReference getAntlrLexer(Grammar it) {
		new TypeReference(namespace + '.parser.antlr.internal', 'Internal' + simpleName + 'Lexer')
	}

	def TypeReference getCompletionContributorSuperClass(Grammar it) {
		usedGrammars.head?.completionContributor ?:
			'org.eclipse.xtext.idea.completion.AbstractCompletionContributor'.typeRef
	}

	def TypeReference getCompletionContributor(Grammar it) {
		new TypeReference(ideaBasePackage + '.completion', simpleName + 'CompletionContributor')
	}

	def TypeReference getAbstractCompletionContributor(Grammar it) {
		new TypeReference(ideaBasePackage + '.completion', 'Abstract' + simpleName + 'CompletionContributor')
	}

	def TypeReference getFacetConfiguration(Grammar it) {
		new TypeReference(ideaBasePackage + '.facet', simpleName + 'FacetConfiguration')
	}

	def TypeReference getFacetType(Grammar it) {
		new TypeReference(ideaBasePackage + '.facet', simpleName + 'FacetType')
	}

	def TypeReference baseColorSettingsPage(Grammar it) {
		new TypeReference(ideaBasePackage + '.highlighting', simpleName + 'BaseColorSettingsPage')
	}

	def TypeReference colorSettingsPage(Grammar it) {
		new TypeReference(baseColorSettingsPage.packageName, simpleName + 'ColorSettingsPage')
	}
}
