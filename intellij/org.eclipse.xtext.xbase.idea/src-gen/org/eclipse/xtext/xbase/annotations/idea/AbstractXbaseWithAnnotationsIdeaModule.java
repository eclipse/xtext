package org.eclipse.xtext.xbase.annotations.idea;

public class AbstractXbaseWithAnnotationsIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.openapi.fileTypes.SyntaxHighlighter> bindSyntaxHighlighter() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsSyntaxHighlighter.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lexer.Lexer> bindLexer() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsLexer.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsPsiParser.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsTokenTypeProvider.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.parser.XbaseWithAnnotationsParserDefinition.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsElementTypeProvider.class;
	}
	
	
}
