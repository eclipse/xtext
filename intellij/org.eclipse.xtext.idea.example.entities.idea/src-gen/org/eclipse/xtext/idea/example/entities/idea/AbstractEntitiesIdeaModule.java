package org.eclipse.xtext.idea.example.entities.idea;

public class AbstractEntitiesIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.idea.example.entities.idea.lang.parser.antlr.EntitiesAntlrTokenFileProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.idea.example.entities.idea.parser.antlr.internal.PsiInternalEntitiesLexer.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.eclipse.xtext.idea.example.entities.idea.parser.antlr.internal.PsiInternalEntitiesLexer.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.idea.example.entities.idea.lang.parser.EntitiesPsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.idea.example.entities.idea.lang.parser.EntitiesTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.idea.example.entities.idea.lang.parser.EntitiesParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.facet.AbstractFacetConfiguration> bindAbstractFacetConfiguration() {
		return org.eclipse.xtext.idea.example.entities.idea.facet.EntitiesFacetConfiguration.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public com.intellij.facet.FacetTypeId bindFacetTypeIdToInstance() {
		return org.eclipse.xtext.idea.example.entities.idea.facet.EntitiesFacetType.TYPEID;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return org.eclipse.xtext.idea.common.types.StubBasedTypeScopeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureLanguageSpecificPsiModelAssociations(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.psi.IPsiModelAssociations.class).annotatedWith(org.eclipse.xtext.service.LanguageSpecific.class).to(org.eclipse.xtext.idea.common.types.DerivedMemberAwarePsiModelAssociations.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.formatting.BlockFactory> bindBlockFactory() {
		return org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.formatting.ChildAttributesProvider> bindChildAttributesProvider() {
		return org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider> bindIBracePairProvider() {
		return org.eclipse.xtext.xbase.idea.bracketmatching.XbaseBracePairProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.findusages.IReferenceSearcher> bindIReferenceSearcher() {
		return org.eclipse.xtext.idea.findusages.JvmElementAwareReferenceSearcher.class;
	}
	
	
}
