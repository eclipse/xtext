/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug456789Test extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test(timeout = 5000)
	public void doesNotHang_01() throws Exception {
		String model =
				"grammar com.acme.G with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate g 'bug456789'\n" +
				"\n" +
				"CompoundStatement: Declaration;\n" +
				"suite: simpleStatement | NL INDENT stmt+ DEDENT;\n" +
				"\n" +
				"test: or_test ('if' or_test 'else' test)? | lambdef;\n" +
				"or_test: and_test ('or' and_test)*;\n" +
				"and_test: not_test ('and' not_test)*;\n" +
				"not_test: 'not' not_test | comparison;\n" +
				"comparison: expr (comp_op expr)*;\n" +
				"comp_op: '<'|'>'|'=='|'>='|'<='|'<>'|'!='|'in'|'not' 'in'|'is'|'is' 'not';\n" +
				"expr: xorExpression ('|' xorExpression)*;\n" +
				"xorExpression: andExpression ('^' andExpression)*;\n" +
				"andExpression: shiftExpression ('&' shiftExpression)*;\n" +
				"shiftExpression: arithExpression (('<<'|'>>') arithExpression)*;\n" +
				"arithExpression: term (('+'|'-') term)*;\n" +
				"term: factor (('*'|'/'|'%'|'//') factor)*;\n" +
				"factor: ('+'|'-'|'~') factor | power;\n" +
				"power: atom trailer* ('**' factor)?;\n" +
				"atom: ('(' (yieldExpression|testlist_comp)? ')' |\n" +
				"       '(' (listmaker)? ')?' |\n" +
				"       '{' (dictorsetmaker)? '}' |\n" +
				"       '`' testlist1 '`' |\n" +
				"       ID | NUMBER | STRING+);\n" +
				"listmaker: test ( list_for | (',' test)* (',')? );\n" +
				"testlist_comp: test ( comp_for | (',' test)* (',')? );\n" +
				"lambdef: 'lambda' (varargslist)? ':' test;\n" +
				"trailer: '(' (arglist)? ')' | '(' subscriptlist ')?' | '.' ID;\n" +
				"subscriptlist: subscript (',' subscript)* (',')?;\n" +
				"subscript: '.' '.' '.' | test | (test)? ':' (test)? (sliceop)?;\n" +
				"sliceop: ':' (test)?;\n" +
				"exprlist: expr (',' expr)* (',')?;\n" +
				"testlist: test (',' test)* (',')?;\n" +
				"dictorsetmaker: ( (test ':' test (comp_for | (',' test ':' test)* (',')?)) |\n" +
				"                  (test (comp_for | (',' test)* (',')?)) );\n";
		XtextResource resource = getResourceFromStringAndExpect(model, AbstractXtextTests.UNKNOWN_EXPECTATION);
		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		Assert.assertNotNull("diag", diag);
		Assert.assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}

	@Test(timeout = 5000)
	public void doesNotHang_02() throws Exception {
		String model =
				"grammar com.acme.G with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate g 'bug456789'\n" +
				"\n" +
				"File: (NL | statements+=Statement)*;\n" +
				"\n" +
				"Declaration: ClassDeclaration | FunctionDeclaration;\n" +
				"FunctionDeclaration: 'def' name=ID parameters=Parameters ':' body=Suite;\n" +
				"Parameters: '(' list=Varargslist? ')';\n" +
				"Varargslist:\n" +
				"	(params+=ParameterWithDefault (',' params+=ParameterWithDefault)*\n" +
				"	(',' (params+=ExcessPositionalParameterDef (',' params+=ExcessKeywordParameterDef)? | params+=ExcessKeywordParameterDef)?)?)?\n" +
				"	| params+=ExcessPositionalParameterDef (',' params+=ExcessKeywordParameterDef)? \n" +
				"	| params+=ExcessKeywordParameterDef;\n" +
				"\n" +
				"ParameterWithDefault returns ParameterDef:\n" +
				"	ParameterDef ({ParameterWithDefault.param=current} '=' default=Test)\n" +
				";\n" +
				"ParameterDef: SimpleParameterDef | TupleParameterDef;\n" +
				"ExcessPositionalParameterDef returns ParameterDef: {ExcessPositionalParameterDef} '*' name=ID;\n" +
				"ExcessKeywordParameterDef returns ParameterDef: {ExcessKeywordParameterDef} '**' name=ID;\n" +
				"SimpleParameterDef: name=ID;\n" +
				"TupleParameterDef: params+=ParameterDef (',' params+=ParameterDef)* (',')?;\n" +
				"\n" +
				"Statement: SimpleStatement | CompoundStatement;\n" +
				"SimpleStatement: SmallStatement ({SmallStatementList.statements+=current} ';' statements+=SmallStatement)* ';'? NL;\n" +
				"SmallStatement: \n" +
				"	ExprStatement | PrintStatement  | DelStatement | PassStatement | FlowStatement |\n" +
				"    ExecStatement | AssertStatement;\n" +
				"ExprStatement: Testlist \n" +
				"	(assignment=AugAssign value=Assignable | ('=' value=Assignable)*);\n" +
				"\n" +
				"Assignable returns Expression: YieldExpression | Testlist;\n" +
				"AugAssign: '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' |\n" +
				"            '<<=' | '>>=' | '**=' | '//=';\n" +
				"PrintStatement: 'print'|'>>' ( values+=Test (',' values+=Test)* (',')? )?;\n" +
				"DelStatement: 'del' expression=Expressionlist;\n" +
				"PassStatement: {PassStatement} 'pass';\n" +
				"FlowStatement: BreakStatement | ContinueStatement | ReturnStatement | RaiseStatement | YieldStatement;\n" +
				"BreakStatement: {BreakStatement} 'break';\n" +
				"ContinueStatement: {ContinueStatement} 'continue';\n" +
				"ReturnStatement: {ReturnStatement} 'return' value=Testlist?;\n" +
				"YieldStatement: {YieldStatement} value=YieldExpression;\n" +
				"RaiseStatement: {RaiseStatement} 'raise' (firstValue=Test (',' secondValue=Test (',' thirdValue=Test)?)?)?;\n" +
				"FQN: ID ('.' ID)*;\n" +
				"ExecStatement: 'exec' expression=Expression ('in' tests+=Test (',' tests+=Test)?)?;\n" +
				"AssertStatement: 'assert' tests+=Test (',' tests+=Test)?;\n" +
				"\n" +
				"CompoundStatement: IfStatement | WhileStatement | ForStatement | TryStatement | WithStatement | Declaration;\n" +
				"IfStatement: 'if' conditions=Test ':' thens=Suite ('elif' conditions=Test ':' thens=Suite)* ('else' ':' else=Suite)?;\n" +
				"WhileStatement: 'while' conditions=Test ':' body=Suite ('else' ':' else=Suite)?;\n" +
				"ForStatement: 'for' expressionList=Exprlist 'in' in=Testlist ':' body=Suite ('else' ':' else=Suite)?;\n" +
				"TryStatement: ('try' ':' try=Suite\n" +
				"           ((except_clause ':' Suite)+\n" +
				"            ('else' ':' else=Suite)?\n" +
				"            ('finally' ':' finally=Suite)? |\n" +
				"           'finally' ':' finally=Suite));\n" +
				"withStatement: 'with' with_item (',' with_item)*  ':' suite;\n" +
				"with_item: test ('as' expr)?;\n" +
				"except_clause: 'except' (test (('as' | ',') test)?)?;\n" +
				"suite: simpleStatement | NL INDENT stmt+ DEDENT;\n" +
				"\n" +
				"testlist_safe: old_test ((',' old_test)+ (',')?)?;\n" +
				"old_test: or_test | old_lambdef;\n" +
				"old_lambdef: 'lambda' (varargslist)? ':' old_test;\n" +
				"\n" +
				"test: or_test ('if' or_test 'else' test)? | lambdef;\n" +
				"or_test: and_test ('or' and_test)*;\n" +
				"and_test: not_test ('and' not_test)*;\n" +
				"not_test: 'not' not_test | comparison;\n" +
				"comparison: expr (comp_op expr)*;\n" +
				"comp_op: '<'|'>'|'=='|'>='|'<='|'<>'|'!='|'in'|'not' 'in'|'is'|'is' 'not';\n" +
				"expr: xorExpression ('|' xorExpression)*;\n" +
				"xorExpression: andExpression ('^' andExpression)*;\n" +
				"andExpression: shiftExpression ('&' shiftExpression)*;\n" +
				"shiftExpression: arithExpression (('<<'|'>>') arithExpression)*;\n" +
				"arithExpression: term (('+'|'-') term)*;\n" +
				"term: factor (('*'|'/'|'%'|'//') factor)*;\n" +
				"factor: ('+'|'-'|'~') factor | power;\n" +
				"power: atom trailer* ('**' factor)?;\n" +
				"atom: ('(' (yieldExpression|testlist_comp)? ')' |\n" +
				"       '(' (listmaker)? ')?' |\n" +
				"       '{' (dictorsetmaker)? '}' |\n" +
				"       '`' testlist1 '`' |\n" +
				"       ID | NUMBER | STRING+);\n" +
				"listmaker: test ( list_for | (',' test)* (',')? );\n" +
				"testlist_comp: test ( comp_for | (',' test)* (',')? );\n" +
				"lambdef: 'lambda' (varargslist)? ':' test;\n" +
				"trailer: '(' (arglist)? ')' | '(' subscriptlist ')?' | '.' ID;\n" +
				"subscriptlist: subscript (',' subscript)* (',')?;\n" +
				"subscript: '.' '.' '.' | test | (test)? ':' (test)? (sliceop)?;\n" +
				"sliceop: ':' (test)?;\n" +
				"exprlist: expr (',' expr)* (',')?;\n" +
				"testlist: test (',' test)* (',')?;\n" +
				"dictorsetmaker: ( (test ':' test (comp_for | (',' test ':' test)* (',')?)) |\n" +
				"                  (test (comp_for | (',' test)* (',')?)) );\n" +
				"\n" +
				"ClassDeclaration: 'class' ID=ID ('(' (testlist)? ')')? ':' suite;\n" +
				"\n" +
				"arglist: (argument ',')* (argument (',')?\n" +
				"                         |'*' test (',' argument)* (',' '**' test)? \n" +
				"                         |'**' test);\n" +
				"argument: test (comp_for)? | test '=' test;\n" +
				"\n" +
				"list_iter: list_for | list_if;\n" +
				"list_for: 'for' exprlist 'in' testlist_safe (list_iter)?;\n" +
				"list_if: 'if' old_test (list_iter)?;\n" +
				"\n" +
				"comp_iter: comp_for | comp_if;\n" +
				"comp_for: 'for' exprlist 'in' or_test (comp_iter)?;\n" +
				"comp_if: 'if' old_test (comp_iter)?;\n" +
				"\n" +
				"testlist1: test (',' test)*;\n" +
				"\n" +
				"encoding_decl: ID;\n" +
				"\n" +
				"yieldExpression: 'yield' (testlist)?;\n" +
				"	\n" +
				"INDENT: 'synthetic:INDENT';\n" +
				"DEDENT: 'synthetic:DEDENT';\n" +
				"\n" +
				"terminal SL_COMMENT: '#' !('\n" +
				"'|'\r'|EOF)*;\n" +
				"\n" +
				"terminal NL: '\r'? '\n" +
				"'|'\r';\n" +
				"\n" +
				"/*\n" +
				" * tabs make 8 spaces\n" +
				" * indentation is computed from all spaces (tabs are converted first)\n" +
				" * \n" +
				" */\n";
		XtextResource resource = getResourceFromStringAndExpect(model, AbstractXtextTests.UNKNOWN_EXPECTATION);
		Diagnostic diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		Assert.assertNotNull("diag", diag);
		Assert.assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
}
