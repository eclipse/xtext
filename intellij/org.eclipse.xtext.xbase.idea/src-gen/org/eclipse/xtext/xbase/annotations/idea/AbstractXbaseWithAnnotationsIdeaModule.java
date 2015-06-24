package org.eclipse.xtext.xbase.annotations.idea;

public class AbstractXbaseWithAnnotationsIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.antlr.XbaseWithAnnotationsAntlrTokenFileProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.eclipse.xtext.xbase.annotations.idea.parser.antlr.internal.PsiInternalXbaseWithAnnotationsLexer.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.eclipse.xtext.xbase.annotations.idea.parser.antlr.internal.PsiInternalXbaseWithAnnotationsLexer.class);
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsPsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsElementTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return org.eclipse.xtext.xbase.idea.types.StubBasedTypeScopeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex> bindJvmDeclaredTypeShortNameIndex() {
		return org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider> bindJavaTypeHierarchyProvider() {
		return org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmDeclaredTypeHierarchyProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends com.intellij.ide.hierarchy.call.JavaCallHierarchyProvider> bindJavaCallHierarchyProvider() {
		return org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallHierarchyProvider.class;
	}
	
	
}
