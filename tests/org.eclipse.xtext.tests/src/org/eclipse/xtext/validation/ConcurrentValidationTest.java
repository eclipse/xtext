/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.validation.ValidationTestHelper.TestChain;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcurrentValidationTest extends AbstractXtextTests {

	private ValidationTestHelper helper;

	@Override
	protected void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		helper = new ValidationTestHelper();
	}

	public void testConcurrentValidation() {
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
		private AssertionFailedError lastError;

		private PoorMansValidationJob(AbstractDeclarativeValidator validator) {
			this.validator = validator;
		}

		public void run() {
			try {
				TestChain diagnostics = helper.chain();
				validator.validate(EcorePackage.eINSTANCE.getEClass(), diagnostics, null);
				helper.assertMatch(diagnostics, 1, 3);
			} catch(IllegalStateException e) {
				lastEx = e;
			} catch(AssertionFailedError error) {
				lastError = error;
			}
		}
	}

}
