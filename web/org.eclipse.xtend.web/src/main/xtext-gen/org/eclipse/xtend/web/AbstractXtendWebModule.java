/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.web;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.ide.common.contentassist.antlr.XtendParser;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendLexer;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.xbase.web.DefaultXbaseWebModule;

/**
 * Manual modifications go to {@link XtendWebModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractXtendWebModule extends DefaultXbaseWebModule {

	public AbstractXtendWebModule(Provider<ExecutorService> executorServiceProvider) {
		super(executorServiceProvider);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer.class).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(InternalXtendLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return XtendParser.class;
	}
	
}
