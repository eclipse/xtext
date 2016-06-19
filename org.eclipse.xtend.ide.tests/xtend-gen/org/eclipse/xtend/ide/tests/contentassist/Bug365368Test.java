/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug365368Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testEscapedIdentifierNoPrefix() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.");
    _append.assertText(
      "^as", "aa", "bb", "m", 
      "class", "clone", "equals()", "finalize", "hashCode", "identityEquals()", "notify", "notifyAll", "toString", "wait", "wait()", "wait()");
  }
  
  @Test
  public void testEscapedIdentifierEscapeCharPrefix() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.^");
    _append.assertText("^as");
  }
  
  @Test
  public void testEscapedIdentifierFirstCharPrefix() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.a");
    _append.assertText("^as", "aa");
  }
  
  @Test
  public void testEscapedIdentifierFirstCharPrefixApplied() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.a");
    ContentAssistProcessorTestBuilder _assertText = _append.assertText("^as", "aa");
    ContentAssistProcessorTestBuilder _applyProposal = _assertText.applyProposal("^as");
    _applyProposal.expectContent("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.^as");
  }
  
  @Test
  public void testEscapedIdentifierTwoCharsPrefix() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.as");
    _append.assertText("^as");
  }
  
  @Test
  public void testEscapedIdentifierTwoCharPrefixApplied() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.as");
    ContentAssistProcessorTestBuilder _applyProposal = _append.applyProposal();
    _applyProposal.expectContent("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.^as");
  }
}
