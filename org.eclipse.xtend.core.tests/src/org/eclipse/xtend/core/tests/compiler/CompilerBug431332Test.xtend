/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class CompilerBug431332Test extends AbstractXtendCompilerTest {
	
	@Test
	def testInnerClassRef() {
		assertCompilesTo('''
			class TestOuterClazz {
				val bug = new testclazzes.TestOuterClazz.Nested
			}
		''', '''
			@SuppressWarnings("all")
			public class TestOuterClazz {
			  private final testclazzes.TestOuterClazz.Nested bug = new testclazzes.TestOuterClazz.Nested();
			}
		''')
	}
	
	@Test
	def testInnerClassRef_2() {
		assertCompilesTo('''
			class Clazz {
				val bug = new testclazzes.TestOuterClazz.Nested
			}
		''', '''
			import testclazzes.TestOuterClazz;
			
			@SuppressWarnings("all")
			public class Clazz {
			  private final TestOuterClazz.Nested bug = new TestOuterClazz.Nested();
			}
		''')
	}
	
	
}