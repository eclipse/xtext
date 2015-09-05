/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.highlighting;

import com.google.inject.Inject;
import com.google.inject.Provider;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer;
import org.eclipse.xtend.idea.LightXtendTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendHighlightingLexerTest extends LightXtendTest {
  @Inject
  private Provider<XtendHighlightingLexer> lexerProvider;
  
  public void testStart_01() {
    final XtendHighlightingLexer lexer = this.lexerProvider.get();
    lexer.start("package mypackage");
    int _tokenStart = lexer.getTokenStart();
    TestCase.assertEquals(0, _tokenStart);
    lexer.advance();
    int _tokenStart_1 = lexer.getTokenStart();
    TestCase.assertNotSame(Integer.valueOf(0), Integer.valueOf(_tokenStart_1));
    lexer.start("package mypackage");
    int _tokenStart_2 = lexer.getTokenStart();
    TestCase.assertEquals(0, _tokenStart_2);
  }
  
  public void testStart_02() {
    final XtendHighlightingLexer lexer = this.lexerProvider.get();
    lexer.start("\'\'\' «» \'\'\'");
    int _tokenStart = lexer.getTokenStart();
    TestCase.assertEquals(0, _tokenStart);
    lexer.advance();
    int _tokenStart_1 = lexer.getTokenStart();
    TestCase.assertNotSame(Integer.valueOf(0), Integer.valueOf(_tokenStart_1));
    lexer.start("\'\'\' «» \'\'\'");
    int _tokenStart_2 = lexer.getTokenStart();
    TestCase.assertEquals(0, _tokenStart_2);
  }
}
