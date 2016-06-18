/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FunctionTypeRefAwareInjectorProvider.class)
public class XbaseSerializerWithoutNodeModelTest extends AbstractXbaseEvaluationTest {

	@Inject
	private SerializerTester tester;

	@Override
	protected void assertEvaluatesTo(Object object, String string) throws Exception {
		assertSerializeable(string);
	}

	@Override
	protected void assertEvaluatesToArray(Object[] object, String string) throws Exception {
		assertSerializeable(string);
	}

	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) throws Exception {
		assertSerializeable(string);
	}

	protected void assertSerializeable(String expected) throws Exception {
		tester.assertSerializeWithoutNodeModel(expected);
	}
	
	@Override
	@Test 
	@Ignore
	public void testClosure_32() throws Exception {
		super.testClosure_32();
	}
	
	@Override
	@Test 
	@Ignore
	public void testClosure_31() throws Exception {
		super.testClosure_31();
	}

}
