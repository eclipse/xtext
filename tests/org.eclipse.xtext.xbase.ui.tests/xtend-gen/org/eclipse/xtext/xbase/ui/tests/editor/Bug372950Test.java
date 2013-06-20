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
import org.eclipse.xtext.xbase.ui.tests.editor.AbstractXbaseContentAssistBugTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug372950Test extends AbstractXbaseContentAssistBugTest {
  @Ignore
  @Test
  public void testProposeStringBuffer_01() throws Exception {
    this.shouldPropose("if (true) {} else { if (o as String != 1 && o instanceof StringBuff", StringBuffer.class);
  }
  
  @Ignore
  @Test
  public void testProposeStringBuffer_02() throws Exception {
    this.shouldPropose("if (true) {} else { if (o as String != 1d && o instanceof StringBuff", StringBuffer.class);
  }
  
  @Ignore
  @Test
  public void testProposeStringBuffer_03() throws Exception {
    this.shouldPropose("if (true) {} else { if (o as String != 1.1e5 && o instanceof StringBuff", StringBuffer.class);
  }
  
  @Test
  public void testProposeStringBuffer_04() throws Exception {
    this.shouldPropose("if (true) {} else { if (o as String != (1) && o instanceof StringBuff", StringBuffer.class);
  }
  
  @Test
  public void testProposeStringBuffer_05() throws Exception {
    this.shouldPropose("if (true) {} else { if (o as String != \"\" && o instanceof StringBuff", StringBuffer.class);
  }
  
  @Test
  public void testProposeStringBuffer_06() throws Exception {
    this.shouldPropose("if (true) {} else { if ((o as String != 1) && o instanceof StringBuff", StringBuffer.class);
  }
  
  @Test
  public void testProposeStringBuffer_07() throws Exception {
    this.shouldPropose("if (true) { if (o as String != 1 && o instanceof StringBuff", StringBuffer.class);
  }
  
  protected void shouldPropose(final String input, final Class<? extends Object> proposedType) throws Exception {
    final ContentAssistProcessorTestBuilder tester = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = tester.append(input);
    final ICompletionProposal[] proposals = _append.computeCompletionProposals();
    final List<String> proposalStrings = tester.toString(proposals);
    String _string = proposalStrings.toString();
    String _simpleName = proposedType.getSimpleName();
    boolean _contains = proposalStrings.contains(_simpleName);
    Assert.assertTrue(_string, _contains);
  }
}
