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
public class XtypeGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class JvmTypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cJvmParameterizedTypeReferenceParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Group cGroup_0_1_0 = (Group)cGroup_0_1.eContents().get(0);
		private final Action cJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0 = (Action)cGroup_0_1_0.eContents().get(0);
		private final RuleCall cArrayBracketsParserRuleCall_0_1_0_1 = (RuleCall)cGroup_0_1_0.eContents().get(1);
		private final RuleCall cXFunctionTypeRefParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//JvmTypeReference:
		//    JvmParameterizedTypeReference =>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		//    | XFunctionTypeRef;
		@Override public ParserRule getRule() { return rule; }
		
		//JvmParameterizedTypeReference =>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		//| XFunctionTypeRef
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//JvmParameterizedTypeReference =>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		public Group getGroup_0() { return cGroup_0; }
		
		//JvmParameterizedTypeReference
		public RuleCall getJvmParameterizedTypeReferenceParserRuleCall_0_0() { return cJvmParameterizedTypeReferenceParserRuleCall_0_0; }
		
		//=>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//{JvmGenericArrayTypeReference.componentType=current} ArrayBrackets
		public Group getGroup_0_1_0() { return cGroup_0_1_0; }
		
		//{JvmGenericArrayTypeReference.componentType=current}
		public Action getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0() { return cJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0; }
		
		//ArrayBrackets
		public RuleCall getArrayBracketsParserRuleCall_0_1_0_1() { return cArrayBracketsParserRuleCall_0_1_0_1; }
		
		//XFunctionTypeRef
		public RuleCall getXFunctionTypeRefParserRuleCall_1() { return cXFunctionTypeRefParserRuleCall_1; }
	}
	public class ArrayBracketsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//ArrayBrackets :
		//    '[' ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'[' ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_1() { return cRightSquareBracketKeyword_1; }
	}
	public class XFunctionTypeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.XFunctionTypeRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Assignment cParamTypesAssignment_0_1_0 = (Assignment)cGroup_0_1.eContents().get(0);
		private final RuleCall cParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0 = (RuleCall)cParamTypesAssignment_0_1_0.eContents().get(0);
		private final Group cGroup_0_1_1 = (Group)cGroup_0_1.eContents().get(1);
		private final Keyword cCommaKeyword_0_1_1_0 = (Keyword)cGroup_0_1_1.eContents().get(0);
		private final Assignment cParamTypesAssignment_0_1_1_1 = (Assignment)cGroup_0_1_1.eContents().get(1);
		private final RuleCall cParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0 = (RuleCall)cParamTypesAssignment_0_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReturnTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cReturnTypeJvmTypeReferenceParserRuleCall_2_0 = (RuleCall)cReturnTypeAssignment_2.eContents().get(0);
		
		//XFunctionTypeRef:
		//    ('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')?
		public Group getGroup_0() { return cGroup_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }
		
		//(paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)?
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//paramTypes+=JvmTypeReference
		public Assignment getParamTypesAssignment_0_1_0() { return cParamTypesAssignment_0_1_0; }
		
		//JvmTypeReference
		public RuleCall getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0() { return cParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0; }
		
		//(',' paramTypes+=JvmTypeReference)*
		public Group getGroup_0_1_1() { return cGroup_0_1_1; }
		
		//','
		public Keyword getCommaKeyword_0_1_1_0() { return cCommaKeyword_0_1_1_0; }
		
		//paramTypes+=JvmTypeReference
		public Assignment getParamTypesAssignment_0_1_1_1() { return cParamTypesAssignment_0_1_1_1; }
		
		//JvmTypeReference
		public RuleCall getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0() { return cParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_2() { return cRightParenthesisKeyword_0_2; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }
		
		//returnType=JvmTypeReference
		public Assignment getReturnTypeAssignment_2() { return cReturnTypeAssignment_2; }
		
		//JvmTypeReference
		public RuleCall getReturnTypeJvmTypeReferenceParserRuleCall_2_0() { return cReturnTypeJvmTypeReferenceParserRuleCall_2_0; }
	}
	public class JvmParameterizedTypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmParameterizedTypeReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cTypeJvmTypeCrossReference_0_0 = (CrossReference)cTypeAssignment_0.eContents().get(0);
		private final RuleCall cTypeJvmTypeQualifiedNameParserRuleCall_0_0_1 = (RuleCall)cTypeJvmTypeCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0 = (RuleCall)cArgumentsAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cCommaKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0 = (RuleCall)cArgumentsAssignment_1_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_3 = (Keyword)cGroup_1.eContents().get(3);
		private final Group cGroup_1_4 = (Group)cGroup_1.eContents().get(4);
		private final Group cGroup_1_4_0 = (Group)cGroup_1_4.eContents().get(0);
		private final Group cGroup_1_4_0_0 = (Group)cGroup_1_4_0.eContents().get(0);
		private final Action cJvmInnerTypeReferenceOuterAction_1_4_0_0_0 = (Action)cGroup_1_4_0_0.eContents().get(0);
		private final Keyword cFullStopKeyword_1_4_0_0_1 = (Keyword)cGroup_1_4_0_0.eContents().get(1);
		private final Assignment cTypeAssignment_1_4_1 = (Assignment)cGroup_1_4.eContents().get(1);
		private final CrossReference cTypeJvmTypeCrossReference_1_4_1_0 = (CrossReference)cTypeAssignment_1_4_1.eContents().get(0);
		private final RuleCall cTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1 = (RuleCall)cTypeJvmTypeCrossReference_1_4_1_0.eContents().get(1);
		private final Group cGroup_1_4_2 = (Group)cGroup_1_4.eContents().get(2);
		private final Keyword cLessThanSignKeyword_1_4_2_0 = (Keyword)cGroup_1_4_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_4_2_1 = (Assignment)cGroup_1_4_2.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0 = (RuleCall)cArgumentsAssignment_1_4_2_1.eContents().get(0);
		private final Group cGroup_1_4_2_2 = (Group)cGroup_1_4_2.eContents().get(2);
		private final Keyword cCommaKeyword_1_4_2_2_0 = (Keyword)cGroup_1_4_2_2.eContents().get(0);
		private final Assignment cArgumentsAssignment_1_4_2_2_1 = (Assignment)cGroup_1_4_2_2.eContents().get(1);
		private final RuleCall cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0 = (RuleCall)cArgumentsAssignment_1_4_2_2_1.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1_4_2_3 = (Keyword)cGroup_1_4_2.eContents().get(3);
		
		//JvmParameterizedTypeReference:
		//    type=[JvmType|QualifiedName] (
		//        =>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
		//        (=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		//    )?;
		@Override public ParserRule getRule() { return rule; }
		
		//type=[JvmType|QualifiedName] (
		//    =>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
		//    (=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		//)?
		public Group getGroup() { return cGroup; }
		
		//type=[JvmType|QualifiedName]
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }
		
		//[JvmType|QualifiedName]
		public CrossReference getTypeJvmTypeCrossReference_0_0() { return cTypeJvmTypeCrossReference_0_0; }
		
		//QualifiedName
		public RuleCall getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1() { return cTypeJvmTypeQualifiedNameParserRuleCall_0_0_1; }
		
		//(
		//       =>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
		//       (=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		//   )?
		public Group getGroup_1() { return cGroup_1; }
		
		//=>'<'
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_1() { return cArgumentsAssignment_1_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0; }
		
		//(',' arguments+=JvmArgumentTypeReference)*
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//','
		public Keyword getCommaKeyword_1_2_0() { return cCommaKeyword_1_2_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_2_1() { return cArgumentsAssignment_1_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_3() { return cGreaterThanSignKeyword_1_3; }
		
		//(=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
		public Group getGroup_1_4() { return cGroup_1_4; }
		
		//=>({JvmInnerTypeReference.outer=current} '.')
		public Group getGroup_1_4_0() { return cGroup_1_4_0; }
		
		//{JvmInnerTypeReference.outer=current} '.'
		public Group getGroup_1_4_0_0() { return cGroup_1_4_0_0; }
		
		//{JvmInnerTypeReference.outer=current}
		public Action getJvmInnerTypeReferenceOuterAction_1_4_0_0_0() { return cJvmInnerTypeReferenceOuterAction_1_4_0_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_4_0_0_1() { return cFullStopKeyword_1_4_0_0_1; }
		
		//type=[JvmType|ValidID]
		public Assignment getTypeAssignment_1_4_1() { return cTypeAssignment_1_4_1; }
		
		//[JvmType|ValidID]
		public CrossReference getTypeJvmTypeCrossReference_1_4_1_0() { return cTypeJvmTypeCrossReference_1_4_1_0; }
		
		//ValidID
		public RuleCall getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1() { return cTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1; }
		
		//(=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?
		public Group getGroup_1_4_2() { return cGroup_1_4_2; }
		
		//=>'<'
		public Keyword getLessThanSignKeyword_1_4_2_0() { return cLessThanSignKeyword_1_4_2_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_4_2_1() { return cArgumentsAssignment_1_4_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0; }
		
		//(',' arguments+=JvmArgumentTypeReference)*
		public Group getGroup_1_4_2_2() { return cGroup_1_4_2_2; }
		
		//','
		public Keyword getCommaKeyword_1_4_2_2_0() { return cCommaKeyword_1_4_2_2_0; }
		
		//arguments+=JvmArgumentTypeReference
		public Assignment getArgumentsAssignment_1_4_2_2_1() { return cArgumentsAssignment_1_4_2_2_1; }
		
		//JvmArgumentTypeReference
		public RuleCall getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0() { return cArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1_4_2_3() { return cGreaterThanSignKeyword_1_4_2_3; }
	}
	public class JvmArgumentTypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cJvmTypeReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cJvmWildcardTypeReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//JvmArgumentTypeReference returns JvmTypeReference:
		//    JvmTypeReference | JvmWildcardTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//JvmTypeReference | JvmWildcardTypeReference
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//JvmTypeReference
		public RuleCall getJvmTypeReferenceParserRuleCall_0() { return cJvmTypeReferenceParserRuleCall_0; }
		
		//JvmWildcardTypeReference
		public RuleCall getJvmWildcardTypeReferenceParserRuleCall_1() { return cJvmWildcardTypeReferenceParserRuleCall_1; }
	}
	public class JvmWildcardTypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmWildcardTypeReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cJvmWildcardTypeReferenceAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cQuestionMarkKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Assignment cConstraintsAssignment_2_0_0 = (Assignment)cGroup_2_0.eContents().get(0);
		private final RuleCall cConstraintsJvmUpperBoundParserRuleCall_2_0_0_0 = (RuleCall)cConstraintsAssignment_2_0_0.eContents().get(0);
		private final Assignment cConstraintsAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0 = (RuleCall)cConstraintsAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Assignment cConstraintsAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cConstraintsJvmLowerBoundParserRuleCall_2_1_0_0 = (RuleCall)cConstraintsAssignment_2_1_0.eContents().get(0);
		private final Assignment cConstraintsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0 = (RuleCall)cConstraintsAssignment_2_1_1.eContents().get(0);
		
		//JvmWildcardTypeReference:
		//    {JvmWildcardTypeReference} '?' (
		//      constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
		//    | constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
		//    )?;
		@Override public ParserRule getRule() { return rule; }
		
		//{JvmWildcardTypeReference} '?' (
		//  constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
		//| constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
		//)?
		public Group getGroup() { return cGroup; }
		
		//{JvmWildcardTypeReference}
		public Action getJvmWildcardTypeReferenceAction_0() { return cJvmWildcardTypeReferenceAction_0; }
		
		//'?'
		public Keyword getQuestionMarkKeyword_1() { return cQuestionMarkKeyword_1; }
		
		//(
		//     constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
		//   | constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
		//   )?
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
		public Group getGroup_2_0() { return cGroup_2_0; }
		
		//constraints+=JvmUpperBound
		public Assignment getConstraintsAssignment_2_0_0() { return cConstraintsAssignment_2_0_0; }
		
		//JvmUpperBound
		public RuleCall getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0() { return cConstraintsJvmUpperBoundParserRuleCall_2_0_0_0; }
		
		//(constraints+=JvmUpperBoundAnded)*
		public Assignment getConstraintsAssignment_2_0_1() { return cConstraintsAssignment_2_0_1; }
		
		//JvmUpperBoundAnded
		public RuleCall getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0() { return cConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0; }
		
		//constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//constraints+=JvmLowerBound
		public Assignment getConstraintsAssignment_2_1_0() { return cConstraintsAssignment_2_1_0; }
		
		//JvmLowerBound
		public RuleCall getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0() { return cConstraintsJvmLowerBoundParserRuleCall_2_1_0_0; }
		
		//(constraints+=JvmLowerBoundAnded)*
		public Assignment getConstraintsAssignment_2_1_1() { return cConstraintsAssignment_2_1_1; }
		
		//JvmLowerBoundAnded
		public RuleCall getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0() { return cConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0; }
	}
	public class JvmUpperBoundElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cExtendsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeReferenceJvmTypeReferenceParserRuleCall_1_0 = (RuleCall)cTypeReferenceAssignment_1.eContents().get(0);
		
		//JvmUpperBound :
		//    'extends' typeReference=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//'extends' typeReference=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//'extends'
		public Keyword getExtendsKeyword_0() { return cExtendsKeyword_0; }
		
		//typeReference=JvmTypeReference
		public Assignment getTypeReferenceAssignment_1() { return cTypeReferenceAssignment_1; }
		
		//JvmTypeReference
		public RuleCall getTypeReferenceJvmTypeReferenceParserRuleCall_1_0() { return cTypeReferenceJvmTypeReferenceParserRuleCall_1_0; }
	}
	public class JvmUpperBoundAndedElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAmpersandKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeReferenceJvmTypeReferenceParserRuleCall_1_0 = (RuleCall)cTypeReferenceAssignment_1.eContents().get(0);
		
		//JvmUpperBoundAnded returns JvmUpperBound:
		//    '&' typeReference=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//'&' typeReference=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//'&'
		public Keyword getAmpersandKeyword_0() { return cAmpersandKeyword_0; }
		
		//typeReference=JvmTypeReference
		public Assignment getTypeReferenceAssignment_1() { return cTypeReferenceAssignment_1; }
		
		//JvmTypeReference
		public RuleCall getTypeReferenceJvmTypeReferenceParserRuleCall_1_0() { return cTypeReferenceJvmTypeReferenceParserRuleCall_1_0; }
	}
	public class JvmLowerBoundElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSuperKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeReferenceJvmTypeReferenceParserRuleCall_1_0 = (RuleCall)cTypeReferenceAssignment_1.eContents().get(0);
		
		//JvmLowerBound :
		//    'super' typeReference=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//'super' typeReference=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//'super'
		public Keyword getSuperKeyword_0() { return cSuperKeyword_0; }
		
		//typeReference=JvmTypeReference
		public Assignment getTypeReferenceAssignment_1() { return cTypeReferenceAssignment_1; }
		
		//JvmTypeReference
		public RuleCall getTypeReferenceJvmTypeReferenceParserRuleCall_1_0() { return cTypeReferenceJvmTypeReferenceParserRuleCall_1_0; }
	}
	public class JvmLowerBoundAndedElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAmpersandKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTypeReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTypeReferenceJvmTypeReferenceParserRuleCall_1_0 = (RuleCall)cTypeReferenceAssignment_1.eContents().get(0);
		
		//JvmLowerBoundAnded returns JvmLowerBound:
		//    '&' typeReference=JvmTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//'&' typeReference=JvmTypeReference
		public Group getGroup() { return cGroup; }
		
		//'&'
		public Keyword getAmpersandKeyword_0() { return cAmpersandKeyword_0; }
		
		//typeReference=JvmTypeReference
		public Assignment getTypeReferenceAssignment_1() { return cTypeReferenceAssignment_1; }
		
		//JvmTypeReference
		public RuleCall getTypeReferenceJvmTypeReferenceParserRuleCall_1_0() { return cTypeReferenceJvmTypeReferenceParserRuleCall_1_0; }
	}
	public class JvmTypeParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.JvmTypeParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameValidIDParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cConstraintsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cConstraintsJvmUpperBoundParserRuleCall_1_0_0 = (RuleCall)cConstraintsAssignment_1_0.eContents().get(0);
		private final Assignment cConstraintsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0 = (RuleCall)cConstraintsAssignment_1_1.eContents().get(0);
		
		//JvmTypeParameter :
		//    name=ValidID
		//    (constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ValidID
		//(constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*)?
		public Group getGroup() { return cGroup; }
		
		//name=ValidID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_0_0() { return cNameValidIDParserRuleCall_0_0; }
		
		//(constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//constraints+=JvmUpperBound
		public Assignment getConstraintsAssignment_1_0() { return cConstraintsAssignment_1_0; }
		
		//JvmUpperBound
		public RuleCall getConstraintsJvmUpperBoundParserRuleCall_1_0_0() { return cConstraintsJvmUpperBoundParserRuleCall_1_0_0; }
		
		//(constraints+=JvmUpperBoundAnded)*
		public Assignment getConstraintsAssignment_1_1() { return cConstraintsAssignment_1_1; }
		
		//JvmUpperBoundAnded
		public RuleCall getConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0() { return cConstraintsJvmUpperBoundAndedParserRuleCall_1_1_0; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cValidIDParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//    ValidID ('.' ValidID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ValidID ('.' ValidID)*
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//('.' ValidID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_1_1() { return cValidIDParserRuleCall_1_1; }
	}
	public class QualifiedNameWithWildcardElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cQualifiedNameParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cAsteriskKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//QualifiedNameWithWildcard :
		//    QualifiedName  '.' '*';
		@Override public ParserRule getRule() { return rule; }
		
		//QualifiedName  '.' '*'
		public Group getGroup() { return cGroup; }
		
		//QualifiedName
		public RuleCall getQualifiedNameParserRuleCall_0() { return cQualifiedNameParserRuleCall_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
		
		//'*'
		public Keyword getAsteriskKeyword_2() { return cAsteriskKeyword_2; }
	}
	public class ValidIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.ValidID");
		private final RuleCall cIDTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ValidID:
		//    ID;
		@Override public ParserRule getRule() { return rule; }
		
		//ID
		public RuleCall getIDTerminalRuleCall() { return cIDTerminalRuleCall; }
	}
	public class XImportSectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.XImportSection");
		private final Assignment cImportDeclarationsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cImportDeclarationsXImportDeclarationParserRuleCall_0 = (RuleCall)cImportDeclarationsAssignment.eContents().get(0);
		
		//XImportSection:
		//    importDeclarations+=XImportDeclaration+;
		@Override public ParserRule getRule() { return rule; }
		
		//importDeclarations+=XImportDeclaration+
		public Assignment getImportDeclarationsAssignment() { return cImportDeclarationsAssignment; }
		
		//XImportDeclaration
		public RuleCall getImportDeclarationsXImportDeclarationParserRuleCall_0() { return cImportDeclarationsXImportDeclarationParserRuleCall_0; }
	}
	public class XImportDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.XImportDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cStaticAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final Keyword cStaticStaticKeyword_1_0_0_0 = (Keyword)cStaticAssignment_1_0_0.eContents().get(0);
		private final Assignment cExtensionAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Keyword cExtensionExtensionKeyword_1_0_1_0 = (Keyword)cExtensionAssignment_1_0_1.eContents().get(0);
		private final Assignment cImportedTypeAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final CrossReference cImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0 = (CrossReference)cImportedTypeAssignment_1_0_2.eContents().get(0);
		private final RuleCall cImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1 = (RuleCall)cImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0.eContents().get(1);
		private final Alternatives cAlternatives_1_0_3 = (Alternatives)cGroup_1_0.eContents().get(3);
		private final Assignment cWildcardAssignment_1_0_3_0 = (Assignment)cAlternatives_1_0_3.eContents().get(0);
		private final Keyword cWildcardAsteriskKeyword_1_0_3_0_0 = (Keyword)cWildcardAssignment_1_0_3_0.eContents().get(0);
		private final Assignment cMemberNameAssignment_1_0_3_1 = (Assignment)cAlternatives_1_0_3.eContents().get(1);
		private final RuleCall cMemberNameValidIDParserRuleCall_1_0_3_1_0 = (RuleCall)cMemberNameAssignment_1_0_3_1.eContents().get(0);
		private final Assignment cImportedTypeAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final CrossReference cImportedTypeJvmDeclaredTypeCrossReference_1_1_0 = (CrossReference)cImportedTypeAssignment_1_1.eContents().get(0);
		private final RuleCall cImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1 = (RuleCall)cImportedTypeJvmDeclaredTypeCrossReference_1_1_0.eContents().get(1);
		private final Assignment cImportedNamespaceAssignment_1_2 = (Assignment)cAlternatives_1.eContents().get(2);
		private final RuleCall cImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0 = (RuleCall)cImportedNamespaceAssignment_1_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//XImportDeclaration:
		//    'import' (
		//        (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID))
		//        | importedType=[JvmDeclaredType|QualifiedName]
		//        | importedNamespace=QualifiedNameWithWildcard) ';'?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'import' (
		//    (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID))
		//    | importedType=[JvmDeclaredType|QualifiedName]
		//    | importedNamespace=QualifiedNameWithWildcard) ';'?
		public Group getGroup() { return cGroup; }
		
		//'import'
		public Keyword getImportKeyword_0() { return cImportKeyword_0; }
		
		//(
		//       (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID))
		//       | importedType=[JvmDeclaredType|QualifiedName]
		//       | importedNamespace=QualifiedNameWithWildcard)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//(static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID))
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//static?='static'
		public Assignment getStaticAssignment_1_0_0() { return cStaticAssignment_1_0_0; }
		
		//'static'
		public Keyword getStaticStaticKeyword_1_0_0_0() { return cStaticStaticKeyword_1_0_0_0; }
		
		//extension?='extension'?
		public Assignment getExtensionAssignment_1_0_1() { return cExtensionAssignment_1_0_1; }
		
		//'extension'
		public Keyword getExtensionExtensionKeyword_1_0_1_0() { return cExtensionExtensionKeyword_1_0_1_0; }
		
		//importedType=[JvmDeclaredType|QualifiedNameInStaticImport]
		public Assignment getImportedTypeAssignment_1_0_2() { return cImportedTypeAssignment_1_0_2; }
		
		//[JvmDeclaredType|QualifiedNameInStaticImport]
		public CrossReference getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0() { return cImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0; }
		
		//QualifiedNameInStaticImport
		public RuleCall getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1() { return cImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1; }
		
		//(wildcard?='*' | memberName=ValidID)
		public Alternatives getAlternatives_1_0_3() { return cAlternatives_1_0_3; }
		
		//wildcard?='*'
		public Assignment getWildcardAssignment_1_0_3_0() { return cWildcardAssignment_1_0_3_0; }
		
		//'*'
		public Keyword getWildcardAsteriskKeyword_1_0_3_0_0() { return cWildcardAsteriskKeyword_1_0_3_0_0; }
		
		//memberName=ValidID
		public Assignment getMemberNameAssignment_1_0_3_1() { return cMemberNameAssignment_1_0_3_1; }
		
		//ValidID
		public RuleCall getMemberNameValidIDParserRuleCall_1_0_3_1_0() { return cMemberNameValidIDParserRuleCall_1_0_3_1_0; }
		
		//importedType=[JvmDeclaredType|QualifiedName]
		public Assignment getImportedTypeAssignment_1_1() { return cImportedTypeAssignment_1_1; }
		
		//[JvmDeclaredType|QualifiedName]
		public CrossReference getImportedTypeJvmDeclaredTypeCrossReference_1_1_0() { return cImportedTypeJvmDeclaredTypeCrossReference_1_1_0; }
		
		//QualifiedName
		public RuleCall getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1() { return cImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1; }
		
		//importedNamespace=QualifiedNameWithWildcard
		public Assignment getImportedNamespaceAssignment_1_2() { return cImportedNamespaceAssignment_1_2; }
		
		//QualifiedNameWithWildcard
		public RuleCall getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0() { return cImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class QualifiedNameInStaticImportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.QualifiedNameInStaticImport");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cValidIDParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//QualifiedNameInStaticImport:
		//    (ValidID '.')+
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(ValidID '.')+
		public Group getGroup() { return cGroup; }
		
		//ValidID
		public RuleCall getValidIDParserRuleCall_0() { return cValidIDParserRuleCall_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
	}
	
	
	private final JvmTypeReferenceElements pJvmTypeReference;
	private final ArrayBracketsElements pArrayBrackets;
	private final XFunctionTypeRefElements pXFunctionTypeRef;
	private final JvmParameterizedTypeReferenceElements pJvmParameterizedTypeReference;
	private final JvmArgumentTypeReferenceElements pJvmArgumentTypeReference;
	private final JvmWildcardTypeReferenceElements pJvmWildcardTypeReference;
	private final JvmUpperBoundElements pJvmUpperBound;
	private final JvmUpperBoundAndedElements pJvmUpperBoundAnded;
	private final JvmLowerBoundElements pJvmLowerBound;
	private final JvmLowerBoundAndedElements pJvmLowerBoundAnded;
	private final JvmTypeParameterElements pJvmTypeParameter;
	private final QualifiedNameElements pQualifiedName;
	private final QualifiedNameWithWildcardElements pQualifiedNameWithWildcard;
	private final ValidIDElements pValidID;
	private final XImportSectionElements pXImportSection;
	private final XImportDeclarationElements pXImportDeclaration;
	private final QualifiedNameInStaticImportElements pQualifiedNameInStaticImport;
	private final TerminalRule tID;
	private final TerminalRule tSTRING;
	private final TerminalRule tML_COMMENT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tWS;
	private final TerminalRule tANY_OTHER;
	
	private final Grammar grammar;

	@Inject
	public XtypeGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pJvmTypeReference = new JvmTypeReferenceElements();
		this.pArrayBrackets = new ArrayBracketsElements();
		this.pXFunctionTypeRef = new XFunctionTypeRefElements();
		this.pJvmParameterizedTypeReference = new JvmParameterizedTypeReferenceElements();
		this.pJvmArgumentTypeReference = new JvmArgumentTypeReferenceElements();
		this.pJvmWildcardTypeReference = new JvmWildcardTypeReferenceElements();
		this.pJvmUpperBound = new JvmUpperBoundElements();
		this.pJvmUpperBoundAnded = new JvmUpperBoundAndedElements();
		this.pJvmLowerBound = new JvmLowerBoundElements();
		this.pJvmLowerBoundAnded = new JvmLowerBoundAndedElements();
		this.pJvmTypeParameter = new JvmTypeParameterElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.pQualifiedNameWithWildcard = new QualifiedNameWithWildcardElements();
		this.pValidID = new ValidIDElements();
		this.pXImportSection = new XImportSectionElements();
		this.pXImportDeclaration = new XImportDeclarationElements();
		this.pQualifiedNameInStaticImport = new QualifiedNameInStaticImportElements();
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.ID");
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.STRING");
		this.tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.ML_COMMENT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.SL_COMMENT");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.WS");
		this.tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.xbase.Xtype.ANY_OTHER");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.xbase.Xtype".equals(grammar.getName())) {
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
	

	
	//JvmTypeReference:
	//    JvmParameterizedTypeReference =>({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//    | XFunctionTypeRef;
	public JvmTypeReferenceElements getJvmTypeReferenceAccess() {
		return pJvmTypeReference;
	}
	
	public ParserRule getJvmTypeReferenceRule() {
		return getJvmTypeReferenceAccess().getRule();
	}
	
	//ArrayBrackets :
	//    '[' ']'
	//;
	public ArrayBracketsElements getArrayBracketsAccess() {
		return pArrayBrackets;
	}
	
	public ParserRule getArrayBracketsRule() {
		return getArrayBracketsAccess().getRule();
	}
	
	//XFunctionTypeRef:
	//    ('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XFunctionTypeRefElements getXFunctionTypeRefAccess() {
		return pXFunctionTypeRef;
	}
	
	public ParserRule getXFunctionTypeRefRule() {
		return getXFunctionTypeRefAccess().getRule();
	}
	
	//JvmParameterizedTypeReference:
	//    type=[JvmType|QualifiedName] (
	//        =>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'
	//        (=>({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*
	//    )?;
	public JvmParameterizedTypeReferenceElements getJvmParameterizedTypeReferenceAccess() {
		return pJvmParameterizedTypeReference;
	}
	
	public ParserRule getJvmParameterizedTypeReferenceRule() {
		return getJvmParameterizedTypeReferenceAccess().getRule();
	}
	
	//JvmArgumentTypeReference returns JvmTypeReference:
	//    JvmTypeReference | JvmWildcardTypeReference;
	public JvmArgumentTypeReferenceElements getJvmArgumentTypeReferenceAccess() {
		return pJvmArgumentTypeReference;
	}
	
	public ParserRule getJvmArgumentTypeReferenceRule() {
		return getJvmArgumentTypeReferenceAccess().getRule();
	}
	
	//JvmWildcardTypeReference:
	//    {JvmWildcardTypeReference} '?' (
	//      constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*
	//    | constraints+=JvmLowerBound (constraints+=JvmLowerBoundAnded)*
	//    )?;
	public JvmWildcardTypeReferenceElements getJvmWildcardTypeReferenceAccess() {
		return pJvmWildcardTypeReference;
	}
	
	public ParserRule getJvmWildcardTypeReferenceRule() {
		return getJvmWildcardTypeReferenceAccess().getRule();
	}
	
	//JvmUpperBound :
	//    'extends' typeReference=JvmTypeReference;
	public JvmUpperBoundElements getJvmUpperBoundAccess() {
		return pJvmUpperBound;
	}
	
	public ParserRule getJvmUpperBoundRule() {
		return getJvmUpperBoundAccess().getRule();
	}
	
	//JvmUpperBoundAnded returns JvmUpperBound:
	//    '&' typeReference=JvmTypeReference;
	public JvmUpperBoundAndedElements getJvmUpperBoundAndedAccess() {
		return pJvmUpperBoundAnded;
	}
	
	public ParserRule getJvmUpperBoundAndedRule() {
		return getJvmUpperBoundAndedAccess().getRule();
	}
	
	//JvmLowerBound :
	//    'super' typeReference=JvmTypeReference;
	public JvmLowerBoundElements getJvmLowerBoundAccess() {
		return pJvmLowerBound;
	}
	
	public ParserRule getJvmLowerBoundRule() {
		return getJvmLowerBoundAccess().getRule();
	}
	
	//JvmLowerBoundAnded returns JvmLowerBound:
	//    '&' typeReference=JvmTypeReference;
	public JvmLowerBoundAndedElements getJvmLowerBoundAndedAccess() {
		return pJvmLowerBoundAnded;
	}
	
	public ParserRule getJvmLowerBoundAndedRule() {
		return getJvmLowerBoundAndedAccess().getRule();
	}
	
	//JvmTypeParameter :
	//    name=ValidID
	//    (constraints+=JvmUpperBound (constraints+=JvmUpperBoundAnded)*)?;
	public JvmTypeParameterElements getJvmTypeParameterAccess() {
		return pJvmTypeParameter;
	}
	
	public ParserRule getJvmTypeParameterRule() {
		return getJvmTypeParameterAccess().getRule();
	}
	
	//QualifiedName:
	//    ValidID ('.' ValidID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//QualifiedNameWithWildcard :
	//    QualifiedName  '.' '*';
	public QualifiedNameWithWildcardElements getQualifiedNameWithWildcardAccess() {
		return pQualifiedNameWithWildcard;
	}
	
	public ParserRule getQualifiedNameWithWildcardRule() {
		return getQualifiedNameWithWildcardAccess().getRule();
	}
	
	//ValidID:
	//    ID;
	public ValidIDElements getValidIDAccess() {
		return pValidID;
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//XImportSection:
	//    importDeclarations+=XImportDeclaration+;
	public XImportSectionElements getXImportSectionAccess() {
		return pXImportSection;
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
	public XImportDeclarationElements getXImportDeclarationAccess() {
		return pXImportDeclaration;
	}
	
	public ParserRule getXImportDeclarationRule() {
		return getXImportDeclarationAccess().getRule();
	}
	
	//QualifiedNameInStaticImport:
	//    (ValidID '.')+
	//;
	public QualifiedNameInStaticImportElements getQualifiedNameInStaticImportAccess() {
		return pQualifiedNameInStaticImport;
	}
	
	public ParserRule getQualifiedNameInStaticImportRule() {
		return getQualifiedNameInStaticImportAccess().getRule();
	}
	
	//terminal ID:
	//    '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') */ | !('\\'|'"') )* '"'? |
	//            "'" ( '\\' . /* ('b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\') */ | !('\\'|"'") )* "'"?;
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
	
	//terminal ML_COMMENT: '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return tML_COMMENT;
	}
	
	//terminal SL_COMMENT: '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//terminal WS: (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return tWS;
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return tANY_OTHER;
	}
}
