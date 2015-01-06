/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.completion;

import org.eclipse.xtend.idea.completion.LightXtendTest;

@SuppressWarnings("all")
public class XtendCompletionTest extends LightXtendTest {
  public void testClassKeyword() {
    this.complete("cl<caret>");
    this.assertLookupStrings("class");
  }
  
  public void testExtendsKeyword() {
    this.complete("class Foo ex<caret>");
    this.assertLookupStrings("extends");
  }
  
  public void testEmptyFile() {
    this.complete("");
    this.assertLookupStrings(
      "annotation", 
      "class", 
      "enum", 
      "import", 
      "interface", 
      "package");
  }
}
