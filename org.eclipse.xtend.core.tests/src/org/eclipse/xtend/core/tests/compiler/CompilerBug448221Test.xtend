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
class CompilerBug448221Test extends AbstractXtendCompilerTest {
	@Test
	def test_01() {
		assertCompilesTo('''
			package sample
			class C {
				var Object[] arr = #[]
				def build() {
					this.arr.m
				}
				def private m(Object... styles) {
					0
				}
				def private m(E e) {
					switch e {
						case E.V: 0
					}
				}
				enum E { V }
			}
		''', '''
			package sample;
			
			@SuppressWarnings("all")
			public class C {
			  public enum E {
			    V;
			  }
			  
			  private Object[] arr = {};
			  
			  public int build() {
			    return this.m(this.arr);
			  }
			  
			  private int m(final Object... styles) {
			    return 0;
			  }
			  
			  private int m(final C.E e) {
			    int _switchResult = (int) 0;
			    if (e != null) {
			      switch (e) {
			        case V:
			          _switchResult = 0;
			          break;
			        default:
			          break;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
}