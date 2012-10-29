/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.common.util.URI
import org.junit.Ignore
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import com.google.inject.Inject
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XThrowExpression

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractReturnTypeTest<Reference> extends AbstractTypeResolverTest<Reference> {
	
	@Test override void testReturnType_01() throws Exception {
		"return 'foo'".resolvesTo("String")
	}
	
	@Test override void testReturnType_02() throws Exception {
		"return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }".resolvesTo("String")
	}
	
	@Test override void testReturnType_03() throws Exception {
		"{ val c = [ int i | return i ] c.apply(1) return null }".resolvesTo("null")
	}
	
	@Test override void testReturnType_04() throws Exception {
		"{ val c = [ int i | i ] c.apply(1) return null }".resolvesTo("null")
	}
	
	@Test override void testReturnType_06() throws Exception {
		"{ var closure = [| return 'literal'] return closure.apply }".resolvesTo("String")
	}
	
	@Test override void testReturnType_08() throws Exception {
		"return [| return 'literal'].apply".resolvesTo("String")
	}
	
	@Test override testIfExpression_03() throws Exception {
		"if (true) return 'foo'".resolvesTo("String")
	}
	
	@Test override testIfExpression_04() throws Exception {
		"if (true) return '' else new StringBuilder".resolvesTo("Serializable & CharSequence")
	}
	
	@Test override testSwitchExpression_1() throws Exception {
		"switch true { case true : return 's' default: null}".resolvesTo("String")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
abstract class AbstractBatchReturnTypeTest extends AbstractReturnTypeTest<LightweightTypeReference> {
	
	override LightweightTypeReference resolvesTo(String expression, String type) {
		val replacedExpressionText = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val xExpression = expression(replacedExpressionText, false /* true */);
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		if (!xExpression.hasReturnExpression) {
			doResolvesTo('''return («replacedExpressionText»)''', type);
			doResolvesTo('''{ { return («replacedExpressionText») } }''', type);
			doResolvesTo('''return {«replacedExpressionText»}''', type);
			doResolvesTo('''{ { return { if (true) «replacedExpressionText» {«replacedExpressionText»} }''', type);
		} else {
			doResolvesTo('''{ «replacedExpressionText» }''', type);
			doResolvesTo('''{ if (true) «replacedExpressionText» {«replacedExpressionText»} }''', type);
		}
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getReturnType(xExpression)
		assertEquals(replacedExpressionText, type, resolvedType.simpleName);
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	def void doResolvesTo(String expression, String type) {
		val parsedExpression = expression(expression, false)
		val resolvedTypes = getTypeResolver.resolveTypes(parsedExpression)
		val resolvedType = resolvedTypes.getReturnType(parsedExpression)
		assertEquals(expression, type, resolvedType.simpleName);
	}
	
	def hasReturnExpression(XExpression expression) {
		switch(expression) {
			XReturnExpression: true
			XThrowExpression: true
			XClosure: false
			default: expression.eContents.exists [ content |
				switch(content) {
					XExpression: content.hasReturnExpression
					default: false
				}
			]
		}
	}
	
	override void isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		assertTrue(reference instanceof FunctionTypeReference)
		assertEquals(type, (reference as FunctionTypeReference).equivalent)
	}
	
	def String getEquivalent(ParameterizedTypeReference type) {
		'''«type.type.simpleName»<«type.typeArguments.join(', ') [simpleName]»>'''
	}
		
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val type = types.getActualType(expression)
		assertNotNull("Type is not resolved. Expression: " + expression.toString, type)
		assertNotNull(expression.toString + " / " + type, type.identifier)	
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
	
	def IBatchTypeResolver getTypeResolver()
	
	@Test 
	def void testNull() throws Exception {
		val typeResolution = typeResolver.resolveTypes(null)
		assertNotNull(typeResolution);
		assertEquals(IResolvedTypes::NULL, typeResolution)
	}

	@Test 
	def void testProxy() throws Exception {
		val proxy = XbaseFactory::eINSTANCE.createXFeatureCall();
		(proxy as InternalEObject).eSetProxyURI(URI::createURI("path#fragment"));
		val typeResolution = typeResolver.resolveTypes(proxy)
		assertNotNull(typeResolution);
		assertEquals(IResolvedTypes::NULL, typeResolution)
	}
	
	@Ignore("TODO discuss the preference - list or array?") @Test override testIfExpression_10() throws Exception {
		super.testIfExpression_10()
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class BatchReturnTypeResolverTest extends AbstractBatchReturnTypeTest {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	override getTypeResolver() {
		typeResolver
	}
	
}