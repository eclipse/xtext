/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.CommonToken
import org.antlr.runtime.Token
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xbase.junit.typesystem.Oven
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractSmokeTest extends AbstractTypeResolverTest<LightweightTypeReference> {
	
	@Inject extension Oven
	
	override resolvesTo(String expression, String type, boolean expectWarning) {
		expression.assertNonSmoking
		return null
	}
	
	override isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		// nothing to do
	}
	
	override protected handleDuplicateExpression(CharSequence expression) {
		// don't process them twice
	}
	
	/**
	 * Processes the input and uses permutations of it to check for raised exceptions.
	 */
	def void assertNonSmoking(String input) throws Exception

	def void processExpression(String expression) throws Exception {
		expression.fireproof
	}
	
	// some re-enabled tests - those don't fulfil the expectation
	// of the super class but should not cause any exceptions
	@Test
	override testOverloadedOperators_11() throws Exception {
		super.testOverloadedOperators_11()
	}
	
	@Test
	override testOverloadedOperators_13() throws Exception {
		super.testOverloadedOperators_13()
	}
	
	@Test
	override testClosure_14() throws Exception {
		super.testClosure_14()
	}
	
	@Test
	override testClosure_32() throws Exception {
		super.testClosure_32()
	}
	
	@Ignore("Disable block expression with 1000+ lines")
	@Test
	override testBlockExpression_03() throws Exception {
		super.testBlockExpression_03()
	}
	
	@Ignore("Disable member feature calls with plenty of nested target expressions")
	@Test
	override testFeatureCall_15_m() throws Exception {
		super.testFeatureCall_15_m()
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipLastCharacters extends AbstractSmokeTest {
	
	override void assertNonSmoking(String input) throws Exception {
		for(i: 0..input.length - 1) {
			processExpression(input.substring(0, i))
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipFirstCharacters extends AbstractSmokeTest {
	
	override void assertNonSmoking(String input) throws Exception {
		for(i: 0..input.length - 1) {
			processExpression(input.substring(i))
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipCharacterInBetween extends AbstractSmokeTest {
	
	override void assertNonSmoking(String input) throws Exception {
		if (input.length > 1) {
			for(i: 0..input.length - 2) {
				processExpression(input.substring(0, i) + input.substring(i+1))
			}
		}
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_b() throws Exception {
		super.testFeatureCall_25_b()
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_c() throws Exception {
		super.testFeatureCall_25_c()
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_d() throws Exception {
		super.testFeatureCall_25_d()
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipTokensInBetween extends AbstractSmokeTest {
	
	@Inject
	Provider<Lexer> lexerProvider
	
	override void assertNonSmoking(String input) throws Exception {
		val List<CommonToken> tokenList = newArrayList();
		{
			val lexer = lexerProvider.get();
			lexer.setCharStream(new ANTLRStringStream(input));
			var token = lexer.nextToken();
			while (token != Token::EOF_TOKEN) {
				tokenList.add(token as CommonToken);
				token = lexer.nextToken();
			}
		}
		for (token : tokenList) {
			val int start = token.getStartIndex();
			val length = token.getText().length();
			processExpression(input.substring(0, start) + input.substring(start + length));
		}		
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_b() throws Exception {
		super.testFeatureCall_25_b()
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_c() throws Exception {
		super.testFeatureCall_25_c()
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_d() throws Exception {
		super.testFeatureCall_25_d()
	}
}


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipNodesInBetween extends AbstractSmokeTest {
	
	override void assertNonSmoking(String input) throws Exception {
		val expression = input.expression
		if (expression != null) {
			val resource = expression.eResource as XtextResource
			val rootNode = resource.parseResult.rootNode
			var ReplaceRegion region;
			for(node: rootNode.asTreeIterable) {
				val offset = node.totalOffset
				val length = node.totalLength
				if (length != 0) {
					if (region == null || region.offset != offset || region.length != length) {
						region = new ReplaceRegion(offset, length, "")
						val builder = new StringBuilder(rootNode.text)
						region.applyTo(builder)
						processExpression(builder.toString)
					}
				}
			}
		}
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_b() throws Exception {
		super.testFeatureCall_25_b()
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_c() throws Exception {
		super.testFeatureCall_25_c()
	}
	
	@Ignore("Disables since it is pretty much the same as testFeatureCall_25_a")
	@Test
	override testFeatureCall_25_d() throws Exception {
		super.testFeatureCall_25_d()
	}
}