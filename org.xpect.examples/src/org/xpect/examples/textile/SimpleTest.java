/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.examples.textile;

import org.junit.runner.RunWith;
import org.xpect.parameters.CommaSeparatedValuesExpectation;
import org.xpect.parameters.ICommaSeparatedValuesExpectation;
import org.xpect.parameters.IStringExpectation;
import org.xpect.parameters.StringExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectTestFiles;

import com.google.common.collect.Lists;

@RunWith(XpectRunner.class)
@XpectTestFiles(fileExtensions = "textile")
public class SimpleTest {

	@Xpect
	public void simple() {
		System.out.println("Hello World");
	}

	@Xpect
	public void simpleString(@StringExpectation IStringExpectation expectation) {
		System.out.println("simpleString");
		expectation.assertEquals("Foo Bar");
	}

	@Xpect
	public void simpleCSV(
			@CommaSeparatedValuesExpectation ICommaSeparatedValuesExpectation expectation) {
		System.out.println("simpleString");
		expectation.assertEquals(Lists.newArrayList("aa", "bb", "cc"));
	}

}
