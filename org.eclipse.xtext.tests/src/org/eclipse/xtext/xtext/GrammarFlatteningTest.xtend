/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext

import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.tests.AbstractXtextTests
import org.junit.Ignore
import org.junit.Test

/** 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class GrammarFlatteningTest extends AbstractXtextTests {
	override void setUp() throws Exception {
		super.setUp()
		with(XtextStandaloneSetup)
	}

	override Grammar getModel(String model) throws Exception {
		return getModel(model, false)
	}
	
	def Grammar getModel(String model, boolean dropUnreachable) throws Exception {
		var Grammar grammar = super.getModel(model) as Grammar
		var RuleNames ruleNames = RuleNames.getRuleNames(grammar, false)
		var RuleFilter filter = new RuleFilter()
		filter.discardUnreachableRules = dropUnreachable
		var Grammar result = new FlattenedGrammarAccess(ruleNames, filter).flattenedGrammar
		var XtextResource resource = get(XtextResource)
		resource.getContents().add(result)
		resource.setURI(URI.createURI("synthetic://flattened.xtext"))
		return result
	}

	@Test def void test_01() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule: name=ID;
			''')
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_02() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule: name=ID;
				terminal ID: super;
			''')
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID;
			
			terminal RULE_ID:
				SUPER_ID;
			
			terminal fragment SUPER_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_03() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A, B>: <A> name=ID | <!B> name=ID | name=STRING;
			''')
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID | name=RULE_STRING;
			
			norm1_Rule:
				name=RULE_ID | name=RULE_ID | name=RULE_STRING;
			
			norm2_Rule:
				name=RULE_STRING;
			
			norm3_Rule:
				name=RULE_ID | name=RULE_STRING;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_04() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID child=Rule<A>?;
			''')
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID child=ruleRule?;
			
			norm1_Rule:
				name=RULE_ID child=norm1_Rule?;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_05() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID (<A>child=Rule<A>|<!A>child=Rule<true>+)?;
			''')
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID child=norm1_Rule*;
			
			norm1_Rule:
				name=RULE_ID child=norm1_Rule?;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_06() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID (<A>child=Rule<!A>)?;
			''')
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID;
			
			norm1_Rule:
				name=RULE_ID child=ruleRule?;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_07() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID (<A>child=Rule<!A>)?;
			''', true)
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}

	@Test def void test_08() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID =>(<A> ->child=Rule<!A> | <!A> ->'keyword')?;
			''', true)
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID => ("keyword")?;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_09() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID ->(<A> =>child=Rule<!A> | <!A> =>'keyword')?;
			''', true)
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID => ("keyword")?;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_10() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				ParserRuleParameters: {ParserRuleParameters} 
				  ( '#1' scenario=Scenario1<true>
				  |	'#2' scenario=Scenario1<Param=false>
				  | '#3' scenario=Scenario2<true>
				  | '#4' scenario=Scenario2<false>
				  | =>('#5' scenario=Scenario2<true>)
				  | =>('#6' scenario=Scenario2<false>)
				  | '#7' scenario=Scenario3<true>
				  | '#8' scenario=Scenario3<false>
				  | '#9' (scenario=Scenario4<true> | scenario=Scenario2<true> 'keyword'?)
				  | '#10' (scenario=Scenario4<true> | scenario=Scenario2<false> 'keyword'?)
				  | '#11' (scenario=Scenario4<false> | scenario=Scenario2<true> 'keyword'?)
				  | '#12' (scenario=Scenario4<false> | scenario=Scenario2<false> 'keyword'?)
				  )
				;
				
				Scenario1<Param> returns Scenario:
					<Param> first=ID
				  | <!Param> second=ID
				;
				
				Scenario2<AllowKeyword> returns Scenario:
					first=IdOrKeyword<AllowKeyword>
				;
				
				Scenario3<AllowKeyword> returns Scenario:
					=>first=IdOrKeyword<AllowKeyword>
					| second='keyword'
				;
				
				Scenario4<AllowKeyword> returns Scenario:
					=>second=IdOrKeyword<AllowKeyword> 'keyword'
				;
				
				IdOrKeyword<Keyword>:
					<Keyword> 'keyword'
					| ID
				;
			''', true)
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleParserRuleParameters:
				{ParserRuleParameters} ("#1" scenario=norm1_Scenario1 | "#2" scenario=ruleScenario1 | "#3" scenario=norm1_Scenario2 |
				"#4" scenario=ruleScenario2 | => ("#5" scenario=norm1_Scenario2) | => ("#6" scenario=ruleScenario2) | "#7"
				scenario=norm1_Scenario3 | "#8" scenario=ruleScenario3 | "#9" (scenario=norm1_Scenario4 | scenario=norm1_Scenario2
				"keyword"?) | "#10" (scenario=norm1_Scenario4 | scenario=ruleScenario2 "keyword"?) | "#11" (scenario=ruleScenario4 |
				scenario=norm1_Scenario2 "keyword"?) | "#12" (scenario=ruleScenario4 | scenario=ruleScenario2 "keyword"?));
			
			ruleScenario1:
				second=RULE_ID;
			
			norm1_Scenario1:
				first=RULE_ID;
			
			ruleScenario2:
				first=ruleIdOrKeyword;
			
			norm1_Scenario2:
				first=norm1_IdOrKeyword;
			
			ruleScenario3:
				=> first=ruleIdOrKeyword | second="keyword";
			
			norm1_Scenario3:
				=> first=norm1_IdOrKeyword | second="keyword";
			
			ruleScenario4:
				=> second=ruleIdOrKeyword "keyword";
			
			norm1_Scenario4:
				=> second=norm1_IdOrKeyword "keyword";
			
			ruleIdOrKeyword:
				RULE_ID;
			
			norm1_IdOrKeyword:
				"keyword" | RULE_ID;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Ignore("Flattened grammar access produces bad grammar?")
	@Test def void test_11() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule<A>: name=ID =>(<A> ->child=Rule<!A> | <!A> ->('a' 'b'))?;
			''', true)
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				name=RULE_ID => ("keyword")?;
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
	
	@Test def void test_12() throws Exception {
		var Grammar flattened = getModel(
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				generate myPack 'http://myURI'
				Rule: =>(name+=ID*);
			''', true)
		var String serialized = getSerializer().serialize(flattened)
		assertEquals('''
			grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)
			
			ruleRule:
				=> (name+=RULE_ID*);
			
			terminal RULE_ID:
				"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
			
			terminal RULE_INT:
				"0".."9"+;
			
			terminal RULE_STRING:
				"\"" ("\\" . | !("\\" | "\""))* "\"" | "\'" ("\\" . | !("\\" | "\'"))* "\'";
			
			terminal RULE_ML_COMMENT:
				"/*"->"*/";
			
			terminal RULE_SL_COMMENT:
				"//" !("\n" | "\r")* ("\r"? "\n")?;
			
			terminal RULE_WS:
				" " | "\t" | "\r" | "\n"+;
			
			terminal RULE_ANY_OTHER:
				.;'''.toString, serialized)
	}
}
