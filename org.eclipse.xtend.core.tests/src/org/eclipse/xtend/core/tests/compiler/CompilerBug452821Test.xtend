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
class CompilerBug452821Test extends AbstractXtendCompilerTest {
	@Test
	def test_01() {
		assertCompilesTo('''
			class AnonymousClassTest {
			  def test() {
			    new Exception("") {
			      var String field
			    }
			  }
			}
		''', '''
			@SuppressWarnings("all")
			public class AnonymousClassTest {
			  public Exception test() {
			    abstract class __AnonymousClassTest_1 extends Exception {
			      __AnonymousClassTest_1(final String arg0) {
			        super(arg0);
			      }
			
			      String field;
			    }
			
			    return new __AnonymousClassTest_1("") {
			    };
			  }
			}
		''')
	}
	
}