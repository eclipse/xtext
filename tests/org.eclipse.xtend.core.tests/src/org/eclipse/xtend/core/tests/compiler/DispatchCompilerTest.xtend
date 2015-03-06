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
			
			@SuppressWarnings("all")
			public class C {
			  protected String _m(@Extension final String s) {
			    return s.substring(4);
			  }
			  
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
			@SuppressWarnings("all")
			public class C {
			  protected void _minus(final Object operand) {
			    throw new RuntimeException();
			  }
			  
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
			@SuppressWarnings("all")
			public class C {
			  protected int _minus(final Object operand) {
			    throw new RuntimeException();
			  }
			  
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
	def testSamePrimitiveArgs() {
		assertCompilesTo('''
			class C {
				def dispatch m(StringBuffer sb, int x) {
					null
				}
				def dispatch m(StringBuilder sb, int x) {
					null
				}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final StringBuffer sb, final int x) {
			    return null;
			  }
			  
			  protected Object _m(final StringBuilder sb, final int x) {
			    return null;
			  }
			  
			  public Object m(final Object sb, final int x) {
			    if (sb instanceof StringBuffer) {
			      return _m((StringBuffer)sb, x);
			    } else if (sb instanceof StringBuilder) {
			      return _m((StringBuilder)sb, x);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(sb, x).toString());
			    }
			  }
			}
		''')
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=365910
	 */
	@Test
	def testDifferentPrimitiveArgs_01() {
		assertCompilesTo('''
			class C {
				def dispatch m(int x) {
					null
				}
				def dispatch m(long x) {
					null
				}
				def dispatch m(float x) {
					null
				}
				def dispatch m(double x) {
					null
				}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final int x) {
			    return null;
			  }
			  
			  protected Object _m(final long x) {
			    return null;
			  }
			  
			  protected Object _m(final float x) {
			    return null;
			  }
			  
			  protected Object _m(final double x) {
			    return null;
			  }
			  
			  public Object m(final Number x) {
			    if (x instanceof Double) {
			      return _m((Double)x);
			    } else if (x instanceof Float) {
			      return _m((Float)x);
			    } else if (x instanceof Integer) {
			      return _m((Integer)x);
			    } else if (x instanceof Long) {
			      return _m((Long)x);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(x).toString());
			    }
			  }
			}
		''')
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=365910
	 */
	@Test
	def testDifferentPrimitiveArgs_02() {
		assertCompilesTo('''
			class C {
				def dispatch m(int x) {
					null
				}
				def dispatch m(char x) {
					null
				}
				def dispatch m(boolean x) {
					null
				}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final int x) {
			    return null;
			  }
			  
			  protected Object _m(final char x) {
			    return null;
			  }
			  
			  protected Object _m(final boolean x) {
			    return null;
			  }
			  
			  public Object m(final Object x) {
			    if (x instanceof Integer) {
			      return _m((Integer)x);
			    } else if (x instanceof Boolean) {
			      return _m((Boolean)x);
			    } else if (x instanceof Character) {
			      return _m((Character)x);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(x).toString());
			    }
			  }
			}
		''')
	}
		
}
