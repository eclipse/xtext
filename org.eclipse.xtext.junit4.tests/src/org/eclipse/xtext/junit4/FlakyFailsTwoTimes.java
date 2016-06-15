/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4;

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