/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.annotations

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.CommonToken
import org.antlr.runtime.Token
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.TypeData
import org.junit.Before

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractSmokeTest extends AnnotationsValidatorTest {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Inject
	extension ParseHelper<EObject> 
	
	@Before
	def void resetTestHelper() {
		validator = new NullValidationTestHelper
	}
	
	override protected annotation(String expression, boolean resolve) throws Exception {
		expression.assertNonSmoking
		return null
	}
	
	override testReferencedTypeIsNoEnum() throws Exception {
		annotation("@java.lang.Object(unknown = #[ new String() ])", false)
	}
	
	def void assertNonSmoking(String input) throws Exception

	def void processExpression(String expression) throws Exception {
		try {
			val xExpression = expression.parse
			val resolvedTypes = typeResolver.resolveTypes(xExpression)
			assertNotNull(resolvedTypes)
			if (xExpression != null) {
				for(content: xExpression.eAllContents.toIterable) {
					switch(content) {
						XAbstractFeatureCall: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.implicitReceiver != null) {
								assertExpressionTypeIsResolved(content.implicitReceiver, resolvedTypes)
							}
						}
						XExpression: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
						}
						JvmIdentifiableElement: {
							assertIdentifiableTypeIsResolved(content, resolvedTypes)
						}
					}
				}
			}
		} catch(Throwable t) {
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
	
}

class NullValidationTestHelper extends ValidationTestHelper {
	
	override assertIssue(EObject model, EClass objectType, String code, Severity severity, String... messageParts) {
		// no-op
	}
	
	override validate(EObject model) {
		return emptyList
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
	
}


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipNodesInBetween extends AbstractSmokeTest {
	
	override void assertNonSmoking(String input) throws Exception {
		val resource = input.newResource as XtextResource
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