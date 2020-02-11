/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.ArrayList;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.xbase.ui.tests.editor.AbstractXbaseContentAssistBugTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug403554Test extends AbstractXbaseContentAssistBugTest {
  private String declarator;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    final IJavaProject project = this.getJavaProject(null);
    IType type = project.findType(ArrayList.class.getName());
    IMethod method = type.getMethod("subList", new String[] { "I", "I" });
    while ((!method.exists())) {
      {
        String superclassName = type.getSuperclassName();
        final int idx = superclassName.indexOf("<");
        if ((idx != (-1))) {
          superclassName = superclassName.substring(0, idx);
        }
        type = project.findType(superclassName);
        method = type.getMethod("subList", new String[] { "I", "I" });
      }
    }
    this.declarator = type.getElementName();
  }
  
  @Test
  public void testProposalOnIt() throws Exception {
    this.newBuilder().append("newArrayList(\"\") => [ it.").assertProposal("subList()").withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Ignore
  @Test
  public void testProposalOnItWithExplicitParameters() throws Exception {
    this.newBuilder().append("newArrayList(\"\") => [ it | it.").assertProposal("subList()").withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Ignore
  @Test
  public void testProposalOnImplicitWithExplicitParameters() throws Exception {
    this.newBuilder().append("newArrayList(\"\") => [ it | ").assertProposal("subList()").withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Ignore
  @Test
  public void testProposalOnImplicit() throws Exception {
    this.newBuilder().append("newArrayList(\"\") => [ ").assertProposal("subList()").withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
  
  @Test
  public void testProposalOnList() throws Exception {
    this.newBuilder().append("newArrayList(\"\").").assertProposal("subList()").withDisplayString(("subList(int fromIndex, int toIndex) : List<E> - " + this.declarator));
  }
}
