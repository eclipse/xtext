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
import org.junit.Test;

/**
 * TODO resolve type parameters in display strings
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug402716Test extends AbstractXbaseContentAssistBugTest {
  @Test
  public void testFilterType() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("#[].filter");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("filter()");
    _assertProposal.withDisplayString("filter(Class<T> type) : Iterable<T> - IterableExtensions");
  }
  
  @Test
  public void testFilterLambda() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("#[].filter");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("filter[]");
    _assertProposal.withDisplayString("filter((T)=>Boolean predicate) : Iterable<T> - IterableExtensions");
  }
  
  @Test
  public void testMapIterable() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("(#[] as Iterable<String>).map");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("map[]");
    _assertProposal.withDisplayString("map((T)=>R transformation) : Iterable<R> - IterableExtensions");
  }
  
  @Test
  public void testMapListLiteral() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("#[].map");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("map[]");
    _assertProposal.withDisplayString("map((T)=>R transformation) : List<R> - ListExtensions");
  }
  
  @Test
  public void testMapNewArrayList() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList.map");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("map[]");
    _assertProposal.withDisplayString("map((T)=>R transformation) : List<R> - ListExtensions");
  }
}
