/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import org.eclipse.xtend.idea.LightXtendTest;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug473721 extends LightXtendTest {
  public void testBug473721() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\naddFileToProject cannot be resolved"
      + "\naddFileToProject cannot be resolved"
      + "\nfindFileInTempDir cannot be resolved"
      + "\nexists cannot be resolved"
      + "\ntestHighlighting cannot be resolved"
      + "\nvirtualFile cannot be resolved");
  }
}
