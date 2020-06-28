/**
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Issue624Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testMembersOfEnclosingTypeAreProposed() throws Exception {
    this.newBuilder().append("class Outer {\n\t\t\tint inOuter = 1;\n\t\t\tstatic class StaticInner {\n\t\t\t\tint inStaticInner = 2;\n\t\t\t\tclass Inner {\n\t\t\t\t\tint inInner = in").assertText(
      "inInner", "inStaticInner", "instanceof - type test and autocast", "internalArrayEquals()");
  }
  
  @Test
  public void testNoInstanceMembersProposedInStaticLocalClass() throws Exception {
    this.newBuilder().append("class Outer {\n\t\t\tstatic int inOuter = 1;\n\t\t\tint instanceInOuter = 2\n\t\t\tstatic def m() {\n\t\t\t\tnew Object() {\n\t\t\t\t\tint inLocal = in").assertText(
      "inOuter", "inLocal", "instanceof - type test and autocast", "internalArrayEquals()");
  }
}
