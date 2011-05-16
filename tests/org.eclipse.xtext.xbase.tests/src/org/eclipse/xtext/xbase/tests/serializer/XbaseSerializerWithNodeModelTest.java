/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import org.eclipse.xtext.junit.serializer.SerializerTester;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
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
	private SerializerTester tester;

	@Override
	protected void assertEvaluatesTo(Object object, String string) throws Exception {
		assertSerializeable(string);
	}

	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) throws Exception {
		assertSerializeable(string);
	}

	protected void assertSerializeable(String expected) throws Exception {
		tester.assertSerializeWithNodeModel(expected);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		injector.injectMembers(this);
	}

}
