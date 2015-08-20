/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.normalization

import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.RuleNames
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.resource.XtextResource
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
		var Grammar result = FlattenedGrammarProvider.flatten(grammar, ruleNames, filter)
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
			
			norm0_Rule:
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
			
			norm0_Rule:
				name=RULE_ID child=norm0_Rule?;
			
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
			
			norm0_Rule:
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
			
			norm0_Rule:
				name=RULE_ID;
			
			norm1_Rule:
				name=RULE_ID child=norm0_Rule?;
			
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
			
			norm0_Rule:
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

}
