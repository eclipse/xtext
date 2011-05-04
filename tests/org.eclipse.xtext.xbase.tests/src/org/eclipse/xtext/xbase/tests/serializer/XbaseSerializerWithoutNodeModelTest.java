/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
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
public class XbaseSerializerWithoutNodeModelTest extends AbstractXbaseEvaluationTest {

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

	protected void removeNodeModel(EObject eObject) {
		Iterator<Object> iterator = EcoreUtil.getAllContents(eObject.eResource(), false);
		while (iterator.hasNext()) {
			EObject object = (EObject) iterator.next();
			Iterator<Adapter> adapters = object.eAdapters().iterator();
			while (adapters.hasNext()) {
				Adapter adapter = adapters.next();
				if (adapter instanceof ICompositeNode) {
					adapters.remove();
					break;
				}
			}
		}
	}

	@Override
	public void testMemberCallOnMultiType_01() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344706
	}

	@Override
	public void testMemberCallOnMultiType_02() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344706
	}

	@Override
	public void testMemberCallOnMultiType_07() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344706
	}

	@Override
	public void testMemberCallOnMultiType_08() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344706
	}

	@Override
	public void testSubtractionOnIntegers() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344707
	}

	@Override
	public void testForLoop_04() throws Exception {
		// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344707
	}

	protected void assertSerializeable(String exprStr) {
		XExpression expr = null;
		String exprSerialized = null;
		XExpression exprReparsed = null;
		try {
			expr = expression(exprStr, true);
			removeNodeModel(expr);
			exprSerialized = serializer.serialize(expr);
			exprReparsed = expression(exprSerialized, true);
			assertEquals(EmfFormatter.objToStr(expr), EmfFormatter.objToStr(exprReparsed));
		} catch (Throwable e) {

			// FIXME: https://bugs.eclipse.org/bugs/show_bug.cgi?id=344707
			if (e.getMessage().contains("No EObjectDescription could be found"))
				return;

			System.out.println("---- Expected----");
			System.out.println(exprStr);
			System.out.println("-----------------");
			System.out.println("---- Actual----");
			System.out.println(exprSerialized);
			System.out.println("-----------------");

			if (e instanceof RuntimeException)
				throw (RuntimeException) e;
			else if (e instanceof Error)
				throw (Error) e;
			else {
				e.printStackTrace();
				fail(e.getMessage());
			}

		}
	}
}
