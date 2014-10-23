package org.xtext.idea.sdomain.idea;

public class AbstractSDomainIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.openapi.fileTypes.SyntaxHighlighter> bindSyntaxHighlighter() {
		return org.xtext.idea.sdomain.idea.lang.SDomainSyntaxHighlighter.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lexer.Lexer> bindLexer() {
		return org.xtext.idea.sdomain.idea.lang.parser.SDomainLexer.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.xtext.idea.sdomain.idea.lang.parser.SDomainPsiParser.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.xtext.idea.sdomain.idea.lang.parser.SDomainTokenTypeProvider.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.xtext.idea.sdomain.idea.lang.parser.SDomainParserDefinition.class;
	}
	// contributed by org.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider.class;
	}
	
	
}
