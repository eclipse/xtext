/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug365368Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testEscapedIdentifierNoPrefix() throws Exception {
    this.newBuilder().append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.").assertText(
      "^as", "aa", "bb", "m", 
      "class", "clone", "equals()", "finalize", "hashCode", "identityEquals()", "notify", "notifyAll", "toString", "wait", "wait()", "wait()");
  }

  @Test
  public void testEscapedIdentifierEscapeCharPrefix() throws Exception {
    this.newBuilder().append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.^").assertText("^as");
  }

  @Test
  public void testEscapedIdentifierFirstCharPrefix() throws Exception {
    this.newBuilder().append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.a").assertText("^as", "aa");
  }

  @Test
  public void testEscapedIdentifierFirstCharPrefixApplied() throws Exception {
    this.newBuilder().append("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.a").assertText("^as", "aa").applyProposal("^as").expectContent("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.^as");
  }

  @Test
  public void testEscapedIdentifierTwoCharsPrefix() throws Exception {
    this.newBuilder().append("class C {\n\t\t\tdef void ^as() {}\n\t\t\tdef void aa() {}\n\t\t\tdef void bb() {}\n\t\t\tdef void m() { this.as").assertText("^as");
  }

  @Test
  public void testEscapedIdentifierTwoCharPrefixApplied() throws Exception {
    this.newBuilder().append("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.as").applyProposal().expectContent("class C {\n\t\t\t\tdef void ^as() {}\n\t\t\t\tdef void aa() {}\n\t\t\t\tdef void bb() {}\n\t\t\t\tdef void m() { this.^as");
  }
}
