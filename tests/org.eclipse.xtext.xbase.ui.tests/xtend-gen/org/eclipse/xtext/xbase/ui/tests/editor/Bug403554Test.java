/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.ui.tests.editor.AbstractXbaseContentAssistBugTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug403554Test extends AbstractXbaseContentAssistBugTest {
  @Test
  public void testProposalOnIt() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ it.");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString("subList(int fromIndex, int toIndex) : List<E> - AbstractList");
  }
  
  @Ignore
  @Test
  public void testProposalOnItWithExplicitParameters() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ it | it.");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString("subList(int fromIndex, int toIndex) : List<E> - AbstractList");
  }
  
  @Ignore
  @Test
  public void testProposalOnImplicitWithExplicitParameters() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ it | ");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString("subList(int fromIndex, int toIndex) : List<E> - AbstractList");
  }
  
  @Ignore
  @Test
  public void testProposalOnImplicit() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ ");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString("subList(int fromIndex, int toIndex) : List<E> - AbstractList");
  }
  
  @Test
  public void testProposalOnList() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\").");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString("subList(int fromIndex, int toIndex) : List<E> - AbstractList");
  }
}
