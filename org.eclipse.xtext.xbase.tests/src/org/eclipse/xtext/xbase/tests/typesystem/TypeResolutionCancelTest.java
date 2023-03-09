/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeResolutionCancelTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver resolver;

	@Test
	public void testCancelTypeResolution() throws Exception {
		XExpression exp = expression("true");
		try {
			resolver.resolveTypes(exp, () -> true);
			Assert.fail("Type resolution should have been canceled");
		} catch (OperationCanceledError e) {
			// ok, expected
		}
	}

	@Test
	public void testRunTypeResolution() throws Exception {
		XExpression exp = expression("true");
		try {
			resolver.resolveTypes(exp, () -> false);
		} catch (OperationCanceledError e) {
			Assert.fail("Type resolution should not have been canceled");
		}
	}
}
