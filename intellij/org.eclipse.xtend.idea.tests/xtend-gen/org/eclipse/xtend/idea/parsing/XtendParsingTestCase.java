/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.parsing;

import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.idea.parsing.IdeaXtendParserTest;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase;

/**
 * @author kosyakov - Initial contribution and API
 */
@TestDecorator
@SuppressWarnings("all")
public class XtendParsingTestCase extends AbstractModelTestCase {
  private IdeaXtendParserTest delegate;
  
  public XtendParsingTestCase() {
    super(XtendFileType.INSTANCE);
    IdeaXtendParserTest _ideaXtendParserTest = new IdeaXtendParserTest(this);
    this.delegate = _ideaXtendParserTest;
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this.delegate);
  }
  
  public void testBug367949() throws Exception {
    delegate.testBug367949();
  }
  
  public void testBug427257() throws Exception {
    delegate.testBug427257();
  }
  
  public void testConstructor_01() throws Exception {
    delegate.testConstructor_01();
  }
  
  public void testConstructor_02() throws Exception {
    delegate.testConstructor_02();
  }
  
  public void testCreateExtension_00() throws Exception {
    delegate.testCreateExtension_00();
  }
  
  public void testCreateExtension_01() throws Exception {
    delegate.testCreateExtension_01();
  }
  
  public void testExtensionOnCatchClause_01() throws Exception {
    delegate.testExtensionOnCatchClause_01();
  }
  
  public void testExtensionOnForLoopParam_01() throws Exception {
    delegate.testExtensionOnForLoopParam_01();
  }
  
  public void testExtensionOnLambdaParameter_01() throws Exception {
    delegate.testExtensionOnLambdaParameter_01();
  }
  
  public void testExtensionOnLocalVar_01() throws Exception {
    delegate.testExtensionOnLocalVar_01();
  }
  
  public void testExtensionOnLocalVar_02() throws Exception {
    delegate.testExtensionOnLocalVar_02();
  }
  
  public void testExtensionOnMethodParameter_01() throws Exception {
    delegate.testExtensionOnMethodParameter_01();
  }
  
  public void testFunctionTypeRef_0() throws Exception {
    delegate.testFunctionTypeRef_0();
  }
  
  public void testFunctionTypeRef_1() throws Exception {
    delegate.testFunctionTypeRef_1();
  }
  
  public void testFunction_0() throws Exception {
    delegate.testFunction_0();
  }
  
  public void testFunction_1() throws Exception {
    delegate.testFunction_1();
  }
  
  public void testFunction_2() throws Exception {
    delegate.testFunction_2();
  }
  
  public void testFunction_3() throws Exception {
    delegate.testFunction_3();
  }
  
  public void testFunction_4() throws Exception {
    delegate.testFunction_4();
  }
  
  public void testFunction_5() throws Exception {
    delegate.testFunction_5();
  }
  
  public void testFunction_6() throws Exception {
    delegate.testFunction_6();
  }
  
  public void testFunction_7() throws Exception {
    delegate.testFunction_7();
  }
  
  public void testImport_01() throws Exception {
    delegate.testImport_01();
  }
  
  public void testImport_02() throws Exception {
    delegate.testImport_02();
  }
  
  public void testImport_03() throws Exception {
    delegate.testImport_03();
  }
  
  public void testImport_04() throws Exception {
    delegate.testImport_04();
  }
  
  public void testMultipleClasses_01() throws Exception {
    delegate.testMultipleClasses_01();
  }
  
  public void testMultipleClasses_02() throws Exception {
    delegate.testMultipleClasses_02();
  }
  
  public void testRichStringFOR_01() throws Exception {
    delegate.testRichStringFOR_01();
  }
  
  public void testRichStringFOR_02() throws Exception {
    delegate.testRichStringFOR_02();
  }
  
  public void testRichStringFOR_03() throws Exception {
    delegate.testRichStringFOR_03();
  }
  
  public void testRichStringIF_00() throws Exception {
    delegate.testRichStringIF_00();
  }
  
  public void testRichStringIF_01() throws Exception {
    delegate.testRichStringIF_01();
  }
  
  public void testRichStringWithComment_00() throws Exception {
    delegate.testRichStringWithComment_00();
  }
  
  public void testRichStringWithComment_01() throws Exception {
    delegate.testRichStringWithComment_01();
  }
  
  public void testRichStringWithComment_03() throws Exception {
    delegate.testRichStringWithComment_03();
  }
  
  public void testRichString_00() throws Exception {
    delegate.testRichString_00();
  }
  
  public void testRichString_01() throws Exception {
    delegate.testRichString_01();
  }
  
  public void testRichString_02() throws Exception {
    delegate.testRichString_02();
  }
  
  public void testTypeParams_1() throws Exception {
    delegate.testTypeParams_1();
  }
  
  public void testTypeParams_2() throws Exception {
    delegate.testTypeParams_2();
  }
  
  public void testTypeParams_3() throws Exception {
    delegate.testTypeParams_3();
  }
  
  public void testUnambiguity_00() throws Exception {
    delegate.testUnambiguity_00();
  }
  
  public void testUnambiguity_01() throws Exception {
    delegate.testUnambiguity_01();
  }
  
  public void testXtendField_00() throws Exception {
    delegate.testXtendField_00();
  }
  
  public void testXtendField_01() throws Exception {
    delegate.testXtendField_01();
  }
  
  public void testXtendField_03() throws Exception {
    delegate.testXtendField_03();
  }
  
  public void testXtendField_04() throws Exception {
    delegate.testXtendField_04();
  }
}
