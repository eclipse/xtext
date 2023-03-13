/**
 * Copyright (c) 2020 Sebastian Zarnekow and others.
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
public class Issue624Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testMembersOfEnclosingTypeAreProposed() throws Exception {
    this.newBuilder().append("class Outer {\n\t\t\tint xxxOuter = 1;\n\t\t\tstatic class StaticInner {\n\t\t\t\tint xxxStaticInner = 2;\n\t\t\t\tclass Inner {\n\t\t\t\t\tint xxxInner = xxx").assertText(
      "xxxInner", "xxxStaticInner");
  }

  @Test
  public void testNoInstanceMembersProposedInStaticLocalClass() throws Exception {
    this.newBuilder().append("class Outer {\n\t\t\tstatic int xxxOuter = 1;\n\t\t\tint xxxInstanceInOuter = 2\n\t\t\tstatic def m() {\n\t\t\t\tnew Object() {\n\t\t\t\t\tint xxxLocal = xxx").assertText(
      "xxxOuter", "xxxLocal");
  }
}
