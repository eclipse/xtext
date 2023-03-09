/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseIdentifiableTypeProviderTest extends AbstractXbaseTestCase {
	
	@Inject
	protected IBatchTypeResolver typeResolver;
	
	@Test public void testVariableDeclaration_in_ForExpression_0() throws Exception {
		XForLoopExpression expression = (XForLoopExpression) expression("for(x : null as java.util.List<String>) x.length", true);
		LightweightTypeReference typeRef = typeResolver.resolveTypes(expression).getActualType(expression.getDeclaredParam());
		assertEquals("java.lang.String", typeRef.getIdentifier());
	}
	@Test public void testVariableDeclaration_in_ForExpression_1() throws Exception {
		XForLoopExpression expression = (XForLoopExpression) expression("for(x : null as Iterable<?>) x.hashCode", true);
		LightweightTypeReference typeRef = typeResolver.resolveTypes(expression).getActualType(expression.getDeclaredParam());
		assertEquals("java.lang.Object", typeRef.getIdentifier());
	}
	@Test public void testVariableDeclaration_in_ForExpression_2() throws Exception {
		XForLoopExpression expression = (XForLoopExpression) expression("for(x : null as java.util.ArrayList<? extends java.util.List<Integer>>) x.hashCode", true);
		LightweightTypeReference typeRef = typeResolver.resolveTypes(expression).getActualType(expression.getDeclaredParam());
		assertEquals("java.util.List<java.lang.Integer>", typeRef.getIdentifier());
	}
	
	@Test
	public void testClosureParameter() throws Exception {
//		List<? super String> list = Lists.newArrayList();
//		ListExtensions.map(list, new Functions.Function1<CharSequence, String>() {
//			public String apply(CharSequence p) {
//				return null;
//			}
//		});
//		ListExtensions.map(list, new Functions.Function1<Object, String>() {
//			public String apply(Object p) {
//				return null;
//			}
//		});
		XBlockExpression block = (XBlockExpression) expression(
				"{\n" + 
				"  var java.util.List<? super String> list = null;\n" + 
				"  list.map(e|e)\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(1);
		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
		JvmFormalParameter e = closure.getDeclaredFormalParameters().get(0);
		LightweightTypeReference typeRef = typeResolver.resolveTypes(closure).getActualType(e);
		assertEquals("java.lang.Object", typeRef.getIdentifier());
	}
}
