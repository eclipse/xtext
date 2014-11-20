package org.eclipse.xtext.idea.sdomain.idea;

public class AbstractSDomainIdeaModule extends org.eclipse.xtext.idea.DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.openapi.fileTypes.SyntaxHighlighter> bindSyntaxHighlighter() {
		return org.eclipse.xtext.idea.sdomain.idea.lang.SDomainSyntaxHighlighter.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.PsiParser> bindPsiParser() {
		return org.eclipse.xtext.idea.sdomain.idea.lang.parser.SDomainPsiParser.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends org.eclipse.xtext.idea.parser.TokenTypeProvider> bindTokenTypeProvider() {
		return org.eclipse.xtext.idea.sdomain.idea.lang.parser.SDomainTokenTypeProvider.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	public Class<? extends com.intellij.lang.ParserDefinition> bindParserDefinition() {
		return org.eclipse.xtext.idea.sdomain.idea.lang.parser.SDomainParserDefinition.class;
	}
	// contributed by org.eclipse.xtext.idea.generator.IdeaPluginGenerator
	@org.eclipse.xtext.service.SingletonBinding
	public Class<? extends org.eclipse.xtext.idea.lang.IElementTypeProvider> bindIElementTypeProvider() {
		return org.eclipse.xtext.idea.sdomain.idea.lang.SDomainElementTypeProvider.class;
	}
	
	
}
