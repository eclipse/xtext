/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.List;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
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
      final ICompletionProposal[] proposals = tester.append(input).computeCompletionProposals();
      final List<String> proposalStrings = tester.toString(proposals);
      Assert.assertTrue(proposalStrings.toString(), proposalStrings.contains("java.util.ArrayList"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
