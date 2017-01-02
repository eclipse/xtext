/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.highlighting;

import org.eclipse.xtend.idea.LightXtendTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendHighlightingLexerTest extends LightXtendTest {
  /* @Inject
   */private /* Provider<XtendHighlightingLexer> */Object lexerProvider;
  
  public void testStart_01() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method assertEquals(int, Object) is undefined"
      + "\nThe method assertNotSame(int, Object) is undefined"
      + "\nThe method assertEquals(int, Object) is undefined"
      + "\nThe field XtendHighlightingLexerTest.lexerProvider refers to the missing type Provider"
      + "\nget cannot be resolved"
      + "\nstart cannot be resolved"
      + "\ntokenStart cannot be resolved"
      + "\nadvance cannot be resolved"
      + "\ntokenStart cannot be resolved"
      + "\nstart cannot be resolved"
      + "\ntokenStart cannot be resolved");
  }
  
  public void ignoreStart_02() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method assertEquals(int, Object) is undefined"
      + "\nThe method assertNotSame(int, Object) is undefined"
      + "\nThe method assertEquals(int, Object) is undefined"
      + "\nThe field XtendHighlightingLexerTest.lexerProvider refers to the missing type Provider"
      + "\nget cannot be resolved"
      + "\nstart cannot be resolved"
      + "\ntokenStart cannot be resolved"
      + "\nadvance cannot be resolved"
      + "\ntokenStart cannot be resolved"
      + "\nstart cannot be resolved"
      + "\ntokenStart cannot be resolved");
  }
}
