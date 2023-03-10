/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.ide.editor.contentassist.AbstractIdeTemplateProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;

public class StatemachineTemplateProposalProvider extends AbstractIdeTemplateProposalProvider {
	public void createStateProposal(ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		StringConcatenationClient template = new StringConcatenationClient() {
			@Override
			protected void appendTo(StringConcatenationClient.TargetStringConcatenation target) {
				target.append("state ");
				target.append(variable("name"));
				target.newLineIfNotEmpty();
				target.append("\t");
				target.append(cursor(), "\t");
				target.newLineIfNotEmpty();
				target.append("end");
				target.newLine();
			}
		};
		acceptProposal("state", "Create a new state", template, context, acceptor);
	}
}
