/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator.IQuantities;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestFactory;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1Enum;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssignmentAllocatorTest extends AbstractXtextTests {
	private static CsvalidationtestFactory f = CsvalidationtestFactory.eINSTANCE;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ConcreteSyntaxValidationTestLanguageStandaloneSetup.class);
		allocator = getInjector().getInstance(IAssignmentQuantityAllocator.class);
		constraints = getInjector().getInstance(IConcreteSyntaxConstraintProvider.class);
	}

	private IAssignmentQuantityAllocator allocator;

	private IConcreteSyntaxConstraintProvider constraints;

	private String getAllocation(EObject object) {
		ISyntaxConstraint c = constraints.getConstraints(object.eClass()).iterator().next();
		IQuantities q = allocator.getAssignmentQuantities(object, c, Lists.<IConcreteSyntaxDiagnostic> newArrayList());
		return q.toString();
	}

	@Test public void testTransient() {
		TransientSerializeables1 ts = f.createTransientSerializeables1();
		assertEquals("((val1:0 enum1:0)? (val2:0 int1:0)?)", getAllocation(ts));

		ts = f.createTransientSerializeables1();
		ts.setVal1("foo");
		assertEquals("((val1:1 enum1:1)? (val2:0 int1:0)?)", getAllocation(ts));

		ts = f.createTransientSerializeables1();
		ts.setEnum1(TransientSerializeables1Enum.LIT2);
		assertEquals("((val1:0 enum1:1)? (val2:0 int1:0)?)", getAllocation(ts));

		ts = f.createTransientSerializeables1();
		ts.setEnum1(TransientSerializeables1Enum.LIT2);
		ts.setVal1("foo");
		assertEquals("((val1:1 enum1:1)? (val2:0 int1:0)?)", getAllocation(ts));

		ts = f.createTransientSerializeables1();
		ts.setVal2("foo");
		assertEquals("((val1:0 enum1:0)? (val2:1 int1:1)?)", getAllocation(ts));

		ts = f.createTransientSerializeables1();
		ts.setInt1(5);
		assertEquals("((val1:0 enum1:0)? (val2:0 int1:1)?)", getAllocation(ts));

		ts = f.createTransientSerializeables1();
		ts.setVal2("foo");
		ts.setInt1(5);
		assertEquals("((val1:0 enum1:0)? (val2:1 int1:1)?)", getAllocation(ts));
	}
}
