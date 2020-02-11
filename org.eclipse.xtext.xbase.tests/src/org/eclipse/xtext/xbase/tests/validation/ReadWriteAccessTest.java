/*******************************************************************************
 * Copyright (c) 2018 Belfort-Montbeliard University of Technology (http://www.utbm.fr) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;

import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;


/** Test the read/write accesses to local variables and fields.
 *
 * Extra tests are included within <a href="https://github.com/eclipse/xtext-xtend/pull/368">Xtend</a>.
 *
 * @author Stephane Galland - Initial contribution and API
 * @since 2.14
 * @see "https://github.com/eclipse/xtext-extras/pull/232"
 * @see "https://github.com/eclipse/xtext-xtend/pull/368"
 */
@SuppressWarnings("all")
public class ReadWriteAccessTest extends AbstractXbaseTestCase {
		
	@Inject
	protected ValidationTestHelper helper;

	@Test
	public void test000() throws Exception {
		XExpression expr = expression("{ val int f = 1; 1 }");
		helper.assertWarning(expr,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				org.eclipse.xtext.xbase.validation.IssueCodes.UNUSED_LOCAL_VARIABLE,
				"variable f");
	}

	@Test
	public void test001() throws Exception {
		XExpression expr = expression("{ var int f = 1;  1 }");
		helper.assertWarning(expr,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				org.eclipse.xtext.xbase.validation.IssueCodes.UNUSED_LOCAL_VARIABLE,
				"variable f");
	}

	@Test
	public void test002() throws Exception {
		XExpression expr = expression("{ var int f;  f = 2 }");
		helper.assertWarning(expr,
				XbasePackage.eINSTANCE.getXVariableDeclaration(),
				org.eclipse.xtext.xbase.validation.IssueCodes.UNUSED_LOCAL_VARIABLE,
				"variable f");
	}

	@Test
	public void test003() throws Exception {
		XExpression expr = expression("{ var int f = 1;  var int x = f;  return x }");
		helper.assertNoIssues(expr);
	}

	@Test
	public void test004() throws Exception {
		XExpression expr = expression("{ var int f = 1;  f = f + 1 }");
		helper.assertNoIssues(expr);
	}

	@Test
	public void test005() throws Exception {
		XExpression expr = expression("{ var int f = 1; Math::abs(f) }");
		helper.assertNoIssues(expr);
	}

	@Test
	public void test006() throws Exception {
		XExpression expr = expression("{ var int f = 1;  for (i : 1..f) { } }");
		helper.assertNoIssues(expr);
	}

}

