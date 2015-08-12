/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.fragments

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class FragmentsPlainParsingTest extends AbstractFragmentsPlainParsingTest {
	override void setUp() throws Exception {
		super.setUp();
		with(new FragmentTestLanguageStandaloneSetup());
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class FragmentExsPlainParsingTest extends AbstractFragmentsPlainParsingTest {
	override void setUp() throws Exception {
		super.setUp();
		with(new FragmentTestLanguageExStandaloneSetup());
	}
}