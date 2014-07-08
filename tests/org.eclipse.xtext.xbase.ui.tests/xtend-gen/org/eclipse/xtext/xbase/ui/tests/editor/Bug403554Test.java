/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.ArrayList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.ui.tests.editor.AbstractXbaseContentAssistBugTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug403554Test extends AbstractXbaseContentAssistBugTest {
  private String declarator;
  
  public void setUp() throws Exception {
    super.setUp();
    final IJavaProject project = this.getJavaProject(null);
    String _name = ArrayList.class.getName();
    IType type = project.findType(_name);
    IMethod method = type.getMethod("subList", new String[] { "I", "I" });
    while ((!method.exists())) {
      {
        String superclassName = type.getSuperclassName();
        final int idx = superclassName.indexOf("<");
        if ((idx != (-1))) {
          String _substring = superclassName.substring(0, idx);
          superclassName = _substring;
        }
        IType _findType = project.findType(superclassName);
        type = _findType;
        IMethod _method = type.getMethod("subList", new String[] { "I", "I" });
        method = _method;
      }
    }
    String _elementName = type.getElementName();
    this.declarator = _elementName;
  }
  
  @Test
  public void testProposalOnIt() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ it.");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Ignore
  @Test
  public void testProposalOnItWithExplicitParameters() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ it | it.");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Ignore
  @Test
  public void testProposalOnImplicitWithExplicitParameters() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ it | ");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Ignore
  @Test
  public void testProposalOnImplicit() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\") => [ ");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Test
  public void testProposalOnList() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("newArrayList(\"\").");
    ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _append.assertProposal("subList()");
    _assertProposal.withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
}
