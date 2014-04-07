/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.ArrayList;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.junit.ui.AbstractXbaseContentAssistTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.ui.tests.editor.ContentAssistTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistCatchTest extends ContentAssistTest {
  protected String getPrefix() {
    return "try { var x = 0 } catch(Exception ex)";
  }
  
  protected String[] getKeywordsAndStatics() {
    String[] _keywordsAndStatics = super.getKeywordsAndStatics();
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList(_keywordsAndStatics);
    result.add("ex");
    return ((String[])Conversions.unwrapArray(result, String.class));
  }
  
  @AfterClass
  public static void resetCastInstanceOf() {
    AbstractXbaseContentAssistTest.CAST_INSTANCEOF = new String[] { "as", "instanceof" };
  }
  
  @BeforeClass
  public static void addCatchAndFinallyToCastInstanceOf() {
    AbstractXbaseContentAssistTest.CAST_INSTANCEOF = new String[] { "as", "catch", "finally", "instanceof" };
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
  
  public void testOnVoidMethod_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append("(null as java.util.List).clear ");
    _append.assertText("catch", "finally");
  }
}
