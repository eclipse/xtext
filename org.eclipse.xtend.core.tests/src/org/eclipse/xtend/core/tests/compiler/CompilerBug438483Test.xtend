/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug438483Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import static extension TestExt.$
			class TestStdExt {
				def test() {
					val t = $(5,false)
				}
			}
			class TestExt {
				def static $(int a, boolean b) {
					new Pair<Integer, Boolean>(a,b)
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class TestStdExt {
			  public void test() {
			    final Pair<Integer, Boolean> t = TestExt.$(5, false);
			  }
			}
		''')
	}
	
}