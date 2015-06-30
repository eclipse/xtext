package org.eclipse.xtext.parsetree.unassignedtext.idea;

public class AbstractUnassignedTextTestLanguageIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.lang.parser.antlr.UnassignedTextTestLanguageAntlrTokenFileProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.parser.antlr.internal.PsiInternalUnassignedTextTestLanguageLexer.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.eclipse.xtext.parsetree.unassignedtext.idea.parser.antlr.internal.PsiInternalUnassignedTextTestLanguageLexer.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.lang.parser.UnassignedTextTestLanguagePsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.lang.parser.UnassignedTextTestLanguageTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.lang.parser.UnassignedTextTestLanguageParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetConfiguration<? extends org.eclipse.xtext.idea.facet.GeneratorConfigurationState>> bindAbstractFacetConfiguration$GeneratorConfigurationState() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.facet.UnassignedTextTestLanguageFacetConfiguration.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetType<org.eclipse.xtext.parsetree.unassignedtext.idea.facet.UnassignedTextTestLanguageFacetConfiguration>> bindAbstractFacetType$UnassignedTextTestLanguageFacetConfiguration() {
		return org.eclipse.xtext.parsetree.unassignedtext.idea.facet.UnassignedTextTestLanguageFacetType.class;
	}
	
	
}
