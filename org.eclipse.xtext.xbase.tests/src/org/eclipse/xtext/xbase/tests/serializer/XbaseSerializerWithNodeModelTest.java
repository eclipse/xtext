/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
public class XbaseSerializerWithNodeModelTest extends AbstractXbaseEvaluationTest {
	
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
		tester.assertSerializeWithNodeModel(expected);
	}

	@Ignore @Test
	@Override
	public void testReturnExpression_07() throws Exception {
		super.testReturnExpression_07();
	}
	
	@Ignore @Test
	@Override
	public void testReturnExpression_08() throws Exception {
		super.testReturnExpression_08();
	}
	
	@Override
	@Test @Ignore public void testClosure_32() throws Exception {
		super.testClosure_32();
	}
	
	@Override
	@Test @Ignore public void testClosure_31() throws Exception {
		super.testClosure_31();
	}
	
	
}
