/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static org.eclipse.xtext.junit.validation.AssertableDiagnostics.error;
import static org.eclipse.xtext.junit.validation.AssertableDiagnostics.warning;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.validation.ValidatorTester;

/**
 * @author meysholdt - Initial contribution and API
 */
public class ValidatorTestingTest extends TestCase {

	private class TestingValidator extends AbstractDeclarativeValidator {
		@Check
		public void someError(EAnnotation dummy) {
			error("someError message", dummy, 1, 101);
		}

		@Check
		public void someWarning(EClass dummy) {
			warning("someWarning message", dummy, 1, 102);
		}

		@Check
		public void manyMessages(EClass dummy) {
			error("ErrorOne message", dummy, 1, 103);
			error("ErrorTwo message", dummy, 1, 104);
			warning("WarningOne message", dummy, 1, 105);
		}

		@Override
		protected List<? extends EPackage> getEPackages() {
			return Arrays.asList(EcorePackage.eINSTANCE);
		}
	}

	private ValidatorTester<TestingValidator> tester;

	@Override
	public void setUp() {
		TestingValidator val = new TestingValidator();
		new XtextStandaloneSetup().createInjectorAndDoEMFRegistration().injectMembers(val);
		tester = new ValidatorTester<TestingValidator>(val);
	}

	public void testError() {
		tester.validator().someError(EcoreFactory.eINSTANCE.createEAnnotation());
		tester.diagnose().assertError(101, "someError");
	}

	public void testError2() {
		tester.validate(EcoreFactory.eINSTANCE.createEAnnotation()).assertError(101, "someError");
	}

	public void testError2Fail() {
		boolean caught = false;
		try {
			tester.validate(EcoreFactory.eINSTANCE.createEAnnotation()).assertError(234242);
		}
		catch (AssertionError err) {
			caught = true;
		}
		assertTrue(caught);
	}

	public void testTwoErrors() {
		tester.validator().manyMessages(EcorePackage.eINSTANCE.getEClass());
		tester.diagnose().assertAll(warning(105, "WarningOne"), error(104, "ErrorTwo"), error(103, "ErrorOne"));
	}

	public void testFail() {
		tester.validator().someError(EcoreFactory.eINSTANCE.createEAnnotation());
		boolean caught = false;
		try {
			tester.diagnose().assertError(12345, "someError");
		}
		catch (AssertionError err) {
			caught = true;
		}
		assertTrue(caught);
	}

	public void testWarning() {
		tester.validator().someWarning(EcorePackage.eINSTANCE.getEClass());
		tester.diagnose().assertWarning(102, "someWarning");
	}

}
