/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XbaseSerializerWithNodeModelTest extends AbstractXbaseEvaluationTest {

	static Injector injector = new XbaseStandaloneSetup() {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new org.eclipse.xtext.xbase.XbaseRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXbaseTestCase.class.getClassLoader();
				}
			});
		}
	}.createInjectorAndDoEMFRegistration();

	@Inject
	private ParseHelper<XExpression> parseHelper;

	@Inject
	private ISerializer serializer;

	@Inject
	private ValidationTestHelper validationHelper;

	protected XExpression expression(String string, boolean resolve) throws Exception {
		XExpression result = parseHelper.parse(string);
		if (resolve) {
			validationHelper.assertNoErrors(result);
		}
		return result;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		injector.injectMembers(this);
	}

	@Override
	protected void tearDown() throws Exception {
		parseHelper = null;
		super.tearDown();
	}

	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		assertSerializeable(string);
	}

	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		assertSerializeable(string);
	}

	protected void assertSerializeable(String expected) {
		try {
			XExpression expr = expression(expected, true);
			//			System.out.println(EmfFormatter.objToStr(expr));
			String actual = serializer.serialize(expr);
			assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Override
	public void testSubtractionOnIntegers() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344707
	}

	@Override
	public void testForLoop_04() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344707
	}
}
