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
class CompilerBug440196Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def bug() {
					if (Boolean.TRUE) return false;
				}
				def invoke() {
					val boolean b = bug
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean bug() {
			    if ((Boolean.TRUE).booleanValue()) {
			      return false;
			    }
			    return false;
			  }
			  
			  public void invoke() {
			    final boolean b = this.bug();
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m() {
					[| if (Boolean.TRUE) return true ].apply
				}
				def invoke() {
					val boolean b = m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C {
			  public Boolean m() {
			    final Function0<Boolean> _function = new Function0<Boolean>() {
			      public Boolean apply() {
			        if ((Boolean.TRUE).booleanValue()) {
			          return true;
			        }
			        return null;
			      }
			    };
			    return _function.apply();
			  }
			  
			  public void invoke() {
			    final boolean b = (this.m()).booleanValue();
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def bug() {
					if (Boolean.TRUE) return Boolean::FALSE;
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Boolean bug() {
			    if ((Boolean.TRUE).booleanValue()) {
			      return Boolean.FALSE;
			    }
			    return null;
			  }
			}
		''')
	}

	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def void bug() {
					if (Boolean.TRUE) return;
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void bug() {
			    if ((Boolean.TRUE).booleanValue()) {
			      return;
			    }
			  }
			}
		''')
	}

	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				def boolean bug() {
					val b = true
					while (b) return true;
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean bug() {
			    final boolean b = true;
			    while (b) {
			      return true;
			    }
			  }
			}
		''')
	}

	@Test
	def test_06() {
		assertCompilesTo('''
			class C {
				def boolean bug() {
					for (;;) return true;
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean bug() {
			    for (;;) {
			      return true;
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			class C {
				def boolean bug() {
					val b = true
					for (;b;) return true;
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean bug() {
			    final boolean b = true;
			    for (; b;) {
			      return true;
			    }
			  }
			}
		''')
	}
}