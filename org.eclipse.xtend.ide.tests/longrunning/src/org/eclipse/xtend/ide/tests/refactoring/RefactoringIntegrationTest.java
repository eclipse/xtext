/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class RefactoringIntegrationTest extends AbstractXtendRenameRefactoringTest {

	@Test public void testRenameVariable() throws Exception {
		performRenameTest("Foo", "class Foo { def foo() { val bar = 7; bar + 1 }}", "bar", "baz");
	}

	@Test public void testRenameParameter() throws Exception {
		performRenameTest("Foo", "class Foo { def foo(int bar) { bar + 1 }}", "bar", "baz");
	}

	@Test public void testRenameTypeParameter() throws Exception {
		// Test with broken model
		performRenameTest("Foo", "class Foo <T> { def T foo() null }", "T", "U");
	}
	
	@Test public void testRenameTypeParameter2() throws Exception {
		performRenameTest("Foo", "class Foo <T> { def T foo() {null} }", "T", "U");
	}

	@Test public void testRenameSwitchVar() throws Exception {
		performRenameTest("Foo", "class Foo { " +
				"def foo() {\n" +
				"   val Object bar = ''\n" + 
				"   switch(bar) {\n" + 
				"      String: bar.length\n" +
				"      Object: bar.hashCode\n" +
				"      default: bar.hashCode\n" + 
				"   }" +
				"}", "bar", "baz");
	}
	
	@Test public void testRenameMethod() throws Exception {
		performRenameTestWithReferringFile("Foo", "Foo", "class Foo { def Integer foo() { foo(); 1 }}", "Bar",
				"class Baz { def baz(Foo arg) {arg.foo()} }", "foo", "bar");
	}

	@Test public void testRenameClass() throws Exception {
		performRenameTestWithReferringFile("Foo", "Bar", "class Foo { def Foo foo() {this} }", "Baz", "class Baz { def Foo foo() {new Foo()} }", "Foo",
				"Bar");
	}
}