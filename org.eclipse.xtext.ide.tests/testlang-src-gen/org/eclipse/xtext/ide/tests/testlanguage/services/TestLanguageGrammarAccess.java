/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.services;

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
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class TestLanguageGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Model");
		private final Assignment cElementsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cElementsAbstractElementParserRuleCall_0 = (RuleCall)cElementsAssignment.eContents().get(0);
		
		//Model:
		//	elements+=AbstractElement*;
		@Override public ParserRule getRule() { return rule; }
		
		//elements+=AbstractElement*
		public Assignment getElementsAssignment() { return cElementsAssignment; }
		
		//AbstractElement
		public RuleCall getElementsAbstractElementParserRuleCall_0() { return cElementsAbstractElementParserRuleCall_0; }
	}
	public class PackageDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.PackageDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsAbstractElementParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//PackageDeclaration:
		//	'package' name=QualifiedName '{'
		//	elements+=AbstractElement*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'package' name=QualifiedName '{' elements+=AbstractElement* '}'
		public Group getGroup() { return cGroup; }
		
		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }
		
		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//elements+=AbstractElement*
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }
		
		//AbstractElement
		public RuleCall getElementsAbstractElementParserRuleCall_3_0() { return cElementsAbstractElementParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class AbstractElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.AbstractElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPackageDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cTypeDeclarationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AbstractElement:
		//	PackageDeclaration | TypeDeclaration;
		@Override public ParserRule getRule() { return rule; }
		
		//PackageDeclaration | TypeDeclaration
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//PackageDeclaration
		public RuleCall getPackageDeclarationParserRuleCall_0() { return cPackageDeclarationParserRuleCall_0; }
		
		//TypeDeclaration
		public RuleCall getTypeDeclarationParserRuleCall_1() { return cTypeDeclarationParserRuleCall_1; }
	}
	public class TypeDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.TypeDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cExtendsKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSuperTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cSuperTypeTypeDeclarationCrossReference_2_1_0 = (CrossReference)cSuperTypeAssignment_2_1.eContents().get(0);
		private final RuleCall cSuperTypeTypeDeclarationQualifiedNameParserRuleCall_2_1_0_1 = (RuleCall)cSuperTypeTypeDeclarationCrossReference_2_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cMembersAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMembersMemberParserRuleCall_4_0 = (RuleCall)cMembersAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//TypeDeclaration:
		//	'type' name=ID ('extends' superType=[TypeDeclaration|QualifiedName])? '{'
		//	members+=Member*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'type' name=ID ('extends' superType=[TypeDeclaration|QualifiedName])? '{' members+=Member* '}'
		public Group getGroup() { return cGroup; }
		
		//'type'
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//('extends' superType=[TypeDeclaration|QualifiedName])?
		public Group getGroup_2() { return cGroup_2; }
		
		//'extends'
		public Keyword getExtendsKeyword_2_0() { return cExtendsKeyword_2_0; }
		
		//superType=[TypeDeclaration|QualifiedName]
		public Assignment getSuperTypeAssignment_2_1() { return cSuperTypeAssignment_2_1; }
		
		//[TypeDeclaration|QualifiedName]
		public CrossReference getSuperTypeTypeDeclarationCrossReference_2_1_0() { return cSuperTypeTypeDeclarationCrossReference_2_1_0; }
		
		//QualifiedName
		public RuleCall getSuperTypeTypeDeclarationQualifiedNameParserRuleCall_2_1_0_1() { return cSuperTypeTypeDeclarationQualifiedNameParserRuleCall_2_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//members+=Member*
		public Assignment getMembersAssignment_4() { return cMembersAssignment_4; }
		
		//Member
		public RuleCall getMembersMemberParserRuleCall_4_0() { return cMembersMemberParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class MemberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Member");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPropertyParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cOperationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Member:
		//	Property | Operation;
		@Override public ParserRule getRule() { return rule; }
		
		//Property | Operation
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Property
		public RuleCall getPropertyParserRuleCall_0() { return cPropertyParserRuleCall_0; }
		
		//Operation
		public RuleCall getOperationParserRuleCall_1() { return cOperationParserRuleCall_1; }
	}
	public class PropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Property");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeTypeParserRuleCall_0_0 = (RuleCall)cTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Property:
		//	type=Type name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//type=Type name=ID
		public Group getGroup() { return cGroup; }
		
		//type=Type
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_0_0() { return cTypeTypeParserRuleCall_0_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}
	public class TypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Type");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final RuleCall cTypeReferenceParserRuleCall_0_0 = (RuleCall)cAlternatives_0.eContents().get(0);
		private final RuleCall cPrimitiveTypeParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cArrayDiemensionsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cArrayDiemensionsLeftSquareBracketKeyword_1_0_0 = (Keyword)cArrayDiemensionsAssignment_1_0.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		
		//Type:
		//	(TypeReference | PrimitiveType) (arrayDiemensions+='[' ']')*;
		@Override public ParserRule getRule() { return rule; }
		
		//(TypeReference | PrimitiveType) (arrayDiemensions+='[' ']')*
		public Group getGroup() { return cGroup; }
		
		//(TypeReference | PrimitiveType)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//TypeReference
		public RuleCall getTypeReferenceParserRuleCall_0_0() { return cTypeReferenceParserRuleCall_0_0; }
		
		//PrimitiveType
		public RuleCall getPrimitiveTypeParserRuleCall_0_1() { return cPrimitiveTypeParserRuleCall_0_1; }
		
		//(arrayDiemensions+='[' ']')*
		public Group getGroup_1() { return cGroup_1; }
		
		//arrayDiemensions+='['
		public Assignment getArrayDiemensionsAssignment_1_0() { return cArrayDiemensionsAssignment_1_0; }
		
		//'['
		public Keyword getArrayDiemensionsLeftSquareBracketKeyword_1_0_0() { return cArrayDiemensionsLeftSquareBracketKeyword_1_0_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_1_1() { return cRightSquareBracketKeyword_1_1; }
	}
	public class OperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Operation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOperationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOpKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cParamsAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final RuleCall cParamsParameterParserRuleCall_4_0_0 = (RuleCall)cParamsAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cParamsAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cParamsParameterParserRuleCall_4_1_1_0 = (RuleCall)cParamsAssignment_4_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cColonKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cReturnTypeAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cReturnTypeTypeParserRuleCall_6_1_0 = (RuleCall)cReturnTypeAssignment_6_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cOperationCallAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cOperationCallOperationCallParserRuleCall_8_0 = (RuleCall)cOperationCallAssignment_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//Operation:
		//	{Operation} 'op' name=ID '(' (params+=Parameter (',' params+=Parameter)*)? ')' (':' returnType=Type)? '{'
		//	operationCall=OperationCall?
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{Operation} 'op' name=ID '(' (params+=Parameter (',' params+=Parameter)*)? ')' (':' returnType=Type)? '{'
		//operationCall=OperationCall? '}'
		public Group getGroup() { return cGroup; }
		
		//{Operation}
		public Action getOperationAction_0() { return cOperationAction_0; }
		
		//'op'
		public Keyword getOpKeyword_1() { return cOpKeyword_1; }
		
		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }
		
		//(params+=Parameter (',' params+=Parameter)*)?
		public Group getGroup_4() { return cGroup_4; }
		
		//params+=Parameter
		public Assignment getParamsAssignment_4_0() { return cParamsAssignment_4_0; }
		
		//Parameter
		public RuleCall getParamsParameterParserRuleCall_4_0_0() { return cParamsParameterParserRuleCall_4_0_0; }
		
		//(',' params+=Parameter)*
		public Group getGroup_4_1() { return cGroup_4_1; }
		
		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }
		
		//params+=Parameter
		public Assignment getParamsAssignment_4_1_1() { return cParamsAssignment_4_1_1; }
		
		//Parameter
		public RuleCall getParamsParameterParserRuleCall_4_1_1_0() { return cParamsParameterParserRuleCall_4_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
		
		//(':' returnType=Type)?
		public Group getGroup_6() { return cGroup_6; }
		
		//':'
		public Keyword getColonKeyword_6_0() { return cColonKeyword_6_0; }
		
		//returnType=Type
		public Assignment getReturnTypeAssignment_6_1() { return cReturnTypeAssignment_6_1; }
		
		//Type
		public RuleCall getReturnTypeTypeParserRuleCall_6_1_0() { return cReturnTypeTypeParserRuleCall_6_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_7() { return cLeftCurlyBracketKeyword_7; }
		
		//operationCall=OperationCall?
		public Assignment getOperationCallAssignment_8() { return cOperationCallAssignment_8; }
		
		//OperationCall
		public RuleCall getOperationCallOperationCallParserRuleCall_8_0() { return cOperationCallOperationCallParserRuleCall_8_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	public class OperationCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.OperationCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOperationAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cOperationOperationCrossReference_0_0 = (CrossReference)cOperationAssignment_0.eContents().get(0);
		private final RuleCall cOperationOperationIDTerminalRuleCall_0_0_1 = (RuleCall)cOperationOperationCrossReference_0_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cParamsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cParamsINTTerminalRuleCall_2_0_0 = (RuleCall)cParamsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cParamsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cParamsINTTerminalRuleCall_2_1_1_0 = (RuleCall)cParamsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//OperationCall:
		//	operation=[Operation] '(' (params+=INT (',' params+=INT)*)? ')';
		@Override public ParserRule getRule() { return rule; }
		
		//operation=[Operation] '(' (params+=INT (',' params+=INT)*)? ')'
		public Group getGroup() { return cGroup; }
		
		//operation=[Operation]
		public Assignment getOperationAssignment_0() { return cOperationAssignment_0; }
		
		//[Operation]
		public CrossReference getOperationOperationCrossReference_0_0() { return cOperationOperationCrossReference_0_0; }
		
		//ID
		public RuleCall getOperationOperationIDTerminalRuleCall_0_0_1() { return cOperationOperationIDTerminalRuleCall_0_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//(params+=INT (',' params+=INT)*)?
		public Group getGroup_2() { return cGroup_2; }
		
		//params+=INT
		public Assignment getParamsAssignment_2_0() { return cParamsAssignment_2_0; }
		
		//INT
		public RuleCall getParamsINTTerminalRuleCall_2_0_0() { return cParamsINTTerminalRuleCall_2_0_0; }
		
		//(',' params+=INT)*
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }
		
		//params+=INT
		public Assignment getParamsAssignment_2_1_1() { return cParamsAssignment_2_1_1; }
		
		//INT
		public RuleCall getParamsINTTerminalRuleCall_2_1_1_0() { return cParamsINTTerminalRuleCall_2_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}
	public class ParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Parameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cParameterAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeTypeParserRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		
		//Parameter:
		//	{Parameter} name=ID ':' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//{Parameter} name=ID ':' type=Type
		public Group getGroup() { return cGroup; }
		
		//{Parameter}
		public Action getParameterAction_0() { return cParameterAction_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//type=Type
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_3_0() { return cTypeTypeParserRuleCall_3_0; }
	}
	public class TypeReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.TypeReference");
		private final Assignment cTypeRefAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cTypeRefTypeDeclarationCrossReference_0 = (CrossReference)cTypeRefAssignment.eContents().get(0);
		private final RuleCall cTypeRefTypeDeclarationQualifiedNameParserRuleCall_0_1 = (RuleCall)cTypeRefTypeDeclarationCrossReference_0.eContents().get(1);
		
		//TypeReference:
		//	typeRef=[TypeDeclaration|QualifiedName];
		@Override public ParserRule getRule() { return rule; }
		
		//typeRef=[TypeDeclaration|QualifiedName]
		public Assignment getTypeRefAssignment() { return cTypeRefAssignment; }
		
		//[TypeDeclaration|QualifiedName]
		public CrossReference getTypeRefTypeDeclarationCrossReference_0() { return cTypeRefTypeDeclarationCrossReference_0; }
		
		//QualifiedName
		public RuleCall getTypeRefTypeDeclarationQualifiedNameParserRuleCall_0_1() { return cTypeRefTypeDeclarationQualifiedNameParserRuleCall_0_1; }
	}
	public class PrimitiveTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.PrimitiveType");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cNameAlternatives_0 = (Alternatives)cNameAssignment.eContents().get(0);
		private final Keyword cNameStringKeyword_0_0 = (Keyword)cNameAlternatives_0.eContents().get(0);
		private final Keyword cNameIntKeyword_0_1 = (Keyword)cNameAlternatives_0.eContents().get(1);
		private final Keyword cNameBooleanKeyword_0_2 = (Keyword)cNameAlternatives_0.eContents().get(2);
		private final Keyword cNameVoidKeyword_0_3 = (Keyword)cNameAlternatives_0.eContents().get(3);
		
		//PrimitiveType:
		//	name=('string' | 'int' | 'boolean' | 'void');
		@Override public ParserRule getRule() { return rule; }
		
		//name=('string' | 'int' | 'boolean' | 'void')
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//('string' | 'int' | 'boolean' | 'void')
		public Alternatives getNameAlternatives_0() { return cNameAlternatives_0; }
		
		//'string'
		public Keyword getNameStringKeyword_0_0() { return cNameStringKeyword_0_0; }
		
		//'int'
		public Keyword getNameIntKeyword_0_1() { return cNameIntKeyword_0_1; }
		
		//'boolean'
		public Keyword getNameBooleanKeyword_0_2() { return cNameBooleanKeyword_0_2; }
		
		//'void'
		public Keyword getNameVoidKeyword_0_3() { return cNameVoidKeyword_0_3; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final ModelElements pModel;
	private final PackageDeclarationElements pPackageDeclaration;
	private final AbstractElementElements pAbstractElement;
	private final TypeDeclarationElements pTypeDeclaration;
	private final MemberElements pMember;
	private final PropertyElements pProperty;
	private final TypeElements pType;
	private final OperationElements pOperation;
	private final OperationCallElements pOperationCall;
	private final ParameterElements pParameter;
	private final TypeReferenceElements pTypeReference;
	private final PrimitiveTypeElements pPrimitiveType;
	private final QualifiedNameElements pQualifiedName;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public TestLanguageGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pModel = new ModelElements();
		this.pPackageDeclaration = new PackageDeclarationElements();
		this.pAbstractElement = new AbstractElementElements();
		this.pTypeDeclaration = new TypeDeclarationElements();
		this.pMember = new MemberElements();
		this.pProperty = new PropertyElements();
		this.pType = new TypeElements();
		this.pOperation = new OperationElements();
		this.pOperationCall = new OperationCallElements();
		this.pParameter = new ParameterElements();
		this.pTypeReference = new TypeReferenceElements();
		this.pPrimitiveType = new PrimitiveTypeElements();
		this.pQualifiedName = new QualifiedNameElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ide.tests.testlanguage.TestLanguage".equals(grammar.getName())) {
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
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Model:
	//	elements+=AbstractElement*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//PackageDeclaration:
	//	'package' name=QualifiedName '{'
	//	elements+=AbstractElement*
	//	'}';
	public PackageDeclarationElements getPackageDeclarationAccess() {
		return pPackageDeclaration;
	}
	
	public ParserRule getPackageDeclarationRule() {
		return getPackageDeclarationAccess().getRule();
	}
	
	//AbstractElement:
	//	PackageDeclaration | TypeDeclaration;
	public AbstractElementElements getAbstractElementAccess() {
		return pAbstractElement;
	}
	
	public ParserRule getAbstractElementRule() {
		return getAbstractElementAccess().getRule();
	}
	
	//TypeDeclaration:
	//	'type' name=ID ('extends' superType=[TypeDeclaration|QualifiedName])? '{'
	//	members+=Member*
	//	'}';
	public TypeDeclarationElements getTypeDeclarationAccess() {
		return pTypeDeclaration;
	}
	
	public ParserRule getTypeDeclarationRule() {
		return getTypeDeclarationAccess().getRule();
	}
	
	//Member:
	//	Property | Operation;
	public MemberElements getMemberAccess() {
		return pMember;
	}
	
	public ParserRule getMemberRule() {
		return getMemberAccess().getRule();
	}
	
	//Property:
	//	type=Type name=ID;
	public PropertyElements getPropertyAccess() {
		return pProperty;
	}
	
	public ParserRule getPropertyRule() {
		return getPropertyAccess().getRule();
	}
	
	//Type:
	//	(TypeReference | PrimitiveType) (arrayDiemensions+='[' ']')*;
	public TypeElements getTypeAccess() {
		return pType;
	}
	
	public ParserRule getTypeRule() {
		return getTypeAccess().getRule();
	}
	
	//Operation:
	//	{Operation} 'op' name=ID '(' (params+=Parameter (',' params+=Parameter)*)? ')' (':' returnType=Type)? '{'
	//	operationCall=OperationCall?
	//	'}';
	public OperationElements getOperationAccess() {
		return pOperation;
	}
	
	public ParserRule getOperationRule() {
		return getOperationAccess().getRule();
	}
	
	//OperationCall:
	//	operation=[Operation] '(' (params+=INT (',' params+=INT)*)? ')';
	public OperationCallElements getOperationCallAccess() {
		return pOperationCall;
	}
	
	public ParserRule getOperationCallRule() {
		return getOperationCallAccess().getRule();
	}
	
	//Parameter:
	//	{Parameter} name=ID ':' type=Type;
	public ParameterElements getParameterAccess() {
		return pParameter;
	}
	
	public ParserRule getParameterRule() {
		return getParameterAccess().getRule();
	}
	
	//TypeReference:
	//	typeRef=[TypeDeclaration|QualifiedName];
	public TypeReferenceElements getTypeReferenceAccess() {
		return pTypeReference;
	}
	
	public ParserRule getTypeReferenceRule() {
		return getTypeReferenceAccess().getRule();
	}
	
	//PrimitiveType:
	//	name=('string' | 'int' | 'boolean' | 'void');
	public PrimitiveTypeElements getPrimitiveTypeAccess() {
		return pPrimitiveType;
	}
	
	public ParserRule getPrimitiveTypeRule() {
		return getPrimitiveTypeAccess().getRule();
	}
	
	//QualifiedName:
	//	ID ('.' ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
