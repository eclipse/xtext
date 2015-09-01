/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Binder
import com.google.inject.Provider
import com.google.inject.name.Names
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ide.labels.IImageDescriptionProvider
import org.eclipse.xtext.web.example.jetty.contentassist.StatemachineWebContentProposalProvider
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineImageDescriptionProvider
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineSemanticHighlightingCalculator
import org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.StatemachineParser
import org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.internal.InternalStatemachineLexer
import org.eclipse.xtext.web.server.DefaultWebModule
import org.eclipse.xtext.web.server.persistence.FileResourceHandler
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

@Accessors
class StatemachineWebModule extends DefaultWebModule {
	
	IResourceBaseProvider resourceBaseProvider
	
	new(ExecutorService executorService, ExecutorService executorServiceWithDocumentLock) {
		super(executorService, executorServiceWithDocumentLock)
	}
	
	new(Provider<ExecutorService> executorServiceProvider) {
		super(executorServiceProvider)
	}
	
	def configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(InternalStatemachineLexer)
	}
	
	def Class<? extends IContentAssistParser> bindIContentAssistParser() {
		StatemachineParser
	}
	
	def Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		StatemachineWebContentProposalProvider
	}
	
	def Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		FileResourceHandler
	}
	
	def configureResourceBaseProvider(Binder binder) {
		if (resourceBaseProvider !== null)
			binder.bind(IResourceBaseProvider).toInstance(resourceBaseProvider)
	}

	def Class<? extends IImageDescriptionProvider> bindIImageDescriptionProvider() {
		StatemachineImageDescriptionProvider
	}
	
	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		StatemachineSemanticHighlightingCalculator
	}
}
