/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.validation.ValidationTestHelper.TestChain;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
public class AbstractDeclarativeValidatorTest extends TestCase {

	private ValidationTestHelper helper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.helper = new ValidationTestHelper();
	}

	@Override
	protected void tearDown() throws Exception {
		this.helper = null;
		super.tearDown();
	}

	public void testSimpleDispatch() throws Exception {
		AbstractDeclarativeValidator test = helper.validator();
		TestChain chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, null);
		helper.assertMatch(chain, 1, 3);
	}

	public void testDeeperHierarchyWithOverwrittenJavaMethods() throws Exception {
		AbstractDeclarativeValidator test = new ValidationTestHelper.TestValidator() {
			@Override
			@Check
			public void foo(Object x) {
				error("fooObject", 5);
			}
		};
		TestChain chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, null);
		helper.assertMatch(chain, 1, 5);
	}

	@SuppressWarnings("serial")
	public void testSkipExpensive() throws Exception {
		AbstractDeclarativeValidator test = new ValidationTestHelper.TestValidator() {
			@SuppressWarnings("unused")
			@Check(CheckType.EXPENSIVE)
			public void bar(Object x) {
				error("fooObject", 27);
			}
		};
		TestChain chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, new HashMap<Object, Object>() {
			{
				put(CheckMode.KEY, CheckMode.NORMAL_AND_FAST);
			}
		});
		helper.assertMatch(chain, 1, 3);

		chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, new HashMap<Object, Object>() {
			{
				put(CheckMode.KEY, CheckMode.ALL);
			}
		});
		helper.assertMatch(chain, 1, 3, 27);

		chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, null);
		helper.assertMatch(chain, 1, 3, 27);
	}

	public void testGuard() throws Exception {
		AbstractDeclarativeValidator validator = new AbstractDeclarativeValidator() {
			@SuppressWarnings("unused")
			@Check
			public void guarded(EClass x) {
				guard("".equals(x.getName()));
			}
		};

		TestChain diagnostics = helper.chain();
		validator.validate(EcorePackage.eINSTANCE.getEClass(), diagnostics, null);
		assertTrue(diagnostics.toString(), diagnostics.isEmpty());
	}

	@SuppressWarnings("serial")
	public void testCheckModeSettedProperly() throws Exception {
		AbstractDeclarativeValidator test = helper.validator();
		TestChain chain = helper.chain();
		try {
			test.validate(EcorePackage.eINSTANCE.getEClass(), chain, new HashMap<Object, Object>() {
				{
					put(CheckMode.KEY, CheckType.NORMAL);
				}
			});
		}
		catch (IllegalArgumentException iae) {
			return;
		}
		fail("CheckMode with wrong type, should throw an IllegalArgumentException");
	}
	
	public void testAssertThreadLocalState() throws Exception {
		AbstractDeclarativeValidator test = new ValidationTestHelper.TestValidator() {
			@Override
			@Check
			public void foo(Object x) {
				Assert.assertNotNull("currentObject must not be null", getCurrentObject());
				Assert.assertNotNull("currentMethod must not be null", getCurrentMethod());
				Assert.assertNotNull("chain must not be null", getChain());
				Assert.assertNotNull("checkMode must not be null", getCheckMode());
				Assert.assertNotNull("context must not be null", getContext());
				
			}
		};
		TestChain chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
	}
	
	public void testCurrentObjectAndMethod() throws Exception {
		AbstractDeclarativeValidator test = new ValidationTestHelper.TestValidator() {
			@Override
			@Check
			public void foo(Object x) {
				Assert.assertEquals(EcorePackage.eINSTANCE.getEClass(), getCurrentObject());
				try {
					Assert.assertEquals(getClass().getMethod("foo", Object.class), getCurrentMethod());
				} catch (Exception e) {
					fail("unexpected");
				} 
			}
		};
		TestChain chain = helper.chain();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
	}
	
	public void testContext() throws Exception {
		AbstractDeclarativeValidator test = new ValidationTestHelper.TestValidator() {
			@Override
			@Check
			public void foo(Object x) {
				Assert.assertEquals(1, getContext().size());
				Assert.assertEquals(CheckMode.EXPENSIVE_ONLY, getContext().get(CheckMode.KEY));
			}
		};
		TestChain chain = helper.chain();
		Map<Object, Object> singletonMap = Collections.<Object, Object>singletonMap(CheckMode.KEY, CheckMode.EXPENSIVE_ONLY);
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, singletonMap);
	}
	
	public void testCheckMode() throws Exception {
		AbstractDeclarativeValidator test = new ValidationTestHelper.TestValidator() {
			@Override
			@Check
			public void foo(Object x) {
				Assert.assertEquals(CheckMode.EXPENSIVE_ONLY, getCheckMode());
			}
		};
		TestChain chain = helper.chain();
		Map<Object, Object> singletonMap = Collections.<Object, Object>singletonMap(CheckMode.KEY, CheckMode.EXPENSIVE_ONLY);
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, singletonMap);
	}
	
	public void testError() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				error("Error Message", 1);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testErrorWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				error("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testWarning() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				warning("Error Message", 1);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.WARNING, diag.getSeverity());
	}

	public void testWarningWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				warning("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.WARNING, diag.getSeverity());
	}

	public void testAssertTrue1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertTrue("Error Message", 1, true);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertTrue2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertTrue("Error Message", 1, false);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertTrueWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertTrue("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, false);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertFalse1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertFalse("Error Message", 1, false);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertFalse2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertFalse("Error Message", 1, true);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertFalseWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertFalse("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, true);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNull1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNull("Error Message", 1, null);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertNull2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNull("Error Message", 1, "");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNullWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNull("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, "");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotNull1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotNull("Error Message", 1, "");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertNotNull2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotNull("Error Message", 1, null);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotNullWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotNull("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, null);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertEquals1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEquals("Error Message", 1, "abc", "abc");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertEquals2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEquals("Error Message", 1, "abc", "xyz");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertEqualsWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEquals("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, "abc", "xyz");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotEquals1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEquals("Error Message", 1, "abc", "xyz");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertNotEquals2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEquals("Error Message", 1, "abc", "abc");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotEqualsWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEquals("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, "abc", "abc");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertEmpty1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEmpty("Error Message", 1, null);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertEmpty2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEmpty("Error Message", 1, " ");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertEmpty3() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEmpty("Error Message", 1, "abc");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertEmptyWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertEmpty("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, "abc");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotEmpty1() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEmpty("Error Message", 1, "abc");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(0, chain.getChildren().size());
	}

	public void testAssertNotEmpty2() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEmpty("Error Message", 1, null);
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotEmpty3() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEmpty("Error Message", 1, " ");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEClass().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

	public void testAssertNotEmptyWithSource() {
		AbstractDeclarativeValidator test = new AbstractDeclarativeValidator() {
			@Check
			@SuppressWarnings("unused")
			public void foo(Object x) {
				assertNotEmpty("Error Message", EcorePackage.eINSTANCE.getEAnnotation(), 1, " ");
			}
		};
		BasicDiagnostic chain = new BasicDiagnostic();
		test.validate(EcorePackage.eINSTANCE.getEClass(), chain, Collections.emptyMap());
		assertEquals(1, chain.getChildren().size());

		Diagnostic diag = chain.getChildren().get(0);
		assertEquals("Error Message", diag.getMessage());
		assertEquals(EcorePackage.eINSTANCE.getEAnnotation().toString(), diag.getSource());
		assertEquals(Diagnostic.ERROR, diag.getSeverity());
	}

}
