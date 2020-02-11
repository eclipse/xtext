/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestLanguageIdeContentProposalProvider extends IdeContentProposalProvider {
  @Inject
  @Extension
  private TestLanguageGrammarAccess _testLanguageGrammarAccess;
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    AbstractRule _rule = ruleCall.getRule();
    ParserRule _typeDeclarationRule = this._testLanguageGrammarAccess.getTypeDeclarationRule();
    boolean _equals = Objects.equal(_rule, _typeDeclarationRule);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type ${1|A,B,C|} {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      acceptor.accept(this.getProposalCreator().createSnippet(_builder.toString(), "Sample Snippet", context), 0);
    }
    super._createProposals(ruleCall, context, acceptor);
  }
}
