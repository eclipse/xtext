/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test.languages.contentassist

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.web.server.contentassist.AbstractDeclarativeWebContentProposalProvider
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.Proposals

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*
import static org.eclipse.xtext.web.server.contentassist.ContentAssistResult.*

class StatemachineWebContentProposalProvider extends AbstractDeclarativeWebContentProposalProvider {
	
	@Proposals(rule='BOOLEAN')
	def completeBoolean(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		acceptor.accept(new ContentAssistResult.Entry(TERMINAL, context.prefix) => [
			proposal = 'true'
		])
		acceptor.accept(new ContentAssistResult.Entry(TERMINAL, context.prefix) => [
			proposal = 'false'
		])
	}
	
	@Proposals(rule='Event', feature='signal')
	def completeEventSignal(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		val scope = scopeProvider.getScope(context.currentModel, EVENT__SIGNAL)
		for (description : scope.allElements.filter[getEClass == INPUT_SIGNAL]) {
			acceptor.accept(new ContentAssistResult.Entry(CROSSREF, context.prefix) => [
				proposal = description.name.toString
				description = 'input signal'
			])
		}
	}
	
	@Proposals(rule='Command', feature='signal')
	def completeCommandSignal(ContentAssistContext context, IAcceptor<ContentAssistResult.Entry> acceptor) {
		val scope = scopeProvider.getScope(context.currentModel, COMMAND__SIGNAL)
		for (description : scope.allElements.filter[getEClass == OUTPUT_SIGNAL]) {
			acceptor.accept(new ContentAssistResult.Entry(CROSSREF, context.prefix) => [
				proposal = description.name.toString
				description = 'output signal'
			])
		}
	}
	
}
