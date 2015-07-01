package org.eclipse.xtext.parser.antlr.idea;

public class AbstractBug289515TestLanguageIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.parser.antlr.idea.lang.parser.antlr.Bug289515TestLanguageAntlrTokenFileProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug289515TestLanguageLexer.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.eclipse.xtext.parser.antlr.idea.parser.antlr.internal.PsiInternalBug289515TestLanguageLexer.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.parser.antlr.idea.lang.parser.Bug289515TestLanguagePsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.parser.antlr.idea.lang.parser.Bug289515TestLanguageTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.parser.antlr.idea.lang.parser.Bug289515TestLanguageParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetConfiguration> bindAbstractFacetConfiguration() {
		return org.eclipse.xtext.parser.antlr.idea.facet.Bug289515TestLanguageFacetConfiguration.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public com.intellij.facet.FacetTypeId bindFacetTypeIdToInstance() {
		return org.eclipse.xtext.parser.antlr.idea.facet.Bug289515TestLanguageFacetType.TYPEID;
	}
	
	
}
