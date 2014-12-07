package org.eclipse.xtend.core.idea;

import org.eclipse.xtend.ide.common.contentassist.antlr.DisabledInternalLexer;
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistContextFactory;
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistParser;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendLexer;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.idea.ide.hierarchy.JvmDeclaredTypeHierarchyProvider;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.service.SingletonBinding;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.intellij.ide.hierarchy.type.JavaTypeHierarchyProvider;

public class XtendIdeaModule extends AbstractXtendIdeaModule {

	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return FlexerBasedContentAssistParser.class;
	}
	
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(InternalXtendLexer.class).toProvider(LexerProvider.create(DisabledInternalLexer.class));
		binder.bind(DisabledInternalLexer.class).toProvider(LexerProvider.create(DisabledInternalLexer.class));
	}

	public void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer.class).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(DisabledInternalLexer.class);
	}
	
	public Class<? extends ContentAssistContextFactory> bindContentAssistContextFactory() {
		return FlexerBasedContentAssistContextFactory.class;
	}
	
	@SingletonBinding
	public Class<? extends JavaTypeHierarchyProvider> bindJavaTypeHierarchyProvider() {
		return JvmDeclaredTypeHierarchyProvider.class;
	}
}
