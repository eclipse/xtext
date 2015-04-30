/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import com.google.inject.Binder
import com.google.inject.name.Names
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.EntitiesParser
import org.eclipse.xtext.idea.example.entities.ide.contentassist.antlr.internal.InternalEntitiesLexer
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.web.server.persistence.FileResourceHandler
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

@FinalFieldsConstructor
class EntitiesWebModule extends AbstractGenericModule {
	
	val ExecutorService executorService
	
	val IResourceBaseProvider resourceBaseProvider
	
	def configureExecutorService(Binder binder) {
		binder.bind(ExecutorService).toInstance(executorService)
	}
	
	def configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(InternalEntitiesLexer)
	}

	def Class<? extends IContentAssistParser> bindIContentAssistParser() {
		EntitiesParser
	}
	
	def Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		FileResourceHandler
	}
	
	def configureResourceBaseProvider(Binder binder) {
		binder.bind(IResourceBaseProvider).toInstance(resourceBaseProvider)
	}

}
