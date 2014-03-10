/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.junit.ui.AbstractXbaseContentAssistTest;
import org.eclipse.xtext.xbase.ui.tests.editor.ContentAssistTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistInIfThenTest extends ContentAssistTest {
  protected String getPrefix() {
    return "if (true)";
  }
  
  @AfterClass
  public static void resetCastInstanceOf() {
    AbstractXbaseContentAssistTest.CAST_INSTANCEOF = new String[] { "as", "instanceof" };
  }
  
  @BeforeClass
  public static void addElseToCastInstanceOf() {
    AbstractXbaseContentAssistTest.CAST_INSTANCEOF = new String[] { "as", "else", "instanceof" };
  }
  
  public void testOnStringLiteral_33() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("(\'\'.toString )");
    String[] _expect = this.expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" });
    _append.assertTextAtCursorPosition(")", _expect);
  }
  
  public void testAfterBinaryOperation_06() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("((\'\'+\'\'))");
    String[] _expect = this.expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" });
    _append.assertTextAtCursorPosition("))", 1, _expect);
  }
  
  public void testAfterBinaryOperation_07() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("((\'\'+\'\'))");
    String[] _expect = this.expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" });
    _append.assertTextAtCursorPosition("))", _expect);
  }
}
