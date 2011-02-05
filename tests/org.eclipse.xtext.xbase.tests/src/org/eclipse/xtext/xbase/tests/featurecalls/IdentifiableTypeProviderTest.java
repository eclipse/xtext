/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.featurecalls;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IdentifiableTypeProviderTest extends AbstractXbaseTestCase {
	
	private IdentifiableTypeProvider typeProvider;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		typeProvider = get(IdentifiableTypeProvider.class);
	}
	
	public void testVariableDeclaration_in_ForExpression_0() throws Exception {
		XForLoopExpression expression = (XForLoopExpression) expression("for(x : null as java.util.List<String>) 'foo'", true);
		JvmTypeReference typeRef = typeProvider.getType(expression.getDeclaredParam(),false);
		assertEquals("java.lang.String", typeRef.getCanonicalName());
	}
	public void testVariableDeclaration_in_ForExpression_1() throws Exception {
		XForLoopExpression expression = (XForLoopExpression) expression("for(x : null as Iterable<?>) 'foo'", true);
		JvmTypeReference typeRef = typeProvider.getType(expression.getDeclaredParam(),false);
		assertEquals("java.lang.Object", typeRef.getCanonicalName());
	}
	public void testVariableDeclaration_in_ForExpression_2() throws Exception {
		XForLoopExpression expression = (XForLoopExpression) expression("for(x : null as java.util.ArrayList<? extends java.util.List<Integer>>) 'foo'", true);
		JvmTypeReference typeRef = typeProvider.getType(expression.getDeclaredParam(),false);
		assertEquals("java.util.List<java.lang.Integer>", typeRef.getCanonicalName());
	}
}
