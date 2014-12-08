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
		return fullName.replace('.','/')+'.java'
	}
	
	def String toXtendPath(String fullName) {
		return fullName.replace('.','/')+'.xtend'
	}
	
	def getBasePackageName(Grammar grammar) {
		grammar.name.toPackageName+".idea"
	}
	
	def String getIdeaModuleName(Grammar it) {
		basePackageName+'.'+it.name.toSimpleName+'IdeaModule'
	}
	
	def String getStandaloneSetupIdea(Grammar it) {
		basePackageName+'.'+it.name.toSimpleName+'StandaloneSetupIdea'
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
	
	def String getFileTypeFactoryName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'FileTypeFactory'
	}
	
	def String getLanguageName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'Language'
	}
	
	def String buildProcessParametersProviderName(Grammar it) {
		basePackageName+'.server.'+it.name.toSimpleName+'BuildProcessParametersProvider'
	}
	
	def String getJvmTypesElementFinderName(Grammar it) {
		basePackageName+'.lang.types.psi.'+it.name.toSimpleName+'JvmTypesElementFinder'
	}
	
	def String getJvmTypesShortNamesCacheName(Grammar it) {
		basePackageName+'.lang.types.'+it.name.toSimpleName+'JvmTypesShortNamesCache'
	}
	
	def String getJvmElementsReferencesSearch(Grammar it) {
		basePackageName+'.lang.types.psi.search.'+it.name.toSimpleName+ 'JvmElementsReferencesSearch'
	}
	
	def String getCodeBlockModificationListenerName(Grammar it) {
		basePackageName+'.lang.psi.'+it.name.toSimpleName+'CodeBlockModificationListener'
	}
	
	def String getElementDescriptionProviderName(Grammar it) {
		basePackageName+'.lang.psi.'+it.name.toSimpleName+'ElementDescriptionProvider'
	}
	
	def String getPsiParserName(Grammar it) {
		basePackageName+'.lang.parser.'+it.name.toSimpleName+'PsiParser'
	}
	
	def String getPomDeclarationSearcherName(Grammar it) {
		basePackageName+'.lang.pom.'+it.name.toSimpleName+'PomDeclarationSearcher'
	}
	
	def String getSyntaxHighlighterFactoryName(Grammar it) {
		basePackageName+'.lang.'+it.name.toSimpleName+'SyntaxHighlighterFactory'
	}
	
	def String getSuperParserDefinitionName(Grammar it) {
		usedGrammars.head?.parserDefinitionName ?: 'org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition'
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
	
	def String getCompletionContributor(Grammar it) {
		basePackageName +'.completion.'+ name.toSimpleName+'CompletionContributor'
	}
}