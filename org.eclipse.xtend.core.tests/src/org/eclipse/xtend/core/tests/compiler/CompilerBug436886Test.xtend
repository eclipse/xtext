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
class CompilerBug436886Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class Test {
				new((Super)=>boolean lambda) {}
				def method() {
					new Test [   
						// Type mismatch: cannot convert from (Super & I)=>boolean to (Super)=>boolean
						switch it {
							Foo: true
							Bar: true
							default: false
						}
					]
				}
			}
			interface I {}
			class Super {}
			class Foo extends Super implements I {}
			class Bar extends Super implements I {}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Test {
			  public Test(final Function1<? super Super, ? extends Boolean> lambda) {
			  }
			  
			  public Test method() {
			    final Function1<Super, Boolean> _function = new Function1<Super, Boolean>() {
			      public Boolean apply(final Super it) {
			        boolean _switchResult = false;
			        boolean _matched = false;
			        if (it instanceof Foo) {
			          _matched=true;
			          _switchResult = true;
			        }
			        if (!_matched) {
			          if (it instanceof Bar) {
			            _matched=true;
			            _switchResult = true;
			          }
			        }
			        if (!_matched) {
			          _switchResult = false;
			        }
			        return Boolean.valueOf(_switchResult);
			      }
			    };
			    return new Test(_function);
			  }
			}
		''')
	}
	
}