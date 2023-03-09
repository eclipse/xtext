/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidationTestHelper {

	public void assertMatch(TestChain chain, EStructuralFeature... expectedFeatures) {
		List<EStructuralFeature> asList = Arrays.asList(expectedFeatures);
		Assert.assertEquals("expected : " + asList + " , but was " + chain.features, expectedFeatures.length, chain.features.size());
		Assert.assertTrue("expected : " + asList + " , but was " + chain.features, asList.containsAll(chain.features));
	}

	public TestChain chain() {
		return new TestChain();
	}

	public TestValidator validator() {
		final TestValidator testValidator =  new TestValidator();
		return testValidator;
	}

	public final class TestChain implements DiagnosticChain {
		private final List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();

		public boolean isEmpty() {
			return features.isEmpty();
		}

		@Override
		public void add(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			Assert.assertTrue(diagnostic.getData().get(0) instanceof EObject);
			features.add((EStructuralFeature) diagnostic.getData().get(1));
		}

		@Override
		public void addAll(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void merge(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			throw new UnsupportedOperationException();
		}

		@Override
		public String toString() {
			return features.toString();
		}
	}

	@ComposedChecks(validators = { ExternalValidator.class })
	public static class TestValidator extends AbstractDeclarativeValidator {
		
		@Override
		protected AbstractDeclarativeValidator newInstance(Class<? extends AbstractDeclarativeValidator> clazz) {
			try {
				return clazz.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		@Check
		protected void foo(EStructuralFeature x) {
			error("fooInteger", EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE);
		}

		@Check
		public void foo(Object x) {
			error("fooObject", EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		}
	}

	@ComposedChecks(validators = { TestValidator.class })
	protected static class ExternalValidator extends AbstractDeclarativeValidator {
		
		@Override
		protected AbstractDeclarativeValidator newInstance(Class<? extends AbstractDeclarativeValidator> clazz) {
			try {
				return clazz.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		@Check
		private void foo(EClass x) {
			error("fooString", EcorePackage.Literals.ECLASS__ABSTRACT);
		}
	}

}
