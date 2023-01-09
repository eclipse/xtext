/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class XbaseGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class XExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XExpression");
		private final RuleCall cXAssignmentParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//XExpression returns XExpression :
		//    XAssignment;
		@Override public ParserRule getRule() { return rule; }
		
		//XAssignment
		public RuleCall getXAssignmentParserRuleCall() { return cXAssignmentParserRuleCall; }
	}
	public class XAssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XAssignment");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cXAssignmentAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cFeatureAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_0_1_0 = (CrossReference)cFeatureAssignment_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_0_1_0.eContents().get(1);
		private final RuleCall cOpSingleAssignParserRuleCall_0_2 = (RuleCall)cGroup_0.eContents().get(2);
		private final Assignment cValueAssignment_0_3 = (Assignment)cGroup_0.eContents().get(3);
		private final RuleCall cValueXAssignmentParserRuleCall_0_3_0 = (RuleCall)cValueAssignment_0_3.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final RuleCall cXOrExpressionParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_0_0 = (Group)cGroup_1_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_1_0_0_0 = (Action)cGroup_1_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_1_0_0_1 = (Assignment)cGroup_1_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cRightOperandXAssignmentParserRuleCall_1_1_1_0 = (RuleCall)cRightOperandAssignment_1_1_1.eContents().get(0);
		
		//XAssignment returns XExpression :
		//    {XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
		//    XOrExpression (
		//        =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//    )?;
		@Override public ParserRule getRule() { return rule; }
		
		//{XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
		//XOrExpression (
		//    =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//)?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment
		public Group getGroup_0() { return cGroup_0; }
		
		//{XAssignment}
		public Action getXAssignmentAction_0_0() { return cXAssignmentAction_0_0; }
		
		//feature=[types::JvmIdentifiableElement|FeatureCallID]
		public Assignment getFeatureAssignment_0_1() { return cFeatureAssignment_0_1; }
		
		//[types::JvmIdentifiableElement|FeatureCallID]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_0_1_0; }
		
		//FeatureCallID
		public RuleCall getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1() { return cFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_0_1_0_1; }
		
		//OpSingleAssign
		public RuleCall getOpSingleAssignParserRuleCall_0_2() { return cOpSingleAssignParserRuleCall_0_2; }
		
		//value=XAssignment
		public Assignment getValueAssignment_0_3() { return cValueAssignment_0_3; }
		
		//XAssignment
		public RuleCall getValueXAssignmentParserRuleCall_0_3_0() { return cValueXAssignmentParserRuleCall_0_3_0; }
		
		//XOrExpression (
		//    =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//)?
		public Group getGroup_1() { return cGroup_1; }
		
		//XOrExpression
		public RuleCall getXOrExpressionParserRuleCall_1_0() { return cXOrExpressionParserRuleCall_1_0; }
		
		//(
		//       =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
		//   )?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign])
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]
		public Group getGroup_1_1_0_0() { return cGroup_1_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpMultiAssign]
		public Assignment getFeatureAssignment_1_1_0_0_1() { return cFeatureAssignment_1_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpMultiAssign]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0; }
		
		//OpMultiAssign
		public RuleCall getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1; }
		
		//rightOperand=XAssignment
		public Assignment getRightOperandAssignment_1_1_1() { return cRightOperandAssignment_1_1_1; }
		
		//XAssignment
		public RuleCall getRightOperandXAssignmentParserRuleCall_1_1_1_0() { return cRightOperandXAssignmentParserRuleCall_1_1_1_0; }
	}
	public class OpSingleAssignElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpSingleAssign");
		private final Keyword cEqualsSignKeyword = (Keyword)rule.eContents().get(1);
		
		//OpSingleAssign:
		//    '='
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'='
		public Keyword getEqualsSignKeyword() { return cEqualsSignKeyword; }
	}
	public class OpMultiAssignElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpMultiAssign");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cAsteriskEqualsSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cSolidusEqualsSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cPercentSignEqualsSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cLessThanSignKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cLessThanSignKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Keyword cEqualsSignKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Group cGroup_6 = (Group)cAlternatives.eContents().get(6);
		private final Keyword cGreaterThanSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Keyword cGreaterThanSignEqualsSignKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		
		//OpMultiAssign:
		//    '+=' | '-=' | '*=' | '/=' | '%=' |
		//    '<' '<' '=' |
		//    '>' '>'? '>=';
		@Override public ParserRule getRule() { return rule; }
		
		//'+=' | '-=' | '*=' | '/=' | '%=' |
		//'<' '<' '=' |
		//'>' '>'? '>='
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'+='
		public Keyword getPlusSignEqualsSignKeyword_0() { return cPlusSignEqualsSignKeyword_0; }
		
		//'-='
		public Keyword getHyphenMinusEqualsSignKeyword_1() { return cHyphenMinusEqualsSignKeyword_1; }
		
		//'*='
		public Keyword getAsteriskEqualsSignKeyword_2() { return cAsteriskEqualsSignKeyword_2; }
		
		//'/='
		public Keyword getSolidusEqualsSignKeyword_3() { return cSolidusEqualsSignKeyword_3; }
		
		//'%='
		public Keyword getPercentSignEqualsSignKeyword_4() { return cPercentSignEqualsSignKeyword_4; }
		
		//'<' '<' '='
		public Group getGroup_5() { return cGroup_5; }
		
		//'<'
		public Keyword getLessThanSignKeyword_5_0() { return cLessThanSignKeyword_5_0; }
		
		//'<'
		public Keyword getLessThanSignKeyword_5_1() { return cLessThanSignKeyword_5_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_5_2() { return cEqualsSignKeyword_5_2; }
		
		//'>' '>'? '>='
		public Group getGroup_6() { return cGroup_6; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_6_0() { return cGreaterThanSignKeyword_6_0; }
		
		//'>'?
		public Keyword getGreaterThanSignKeyword_6_1() { return cGreaterThanSignKeyword_6_1; }
		
		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_6_2() { return cGreaterThanSignEqualsSignKeyword_6_2; }
	}
	public class XOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandXAndExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//XOrExpression returns XExpression:
		//    XAndExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr]) rightOperand=XAndExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XAndExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr]) rightOperand=XAndExpression)*
		public Group getGroup() { return cGroup; }
		
		//XAndExpression
		public RuleCall getXAndExpressionParserRuleCall_0() { return cXAndExpressionParserRuleCall_0; }
		
		//(=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr]) rightOperand=XAndExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr])
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr]
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpOr]
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpOr]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0; }
		
		//OpOr
		public RuleCall getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1; }
		
		//rightOperand=XAndExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }
		
		//XAndExpression
		public RuleCall getRightOperandXAndExpressionParserRuleCall_1_1_0() { return cRightOperandXAndExpressionParserRuleCall_1_1_0; }
	}
	public class OpOrElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpOr");
		private final Keyword cVerticalLineVerticalLineKeyword = (Keyword)rule.eContents().get(1);
		
		//OpOr:
		//    '||';
		@Override public ParserRule getRule() { return rule; }
		
		//'||'
		public Keyword getVerticalLineVerticalLineKeyword() { return cVerticalLineVerticalLineKeyword; }
	}
	public class XAndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XAndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXEqualityExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandXEqualityExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//XAndExpression returns XExpression:
		//    XEqualityExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd]) rightOperand=XEqualityExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XEqualityExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd]) rightOperand=XEqualityExpression)*
		public Group getGroup() { return cGroup; }
		
		//XEqualityExpression
		public RuleCall getXEqualityExpressionParserRuleCall_0() { return cXEqualityExpressionParserRuleCall_0; }
		
		//(=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd]) rightOperand=XEqualityExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd])
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd]
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpAnd]
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpAnd]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0; }
		
		//OpAnd
		public RuleCall getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1; }
		
		//rightOperand=XEqualityExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }
		
		//XEqualityExpression
		public RuleCall getRightOperandXEqualityExpressionParserRuleCall_1_1_0() { return cRightOperandXEqualityExpressionParserRuleCall_1_1_0; }
	}
	public class OpAndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpAnd");
		private final Keyword cAmpersandAmpersandKeyword = (Keyword)rule.eContents().get(1);
		
		//OpAnd:
		//    '&&';
		@Override public ParserRule getRule() { return rule; }
		
		//'&&'
		public Keyword getAmpersandAmpersandKeyword() { return cAmpersandAmpersandKeyword; }
	}
	public class XEqualityExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXRelationalExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandXRelationalExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//XEqualityExpression returns XExpression:
		//    XRelationalExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
		//    rightOperand=XRelationalExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XRelationalExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
		//rightOperand=XRelationalExpression)*
		public Group getGroup() { return cGroup; }
		
		//XRelationalExpression
		public RuleCall getXRelationalExpressionParserRuleCall_0() { return cXRelationalExpressionParserRuleCall_0; }
		
		//(=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
		//   rightOperand=XRelationalExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality]
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpEquality]
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpEquality]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0; }
		
		//OpEquality
		public RuleCall getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1; }
		
		//rightOperand=XRelationalExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }
		
		//XRelationalExpression
		public RuleCall getRightOperandXRelationalExpressionParserRuleCall_1_1_0() { return cRightOperandXRelationalExpressionParserRuleCall_1_1_0; }
	}
	public class OpEqualityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpEquality");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cEqualsSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cExclamationMarkEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cEqualsSignEqualsSignEqualsSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cExclamationMarkEqualsSignEqualsSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpEquality:
		//    '==' | '!=' | '===' | '!==';
		@Override public ParserRule getRule() { return rule; }
		
		//'==' | '!=' | '===' | '!=='
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'=='
		public Keyword getEqualsSignEqualsSignKeyword_0() { return cEqualsSignEqualsSignKeyword_0; }
		
		//'!='
		public Keyword getExclamationMarkEqualsSignKeyword_1() { return cExclamationMarkEqualsSignKeyword_1; }
		
		//'==='
		public Keyword getEqualsSignEqualsSignEqualsSignKeyword_2() { return cEqualsSignEqualsSignEqualsSignKeyword_2; }
		
		//'!=='
		public Keyword getExclamationMarkEqualsSignEqualsSignKeyword_3() { return cExclamationMarkEqualsSignEqualsSignKeyword_3; }
	}
	public class XRelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXOtherOperatorExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Group cGroup_1_0_0_0 = (Group)cGroup_1_0_0.eContents().get(0);
		private final Action cXInstanceOfExpressionExpressionAction_1_0_0_0_0 = (Action)cGroup_1_0_0_0.eContents().get(0);
		private final Keyword cInstanceofKeyword_1_0_0_0_1 = (Keyword)cGroup_1_0_0_0.eContents().get(1);
		private final Assignment cTypeAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_1_0_1_0 = (RuleCall)cTypeAssignment_1_0_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_0_0 = (Group)cGroup_1_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_1_0_0_0 = (Action)cGroup_1_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_1_0_0_1 = (Assignment)cGroup_1_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0 = (RuleCall)cRightOperandAssignment_1_1_1.eContents().get(0);
		
		//XRelationalExpression returns XExpression:
		//    XOtherOperatorExpression
		//    (=>({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
		//     =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]) rightOperand=XOtherOperatorExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XOtherOperatorExpression
		//(=>({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
		// =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]) rightOperand=XOtherOperatorExpression)*
		public Group getGroup() { return cGroup; }
		
		//XOtherOperatorExpression
		public RuleCall getXOtherOperatorExpressionParserRuleCall_0() { return cXOtherOperatorExpressionParserRuleCall_0; }
		
		//(=>({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
		// =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]) rightOperand=XOtherOperatorExpression)*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//=>({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//=>({XInstanceOfExpression.expression=current} 'instanceof')
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XInstanceOfExpression.expression=current} 'instanceof'
		public Group getGroup_1_0_0_0() { return cGroup_1_0_0_0; }
		
		//{XInstanceOfExpression.expression=current}
		public Action getXInstanceOfExpressionExpressionAction_1_0_0_0_0() { return cXInstanceOfExpressionExpressionAction_1_0_0_0_0; }
		
		//'instanceof'
		public Keyword getInstanceofKeyword_1_0_0_0_1() { return cInstanceofKeyword_1_0_0_0_1; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_1_0_1() { return cTypeAssignment_1_0_1; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_1_0_1_0() { return cTypeJvmTypeReferenceParserRuleCall_1_0_1_0; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]) rightOperand=XOtherOperatorExpression
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare])
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]
		public Group getGroup_1_1_0_0() { return cGroup_1_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpCompare]
		public Assignment getFeatureAssignment_1_1_0_0_1() { return cFeatureAssignment_1_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpCompare]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0; }
		
		//OpCompare
		public RuleCall getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1; }
		
		//rightOperand=XOtherOperatorExpression
		public Assignment getRightOperandAssignment_1_1_1() { return cRightOperandAssignment_1_1_1; }
		
		//XOtherOperatorExpression
		public RuleCall getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0() { return cRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0; }
	}
	public class OpCompareElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpCompare");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cGreaterThanSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cLessThanSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpCompare:
		//    '>=' | '<' '=' | '>' | '<' ;
		@Override public ParserRule getRule() { return rule; }
		
		//'>=' | '<' '=' | '>' | '<'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_0() { return cGreaterThanSignEqualsSignKeyword_0; }
		
		//'<' '='
		public Group getGroup_1() { return cGroup_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_1_1() { return cEqualsSignKeyword_1_1; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2() { return cGreaterThanSignKeyword_2; }
		
		//'<'
		public Keyword getLessThanSignKeyword_3() { return cLessThanSignKeyword_3; }
	}
	public class XOtherOperatorExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXAdditiveExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandXAdditiveExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//XOtherOperatorExpression returns XExpression:
		//    XAdditiveExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
		//    rightOperand=XAdditiveExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XAdditiveExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
		//rightOperand=XAdditiveExpression)*
		public Group getGroup() { return cGroup; }
		
		//XAdditiveExpression
		public RuleCall getXAdditiveExpressionParserRuleCall_0() { return cXAdditiveExpressionParserRuleCall_0; }
		
		//(=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
		//   rightOperand=XAdditiveExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther]
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpOther]
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpOther]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0; }
		
		//OpOther
		public RuleCall getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1; }
		
		//rightOperand=XAdditiveExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }
		
		//XAdditiveExpression
		public RuleCall getRightOperandXAdditiveExpressionParserRuleCall_1_1_0() { return cRightOperandXAdditiveExpressionParserRuleCall_1_1_0; }
	}
	public class OpOtherElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpOther");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cFullStopFullStopLessThanSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cGreaterThanSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cEqualsSignGreaterThanSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cGreaterThanSignKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Alternatives cAlternatives_5_1 = (Alternatives)cGroup_5.eContents().get(1);
		private final Group cGroup_5_1_0 = (Group)cAlternatives_5_1.eContents().get(0);
		private final Group cGroup_5_1_0_0 = (Group)cGroup_5_1_0.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_5_1_0_0_0 = (Keyword)cGroup_5_1_0_0.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_5_1_0_0_1 = (Keyword)cGroup_5_1_0_0.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_5_1_1 = (Keyword)cAlternatives_5_1.eContents().get(1);
		private final Group cGroup_6 = (Group)cAlternatives.eContents().get(6);
		private final Keyword cLessThanSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Alternatives cAlternatives_6_1 = (Alternatives)cGroup_6.eContents().get(1);
		private final Group cGroup_6_1_0 = (Group)cAlternatives_6_1.eContents().get(0);
		private final Group cGroup_6_1_0_0 = (Group)cGroup_6_1_0.eContents().get(0);
		private final Keyword cLessThanSignKeyword_6_1_0_0_0 = (Keyword)cGroup_6_1_0_0.eContents().get(0);
		private final Keyword cLessThanSignKeyword_6_1_0_0_1 = (Keyword)cGroup_6_1_0_0.eContents().get(1);
		private final Keyword cLessThanSignKeyword_6_1_1 = (Keyword)cAlternatives_6_1.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_6_1_2 = (Keyword)cAlternatives_6_1.eContents().get(2);
		private final Keyword cLessThanSignGreaterThanSignKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cQuestionMarkColonKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		
		//OpOther:
		//      '->'
		//    | '..<'
		//    | '>' '..'
		//    | '..'
		//    | '=>'
		//    | '>' (=>('>' '>') | '>')
		//    | '<' (=>('<' '<') | '<' | '=>')
		//    | '<>'
		//    | '?:';
		@Override public ParserRule getRule() { return rule; }
		
		//  '->'
		//| '..<'
		//| '>' '..'
		//| '..'
		//| '=>'
		//| '>' (=>('>' '>') | '>')
		//| '<' (=>('<' '<') | '<' | '=>')
		//| '<>'
		//| '?:'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }
		
		//'..<'
		public Keyword getFullStopFullStopLessThanSignKeyword_1() { return cFullStopFullStopLessThanSignKeyword_1; }
		
		//'>' '..'
		public Group getGroup_2() { return cGroup_2; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2_0() { return cGreaterThanSignKeyword_2_0; }
		
		//'..'
		public Keyword getFullStopFullStopKeyword_2_1() { return cFullStopFullStopKeyword_2_1; }
		
		//'..'
		public Keyword getFullStopFullStopKeyword_3() { return cFullStopFullStopKeyword_3; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_4() { return cEqualsSignGreaterThanSignKeyword_4; }
		
		//'>' (=>('>' '>') | '>')
		public Group getGroup_5() { return cGroup_5; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_5_0() { return cGreaterThanSignKeyword_5_0; }
		
		//(=>('>' '>') | '>')
		public Alternatives getAlternatives_5_1() { return cAlternatives_5_1; }
		
		//=>('>' '>')
		public Group getGroup_5_1_0() { return cGroup_5_1_0; }
		
		//'>' '>'
		public Group getGroup_5_1_0_0() { return cGroup_5_1_0_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_5_1_0_0_0() { return cGreaterThanSignKeyword_5_1_0_0_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_5_1_0_0_1() { return cGreaterThanSignKeyword_5_1_0_0_1; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_5_1_1() { return cGreaterThanSignKeyword_5_1_1; }
		
		//'<' (=>('<' '<') | '<' | '=>')
		public Group getGroup_6() { return cGroup_6; }
		
		//'<'
		public Keyword getLessThanSignKeyword_6_0() { return cLessThanSignKeyword_6_0; }
		
		//(=>('<' '<') | '<' | '=>')
		public Alternatives getAlternatives_6_1() { return cAlternatives_6_1; }
		
		//=>('<' '<')
		public Group getGroup_6_1_0() { return cGroup_6_1_0; }
		
		//'<' '<'
		public Group getGroup_6_1_0_0() { return cGroup_6_1_0_0; }
		
		//'<'
		public Keyword getLessThanSignKeyword_6_1_0_0_0() { return cLessThanSignKeyword_6_1_0_0_0; }
		
		//'<'
		public Keyword getLessThanSignKeyword_6_1_0_0_1() { return cLessThanSignKeyword_6_1_0_0_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_6_1_1() { return cLessThanSignKeyword_6_1_1; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_6_1_2() { return cEqualsSignGreaterThanSignKeyword_6_1_2; }
		
		//'<>'
		public Keyword getLessThanSignGreaterThanSignKeyword_7() { return cLessThanSignGreaterThanSignKeyword_7; }
		
		//'?:'
		public Keyword getQuestionMarkColonKeyword_8() { return cQuestionMarkColonKeyword_8; }
	}
	public class XAdditiveExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXMultiplicativeExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//XAdditiveExpression returns XExpression:
		//    XMultiplicativeExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
		//    rightOperand=XMultiplicativeExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XMultiplicativeExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
		//rightOperand=XMultiplicativeExpression)*
		public Group getGroup() { return cGroup; }
		
		//XMultiplicativeExpression
		public RuleCall getXMultiplicativeExpressionParserRuleCall_0() { return cXMultiplicativeExpressionParserRuleCall_0; }
		
		//(=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
		//   rightOperand=XMultiplicativeExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd]
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpAdd]
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpAdd]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0; }
		
		//OpAdd
		public RuleCall getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1; }
		
		//rightOperand=XMultiplicativeExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }
		
		//XMultiplicativeExpression
		public RuleCall getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0() { return cRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0; }
	}
	public class OpAddElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpAdd");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpAdd:
		//    '+' | '-';
		@Override public ParserRule getRule() { return rule; }
		
		//'+' | '-'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'+'
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
	}
	public class XMultiplicativeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXUnaryOperationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXBinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0 = (CrossReference)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0.eContents().get(1);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandXUnaryOperationParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//XMultiplicativeExpression returns XExpression:
		//    XUnaryOperation (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti]) rightOperand=XUnaryOperation)*;
		@Override public ParserRule getRule() { return rule; }
		
		//XUnaryOperation (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti]) rightOperand=XUnaryOperation)*
		public Group getGroup() { return cGroup; }
		
		//XUnaryOperation
		public RuleCall getXUnaryOperationParserRuleCall_0() { return cXUnaryOperationParserRuleCall_0; }
		
		//(=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti]) rightOperand=XUnaryOperation)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti])
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti]
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XBinaryOperation.leftOperand=current}
		public Action getXBinaryOperationLeftOperandAction_1_0_0_0() { return cXBinaryOperationLeftOperandAction_1_0_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpMulti]
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }
		
		//[types::JvmIdentifiableElement|OpMulti]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0; }
		
		//OpMulti
		public RuleCall getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1() { return cFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1; }
		
		//rightOperand=XUnaryOperation
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }
		
		//XUnaryOperation
		public RuleCall getRightOperandXUnaryOperationParserRuleCall_1_1_0() { return cRightOperandXUnaryOperationParserRuleCall_1_1_0; }
	}
	public class OpMultiElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpMulti");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsteriskKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAsteriskAsteriskKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cSolidusKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cPercentSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpMulti:
		//    '*' | '**' | '/' | '%';
		@Override public ParserRule getRule() { return rule; }
		
		//'*' | '**' | '/' | '%'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'*'
		public Keyword getAsteriskKeyword_0() { return cAsteriskKeyword_0; }
		
		//'**'
		public Keyword getAsteriskAsteriskKeyword_1() { return cAsteriskAsteriskKeyword_1; }
		
		//'/'
		public Keyword getSolidusKeyword_2() { return cSolidusKeyword_2; }
		
		//'%'
		public Keyword getPercentSignKeyword_3() { return cPercentSignKeyword_3; }
	}
	public class XUnaryOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cXUnaryOperationAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cFeatureAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_0_1_0 = (CrossReference)cFeatureAssignment_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_0_1_0.eContents().get(1);
		private final Assignment cOperandAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOperandXUnaryOperationParserRuleCall_0_2_0 = (RuleCall)cOperandAssignment_0_2.eContents().get(0);
		private final RuleCall cXCastedExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//XUnaryOperation returns XExpression:
		//    {XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
		//    | XCastedExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//{XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
		//| XCastedExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
		public Group getGroup_0() { return cGroup_0; }
		
		//{XUnaryOperation}
		public Action getXUnaryOperationAction_0_0() { return cXUnaryOperationAction_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpUnary]
		public Assignment getFeatureAssignment_0_1() { return cFeatureAssignment_0_1; }
		
		//[types::JvmIdentifiableElement|OpUnary]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_0_1_0; }
		
		//OpUnary
		public RuleCall getFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1() { return cFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1; }
		
		//operand=XUnaryOperation
		public Assignment getOperandAssignment_0_2() { return cOperandAssignment_0_2; }
		
		//XUnaryOperation
		public RuleCall getOperandXUnaryOperationParserRuleCall_0_2_0() { return cOperandXUnaryOperationParserRuleCall_0_2_0; }
		
		//XCastedExpression
		public RuleCall getXCastedExpressionParserRuleCall_1() { return cXCastedExpressionParserRuleCall_1; }
	}
	public class OpUnaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpUnary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cExclamationMarkKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cPlusSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//OpUnary:
		//    "!" | "-" | "+";
		@Override public ParserRule getRule() { return rule; }
		
		//"!" | "-" | "+"
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//"!"
		public Keyword getExclamationMarkKeyword_0() { return cExclamationMarkKeyword_0; }
		
		//"-"
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
		
		//"+"
		public Keyword getPlusSignKeyword_2() { return cPlusSignKeyword_2; }
	}
	public class XCastedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XCastedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXPostfixOperationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cXCastedExpressionTargetAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cAsKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cTypeAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_1_1_0 = (RuleCall)cTypeAssignment_1_1.eContents().get(0);
		
		//XCastedExpression returns XExpression:
		//    XPostfixOperation (=>({XCastedExpression.target=current} 'as') type=JvmTypeReference)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XPostfixOperation (=>({XCastedExpression.target=current} 'as') type=JvmTypeReference)*
		public Group getGroup() { return cGroup; }
		
		//XPostfixOperation
		public RuleCall getXPostfixOperationParserRuleCall_0() { return cXPostfixOperationParserRuleCall_0; }
		
		//(=>({XCastedExpression.target=current} 'as') type=JvmTypeReference)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>({XCastedExpression.target=current} 'as')
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XCastedExpression.target=current} 'as'
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XCastedExpression.target=current}
		public Action getXCastedExpressionTargetAction_1_0_0_0() { return cXCastedExpressionTargetAction_1_0_0_0; }
		
		//'as'
		public Keyword getAsKeyword_1_0_0_1() { return cAsKeyword_1_0_0_1; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_1_1() { return cTypeAssignment_1_1; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_1_1_0() { return cTypeJvmTypeReferenceParserRuleCall_1_1_0; }
	}
	public class XPostfixOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XPostfixOperation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXMemberFeatureCallParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cXPostfixOperationOperandAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_1_0 = (CrossReference)cFeatureAssignment_1_0_1.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_1_0.eContents().get(1);
		
		//XPostfixOperation returns XExpression:
		//    XMemberFeatureCall =>({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XMemberFeatureCall =>({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?
		public Group getGroup() { return cGroup; }
		
		//XMemberFeatureCall
		public RuleCall getXMemberFeatureCallParserRuleCall_0() { return cXMemberFeatureCallParserRuleCall_0; }
		
		//=>({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?
		public Group getGroup_1() { return cGroup_1; }
		
		//{XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix]
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{XPostfixOperation.operand=current}
		public Action getXPostfixOperationOperandAction_1_0_0() { return cXPostfixOperationOperandAction_1_0_0; }
		
		//feature=[types::JvmIdentifiableElement|OpPostfix]
		public Assignment getFeatureAssignment_1_0_1() { return cFeatureAssignment_1_0_1; }
		
		//[types::JvmIdentifiableElement|OpPostfix]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_1_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_1_0; }
		
		//OpPostfix
		public RuleCall getFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1() { return cFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1; }
	}
	public class OpPostfixElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.OpPostfix");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpPostfix:
		//    "++" | "--"
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//"++" | "--"
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//"++"
		public Keyword getPlusSignPlusSignKeyword_0() { return cPlusSignPlusSignKeyword_0; }
		
		//"--"
		public Keyword getHyphenMinusHyphenMinusKeyword_1() { return cHyphenMinusHyphenMinusKeyword_1; }
	}
	public class XMemberFeatureCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XMemberFeatureCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cXPrimaryExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Group cGroup_1_0_0_0 = (Group)cGroup_1_0_0.eContents().get(0);
		private final Action cXAssignmentAssignableAction_1_0_0_0_0 = (Action)cGroup_1_0_0_0.eContents().get(0);
		private final Alternatives cAlternatives_1_0_0_0_1 = (Alternatives)cGroup_1_0_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0_0_0_1_0 = (Keyword)cAlternatives_1_0_0_0_1.eContents().get(0);
		private final Assignment cExplicitStaticAssignment_1_0_0_0_1_1 = (Assignment)cAlternatives_1_0_0_0_1.eContents().get(1);
		private final Keyword cExplicitStaticColonColonKeyword_1_0_0_0_1_1_0 = (Keyword)cExplicitStaticAssignment_1_0_0_0_1_1.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_0_2 = (Assignment)cGroup_1_0_0_0.eContents().get(2);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0 = (CrossReference)cFeatureAssignment_1_0_0_0_2.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0.eContents().get(1);
		private final RuleCall cOpSingleAssignParserRuleCall_1_0_0_0_3 = (RuleCall)cGroup_1_0_0_0.eContents().get(3);
		private final Assignment cValueAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cValueXAssignmentParserRuleCall_1_0_1_0 = (RuleCall)cValueAssignment_1_0_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_0_0 = (Group)cGroup_1_1_0.eContents().get(0);
		private final Action cXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0 = (Action)cGroup_1_1_0_0.eContents().get(0);
		private final Alternatives cAlternatives_1_1_0_0_1 = (Alternatives)cGroup_1_1_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1_1_0_0_1_0 = (Keyword)cAlternatives_1_1_0_0_1.eContents().get(0);
		private final Assignment cNullSafeAssignment_1_1_0_0_1_1 = (Assignment)cAlternatives_1_1_0_0_1.eContents().get(1);
		private final Keyword cNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0 = (Keyword)cNullSafeAssignment_1_1_0_0_1_1.eContents().get(0);
		private final Assignment cExplicitStaticAssignment_1_1_0_0_1_2 = (Assignment)cAlternatives_1_1_0_0_1.eContents().get(2);
		private final Keyword cExplicitStaticColonColonKeyword_1_1_0_0_1_2_0 = (Keyword)cExplicitStaticAssignment_1_1_0_0_1_2.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cGroup_1_1.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_1_1_0 = (Keyword)cGroup_1_1_1.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_1_1_1_1 = (Assignment)cGroup_1_1_1.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0 = (RuleCall)cTypeArgumentsAssignment_1_1_1_1.eContents().get(0);
		private final Group cGroup_1_1_1_2 = (Group)cGroup_1_1_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_1_1_2_0 = (Keyword)cGroup_1_1_1_2.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_1_1_1_2_1 = (Assignment)cGroup_1_1_1_2.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0 = (RuleCall)cTypeArgumentsAssignment_1_1_1_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_1_1_3 = (Keyword)cGroup_1_1_1.eContents().get(3);
		private final Assignment cFeatureAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_1_1_2_0 = (CrossReference)cFeatureAssignment_1_1_2.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_1_1_2_0.eContents().get(1);
		private final Group cGroup_1_1_3 = (Group)cGroup_1_1.eContents().get(3);
		private final Assignment cExplicitOperationCallAssignment_1_1_3_0 = (Assignment)cGroup_1_1_3.eContents().get(0);
		private final Keyword cExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0 = (Keyword)cExplicitOperationCallAssignment_1_1_3_0.eContents().get(0);
		private final Alternatives cAlternatives_1_1_3_1 = (Alternatives)cGroup_1_1_3.eContents().get(1);
		private final Assignment cMemberCallArgumentsAssignment_1_1_3_1_0 = (Assignment)cAlternatives_1_1_3_1.eContents().get(0);
		private final RuleCall cMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0 = (RuleCall)cMemberCallArgumentsAssignment_1_1_3_1_0.eContents().get(0);
		private final Group cGroup_1_1_3_1_1 = (Group)cAlternatives_1_1_3_1.eContents().get(1);
		private final Assignment cMemberCallArgumentsAssignment_1_1_3_1_1_0 = (Assignment)cGroup_1_1_3_1_1.eContents().get(0);
		private final RuleCall cMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0 = (RuleCall)cMemberCallArgumentsAssignment_1_1_3_1_1_0.eContents().get(0);
		private final Group cGroup_1_1_3_1_1_1 = (Group)cGroup_1_1_3_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_1_3_1_1_1_0 = (Keyword)cGroup_1_1_3_1_1_1.eContents().get(0);
		private final Assignment cMemberCallArgumentsAssignment_1_1_3_1_1_1_1 = (Assignment)cGroup_1_1_3_1_1_1.eContents().get(1);
		private final RuleCall cMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0 = (RuleCall)cMemberCallArgumentsAssignment_1_1_3_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_3_2 = (Keyword)cGroup_1_1_3.eContents().get(2);
		private final Assignment cMemberCallArgumentsAssignment_1_1_4 = (Assignment)cGroup_1_1.eContents().get(4);
		private final RuleCall cMemberCallArgumentsXClosureParserRuleCall_1_1_4_0 = (RuleCall)cMemberCallArgumentsAssignment_1_1_4.eContents().get(0);
		
		//XMemberFeatureCall returns XExpression:
		//    XPrimaryExpression
		//    (=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
		//    |=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
		//        ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//        feature=[types::JvmIdentifiableElement|IdOrSuper] (
		//            =>explicitOperationCall?='('
		//                (
		//                    memberCallArguments+=XShortClosure
		//                  | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		//                )?
		//            ')')?
		//            memberCallArguments+=XClosure?
		//        )*;
		@Override public ParserRule getRule() { return rule; }
		
		//XPrimaryExpression
		//(=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
		//|=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
		//    ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//    feature=[types::JvmIdentifiableElement|IdOrSuper] (
		//        =>explicitOperationCall?='('
		//            (
		//                memberCallArguments+=XShortClosure
		//              | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		//            )?
		//        ')')?
		//        memberCallArguments+=XClosure?
		//    )*
		public Group getGroup() { return cGroup; }
		
		//XPrimaryExpression
		public RuleCall getXPrimaryExpressionParserRuleCall_0() { return cXPrimaryExpressionParserRuleCall_0; }
		
		//(=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
		//|=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
		//    ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//    feature=[types::JvmIdentifiableElement|IdOrSuper] (
		//        =>explicitOperationCall?='('
		//            (
		//                memberCallArguments+=XShortClosure
		//              | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		//            )?
		//        ')')?
		//        memberCallArguments+=XClosure?
		//    )*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign
		public Group getGroup_1_0_0_0() { return cGroup_1_0_0_0; }
		
		//{XAssignment.assignable=current}
		public Action getXAssignmentAssignableAction_1_0_0_0_0() { return cXAssignmentAssignableAction_1_0_0_0_0; }
		
		//('.'|explicitStatic?="::")
		public Alternatives getAlternatives_1_0_0_0_1() { return cAlternatives_1_0_0_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0_0_0_1_0() { return cFullStopKeyword_1_0_0_0_1_0; }
		
		//explicitStatic?="::"
		public Assignment getExplicitStaticAssignment_1_0_0_0_1_1() { return cExplicitStaticAssignment_1_0_0_0_1_1; }
		
		//"::"
		public Keyword getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0() { return cExplicitStaticColonColonKeyword_1_0_0_0_1_1_0; }
		
		//feature=[types::JvmIdentifiableElement|FeatureCallID]
		public Assignment getFeatureAssignment_1_0_0_0_2() { return cFeatureAssignment_1_0_0_0_2; }
		
		//[types::JvmIdentifiableElement|FeatureCallID]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0() { return cFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0; }
		
		//FeatureCallID
		public RuleCall getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1() { return cFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_0_0_0_2_0_1; }
		
		//OpSingleAssign
		public RuleCall getOpSingleAssignParserRuleCall_1_0_0_0_3() { return cOpSingleAssignParserRuleCall_1_0_0_0_3; }
		
		//value=XAssignment
		public Assignment getValueAssignment_1_0_1() { return cValueAssignment_1_0_1; }
		
		//XAssignment
		public RuleCall getValueXAssignmentParserRuleCall_1_0_1_0() { return cValueXAssignmentParserRuleCall_1_0_1_0; }
		
		//=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
		//        ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//        feature=[types::JvmIdentifiableElement|IdOrSuper] (
		//            =>explicitOperationCall?='('
		//                (
		//                    memberCallArguments+=XShortClosure
		//                  | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		//                )?
		//            ')')?
		//            memberCallArguments+=XClosure?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }
		
		//{XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::")
		public Group getGroup_1_1_0_0() { return cGroup_1_1_0_0; }
		
		//{XMemberFeatureCall.memberCallTarget=current}
		public Action getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0() { return cXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0; }
		
		//("."|nullSafe?="?."|explicitStatic?="::")
		public Alternatives getAlternatives_1_1_0_0_1() { return cAlternatives_1_1_0_0_1; }
		
		//"."
		public Keyword getFullStopKeyword_1_1_0_0_1_0() { return cFullStopKeyword_1_1_0_0_1_0; }
		
		//nullSafe?="?."
		public Assignment getNullSafeAssignment_1_1_0_0_1_1() { return cNullSafeAssignment_1_1_0_0_1_1; }
		
		//"?."
		public Keyword getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0() { return cNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0; }
		
		//explicitStatic?="::"
		public Assignment getExplicitStaticAssignment_1_1_0_0_1_2() { return cExplicitStaticAssignment_1_1_0_0_1_2; }
		
		//"::"
		public Keyword getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0() { return cExplicitStaticColonColonKeyword_1_1_0_0_1_2_0; }
		
		//('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_1_1_0() { return cLessThanSignKeyword_1_1_1_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_1_1_1_1() { return cTypeArgumentsAssignment_1_1_1_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0; }
		
		//(',' typeArguments+=JvmArgumentTypeReference)*
		public Group getGroup_1_1_1_2() { return cGroup_1_1_1_2; }
		
		//','
		public Keyword getCommaKeyword_1_1_1_2_0() { return cCommaKeyword_1_1_1_2_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_1_1_1_2_1() { return cTypeArgumentsAssignment_1_1_1_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_1_1_3() { return cGreaterThanSignKeyword_1_1_1_3; }
		
		//feature=[types::JvmIdentifiableElement|IdOrSuper]
		public Assignment getFeatureAssignment_1_1_2() { return cFeatureAssignment_1_1_2; }
		
		//[types::JvmIdentifiableElement|IdOrSuper]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_1_1_2_0() { return cFeatureJvmIdentifiableElementCrossReference_1_1_2_0; }
		
		//IdOrSuper
		public RuleCall getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1() { return cFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_1_1_2_0_1; }
		
		//(
		//           =>explicitOperationCall?='('
		//               (
		//                   memberCallArguments+=XShortClosure
		//                 | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		//               )?
		//           ')')?
		public Group getGroup_1_1_3() { return cGroup_1_1_3; }
		
		//=>explicitOperationCall?='('
		public Assignment getExplicitOperationCallAssignment_1_1_3_0() { return cExplicitOperationCallAssignment_1_1_3_0; }
		
		//'('
		public Keyword getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0() { return cExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0; }
		
		//(
		//    memberCallArguments+=XShortClosure
		//  | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		//)?
		public Alternatives getAlternatives_1_1_3_1() { return cAlternatives_1_1_3_1; }
		
		//memberCallArguments+=XShortClosure
		public Assignment getMemberCallArgumentsAssignment_1_1_3_1_0() { return cMemberCallArgumentsAssignment_1_1_3_1_0; }
		
		//XShortClosure
		public RuleCall getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0() { return cMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0; }
		
		//memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
		public Group getGroup_1_1_3_1_1() { return cGroup_1_1_3_1_1; }
		
		//memberCallArguments+=XExpression
		public Assignment getMemberCallArgumentsAssignment_1_1_3_1_1_0() { return cMemberCallArgumentsAssignment_1_1_3_1_1_0; }
		
		//XExpression
		public RuleCall getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0() { return cMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0; }
		
		//(',' memberCallArguments+=XExpression)*
		public Group getGroup_1_1_3_1_1_1() { return cGroup_1_1_3_1_1_1; }
		
		//','
		public Keyword getCommaKeyword_1_1_3_1_1_1_0() { return cCommaKeyword_1_1_3_1_1_1_0; }
		
		//memberCallArguments+=XExpression
		public Assignment getMemberCallArgumentsAssignment_1_1_3_1_1_1_1() { return cMemberCallArgumentsAssignment_1_1_3_1_1_1_1; }
		
		//XExpression
		public RuleCall getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0() { return cMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_1_3_2() { return cRightParenthesisKeyword_1_1_3_2; }
		
		//memberCallArguments+=XClosure?
		public Assignment getMemberCallArgumentsAssignment_1_1_4() { return cMemberCallArgumentsAssignment_1_1_4; }
		
		//XClosure
		public RuleCall getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0() { return cMemberCallArgumentsXClosureParserRuleCall_1_1_4_0; }
	}
	public class XPrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XPrimaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXConstructorCallParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXBlockExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cXSwitchExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cXSynchronizedExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cXFeatureCallParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cXLiteralParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cXIfExpressionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cXForLoopExpressionParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cXBasicForLoopExpressionParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cXWhileExpressionParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cXDoWhileExpressionParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cXThrowExpressionParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);
		private final RuleCall cXReturnExpressionParserRuleCall_12 = (RuleCall)cAlternatives.eContents().get(12);
		private final RuleCall cXTryCatchFinallyExpressionParserRuleCall_13 = (RuleCall)cAlternatives.eContents().get(13);
		private final RuleCall cXParenthesizedExpressionParserRuleCall_14 = (RuleCall)cAlternatives.eContents().get(14);
		
		//XPrimaryExpression returns XExpression:
		//    XConstructorCall |
		//    XBlockExpression |
		//    XSwitchExpression |
		//    XSynchronizedExpression |
		//    XFeatureCall |
		//    XLiteral |
		//    XIfExpression |
		//    XForLoopExpression |
		//    XBasicForLoopExpression |
		//    XWhileExpression |
		//    XDoWhileExpression |
		//    XThrowExpression |
		//    XReturnExpression |
		//    XTryCatchFinallyExpression |
		//    XParenthesizedExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//XConstructorCall |
		//XBlockExpression |
		//XSwitchExpression |
		//XSynchronizedExpression |
		//XFeatureCall |
		//XLiteral |
		//XIfExpression |
		//XForLoopExpression |
		//XBasicForLoopExpression |
		//XWhileExpression |
		//XDoWhileExpression |
		//XThrowExpression |
		//XReturnExpression |
		//XTryCatchFinallyExpression |
		//XParenthesizedExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//XConstructorCall
		public RuleCall getXConstructorCallParserRuleCall_0() { return cXConstructorCallParserRuleCall_0; }
		
		//XBlockExpression
		public RuleCall getXBlockExpressionParserRuleCall_1() { return cXBlockExpressionParserRuleCall_1; }
		
		//XSwitchExpression
		public RuleCall getXSwitchExpressionParserRuleCall_2() { return cXSwitchExpressionParserRuleCall_2; }
		
		//XSynchronizedExpression
		public RuleCall getXSynchronizedExpressionParserRuleCall_3() { return cXSynchronizedExpressionParserRuleCall_3; }
		
		//XFeatureCall
		public RuleCall getXFeatureCallParserRuleCall_4() { return cXFeatureCallParserRuleCall_4; }
		
		//XLiteral
		public RuleCall getXLiteralParserRuleCall_5() { return cXLiteralParserRuleCall_5; }
		
		//XIfExpression
		public RuleCall getXIfExpressionParserRuleCall_6() { return cXIfExpressionParserRuleCall_6; }
		
		//XForLoopExpression
		public RuleCall getXForLoopExpressionParserRuleCall_7() { return cXForLoopExpressionParserRuleCall_7; }
		
		//XBasicForLoopExpression
		public RuleCall getXBasicForLoopExpressionParserRuleCall_8() { return cXBasicForLoopExpressionParserRuleCall_8; }
		
		//XWhileExpression
		public RuleCall getXWhileExpressionParserRuleCall_9() { return cXWhileExpressionParserRuleCall_9; }
		
		//XDoWhileExpression
		public RuleCall getXDoWhileExpressionParserRuleCall_10() { return cXDoWhileExpressionParserRuleCall_10; }
		
		//XThrowExpression
		public RuleCall getXThrowExpressionParserRuleCall_11() { return cXThrowExpressionParserRuleCall_11; }
		
		//XReturnExpression
		public RuleCall getXReturnExpressionParserRuleCall_12() { return cXReturnExpressionParserRuleCall_12; }
		
		//XTryCatchFinallyExpression
		public RuleCall getXTryCatchFinallyExpressionParserRuleCall_13() { return cXTryCatchFinallyExpressionParserRuleCall_13; }
		
		//XParenthesizedExpression
		public RuleCall getXParenthesizedExpressionParserRuleCall_14() { return cXParenthesizedExpressionParserRuleCall_14; }
	}
	public class XLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XLiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXCollectionLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXClosureParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cXBooleanLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cXNumberLiteralParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cXNullLiteralParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cXStringLiteralParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cXTypeLiteralParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//XLiteral returns XExpression:
		//    XCollectionLiteral |
		//    XClosure |
		//    XBooleanLiteral |
		//    XNumberLiteral |
		//    XNullLiteral |
		//    XStringLiteral |
		//    XTypeLiteral
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XCollectionLiteral |
		//XClosure |
		//XBooleanLiteral |
		//XNumberLiteral |
		//XNullLiteral |
		//XStringLiteral |
		//XTypeLiteral
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//XCollectionLiteral
		public RuleCall getXCollectionLiteralParserRuleCall_0() { return cXCollectionLiteralParserRuleCall_0; }
		
		//XClosure
		public RuleCall getXClosureParserRuleCall_1() { return cXClosureParserRuleCall_1; }
		
		//XBooleanLiteral
		public RuleCall getXBooleanLiteralParserRuleCall_2() { return cXBooleanLiteralParserRuleCall_2; }
		
		//XNumberLiteral
		public RuleCall getXNumberLiteralParserRuleCall_3() { return cXNumberLiteralParserRuleCall_3; }
		
		//XNullLiteral
		public RuleCall getXNullLiteralParserRuleCall_4() { return cXNullLiteralParserRuleCall_4; }
		
		//XStringLiteral
		public RuleCall getXStringLiteralParserRuleCall_5() { return cXStringLiteralParserRuleCall_5; }
		
		//XTypeLiteral
		public RuleCall getXTypeLiteralParserRuleCall_6() { return cXTypeLiteralParserRuleCall_6; }
	}
	public class XCollectionLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XCollectionLiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXSetLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXListLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//XCollectionLiteral:
		//    XSetLiteral | XListLiteral
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//XSetLiteral | XListLiteral
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//XSetLiteral
		public RuleCall getXSetLiteralParserRuleCall_0() { return cXSetLiteralParserRuleCall_0; }
		
		//XListLiteral
		public RuleCall getXListLiteralParserRuleCall_1() { return cXListLiteralParserRuleCall_1; }
	}
	public class XSetLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XSetLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXSetLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cElementsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cElementsXExpressionParserRuleCall_3_0_0 = (RuleCall)cElementsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cElementsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cElementsXExpressionParserRuleCall_3_1_1_0 = (RuleCall)cElementsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//XSetLiteral:
		//    {XSetLiteral} '#' '{' (elements+=XExpression (',' elements+=XExpression )*)? '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XSetLiteral} '#' '{' (elements+=XExpression (',' elements+=XExpression )*)? '}'
		public Group getGroup() { return cGroup; }
		
		//{XSetLiteral}
		public Action getXSetLiteralAction_0() { return cXSetLiteralAction_0; }
		
		//'#'
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(elements+=XExpression (',' elements+=XExpression )*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//elements+=XExpression
		public Assignment getElementsAssignment_3_0() { return cElementsAssignment_3_0; }
		
		//XExpression
		public RuleCall getElementsXExpressionParserRuleCall_3_0_0() { return cElementsXExpressionParserRuleCall_3_0_0; }
		
		//(',' elements+=XExpression )*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//elements+=XExpression
		public Assignment getElementsAssignment_3_1_1() { return cElementsAssignment_3_1_1; }
		
		//XExpression
		public RuleCall getElementsXExpressionParserRuleCall_3_1_1_0() { return cElementsXExpressionParserRuleCall_3_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class XListLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XListLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXListLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cElementsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cElementsXExpressionParserRuleCall_3_0_0 = (RuleCall)cElementsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cElementsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cElementsXExpressionParserRuleCall_3_1_1_0 = (RuleCall)cElementsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//XListLiteral:
		//    {XListLiteral} '#' '[' (elements+=XExpression (',' elements+=XExpression )*)? ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XListLiteral} '#' '[' (elements+=XExpression (',' elements+=XExpression )*)? ']'
		public Group getGroup() { return cGroup; }
		
		//{XListLiteral}
		public Action getXListLiteralAction_0() { return cXListLiteralAction_0; }
		
		//'#'
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }
		
		//(elements+=XExpression (',' elements+=XExpression )*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//elements+=XExpression
		public Assignment getElementsAssignment_3_0() { return cElementsAssignment_3_0; }
		
		//XExpression
		public RuleCall getElementsXExpressionParserRuleCall_3_0_0() { return cElementsXExpressionParserRuleCall_3_0_0; }
		
		//(',' elements+=XExpression )*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//elements+=XExpression
		public Assignment getElementsAssignment_3_1_1() { return cElementsAssignment_3_1_1; }
		
		//XExpression
		public RuleCall getElementsXExpressionParserRuleCall_3_1_1_0() { return cElementsXExpressionParserRuleCall_3_1_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}
	public class XClosureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XClosure");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cXClosureAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0_0_1 = (Keyword)cGroup_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Assignment cDeclaredFormalParametersAssignment_1_0_0_0 = (Assignment)cGroup_1_0_0.eContents().get(0);
		private final RuleCall cDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0 = (RuleCall)cDeclaredFormalParametersAssignment_1_0_0_0.eContents().get(0);
		private final Group cGroup_1_0_0_1 = (Group)cGroup_1_0_0.eContents().get(1);
		private final Keyword cCommaKeyword_1_0_0_1_0 = (Keyword)cGroup_1_0_0_1.eContents().get(0);
		private final Assignment cDeclaredFormalParametersAssignment_1_0_0_1_1 = (Assignment)cGroup_1_0_0_1.eContents().get(1);
		private final RuleCall cDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0 = (RuleCall)cDeclaredFormalParametersAssignment_1_0_0_1_1.eContents().get(0);
		private final Assignment cExplicitSyntaxAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Keyword cExplicitSyntaxVerticalLineKeyword_1_0_1_0 = (Keyword)cExplicitSyntaxAssignment_1_0_1.eContents().get(0);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionXExpressionInClosureParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//XClosure returns XExpression:
		//    =>({XClosure}
		//    '[')
		//        =>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')?
		//        expression=XExpressionInClosure
		//    ']';
		@Override public ParserRule getRule() { return rule; }
		
		//=>({XClosure}
		//'[')
		//    =>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')?
		//    expression=XExpressionInClosure
		//']'
		public Group getGroup() { return cGroup; }
		
		//=>({XClosure}
		//'[')
		public Group getGroup_0() { return cGroup_0; }
		
		//{XClosure}
		//    '['
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{XClosure}
		public Action getXClosureAction_0_0_0() { return cXClosureAction_0_0_0; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0_0_1() { return cLeftSquareBracketKeyword_0_0_1; }
		
		//=>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')?
		public Group getGroup_1() { return cGroup_1; }
		
		//(declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|'
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//(declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//declaredFormalParameters+=JvmFormalParameter
		public Assignment getDeclaredFormalParametersAssignment_1_0_0_0() { return cDeclaredFormalParametersAssignment_1_0_0_0; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0() { return cDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0; }
		
		//(',' declaredFormalParameters+=JvmFormalParameter)*
		public Group getGroup_1_0_0_1() { return cGroup_1_0_0_1; }
		
		//','
		public Keyword getCommaKeyword_1_0_0_1_0() { return cCommaKeyword_1_0_0_1_0; }
		
		//declaredFormalParameters+=JvmFormalParameter
		public Assignment getDeclaredFormalParametersAssignment_1_0_0_1_1() { return cDeclaredFormalParametersAssignment_1_0_0_1_1; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0() { return cDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0; }
		
		//explicitSyntax?='|'
		public Assignment getExplicitSyntaxAssignment_1_0_1() { return cExplicitSyntaxAssignment_1_0_1; }
		
		//'|'
		public Keyword getExplicitSyntaxVerticalLineKeyword_1_0_1_0() { return cExplicitSyntaxVerticalLineKeyword_1_0_1_0; }
		
		//expression=XExpressionInClosure
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }
		
		//XExpressionInClosure
		public RuleCall getExpressionXExpressionInClosureParserRuleCall_2_0() { return cExpressionXExpressionInClosureParserRuleCall_2_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}
	public class XExpressionInClosureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XExpressionInClosure");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXBlockExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cExpressionsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0 = (RuleCall)cExpressionsAssignment_1_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		
		//XExpressionInClosure returns XExpression:
		//    {XBlockExpression}
		//    (expressions+=XExpressionOrVarDeclaration ';'?)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XBlockExpression}
		//(expressions+=XExpressionOrVarDeclaration ';'?)*
		public Group getGroup() { return cGroup; }
		
		//{XBlockExpression}
		public Action getXBlockExpressionAction_0() { return cXBlockExpressionAction_0; }
		
		//(expressions+=XExpressionOrVarDeclaration ';'?)*
		public Group getGroup_1() { return cGroup_1; }
		
		//expressions+=XExpressionOrVarDeclaration
		public Assignment getExpressionsAssignment_1_0() { return cExpressionsAssignment_1_0; }
		
		//XExpressionOrVarDeclaration
		public RuleCall getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0() { return cExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_1_1() { return cSemicolonKeyword_1_1; }
	}
	public class XShortClosureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XShortClosure");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cXClosureAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Group cGroup_0_0_1 = (Group)cGroup_0_0.eContents().get(1);
		private final Assignment cDeclaredFormalParametersAssignment_0_0_1_0 = (Assignment)cGroup_0_0_1.eContents().get(0);
		private final RuleCall cDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0 = (RuleCall)cDeclaredFormalParametersAssignment_0_0_1_0.eContents().get(0);
		private final Group cGroup_0_0_1_1 = (Group)cGroup_0_0_1.eContents().get(1);
		private final Keyword cCommaKeyword_0_0_1_1_0 = (Keyword)cGroup_0_0_1_1.eContents().get(0);
		private final Assignment cDeclaredFormalParametersAssignment_0_0_1_1_1 = (Assignment)cGroup_0_0_1_1.eContents().get(1);
		private final RuleCall cDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0 = (RuleCall)cDeclaredFormalParametersAssignment_0_0_1_1_1.eContents().get(0);
		private final Assignment cExplicitSyntaxAssignment_0_0_2 = (Assignment)cGroup_0_0.eContents().get(2);
		private final Keyword cExplicitSyntaxVerticalLineKeyword_0_0_2_0 = (Keyword)cExplicitSyntaxAssignment_0_0_2.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionXExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		
		//XShortClosure returns XExpression:
		//    =>({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|') expression=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//=>({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|') expression=XExpression
		public Group getGroup() { return cGroup; }
		
		//=>({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')
		public Group getGroup_0() { return cGroup_0; }
		
		//{XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|'
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{XClosure}
		public Action getXClosureAction_0_0_0() { return cXClosureAction_0_0_0; }
		
		//(declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?
		public Group getGroup_0_0_1() { return cGroup_0_0_1; }
		
		//declaredFormalParameters+=JvmFormalParameter
		public Assignment getDeclaredFormalParametersAssignment_0_0_1_0() { return cDeclaredFormalParametersAssignment_0_0_1_0; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0() { return cDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0; }
		
		//(',' declaredFormalParameters+=JvmFormalParameter)*
		public Group getGroup_0_0_1_1() { return cGroup_0_0_1_1; }
		
		//','
		public Keyword getCommaKeyword_0_0_1_1_0() { return cCommaKeyword_0_0_1_1_0; }
		
		//declaredFormalParameters+=JvmFormalParameter
		public Assignment getDeclaredFormalParametersAssignment_0_0_1_1_1() { return cDeclaredFormalParametersAssignment_0_0_1_1_1; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0() { return cDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0; }
		
		//explicitSyntax?='|'
		public Assignment getExplicitSyntaxAssignment_0_0_2() { return cExplicitSyntaxAssignment_0_0_2; }
		
		//'|'
		public Keyword getExplicitSyntaxVerticalLineKeyword_0_0_2_0() { return cExplicitSyntaxVerticalLineKeyword_0_0_2_0; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_1_0() { return cExpressionXExpressionParserRuleCall_1_0; }
	}
	public class XParenthesizedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XParenthesizedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cXExpressionParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//XParenthesizedExpression returns XExpression:
		//    '(' XExpression ')';
		@Override public ParserRule getRule() { return rule; }
		
		//'(' XExpression ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//XExpression
		public RuleCall getXExpressionParserRuleCall_1() { return cXExpressionParserRuleCall_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class XIfExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XIfExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXIfExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cIfAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIfXExpressionParserRuleCall_3_0 = (RuleCall)cIfAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cThenAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cThenXExpressionParserRuleCall_5_0 = (RuleCall)cThenAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cElseKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cElseAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cElseXExpressionParserRuleCall_6_1_0 = (RuleCall)cElseAssignment_6_1.eContents().get(0);
		
		//XIfExpression returns XExpression:
		//    {XIfExpression}
		//    'if' '(' if=XExpression ')'
		//    then=XExpression
		//    (=>'else' else=XExpression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//{XIfExpression}
		//'if' '(' if=XExpression ')'
		//then=XExpression
		//(=>'else' else=XExpression)?
		public Group getGroup() { return cGroup; }
		
		//{XIfExpression}
		public Action getXIfExpressionAction_0() { return cXIfExpressionAction_0; }
		
		//'if'
		public Keyword getIfKeyword_1() { return cIfKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//if=XExpression
		public Assignment getIfAssignment_3() { return cIfAssignment_3; }
		
		//XExpression
		public RuleCall getIfXExpressionParserRuleCall_3_0() { return cIfXExpressionParserRuleCall_3_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//then=XExpression
		public Assignment getThenAssignment_5() { return cThenAssignment_5; }
		
		//XExpression
		public RuleCall getThenXExpressionParserRuleCall_5_0() { return cThenXExpressionParserRuleCall_5_0; }
		
		//(=>'else' else=XExpression)?
		public Group getGroup_6() { return cGroup_6; }
		
		//=>'else'
		public Keyword getElseKeyword_6_0() { return cElseKeyword_6_0; }
		
		//else=XExpression
		public Assignment getElseAssignment_6_1() { return cElseAssignment_6_1; }
		
		//XExpression
		public RuleCall getElseXExpressionParserRuleCall_6_1_0() { return cElseXExpressionParserRuleCall_6_1_0; }
	}
	public class XSwitchExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XSwitchExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXSwitchExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSwitchKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Group cGroup_2_0_0_0 = (Group)cGroup_2_0_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_0_0_0_0 = (Keyword)cGroup_2_0_0_0.eContents().get(0);
		private final Assignment cDeclaredParamAssignment_2_0_0_0_1 = (Assignment)cGroup_2_0_0_0.eContents().get(1);
		private final RuleCall cDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0 = (RuleCall)cDeclaredParamAssignment_2_0_0_0_1.eContents().get(0);
		private final Keyword cColonKeyword_2_0_0_0_2 = (Keyword)cGroup_2_0_0_0.eContents().get(2);
		private final Assignment cSwitchAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cSwitchXExpressionParserRuleCall_2_0_1_0 = (RuleCall)cSwitchAssignment_2_0_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_0_2 = (Keyword)cGroup_2_0.eContents().get(2);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Group cGroup_2_1_0 = (Group)cGroup_2_1.eContents().get(0);
		private final Group cGroup_2_1_0_0 = (Group)cGroup_2_1_0.eContents().get(0);
		private final Assignment cDeclaredParamAssignment_2_1_0_0_0 = (Assignment)cGroup_2_1_0_0.eContents().get(0);
		private final RuleCall cDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0 = (RuleCall)cDeclaredParamAssignment_2_1_0_0_0.eContents().get(0);
		private final Keyword cColonKeyword_2_1_0_0_1 = (Keyword)cGroup_2_1_0_0.eContents().get(1);
		private final Assignment cSwitchAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cSwitchXExpressionParserRuleCall_2_1_1_0 = (RuleCall)cSwitchAssignment_2_1_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCasesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCasesXCasePartParserRuleCall_4_0 = (RuleCall)cCasesAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cDefaultKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cColonKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cDefaultAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final RuleCall cDefaultXExpressionParserRuleCall_5_2_0 = (RuleCall)cDefaultAssignment_5_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//XSwitchExpression returns XExpression:
		//    {XSwitchExpression}
		//    'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		//        | =>(declaredParam=JvmFormalParameter ':')? switch=XExpression) '{'
		//    (cases+=XCasePart)*
		//    ('default' ':' default=XExpression )?
		//    '}';
		@Override public ParserRule getRule() { return rule; }
		
		//{XSwitchExpression}
		//'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		//    | =>(declaredParam=JvmFormalParameter ':')? switch=XExpression) '{'
		//(cases+=XCasePart)*
		//('default' ':' default=XExpression )?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{XSwitchExpression}
		public Action getXSwitchExpressionAction_0() { return cXSwitchExpressionAction_0; }
		
		//'switch'
		public Keyword getSwitchKeyword_1() { return cSwitchKeyword_1; }
		
		//(=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		//       | =>(declaredParam=JvmFormalParameter ':')? switch=XExpression)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//=>('(' declaredParam=JvmFormalParameter ':')
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }
		
		//'(' declaredParam=JvmFormalParameter ':'
		public Group getGroup_2_0_0_0() { return cGroup_2_0_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_0_0_0_0() { return cLeftParenthesisKeyword_2_0_0_0_0; }
		
		//declaredParam=JvmFormalParameter
		public Assignment getDeclaredParamAssignment_2_0_0_0_1() { return cDeclaredParamAssignment_2_0_0_0_1; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0() { return cDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0; }
		
		//':'
		public Keyword getColonKeyword_2_0_0_0_2() { return cColonKeyword_2_0_0_0_2; }
		
		//switch=XExpression
		public Assignment getSwitchAssignment_2_0_1() { return cSwitchAssignment_2_0_1; }
		
		//XExpression
		public RuleCall getSwitchXExpressionParserRuleCall_2_0_1_0() { return cSwitchXExpressionParserRuleCall_2_0_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_0_2() { return cRightParenthesisKeyword_2_0_2; }
		
		//=>(declaredParam=JvmFormalParameter ':')? switch=XExpression
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//=>(declaredParam=JvmFormalParameter ':')?
		public Group getGroup_2_1_0() { return cGroup_2_1_0; }
		
		//declaredParam=JvmFormalParameter ':'
		public Group getGroup_2_1_0_0() { return cGroup_2_1_0_0; }
		
		//declaredParam=JvmFormalParameter
		public Assignment getDeclaredParamAssignment_2_1_0_0_0() { return cDeclaredParamAssignment_2_1_0_0_0; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0() { return cDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_2_1_0_0_1() { return cColonKeyword_2_1_0_0_1; }
		
		//switch=XExpression
		public Assignment getSwitchAssignment_2_1_1() { return cSwitchAssignment_2_1_1; }
		
		//XExpression
		public RuleCall getSwitchXExpressionParserRuleCall_2_1_1_0() { return cSwitchXExpressionParserRuleCall_2_1_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//(cases+=XCasePart)*
		public Assignment getCasesAssignment_4() { return cCasesAssignment_4; }
		
		//XCasePart
		public RuleCall getCasesXCasePartParserRuleCall_4_0() { return cCasesXCasePartParserRuleCall_4_0; }
		
		//('default' ':' default=XExpression )?
		public Group getGroup_5() { return cGroup_5; }
		
		//'default'
		public Keyword getDefaultKeyword_5_0() { return cDefaultKeyword_5_0; }
		
		//':'
		public Keyword getColonKeyword_5_1() { return cColonKeyword_5_1; }
		
		//default=XExpression
		public Assignment getDefaultAssignment_5_2() { return cDefaultAssignment_5_2; }
		
		//XExpression
		public RuleCall getDefaultXExpressionParserRuleCall_5_2_0() { return cDefaultXExpressionParserRuleCall_5_2_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class XCasePartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XCasePart");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXCasePartAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cTypeGuardAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeGuardJvmTypeReferenceParserRuleCall_1_0 = (RuleCall)cTypeGuardAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCaseKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cCaseAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cCaseXExpressionParserRuleCall_2_1_0 = (RuleCall)cCaseAssignment_2_1.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Keyword cColonKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cThenAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cThenXExpressionParserRuleCall_3_0_1_0 = (RuleCall)cThenAssignment_3_0_1.eContents().get(0);
		private final Assignment cFallThroughAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final Keyword cFallThroughCommaKeyword_3_1_0 = (Keyword)cFallThroughAssignment_3_1.eContents().get(0);
		
		//XCasePart:
		//    {XCasePart}
		//    typeGuard=JvmTypeReference? ('case' case=XExpression)?
		//        (':' then=XExpression | fallThrough?=',') ;
		@Override public ParserRule getRule() { return rule; }
		
		//{XCasePart}
		//typeGuard=JvmTypeReference? ('case' case=XExpression)?
		//    (':' then=XExpression | fallThrough?=',')
		public Group getGroup() { return cGroup; }
		
		//{XCasePart}
		public Action getXCasePartAction_0() { return cXCasePartAction_0; }
		
		//typeGuard=JvmTypeReference?
		public Assignment getTypeGuardAssignment_1() { return cTypeGuardAssignment_1; }
		
		//JvmTypeReference
		public RuleCall getTypeGuardJvmTypeReferenceParserRuleCall_1_0() { return cTypeGuardJvmTypeReferenceParserRuleCall_1_0; }
		
		//('case' case=XExpression)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'case'
		public Keyword getCaseKeyword_2_0() { return cCaseKeyword_2_0; }
		
		//case=XExpression
		public Assignment getCaseAssignment_2_1() { return cCaseAssignment_2_1; }
		
		//XExpression
		public RuleCall getCaseXExpressionParserRuleCall_2_1_0() { return cCaseXExpressionParserRuleCall_2_1_0; }
		
		//(':' then=XExpression | fallThrough?=',')
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//':' then=XExpression
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//':'
		public Keyword getColonKeyword_3_0_0() { return cColonKeyword_3_0_0; }
		
		//then=XExpression
		public Assignment getThenAssignment_3_0_1() { return cThenAssignment_3_0_1; }
		
		//XExpression
		public RuleCall getThenXExpressionParserRuleCall_3_0_1_0() { return cThenXExpressionParserRuleCall_3_0_1_0; }
		
		//fallThrough?=','
		public Assignment getFallThroughAssignment_3_1() { return cFallThroughAssignment_3_1; }
		
		//','
		public Keyword getFallThroughCommaKeyword_3_1_0() { return cFallThroughCommaKeyword_3_1_0; }
	}
	public class XForLoopExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XForLoopExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cXForLoopExpressionAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Keyword cForKeyword_0_0_1 = (Keyword)cGroup_0_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_0_2 = (Keyword)cGroup_0_0.eContents().get(2);
		private final Assignment cDeclaredParamAssignment_0_0_3 = (Assignment)cGroup_0_0.eContents().get(3);
		private final RuleCall cDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0 = (RuleCall)cDeclaredParamAssignment_0_0_3.eContents().get(0);
		private final Keyword cColonKeyword_0_0_4 = (Keyword)cGroup_0_0.eContents().get(4);
		private final Assignment cForExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cForExpressionXExpressionParserRuleCall_1_0 = (RuleCall)cForExpressionAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cEachExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cEachExpressionXExpressionParserRuleCall_3_0 = (RuleCall)cEachExpressionAssignment_3.eContents().get(0);
		
		//XForLoopExpression returns XExpression:
		//    =>({XForLoopExpression}
		//    'for' '(' declaredParam=JvmFormalParameter ':') forExpression=XExpression ')'
		//        eachExpression=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//=>({XForLoopExpression}
		//'for' '(' declaredParam=JvmFormalParameter ':') forExpression=XExpression ')'
		//    eachExpression=XExpression
		public Group getGroup() { return cGroup; }
		
		//=>({XForLoopExpression}
		//'for' '(' declaredParam=JvmFormalParameter ':')
		public Group getGroup_0() { return cGroup_0; }
		
		//{XForLoopExpression}
		//    'for' '(' declaredParam=JvmFormalParameter ':'
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{XForLoopExpression}
		public Action getXForLoopExpressionAction_0_0_0() { return cXForLoopExpressionAction_0_0_0; }
		
		//'for'
		public Keyword getForKeyword_0_0_1() { return cForKeyword_0_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_0_2() { return cLeftParenthesisKeyword_0_0_2; }
		
		//declaredParam=JvmFormalParameter
		public Assignment getDeclaredParamAssignment_0_0_3() { return cDeclaredParamAssignment_0_0_3; }
		
		//JvmFormalParameter
		public RuleCall getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0() { return cDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0; }
		
		//':'
		public Keyword getColonKeyword_0_0_4() { return cColonKeyword_0_0_4; }
		
		//forExpression=XExpression
		public Assignment getForExpressionAssignment_1() { return cForExpressionAssignment_1; }
		
		//XExpression
		public RuleCall getForExpressionXExpressionParserRuleCall_1_0() { return cForExpressionXExpressionParserRuleCall_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
		
		//eachExpression=XExpression
		public Assignment getEachExpressionAssignment_3() { return cEachExpressionAssignment_3; }
		
		//XExpression
		public RuleCall getEachExpressionXExpressionParserRuleCall_3_0() { return cEachExpressionXExpressionParserRuleCall_3_0; }
	}
	public class XBasicForLoopExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XBasicForLoopExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXBasicForLoopExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cInitExpressionsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0 = (RuleCall)cInitExpressionsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cInitExpressionsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0 = (RuleCall)cInitExpressionsAssignment_3_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cExpressionAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cExpressionXExpressionParserRuleCall_5_0 = (RuleCall)cExpressionAssignment_5.eContents().get(0);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Assignment cUpdateExpressionsAssignment_7_0 = (Assignment)cGroup_7.eContents().get(0);
		private final RuleCall cUpdateExpressionsXExpressionParserRuleCall_7_0_0 = (RuleCall)cUpdateExpressionsAssignment_7_0.eContents().get(0);
		private final Group cGroup_7_1 = (Group)cGroup_7.eContents().get(1);
		private final Keyword cCommaKeyword_7_1_0 = (Keyword)cGroup_7_1.eContents().get(0);
		private final Assignment cUpdateExpressionsAssignment_7_1_1 = (Assignment)cGroup_7_1.eContents().get(1);
		private final RuleCall cUpdateExpressionsXExpressionParserRuleCall_7_1_1_0 = (RuleCall)cUpdateExpressionsAssignment_7_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cEachExpressionAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cEachExpressionXExpressionParserRuleCall_9_0 = (RuleCall)cEachExpressionAssignment_9.eContents().get(0);
		
		//XBasicForLoopExpression returns XExpression:
		//    {XBasicForLoopExpression}
		//    'for' '('(initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)? ';'
		//        expression=XExpression? ';'
		//        (updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)? ')'
		//        eachExpression=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//{XBasicForLoopExpression}
		//'for' '('(initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)? ';'
		//    expression=XExpression? ';'
		//    (updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)? ')'
		//    eachExpression=XExpression
		public Group getGroup() { return cGroup; }
		
		//{XBasicForLoopExpression}
		public Action getXBasicForLoopExpressionAction_0() { return cXBasicForLoopExpressionAction_0; }
		
		//'for'
		public Keyword getForKeyword_1() { return cForKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//(initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//initExpressions+=XExpressionOrVarDeclaration
		public Assignment getInitExpressionsAssignment_3_0() { return cInitExpressionsAssignment_3_0; }
		
		//XExpressionOrVarDeclaration
		public RuleCall getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0() { return cInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0; }
		
		//(',' initExpressions+=XExpressionOrVarDeclaration)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//initExpressions+=XExpressionOrVarDeclaration
		public Assignment getInitExpressionsAssignment_3_1_1() { return cInitExpressionsAssignment_3_1_1; }
		
		//XExpressionOrVarDeclaration
		public RuleCall getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0() { return cInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0; }
		
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
		
		//expression=XExpression?
		public Assignment getExpressionAssignment_5() { return cExpressionAssignment_5; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_5_0() { return cExpressionXExpressionParserRuleCall_5_0; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
		
		//(updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)?
		public Group getGroup_7() { return cGroup_7; }
		
		//updateExpressions+=XExpression
		public Assignment getUpdateExpressionsAssignment_7_0() { return cUpdateExpressionsAssignment_7_0; }
		
		//XExpression
		public RuleCall getUpdateExpressionsXExpressionParserRuleCall_7_0_0() { return cUpdateExpressionsXExpressionParserRuleCall_7_0_0; }
		
		//(',' updateExpressions+=XExpression)*
		public Group getGroup_7_1() { return cGroup_7_1; }
		
		//','
		public Keyword getCommaKeyword_7_1_0() { return cCommaKeyword_7_1_0; }
		
		//updateExpressions+=XExpression
		public Assignment getUpdateExpressionsAssignment_7_1_1() { return cUpdateExpressionsAssignment_7_1_1; }
		
		//XExpression
		public RuleCall getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0() { return cUpdateExpressionsXExpressionParserRuleCall_7_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_8() { return cRightParenthesisKeyword_8; }
		
		//eachExpression=XExpression
		public Assignment getEachExpressionAssignment_9() { return cEachExpressionAssignment_9; }
		
		//XExpression
		public RuleCall getEachExpressionXExpressionParserRuleCall_9_0() { return cEachExpressionXExpressionParserRuleCall_9_0; }
	}
	public class XWhileExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XWhileExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXWhileExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cWhileKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cPredicateAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cPredicateXExpressionParserRuleCall_3_0 = (RuleCall)cPredicateAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cBodyAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cBodyXExpressionParserRuleCall_5_0 = (RuleCall)cBodyAssignment_5.eContents().get(0);
		
		//XWhileExpression returns XExpression:
		//    {XWhileExpression}
		//    'while' '(' predicate=XExpression ')'
		//        body=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//{XWhileExpression}
		//'while' '(' predicate=XExpression ')'
		//    body=XExpression
		public Group getGroup() { return cGroup; }
		
		//{XWhileExpression}
		public Action getXWhileExpressionAction_0() { return cXWhileExpressionAction_0; }
		
		//'while'
		public Keyword getWhileKeyword_1() { return cWhileKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//predicate=XExpression
		public Assignment getPredicateAssignment_3() { return cPredicateAssignment_3; }
		
		//XExpression
		public RuleCall getPredicateXExpressionParserRuleCall_3_0() { return cPredicateXExpressionParserRuleCall_3_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//body=XExpression
		public Assignment getBodyAssignment_5() { return cBodyAssignment_5; }
		
		//XExpression
		public RuleCall getBodyXExpressionParserRuleCall_5_0() { return cBodyXExpressionParserRuleCall_5_0; }
	}
	public class XDoWhileExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XDoWhileExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXDoWhileExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cDoKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cBodyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cBodyXExpressionParserRuleCall_2_0 = (RuleCall)cBodyAssignment_2.eContents().get(0);
		private final Keyword cWhileKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cPredicateAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cPredicateXExpressionParserRuleCall_5_0 = (RuleCall)cPredicateAssignment_5.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//XDoWhileExpression returns XExpression:
		//    {XDoWhileExpression}
		//    'do'
		//        body=XExpression
		//    'while' '(' predicate=XExpression ')';
		@Override public ParserRule getRule() { return rule; }
		
		//{XDoWhileExpression}
		//'do'
		//    body=XExpression
		//'while' '(' predicate=XExpression ')'
		public Group getGroup() { return cGroup; }
		
		//{XDoWhileExpression}
		public Action getXDoWhileExpressionAction_0() { return cXDoWhileExpressionAction_0; }
		
		//'do'
		public Keyword getDoKeyword_1() { return cDoKeyword_1; }
		
		//body=XExpression
		public Assignment getBodyAssignment_2() { return cBodyAssignment_2; }
		
		//XExpression
		public RuleCall getBodyXExpressionParserRuleCall_2_0() { return cBodyXExpressionParserRuleCall_2_0; }
		
		//'while'
		public Keyword getWhileKeyword_3() { return cWhileKeyword_3; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4() { return cLeftParenthesisKeyword_4; }
		
		//predicate=XExpression
		public Assignment getPredicateAssignment_5() { return cPredicateAssignment_5; }
		
		//XExpression
		public RuleCall getPredicateXExpressionParserRuleCall_5_0() { return cPredicateXExpressionParserRuleCall_5_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }
	}
	public class XBlockExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XBlockExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXBlockExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cExpressionsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0 = (RuleCall)cExpressionsAssignment_2_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//XBlockExpression returns XExpression:
		//    {XBlockExpression}
		//    '{'
		//        (expressions+=XExpressionOrVarDeclaration ';'?)*
		//    '}';
		@Override public ParserRule getRule() { return rule; }
		
		//{XBlockExpression}
		//'{'
		//    (expressions+=XExpressionOrVarDeclaration ';'?)*
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{XBlockExpression}
		public Action getXBlockExpressionAction_0() { return cXBlockExpressionAction_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//(expressions+=XExpressionOrVarDeclaration ';'?)*
		public Group getGroup_2() { return cGroup_2; }
		
		//expressions+=XExpressionOrVarDeclaration
		public Assignment getExpressionsAssignment_2_0() { return cExpressionsAssignment_2_0; }
		
		//XExpressionOrVarDeclaration
		public RuleCall getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0() { return cExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2_1() { return cSemicolonKeyword_2_1; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}
	public class XExpressionOrVarDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cXVariableDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cXExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//XExpressionOrVarDeclaration returns XExpression:
		//    XVariableDeclaration | XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//XVariableDeclaration | XExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//XVariableDeclaration
		public RuleCall getXVariableDeclarationParserRuleCall_0() { return cXVariableDeclarationParserRuleCall_0; }
		
		//XExpression
		public RuleCall getXExpressionParserRuleCall_1() { return cXExpressionParserRuleCall_1; }
	}
	public class XVariableDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XVariableDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXVariableDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cWriteableAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cWriteableVarKeyword_1_0_0 = (Keyword)cWriteableAssignment_1_0.eContents().get(0);
		private final Keyword cValKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_0 = (Assignment)cGroup_2_0_0.eContents().get(0);
		private final RuleCall cTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0 = (RuleCall)cTypeAssignment_2_0_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_1 = (Assignment)cGroup_2_0_0.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_2_0_0_1_0 = (RuleCall)cNameAssignment_2_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cRightAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cRightXExpressionParserRuleCall_3_1_0 = (RuleCall)cRightAssignment_3_1.eContents().get(0);
		
		//XVariableDeclaration returns XExpression:
		//    {XVariableDeclaration}
		//    (writeable?='var'|'val') (=>(type=JvmTypeReference name=ValidID) | name=ValidID) ('=' right=XExpression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//{XVariableDeclaration}
		//(writeable?='var'|'val') (=>(type=JvmTypeReference name=ValidID) | name=ValidID) ('=' right=XExpression)?
		public Group getGroup() { return cGroup; }
		
		//{XVariableDeclaration}
		public Action getXVariableDeclarationAction_0() { return cXVariableDeclarationAction_0; }
		
		//(writeable?='var'|'val')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//writeable?='var'
		public Assignment getWriteableAssignment_1_0() { return cWriteableAssignment_1_0; }
		
		//'var'
		public Keyword getWriteableVarKeyword_1_0_0() { return cWriteableVarKeyword_1_0_0; }
		
		//'val'
		public Keyword getValKeyword_1_1() { return cValKeyword_1_1; }
		
		//(=>(type=JvmTypeReference name=ValidID) | name=ValidID)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//=>(type=JvmTypeReference name=ValidID)
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//type=JvmTypeReference name=ValidID
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }
		
		//type=JvmTypeReference
		public Assignment getTypeAssignment_2_0_0_0() { return cTypeAssignment_2_0_0_0; }
		
		//JvmTypeReference
		public RuleCall getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0() { return cTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_0_0_1() { return cNameAssignment_2_0_0_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0_0_1_0() { return cNameValidIDParserRuleCall_2_0_0_1_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_1_0() { return cNameValidIDParserRuleCall_2_1_0; }
		
		//('=' right=XExpression)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'='
		public Keyword getEqualsSignKeyword_3_0() { return cEqualsSignKeyword_3_0; }
		
		//right=XExpression
		public Assignment getRightAssignment_3_1() { return cRightAssignment_3_1; }
		
		//XExpression
		public RuleCall getRightXExpressionParserRuleCall_3_1_0() { return cRightXExpressionParserRuleCall_3_1_0; }
	}
	public class JvmFormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cParameterTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cParameterTypeJvmTypeReferenceParserRuleCall_0_0 = (RuleCall)cParameterTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//JvmFormalParameter returns types::JvmFormalParameter:
		//    (parameterType=JvmTypeReference)? name=ValidID;
		@Override public ParserRule getRule() { return rule; }
		
		//(parameterType=JvmTypeReference)? name=ValidID
		public Group getGroup() { return cGroup; }
		
		//(parameterType=JvmTypeReference)?
		public Assignment getParameterTypeAssignment_0() { return cParameterTypeAssignment_0; }
		
		//JvmTypeReference
		public RuleCall getParameterTypeJvmTypeReferenceParserRuleCall_0_0() { return cParameterTypeJvmTypeReferenceParserRuleCall_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
	}
	public class FullJvmFormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.FullJvmFormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cParameterTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cParameterTypeJvmTypeReferenceParserRuleCall_0_0 = (RuleCall)cParameterTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//FullJvmFormalParameter returns types::JvmFormalParameter:
		//    parameterType=JvmTypeReference name=ValidID;
		@Override public ParserRule getRule() { return rule; }
		
		//parameterType=JvmTypeReference name=ValidID
		public Group getGroup() { return cGroup; }
		
		//parameterType=JvmTypeReference
		public Assignment getParameterTypeAssignment_0() { return cParameterTypeAssignment_0; }
		
		//JvmTypeReference
		public RuleCall getParameterTypeJvmTypeReferenceParserRuleCall_0_0() { return cParameterTypeJvmTypeReferenceParserRuleCall_0_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
	}
	public class XFeatureCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XFeatureCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXFeatureCallAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0 = (RuleCall)cTypeArgumentsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0 = (RuleCall)cTypeArgumentsAssignment_1_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Assignment cFeatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cFeatureJvmIdentifiableElementCrossReference_2_0 = (CrossReference)cFeatureAssignment_2.eContents().get(0);
		private final RuleCall cFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1 = (RuleCall)cFeatureJvmIdentifiableElementCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cExplicitOperationCallAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final Keyword cExplicitOperationCallLeftParenthesisKeyword_3_0_0 = (Keyword)cExplicitOperationCallAssignment_3_0.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final Assignment cFeatureCallArgumentsAssignment_3_1_0 = (Assignment)cAlternatives_3_1.eContents().get(0);
		private final RuleCall cFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0 = (RuleCall)cFeatureCallArgumentsAssignment_3_1_0.eContents().get(0);
		private final Group cGroup_3_1_1 = (Group)cAlternatives_3_1.eContents().get(1);
		private final Assignment cFeatureCallArgumentsAssignment_3_1_1_0 = (Assignment)cGroup_3_1_1.eContents().get(0);
		private final RuleCall cFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0 = (RuleCall)cFeatureCallArgumentsAssignment_3_1_1_0.eContents().get(0);
		private final Group cGroup_3_1_1_1 = (Group)cGroup_3_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_1_1_0 = (Keyword)cGroup_3_1_1_1.eContents().get(0);
		private final Assignment cFeatureCallArgumentsAssignment_3_1_1_1_1 = (Assignment)cGroup_3_1_1_1.eContents().get(1);
		private final RuleCall cFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0 = (RuleCall)cFeatureCallArgumentsAssignment_3_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Assignment cFeatureCallArgumentsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFeatureCallArgumentsXClosureParserRuleCall_4_0 = (RuleCall)cFeatureCallArgumentsAssignment_4.eContents().get(0);
		
		//XFeatureCall returns XExpression:
		//    {XFeatureCall}
		//    ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//    feature=[types::JvmIdentifiableElement|IdOrSuper]
		//    (=>explicitOperationCall?='('
		//        (
		//            featureCallArguments+=XShortClosure
		//          | featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
		//        )?
		//    ')')?
		//    featureCallArguments+=XClosure?;
		@Override public ParserRule getRule() { return rule; }
		
		//{XFeatureCall}
		//('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//feature=[types::JvmIdentifiableElement|IdOrSuper]
		//(=>explicitOperationCall?='('
		//    (
		//        featureCallArguments+=XShortClosure
		//      | featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
		//    )?
		//')')?
		//featureCallArguments+=XClosure?
		public Group getGroup() { return cGroup; }
		
		//{XFeatureCall}
		public Action getXFeatureCallAction_0() { return cXFeatureCallAction_0; }
		
		//('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		public Group getGroup_1() { return cGroup_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_1_1() { return cTypeArgumentsAssignment_1_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0; }
		
		//(',' typeArguments+=JvmArgumentTypeReference)*
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_1_2_1() { return cTypeArgumentsAssignment_1_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_3() { return cGreaterThanSignKeyword_1_3; }
		
		//feature=[types::JvmIdentifiableElement|IdOrSuper]
		public Assignment getFeatureAssignment_2() { return cFeatureAssignment_2; }
		
		//[types::JvmIdentifiableElement|IdOrSuper]
		public CrossReference getFeatureJvmIdentifiableElementCrossReference_2_0() { return cFeatureJvmIdentifiableElementCrossReference_2_0; }
		
		//IdOrSuper
		public RuleCall getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1() { return cFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1; }
		
		//(=>explicitOperationCall?='('
		//    (
		//        featureCallArguments+=XShortClosure
		//      | featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
		//    )?
		//')')?
		public Group getGroup_3() { return cGroup_3; }
		
		//=>explicitOperationCall?='('
		public Assignment getExplicitOperationCallAssignment_3_0() { return cExplicitOperationCallAssignment_3_0; }
		
		//'('
		public Keyword getExplicitOperationCallLeftParenthesisKeyword_3_0_0() { return cExplicitOperationCallLeftParenthesisKeyword_3_0_0; }
		
		//(
		//    featureCallArguments+=XShortClosure
		//  | featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
		//)?
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }
		
		//featureCallArguments+=XShortClosure
		public Assignment getFeatureCallArgumentsAssignment_3_1_0() { return cFeatureCallArgumentsAssignment_3_1_0; }
		
		//XShortClosure
		public RuleCall getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0() { return cFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0; }
		
		//featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
		public Group getGroup_3_1_1() { return cGroup_3_1_1; }
		
		//featureCallArguments+=XExpression
		public Assignment getFeatureCallArgumentsAssignment_3_1_1_0() { return cFeatureCallArgumentsAssignment_3_1_1_0; }
		
		//XExpression
		public RuleCall getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0() { return cFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0; }
		
		//(',' featureCallArguments+=XExpression)*
		public Group getGroup_3_1_1_1() { return cGroup_3_1_1_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_1_1_0() { return cCommaKeyword_3_1_1_1_0; }
		
		//featureCallArguments+=XExpression
		public Assignment getFeatureCallArgumentsAssignment_3_1_1_1_1() { return cFeatureCallArgumentsAssignment_3_1_1_1_1; }
		
		//XExpression
		public RuleCall getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0() { return cFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }
		
		//featureCallArguments+=XClosure?
		public Assignment getFeatureCallArgumentsAssignment_4() { return cFeatureCallArgumentsAssignment_4; }
		
		//XClosure
		public RuleCall getFeatureCallArgumentsXClosureParserRuleCall_4_0() { return cFeatureCallArgumentsXClosureParserRuleCall_4_0; }
	}
	public class FeatureCallIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.FeatureCallID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cExtendsKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cStaticKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cImportKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cExtensionKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		
		//FeatureCallID:
		//    ValidID | 'extends' | 'static' | 'import' | 'extension'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID | 'extends' | 'static' | 'import' | 'extension'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//'extends'
		public Keyword getExtendsKeyword_1() { return cExtendsKeyword_1; }
		
		//'static'
		public Keyword getStaticKeyword_2() { return cStaticKeyword_2; }
		
		//'import'
		public Keyword getImportKeyword_3() { return cImportKeyword_3; }
		
		//'extension'
		public Keyword getExtensionKeyword_4() { return cExtensionKeyword_4; }
	}
	public class IdOrSuperElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.IdOrSuper");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cFeatureCallIDParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Keyword cSuperKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//IdOrSuper :
		//    FeatureCallID | 'super'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//FeatureCallID | 'super'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//FeatureCallID
		public RuleCall getFeatureCallIDParserRuleCall_0() { return cFeatureCallIDParserRuleCall_0; }
		
		//'super'
		public Keyword getSuperKeyword_1() { return cSuperKeyword_1; }
	}
	public class XConstructorCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XConstructorCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXConstructorCallAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNewKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cConstructorAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cConstructorJvmConstructorCrossReference_2_0 = (CrossReference)cConstructorAssignment_2.eContents().get(0);
		private final RuleCall cConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cConstructorJvmConstructorCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLessThanSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0 = (RuleCall)cTypeArgumentsAssignment_3_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cGroup_3.eContents().get(2);
		private final Keyword cCommaKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cTypeArgumentsAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0 = (RuleCall)cTypeArgumentsAssignment_3_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cExplicitConstructorCallAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final Keyword cExplicitConstructorCallLeftParenthesisKeyword_4_0_0 = (Keyword)cExplicitConstructorCallAssignment_4_0.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cArgumentsAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final RuleCall cArgumentsXShortClosureParserRuleCall_4_1_0_0 = (RuleCall)cArgumentsAssignment_4_1_0.eContents().get(0);
		private final Group cGroup_4_1_1 = (Group)cAlternatives_4_1.eContents().get(1);
		private final Assignment cArgumentsAssignment_4_1_1_0 = (Assignment)cGroup_4_1_1.eContents().get(0);
		private final RuleCall cArgumentsXExpressionParserRuleCall_4_1_1_0_0 = (RuleCall)cArgumentsAssignment_4_1_1_0.eContents().get(0);
		private final Group cGroup_4_1_1_1 = (Group)cGroup_4_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_1_1_0 = (Keyword)cGroup_4_1_1_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_4_1_1_1_1 = (Assignment)cGroup_4_1_1_1.eContents().get(1);
		private final RuleCall cArgumentsXExpressionParserRuleCall_4_1_1_1_1_0 = (RuleCall)cArgumentsAssignment_4_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Assignment cArgumentsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cArgumentsXClosureParserRuleCall_5_0 = (RuleCall)cArgumentsAssignment_5.eContents().get(0);
		
		//XConstructorCall returns XExpression:
		//    {XConstructorCall}
		//    'new' constructor=[types::JvmConstructor|QualifiedName]
		//    (=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//    (=>explicitConstructorCall?='('
		//        (
		//            arguments+=XShortClosure
		//          | arguments+=XExpression (',' arguments+=XExpression)*
		//        )?
		//    ')')?
		//    arguments+=XClosure?;
		@Override public ParserRule getRule() { return rule; }
		
		//{XConstructorCall}
		//'new' constructor=[types::JvmConstructor|QualifiedName]
		//(=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		//(=>explicitConstructorCall?='('
		//    (
		//        arguments+=XShortClosure
		//      | arguments+=XExpression (',' arguments+=XExpression)*
		//    )?
		//')')?
		//arguments+=XClosure?
		public Group getGroup() { return cGroup; }
		
		//{XConstructorCall}
		public Action getXConstructorCallAction_0() { return cXConstructorCallAction_0; }
		
		//'new'
		public Keyword getNewKeyword_1() { return cNewKeyword_1; }
		
		//constructor=[types::JvmConstructor|QualifiedName]
		public Assignment getConstructorAssignment_2() { return cConstructorAssignment_2; }
		
		//[types::JvmConstructor|QualifiedName]
		public CrossReference getConstructorJvmConstructorCrossReference_2_0() { return cConstructorJvmConstructorCrossReference_2_0; }
		
		//QualifiedName
		public RuleCall getConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1() { return cConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1; }
		
		//(=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
		public Group getGroup_3() { return cGroup_3; }
		
		//=>'<'
		public Keyword getLessThanSignKeyword_3_0() { return cLessThanSignKeyword_3_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_3_1() { return cTypeArgumentsAssignment_3_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0; }
		
		//(',' typeArguments+=JvmArgumentTypeReference)*
		public Group getGroup_3_2() { return cGroup_3_2; }
		
		//','
		public Keyword getCommaKeyword_3_2_0() { return cCommaKeyword_3_2_0; }
		
		//typeArguments+=JvmArgumentTypeReference
		public Assignment getTypeArgumentsAssignment_3_2_1() { return cTypeArgumentsAssignment_3_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0() { return cTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_3_3() { return cGreaterThanSignKeyword_3_3; }
		
		//(=>explicitConstructorCall?='('
		//    (
		//        arguments+=XShortClosure
		//      | arguments+=XExpression (',' arguments+=XExpression)*
		//    )?
		//')')?
		public Group getGroup_4() { return cGroup_4; }
		
		//=>explicitConstructorCall?='('
		public Assignment getExplicitConstructorCallAssignment_4_0() { return cExplicitConstructorCallAssignment_4_0; }
		
		//'('
		public Keyword getExplicitConstructorCallLeftParenthesisKeyword_4_0_0() { return cExplicitConstructorCallLeftParenthesisKeyword_4_0_0; }
		
		//(
		//    arguments+=XShortClosure
		//  | arguments+=XExpression (',' arguments+=XExpression)*
		//)?
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }
		
		//arguments+=XShortClosure
		public Assignment getArgumentsAssignment_4_1_0() { return cArgumentsAssignment_4_1_0; }
		
		//XShortClosure
		public RuleCall getArgumentsXShortClosureParserRuleCall_4_1_0_0() { return cArgumentsXShortClosureParserRuleCall_4_1_0_0; }
		
		//arguments+=XExpression (',' arguments+=XExpression)*
		public Group getGroup_4_1_1() { return cGroup_4_1_1; }
		
		//arguments+=XExpression
		public Assignment getArgumentsAssignment_4_1_1_0() { return cArgumentsAssignment_4_1_1_0; }
		
		//XExpression
		public RuleCall getArgumentsXExpressionParserRuleCall_4_1_1_0_0() { return cArgumentsXExpressionParserRuleCall_4_1_1_0_0; }
		
		//(',' arguments+=XExpression)*
		public Group getGroup_4_1_1_1() { return cGroup_4_1_1_1; }
		
		//','
		public Keyword getCommaKeyword_4_1_1_1_0() { return cCommaKeyword_4_1_1_1_0; }
		
		//arguments+=XExpression
		public Assignment getArgumentsAssignment_4_1_1_1_1() { return cArgumentsAssignment_4_1_1_1_1; }
		
		//XExpression
		public RuleCall getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0() { return cArgumentsXExpressionParserRuleCall_4_1_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_2() { return cRightParenthesisKeyword_4_2; }
		
		//arguments+=XClosure?
		public Assignment getArgumentsAssignment_5() { return cArgumentsAssignment_5; }
		
		//XClosure
		public RuleCall getArgumentsXClosureParserRuleCall_5_0() { return cArgumentsXClosureParserRuleCall_5_0; }
	}
	public class XBooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XBooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cFalseKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cIsTrueAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cIsTrueTrueKeyword_1_1_0 = (Keyword)cIsTrueAssignment_1_1.eContents().get(0);
		
		//XBooleanLiteral returns XExpression :
		//    {XBooleanLiteral} ('false' | isTrue?='true');
		@Override public ParserRule getRule() { return rule; }
		
		//{XBooleanLiteral} ('false' | isTrue?='true')
		public Group getGroup() { return cGroup; }
		
		//{XBooleanLiteral}
		public Action getXBooleanLiteralAction_0() { return cXBooleanLiteralAction_0; }
		
		//('false' | isTrue?='true')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//'false'
		public Keyword getFalseKeyword_1_0() { return cFalseKeyword_1_0; }
		
		//isTrue?='true'
		public Assignment getIsTrueAssignment_1_1() { return cIsTrueAssignment_1_1; }
		
		//'true'
		public Keyword getIsTrueTrueKeyword_1_1_0() { return cIsTrueTrueKeyword_1_1_0; }
	}
	public class XNullLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XNullLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXNullLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//XNullLiteral returns XExpression :
		//    {XNullLiteral} 'null';
		@Override public ParserRule getRule() { return rule; }
		
		//{XNullLiteral} 'null'
		public Group getGroup() { return cGroup; }
		
		//{XNullLiteral}
		public Action getXNullLiteralAction_0() { return cXNullLiteralAction_0; }
		
		//'null'
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
	}
	public class XNumberLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XNumberLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXNumberLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueNumberParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//XNumberLiteral returns XExpression :
		//    {XNumberLiteral} value=Number;
		@Override public ParserRule getRule() { return rule; }
		
		//{XNumberLiteral} value=Number
		public Group getGroup() { return cGroup; }
		
		//{XNumberLiteral}
		public Action getXNumberLiteralAction_0() { return cXNumberLiteralAction_0; }
		
		//value=Number
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//Number
		public RuleCall getValueNumberParserRuleCall_1_0() { return cValueNumberParserRuleCall_1_0; }
	}
	public class XStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XStringLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//XStringLiteral returns XExpression:
		//    {XStringLiteral} value=STRING;
		@Override public ParserRule getRule() { return rule; }
		
		//{XStringLiteral} value=STRING
		public Group getGroup() { return cGroup; }
		
		//{XStringLiteral}
		public Action getXStringLiteralAction_0() { return cXStringLiteralAction_0; }
		
		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}
	public class XTypeLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XTypeLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXTypeLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cTypeofKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTypeJvmTypeCrossReference_3_0 = (CrossReference)cTypeAssignment_3.eContents().get(0);
		private final RuleCall cTypeJvmTypeQualifiedNameParserRuleCall_3_0_1 = (RuleCall)cTypeJvmTypeCrossReference_3_0.eContents().get(1);
		private final Assignment cArrayDimensionsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cArrayDimensionsArrayBracketsParserRuleCall_4_0 = (RuleCall)cArrayDimensionsAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//XTypeLiteral returns XExpression :
		//    {XTypeLiteral} 'typeof' '(' type=[types::JvmType|QualifiedName] (arrayDimensions+=ArrayBrackets)* ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{XTypeLiteral} 'typeof' '(' type=[types::JvmType|QualifiedName] (arrayDimensions+=ArrayBrackets)* ')'
		public Group getGroup() { return cGroup; }
		
		//{XTypeLiteral}
		public Action getXTypeLiteralAction_0() { return cXTypeLiteralAction_0; }
		
		//'typeof'
		public Keyword getTypeofKeyword_1() { return cTypeofKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//type=[types::JvmType|QualifiedName]
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//[types::JvmType|QualifiedName]
		public CrossReference getTypeJvmTypeCrossReference_3_0() { return cTypeJvmTypeCrossReference_3_0; }
		
		//QualifiedName
		public RuleCall getTypeJvmTypeQualifiedNameParserRuleCall_3_0_1() { return cTypeJvmTypeQualifiedNameParserRuleCall_3_0_1; }
		
		//(arrayDimensions+=ArrayBrackets)*
		public Assignment getArrayDimensionsAssignment_4() { return cArrayDimensionsAssignment_4; }
		
		//ArrayBrackets
		public RuleCall getArrayDimensionsArrayBracketsParserRuleCall_4_0() { return cArrayDimensionsArrayBracketsParserRuleCall_4_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class XThrowExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XThrowExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXThrowExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cThrowKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionXExpressionParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		
		//XThrowExpression returns XExpression :
		//    {XThrowExpression} 'throw' expression=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//{XThrowExpression} 'throw' expression=XExpression
		public Group getGroup() { return cGroup; }
		
		//{XThrowExpression}
		public Action getXThrowExpressionAction_0() { return cXThrowExpressionAction_0; }
		
		//'throw'
		public Keyword getThrowKeyword_1() { return cThrowKeyword_1; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_2_0() { return cExpressionXExpressionParserRuleCall_2_0; }
	}
	public class XReturnExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XReturnExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXReturnExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cReturnKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionXExpressionParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		
		//XReturnExpression returns XExpression :
		//    {XReturnExpression} 'return' (->expression=XExpression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//{XReturnExpression} 'return' (->expression=XExpression)?
		public Group getGroup() { return cGroup; }
		
		//{XReturnExpression}
		public Action getXReturnExpressionAction_0() { return cXReturnExpressionAction_0; }
		
		//'return'
		public Keyword getReturnKeyword_1() { return cReturnKeyword_1; }
		
		//(->expression=XExpression)?
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_2_0() { return cExpressionXExpressionParserRuleCall_2_0; }
	}
	public class XTryCatchFinallyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XTryCatchFinallyExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cXTryCatchFinallyExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cTryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionXExpressionParserRuleCall_2_0 = (RuleCall)cExpressionAssignment_2.eContents().get(0);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cAlternatives_3.eContents().get(0);
		private final Assignment cCatchClausesAssignment_3_0_0 = (Assignment)cGroup_3_0.eContents().get(0);
		private final RuleCall cCatchClausesXCatchClauseParserRuleCall_3_0_0_0 = (RuleCall)cCatchClausesAssignment_3_0_0.eContents().get(0);
		private final Group cGroup_3_0_1 = (Group)cGroup_3_0.eContents().get(1);
		private final Keyword cFinallyKeyword_3_0_1_0 = (Keyword)cGroup_3_0_1.eContents().get(0);
		private final Assignment cFinallyExpressionAssignment_3_0_1_1 = (Assignment)cGroup_3_0_1.eContents().get(1);
		private final RuleCall cFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0 = (RuleCall)cFinallyExpressionAssignment_3_0_1_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cAlternatives_3.eContents().get(1);
		private final Keyword cFinallyKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cFinallyExpressionAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cFinallyExpressionXExpressionParserRuleCall_3_1_1_0 = (RuleCall)cFinallyExpressionAssignment_3_1_1.eContents().get(0);
		
		//XTryCatchFinallyExpression returns XExpression:
		//    {XTryCatchFinallyExpression}
		//    'try'
		//        expression=XExpression
		//    (
		//        catchClauses+=XCatchClause+
		//        (=>'finally' finallyExpression=XExpression)?
		//    |    'finally' finallyExpression=XExpression
		//    );
		@Override public ParserRule getRule() { return rule; }
		
		//{XTryCatchFinallyExpression}
		//'try'
		//    expression=XExpression
		//(
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		//)
		public Group getGroup() { return cGroup; }
		
		//{XTryCatchFinallyExpression}
		public Action getXTryCatchFinallyExpressionAction_0() { return cXTryCatchFinallyExpressionAction_0; }
		
		//'try'
		public Keyword getTryKeyword_1() { return cTryKeyword_1; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_2() { return cExpressionAssignment_2; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_2_0() { return cExpressionXExpressionParserRuleCall_2_0; }
		
		//(
		//    catchClauses+=XCatchClause+
		//    (=>'finally' finallyExpression=XExpression)?
		//|    'finally' finallyExpression=XExpression
		//)
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//catchClauses+=XCatchClause+
		//(=>'finally' finallyExpression=XExpression)?
		public Group getGroup_3_0() { return cGroup_3_0; }
		
		//catchClauses+=XCatchClause+
		public Assignment getCatchClausesAssignment_3_0_0() { return cCatchClausesAssignment_3_0_0; }
		
		//XCatchClause
		public RuleCall getCatchClausesXCatchClauseParserRuleCall_3_0_0_0() { return cCatchClausesXCatchClauseParserRuleCall_3_0_0_0; }
		
		//(=>'finally' finallyExpression=XExpression)?
		public Group getGroup_3_0_1() { return cGroup_3_0_1; }
		
		//=>'finally'
		public Keyword getFinallyKeyword_3_0_1_0() { return cFinallyKeyword_3_0_1_0; }
		
		//finallyExpression=XExpression
		public Assignment getFinallyExpressionAssignment_3_0_1_1() { return cFinallyExpressionAssignment_3_0_1_1; }
		
		//XExpression
		public RuleCall getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0() { return cFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0; }
		
		//'finally' finallyExpression=XExpression
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//'finally'
		public Keyword getFinallyKeyword_3_1_0() { return cFinallyKeyword_3_1_0; }
		
		//finallyExpression=XExpression
		public Assignment getFinallyExpressionAssignment_3_1_1() { return cFinallyExpressionAssignment_3_1_1; }
		
		//XExpression
		public RuleCall getFinallyExpressionXExpressionParserRuleCall_3_1_1_0() { return cFinallyExpressionXExpressionParserRuleCall_3_1_1_0; }
	}
	public class XSynchronizedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XSynchronizedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cXSynchronizedExpressionAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Keyword cSynchronizedKeyword_0_0_1 = (Keyword)cGroup_0_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_0_2 = (Keyword)cGroup_0_0.eContents().get(2);
		private final Assignment cParamAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParamXExpressionParserRuleCall_1_0 = (RuleCall)cParamAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cExpressionXExpressionParserRuleCall_3_0 = (RuleCall)cExpressionAssignment_3.eContents().get(0);
		
		//XSynchronizedExpression returns XExpression:
		//    =>({XSynchronizedExpression}
		//    'synchronized' '(') param=XExpression ')' expression=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//=>({XSynchronizedExpression}
		//'synchronized' '(') param=XExpression ')' expression=XExpression
		public Group getGroup() { return cGroup; }
		
		//=>({XSynchronizedExpression}
		//'synchronized' '(')
		public Group getGroup_0() { return cGroup_0; }
		
		//{XSynchronizedExpression}
		//    'synchronized' '('
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{XSynchronizedExpression}
		public Action getXSynchronizedExpressionAction_0_0_0() { return cXSynchronizedExpressionAction_0_0_0; }
		
		//'synchronized'
		public Keyword getSynchronizedKeyword_0_0_1() { return cSynchronizedKeyword_0_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_0_2() { return cLeftParenthesisKeyword_0_0_2; }
		
		//param=XExpression
		public Assignment getParamAssignment_1() { return cParamAssignment_1; }
		
		//XExpression
		public RuleCall getParamXExpressionParserRuleCall_1_0() { return cParamXExpressionParserRuleCall_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_3() { return cExpressionAssignment_3; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_3_0() { return cExpressionXExpressionParserRuleCall_3_0; }
	}
	public class XCatchClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.XCatchClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCatchKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDeclaredParamAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDeclaredParamFullJvmFormalParameterParserRuleCall_2_0 = (RuleCall)cDeclaredParamAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cExpressionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cExpressionXExpressionParserRuleCall_4_0 = (RuleCall)cExpressionAssignment_4.eContents().get(0);
		
		//XCatchClause :
		//    =>'catch' '(' declaredParam=FullJvmFormalParameter ')' expression=XExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//=>'catch' '(' declaredParam=FullJvmFormalParameter ')' expression=XExpression
		public Group getGroup() { return cGroup; }
		
		//=>'catch'
		public Keyword getCatchKeyword_0() { return cCatchKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//declaredParam=FullJvmFormalParameter
		public Assignment getDeclaredParamAssignment_2() { return cDeclaredParamAssignment_2; }
		
		//FullJvmFormalParameter
		public RuleCall getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0() { return cDeclaredParamFullJvmFormalParameterParserRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//expression=XExpression
		public Assignment getExpressionAssignment_4() { return cExpressionAssignment_4; }
		
		//XExpression
		public RuleCall getExpressionXExpressionParserRuleCall_4_0() { return cExpressionXExpressionParserRuleCall_4_0; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//@Override
		//QualifiedName:
		//    ValidID (=>'.' ValidID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID (=>'.' ValidID)*
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//(=>'.' ValidID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=>'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1_1() { return cValidIDParserRuleCall_1_1; }
	}
	public class NumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.Number");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cHEXTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Alternatives cAlternatives_1_0 = (Alternatives)cGroup_1.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1_0_0 = (RuleCall)cAlternatives_1_0.eContents().get(0);
		private final RuleCall cDECIMALTerminalRuleCall_1_0_1 = (RuleCall)cAlternatives_1_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cFullStopKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1_1 = (Alternatives)cGroup_1_1.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1_1_1_0 = (RuleCall)cAlternatives_1_1_1.eContents().get(0);
		private final RuleCall cDECIMALTerminalRuleCall_1_1_1_1 = (RuleCall)cAlternatives_1_1_1.eContents().get(1);
		
		//Number hidden():
		//    HEX | (INT | DECIMAL) ('.' (INT | DECIMAL))?;
		@Override public ParserRule getRule() { return rule; }
		
		//HEX | (INT | DECIMAL) ('.' (INT | DECIMAL))?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//HEX
		public RuleCall getHEXTerminalRuleCall_0() { return cHEXTerminalRuleCall_0; }
		
		//(INT | DECIMAL) ('.' (INT | DECIMAL))?
		public Group getGroup_1() { return cGroup_1; }
		
		//(INT | DECIMAL)
		public Alternatives getAlternatives_1_0() { return cAlternatives_1_0; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1_0_0() { return cINTTerminalRuleCall_1_0_0; }
		
		//DECIMAL
		public RuleCall getDECIMALTerminalRuleCall_1_0_1() { return cDECIMALTerminalRuleCall_1_0_1; }
		
		//('.' (INT | DECIMAL))?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_1_0() { return cFullStopKeyword_1_1_0; }
		
		//(INT | DECIMAL)
		public Alternatives getAlternatives_1_1_1() { return cAlternatives_1_1_1; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_1_1_1_0() { return cINTTerminalRuleCall_1_1_1_0; }
		
		//DECIMAL
		public RuleCall getDECIMALTerminalRuleCall_1_1_1_1() { return cDECIMALTerminalRuleCall_1_1_1_1; }
	}
	public class StaticQualifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.StaticQualifier");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		///**
		// * Dummy rule, for "better" downwards compatibility, since GrammarAccess generates non-static inner classes,
		// * which makes downstream grammars break on classloading, when a rule is removed.
		// */
		//StaticQualifier:
		//    (ValidID '::')+
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(ValidID '::')+
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//'::'
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }
	}
	
	
	private final XExpressionElements pXExpression;
	private final XAssignmentElements pXAssignment;
	private final OpSingleAssignElements pOpSingleAssign;
	private final OpMultiAssignElements pOpMultiAssign;
	private final XOrExpressionElements pXOrExpression;
	private final OpOrElements pOpOr;
	private final XAndExpressionElements pXAndExpression;
	private final OpAndElements pOpAnd;
	private final XEqualityExpressionElements pXEqualityExpression;
	private final OpEqualityElements pOpEquality;
	private final XRelationalExpressionElements pXRelationalExpression;
	private final OpCompareElements pOpCompare;
	private final XOtherOperatorExpressionElements pXOtherOperatorExpression;
	private final OpOtherElements pOpOther;
	private final XAdditiveExpressionElements pXAdditiveExpression;
	private final OpAddElements pOpAdd;
	private final XMultiplicativeExpressionElements pXMultiplicativeExpression;
	private final OpMultiElements pOpMulti;
	private final XUnaryOperationElements pXUnaryOperation;
	private final OpUnaryElements pOpUnary;
	private final XCastedExpressionElements pXCastedExpression;
	private final XPostfixOperationElements pXPostfixOperation;
	private final OpPostfixElements pOpPostfix;
	private final XMemberFeatureCallElements pXMemberFeatureCall;
	private final XPrimaryExpressionElements pXPrimaryExpression;
	private final XLiteralElements pXLiteral;
	private final XCollectionLiteralElements pXCollectionLiteral;
	private final XSetLiteralElements pXSetLiteral;
	private final XListLiteralElements pXListLiteral;
	private final XClosureElements pXClosure;
	private final XExpressionInClosureElements pXExpressionInClosure;
	private final XShortClosureElements pXShortClosure;
	private final XParenthesizedExpressionElements pXParenthesizedExpression;
	private final XIfExpressionElements pXIfExpression;
	private final XSwitchExpressionElements pXSwitchExpression;
	private final XCasePartElements pXCasePart;
	private final XForLoopExpressionElements pXForLoopExpression;
	private final XBasicForLoopExpressionElements pXBasicForLoopExpression;
	private final XWhileExpressionElements pXWhileExpression;
	private final XDoWhileExpressionElements pXDoWhileExpression;
	private final XBlockExpressionElements pXBlockExpression;
	private final XExpressionOrVarDeclarationElements pXExpressionOrVarDeclaration;
	private final XVariableDeclarationElements pXVariableDeclaration;
	private final JvmFormalParameterElements pJvmFormalParameter;
	private final FullJvmFormalParameterElements pFullJvmFormalParameter;
	private final XFeatureCallElements pXFeatureCall;
	private final FeatureCallIDElements pFeatureCallID;
	private final IdOrSuperElements pIdOrSuper;
	private final XConstructorCallElements pXConstructorCall;
	private final XBooleanLiteralElements pXBooleanLiteral;
	private final XNullLiteralElements pXNullLiteral;
	private final XNumberLiteralElements pXNumberLiteral;
	private final XStringLiteralElements pXStringLiteral;
	private final XTypeLiteralElements pXTypeLiteral;
	private final XThrowExpressionElements pXThrowExpression;
	private final XReturnExpressionElements pXReturnExpression;
	private final XTryCatchFinallyExpressionElements pXTryCatchFinallyExpression;
	private final XSynchronizedExpressionElements pXSynchronizedExpression;
	private final XCatchClauseElements pXCatchClause;
	private final QualifiedNameElements pQualifiedName;
	private final NumberElements pNumber;
	private final StaticQualifierElements pStaticQualifier;
	private final TerminalRule tHEX;
	private final TerminalRule tINT;
	private final TerminalRule tDECIMAL;
	
	private final Grammar grammar;
	
	private final XtypeGrammarAccess gaXtype;

	@Inject
	public XbaseGrammarAccess(GrammarProvider grammarProvider,
			XtypeGrammarAccess gaXtype) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaXtype = gaXtype;
		this.pXExpression = new XExpressionElements();
		this.pXAssignment = new XAssignmentElements();
		this.pOpSingleAssign = new OpSingleAssignElements();
		this.pOpMultiAssign = new OpMultiAssignElements();
		this.pXOrExpression = new XOrExpressionElements();
		this.pOpOr = new OpOrElements();
		this.pXAndExpression = new XAndExpressionElements();
		this.pOpAnd = new OpAndElements();
		this.pXEqualityExpression = new XEqualityExpressionElements();
		this.pOpEquality = new OpEqualityElements();
		this.pXRelationalExpression = new XRelationalExpressionElements();
		this.pOpCompare = new OpCompareElements();
		this.pXOtherOperatorExpression = new XOtherOperatorExpressionElements();
		this.pOpOther = new OpOtherElements();
		this.pXAdditiveExpression = new XAdditiveExpressionElements();
		this.pOpAdd = new OpAddElements();
		this.pXMultiplicativeExpression = new XMultiplicativeExpressionElements();
		this.pOpMulti = new OpMultiElements();
		this.pXUnaryOperation = new XUnaryOperationElements();
		this.pOpUnary = new OpUnaryElements();
		this.pXCastedExpression = new XCastedExpressionElements();
		this.pXPostfixOperation = new XPostfixOperationElements();
		this.pOpPostfix = new OpPostfixElements();
		this.pXMemberFeatureCall = new XMemberFeatureCallElements();
		this.pXPrimaryExpression = new XPrimaryExpressionElements();
		this.pXLiteral = new XLiteralElements();
		this.pXCollectionLiteral = new XCollectionLiteralElements();
		this.pXSetLiteral = new XSetLiteralElements();
		this.pXListLiteral = new XListLiteralElements();
		this.pXClosure = new XClosureElements();
		this.pXExpressionInClosure = new XExpressionInClosureElements();
		this.pXShortClosure = new XShortClosureElements();
		this.pXParenthesizedExpression = new XParenthesizedExpressionElements();
		this.pXIfExpression = new XIfExpressionElements();
		this.pXSwitchExpression = new XSwitchExpressionElements();
		this.pXCasePart = new XCasePartElements();
		this.pXForLoopExpression = new XForLoopExpressionElements();
		this.pXBasicForLoopExpression = new XBasicForLoopExpressionElements();
		this.pXWhileExpression = new XWhileExpressionElements();
		this.pXDoWhileExpression = new XDoWhileExpressionElements();
		this.pXBlockExpression = new XBlockExpressionElements();
		this.pXExpressionOrVarDeclaration = new XExpressionOrVarDeclarationElements();
		this.pXVariableDeclaration = new XVariableDeclarationElements();
		this.pJvmFormalParameter = new JvmFormalParameterElements();
		this.pFullJvmFormalParameter = new FullJvmFormalParameterElements();
		this.pXFeatureCall = new XFeatureCallElements();
		this.pFeatureCallID = new FeatureCallIDElements();
		this.pIdOrSuper = new IdOrSuperElements();
		this.pXConstructorCall = new XConstructorCallElements();
		this.pXBooleanLiteral = new XBooleanLiteralElements();
		this.pXNullLiteral = new XNullLiteralElements();
		this.pXNumberLiteral = new XNumberLiteralElements();
		this.pXStringLiteral = new XStringLiteralElements();
		this.pXTypeLiteral = new XTypeLiteralElements();
		this.pXThrowExpression = new XThrowExpressionElements();
		this.pXReturnExpression = new XReturnExpressionElements();
		this.pXTryCatchFinallyExpression = new XTryCatchFinallyExpressionElements();
		this.pXSynchronizedExpression = new XSynchronizedExpressionElements();
		this.pXCatchClause = new XCatchClauseElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.pNumber = new NumberElements();
		this.pStaticQualifier = new StaticQualifierElements();
		this.tHEX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.HEX");
		this.tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.INT");
		this.tDECIMAL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xbase.DECIMAL");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.xbase.Xbase".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public XtypeGrammarAccess getXtypeGrammarAccess() {
		return gaXtype;
	}

	
	//XExpression returns XExpression :
	//    XAssignment;
	public XExpressionElements getXExpressionAccess() {
		return pXExpression;
	}
	
	public ParserRule getXExpressionRule() {
		return getXExpressionAccess().getRule();
	}
	
	//XAssignment returns XExpression :
	//    {XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |
	//    XOrExpression (
	//        =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment
	//    )?;
	public XAssignmentElements getXAssignmentAccess() {
		return pXAssignment;
	}
	
	public ParserRule getXAssignmentRule() {
		return getXAssignmentAccess().getRule();
	}
	
	//OpSingleAssign:
	//    '='
	//;
	public OpSingleAssignElements getOpSingleAssignAccess() {
		return pOpSingleAssign;
	}
	
	public ParserRule getOpSingleAssignRule() {
		return getOpSingleAssignAccess().getRule();
	}
	
	//OpMultiAssign:
	//    '+=' | '-=' | '*=' | '/=' | '%=' |
	//    '<' '<' '=' |
	//    '>' '>'? '>=';
	public OpMultiAssignElements getOpMultiAssignAccess() {
		return pOpMultiAssign;
	}
	
	public ParserRule getOpMultiAssignRule() {
		return getOpMultiAssignAccess().getRule();
	}
	
	//XOrExpression returns XExpression:
	//    XAndExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr]) rightOperand=XAndExpression)*;
	public XOrExpressionElements getXOrExpressionAccess() {
		return pXOrExpression;
	}
	
	public ParserRule getXOrExpressionRule() {
		return getXOrExpressionAccess().getRule();
	}
	
	//OpOr:
	//    '||';
	public OpOrElements getOpOrAccess() {
		return pOpOr;
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}
	
	//XAndExpression returns XExpression:
	//    XEqualityExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd]) rightOperand=XEqualityExpression)*;
	public XAndExpressionElements getXAndExpressionAccess() {
		return pXAndExpression;
	}
	
	public ParserRule getXAndExpressionRule() {
		return getXAndExpressionAccess().getRule();
	}
	
	//OpAnd:
	//    '&&';
	public OpAndElements getOpAndAccess() {
		return pOpAnd;
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}
	
	//XEqualityExpression returns XExpression:
	//    XRelationalExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
	//    rightOperand=XRelationalExpression)*;
	public XEqualityExpressionElements getXEqualityExpressionAccess() {
		return pXEqualityExpression;
	}
	
	public ParserRule getXEqualityExpressionRule() {
		return getXEqualityExpressionAccess().getRule();
	}
	
	//OpEquality:
	//    '==' | '!=' | '===' | '!==';
	public OpEqualityElements getOpEqualityAccess() {
		return pOpEquality;
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}
	
	//XRelationalExpression returns XExpression:
	//    XOtherOperatorExpression
	//    (=>({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
	//     =>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare]) rightOperand=XOtherOperatorExpression)*;
	public XRelationalExpressionElements getXRelationalExpressionAccess() {
		return pXRelationalExpression;
	}
	
	public ParserRule getXRelationalExpressionRule() {
		return getXRelationalExpressionAccess().getRule();
	}
	
	//OpCompare:
	//    '>=' | '<' '=' | '>' | '<' ;
	public OpCompareElements getOpCompareAccess() {
		return pOpCompare;
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}
	
	//XOtherOperatorExpression returns XExpression:
	//    XAdditiveExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
	//    rightOperand=XAdditiveExpression)*;
	public XOtherOperatorExpressionElements getXOtherOperatorExpressionAccess() {
		return pXOtherOperatorExpression;
	}
	
	public ParserRule getXOtherOperatorExpressionRule() {
		return getXOtherOperatorExpressionAccess().getRule();
	}
	
	//OpOther:
	//      '->'
	//    | '..<'
	//    | '>' '..'
	//    | '..'
	//    | '=>'
	//    | '>' (=>('>' '>') | '>')
	//    | '<' (=>('<' '<') | '<' | '=>')
	//    | '<>'
	//    | '?:';
	public OpOtherElements getOpOtherAccess() {
		return pOpOther;
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}
	
	//XAdditiveExpression returns XExpression:
	//    XMultiplicativeExpression (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
	//    rightOperand=XMultiplicativeExpression)*;
	public XAdditiveExpressionElements getXAdditiveExpressionAccess() {
		return pXAdditiveExpression;
	}
	
	public ParserRule getXAdditiveExpressionRule() {
		return getXAdditiveExpressionAccess().getRule();
	}
	
	//OpAdd:
	//    '+' | '-';
	public OpAddElements getOpAddAccess() {
		return pOpAdd;
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}
	
	//XMultiplicativeExpression returns XExpression:
	//    XUnaryOperation (=>({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti]) rightOperand=XUnaryOperation)*;
	public XMultiplicativeExpressionElements getXMultiplicativeExpressionAccess() {
		return pXMultiplicativeExpression;
	}
	
	public ParserRule getXMultiplicativeExpressionRule() {
		return getXMultiplicativeExpressionAccess().getRule();
	}
	
	//OpMulti:
	//    '*' | '**' | '/' | '%';
	public OpMultiElements getOpMultiAccess() {
		return pOpMulti;
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}
	
	//XUnaryOperation returns XExpression:
	//    {XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
	//    | XCastedExpression;
	public XUnaryOperationElements getXUnaryOperationAccess() {
		return pXUnaryOperation;
	}
	
	public ParserRule getXUnaryOperationRule() {
		return getXUnaryOperationAccess().getRule();
	}
	
	//OpUnary:
	//    "!" | "-" | "+";
	public OpUnaryElements getOpUnaryAccess() {
		return pOpUnary;
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}
	
	//XCastedExpression returns XExpression:
	//    XPostfixOperation (=>({XCastedExpression.target=current} 'as') type=JvmTypeReference)*
	//;
	public XCastedExpressionElements getXCastedExpressionAccess() {
		return pXCastedExpression;
	}
	
	public ParserRule getXCastedExpressionRule() {
		return getXCastedExpressionAccess().getRule();
	}
	
	//XPostfixOperation returns XExpression:
	//    XMemberFeatureCall =>({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?
	//;
	public XPostfixOperationElements getXPostfixOperationAccess() {
		return pXPostfixOperation;
	}
	
	public ParserRule getXPostfixOperationRule() {
		return getXPostfixOperationAccess().getRule();
	}
	
	//OpPostfix:
	//    "++" | "--"
	//;
	public OpPostfixElements getOpPostfixAccess() {
		return pOpPostfix;
	}
	
	public ParserRule getOpPostfixRule() {
		return getOpPostfixAccess().getRule();
	}
	
	//XMemberFeatureCall returns XExpression:
	//    XPrimaryExpression
	//    (=>({XAssignment.assignable=current} ('.'|explicitStatic?="::") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
	//    |=>({XMemberFeatureCall.memberCallTarget=current} ("."|nullSafe?="?."|explicitStatic?="::"))
	//        ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//        feature=[types::JvmIdentifiableElement|IdOrSuper] (
	//            =>explicitOperationCall?='('
	//                (
	//                    memberCallArguments+=XShortClosure
	//                  | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*
	//                )?
	//            ')')?
	//            memberCallArguments+=XClosure?
	//        )*;
	public XMemberFeatureCallElements getXMemberFeatureCallAccess() {
		return pXMemberFeatureCall;
	}
	
	public ParserRule getXMemberFeatureCallRule() {
		return getXMemberFeatureCallAccess().getRule();
	}
	
	//XPrimaryExpression returns XExpression:
	//    XConstructorCall |
	//    XBlockExpression |
	//    XSwitchExpression |
	//    XSynchronizedExpression |
	//    XFeatureCall |
	//    XLiteral |
	//    XIfExpression |
	//    XForLoopExpression |
	//    XBasicForLoopExpression |
	//    XWhileExpression |
	//    XDoWhileExpression |
	//    XThrowExpression |
	//    XReturnExpression |
	//    XTryCatchFinallyExpression |
	//    XParenthesizedExpression;
	public XPrimaryExpressionElements getXPrimaryExpressionAccess() {
		return pXPrimaryExpression;
	}
	
	public ParserRule getXPrimaryExpressionRule() {
		return getXPrimaryExpressionAccess().getRule();
	}
	
	//XLiteral returns XExpression:
	//    XCollectionLiteral |
	//    XClosure |
	//    XBooleanLiteral |
	//    XNumberLiteral |
	//    XNullLiteral |
	//    XStringLiteral |
	//    XTypeLiteral
	//;
	public XLiteralElements getXLiteralAccess() {
		return pXLiteral;
	}
	
	public ParserRule getXLiteralRule() {
		return getXLiteralAccess().getRule();
	}
	
	//XCollectionLiteral:
	//    XSetLiteral | XListLiteral
	//;
	public XCollectionLiteralElements getXCollectionLiteralAccess() {
		return pXCollectionLiteral;
	}
	
	public ParserRule getXCollectionLiteralRule() {
		return getXCollectionLiteralAccess().getRule();
	}
	
	//XSetLiteral:
	//    {XSetLiteral} '#' '{' (elements+=XExpression (',' elements+=XExpression )*)? '}'
	//;
	public XSetLiteralElements getXSetLiteralAccess() {
		return pXSetLiteral;
	}
	
	public ParserRule getXSetLiteralRule() {
		return getXSetLiteralAccess().getRule();
	}
	
	//XListLiteral:
	//    {XListLiteral} '#' '[' (elements+=XExpression (',' elements+=XExpression )*)? ']'
	//;
	public XListLiteralElements getXListLiteralAccess() {
		return pXListLiteral;
	}
	
	public ParserRule getXListLiteralRule() {
		return getXListLiteralAccess().getRule();
	}
	
	//XClosure returns XExpression:
	//    =>({XClosure}
	//    '[')
	//        =>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')?
	//        expression=XExpressionInClosure
	//    ']';
	public XClosureElements getXClosureAccess() {
		return pXClosure;
	}
	
	public ParserRule getXClosureRule() {
		return getXClosureAccess().getRule();
	}
	
	//XExpressionInClosure returns XExpression:
	//    {XBlockExpression}
	//    (expressions+=XExpressionOrVarDeclaration ';'?)*
	//;
	public XExpressionInClosureElements getXExpressionInClosureAccess() {
		return pXExpressionInClosure;
	}
	
	public ParserRule getXExpressionInClosureRule() {
		return getXExpressionInClosureAccess().getRule();
	}
	
	//XShortClosure returns XExpression:
	//    =>({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|') expression=XExpression;
	public XShortClosureElements getXShortClosureAccess() {
		return pXShortClosure;
	}
	
	public ParserRule getXShortClosureRule() {
		return getXShortClosureAccess().getRule();
	}
	
	//XParenthesizedExpression returns XExpression:
	//    '(' XExpression ')';
	public XParenthesizedExpressionElements getXParenthesizedExpressionAccess() {
		return pXParenthesizedExpression;
	}
	
	public ParserRule getXParenthesizedExpressionRule() {
		return getXParenthesizedExpressionAccess().getRule();
	}
	
	//XIfExpression returns XExpression:
	//    {XIfExpression}
	//    'if' '(' if=XExpression ')'
	//    then=XExpression
	//    (=>'else' else=XExpression)?;
	public XIfExpressionElements getXIfExpressionAccess() {
		return pXIfExpression;
	}
	
	public ParserRule getXIfExpressionRule() {
		return getXIfExpressionAccess().getRule();
	}
	
	//XSwitchExpression returns XExpression:
	//    {XSwitchExpression}
	//    'switch' (=>('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
	//        | =>(declaredParam=JvmFormalParameter ':')? switch=XExpression) '{'
	//    (cases+=XCasePart)*
	//    ('default' ':' default=XExpression )?
	//    '}';
	public XSwitchExpressionElements getXSwitchExpressionAccess() {
		return pXSwitchExpression;
	}
	
	public ParserRule getXSwitchExpressionRule() {
		return getXSwitchExpressionAccess().getRule();
	}
	
	//XCasePart:
	//    {XCasePart}
	//    typeGuard=JvmTypeReference? ('case' case=XExpression)?
	//        (':' then=XExpression | fallThrough?=',') ;
	public XCasePartElements getXCasePartAccess() {
		return pXCasePart;
	}
	
	public ParserRule getXCasePartRule() {
		return getXCasePartAccess().getRule();
	}
	
	//XForLoopExpression returns XExpression:
	//    =>({XForLoopExpression}
	//    'for' '(' declaredParam=JvmFormalParameter ':') forExpression=XExpression ')'
	//        eachExpression=XExpression;
	public XForLoopExpressionElements getXForLoopExpressionAccess() {
		return pXForLoopExpression;
	}
	
	public ParserRule getXForLoopExpressionRule() {
		return getXForLoopExpressionAccess().getRule();
	}
	
	//XBasicForLoopExpression returns XExpression:
	//    {XBasicForLoopExpression}
	//    'for' '('(initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)? ';'
	//        expression=XExpression? ';'
	//        (updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)? ')'
	//        eachExpression=XExpression;
	public XBasicForLoopExpressionElements getXBasicForLoopExpressionAccess() {
		return pXBasicForLoopExpression;
	}
	
	public ParserRule getXBasicForLoopExpressionRule() {
		return getXBasicForLoopExpressionAccess().getRule();
	}
	
	//XWhileExpression returns XExpression:
	//    {XWhileExpression}
	//    'while' '(' predicate=XExpression ')'
	//        body=XExpression;
	public XWhileExpressionElements getXWhileExpressionAccess() {
		return pXWhileExpression;
	}
	
	public ParserRule getXWhileExpressionRule() {
		return getXWhileExpressionAccess().getRule();
	}
	
	//XDoWhileExpression returns XExpression:
	//    {XDoWhileExpression}
	//    'do'
	//        body=XExpression
	//    'while' '(' predicate=XExpression ')';
	public XDoWhileExpressionElements getXDoWhileExpressionAccess() {
		return pXDoWhileExpression;
	}
	
	public ParserRule getXDoWhileExpressionRule() {
		return getXDoWhileExpressionAccess().getRule();
	}
	
	//XBlockExpression returns XExpression:
	//    {XBlockExpression}
	//    '{'
	//        (expressions+=XExpressionOrVarDeclaration ';'?)*
	//    '}';
	public XBlockExpressionElements getXBlockExpressionAccess() {
		return pXBlockExpression;
	}
	
	public ParserRule getXBlockExpressionRule() {
		return getXBlockExpressionAccess().getRule();
	}
	
	//XExpressionOrVarDeclaration returns XExpression:
	//    XVariableDeclaration | XExpression;
	public XExpressionOrVarDeclarationElements getXExpressionOrVarDeclarationAccess() {
		return pXExpressionOrVarDeclaration;
	}
	
	public ParserRule getXExpressionOrVarDeclarationRule() {
		return getXExpressionOrVarDeclarationAccess().getRule();
	}
	
	//XVariableDeclaration returns XExpression:
	//    {XVariableDeclaration}
	//    (writeable?='var'|'val') (=>(type=JvmTypeReference name=ValidID) | name=ValidID) ('=' right=XExpression)?;
	public XVariableDeclarationElements getXVariableDeclarationAccess() {
		return pXVariableDeclaration;
	}
	
	public ParserRule getXVariableDeclarationRule() {
		return getXVariableDeclarationAccess().getRule();
	}
	
	//JvmFormalParameter returns types::JvmFormalParameter:
	//    (parameterType=JvmTypeReference)? name=ValidID;
	public JvmFormalParameterElements getJvmFormalParameterAccess() {
		return pJvmFormalParameter;
	}
	
	public ParserRule getJvmFormalParameterRule() {
		return getJvmFormalParameterAccess().getRule();
	}
	
	//FullJvmFormalParameter returns types::JvmFormalParameter:
	//    parameterType=JvmTypeReference name=ValidID;
	public FullJvmFormalParameterElements getFullJvmFormalParameterAccess() {
		return pFullJvmFormalParameter;
	}
	
	public ParserRule getFullJvmFormalParameterRule() {
		return getFullJvmFormalParameterAccess().getRule();
	}
	
	//XFeatureCall returns XExpression:
	//    {XFeatureCall}
	//    ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//    feature=[types::JvmIdentifiableElement|IdOrSuper]
	//    (=>explicitOperationCall?='('
	//        (
	//            featureCallArguments+=XShortClosure
	//          | featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*
	//        )?
	//    ')')?
	//    featureCallArguments+=XClosure?;
	public XFeatureCallElements getXFeatureCallAccess() {
		return pXFeatureCall;
	}
	
	public ParserRule getXFeatureCallRule() {
		return getXFeatureCallAccess().getRule();
	}
	
	//FeatureCallID:
	//    ValidID | 'extends' | 'static' | 'import' | 'extension'
	//;
	public FeatureCallIDElements getFeatureCallIDAccess() {
		return pFeatureCallID;
	}
	
	public ParserRule getFeatureCallIDRule() {
		return getFeatureCallIDAccess().getRule();
	}
	
	//IdOrSuper :
	//    FeatureCallID | 'super'
	//;
	public IdOrSuperElements getIdOrSuperAccess() {
		return pIdOrSuper;
	}
	
	public ParserRule getIdOrSuperRule() {
		return getIdOrSuperAccess().getRule();
	}
	
	//XConstructorCall returns XExpression:
	//    {XConstructorCall}
	//    'new' constructor=[types::JvmConstructor|QualifiedName]
	//    (=>'<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//    (=>explicitConstructorCall?='('
	//        (
	//            arguments+=XShortClosure
	//          | arguments+=XExpression (',' arguments+=XExpression)*
	//        )?
	//    ')')?
	//    arguments+=XClosure?;
	public XConstructorCallElements getXConstructorCallAccess() {
		return pXConstructorCall;
	}
	
	public ParserRule getXConstructorCallRule() {
		return getXConstructorCallAccess().getRule();
	}
	
	//XBooleanLiteral returns XExpression :
	//    {XBooleanLiteral} ('false' | isTrue?='true');
	public XBooleanLiteralElements getXBooleanLiteralAccess() {
		return pXBooleanLiteral;
	}
	
	public ParserRule getXBooleanLiteralRule() {
		return getXBooleanLiteralAccess().getRule();
	}
	
	//XNullLiteral returns XExpression :
	//    {XNullLiteral} 'null';
	public XNullLiteralElements getXNullLiteralAccess() {
		return pXNullLiteral;
	}
	
	public ParserRule getXNullLiteralRule() {
		return getXNullLiteralAccess().getRule();
	}
	
	//XNumberLiteral returns XExpression :
	//    {XNumberLiteral} value=Number;
	public XNumberLiteralElements getXNumberLiteralAccess() {
		return pXNumberLiteral;
	}
	
	public ParserRule getXNumberLiteralRule() {
		return getXNumberLiteralAccess().getRule();
	}
	
	//XStringLiteral returns XExpression:
	//    {XStringLiteral} value=STRING;
	public XStringLiteralElements getXStringLiteralAccess() {
		return pXStringLiteral;
	}
	
	public ParserRule getXStringLiteralRule() {
		return getXStringLiteralAccess().getRule();
	}
	
	//XTypeLiteral returns XExpression :
	//    {XTypeLiteral} 'typeof' '(' type=[types::JvmType|QualifiedName] (arrayDimensions+=ArrayBrackets)* ')'
	//;
	public XTypeLiteralElements getXTypeLiteralAccess() {
		return pXTypeLiteral;
	}
	
	public ParserRule getXTypeLiteralRule() {
		return getXTypeLiteralAccess().getRule();
	}
	
	//XThrowExpression returns XExpression :
	//    {XThrowExpression} 'throw' expression=XExpression;
	public XThrowExpressionElements getXThrowExpressionAccess() {
		return pXThrowExpression;
	}
	
	public ParserRule getXThrowExpressionRule() {
		return getXThrowExpressionAccess().getRule();
	}
	
	//XReturnExpression returns XExpression :
	//    {XReturnExpression} 'return' (->expression=XExpression)?;
	public XReturnExpressionElements getXReturnExpressionAccess() {
		return pXReturnExpression;
	}
	
	public ParserRule getXReturnExpressionRule() {
		return getXReturnExpressionAccess().getRule();
	}
	
	//XTryCatchFinallyExpression returns XExpression:
	//    {XTryCatchFinallyExpression}
	//    'try'
	//        expression=XExpression
	//    (
	//        catchClauses+=XCatchClause+
	//        (=>'finally' finallyExpression=XExpression)?
	//    |    'finally' finallyExpression=XExpression
	//    );
	public XTryCatchFinallyExpressionElements getXTryCatchFinallyExpressionAccess() {
		return pXTryCatchFinallyExpression;
	}
	
	public ParserRule getXTryCatchFinallyExpressionRule() {
		return getXTryCatchFinallyExpressionAccess().getRule();
	}
	
	//XSynchronizedExpression returns XExpression:
	//    =>({XSynchronizedExpression}
	//    'synchronized' '(') param=XExpression ')' expression=XExpression;
	public XSynchronizedExpressionElements getXSynchronizedExpressionAccess() {
		return pXSynchronizedExpression;
	}
	
	public ParserRule getXSynchronizedExpressionRule() {
		return getXSynchronizedExpressionAccess().getRule();
	}
	
	//XCatchClause :
	//    =>'catch' '(' declaredParam=FullJvmFormalParameter ')' expression=XExpression;
	public XCatchClauseElements getXCatchClauseAccess() {
		return pXCatchClause;
	}
	
	public ParserRule getXCatchClauseRule() {
		return getXCatchClauseAccess().getRule();
	}
	
	//@Override
	//QualifiedName:
	//    ValidID (=>'.' ValidID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//Number hidden():
	//    HEX | (INT | DECIMAL) ('.' (INT | DECIMAL))?;
	public NumberElements getNumberAccess() {
		return pNumber;
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}
	
	///**
	// * Dummy rule, for "better" downwards compatibility, since GrammarAccess generates non-static inner classes,
	// * which makes downstream grammars break on classloading, when a rule is removed.
	// */
	//StaticQualifier:
	//    (ValidID '::')+
	//;
	public StaticQualifierElements getStaticQualifierAccess() {
		return pStaticQualifier;
	}
	
	public ParserRule getStaticQualifierRule() {
		return getStaticQualifierAccess().getRule();
	}
	
	//terminal HEX:
	//    ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+
	//    ('#' (('b'|'B')('i'|'I') | ('l'|'L')))?;
	public TerminalRule getHEXRule() {
		return tHEX;
	}
	
	//terminal INT returns ecore::EInt:
	//    '0'..'9' ('0'..'9'|'_')*;
	public TerminalRule getINTRule() {
		return tINT;
	}
	
	//terminal DECIMAL:
	//    INT
	//    (('e'|'E') ('+'|'-')? INT)?
	//    (('b'|'B')('i'|'I'|'d'|'D') | ('l'|'L'|'d'|'D'|'f'|'F'))?;
	public TerminalRule getDECIMALRule() {
		return tDECIMAL;
	}
	
	//JvmTypeReference:
	//    JvmParameterizedTypeReference =>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//    | XFunctionTypeRef;
	public XtypeGrammarAccess.JvmTypeReferenceElements getJvmTypeReferenceAccess() {
		return gaXtype.getJvmTypeReferenceAccess();
	}
	
	public ParserRule getJvmTypeReferenceRule() {
		return getJvmTypeReferenceAccess().getRule();
	}
	
	//ArrayBrackets :
	//    '[' ']'
	//;
	public XtypeGrammarAccess.ArrayBracketsElements getArrayBracketsAccess() {
		return gaXtype.getArrayBracketsAccess();
	}
	
	public ParserRule getArrayBracketsRule() {
		return getArrayBracketsAccess().getRule();
	}
	
	//XFunctionTypeRef:
	//    ('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XtypeGrammarAccess.XFunctionTypeRefElements getXFunctionTypeRefAccess() {
		return gaXtype.getXFunctionTypeRefAccess();
	}
	
	public ParserRule getXFunctionTypeRefRule() {
		return getXFunctionTypeRefAccess().getRule();
	}
	
	//JvmParameterizedTypeReference:
	//    type=[JvmType|QualifiedName] (
	//        =>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
	//        (=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
	//    )?;
	public XtypeGrammarAccess.JvmParameterizedTypeReferenceElements getJvmParameterizedTypeReferenceAccess() {
		return gaXtype.getJvmParameterizedTypeReferenceAccess();
	}
	
	public ParserRule getJvmParameterizedTypeReferenceRule() {
		return getJvmParameterizedTypeReferenceAccess().getRule();
	}
	
	//JvmArgumentTypeReference returns JvmTypeReference:
	//    JvmTypeReference | JvmWildcardTypeReference;
	public XtypeGrammarAccess.JvmArgumentTypeReferenceElements getJvmArgumentTypeReferenceAccess() {
		return gaXtype.getJvmArgumentTypeReferenceAccess();
	}
	
	public ParserRule getJvmArgumentTypeReferenceRule() {
		return getJvmArgumentTypeReferenceAccess().getRule();
	}
	
	//JvmWildcardTypeReference:
	//    {JvmWildcardTypeReference} '?' (
	//      constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
	//    | constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
	//    )?;
	public XtypeGrammarAccess.JvmWildcardTypeReferenceElements getJvmWildcardTypeReferenceAccess() {
		return gaXtype.getJvmWildcardTypeReferenceAccess();
	}
	
	public ParserRule getJvmWildcardTypeReferenceRule() {
		return getJvmWildcardTypeReferenceAccess().getRule();
	}
	
	//JvmUpperBound :
	//    'extends' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundElements getJvmUpperBoundAccess() {
		return gaXtype.getJvmUpperBoundAccess();
	}
	
	public ParserRule getJvmUpperBoundRule() {
		return getJvmUpperBoundAccess().getRule();
	}
	
	//JvmUpperBoundAnded returns JvmUpperBound:
	//    '&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundAndedElements getJvmUpperBoundAndedAccess() {
		return gaXtype.getJvmUpperBoundAndedAccess();
	}
	
	public ParserRule getJvmUpperBoundAndedRule() {
		return getJvmUpperBoundAndedAccess().getRule();
	}
	
	//JvmLowerBound :
	//    'super' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundElements getJvmLowerBoundAccess() {
		return gaXtype.getJvmLowerBoundAccess();
	}
	
	public ParserRule getJvmLowerBoundRule() {
		return getJvmLowerBoundAccess().getRule();
	}
	
	//JvmLowerBoundAnded returns JvmLowerBound:
	//    '&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundAndedElements getJvmLowerBoundAndedAccess() {
		return gaXtype.getJvmLowerBoundAndedAccess();
	}
	
	public ParserRule getJvmLowerBoundAndedRule() {
		return getJvmLowerBoundAndedAccess().getRule();
	}
	
	//JvmTypeParameter :
	//    name=ValidID
	//    (constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*)?;
	public XtypeGrammarAccess.JvmTypeParameterElements getJvmTypeParameterAccess() {
		return gaXtype.getJvmTypeParameterAccess();
	}
	
	public ParserRule getJvmTypeParameterRule() {
		return getJvmTypeParameterAccess().getRule();
	}
	
	//QualifiedNameWithWildcard :
	//    QualifiedName  '.' '*';
	public XtypeGrammarAccess.QualifiedNameWithWildcardElements getQualifiedNameWithWildcardAccess() {
		return gaXtype.getQualifiedNameWithWildcardAccess();
	}
	
	public ParserRule getQualifiedNameWithWildcardRule() {
		return getQualifiedNameWithWildcardAccess().getRule();
	}
	
	//ValidID:
	//    ID;
	public XtypeGrammarAccess.ValidIDElements getValidIDAccess() {
		return gaXtype.getValidIDAccess();
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//XImportSection:
	//    importDeclarations+=XImportDeclaration+;
	public XtypeGrammarAccess.XImportSectionElements getXImportSectionAccess() {
		return gaXtype.getXImportSectionAccess();
	}
	
	public ParserRule getXImportSectionRule() {
		return getXImportSectionAccess().getRule();
	}
	
	//XImportDeclaration:
	//    'import' (
	//        (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID))
	//        | importedType=[JvmDeclaredType|QualifiedName]
	//        | importedNamespace=QualifiedNameWithWildcard) ';'?
	//;
	public XtypeGrammarAccess.XImportDeclarationElements getXImportDeclarationAccess() {
		return gaXtype.getXImportDeclarationAccess();
	}
	
	public ParserRule getXImportDeclarationRule() {
		return getXImportDeclarationAccess().getRule();
	}
	
	//QualifiedNameInStaticImport:
	//    (ValidID '.')+
	//;
	public XtypeGrammarAccess.QualifiedNameInStaticImportElements getQualifiedNameInStaticImportAccess() {
		return gaXtype.getQualifiedNameInStaticImportAccess();
	}
	
	public ParserRule getQualifiedNameInStaticImportRule() {
		return getQualifiedNameInStaticImportAccess().getRule();
	}
	
	//terminal ID:
	//    '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaXtype.getIDRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') */ | !('\\'|'"') )* '"'? |
	//            "'" ( '\\' . /* ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') */ | !('\\'|"'") )* "'"?;
	public TerminalRule getSTRINGRule() {
		return gaXtype.getSTRINGRule();
	}
	
	//terminal ML_COMMENT: '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaXtype.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT: '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaXtype.getSL_COMMENTRule();
	}
	
	//terminal WS: (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaXtype.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaXtype.getANY_OTHERRule();
	}
}
