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
      final Iterator<ICompletionProposal> proposals = ((List<ICompletionProposal>)Conversions.doWrapArray(this.newBuilder().append(text).insert("", idx).computeCompletionProposals())).iterator();
      this.assertContains(proposals.next(), "aParam");
      this.assertContains(proposals.next(), "aVar");
      this.assertContains(proposals.next(), "zParam");
      this.assertContains(proposals.next(), "zVar");
      this.assertContains(proposals.next(), "aField");
      this.assertContains(proposals.next(), "aStaticField");
      this.assertContains(proposals.next(), "zField");
      this.assertContains(proposals.next(), "zStaticField");
      this.assertContains(proposals.next(), "aMethod");
      this.assertContains(proposals.next(), "aStaticMethod");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertContains(final ICompletionProposal proposal, final String text) {
    String _displayString = proposal.getDisplayString();
    String _plus = ((text + " in ") + _displayString);
    Assert.assertTrue(_plus, proposal.getDisplayString().contains(text));
  }
}
