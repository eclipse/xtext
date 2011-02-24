/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class XbaseTypeProviderTest extends AbstractXbaseTestCase {
	
	public void testFeatureCallWithArrayToIterableConversion() throws Exception {
		assertResolvedReturnType("java.util.Iterator<java.lang.Character>", "'foo'.toCharArray.iterator");
	}
	
	public void testReturnType() throws Exception {
		assertResolvedReturnType("void", "return 'foo'");
	}
	
	public void testClosure_00() throws Exception {
		assertResolvedReturnType("java.lang.String", "[|'literal'].apply()");
	}
	
	public void testClosure_01() throws Exception {
		assertResolvedReturnType("java.lang.String", "{" +
				"  var closure = [|'literal']" +
				"  new testdata.ClosureClient().invoke0(closure)" +
		"}");
	}
	
	public void testTypeArgs() throws Exception {
		assertResolvedReturnType("boolean", "new java.util.ArrayList<String>() += 'foo'");
	}

	public void testIfExpression() throws Exception {
		assertResolvedReturnType("java.lang.String", "if (true) 'foo' else null");
		assertResolvedReturnType("java.lang.String", "if (true) 'foo' else 'bar'");
		assertResolvedReturnType("java.lang.String", "if (true) 'foo'");
	}

	public void testSwitchExpression() throws Exception {
		assertResolvedReturnType(String.class.getName(),
				"switch true { case true : 's' case false : 'foo' default: 'bar'}");
		assertResolvedReturnType(Object.class.getName(),
				"switch true { case true : 's' case false : new java.lang.Object() default: 'bar'}");
	}

	public void testBlockExpression() throws Exception {
		assertResolvedReturnType(Integer.class.getName(), "{''.toString;4;}");
		assertResolvedReturnType(Boolean.class.getName(), "{''.toString;true;}");
		assertResolvedReturnType(Void.class.getName(), "{null;}");
	}

	public void testNullLiteral() throws Exception {
		assertResolvedReturnType(Void.class.getName(), "null");
	}

	public void testBooleanLiteral() throws Exception {
		assertResolvedReturnType(Boolean.class.getName(), "true");
		assertResolvedReturnType(Boolean.class.getName(), "false");
	}

	public void testStringLiteral() throws Exception {
		assertResolvedReturnType(String.class.getName(), "'foo'");
		assertResolvedReturnType(String.class.getName(), "\"foo\"");
	}

	public void testIntLiteral() throws Exception {
		assertResolvedReturnType(Integer.class.getName(), "3");
	}

	public void testCastExpression() throws Exception {
		assertResolvedReturnType(String.class.getName(), "null as String");
		assertResolvedReturnType(Boolean.class.getName(), "null as Boolean");
	}

	public void testConstructorCall() throws Exception {
		assertResolvedReturnType("java.util.ArrayList", "new java.util.ArrayList()");
		assertResolvedReturnType("java.util.ArrayList<java.lang.String>", "new java.util.ArrayList<java.lang.String>()");
		assertResolvedReturnType("java.util.HashMap<java.lang.String,java.lang.Boolean>",
				"new java.util.HashMap<java.lang.String, java.lang.Boolean>()");
		assertResolvedReturnType("java.util.HashMap<? extends java.lang.String,? super java.lang.Boolean>",
				"new java.util.HashMap<? extends java.lang.String, ? super java.lang.Boolean>()");
	}

	public void testClosure() throws Exception {
		assertResolvedReturnType(Functions.class.getCanonicalName()+"$Function1<java.lang.String,java.lang.Boolean>", "[java.lang.String x| true]");
	}

	public void testFeatureCall_01() throws Exception {
		assertResolvedReturnType("int", "'foo'.length");
	}

	public void testFeatureCall_02() throws Exception {
		assertResolvedReturnType("byte[]", "'foo'.getBytes()");
		assertResolvedReturnType("java.lang.String", "new java.util.ArrayList<java.lang.String>().get(23)");
	}
	
	public void testFeatureCall_03() throws Exception {
		assertResolvedReturnType("java.util.List<java.lang.Object>", "new testdata.ClassWithVarArgs().toList()");
		assertResolvedReturnType("java.util.List<java.lang.String>", "new testdata.ClassWithVarArgs().toList('')");
		assertResolvedReturnType("java.util.List<java.lang.String>", "new testdata.ClassWithVarArgs().toList('', '')");
	}
	
	public void testFeatureCall_04() throws Exception {
		// TODO: to be discussed: jdt expects java.util.List<? extends Object> 
		assertResolvedReturnType("java.util.List<java.lang.Comparable<? extends java.lang.Object>>", "new testdata.ClassWithVarArgs().toList('', 1)");
	}
	
	public void testFeatureCall_05() throws Exception {
		assertResolvedReturnType("java.util.List<java.lang.Number>", "new testdata.ClassWithVarArgs().toNumberList()");
		assertResolvedReturnType("java.util.List<java.lang.Integer>", "new testdata.ClassWithVarArgs().toNumberList(0)");
		assertResolvedReturnType("java.util.List<java.lang.Integer>", "new testdata.ClassWithVarArgs().toNumberList(0, 1)");
		assertResolvedReturnType("java.util.List<java.lang.Number>", "new testdata.ClassWithVarArgs().toNumberList(new Integer(0), new Integer(0).doubleValue)");
	}
	
	public void testFeatureCall_06() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.String>", "newArrayList('').map(s|s)");
	}
	
	public void testFeatureCall_06_1() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|1)");
	}
	
	public void testFeatureCall_07() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|s.length)");
	}
	
	public void testFeatureCall_08() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Boolean>", "newArrayList('').map(s|s != null)");
	}
	
	public void testFeatureCall_09() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|s.length+1)");
	}
	
	public void testFeatureCall_10() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|1).map(i|i+1)");
	}
	
	public void testFeatureCall_11() throws Exception {
		assertResolvedReturnType("java.util.List<java.lang.Integer>", "newArrayList('').map(s|1).toList()");
	}
	
	public void testFeatureCall_12() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|1).toList().map(i|i)");
	}
	
	public void testFeatureCall_13() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|1).toList().map(i|i+1)");
	}
	
	public void testFeatureCall_13_2() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "{ var this = newArrayList('').map(s|1).toList() this.map(i|i+1) }");
	}
	
	public void testFeatureCall_13_3() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "{ var this = newArrayList('').map(s|1).toList() map(i|i+1) }");
	}
	
	public void testFeatureCall_14() throws Exception {
		assertResolvedReturnType("java.util.ArrayList<java.lang.Iterable<java.lang.Integer>>", "newArrayList(newArrayList('').map(s|1))");
	}
	
	public void testFeatureCall_15() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList(newArrayList('').map(s|1)).map(iterable|iterable.size())");
	}
	
	public void testFeatureCall_16() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|1).map(i|1)");
	}
	
	public void testFeatureCall_17() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Integer>", "newArrayList('').map(s|s.length).map(i|i)");
	}
	
	public void testFeatureCall_18() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b|b)");
	}
	
	public void testFeatureCall_19() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| { 'length'.length b })");
	}
	
	public void testFeatureCall_20() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(boolean b|!b)");
	}
	
	public void testFeatureCall_21() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| ! b )");
	}
	
	public void testFeatureCall_22() throws Exception {
		assertResolvedReturnType("java.lang.Iterable<java.lang.Boolean>", "newArrayList('').map(s|s.length + 1 == 5).map(b| { !b } )");
	}

	public void testFeatureCallWithOperatorOverloading_2() throws Exception {
		assertResolvedReturnType("boolean", "new java.util.ArrayList<Byte>() += 'x'.getBytes().iterator.next");
	}
	
	public void testFeatureCallWithOperatorOverloading_3() throws Exception {
		assertResolvedReturnType("boolean", "new java.util.ArrayList<Byte>() += null");
	}
	
	public void testFeatureCallWithOperatorOverloading_4() throws Exception {
		assertResolvedReturnType("boolean", "new java.util.ArrayList<Byte>() += newArrayList('x'.getBytes().iterator.next)");
	}
	
	public void testFeatureCallWithOperatorOverloading_5() throws Exception {
		assertResolvedReturnType("boolean", "new java.util.ArrayList<Byte>() += 'x'.getBytes()");
	}
	
	public void testFeatureCallOnThis() throws Exception {
		assertResolvedReturnType("boolean", "{ val this = 'foo'; length == 3;}");
	}
	
	public void testStaticMethods_01() throws Exception {
		assertResolvedReturnType("java.util.ArrayList<java.lang.String>", "newArrayList('')");
	}
	
	public void testStaticMethods_02() throws Exception {
		assertResolvedReturnType("java.util.ArrayList<java.lang.String>", "newArrayList('', '')");
	}
	
	public void testStaticMethods_03() throws Exception {
		assertResolvedReturnType("java.util.ArrayList<java.util.HashSet<java.lang.String>>", "newArrayList(newHashSet(''))");
	}
	
	public void testStaticMethods_04() throws Exception {
		assertResolvedReturnType("java.util.ArrayList<java.lang.Object>", "newArrayList()");
	}

	public void testThrowExpression() throws Exception {
		assertResolvedReturnType("void", "throw new java.lang.Exception()");
	}

	public void testTryCatchFinallyExpression_0() throws Exception {
		assertResolvedReturnType("java.lang.String", "try 'foo' catch (java.lang.Exception e) 'bar'"); 
	}
	
	public void testTryCatchFinallyExpression_1() throws Exception {
		assertResolvedReturnType("java.lang.String", "try 'foo' catch (java.lang.Exception e) 'bar' catch(java.lang.RuntimeException e) 'baz'");	
	}
	
	public void testTryCatchFinallyExpression_2() throws Exception {
		assertResolvedReturnType("java.lang.String", "try 'foo' catch (java.lang.Exception e) 'bar' catch(java.lang.RuntimeException e) 'baz' finally true");	
	}

	public void testForExpression() throws Exception {
		assertResolvedReturnType("void", "for(java.lang.String x : new java.util.ArrayList()) 'foo'");
	}

	public void testNull() throws Exception {
		assertNull(typeProvider.getType(null));
	}

	public void testProxy() throws Exception {
		XFeatureCall proxy = XbaseFactory.eINSTANCE.createXFeatureCall();
		((InternalEObject) proxy).eSetProxyURI(URI.createURI("path#fragment"));
		assertNull(typeProvider.getType(proxy));
	}
	
	public void testMethodTypeParamInference_00() throws Exception {
		assertResolvedReturnType("java.lang.String", "new java.util.ArrayList<? extends String>().findFirst(e|true)");
	}
	
	public void testMethodTypeParamInference_01() throws Exception {
		assertResolvedReturnType("java.lang.String", "new java.util.ArrayList<String>().findFirst(e|e == 'foo')");
	}

	@Inject
	private ITypeProvider typeProvider;

	public void assertResolvedReturnType(String typeName, String expression) throws Exception {
		final XExpression expression2 = expression(expression, true);
		JvmTypeReference typeRef = typeProvider.getType(expression2);
		assertNotNull("type ref was null for " + expression, typeRef);
		assertEquals(typeName, toString(typeRef));
	}

	protected String toString(JvmTypeReference typeref) {
		return typeref.getIdentifier();
	}

}
