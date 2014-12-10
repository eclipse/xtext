/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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