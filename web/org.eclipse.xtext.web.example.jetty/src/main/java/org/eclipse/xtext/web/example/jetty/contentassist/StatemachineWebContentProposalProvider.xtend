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
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor
import org.eclipse.xtext.web.server.contentassist.WebContentProposalProvider

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*

class StatemachineWebContentProposalProvider extends WebContentProposalProvider {
	
	@Inject extension StatemachineGrammarAccess
	
	override dispatch createProposals(RuleCall ruleCall, ContentAssistContext context,
			IWebContentProposaAcceptor acceptor) {
		switch (ruleCall.rule) {
			
			case BOOLEANRule: {
				val trueEntry = new ContentAssistResult.Entry(context.prefix) => [
					proposal = 'true'
				]
				acceptor.accept(trueEntry, proposalPriorities.getDefaultPriority(trueEntry))
				val falseEntry = new ContentAssistResult.Entry(context.prefix) => [
					proposal = 'false'
				]
				acceptor.accept(falseEntry, proposalPriorities.getDefaultPriority(falseEntry))
			}
			
			default:
				super._createProposals(ruleCall, context, acceptor)	
		}
	}
	
	override dispatch createProposals(Assignment assignment, ContentAssistContext context,
			IWebContentProposaAcceptor acceptor) {
		switch (assignment) {
			case eventAccess.signalAssignment_0: {
				val scope = scopeProvider.getScope(context.currentModel, EVENT__SIGNAL)
				for (description : scope.allElements.filter[getEClass == INPUT_SIGNAL]) {
					val entry = new ContentAssistResult.Entry(context.prefix) => [
						proposal = description.name.toString
						description = 'input signal'
					]
					acceptor.accept(entry, proposalPriorities.getCrossRefPriority(description, entry))
				}
			}
			
			case commandAccess.signalAssignment_1: {
				val scope = scopeProvider.getScope(context.currentModel, COMMAND__SIGNAL)
				for (description : scope.allElements.filter[getEClass == OUTPUT_SIGNAL]) {
					val entry = new ContentAssistResult.Entry(context.prefix) => [
											proposal = description.name.toString
											description = 'output signal'
										]
					acceptor.accept(entry, proposalPriorities.getCrossRefPriority(description, entry))
				}
			}
			
			default:
				super._createProposals(assignment, context, acceptor)
		}
	}
	
}