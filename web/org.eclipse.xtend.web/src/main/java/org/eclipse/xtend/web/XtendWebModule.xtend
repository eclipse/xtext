/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.web

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtend.core.linking.Linker
import org.eclipse.xtend.ide.common.contentassist.antlr.DisabledInternalLexer
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistContextFactory
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistParser
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendLexer
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingCalculator
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.linking.ILinker
import org.eclipse.xtext.parser.antlr.LexerProvider
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.occurrences.OccurrencesService
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

/**
 * Use this class to register additional components to be used within the web application.
 */
@FinalFieldsConstructor class XtendWebModule extends AbstractXtendWebModule {

	override Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return FlexerBasedContentAssistParser
	}

	def void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(InternalXtendLexer).toProvider(LexerProvider.create(DisabledInternalLexer))
		binder.bind(DisabledInternalLexer).toProvider(LexerProvider.create(DisabledInternalLexer))
	}

	override void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(DisabledInternalLexer)
	}

	def Class<? extends ILinker> bindILinker() {
		return Linker
	}

	def Class<? extends ContentAssistContextFactory> bindContentAssistContextFactory() {
		return FlexerBasedContentAssistContextFactory
	}

	def Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		return ExampleResourceHandler
	}
	
	def Class<? extends OccurrencesService> bindOccurencesService() {
		return XtendOccurrencesService
	}
	
	def Class<? extends XtextServiceDispatcher> bindXtextServiceDispatcher() {
		return XtendServiceDispatcher
	}

	override Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return XtendHighlightingCalculator
	}
	
}
