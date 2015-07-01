/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest;
import org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test the content assist to make sure we inherit the default XbaseProposalProvider
 * implementation.
 * 
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=471434
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ContentAssistFragmentTestLangUiInjectorProvider.class)
@SuppressWarnings("all")
public class Bug471434Test extends AbstractContentAssistTest {
  @Test
  public void testVariableRightWithPrefix() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val first = 0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val second = f");
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("first");
    _assertProposal.withDisplayString("first");
  }
  
  @Test
  public void testVariableRight() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val first = 0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val second = ");
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("first");
    _assertProposal.withDisplayString("first");
  }
}
