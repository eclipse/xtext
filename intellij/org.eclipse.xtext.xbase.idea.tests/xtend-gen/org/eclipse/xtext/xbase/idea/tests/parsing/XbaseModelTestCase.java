/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.tests.parsing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseFileType;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest;

@TestDecorator
@SuppressWarnings("all")
public class XbaseModelTestCase extends AbstractModelTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends XbaseParserTest {
    private final ModelChecker expressionChecker;
    
    @Override
    protected XExpression expression(final CharSequence string) throws Exception {
      String _string = string.toString();
      Model _checkModel = this.expressionChecker.<Model>checkModel(_string, false);
      XBlockExpression _block = _checkModel.getBlock();
      EList<XExpression> _expressions = _block.getExpressions();
      return IterableExtensions.<XExpression>head(_expressions);
    }
    
    @Override
    protected XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
      String _string = string.toString();
      Model _checkModel = this.expressionChecker.<Model>checkModel(_string, resolve);
      XBlockExpression _block = _checkModel.getBlock();
      EList<XExpression> _expressions = _block.getExpressions();
      return IterableExtensions.<XExpression>head(_expressions);
    }
    
    public Delegate(final ModelChecker expressionChecker) {
      super();
      this.expressionChecker = expressionChecker;
    }
  }
  
  private XbaseModelTestCase.Delegate delegate;
  
  public XbaseModelTestCase() {
    super(PureXbaseFileType.INSTANCE);
    XbaseModelTestCase.Delegate _delegate = new XbaseModelTestCase.Delegate(this);
    this.delegate = _delegate;
  }
  
  public void testAddition_1() throws Exception {
    delegate.testAddition_1();
  }
  
  public void testAddition_2() throws Exception {
    delegate.testAddition_2();
  }
  
  public void testAssignment_RightAssociativity() throws Exception {
    delegate.testAssignment_RightAssociativity();
  }
  
  public void testAssignments_00() throws Exception {
    delegate.testAssignments_00();
  }
  
  public void testBlockExpression_0() throws Exception {
    delegate.testBlockExpression_0();
  }
  
  public void testBlockExpression_1() throws Exception {
    delegate.testBlockExpression_1();
  }
  
  public void testBlockExpression_2() throws Exception {
    delegate.testBlockExpression_2();
  }
  
  public void testBlockExpression_3() throws Exception {
    delegate.testBlockExpression_3();
  }
  
  public void testBlockExpression_4() throws Exception {
    delegate.testBlockExpression_4();
  }
  
  public void testBlockExpression_5() throws Exception {
    delegate.testBlockExpression_5();
  }
  
  public void testBlockExpression_withVariableDeclaration_0() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_0();
  }
  
  public void testBlockExpression_withVariableDeclaration_1() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_1();
  }
  
  public void testBlockExpression_withVariableDeclaration_2() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_2();
  }
  
  public void testBlockExpression_withVariableDeclaration_3() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_3();
  }
  
  public void testBlockExpression_withVariableDeclaration_4() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_4();
  }
  
  public void testBooleanLiteral_1() throws Exception {
    delegate.testBooleanLiteral_1();
  }
  
  public void testBooleanLiteral_2() throws Exception {
    delegate.testBooleanLiteral_2();
  }
  
  public void testCastedExpression() throws Exception {
    delegate.testCastedExpression();
  }
  
  public void testCastedExpression_1() throws Exception {
    delegate.testCastedExpression_1();
  }
  
  public void testCastedExpression_2() throws Exception {
    delegate.testCastedExpression_2();
  }
  
  public void testClosure_1() throws Exception {
    delegate.testClosure_1();
  }
  
  public void testClosure_2() throws Exception {
    delegate.testClosure_2();
  }
  
  public void testClosure_3() throws Exception {
    delegate.testClosure_3();
  }
  
  public void testClosure_4() throws Exception {
    delegate.testClosure_4();
  }
  
  public void testClosure_5() throws Exception {
    delegate.testClosure_5();
  }
  
  public void testClosure_6() throws Exception {
    delegate.testClosure_6();
  }
  
  public void testConstructorCall_0() throws Exception {
    delegate.testConstructorCall_0();
  }
  
  public void testConstructorCall_1() throws Exception {
    delegate.testConstructorCall_1();
  }
  
  public void testConstructorCall_2() throws Exception {
    delegate.testConstructorCall_2();
  }
  
  public void testDoWhileExpression() throws Exception {
    delegate.testDoWhileExpression();
  }
  
  public void testExclusiveRange() throws Exception {
    delegate.testExclusiveRange();
  }
  
  public void testFeatureCall_0() throws Exception {
    delegate.testFeatureCall_0();
  }
  
  public void testFeatureCall_1() throws Exception {
    delegate.testFeatureCall_1();
  }
  
  public void testFeatureCall_2() throws Exception {
    delegate.testFeatureCall_2();
  }
  
  public void testFeatureCall_3() throws Exception {
    delegate.testFeatureCall_3();
  }
  
  public void testFeatureCall_4() throws Exception {
    delegate.testFeatureCall_4();
  }
  
  public void testFeatureCall_5() throws Exception {
    delegate.testFeatureCall_5();
  }
  
  public void testForLoopExpression() throws Exception {
    delegate.testForLoopExpression();
  }
  
  public void testForLoopExpression_1() throws Exception {
    delegate.testForLoopExpression_1();
  }
  
  public void testIfWithAdd() throws Exception {
    delegate.testIfWithAdd();
  }
  
  public void testIfWithAdd_2() throws Exception {
    delegate.testIfWithAdd_2();
  }
  
  public void testIfWithClosure() throws Exception {
    delegate.testIfWithClosure();
  }
  
  public void testIf_0() throws Exception {
    delegate.testIf_0();
  }
  
  public void testIf_1() throws Exception {
    delegate.testIf_1();
  }
  
  public void testIf_2() throws Exception {
    delegate.testIf_2();
  }
  
  public void testIf_3() throws Exception {
    delegate.testIf_3();
  }
  
  public void testInstanceOf() throws Exception {
    delegate.testInstanceOf();
  }
  
  public void testInstanceOf_1() throws Exception {
    delegate.testInstanceOf_1();
  }
  
  public void testMemberFeatureCall_00() throws Exception {
    delegate.testMemberFeatureCall_00();
  }
  
  public void testMemberFeatureCall_01() throws Exception {
    delegate.testMemberFeatureCall_01();
  }
  
  public void testOrAndAndPrecedence() throws Exception {
    delegate.testOrAndAndPrecedence();
  }
  
  public void testReturnExpressionInBlock_1() throws Exception {
    delegate.testReturnExpressionInBlock_1();
  }
  
  public void testReturnExpressionInBlock_2() throws Exception {
    delegate.testReturnExpressionInBlock_2();
  }
  
  public void testReturnExpressionInBlock_3() throws Exception {
    delegate.testReturnExpressionInBlock_3();
  }
  
  public void testShortClosure_1() throws Exception {
    delegate.testShortClosure_1();
  }
  
  public void testShortClosure_2() throws Exception {
    delegate.testShortClosure_2();
  }
  
  public void testShortClosure_3() throws Exception {
    delegate.testShortClosure_3();
  }
  
  public void testStaticFeatureCall_0() throws Exception {
    delegate.testStaticFeatureCall_0();
  }
  
  public void testStaticFeatureCall_1() throws Exception {
    delegate.testStaticFeatureCall_1();
  }
  
  public void testStaticFeatureCall_2() throws Exception {
    delegate.testStaticFeatureCall_2();
  }
  
  public void testStaticFeatureCall_3() throws Exception {
    delegate.testStaticFeatureCall_3();
  }
  
  public void testStaticFeatureCall_4() throws Exception {
    delegate.testStaticFeatureCall_4();
  }
  
  public void testStaticFeatureCall_5() throws Exception {
    delegate.testStaticFeatureCall_5();
  }
  
  public void testStringLiteral() throws Exception {
    delegate.testStringLiteral();
  }
  
  public void testSwitch_0() throws Exception {
    delegate.testSwitch_0();
  }
  
  public void testSwitch_1() throws Exception {
    delegate.testSwitch_1();
  }
  
  public void testSwitch_2() throws Exception {
    delegate.testSwitch_2();
  }
  
  public void testThrowExpression() throws Exception {
    delegate.testThrowExpression();
  }
  
  public void testTryCatchExpression() throws Exception {
    delegate.testTryCatchExpression();
  }
  
  public void testTryCatchExpression_1() throws Exception {
    delegate.testTryCatchExpression_1();
  }
  
  public void testTryCatchExpression_2() throws Exception {
    delegate.testTryCatchExpression_2();
  }
  
  public void testTryCatchExpression_3() throws Exception {
    delegate.testTryCatchExpression_3();
  }
  
  public void testTypeLiteral() throws Exception {
    delegate.testTypeLiteral();
  }
  
  public void testUnaryOperation() throws Exception {
    delegate.testUnaryOperation();
  }
  
  public void testUnaryOperation_2() throws Exception {
    delegate.testUnaryOperation_2();
  }
  
  public void testUnaryOperation_3() throws Exception {
    delegate.testUnaryOperation_3();
  }
  
  public void testWhileExpression() throws Exception {
    delegate.testWhileExpression();
  }
}
