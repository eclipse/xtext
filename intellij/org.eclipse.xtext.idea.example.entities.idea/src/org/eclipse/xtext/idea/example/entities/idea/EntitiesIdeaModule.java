/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea;

import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.EntitiesParser;

public class EntitiesIdeaModule extends AbstractEntitiesIdeaModule {

	public Class<? extends IContentAssistParser> bindContentAssistParser() {
		return EntitiesParser.class;
	}
	
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.internal.InternalEntitiesLexer.class)
			.toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.internal.InternalEntitiesLexer.class));
	}

	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer.class)
			.annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST))
			.to(org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.internal.InternalEntitiesLexer.class);
	}

}
