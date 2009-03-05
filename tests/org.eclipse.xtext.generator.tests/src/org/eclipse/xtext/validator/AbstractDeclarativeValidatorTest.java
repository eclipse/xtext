/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class AbstractDeclarativeValidatorTest extends TestCase {

	public void testSimpleDispatch() throws Exception {

		AbstractDeclarativeValidator test = new TestValidator();
		TestChain chain = chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, null);
		assertMatch(chain, 1, 3);
	}

	public void testDeeperHierarchyWithOverwrittenJavaMethods() throws Exception {
		AbstractDeclarativeValidator test = new TestValidator() {
			@Override
			@Check
			public void foo(Object x) {
				error("fooObject",5);
			}
		};
		TestChain chain = chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, null);
		assertMatch(chain, 1, 5);
	}

	public void testSkipExpensive() throws Exception {
		AbstractDeclarativeValidator test = new TestValidator() {
			@SuppressWarnings("unused")
			@Check(CheckType.EXPENSIVE)
			public void bar(Object x) {
				error("fooObject",27);
			}
		};
		TestChain chain = chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.singletonMap((Object)CheckMode.KEY, (Object)CheckMode.FAST));
		assertMatch(chain, 1, 3);

		chain = chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.singletonMap((Object)CheckMode.KEY, (Object)CheckMode.ALL));
		assertMatch(chain, 1, 3, 27);

		chain = chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, null);
		assertMatch(chain, 1, 3, 27);
	}

	private void assertMatch(TestChain chain, Integer ... expectedFeatureIds) {
		assertEquals(expectedFeatureIds.length, chain.integers.size());
		List<Integer> asList = Arrays.asList(expectedFeatureIds);
		assertTrue("expected : "+asList+" , but was "+chain.integers,chain.integers.containsAll(asList));
	}


	private TestChain chain() {
		return new TestChain();
	}
	
	
	public void testGuard() throws Exception {
		AbstractDeclarativeValidator validator = new AbstractDeclarativeValidator(){
			@Check
			public void guarded(EClass x) {
				guard("".equals(x.getName()));
			}
		};
		
		TestChain diagnostics = new TestChain();
		validator.validate(EcorePackage.eINSTANCE.getEClass(), diagnostics, null);
		assertEquals(0,diagnostics.integers.size());
	}
	
	@SuppressWarnings("unused")
	private class TestValidator extends AbstractDeclarativeValidator {
		@Check
		private void foo(EClass x) {
			error("fooString",1);
		}

		@Check
		protected void foo(EStructuralFeature x) {
			error("fooInteger",2);
		}

		@Check
		public void foo(Object x) {
			error("fooObject",3);
		}
	}

	private final class TestChain implements DiagnosticChain {
		public List<Integer> integers = new ArrayList<Integer>();

		public void add(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			assertTrue(diagnostic.getData().get(0) instanceof EObject);
			integers.add((Integer) diagnostic.getData().get(1));
		}

		public void addAll(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			throw new UnsupportedOperationException();
		}

		public void merge(org.eclipse.emf.common.util.Diagnostic diagnostic) {
			throw new UnsupportedOperationException();
		}
	}
}
