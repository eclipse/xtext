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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistPrioritiesTest extends AbstractXtendContentAssistBugTest {
  @Test
  public void testPriorities() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class Example {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String aField;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String zField;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String aStaticField;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String zStaticField;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void aMethod(String aParam,String zParam) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val aVar = \'fdfg\';");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val zVar = \'fdfg\';");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//CURSOR");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void zMethod() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void aStaticMethod() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void zStaticMethod() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      int _indexOf = text.indexOf("//CURSOR");
      final int idx = (_indexOf - 1);
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(text);
      ContentAssistProcessorTestBuilder _insert = _append.insert("", idx);
      ICompletionProposal[] _computeCompletionProposals = _insert.computeCompletionProposals();
      final Iterator<ICompletionProposal> proposals = ((List<ICompletionProposal>)Conversions.doWrapArray(_computeCompletionProposals)).iterator();
      ICompletionProposal _next = proposals.next();
      this.assertContains(_next, "aParam");
      ICompletionProposal _next_1 = proposals.next();
      this.assertContains(_next_1, "aVar");
      ICompletionProposal _next_2 = proposals.next();
      this.assertContains(_next_2, "zParam");
      ICompletionProposal _next_3 = proposals.next();
      this.assertContains(_next_3, "zVar");
      ICompletionProposal _next_4 = proposals.next();
      this.assertContains(_next_4, "aField");
      ICompletionProposal _next_5 = proposals.next();
      this.assertContains(_next_5, "aStaticField");
      ICompletionProposal _next_6 = proposals.next();
      this.assertContains(_next_6, "zField");
      ICompletionProposal _next_7 = proposals.next();
      this.assertContains(_next_7, "zStaticField");
      ICompletionProposal _next_8 = proposals.next();
      this.assertContains(_next_8, "aMethod");
      ICompletionProposal _next_9 = proposals.next();
      this.assertContains(_next_9, "aStaticMethod");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertContains(final ICompletionProposal proposal, final String text) {
    String _displayString = proposal.getDisplayString();
    String _plus = ((text + " in ") + _displayString);
    String _displayString_1 = proposal.getDisplayString();
    boolean _contains = _displayString_1.contains(text);
    Assert.assertTrue(_plus, _contains);
  }
}
