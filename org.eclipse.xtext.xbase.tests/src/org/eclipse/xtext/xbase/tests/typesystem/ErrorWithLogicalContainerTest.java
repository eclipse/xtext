/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(XbaseWithLogicalContainerInjectorProvider.class)
public class ErrorWithLogicalContainerTest extends AbstractXbaseTestCase {
	@Inject
	private Oven oven;

	@Test
	public void testErrorModel_01() throws Exception {
		oven.fireproof("return s");
	}

	@Test
	public void testErrorModel_02() throws Exception {
		oven.fireproof("retus.toUpperCase");
	}
}
