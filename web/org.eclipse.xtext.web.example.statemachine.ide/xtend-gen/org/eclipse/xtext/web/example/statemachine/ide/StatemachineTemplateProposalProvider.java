/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.ide.editor.contentassist.AbstractIdeTemplateProposalProvider;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;

@SuppressWarnings("all")
public class StatemachineTemplateProposalProvider extends AbstractIdeTemplateProposalProvider {
  public void createStateProposal(final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("state ");
        AbstractIdeTemplateProposalProvider.Variable _variable = StatemachineTemplateProposalProvider.this.variable("name");
        _builder.append(_variable, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        AbstractIdeTemplateProposalProvider.Cursor _cursor = StatemachineTemplateProposalProvider.this.cursor();
        _builder.append(_cursor, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("end");
        _builder.newLine();
      }
    };
    final StringConcatenationClient template = _client;
    this.acceptProposal("state", "Create a new state", template, context, acceptor);
  }
}
