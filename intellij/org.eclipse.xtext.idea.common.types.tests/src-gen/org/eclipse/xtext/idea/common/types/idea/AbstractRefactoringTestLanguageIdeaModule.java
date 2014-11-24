package org.eclipse.xtext.idea.common.types.idea;

public class AbstractRefactoringTestLanguageIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.idea.common.types.idea.lang.parser.RefactoringTestLanguagePsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.idea.common.types.idea.lang.parser.RefactoringTestLanguageTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.idea.common.types.idea.lang.parser.RefactoringTestLanguageParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return org.eclipse.xtext.idea.types.access.StubTypeProviderFactory.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return org.eclipse.xtext.idea.types.StubBasedTypeScopeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator> bindJvmModelAssociator() {
		return org.eclipse.xtext.idea.jvmmodel.PsiJvmModelAssociator.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex> bindJvmDeclaredTypeShortNameIndex() {
		return org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider.class;
	}
	
	
}
