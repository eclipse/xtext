/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class JavaFormatterGrammarTest extends AbstractXtextTests {

	private static final String NL = System.lineSeparator();

	@Inject
	private FormatterTestHelper formatterTestHelper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void action() {
		// @formatter:off
		assertFormattedGrammar(
				"Rule:" + NL +
				"	SubRule ({ Other . source = current } op='.');"
				,
				"Rule:" + NL +
				"	SubRule ({Other.source=current} op='.');"
		);
		// @formatter:on
	}

	@Test
	public void enumLiterals() {
		// @formatter:off
		assertFormattedGrammar(
				"enum StateType:" + NL +
				"	FIRST|SECOND|THIRD;"
				,
				"enum StateType:" + NL +
				"	FIRST | SECOND | THIRD;"
				);
		// @formatter:on
	}

	@Test
	public void enumLiteralAssignment() {
		// @formatter:off
		assertFormattedGrammar(
				"enum StateType:" + NL +
				"	PSEUDO = 'cond';"
				,
				"enum StateType:" + NL +
				"	PSEUDO='cond';"
				);
		// @formatter:on
	}

	@Test
	public void hiddenClause() {
		// @formatter:off
		assertFormattedGrammar(
				"Child  hidden ( WS ,  ID ):" + NL +
				"	A;"
				,
				"Child hidden(WS, ID):" + NL +
				"	A;"
				);
		// @formatter:on
	}

	@Test
	public void tokenCardinality() {
		// @formatter:off
		assertFormattedGrammar(
				"Real hidden(): INT ? '.' (EXT_INT | INT);"
				,
				"Real hidden():" + NL
				+ "	INT? '.' (EXT_INT | INT);"
				);
		// @formatter:on
	}

	@Test
	public void unorderedGroups() {
		// @formatter:off
		assertFormattedGrammar(
				"CopyFieldNameToVariableStmt:" + NL +
				"  'FIELD-NAME-TO-VARIABLE' ((',' 'SCREEN' '=' '(' line=INT ',' column=INT ')') &" + NL +
				"			(','     'VAR' '=' name=ID) &" + NL +
				"			(',' 'TYPE' '='    'REPLACE')?);"
				,
				"CopyFieldNameToVariableStmt:" + NL +
				"	'FIELD-NAME-TO-VARIABLE' ((',' 'SCREEN' '=' '(' line=INT ',' column=INT ')') &" + NL +
				"	(',' 'VAR' '=' name=ID) &" + NL +
				"	(',' 'TYPE' '=' 'REPLACE')?);"
				);
		// @formatter:on
	}

	@Test
	public void unorderedGroups2() {
		// @formatter:off
		assertFormattedGrammar(
				"CopyFieldNameToVariableStmt:" + NL +
				"	'FIELD-NAME-TO-VARIABLE'   (  (   ',' 'SCREEN' '=' '('   line=INT    ',' column=INT ')'  )   &   " + NL +
				"	  (  ',' 'VAR' '=' name=ID  )   &   " + NL +
				"	  (  ',' 'TYPE' '=' 'REPLACE'  )  ?   )  ;"
				,
				"CopyFieldNameToVariableStmt:" + NL +
				"	'FIELD-NAME-TO-VARIABLE' ((',' 'SCREEN' '=' '(' line=INT ',' column=INT ')') &" + NL +
				"	(',' 'VAR' '=' name=ID) &" + NL +
				"	(',' 'TYPE' '=' 'REPLACE')?);"
				);
		// @formatter:on
	}

	@Test
	public void guardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"AssignmentExpression <In, Yield> returns Expression:" + NL +
				"	<Yield> YieldExpression<In>" + NL +
				"	| RelationalExpression<In,Yield> (=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?" + NL +
				";"
				,
				"AssignmentExpression <In, Yield> returns Expression:" + NL +
				"	<Yield> YieldExpression<In>" + NL +
				"	| RelationalExpression<In, Yield> (=> ({AssignmentExpression.lhs=current} op='=')" + NL +
				"	rhs=AssignmentExpression<In, Yield>)?;"
				);
		// @formatter:on
	}

	@Test
	public void negatedGuardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				"		<Expression> body=Block<Yield>" + NL +
				"	|"+ "	<!Expression> body=Block<Yield>?" + NL +
				";"
				,
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				"	<Expression> body=Block<Yield>" + NL +
				"	| <!Expression> body=Block<Yield>?;"
				);
		// @formatter:on
	}

	@Test
	public void disjunctedGuardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				"	<Expression|Expression> body=Block<Yield>?" + NL +
				";"
				,
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				"	<Expression | Expression> body=Block<Yield>?;"
				);
		// @formatter:on
	}

	@Test
	public void conjunctedGuardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				"	<Expression&Expression> body=Block<Yield>?" + NL +
				";"
				,
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				"	<Expression & Expression> body=Block<Yield>?;"
				);
		// @formatter:on
	}

	@Test
	public void bug287941TestLanguage() {
		// @formatter:off
		assertFormattedGrammar(
				"WhereEntry returns WhereEntry:" + NL +
				"	AndWhereEntry ({OrWhereEntry.entries+=current} " + NL +
				"		(\"or\" entries+=AndWhereEntry)+)?" + NL +
				";"
				,
				"WhereEntry returns WhereEntry:" + NL +
				"	AndWhereEntry ({OrWhereEntry.entries+=current}" + NL +
				"	(\"or\" entries+=AndWhereEntry)+)?;"
				);
		// @formatter:on
	}

	@Test
	public void codetemplates() {
		// @formatter:off
		assertFormattedGrammar(
				"Codetemplate:" + NL +
				"  name=ValidID '(' id=ID ',' description = STRING ')' 'for' " + NL +
				"        (context=[xtext::AbstractRule|ValidID] | keywordContext=STRING) " + NL +
				"    body = TemplateBodyWithQuotes" + NL +
				"  ; "
				,
				"Codetemplate:" + NL +
				"	name=ValidID '(' id=ID ',' description=STRING ')' 'for'" + NL +
				"	(context=[xtext::AbstractRule|ValidID] | keywordContext=STRING)" + NL +
				"	body=TemplateBodyWithQuotes;"
				);
		// @formatter:on
	}

	@Test
	public void bug297105TestLanguage() {
		// @formatter:off
		assertFormattedGrammar(
				"Real hidden(): INT ? '.' (EXT_INT | INT);"
				,
				"Real hidden():" + NL +
				"	INT? '.' (EXT_INT | INT);"
				);
		// @formatter:on
	}

	@Test
	public void xtextGrammarTestLanguage() {
		// @formatter:off
		assertFormattedGrammar(
				"ParserRule :" + NL +
				"(" + NL +
				"	  ^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ReturnsClause?) " + NL +
				"	| RuleNameAndParams ReturnsClause?" + NL +
				"	)" + NL +
				"	HiddenClause? ':'" + NL +
				"   " + "	alternatives=Alternatives   " + NL +
				"    ';'" + NL +
				";"
				,
				"ParserRule:" + NL +
				"	(^fragment?='fragment' RuleNameAndParams (wildcard?='*' | ReturnsClause?)" + NL +
				"	| RuleNameAndParams ReturnsClause?)" + NL +
				"	HiddenClause? ':'" + NL +
				"	alternatives=Alternatives" + NL +
				"	';';"
				);
		// @formatter:on
	}

	@Test
	public void qualifiedTypes() {
		// @formatter:off
		assertFormattedGrammar(
				"AType returns root::AType:" + NL +
				"	'foo' {root::AType};"
				,
				"AType returns root::AType:" + NL +
				"	'foo' {root::AType};"
				);
		// @formatter:on
	}

	@Test
	public void qualifiedTypes2() {
		// @formatter:off
		assertFormattedGrammar(
				"AType returns root :: AType :" + NL +
				"	'foo' { root :: AType };"
				,
				"AType returns root::AType:" + NL +
				"	'foo' {root::AType};"
				);
		// @formatter:on
	}

	@Test
	public void pureXbase() {
		// @formatter:off
		assertFormattedGrammar(
				"@Override " + NL +
				"XAssignment returns xbase::XExpression :" + NL +
				"	{xbase::XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |" + NL +
				"	XConditionalExpression (" + NL +
				"		=>({xbase::XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment" + NL +
				"	)?;"
				,
				"@Override" + NL +
				"XAssignment returns xbase::XExpression:" + NL +
				"	{xbase::XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment |" + NL +
				"	XConditionalExpression (=>({xbase::XBinaryOperation.leftOperand=current}" + NL +
				"	feature=[types::JvmIdentifiableElement|OpMultiAssign]) rightOperand=XAssignment)?;"
				);
		// @formatter:on
	}

	@Test
	public void pureXbase2() {
		// @formatter:off
		assertFormattedGrammar(
				"XClosure returns XExpression:" + NL +
				"	=>({XClosure}" + NL +
				"	'[')" + NL +
				"		=>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)? explicitSyntax?='|')?" + NL +
				"		expression=XExpressionInClosure" + NL +
				"	']';"
				,
				"XClosure returns XExpression:" + NL +
				"	=>({XClosure}" + NL +
				"	'[')" + NL +
				"	=>((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?" + NL +
				"	explicitSyntax?='|')?" + NL +
				"	expression=XExpressionInClosure" + NL +
				"	']';"
				);
		// @formatter:on
	}

	@Test
	public void xbase() {
		// @formatter:off
		assertFormattedGrammar(
				"XMemberFeatureCall returns XExpression:" + NL +
				"	XPrimaryExpression" + NL +
				"	(=>({XAssignment.assignable=current} ('.'|explicitStatic?=\"::\") feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment" + NL +
				"	|=>({XMemberFeatureCall.memberCallTarget=current} (\".\"|nullSafe?=\"?.\"|explicitStatic?=\"::\"))" + NL +
				"		('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?" + NL +
				"		feature=[types::JvmIdentifiableElement|IdOrSuper] (" + NL +
				"			=>explicitOperationCall?='('" + NL +
				"				(" + NL +
				"				    memberCallArguments+=XShortClosure" + NL +
				"				  | memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*" + NL +
				"				)?" + NL +
				"			')')?" + NL +
				"			memberCallArguments+=XClosure?" + NL +
				"		)*;"
				,
				"XMemberFeatureCall returns XExpression:" + NL +
				"	XPrimaryExpression" + NL +
				"	(=>({XAssignment.assignable=current} ('.' | explicitStatic?=\"::\")" + NL +
				"	feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment" + NL +
				"	| =>({XMemberFeatureCall.memberCallTarget=current} (\".\" | nullSafe?=\"?.\" | explicitStatic?=\"::\"))" + NL +
				"	('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?" + NL +
				"	feature=[types::JvmIdentifiableElement|IdOrSuper] (=>explicitOperationCall?='('" + NL +
				"	(memberCallArguments+=XShortClosure" + NL +
				"	| memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*)?" + NL +
				"	')')?" + NL +
				"	memberCallArguments+=XClosure?)*;"
				);
		// @formatter:on
	}

	@Test
	public void xbaseWithAnnowtation() {
		// @formatter:off
		assertFormattedGrammar(
				"XAnnotation :" + NL +
				"	{XAnnotation}" + NL +
				"	'@' annotationType=[types::JvmAnnotationType | QualifiedName] (=>'('" + NL +
				"		(" + NL +
				"			elementValuePairs+=XAnnotationElementValuePair (',' elementValuePairs+=XAnnotationElementValuePair)*" + NL +
				"		|	value=XAnnotationElementValueOrCommaList" + NL +
				"		)?" + NL +
				"	')')?" + NL +
				";"
				,
				"XAnnotation:" + NL +
				"	{XAnnotation}" + NL +
				"	'@' annotationType=[types::JvmAnnotationType|QualifiedName] (=>'('" + NL +
				"	(elementValuePairs+=XAnnotationElementValuePair (',' elementValuePairs+=XAnnotationElementValuePair)*" + NL +
				"	| value=XAnnotationElementValueOrCommaList)?" + NL +
				"	')')?;"
				);
		// @formatter:on
	}

	@Test
	public void xtend() {
		// @formatter:off
		assertFormattedGrammar(
				"ParameterizedTypeReferenceWithTypeArgs returns types::JvmParameterizedTypeReference:" + NL +
				"	type=[types::JvmType|QualifiedName] (" + NL +
				"		'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>'" + NL +
				"		(=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*" + NL +
				"	)" + NL +
				";"
				,
				"ParameterizedTypeReferenceWithTypeArgs returns types::JvmParameterizedTypeReference:" + NL +
				"	type=[types::JvmType|QualifiedName] ('<' arguments+=JvmArgumentTypeReference (','" + NL +
				"	arguments+=JvmArgumentTypeReference)* '>'" + NL +
				"	(=>({types::JvmInnerTypeReference.outer=current} '.') type=[types::JvmType|ValidID] (=>'<'" + NL +
				"	arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*);"
				);
		// @formatter:on
	}

	@Test
	public void predicatedKeyword0() {
		// @formatter:off
		assertFormattedGrammar(
				"Rule:" + NL +
				"	(  ->   'a')?;"
				,
				"Rule:" + NL +
				"	(->'a')?;"
				);
		// @formatter:on
	}

	@Test
	public void predicatedKeyword1() {
		// @formatter:off
		assertFormattedGrammar(
				"Rule:" + NL +
				"	(  =>   'a')?;"
				,
				"Rule:" + NL +
				"	(=>'a')?;"
				);
		// @formatter:on
	}

	@Test
	public void predicatedKeyword3() {
		// @formatter:off
		assertFormattedGrammar(
				"Rule:" + NL +
				"	{XReturnExpression} 'return'  ->  expression=XExpression?;"
				,
				"Rule:" + NL +
				"	{XReturnExpression} 'return' ->expression=XExpression?;"
				);
		// @formatter:on
	}

	@Test
	public void bug287941TestLanguageGrammarAccess() {
		// @formatter:off
		assertFormattedGrammar(
				"AndWhereEntry returns WhereEntry:" + NL +
				"	ConcreteWhereEntry ({AndWhereEntry.entries += current}" + NL +
				"	(\"and\" entries+=ConcreteWhereEntry)+)?;"
				,
				"AndWhereEntry returns WhereEntry:" + NL +
				"	ConcreteWhereEntry ({AndWhereEntry.entries+=current}" + NL +
				"	(\"and\" entries+=ConcreteWhereEntry)+)?;"
				);
		// @formatter:on
	}

	@Test
	public void untilToken() {
		// @formatter:off
		assertFormattedGrammar(
				"terminal RULE_ML_COMMENT:" + NL +
				"			\"/*\"->\"*/\";"
				,
				"terminal RULE_ML_COMMENT:" + NL +
				"	\"/*\"->\"*/\";"
				);
		// @formatter:on
	}

	@Test
	public void beeLanguage() {
		// @formatter:off
		assertFormattedGrammar(
				"ProvidedCapability: {ProvidedCapability}" + NL +
				"	((nameSpace=ID) | \"unit\") " + NL +
				"	('{'" + NL +
				"     	( 	" + NL +
				"     	  ('when' ':' condExpr = Expression ';')?" + NL +
				"	    & (\"name\" ':' name = ID ';')          " + NL +
				"	    & (\"version\" ':' version = ID ';')?" + NL +
				"	    )" + NL +
				"	'}')?" + NL +
				";" + NL +
				""
				,
				"ProvidedCapability:" + NL +
				"	{ProvidedCapability}" + NL +
				"	((nameSpace=ID) | \"unit\")" + NL +
				"	('{'" + NL +
				"	(('when' ':' condExpr=Expression ';')? & (\"name\" ':' name=ID ';') & (\"version\" ':' version=ID ';')?)" + NL +
				"	'}')?;" + NL +
				""
				);
		// @formatter:on
	}

	@Test
	public void xtextDocumentModifyTest_testCommentsNotDuplicated() {
		// @formatter:off
		assertFormattedGrammar(
				"generate foo \"http://foo.net/foo\"" + NL +
				"Foo: // comment in Foo " + NL +
				"// comment before Assignment" + NL +
				"  bars+= /* comment in assignment */ Bar // comment after assignment" + NL +
				"// comment before keywod" + NL +
				"'foo';" + NL +
				"Bar: 'bar';"
				,
				"generate foo \"http://foo.net/foo\"" + NL +
				""  + NL +
				"Foo: // comment in Foo " + NL +
				"// comment before Assignment" + NL +
				"	bars+= /* comment in assignment */ Bar // comment after assignment" + NL +
				"// comment before keywod" + NL +
				"	'foo';" + NL +
				""  + NL +
				"Bar:" + NL +
				"	'bar';"
				);
		// @formatter:on
	}

	private void assertFormattedGrammar(String input, String expectation) {
		assertFormatted("grammar a.A" + NL + NL + input, "grammar a.A" + NL + NL + expectation);
	}

	private void assertFormatted(String original, String expectation) {
		formatterTestHelper
				.assertFormatted(r -> r.setToBeFormatted(original).setExpectation(expectation).setUseSerializer(false));
	}

	public static class XtextInjectorProvider implements IInjectorProvider {
		@Override
		public Injector getInjector() {
			return new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}
}
