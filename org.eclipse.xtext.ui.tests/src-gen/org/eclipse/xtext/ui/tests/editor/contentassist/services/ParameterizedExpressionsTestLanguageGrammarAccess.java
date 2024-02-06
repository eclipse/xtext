/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class ParameterizedExpressionsTestLanguageGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class RootStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RootStatement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBlockParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cFunctionDeclarationParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cLabelledStatementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cExpressionStatementParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//RootStatement <Yield> returns Statement:
		//      Block<Yield>
		//    | FunctionDeclaration<Yield>
		//    | LabelledStatement<Yield>
		//    | ExpressionStatement<Yield>
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//  Block<Yield>
		//| FunctionDeclaration<Yield>
		//| LabelledStatement<Yield>
		//| ExpressionStatement<Yield>
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Block<Yield>
		public RuleCall getBlockParserRuleCall_0() { return cBlockParserRuleCall_0; }
		
		//FunctionDeclaration<Yield>
		public RuleCall getFunctionDeclarationParserRuleCall_1() { return cFunctionDeclarationParserRuleCall_1; }
		
		//LabelledStatement<Yield>
		public RuleCall getLabelledStatementParserRuleCall_2() { return cLabelledStatementParserRuleCall_2; }
		
		//ExpressionStatement<Yield>
		public RuleCall getExpressionStatementParserRuleCall_3() { return cExpressionStatementParserRuleCall_3; }
	}
	public class FunctionDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.FunctionDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cFunctionDeclarationAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final RuleCall cFunctionImplParserRuleCall_0_0_1 = (RuleCall)cGroup_0_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//FunctionDeclaration <Yield>:
		//    => ({FunctionDeclaration}
		//        -> FunctionImpl <Yield,Yield,Expression=false>
		//    ) => ';'?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//=> ({FunctionDeclaration}
		//    -> FunctionImpl <Yield,Yield,Expression=false>
		//) => ';'?
		public Group getGroup() { return cGroup; }
		
		//=> ({FunctionDeclaration}
		//    -> FunctionImpl <Yield,Yield,Expression=false>
		//)
		public Group getGroup_0() { return cGroup_0; }
		
		//{FunctionDeclaration}
		//        -> FunctionImpl <Yield,Yield,Expression=false>
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{FunctionDeclaration}
		public Action getFunctionDeclarationAction_0_0_0() { return cFunctionDeclarationAction_0_0_0; }
		
		//-> FunctionImpl <Yield,Yield,Expression=false>
		public RuleCall getFunctionImplParserRuleCall_0_0_1() { return cFunctionImplParserRuleCall_0_0_1; }
		
		//=> ';'?
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class FunctionImplElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.FunctionImpl");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Keyword cFunctionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Assignment cGeneratorAssignment_1_0_0 = (Assignment)cGroup_1_0.eContents().get(0);
		private final Keyword cGeneratorAsteriskKeyword_1_0_0_0 = (Keyword)cGeneratorAssignment_1_0_0.eContents().get(0);
		private final RuleCall cFunctionHeaderParserRuleCall_1_0_1 = (RuleCall)cGroup_1_0.eContents().get(1);
		private final RuleCall cFunctionBodyParserRuleCall_1_0_2 = (RuleCall)cGroup_1_0.eContents().get(2);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final RuleCall cFunctionHeaderParserRuleCall_1_1_0 = (RuleCall)cGroup_1_1.eContents().get(0);
		private final RuleCall cFunctionBodyParserRuleCall_1_1_1 = (RuleCall)cGroup_1_1.eContents().get(1);
		
		//fragment FunctionImpl<Yield, YieldIfGenerator, Expression>*:
		//    'function'
		//    (
		//        generator?='*' FunctionHeader<YieldIfGenerator,Generator=true> FunctionBody<Yield=true,Expression>
		//    |     FunctionHeader<Yield,Generator=false> FunctionBody<Yield=false,Expression>
		//    )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'function'
		//(
		//    generator?='*' FunctionHeader<YieldIfGenerator,Generator=true> FunctionBody<Yield=true,Expression>
		//|     FunctionHeader<Yield,Generator=false> FunctionBody<Yield=false,Expression>
		//)
		public Group getGroup() { return cGroup; }
		
		//'function'
		public Keyword getFunctionKeyword_0() { return cFunctionKeyword_0; }
		
		//(
		//    generator?='*' FunctionHeader<YieldIfGenerator,Generator=true> FunctionBody<Yield=true,Expression>
		//|     FunctionHeader<Yield,Generator=false> FunctionBody<Yield=false,Expression>
		//)
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//generator?='*' FunctionHeader<YieldIfGenerator,Generator=true> FunctionBody<Yield=true,Expression>
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//generator?='*'
		public Assignment getGeneratorAssignment_1_0_0() { return cGeneratorAssignment_1_0_0; }
		
		//'*'
		public Keyword getGeneratorAsteriskKeyword_1_0_0_0() { return cGeneratorAsteriskKeyword_1_0_0_0; }
		
		//FunctionHeader<YieldIfGenerator,Generator=true>
		public RuleCall getFunctionHeaderParserRuleCall_1_0_1() { return cFunctionHeaderParserRuleCall_1_0_1; }
		
		//FunctionBody<Yield=true,Expression>
		public RuleCall getFunctionBodyParserRuleCall_1_0_2() { return cFunctionBodyParserRuleCall_1_0_2; }
		
		//FunctionHeader<Yield,Generator=false> FunctionBody<Yield=false,Expression>
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//FunctionHeader<Yield,Generator=false>
		public RuleCall getFunctionHeaderParserRuleCall_1_1_0() { return cFunctionHeaderParserRuleCall_1_1_0; }
		
		//FunctionBody<Yield=false,Expression>
		public RuleCall getFunctionBodyParserRuleCall_1_1_1() { return cFunctionBodyParserRuleCall_1_1_1; }
	}
	public class FunctionHeaderElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.FunctionHeader");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//fragment FunctionHeader<Yield, Generator>*:
		//    name=Identifier<Yield>?
		//    '('')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=Identifier<Yield>?
		//'('')'
		public Group getGroup() { return cGroup; }
		
		//name=Identifier<Yield>?
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//Identifier<Yield>
		public RuleCall getNameIdentifierParserRuleCall_0_0() { return cNameIdentifierParserRuleCall_0_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class FunctionBodyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.FunctionBody");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(0);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cBodyAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cBodyBlockParserRuleCall_0_0_0 = (RuleCall)cBodyAssignment_0_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cBodyAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cBodyBlockParserRuleCall_1_0_0 = (RuleCall)cBodyAssignment_1_0.eContents().get(0);
		
		//fragment FunctionBody <Yield, Expression>*:
		//        <Expression> body=Block<Yield>
		//    |    <!Expression> body=Block<Yield>?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//    <Expression> body=Block<Yield>
		//|    <!Expression> body=Block<Yield>?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//<Expression> body=Block<Yield>
		public Group getGroup_0() { return cGroup_0; }
		
		//body=Block<Yield>
		public Assignment getBodyAssignment_0_0() { return cBodyAssignment_0_0; }
		
		//Block<Yield>
		public RuleCall getBodyBlockParserRuleCall_0_0_0() { return cBodyBlockParserRuleCall_0_0_0; }
		
		//<!Expression> body=Block<Yield>?
		public Group getGroup_1() { return cGroup_1; }
		
		//body=Block<Yield>?
		public Assignment getBodyAssignment_1_0() { return cBodyAssignment_1_0; }
		
		//Block<Yield>
		public RuleCall getBodyBlockParserRuleCall_1_0_0() { return cBodyBlockParserRuleCall_1_0_0; }
	}
	public class BlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Block");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Action cBlockAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_0_1 = (Keyword)cGroup_0_0.eContents().get(1);
		private final Assignment cStatementsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStatementsStatementParserRuleCall_1_0 = (RuleCall)cStatementsAssignment_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Block <Yield>: => ({Block} '{') statements+=Statement<Yield>* '}';
		@Override public ParserRule getRule() { return rule; }
		
		//=> ({Block} '{') statements+=Statement<Yield>* '}'
		public Group getGroup() { return cGroup; }
		
		//=> ({Block} '{')
		public Group getGroup_0() { return cGroup_0; }
		
		//{Block} '{'
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{Block}
		public Action getBlockAction_0_0_0() { return cBlockAction_0_0_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0_0_1() { return cLeftCurlyBracketKeyword_0_0_1; }
		
		//statements+=Statement<Yield>*
		public Assignment getStatementsAssignment_1() { return cStatementsAssignment_1; }
		
		//Statement<Yield>
		public RuleCall getStatementsStatementParserRuleCall_1_0() { return cStatementsStatementParserRuleCall_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
	}
	public class StatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Statement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cFunctionDeclarationParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRootStatementParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Statement <Yield>:
		//      FunctionDeclaration<Yield>
		//    | RootStatement<Yield>
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//  FunctionDeclaration<Yield>
		//| RootStatement<Yield>
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//FunctionDeclaration<Yield>
		public RuleCall getFunctionDeclarationParserRuleCall_0() { return cFunctionDeclarationParserRuleCall_0; }
		
		//RootStatement<Yield>
		public RuleCall getRootStatementParserRuleCall_1() { return cRootStatementParserRuleCall_1; }
	}
	public class ExpressionStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ExpressionStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpressionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpressionExpressionParserRuleCall_0_0 = (RuleCall)cExpressionAssignment_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//ExpressionStatement <Yield>:
		//    expression=Expression<In=true,Yield> ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//expression=Expression<In=true,Yield> ';'
		public Group getGroup() { return cGroup; }
		
		//expression=Expression<In=true,Yield>
		public Assignment getExpressionAssignment_0() { return cExpressionAssignment_0; }
		
		//Expression<In=true,Yield>
		public RuleCall getExpressionExpressionParserRuleCall_0_0() { return cExpressionExpressionParserRuleCall_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_1() { return cSemicolonKeyword_1; }
	}
	public class LabelledStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.LabelledStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cGroup_0.eContents().get(0);
		private final Assignment cNameAssignment_0_0_0 = (Assignment)cGroup_0_0.eContents().get(0);
		private final RuleCall cNameIdentifierParserRuleCall_0_0_0_0 = (RuleCall)cNameAssignment_0_0_0.eContents().get(0);
		private final Keyword cColonKeyword_0_0_1 = (Keyword)cGroup_0_0.eContents().get(1);
		private final Assignment cStatementAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cStatementStatementParserRuleCall_1_0 = (RuleCall)cStatementAssignment_1.eContents().get(0);
		
		//LabelledStatement <Yield>: => (name=Identifier<Yield> ':') statement=Statement<Yield>;
		@Override public ParserRule getRule() { return rule; }
		
		//=> (name=Identifier<Yield> ':') statement=Statement<Yield>
		public Group getGroup() { return cGroup; }
		
		//=> (name=Identifier<Yield> ':')
		public Group getGroup_0() { return cGroup_0; }
		
		//name=Identifier<Yield> ':'
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//name=Identifier<Yield>
		public Assignment getNameAssignment_0_0_0() { return cNameAssignment_0_0_0; }
		
		//Identifier<Yield>
		public RuleCall getNameIdentifierParserRuleCall_0_0_0_0() { return cNameIdentifierParserRuleCall_0_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_0_0_1() { return cColonKeyword_0_0_1; }
		
		//statement=Statement<Yield>
		public Assignment getStatementAssignment_1() { return cStatementAssignment_1; }
		
		//Statement<Yield>
		public RuleCall getStatementStatementParserRuleCall_1_0() { return cStatementStatementParserRuleCall_1_0; }
	}
	public class PrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.PrimaryExpression");
		private final RuleCall cIdentifierRefParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//PrimaryExpression <Yield> returns Expression:
		//      IdentifierRef<Yield>
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//IdentifierRef<Yield>
		public RuleCall getIdentifierRefParserRuleCall() { return cIdentifierRefParserRuleCall; }
	}
	public class IdentifierRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.IdentifierRef");
		private final Assignment cIdAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cIdIdentifierParserRuleCall_0 = (RuleCall)cIdAssignment.eContents().get(0);
		
		//IdentifierRef <Yield>:
		//    id=Identifier<Yield>
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//id=Identifier<Yield>
		public Assignment getIdAssignment() { return cIdAssignment; }
		
		//Identifier<Yield>
		public RuleCall getIdIdentifierParserRuleCall_0() { return cIdIdentifierParserRuleCall_0; }
	}
	public class MemberExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.MemberExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Action cIndexedAccessExpressionTargetAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final RuleCall cIndexedAccessExpressionTailParserRuleCall_1_0_1 = (RuleCall)cGroup_1_0.eContents().get(1);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Action cParameterizedPropertyAccessExpressionTargetAction_1_1_0 = (Action)cGroup_1_1.eContents().get(0);
		private final RuleCall cParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1 = (RuleCall)cGroup_1_1.eContents().get(1);
		
		//MemberExpression <Yield> returns Expression:
		//    PrimaryExpression<Yield> (
		//          {IndexedAccessExpression.target=current} IndexedAccessExpressionTail<Yield>
		//        | {ParameterizedPropertyAccessExpression.target=current} ParameterizedPropertyAccessExpressionTail<Yield>
		//        )*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//PrimaryExpression<Yield> (
		//      {IndexedAccessExpression.target=current} IndexedAccessExpressionTail<Yield>
		//    | {ParameterizedPropertyAccessExpression.target=current} ParameterizedPropertyAccessExpressionTail<Yield>
		//    )*
		public Group getGroup() { return cGroup; }
		
		//PrimaryExpression<Yield>
		public RuleCall getPrimaryExpressionParserRuleCall_0() { return cPrimaryExpressionParserRuleCall_0; }
		
		//(
		//         {IndexedAccessExpression.target=current} IndexedAccessExpressionTail<Yield>
		//       | {ParameterizedPropertyAccessExpression.target=current} ParameterizedPropertyAccessExpressionTail<Yield>
		//       )*
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//{IndexedAccessExpression.target=current} IndexedAccessExpressionTail<Yield>
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{IndexedAccessExpression.target=current}
		public Action getIndexedAccessExpressionTargetAction_1_0_0() { return cIndexedAccessExpressionTargetAction_1_0_0; }
		
		//IndexedAccessExpressionTail<Yield>
		public RuleCall getIndexedAccessExpressionTailParserRuleCall_1_0_1() { return cIndexedAccessExpressionTailParserRuleCall_1_0_1; }
		
		//{ParameterizedPropertyAccessExpression.target=current} ParameterizedPropertyAccessExpressionTail<Yield>
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//{ParameterizedPropertyAccessExpression.target=current}
		public Action getParameterizedPropertyAccessExpressionTargetAction_1_1_0() { return cParameterizedPropertyAccessExpressionTargetAction_1_1_0; }
		
		//ParameterizedPropertyAccessExpressionTail<Yield>
		public RuleCall getParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1() { return cParameterizedPropertyAccessExpressionTailParserRuleCall_1_1_1; }
	}
	public class IndexedAccessExpressionTailElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.IndexedAccessExpressionTail");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIndexAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIndexExpressionParserRuleCall_1_0 = (RuleCall)cIndexAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//fragment IndexedAccessExpressionTail <Yield>*:
		//    '[' index=Expression<In=true,Yield> ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'[' index=Expression<In=true,Yield> ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//index=Expression<In=true,Yield>
		public Assignment getIndexAssignment_1() { return cIndexAssignment_1; }
		
		//Expression<In=true,Yield>
		public RuleCall getIndexExpressionParserRuleCall_1_0() { return cIndexExpressionParserRuleCall_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}
	public class ParameterizedPropertyAccessExpressionTailElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ParameterizedPropertyAccessExpressionTail");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Keyword cFullStopKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cPropertyIdentifierParserRuleCall_1_0 = (RuleCall)cPropertyAssignment_1.eContents().get(0);
		
		//fragment ParameterizedPropertyAccessExpressionTail <Yield>*:
		//    '.' property=Identifier<Yield>
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'.' property=Identifier<Yield>
		public Group getGroup() { return cGroup; }
		
		//'.'
		public Keyword getFullStopKeyword_0() { return cFullStopKeyword_0; }
		
		//property=Identifier<Yield>
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }
		
		//Identifier<Yield>
		public RuleCall getPropertyIdentifierParserRuleCall_1_0() { return cPropertyIdentifierParserRuleCall_1_0; }
	}
	public class ShiftExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.ShiftExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMemberExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cShiftExpressionLhsAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final Alternatives cOpAlternatives_1_0_1_0 = (Alternatives)cOpAssignment_1_0_1.eContents().get(0);
		private final Keyword cOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(0);
		private final Keyword cOpLessThanSignLessThanSignKeyword_1_0_1_0_1 = (Keyword)cOpAlternatives_1_0_1_0.eContents().get(1);
		private final Assignment cRhsAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRhsMemberExpressionParserRuleCall_1_0_2_0 = (RuleCall)cRhsAssignment_1_0_2.eContents().get(0);
		
		//ShiftExpression <Yield> returns Expression: MemberExpression<Yield>
		//    (=>({ShiftExpression.lhs=current} op=('>>'|'<<') rhs=MemberExpression<Yield>))*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//MemberExpression<Yield>
		//   (=>({ShiftExpression.lhs=current} op=('>>'|'<<') rhs=MemberExpression<Yield>))*
		public Group getGroup() { return cGroup; }
		
		//MemberExpression<Yield>
		public RuleCall getMemberExpressionParserRuleCall_0() { return cMemberExpressionParserRuleCall_0; }
		
		//(=>({ShiftExpression.lhs=current} op=('>>'|'<<') rhs=MemberExpression<Yield>))*
		public Group getGroup_1() { return cGroup_1; }
		
		//{ShiftExpression.lhs=current} op=('>>'|'<<') rhs=MemberExpression<Yield>
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{ShiftExpression.lhs=current}
		public Action getShiftExpressionLhsAction_1_0_0() { return cShiftExpressionLhsAction_1_0_0; }
		
		//op=('>>'|'<<')
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }
		
		//('>>'|'<<')
		public Alternatives getOpAlternatives_1_0_1_0() { return cOpAlternatives_1_0_1_0; }
		
		//'>>'
		public Keyword getOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0() { return cOpGreaterThanSignGreaterThanSignKeyword_1_0_1_0_0; }
		
		//'<<'
		public Keyword getOpLessThanSignLessThanSignKeyword_1_0_1_0_1() { return cOpLessThanSignLessThanSignKeyword_1_0_1_0_1; }
		
		//rhs=MemberExpression<Yield>
		public Assignment getRhsAssignment_1_0_2() { return cRhsAssignment_1_0_2; }
		
		//MemberExpression<Yield>
		public RuleCall getRhsMemberExpressionParserRuleCall_1_0_2_0() { return cRhsMemberExpressionParserRuleCall_1_0_2_0; }
	}
	public class RelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cShiftExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cRelationalExpressionLhsAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Assignment cOpAssignment_1_0_1 = (Assignment)cGroup_1_0.eContents().get(1);
		private final RuleCall cOpRelationalOperatorParserRuleCall_1_0_1_0 = (RuleCall)cOpAssignment_1_0_1.eContents().get(0);
		private final Assignment cRhsAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cRhsShiftExpressionParserRuleCall_1_0_2_0 = (RuleCall)cRhsAssignment_1_0_2.eContents().get(0);
		
		//RelationalExpression <In, Yield> returns Expression: ShiftExpression<Yield>
		//    =>({RelationalExpression.lhs=current} op=RelationalOperator<In> ->rhs=ShiftExpression<Yield>)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ShiftExpression<Yield>
		//   =>({RelationalExpression.lhs=current} op=RelationalOperator<In> ->rhs=ShiftExpression<Yield>)*
		public Group getGroup() { return cGroup; }
		
		//ShiftExpression<Yield>
		public RuleCall getShiftExpressionParserRuleCall_0() { return cShiftExpressionParserRuleCall_0; }
		
		//=>({RelationalExpression.lhs=current} op=RelationalOperator<In> ->rhs=ShiftExpression<Yield>)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{RelationalExpression.lhs=current} op=RelationalOperator<In> ->rhs=ShiftExpression<Yield>
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{RelationalExpression.lhs=current}
		public Action getRelationalExpressionLhsAction_1_0_0() { return cRelationalExpressionLhsAction_1_0_0; }
		
		//op=RelationalOperator<In>
		public Assignment getOpAssignment_1_0_1() { return cOpAssignment_1_0_1; }
		
		//RelationalOperator<In>
		public RuleCall getOpRelationalOperatorParserRuleCall_1_0_1_0() { return cOpRelationalOperatorParserRuleCall_1_0_1_0; }
		
		//->rhs=ShiftExpression<Yield>
		public Assignment getRhsAssignment_1_0_2() { return cRhsAssignment_1_0_2; }
		
		//ShiftExpression<Yield>
		public RuleCall getRhsShiftExpressionParserRuleCall_1_0_2_0() { return cRhsShiftExpressionParserRuleCall_1_0_2_0; }
	}
	public class RelationalOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.RelationalOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cLessThanSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cLessThanSignEqualsSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cGreaterThanSignEqualsSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cInstanceofKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cInKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		
		//RelationalOperator <In> :
		//    '<' | '>' | '<=' | '>=' | 'instanceof' | <In> 'in';
		@Override public ParserRule getRule() { return rule; }
		
		//'<' | '>' | '<=' | '>=' | 'instanceof' | <In> 'in'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'<'
		public Keyword getLessThanSignKeyword_0() { return cLessThanSignKeyword_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1() { return cGreaterThanSignKeyword_1; }
		
		//'<='
		public Keyword getLessThanSignEqualsSignKeyword_2() { return cLessThanSignEqualsSignKeyword_2; }
		
		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_3() { return cGreaterThanSignEqualsSignKeyword_3; }
		
		//'instanceof'
		public Keyword getInstanceofKeyword_4() { return cInstanceofKeyword_4; }
		
		//<In> 'in'
		public Group getGroup_5() { return cGroup_5; }
		
		//'in'
		public Keyword getInKeyword_5_0() { return cInKeyword_5_0; }
	}
	public class AssignmentExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.AssignmentExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cYieldExpressionParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final RuleCall cRelationalExpressionParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Group cGroup_1_1_0 = (Group)cGroup_1_1.eContents().get(0);
		private final Group cGroup_1_1_0_0 = (Group)cGroup_1_1_0.eContents().get(0);
		private final Action cAssignmentExpressionLhsAction_1_1_0_0_0 = (Action)cGroup_1_1_0_0.eContents().get(0);
		private final Assignment cOpAssignment_1_1_0_0_1 = (Assignment)cGroup_1_1_0_0.eContents().get(1);
		private final Keyword cOpEqualsSignKeyword_1_1_0_0_1_0 = (Keyword)cOpAssignment_1_1_0_0_1.eContents().get(0);
		private final Assignment cRhsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cRhsAssignmentExpressionParserRuleCall_1_1_1_0 = (RuleCall)cRhsAssignment_1_1_1.eContents().get(0);
		
		//AssignmentExpression <In, Yield> returns Expression:
		//    <Yield> YieldExpression<In>
		//    | RelationalExpression<In,Yield> (=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//<Yield> YieldExpression<In>
		//| RelationalExpression<In,Yield> (=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//<Yield> YieldExpression<In>
		public Group getGroup_0() { return cGroup_0; }
		
		//YieldExpression<In>
		public RuleCall getYieldExpressionParserRuleCall_0_0() { return cYieldExpressionParserRuleCall_0_0; }
		
		//RelationalExpression<In,Yield> (=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?
		public Group getGroup_1() { return cGroup_1; }
		
		//RelationalExpression<In,Yield>
		public RuleCall getRelationalExpressionParserRuleCall_1_0() { return cRelationalExpressionParserRuleCall_1_0; }
		
		//(=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//=> ({AssignmentExpression.lhs=current} op='=')
		public Group getGroup_1_1_0() { return cGroup_1_1_0; }
		
		//{AssignmentExpression.lhs=current} op='='
		public Group getGroup_1_1_0_0() { return cGroup_1_1_0_0; }
		
		//{AssignmentExpression.lhs=current}
		public Action getAssignmentExpressionLhsAction_1_1_0_0_0() { return cAssignmentExpressionLhsAction_1_1_0_0_0; }
		
		//op='='
		public Assignment getOpAssignment_1_1_0_0_1() { return cOpAssignment_1_1_0_0_1; }
		
		//'='
		public Keyword getOpEqualsSignKeyword_1_1_0_0_1_0() { return cOpEqualsSignKeyword_1_1_0_0_1_0; }
		
		//rhs=AssignmentExpression<In,Yield>
		public Assignment getRhsAssignment_1_1_1() { return cRhsAssignment_1_1_1; }
		
		//AssignmentExpression<In,Yield>
		public RuleCall getRhsAssignmentExpressionParserRuleCall_1_1_1_0() { return cRhsAssignmentExpressionParserRuleCall_1_1_1_0; }
	}
	public class YieldExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.YieldExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cYieldExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cYieldKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cManyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cManyAsteriskKeyword_2_0 = (Keyword)cManyAssignment_2.eContents().get(0);
		private final Assignment cExpressionAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cExpressionAssignmentExpressionParserRuleCall_3_0 = (RuleCall)cExpressionAssignment_3.eContents().get(0);
		
		//YieldExpression <In> returns Expression:
		//    {YieldExpression} 'yield' => many?='*'? -> expression=AssignmentExpression<In,Yield=true>?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{YieldExpression} 'yield' => many?='*'? -> expression=AssignmentExpression<In,Yield=true>?
		public Group getGroup() { return cGroup; }
		
		//{YieldExpression}
		public Action getYieldExpressionAction_0() { return cYieldExpressionAction_0; }
		
		//'yield'
		public Keyword getYieldKeyword_1() { return cYieldKeyword_1; }
		
		//=> many?='*'?
		public Assignment getManyAssignment_2() { return cManyAssignment_2; }
		
		//'*'
		public Keyword getManyAsteriskKeyword_2_0() { return cManyAsteriskKeyword_2_0; }
		
		//-> expression=AssignmentExpression<In,Yield=true>?
		public Assignment getExpressionAssignment_3() { return cExpressionAssignment_3; }
		
		//AssignmentExpression<In,Yield=true>
		public RuleCall getExpressionAssignmentExpressionParserRuleCall_3_0() { return cExpressionAssignmentExpressionParserRuleCall_3_0; }
	}
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Expression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAssignmentExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cCommaExpressionExprsAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cCommaKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cExprsAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cExprsAssignmentExpressionParserRuleCall_1_2_0 = (RuleCall)cExprsAssignment_1_2.eContents().get(0);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cCommaKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cExprsAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final RuleCall cExprsAssignmentExpressionParserRuleCall_1_3_1_0 = (RuleCall)cExprsAssignment_1_3_1.eContents().get(0);
		
		//Expression <In, Yield>:
		//    AssignmentExpression<In,Yield> ({CommaExpression.exprs+=current} ',' exprs+=AssignmentExpression<In,Yield> (','    exprs+=AssignmentExpression<In,Yield>)*)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//AssignmentExpression<In,Yield> ({CommaExpression.exprs+=current} ',' exprs+=AssignmentExpression<In,Yield> (','	exprs+=AssignmentExpression<In,Yield>)*)?
		public Group getGroup() { return cGroup; }
		
		//AssignmentExpression<In,Yield>
		public RuleCall getAssignmentExpressionParserRuleCall_0() { return cAssignmentExpressionParserRuleCall_0; }
		
		//({CommaExpression.exprs+=current} ',' exprs+=AssignmentExpression<In,Yield> (','	exprs+=AssignmentExpression<In,Yield>)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{CommaExpression.exprs+=current}
		public Action getCommaExpressionExprsAction_1_0() { return cCommaExpressionExprsAction_1_0; }
		
		//','
		public Keyword getCommaKeyword_1_1() { return cCommaKeyword_1_1; }
		
		//exprs+=AssignmentExpression<In,Yield>
		public Assignment getExprsAssignment_1_2() { return cExprsAssignment_1_2; }
		
		//AssignmentExpression<In,Yield>
		public RuleCall getExprsAssignmentExpressionParserRuleCall_1_2_0() { return cExprsAssignmentExpressionParserRuleCall_1_2_0; }
		
		//(','	exprs+=AssignmentExpression<In,Yield>)*
		public Group getGroup_1_3() { return cGroup_1_3; }
		
		//','
		public Keyword getCommaKeyword_1_3_0() { return cCommaKeyword_1_3_0; }
		
		//exprs+=AssignmentExpression<In,Yield>
		public Assignment getExprsAssignment_1_3_1() { return cExprsAssignment_1_3_1; }
		
		//AssignmentExpression<In,Yield>
		public RuleCall getExprsAssignmentExpressionParserRuleCall_1_3_1_0() { return cExprsAssignmentExpressionParserRuleCall_1_3_1_0; }
	}
	public class IdentifierElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage.Identifier");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cYieldKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		
		//Identifier <Yield>:
		//    ID | <!Yield> 'yield'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | <!Yield> 'yield'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//<!Yield> 'yield'
		public Group getGroup_1() { return cGroup_1; }
		
		//'yield'
		public Keyword getYieldKeyword_1_0() { return cYieldKeyword_1_0; }
	}
	
	
	private final RootStatementElements pRootStatement;
	private final FunctionDeclarationElements pFunctionDeclaration;
	private final FunctionImplElements pFunctionImpl;
	private final FunctionHeaderElements pFunctionHeader;
	private final FunctionBodyElements pFunctionBody;
	private final BlockElements pBlock;
	private final StatementElements pStatement;
	private final ExpressionStatementElements pExpressionStatement;
	private final LabelledStatementElements pLabelledStatement;
	private final PrimaryExpressionElements pPrimaryExpression;
	private final IdentifierRefElements pIdentifierRef;
	private final MemberExpressionElements pMemberExpression;
	private final IndexedAccessExpressionTailElements pIndexedAccessExpressionTail;
	private final ParameterizedPropertyAccessExpressionTailElements pParameterizedPropertyAccessExpressionTail;
	private final ShiftExpressionElements pShiftExpression;
	private final RelationalExpressionElements pRelationalExpression;
	private final RelationalOperatorElements pRelationalOperator;
	private final AssignmentExpressionElements pAssignmentExpression;
	private final YieldExpressionElements pYieldExpression;
	private final ExpressionElements pExpression;
	private final IdentifierElements pIdentifier;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ParameterizedExpressionsTestLanguageGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pRootStatement = new RootStatementElements();
		this.pFunctionDeclaration = new FunctionDeclarationElements();
		this.pFunctionImpl = new FunctionImplElements();
		this.pFunctionHeader = new FunctionHeaderElements();
		this.pFunctionBody = new FunctionBodyElements();
		this.pBlock = new BlockElements();
		this.pStatement = new StatementElements();
		this.pExpressionStatement = new ExpressionStatementElements();
		this.pLabelledStatement = new LabelledStatementElements();
		this.pPrimaryExpression = new PrimaryExpressionElements();
		this.pIdentifierRef = new IdentifierRefElements();
		this.pMemberExpression = new MemberExpressionElements();
		this.pIndexedAccessExpressionTail = new IndexedAccessExpressionTailElements();
		this.pParameterizedPropertyAccessExpressionTail = new ParameterizedPropertyAccessExpressionTailElements();
		this.pShiftExpression = new ShiftExpressionElements();
		this.pRelationalExpression = new RelationalExpressionElements();
		this.pRelationalOperator = new RelationalOperatorElements();
		this.pAssignmentExpression = new AssignmentExpressionElements();
		this.pYieldExpression = new YieldExpressionElements();
		this.pExpression = new ExpressionElements();
		this.pIdentifier = new IdentifierElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ui.tests.editor.contentassist.ParameterizedExpressionsTestLanguage".equals(grammar.getName())) {
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

	
	//RootStatement <Yield> returns Statement:
	//      Block<Yield>
	//    | FunctionDeclaration<Yield>
	//    | LabelledStatement<Yield>
	//    | ExpressionStatement<Yield>
	//;
	public RootStatementElements getRootStatementAccess() {
		return pRootStatement;
	}
	
	public ParserRule getRootStatementRule() {
		return getRootStatementAccess().getRule();
	}
	
	//FunctionDeclaration <Yield>:
	//    => ({FunctionDeclaration}
	//        -> FunctionImpl <Yield,Yield,Expression=false>
	//    ) => ';'?
	//;
	public FunctionDeclarationElements getFunctionDeclarationAccess() {
		return pFunctionDeclaration;
	}
	
	public ParserRule getFunctionDeclarationRule() {
		return getFunctionDeclarationAccess().getRule();
	}
	
	//fragment FunctionImpl<Yield, YieldIfGenerator, Expression>*:
	//    'function'
	//    (
	//        generator?='*' FunctionHeader<YieldIfGenerator,Generator=true> FunctionBody<Yield=true,Expression>
	//    |     FunctionHeader<Yield,Generator=false> FunctionBody<Yield=false,Expression>
	//    )
	//;
	public FunctionImplElements getFunctionImplAccess() {
		return pFunctionImpl;
	}
	
	public ParserRule getFunctionImplRule() {
		return getFunctionImplAccess().getRule();
	}
	
	//fragment FunctionHeader<Yield, Generator>*:
	//    name=Identifier<Yield>?
	//    '('')'
	//;
	public FunctionHeaderElements getFunctionHeaderAccess() {
		return pFunctionHeader;
	}
	
	public ParserRule getFunctionHeaderRule() {
		return getFunctionHeaderAccess().getRule();
	}
	
	//fragment FunctionBody <Yield, Expression>*:
	//        <Expression> body=Block<Yield>
	//    |    <!Expression> body=Block<Yield>?
	//;
	public FunctionBodyElements getFunctionBodyAccess() {
		return pFunctionBody;
	}
	
	public ParserRule getFunctionBodyRule() {
		return getFunctionBodyAccess().getRule();
	}
	
	//Block <Yield>: => ({Block} '{') statements+=Statement<Yield>* '}';
	public BlockElements getBlockAccess() {
		return pBlock;
	}
	
	public ParserRule getBlockRule() {
		return getBlockAccess().getRule();
	}
	
	//Statement <Yield>:
	//      FunctionDeclaration<Yield>
	//    | RootStatement<Yield>
	//;
	public StatementElements getStatementAccess() {
		return pStatement;
	}
	
	public ParserRule getStatementRule() {
		return getStatementAccess().getRule();
	}
	
	//ExpressionStatement <Yield>:
	//    expression=Expression<In=true,Yield> ';'
	//;
	public ExpressionStatementElements getExpressionStatementAccess() {
		return pExpressionStatement;
	}
	
	public ParserRule getExpressionStatementRule() {
		return getExpressionStatementAccess().getRule();
	}
	
	//LabelledStatement <Yield>: => (name=Identifier<Yield> ':') statement=Statement<Yield>;
	public LabelledStatementElements getLabelledStatementAccess() {
		return pLabelledStatement;
	}
	
	public ParserRule getLabelledStatementRule() {
		return getLabelledStatementAccess().getRule();
	}
	
	//PrimaryExpression <Yield> returns Expression:
	//      IdentifierRef<Yield>
	//;
	public PrimaryExpressionElements getPrimaryExpressionAccess() {
		return pPrimaryExpression;
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}
	
	//IdentifierRef <Yield>:
	//    id=Identifier<Yield>
	//;
	public IdentifierRefElements getIdentifierRefAccess() {
		return pIdentifierRef;
	}
	
	public ParserRule getIdentifierRefRule() {
		return getIdentifierRefAccess().getRule();
	}
	
	//MemberExpression <Yield> returns Expression:
	//    PrimaryExpression<Yield> (
	//          {IndexedAccessExpression.target=current} IndexedAccessExpressionTail<Yield>
	//        | {ParameterizedPropertyAccessExpression.target=current} ParameterizedPropertyAccessExpressionTail<Yield>
	//        )*
	//;
	public MemberExpressionElements getMemberExpressionAccess() {
		return pMemberExpression;
	}
	
	public ParserRule getMemberExpressionRule() {
		return getMemberExpressionAccess().getRule();
	}
	
	//fragment IndexedAccessExpressionTail <Yield>*:
	//    '[' index=Expression<In=true,Yield> ']'
	//;
	public IndexedAccessExpressionTailElements getIndexedAccessExpressionTailAccess() {
		return pIndexedAccessExpressionTail;
	}
	
	public ParserRule getIndexedAccessExpressionTailRule() {
		return getIndexedAccessExpressionTailAccess().getRule();
	}
	
	//fragment ParameterizedPropertyAccessExpressionTail <Yield>*:
	//    '.' property=Identifier<Yield>
	//;
	public ParameterizedPropertyAccessExpressionTailElements getParameterizedPropertyAccessExpressionTailAccess() {
		return pParameterizedPropertyAccessExpressionTail;
	}
	
	public ParserRule getParameterizedPropertyAccessExpressionTailRule() {
		return getParameterizedPropertyAccessExpressionTailAccess().getRule();
	}
	
	//ShiftExpression <Yield> returns Expression: MemberExpression<Yield>
	//    (=>({ShiftExpression.lhs=current} op=('>>'|'<<') rhs=MemberExpression<Yield>))*
	//;
	public ShiftExpressionElements getShiftExpressionAccess() {
		return pShiftExpression;
	}
	
	public ParserRule getShiftExpressionRule() {
		return getShiftExpressionAccess().getRule();
	}
	
	//RelationalExpression <In, Yield> returns Expression: ShiftExpression<Yield>
	//    =>({RelationalExpression.lhs=current} op=RelationalOperator<In> ->rhs=ShiftExpression<Yield>)*;
	public RelationalExpressionElements getRelationalExpressionAccess() {
		return pRelationalExpression;
	}
	
	public ParserRule getRelationalExpressionRule() {
		return getRelationalExpressionAccess().getRule();
	}
	
	//RelationalOperator <In> :
	//    '<' | '>' | '<=' | '>=' | 'instanceof' | <In> 'in';
	public RelationalOperatorElements getRelationalOperatorAccess() {
		return pRelationalOperator;
	}
	
	public ParserRule getRelationalOperatorRule() {
		return getRelationalOperatorAccess().getRule();
	}
	
	//AssignmentExpression <In, Yield> returns Expression:
	//    <Yield> YieldExpression<In>
	//    | RelationalExpression<In,Yield> (=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?
	//;
	public AssignmentExpressionElements getAssignmentExpressionAccess() {
		return pAssignmentExpression;
	}
	
	public ParserRule getAssignmentExpressionRule() {
		return getAssignmentExpressionAccess().getRule();
	}
	
	//YieldExpression <In> returns Expression:
	//    {YieldExpression} 'yield' => many?='*'? -> expression=AssignmentExpression<In,Yield=true>?
	//;
	public YieldExpressionElements getYieldExpressionAccess() {
		return pYieldExpression;
	}
	
	public ParserRule getYieldExpressionRule() {
		return getYieldExpressionAccess().getRule();
	}
	
	//Expression <In, Yield>:
	//    AssignmentExpression<In,Yield> ({CommaExpression.exprs+=current} ',' exprs+=AssignmentExpression<In,Yield> (','    exprs+=AssignmentExpression<In,Yield>)*)?
	//;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}
	
	//Identifier <Yield>:
	//    ID | <!Yield> 'yield'
	//;
	public IdentifierElements getIdentifierAccess() {
		return pIdentifier;
	}
	
	public ParserRule getIdentifierRule() {
		return getIdentifierAccess().getRule();
	}
	
	//terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt: ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|'"') )* '"' |
	//            "'" ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT : '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT : '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS         : (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
