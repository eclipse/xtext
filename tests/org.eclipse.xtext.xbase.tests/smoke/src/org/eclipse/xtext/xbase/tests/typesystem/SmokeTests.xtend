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
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.TypeData
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
abstract class AbstractSmokeTest extends AbstractTypeResolverTest<LightweightTypeReference> {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	override resolvesTo(String expression, String type) {
		expression.assertNonSmoking
		return null
	}
	
	override isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		// nothing to do
	}
	
	override protected handleDuplicateExpression(CharSequence expression) {
		// don't process them twice
	}
	
	def void assertNonSmoking(String input) throws Exception

	def void processExpression(String expression) throws Exception {
		try {
			val xExpression = expression(expression.replace('$$', 'org::eclipse::xtext::xbase::lib::'), false /* true */);
			val resolvedTypes = typeResolver.resolveTypes(xExpression)
			assertNotNull(resolvedTypes)
			if (xExpression != null) {
				for(content: xExpression.eAllContents.toIterable) {
					switch(content) {
						XSwitchExpression: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.localVarName != null) {
								assertIdentifiableTypeIsResolved(content, resolvedTypes)
							}
						}
						XAbstractFeatureCall: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.implicitReceiver != null) {
								assertExpressionTypeIsResolved(content.implicitReceiver, resolvedTypes)
							}
						}
						XExpression: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
						}
						XCasePart : { /* skip */}
						JvmIdentifiableElement: {
							assertIdentifiableTypeIsResolved(content, resolvedTypes)
						}
					}
				}
			}
		} catch(Throwable t) {
			t.printStackTrace
			throw new RuntimeException("Expression was: '" + expression + '"', t)
		}
	}
	
	@Inject extension ReflectExtensions
	
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val internalTypes = types.invoke('delegate')
		val type = internalTypes.invoke("getTypeData", expression, Boolean::FALSE) as TypeData
		assertNotNull("Type is not resolved. Expression: " + expression.toString, type)
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
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
						val builder = new StringBuilder(input)
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