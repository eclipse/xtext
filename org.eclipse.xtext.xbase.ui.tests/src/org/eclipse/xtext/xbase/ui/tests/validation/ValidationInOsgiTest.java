/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.validation;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.ui.tests.XbaseInjectorProvider;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseInjectorProvider.class)
public class ValidationInOsgiTest extends AbstractXbaseTestCase {

	@Inject
	private ValidationTestHelper helper;
	@Inject
	private ParseHelper<XExpression> parser;
	
	@Test public void testLambdaIssuesEmittedOnce() throws Exception {
		XExpression expr = parser.parse("{ val list = #[] list.filter[it == null] }");
		List<Issue> issues = helper.validate(expr);
		Assert.assertEquals(1, issues.size());
	}
}
