/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage

import com.google.inject.Binder
import com.google.inject.name.Names
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.TestLanguageParser
import org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal.InternalTestLanguageLexer
import org.eclipse.xtext.ide.editor.syntaxcoloring.IEditorHighlightingConfigurationProvider
import org.eclipse.xtext.ide.tests.testlanguage.highlighting.TestLanguageHighlightingProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class TestLanguageRuntimeModule extends AbstractTestLanguageRuntimeModule {

	def void configureExecutorService(Binder binder) {
		binder.bind(ExecutorService).toInstance(Executors.newCachedThreadPool)
	}

	def void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(InternalTestLanguageLexer)
	}

	def Class<? extends IContentAssistParser> bindIContentAssistParser() {
		TestLanguageParser
	}
	
	def Class<? extends IEditorHighlightingConfigurationProvider> bindIEditorHighlightingConfigurationProvider() {
		TestLanguageHighlightingProvider
	}

}
