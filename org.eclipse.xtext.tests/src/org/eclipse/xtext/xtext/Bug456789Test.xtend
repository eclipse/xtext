/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug456789Test extends AbstractXtextTests {
	
	override setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup)
	}
	
	@Test(timeout=5000 /* pessimistic, should be way faster */) def void doesNotHang_01() {
		val resource = getResourceFromStringAndExpect('''
			grammar com.acme.G with org.eclipse.xtext.common.Terminals
			
			generate g "bug456789"
			
			CompoundStatement: Declaration;
			suite: simpleStatement | NL INDENT stmt+ DEDENT;
			
			test: or_test ('if' or_test 'else' test)? | lambdef;
			or_test: and_test ('or' and_test)*;
			and_test: not_test ('and' not_test)*;
			not_test: 'not' not_test | comparison;
			comparison: expr (comp_op expr)*;
			comp_op: '<'|'>'|'=='|'>='|'<='|'<>'|'!='|'in'|'not' 'in'|'is'|'is' 'not';
			expr: xorExpression ('|' xorExpression)*;
			xorExpression: andExpression ('^' andExpression)*;
			andExpression: shiftExpression ('&' shiftExpression)*;
			shiftExpression: arithExpression (('<<'|'>>') arithExpression)*;
			arithExpression: term (('+'|'-') term)*;
			term: factor (('*'|'/'|'%'|'//') factor)*;
			factor: ('+'|'-'|'~') factor | power;
			power: atom trailer* ('**' factor)?;
			atom: ('(' (yieldExpression|testlist_comp)? ')' |
			       '(' (listmaker)? ')?' |
			       '{' (dictorsetmaker)? '}' |
			       '`' testlist1 '`' |
			       ID | NUMBER | STRING+);
			listmaker: test ( list_for | (',' test)* (',')? );
			testlist_comp: test ( comp_for | (',' test)* (',')? );
			lambdef: 'lambda' (varargslist)? ':' test;
			trailer: '(' (arglist)? ')' | '(' subscriptlist ')?' | '.' ID;
			subscriptlist: subscript (',' subscript)* (',')?;
			subscript: '.' '.' '.' | test | (test)? ':' (test)? (sliceop)?;
			sliceop: ':' (test)?;
			exprlist: expr (',' expr)* (',')?;
			testlist: test (',' test)* (',')?;
			dictorsetmaker: ( (test ':' test (comp_for | (',' test ':' test)* (',')?)) |
			                  (test (comp_for | (',' test)* (',')?)) );
		''', UNKNOWN_EXPECTATION);
			
		val diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
	@Test(timeout=5000) def void doesNotHang_02() {
		val resource = getResourceFromStringAndExpect('''
			grammar com.acme.G with org.eclipse.xtext.common.Terminals
			
			generate g "bug456789"
			
			File: (NL | statements+=Statement)*;
			
			Declaration: ClassDeclaration | FunctionDeclaration;
			FunctionDeclaration: 'def' name=ID parameters=Parameters ':' body=Suite;
			Parameters: '(' list=Varargslist? ')';
			Varargslist:
				(params+=ParameterWithDefault (',' params+=ParameterWithDefault)*
				(',' (params+=ExcessPositionalParameterDef (',' params+=ExcessKeywordParameterDef)? | params+=ExcessKeywordParameterDef)?)?)?
				| params+=ExcessPositionalParameterDef (',' params+=ExcessKeywordParameterDef)? 
				| params+=ExcessKeywordParameterDef;
			
			ParameterWithDefault returns ParameterDef:
				ParameterDef ({ParameterWithDefault.param=current} '=' default=Test)
			;
			ParameterDef: SimpleParameterDef | TupleParameterDef;
			ExcessPositionalParameterDef returns ParameterDef: {ExcessPositionalParameterDef} '*' name=ID;
			ExcessKeywordParameterDef returns ParameterDef: {ExcessKeywordParameterDef} '**' name=ID;
			SimpleParameterDef: name=ID;
			TupleParameterDef: params+=ParameterDef (',' params+=ParameterDef)* (',')?;
			
			Statement: SimpleStatement | CompoundStatement;
			SimpleStatement: SmallStatement ({SmallStatementList.statements+=current} ';' statements+=SmallStatement)* ';'? NL;
			SmallStatement: 
				ExprStatement | PrintStatement  | DelStatement | PassStatement | FlowStatement |
			    ExecStatement | AssertStatement;
			ExprStatement: Testlist 
				(assignment=AugAssign value=Assignable | ('=' value=Assignable)*);
			
			Assignable returns Expression: YieldExpression | Testlist;
			AugAssign: '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' |
			            '<<=' | '>>=' | '**=' | '//=';
			PrintStatement: 'print'|'>>' ( values+=Test (',' values+=Test)* (',')? )?;
			DelStatement: 'del' expression=Expressionlist;
			PassStatement: {PassStatement} 'pass';
			FlowStatement: BreakStatement | ContinueStatement | ReturnStatement | RaiseStatement | YieldStatement;
			BreakStatement: {BreakStatement} 'break';
			ContinueStatement: {ContinueStatement} 'continue';
			ReturnStatement: {ReturnStatement} 'return' value=Testlist?;
			YieldStatement: {YieldStatement} value=YieldExpression;
			RaiseStatement: {RaiseStatement} 'raise' (firstValue=Test (',' secondValue=Test (',' thirdValue=Test)?)?)?;
			FQN: ID ('.' ID)*;
			ExecStatement: 'exec' expression=Expression ('in' tests+=Test (',' tests+=Test)?)?;
			AssertStatement: 'assert' tests+=Test (',' tests+=Test)?;
			
			CompoundStatement: IfStatement | WhileStatement | ForStatement | TryStatement | WithStatement | Declaration;
			IfStatement: 'if' conditions=Test ':' thens=Suite ('elif' conditions=Test ':' thens=Suite)* ('else' ':' else=Suite)?;
			WhileStatement: 'while' conditions=Test ':' body=Suite ('else' ':' else=Suite)?;
			ForStatement: 'for' expressionList=Exprlist 'in' in=Testlist ':' body=Suite ('else' ':' else=Suite)?;
			TryStatement: ('try' ':' try=Suite
			           ((except_clause ':' Suite)+
			            ('else' ':' else=Suite)?
			            ('finally' ':' finally=Suite)? |
			           'finally' ':' finally=Suite));
			withStatement: 'with' with_item (',' with_item)*  ':' suite;
			with_item: test ('as' expr)?;
			except_clause: 'except' (test (('as' | ',') test)?)?;
			suite: simpleStatement | NL INDENT stmt+ DEDENT;
			
			testlist_safe: old_test ((',' old_test)+ (',')?)?;
			old_test: or_test | old_lambdef;
			old_lambdef: 'lambda' (varargslist)? ':' old_test;
			
			test: or_test ('if' or_test 'else' test)? | lambdef;
			or_test: and_test ('or' and_test)*;
			and_test: not_test ('and' not_test)*;
			not_test: 'not' not_test | comparison;
			comparison: expr (comp_op expr)*;
			comp_op: '<'|'>'|'=='|'>='|'<='|'<>'|'!='|'in'|'not' 'in'|'is'|'is' 'not';
			expr: xorExpression ('|' xorExpression)*;
			xorExpression: andExpression ('^' andExpression)*;
			andExpression: shiftExpression ('&' shiftExpression)*;
			shiftExpression: arithExpression (('<<'|'>>') arithExpression)*;
			arithExpression: term (('+'|'-') term)*;
			term: factor (('*'|'/'|'%'|'//') factor)*;
			factor: ('+'|'-'|'~') factor | power;
			power: atom trailer* ('**' factor)?;
			atom: ('(' (yieldExpression|testlist_comp)? ')' |
			       '(' (listmaker)? ')?' |
			       '{' (dictorsetmaker)? '}' |
			       '`' testlist1 '`' |
			       ID | NUMBER | STRING+);
			listmaker: test ( list_for | (',' test)* (',')? );
			testlist_comp: test ( comp_for | (',' test)* (',')? );
			lambdef: 'lambda' (varargslist)? ':' test;
			trailer: '(' (arglist)? ')' | '(' subscriptlist ')?' | '.' ID;
			subscriptlist: subscript (',' subscript)* (',')?;
			subscript: '.' '.' '.' | test | (test)? ':' (test)? (sliceop)?;
			sliceop: ':' (test)?;
			exprlist: expr (',' expr)* (',')?;
			testlist: test (',' test)* (',')?;
			dictorsetmaker: ( (test ':' test (comp_for | (',' test ':' test)* (',')?)) |
			                  (test (comp_for | (',' test)* (',')?)) );
			
			ClassDeclaration: 'class' ID=ID ('(' (testlist)? ')')? ':' suite;
			
			arglist: (argument ',')* (argument (',')?
			                         |'*' test (',' argument)* (',' '**' test)? 
			                         |'**' test);
			argument: test (comp_for)? | test '=' test;
			
			list_iter: list_for | list_if;
			list_for: 'for' exprlist 'in' testlist_safe (list_iter)?;
			list_if: 'if' old_test (list_iter)?;
			
			comp_iter: comp_for | comp_if;
			comp_for: 'for' exprlist 'in' or_test (comp_iter)?;
			comp_if: 'if' old_test (comp_iter)?;
			
			testlist1: test (',' test)*;
			
			encoding_decl: ID;
			
			yieldExpression: 'yield' (testlist)?;
				
			INDENT: 'synthetic:INDENT';
			DEDENT: 'synthetic:DEDENT';
			
			terminal SL_COMMENT: '#' !('\n'|'\r'|EOF)*;
			
			terminal NL: '\r'? '\n'|'\r';
			
			/*
			 * tabs make 8 spaces
			 * indentation is computed from all spaces (tabs are converted first)
			 * 
			 */
		''', UNKNOWN_EXPECTATION);
			
		val diag = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		assertNotNull("diag", diag);
		assertEquals("diag.isError", diag.getSeverity(), Diagnostic.ERROR);
	}
	
}