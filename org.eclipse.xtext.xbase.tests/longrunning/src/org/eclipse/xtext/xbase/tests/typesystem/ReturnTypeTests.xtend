/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.XThrowExpression
import org.eclipse.xtext.xbase.XbaseFactory
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.junit.Test
import org.eclipse.emf.ecore.EObject

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractReturnTypeTest<Reference> extends AbstractTypeResolverTest<Reference> {
	
	@Test override void testReturnExpression_01() throws Exception {
		"return 'foo'".resolvesTo("String")
	}
	
	@Test override void testReturnExpression_02() throws Exception {
		"return try { if (true) 'foo' else 'bar' } finally { String::valueOf('zonk') }".resolvesTo("String")
	}
	
	@Test override void testReturnExpression_03() throws Exception {
		"{ val c = [ int i | return i ] c.apply(1) return null }".resolvesTo("null")
	}
	
	@Test override void testReturnExpression_04() throws Exception {
		"{ val c = [ int i | i ] c.apply(1) return null }".resolvesTo("null")
	}
	
	@Test override void testReturnExpression_06() throws Exception {
		"{ var closure = [| return 'literal'] return closure.apply }".resolvesTo("String")
	}
	
	@Test override void testReturnExpression_08() throws Exception {
		"return [| return 'literal'].apply".resolvesTo("String")
	}
	
	@Test override testReturnExpression_10() throws Exception {
		"return if (true) while(false) ('foo'+'bar').length".resolvesTo("null")
	}
	
	@Test override void testBooleanLiteral_02() throws Exception {
		"return true".resolvesTo("boolean")
	}
	
	@Test override testIfExpression_03() throws Exception {
		"if (true) return 'foo'".resolvesTo("String")
	}
	
	@Test override testIfExpression_04() throws Exception {
		if (isJava11OrLater) {
			"if (true) return '' else new StringBuilder".resolvesTo("Serializable & Comparable<?> & CharSequence")
		} else {
			"if (true) return '' else new StringBuilder".resolvesTo("Serializable & CharSequence")
		}
	}
	
	@Test override testIfExpression_17() throws Exception {
		"if (true) return 1".resolvesTo("int")
	}
	
	@Test override void testIfExpression_19() throws Exception {
		"if (true) return else null".resolvesTo("void")
	}
	
	@Test override void testIfExpression_23() throws Exception {
		"{ val x = if (true) return 1 x }".resolvesTo("Integer")
	}
	
	@Test override void testIfExpression_24() throws Exception {
		"{ val x = if (true) return; x }".resolvesTo("void")
	}
	
	@Test override void testIfExpression_25() throws Exception {
		"{ val x = if (true) return else null x }".resolvesTo("void")
	}
	
	@Test override void testIfExpression_28() throws Exception {
		if (isJava12OrLater) {
			"if (true) return '' else 1".resolvesTo("Comparable<?> & Constable & ConstantDesc & Serializable")
		} else {
			"if (true) return '' else 1".resolvesTo("Comparable<?> & Serializable")
		}
	}
	
	@Test override testSwitchExpression_1() throws Exception {
		"switch true { case true : return 's' default: null}".resolvesTo("String")
	}
	
	@Test override void testSwitchExpression_2() throws Exception {
		"switch null {
		  Object : return null 
		}".resolvesTo("null")
	}
	
	@Test override testForExpression_05() throws Exception {
		"for(String x : new java.util.ArrayList<String>()) return x.length".resolvesTo("Integer")
		"for(String x : newArrayList('foo')) return x.length".resolvesTo("Integer")
		"for(String x : <String>newArrayList()) return x.length".resolvesTo("Integer")
	}
	
	@Test override testForExpression_06() throws Exception {
		"for(x : new java.util.ArrayList<String>()) return x.length".resolvesTo("Integer")
		"for(x : <String>newArrayList()) return x.length".resolvesTo("Integer")
		"for(x : newArrayList('foo')) return x.length".resolvesTo("Integer")
	}
	
	@Test override testForExpression_07() throws Exception {
		"for(String x : null as String[]) return x.length".resolvesTo("Integer")
	}
	
	@Test override testForExpression_08() throws Exception {
		"for(x : null as String[]) return x.length".resolvesTo("Integer")
	}
	
	@Test def void testForExpression_10() throws Exception {
		"{ for(x : null as String[]) return x.length 1 }".resolvesTo("int")
	}
	
	@Test def void testForExpression_11() throws Exception {
		"for(x : null as String[]) if (true) return 1".resolvesTo("Integer")
	}
	
	@Test def void testForExpression_12() throws Exception {
		"for(x : null as String[]) if (true) return 1 else return 2".resolvesTo("Integer")
	}
	
	@Test override testWhileExpression_02() throws Exception {
		"while(true) return 1".resolvesTo("Integer")
	}
	
	@Test def void testWhileExpression_03() throws Exception {
		"while(if (true) return 1 else false) ''.length".resolvesTo("Integer")
	}
	
	@Test def void testWhileExpression_04() throws Exception {
		"while(null instanceof String) return ''".resolvesTo("String")
	}
	
	@Test def void testWhileExpression_05() throws Exception {
		"{ while(null instanceof String) return '' return '' }".resolvesTo("String")
	}
	
	@Test def void testWhileExpression_EarlyExitWithSwitchCase() throws Exception {
		'while(true) {
			switch "test" {
				case "foo" : return "result"
			}
		}'.resolvesTo("String")
	}
	
	@Test def void testWhileExpression_EarlyExitWithSwitchDefault() throws Exception {
		'while(true) {
			switch "test" {
				case "foo" : {}
				default : return "result"
			}
		}'.resolvesTo("String")
	}
	
	@Test def void testWhileExpression_EarlyExitWithSwitchAndIf() throws Exception {
		'while(true) {
			if(false) {
				switch "test" {
					case "foo" : if(false) return "result"
				}
			}
		}'.resolvesTo("String")
	}
	
	@Test override testTryCatchFinallyExpression_08() throws Exception {
		"try return 'foo' catch (Exception e) return 'bar'".resolvesTo("String") 
	}
	
	@Test override testTryCatchFinallyExpression_09() throws Exception {
		"try return 'foo' catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz'".resolvesTo("String")	
	}
	
	@Test override testTryCatchFinallyExpression_10() throws Exception {
		"try return 'foo' catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz' finally true".resolvesTo("String")	
	}
	
	@Test override testTryCatchFinallyExpression_11() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) return 'caught'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_12() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) {return 'caught'}".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_13() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(NullPointerException e) return 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_14() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_15() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) return null as Number
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("Serializable")	
	}
	
	@Test override testTryCatchFinallyExpression_19() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) 'caught'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_20() throws Exception {
		"try { return 'literal' as Object as Boolean } catch(ClassCastException e) {'caught'}".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_21() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(NullPointerException e) 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_22() throws Exception {
		"try return 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) 'dont catch subsequent exceptions'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_25() throws Exception {
		"try true catch (Exception e) return 'bar' catch(RuntimeException e) return 'baz'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_26() throws Exception {
		"try 'foo' catch (Exception e) 'bar' catch(RuntimeException e) return true finally true".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_27() throws Exception {
		"try { 'literal' as Object as Boolean } catch(ClassCastException e) return 'caught'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_28() throws Exception {
		"try { 'literal' as Object as Boolean } catch(ClassCastException e) {return 'caught'}".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_29() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(NullPointerException e) return 'second thing is thrown'		  
		  catch(ClassCastException e) throw new NullPointerException()
		".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_30() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(ClassCastException e) throw new NullPointerException()
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("Serializable & Comparable<?>")	
	}
	
	@Test override testTryCatchFinallyExpression_31() throws Exception {
		"try 'literal' as Object as Boolean
		  catch(ClassCastException e) return null as Number
		  catch(NullPointerException e) return 'dont catch subsequent exceptions'".resolvesTo("Serializable")	
	}

	@Test def void testThrowExpressionAfterLoop_01() throws Exception {
		"{
			while(true) ''.toString
			throw new RuntimeException()
		}".resolvesTo("void")
	}

	@Test def void testThrowExpressionAfterLoop_02() throws Exception {
		"{
			while(true) return 1
			throw new RuntimeException()
		}".resolvesTo("int")
	}

	@Test def void testThrowExpressionAfterLoop_03() throws Exception {
		"{
			while(true) if (true) return 1 else ''
			throw new RuntimeException()
		}".resolvesTo("int")
	}
	
	@Test override void testBlockExpression_09() throws Exception {
		"{val Object x = if (false) return; x }".resolvesTo("void")
	}
    
    @Test override void testBlockExpression_10() throws Exception {
		"{ ( if (true) {val Object x = if (false) return; x } ) }".resolvesTo("void")
	}
    
    @Test override void testBlockExpression_11() throws Exception {
		"{ ( if (true) {val Object x = if (false) return; x } ) {val Object x = if (false) return; x } }".resolvesTo("void")
	}
	
	@Test override void testBlockExpression_12() throws Exception {
		"{ ( if (true) if (true) return else null ) { if (true) return else null } }".resolvesTo("void")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractBatchReturnTypeTest extends AbstractReturnTypeTest<LightweightTypeReference> {
	
	override LightweightTypeReference resolvesTo(String expression, String type) {
		val replacedExpressionText = expression.replace('$$', 'org::eclipse::xtext::xbase::lib::')
		val xExpression = expression(replacedExpressionText, false /* true */);
		assertTrue(xExpression.eResource.errors.toString, xExpression.eResource.errors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		val resolvedTypes = getTypeResolver.resolveTypes(xExpression)
		val resolvedType = resolvedTypes.getReturnType(xExpression)
		assertEquals(replacedExpressionText, type, resolvedType.simpleName);
		assertTrue(xExpression.eResource.linkingAndSyntaxErrors.toString, xExpression.eResource.linkingAndSyntaxErrors.isEmpty)
		assertTrue(xExpression.eResource.warnings.toString, xExpression.eResource.warnings.isEmpty)
		return resolvedType
	}
	
	def void doResolvesTo(String expression, String type) {
		val parsedExpression = expression(expression, false)
		val resolvedTypes = getTypeResolver.resolveTypes(parsedExpression)
		val resolvedType = resolvedTypes.getReturnType(parsedExpression)
		assertEquals(expression, type, resolvedType.simpleName);
	}
	
	def boolean hasReturnExpression(XExpression expression) {
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
		'''«type.type.simpleName»«type.typeArguments.join('<', ', ', '>') [simpleName]»'''
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
		val typeResolution = typeResolver.resolveTypes(null as EObject)
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
