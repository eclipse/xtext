/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.xtext.validation.CompositeEValidator.EValidatorEqualitySupport;
import org.junit.Assert;
import org.junit.Test;

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
	@Test
	public void testNoShortCircuiting() {
		CompositeEValidator compositeValidator = new CompositeEValidator();
		compositeValidator.setEqualitySupportProvider(CompositeEValidator.EValidatorEqualitySupport::new);
		assertEquals(1, compositeValidator.getContents().size());

		compositeValidator.addValidator(EcoreValidator.INSTANCE);
		assertEquals(2, compositeValidator.getContents().size());

		TestEcoreValidator testValidator = new TestEcoreValidator();
		compositeValidator.addValidator(testValidator);
		assertEquals(3, compositeValidator.getContents().size());
		
		compositeValidator.validate(EcoreFactory.eINSTANCE.createEClass(), new BasicDiagnostic(), null);
		assertTrue(testValidator.wasCalled());
	}
	
	@Test
	public void testCopyAndClearContents() {
		class TestMe extends CompositeEValidator {
		}
		CompositeEValidator testee = new TestMe();
		testee.setEqualitySupportProvider(CompositeEValidator.EValidatorEqualitySupport::new);
		testee.setUseEObjectValidator(true);
		List<EValidatorEqualitySupport> oldContents = testee.getContents();
		CompositeEValidator copy = testee.getCopyAndClearContents();
		Assert.assertEquals(testee.getClass(), copy.getClass());
		List<EValidatorEqualitySupport> newContents = testee.getContents();
		Assert.assertEquals(oldContents.size(), newContents.size());
		Assert.assertSame(oldContents.get(0), copy.getContents().get(0));
		Assert.assertNotSame(oldContents.get(0), testee.getContents().get(0));
	}
}
