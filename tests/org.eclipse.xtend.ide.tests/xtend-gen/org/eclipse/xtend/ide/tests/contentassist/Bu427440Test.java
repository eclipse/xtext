/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bu427440Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testStaticMemberPriority() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def augument() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Main {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Test.a|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ICompletionProposal[] _computeCompletionProposals = _append.computeCompletionProposals("|");
    final Iterator<ICompletionProposal> proposals = ((List<ICompletionProposal>)Conversions.doWrapArray(_computeCompletionProposals)).iterator();
    ICompletionProposal _next = proposals.next();
    this.assertContains(_next, "augument");
    ICompletionProposal _next_1 = proposals.next();
    this.assertContains(_next_1, "annotation");
    ICompletionProposal _next_2 = proposals.next();
    this.assertContains(_next_2, "annotations");
    ICompletionProposal _next_3 = proposals.next();
    this.assertContains(_next_3, "anonymousClass");
    ICompletionProposal _next_4 = proposals.next();
    this.assertContains(_next_4, "array");
    ICompletionProposal _next_5 = proposals.next();
    this.assertContains(_next_5, "asSubclass()");
  }
  
  public void assertContains(final ICompletionProposal proposal, final String text) {
    String _proposedText = this.getProposedText(proposal);
    Assert.assertEquals(text, _proposedText);
  }
  
  public String getProposedText(final ICompletionProposal completionProposal) {
    String proposedText = completionProposal.getDisplayString();
    if ((completionProposal instanceof ConfigurableCompletionProposal)) {
      String _replacementString = ((ConfigurableCompletionProposal)completionProposal).getReplacementString();
      proposedText = _replacementString;
      ConfigurableCompletionProposal.IReplacementTextApplier _textApplier = ((ConfigurableCompletionProposal)completionProposal).getTextApplier();
      if ((_textApplier instanceof ReplacementTextApplier)) {
        ConfigurableCompletionProposal.IReplacementTextApplier _textApplier_1 = ((ConfigurableCompletionProposal)completionProposal).getTextApplier();
        String _actualReplacementString = ((ReplacementTextApplier) _textApplier_1).getActualReplacementString(((ConfigurableCompletionProposal)completionProposal));
        proposedText = _actualReplacementString;
      }
    }
    return proposedText;
  }
}
