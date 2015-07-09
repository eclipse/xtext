package org.eclipse.xtext.generator.ecore.idea;

public class AbstractEcoreFragmentTestLanguageIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.generator.ecore.idea.lang.parser.antlr.EcoreFragmentTestLanguageAntlrTokenFileProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal.PsiInternalEcoreFragmentTestLanguageLexer.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal.PsiInternalEcoreFragmentTestLanguageLexer.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.generator.ecore.idea.lang.parser.EcoreFragmentTestLanguagePsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.generator.ecore.idea.lang.parser.EcoreFragmentTestLanguageTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.generator.ecore.idea.lang.parser.EcoreFragmentTestLanguageParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetConfiguration> bindAbstractFacetConfiguration() {
		return org.eclipse.xtext.generator.ecore.idea.facet.EcoreFragmentTestLanguageFacetConfiguration.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public com.intellij.facet.FacetTypeId bindFacetTypeIdToInstance() {
		return org.eclipse.xtext.generator.ecore.idea.facet.EcoreFragmentTestLanguageFacetType.TYPEID;
	}
	
	
}
