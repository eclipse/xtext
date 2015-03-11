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
class CompilerBug381162Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def m() {
					m(''«»'foo'«»'')
				}
				def m(String ... x) {}
			}
		''', '''
			import org.eclipse.xtend2.lib.StringConcatenation;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    StringConcatenation _builder = new StringConcatenation();
			    _builder.append("foo");
			    return this.m(_builder.toString());
			  }
			  
			  public Object m(final String... x) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m() {
					m(''«»'a'«»'', ''«»'b'«»'')
				}
				def m(String ... x) {}
			}
		''', '''
			import org.eclipse.xtend2.lib.StringConcatenation;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    StringConcatenation _builder = new StringConcatenation();
			    _builder.append("a");
			    StringConcatenation _builder_1 = new StringConcatenation();
			    _builder_1.append("b");
			    return this.m(_builder.toString(), _builder_1.toString());
			  }
			  
			  public Object m(final String... x) {
			    return null;
			  }
			}
		''')
	}
	
}