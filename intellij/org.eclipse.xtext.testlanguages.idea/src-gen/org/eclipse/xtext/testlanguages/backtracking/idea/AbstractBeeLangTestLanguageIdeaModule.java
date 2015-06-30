package org.eclipse.xtext.testlanguages.backtracking.idea;

public class AbstractBeeLangTestLanguageIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.antlr.BeeLangTestLanguageAntlrTokenFileProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal.PsiInternalBeeLangTestLanguageLexer.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal.PsiInternalBeeLangTestLanguageLexer.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.BeeLangTestLanguagePsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.BeeLangTestLanguageTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.lang.parser.BeeLangTestLanguageParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetConfiguration<? extends org.eclipse.xtext.idea.facet.GeneratorConfigurationState>> bindAbstractFacetConfiguration$GeneratorConfigurationState() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.facet.BeeLangTestLanguageFacetConfiguration.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetType<org.eclipse.xtext.testlanguages.backtracking.idea.facet.BeeLangTestLanguageFacetConfiguration>> bindAbstractFacetType$BeeLangTestLanguageFacetConfiguration() {
		return org.eclipse.xtext.testlanguages.backtracking.idea.facet.BeeLangTestLanguageFacetType.class;
	}
	
	
}
