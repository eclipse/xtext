/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static org.junit.Assert.*;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.xtext.validation.CompositeEValidator.EValidatorEqualitySupport;
import org.junit.Test;

import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class CompositeEValidatorTest {

	private static class TestEcoreValidator extends EcoreValidator {
		private boolean called;

		@Override
		public boolean validateENamedElement_WellFormedName(ENamedElement eNamedElement, DiagnosticChain diagnostics,
				Map<Object, Object> context) {
			this.called = true;
			return true;
		}
		
		public boolean wasCalled() {
			return called;
		}
	}

	/** Test for https://bugs.eclipse.org/bugs/show_bug.cgi?id=396726 */
	@Test public void testNoShortCircuiting() {
		CompositeEValidator compositeValidator = new CompositeEValidator();
		compositeValidator.setEqualitySupportProvider(new Provider<CompositeEValidator.EValidatorEqualitySupport>() {
			@Override
			public EValidatorEqualitySupport get() {
				return new CompositeEValidator.EValidatorEqualitySupport();
			}
		});
		assertEquals(1, compositeValidator.getContents().size());

		compositeValidator.addValidator(EcoreValidator.INSTANCE);
		assertEquals(2, compositeValidator.getContents().size());

		TestEcoreValidator testValidator = new TestEcoreValidator();
		compositeValidator.addValidator(testValidator);
		assertEquals(3, compositeValidator.getContents().size());
		
		compositeValidator.validate(EcoreFactory.eINSTANCE.createEClass(), new BasicDiagnostic(), null);
		assertTrue(testValidator.wasCalled());
	}
}
