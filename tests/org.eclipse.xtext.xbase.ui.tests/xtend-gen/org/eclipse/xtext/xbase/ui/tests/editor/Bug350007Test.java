/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.List;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.ui.tests.editor.AbstractXbaseContentAssistBugTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug350007Test extends AbstractXbaseContentAssistBugTest {
  @Test
  public void testTypeLiteral_01() {
    this.expectArrayList("typeof(java.util");
  }
  
  @Test
  public void testTypeLiteral_02() {
    this.expectArrayList("typeof(java.util.A");
  }
  
  @Test
  @Ignore
  public void testTypeLiteral_03() {
    this.expectArrayList("typeof(java.util.");
  }
  
  @Test
  public void testInstanceOf_01() {
    this.expectArrayList("null instanceof java.util");
  }
  
  @Test
  public void testInstanceOf_02() {
    this.expectArrayList("null instanceof java.util.A");
  }
  
  @Test
  @Ignore
  public void testInstanceOf_03() {
    this.expectArrayList("null instanceof java.util.");
  }
  
  @Test
  public void testCast_01() {
    this.expectArrayList("null as java.util");
  }
  
  @Test
  public void testCast_02() {
    this.expectArrayList("null as java.util.A");
  }
  
  @Test
  @Ignore
  public void testCast_03() {
    this.expectArrayList("null as java.util.");
  }
  
  @Test
  public void testConstructor_01() {
    this.expectArrayList("new java.util");
  }
  
  @Test
  public void testConstructor_02() {
    this.expectArrayList("new java.util.A");
  }
  
  @Test
  @Ignore
  public void testConstructor_03() {
    this.expectArrayList("new java.util.");
  }
  
  protected void expectArrayList(final String input) {
    try {
      final ContentAssistProcessorTestBuilder tester = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = tester.append(input);
      final ICompletionProposal[] proposals = _append.computeCompletionProposals();
      final List<String> proposalStrings = tester.toString(proposals);
      String _string = proposalStrings.toString();
      boolean _contains = proposalStrings.contains("java.util.ArrayList");
      Assert.assertTrue(_string, _contains);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
