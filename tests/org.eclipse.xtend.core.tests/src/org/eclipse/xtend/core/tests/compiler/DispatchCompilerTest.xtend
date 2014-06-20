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
 * @author Sven Efftinge - Initial contribution and API
 */
class DispatchCompilerTest extends AbstractXtendCompilerTest {
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=410329
	 */
	@Test
	def testExtensionParameters() {
		assertCompilesTo('''
			class C {
				def dispatch m(extension String s) {
					4.substring
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected String _m(@Extension final String s) {
			    return s.substring(4);
			  }
			  
			  @Synthetic
			  public String m(final String s) {
			    return _m(s);
			  }
			}
		''')
	}
	
	@Test
	def testThrowExceptionSingleDispatchCase_01() {
		assertCompilesTo('''
			class C {
				def dispatch minus(Object operand) {
					throw new RuntimeException();
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected void _minus(final Object operand) {
			    throw new RuntimeException();
			  }
			  
			  @Synthetic
			  public void minus(final Object operand) {
			    _minus(operand);
			    return;
			  }
			}
		''')
	}
	
	@Test
	def testThrowExceptionSingleDispatchCase_02() {
		assertCompilesTo('''
			class C {
				def dispatch int minus(Object operand) {
					throw new RuntimeException();
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected int _minus(final Object operand) {
			    throw new RuntimeException();
			  }
			  
			  @Synthetic
			  public int minus(final Object operand) {
			    return _minus(operand);
			  }
			}
		''')
	}
	
	@Test
	def testThrowException() {
		assertCompilesTo('''
			class C {
				def dispatch minus(Object operand) {
					if (true)
						throw new RuntimeException();
					throw new RuntimeException();
				}
				def dispatch minus(Integer e) { -e }
				def dispatch minus(Double e) { -e }
			}
		''', '''
			import java.util.Arrays;
			import org.eclipse.xtext.xbase.lib.DoubleExtensions;
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected double _minus(final Object operand) {
			    if (true) {
			      throw new RuntimeException();
			    }
			    throw new RuntimeException();
			  }
			  
			  protected double _minus(final Integer e) {
			    return (-(e).intValue());
			  }
			  
			  protected double _minus(final Double e) {
			    return DoubleExtensions.operator_minus(e);
			  }
			  
			  @Synthetic
			  public double minus(final Object e) {
			    if (e instanceof Double) {
			      return _minus((Double)e);
			    } else if (e instanceof Integer) {
			      return _minus((Integer)e);
			    } else if (e != null) {
			      return _minus(e);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(e).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def testAllCasesThrowException() {
		assertCompilesTo('''
			class C {
				def dispatch minus(Object operand) {
					throw new RuntimeException();
				}
				def dispatch minus(Integer e) {
					throw new RuntimeException();
				}
				def dispatch minus(Double e) {
					throw new RuntimeException();
				}
			}
		''', '''
			import java.util.Arrays;
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected void _minus(final Object operand) {
			    throw new RuntimeException();
			  }
			  
			  protected void _minus(final Integer e) {
			    throw new RuntimeException();
			  }
			  
			  protected void _minus(final Double e) {
			    throw new RuntimeException();
			  }
			  
			  @Synthetic
			  public void minus(final Object e) {
			    if (e instanceof Double) {
			      _minus((Double)e);
			      return;
			    } else if (e instanceof Integer) {
			      _minus((Integer)e);
			      return;
			    } else if (e != null) {
			      _minus(e);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(e).toString());
			    }
			  }
			}
		''')
	}

	@Test
	def testImplicitReturn_01() {
		assertCompilesTo('''
			class C {
				def dispatch minus(Object operand) {
					wait()
				}
				def dispatch minus(Integer e) { -e }
				def dispatch minus(Double e) { -e }
			}
		''', '''
			import java.util.Arrays;
			import org.eclipse.xtext.xbase.lib.DoubleExtensions;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected Number _minus(final Object operand) {
			    try {
			      this.wait();
			      return null;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			  
			  protected Number _minus(final Integer e) {
			    return Integer.valueOf((-(e).intValue()));
			  }
			  
			  protected Number _minus(final Double e) {
			    return Double.valueOf(DoubleExtensions.operator_minus(e));
			  }
			  
			  @Synthetic
			  public Number minus(final Object e) {
			    if (e instanceof Double) {
			      return _minus((Double)e);
			    } else if (e instanceof Integer) {
			      return _minus((Integer)e);
			    } else if (e != null) {
			      return _minus(e);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(e).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def testImplicitReturn_02() {
		assertCompilesTo('''
			class C {
				def dispatch minus(Object operand) {
					wait()
				}
				def dispatch minus(Integer e) { return -e }
				def dispatch minus(Double e) { -e }
			}
		''', '''
			import java.util.Arrays;
			import org.eclipse.xtext.xbase.lib.DoubleExtensions;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Synthetic;
			
			@SuppressWarnings("all")
			public class C {
			  protected Number _minus(final Object operand) {
			    try {
			      this.wait();
			      return null;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			  
			  protected Number _minus(final Integer e) {
			    return Integer.valueOf((-(e).intValue()));
			  }
			  
			  protected Number _minus(final Double e) {
			    return Double.valueOf(DoubleExtensions.operator_minus(e));
			  }
			  
			  @Synthetic
			  public Number minus(final Object e) {
			    if (e instanceof Double) {
			      return _minus((Double)e);
			    } else if (e instanceof Integer) {
			      return _minus((Integer)e);
			    } else if (e != null) {
			      return _minus(e);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(e).toString());
			    }
			  }
			}
		''')
	}
		
}
