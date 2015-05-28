/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty.contentassist

import com.google.inject.Inject
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*
import static org.eclipse.xtext.web.server.contentassist.ContentAssistResult.*

class StatemachineWebContentProposalProvider extends WebContentProposalProvider {
	
	@Inject extension StatemachineGrammarAccess
	
	override dispatch createProposals(RuleCall ruleCall, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		switch (ruleCall.rule) {
			
			case BOOLEANRule: {
				acceptor.accept(new ContentAssistResult.Entry(TERMINAL, context.prefix) => [
					proposal = 'true'
				])
				acceptor.accept(new ContentAssistResult.Entry(TERMINAL, context.prefix) => [
					proposal = 'false'
				])
			}
			
			default:
				super._createProposals(ruleCall, context, acceptor)	
		}
	}
	
	override dispatch createProposals(Assignment assignment, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		switch (assignment) {
			case eventAccess.signalAssignment_0: {
				val scope = scopeProvider.getScope(context.currentModel, EVENT__SIGNAL)
				for (description : scope.allElements.filter[getEClass == INPUT_SIGNAL]) {
					acceptor.accept(new ContentAssistResult.Entry(CROSSREF, context.prefix) => [
						proposal = description.name.toString
						description = 'input signal'
					])
				}
			}
			
			case commandAccess.signalAssignment_1: {
				val scope = scopeProvider.getScope(context.currentModel, COMMAND__SIGNAL)
				for (description : scope.allElements.filter[getEClass == OUTPUT_SIGNAL]) {
					acceptor.accept(new ContentAssistResult.Entry(CROSSREF, context.prefix) => [
						proposal = description.name.toString
						description = 'output signal'
					])
				}
			}
			
			default:
				super._createProposals(assignment, context, acceptor)
		}
	}
	
}