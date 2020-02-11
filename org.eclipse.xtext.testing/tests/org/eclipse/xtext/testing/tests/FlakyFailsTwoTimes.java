/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import org.eclipse.xtext.testing.Flaky;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
public class FlakyFailsTwoTimes {
	@Rule 
	public Flaky.Rule rule = new Flaky.Rule();
	
	static int fails = 2;
	
	@Test
	@Flaky
	public void flakyTest() {
		fails--;
		Assert.assertTrue(fails <= 0);
	}
}
