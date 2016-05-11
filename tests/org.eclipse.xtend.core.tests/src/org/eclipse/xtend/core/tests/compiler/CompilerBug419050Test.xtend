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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug419050Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def boolean m(boolean b) { 
					if (b) { 
						return true 
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final boolean b) {
			    if (b) {
			      return true;
			    }
			    return false;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def boolean m1(boolean x) {
					while(x) {
						return true
					}
				}
				def m2(boolean x) {
				  while(x) {
				    return true
				  }
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m1(final boolean x) {
			    while (x) {
			      return true;
			    }
			    return false;
			  }
			  
			  public Boolean m2(final boolean x) {
			    while (x) {
			      return Boolean.valueOf(true);
			    }
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def boolean m(Object o) { 
					switch o { 
						String: return true 
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final Object o) {
			    boolean _matched = false;
			    if (o instanceof String) {
			      _matched=true;
			      return true;
			    }
			    return false;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def boolean m(Object o) { 
					try {
						return true;
					} finally {
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final Object o) {
			    try {
			      return true;
			    } finally {
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				def m(boolean b) { 
					if (b) { 
						while(b) {}
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final boolean b) {
			    if (b) {
			      while (b) {
			      }
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			class C {
				def m(boolean b) { 
					var boolean y = if (b) return true
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Boolean m(final boolean b) {
			    boolean _xifexpression = false;
			    if (b) {
			      return Boolean.valueOf(true);
			    }
			    boolean y = _xifexpression;
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			class C {
				def m(boolean b) { 
					val boolean x = if (b) true
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final boolean b) {
			    boolean _xifexpression = false;
			    if (b) {
			      _xifexpression = true;
			    }
			    final boolean x = _xifexpression;
			  }
			}
		''')
	}
	
	@Test
	def test_08() {
		assertCompilesTo('''
			class C {
				def m(boolean b) { 
					while(true) return false
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Boolean m(final boolean b) {
			    while (true) {
			      return Boolean.valueOf(false);
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_09() {
		assertCompilesTo('''
			class C {
				def boolean m(boolean b) { 
					while(true) return false
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final boolean b) {
			    while (true) {
			      return false;
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_10() {
		assertCompilesTo('''
			class C {
				def boolean m(boolean b) { 
					val func = [String s|while(true) return false]
					while(true) 
						return func.apply("foo")
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final boolean b) {
			    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
			      public Boolean apply(final String s) {
			        while (true) {
			          return Boolean.valueOf(false);
			        }
			      }
			    };
			    final Function1<String, Boolean> func = _function;
			    while (true) {
			      return (func.apply("foo")).booleanValue();
			    }
			  }
			}
		''')
	}

	@Test
	def test_11() {
		assertCompilesTo('''
			class C {
				def boolean m(boolean b) {
					val com.google.common.base.Predicate<String> func = [while(true) return false]
					while(true) 
						return func.apply("foo")
				}
			}
		''', '''
			import com.google.common.base.Predicate;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final boolean b) {
			    final Predicate<String> _function = new Predicate<String>() {
			      public boolean apply(final String it) {
			        while (true) {
			          return false;
			        }
			      }
			    };
			    final Predicate<String> func = _function;
			    while (true) {
			      return func.apply("foo");
			    }
			  }
			}
		''')
	}
	
	@Test
	def testBug417371_01() {
		assertCompilesTo('''
			class C {
				def m(Iterable<String> iter) {
					iter.filter [
						if (length < 2) {
							return true
						} else if (length > 2) {
							return false
						}
					] 
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<String> m(final Iterable<String> iter) {
			    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
			      public Boolean apply(final String it) {
			        int _length = it.length();
			        boolean _lessThan = (_length < 2);
			        if (_lessThan) {
			          return Boolean.valueOf(true);
			        } else {
			          int _length_1 = it.length();
			          boolean _greaterThan = (_length_1 > 2);
			          if (_greaterThan) {
			            return Boolean.valueOf(false);
			          }
			        }
			        return null;
			      }
			    };
			    return IterableExtensions.<String>filter(iter, _function);
			  }
			}
		''')
	}
	
}