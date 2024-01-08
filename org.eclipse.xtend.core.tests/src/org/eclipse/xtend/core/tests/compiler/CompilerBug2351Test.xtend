/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian - Initial contribution and API
 */
class CompilerBug2351Test extends AbstractXtendCompilerTest {
	
	@Test def void test_01() {
		assertCompilesTo(
			'''
			package p
			
			import java.math.BigDecimal
			
			class C {
				def Object m(int i) {
					val r = switch(i) {
						case 1: 1.0 // double
						case 2: 1.0bd // BigDecimal
						default: weird("")
					}
					return r	
				}
				
				private def <T> T weird(Object object) {
					return null;
				}
			}
			''',
			'''
			package p;
			
			import java.math.BigDecimal;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m(final int i) {
			    Object _switchResult = null;
			    switch (i) {
			      case 1:
			        _switchResult = Double.valueOf(1.0);
			        break;
			      case 2:
			        _switchResult = new BigDecimal("1.0");
			        break;
			      default:
			        _switchResult = this.<Object>weird("");
			        break;
			    }
			    final Object r = _switchResult;
			    return r;
			  }
			
			  private <T extends Object> T weird(final Object object) {
			    return null;
			  }
			}
			'''
		)
	}
	
	@Test def void test_02() {
		assertCompilesTo(
			'''
			package p
			
			import java.math.BigDecimal
			
			class C {
				def void m() {
						val s1 = switch 45 { // int
							case 2: 1
							case 3: 3.0
							case 78: exit('.')
							case 4: 4.0 / 5.0
							default: 6
						}
						val s2 = switch 45 {                       // Number
						        case 78: exit('.')
						        case 2: 1
						        case 3: 3.0
						        case 4: 4.0/5.0
						        default: 6 
						} 
						s1.toString
						s2.toString
					}
				
					def <T> T exit(String message) {
						throw new UnsupportedOperationException(message)
					}
			}
			''',
			'''
			package p;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    Number _switchResult = null;
			    final int _switchValue = 45;
			    switch (_switchValue) {
			      case 2:
			        _switchResult = Integer.valueOf(1);
			        break;
			      case 3:
			        _switchResult = Double.valueOf(3.0);
			        break;
			      case 78:
			        _switchResult = ((Number)this.<Number>exit("."));
			        break;
			      case 4:
			        _switchResult = Double.valueOf((4.0 / 5.0));
			        break;
			      default:
			        _switchResult = Integer.valueOf(6);
			        break;
			    }
			    final Number s1 = ((Number)_switchResult);
			    Number _switchResult_1 = null;
			    final int _switchValue_1 = 45;
			    switch (_switchValue_1) {
			      case 78:
			        _switchResult_1 = ((Number)this.<Number>exit("."));
			        break;
			      case 2:
			        _switchResult_1 = Integer.valueOf(1);
			        break;
			      case 3:
			        _switchResult_1 = Double.valueOf(3.0);
			        break;
			      case 4:
			        _switchResult_1 = Double.valueOf((4.0 / 5.0));
			        break;
			      default:
			        _switchResult_1 = Integer.valueOf(6);
			        break;
			    }
			    final Number s2 = ((Number)_switchResult_1);
			    s1.toString();
			    s2.toString();
			  }
			
			  public <T extends Object> T exit(final String message) {
			    throw new UnsupportedOperationException(message);
			  }
			}
			'''
		)
	}
}