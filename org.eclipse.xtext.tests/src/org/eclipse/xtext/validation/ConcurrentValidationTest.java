/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.validation.ValidationTestHelper.TestChain;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcurrentValidationTest extends AbstractXtextTests {

	private ValidationTestHelper helper;

	@Override
	public void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		helper = new ValidationTestHelper();
	}

	@Test public void testConcurrentValidation() {
		AbstractDeclarativeValidator validator = new ValidationTestHelper.TestValidator() {
			@Override
			protected void foo(EStructuralFeature x) {
				try {
					Thread.sleep(50);
					super.foo(x);
					Thread.sleep(50);
				}
				catch (InterruptedException e) {
					//
				}
			}

			@Override
			public void foo(Object x) {
				try {
					Thread.sleep(50);
					super.foo(x);
					Thread.sleep(50);
				}
				catch (InterruptedException e) {
					//
				}
			}
		};
		PoorMansValidationJob runnable = new PoorMansValidationJob(validator);
		for(int i = 0; i < 100; i++) {
			new Thread(runnable).start();
		}
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			//
		}
		assertNull(runnable.lastEx);
		assertNull(runnable.lastError);
	}

	private class PoorMansValidationJob implements Runnable {

		private final AbstractDeclarativeValidator validator;
		private IllegalStateException lastEx;
		private AssertionError lastError;

		private PoorMansValidationJob(AbstractDeclarativeValidator validator) {
			this.validator = validator;
		}

		@Override
		public void run() {
			try {
				TestChain diagnostics = helper.chain();
				validator.validate(EcorePackage.eINSTANCE.getEClass(), diagnostics, null);
				helper.assertMatch(diagnostics, EcorePackage.Literals.ENAMED_ELEMENT__NAME, EcorePackage.Literals.ECLASS__ABSTRACT);
			} catch(IllegalStateException e) {
				lastEx = e;
			} catch(AssertionError error) {
				lastError = error;
			}
		}
	}

}
