/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide

import org.eclipse.xtext.ide.editor.contentassist.AbstractIdeTemplateProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtend2.lib.StringConcatenationClient

class StatemachineTemplateProposalProvider extends AbstractIdeTemplateProposalProvider {
	
	def void createStateProposal(ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		val StringConcatenationClient template = '''
			state «variable('name')»
				«cursor»
			end
		'''
		acceptProposal('state', 'Create a new state', template, context, acceptor)
	}
	
}