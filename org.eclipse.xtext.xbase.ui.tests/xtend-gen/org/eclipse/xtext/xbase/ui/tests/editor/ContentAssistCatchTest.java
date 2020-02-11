/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.ui.testing.AbstractXbaseContentAssistTest;
import org.eclipse.xtext.xbase.ui.tests.editor.ContentAssistTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistCatchTest extends ContentAssistTest {
  @Override
  protected String getPrefix() {
    return "try { var x = 0 } catch(Exception ex)";
  }
  
  @Override
  protected String[] getKeywordsAndStatics() {
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList(super.getKeywordsAndStatics());
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
  
  @Override
  public void testOnStringLiteral_33() throws Exception {
    this.newBuilder().append("(\'\'.toString )").assertTextAtCursorPosition(")", this.expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" }));
  }
  
  @Override
  public void testAfterBinaryOperation_06() throws Exception {
    this.newBuilder().append("((\'\'+\'\'))").assertTextAtCursorPosition("))", 1, this.expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" }));
  }
  
  @Override
  public void testAfterBinaryOperation_07() throws Exception {
    this.newBuilder().append("((\'\'+\'\'))").assertTextAtCursorPosition("))", this.expect(AbstractXbaseContentAssistTest.STRING_OPERATORS, new String[] { "as", "instanceof" }));
  }
  
  @Override
  public void testOnVoidMethod_01() throws Exception {
    this.newBuilder().append("(null as java.util.List).clear ").assertText("catch", "finally");
  }
}
