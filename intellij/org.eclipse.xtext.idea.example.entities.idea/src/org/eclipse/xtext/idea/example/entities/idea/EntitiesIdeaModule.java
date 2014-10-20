package org.eclipse.xtext.idea.example.entities.idea;

import org.eclipse.xtext.idea.example.entities.ui.contentassist.antlr.EntitiesParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;

public class EntitiesIdeaModule extends AbstractEntitiesIdeaModule {

	public Class<? extends IContentAssistParser> bindContentAssistParser() {
		return EntitiesParser.class;
	}
	
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.idea.example.entities.ui.contentassist.antlr.internal.InternalEntitiesLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.eclipse.xtext.idea.example.entities.ui.contentassist.antlr.internal.InternalEntitiesLexer.class));
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(org.eclipse.xtext.idea.example.entities.ui.contentassist.antlr.internal.InternalEntitiesLexer.class);
	}
}