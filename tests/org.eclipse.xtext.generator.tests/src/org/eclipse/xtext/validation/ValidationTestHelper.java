/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidationTestHelper {

	public void assertMatch(TestChain chain, Integer... expectedFeatureIds) {
		List<Integer> asList = Arrays.asList(expectedFeatureIds);
		Assert.assertEquals("expected : " + asList + " , but was " + chain.integers, expectedFeatureIds.length, chain.integers.size());
		Assert.assertTrue("expected : " + asList + " , but was " + chain.integers, asList.containsAll(chain.integers));
	}

	public TestChain chain() {
		return new TestChain();
	}

	public TestValidator validator() {
		return new TestValidator();
	}

	public final class TestChain implements DiagnosticChain {
		private final List<Integer> integers = new ArrayList<Integer>();

		public boolean isEmpty() {
			return integers.isEmpty();
		}

		public void add(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			Assert.assertTrue(diagnostic.getData().get(0) instanceof EObject);
			integers.add((Integer) diagnostic.getData().get(1));
		}

		public void addAll(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			throw new UnsupportedOperationException();
		}

		public void merge(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			throw new UnsupportedOperationException();
		}

		@Override
		public String toString() {
			return integers.toString();
		}
	}

	@ComposedChecks(validators = { ExternalValidator.class })
	public static class TestValidator extends AbstractDeclarativeValidator {
		@Check
		protected void foo(EStructuralFeature x) {
			error("fooInteger", 2);
		}

		@Check
		public void foo(Object x) {
			error("fooObject", 3);
		}
	}

	@ComposedChecks(validators = { TestValidator.class })
	private static class ExternalValidator extends AbstractDeclarativeValidator {
		@SuppressWarnings("unused")
		@Check
		private void foo(EClass x) {
			error("fooString", 1);
		}
	}

}
