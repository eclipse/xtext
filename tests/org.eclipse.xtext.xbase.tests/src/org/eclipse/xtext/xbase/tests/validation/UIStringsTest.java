/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stéphane Galland - Initial contribution and API
 */
public class UIStringsTest extends AbstractXbaseTestCase {
	
	@Inject
	protected UIStrings uiStrings;
	
	@Inject
	protected TypeReferences typeReferences;
	
	@Test
	public void testReferenceToString_0() throws Exception {
		XExpression expr = expression("typeof(foo.String)", true);
		assertTrue(expr instanceof XTypeLiteral);
		XTypeLiteral operator = (XTypeLiteral) expr;
		JvmType type = operator.getType();
		JvmTypeReference reference = this.typeReferences.createTypeRef(type);
		assertEquals("String", this.uiStrings.referenceToString(reference, "the-default-value"));
	}

	@Test
	public void testReferenceToString_1() throws Exception {
		XExpression expr = expression("typeof(String)", true);
		assertTrue(expr instanceof XTypeLiteral);
		XTypeLiteral operator = (XTypeLiteral) expr;
		JvmType type = operator.getType();
		JvmTypeReference reference = this.typeReferences.createTypeRef(type);
		assertEquals("String", this.uiStrings.referenceToString(reference, "the-default-value"));
	}

	@Test
	public void testReferenceToString_2() throws Exception {
		XExpression expr = expression("null as foo.String", true);
		assertTrue(expr instanceof XCastedExpression);
		XCastedExpression operator = (XCastedExpression) expr;
		JvmTypeReference reference = operator.getType();
		assertEquals("String", this.uiStrings.referenceToString(reference, "the-default-value"));
	}

	@Test
	public void testReferenceToString_3() throws Exception {
		XExpression expr = expression("{ var foo.String x }", false);
		assertNotNull(expr);
		XVariableDeclaration declaration = (XVariableDeclaration) (((XBlockExpression) expr).getExpressions().get(0));
		JvmTypeReference reference = declaration.getType();
		assertEquals("String", this.uiStrings.referenceToString(reference, "the-default-value"));
	}
	
	@Test
	public void testReferenceToString_4() throws Exception {
		XExpression expr = expression("null", true);
		JvmTypeReference reference = this.typeReferences.createAnyTypeReference(expr);
		assertEquals("Object", this.uiStrings.referenceToString(reference, "the-default-value"));
	}
	
}
