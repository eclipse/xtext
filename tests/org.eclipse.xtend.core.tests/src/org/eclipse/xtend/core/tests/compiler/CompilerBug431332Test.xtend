/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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