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
class AutocastCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def testSwitch_01() {
		assertCompilesTo('''
			class C {
				def void m(Object o) {
					switch(o) {
						String: n(o)
					}
				}
				def void n(CharSequence s) {
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final Object o) {
			    boolean _matched = false;
			    if (o instanceof String) {
			      _matched=true;
			      this.n(((CharSequence)o));
			    }
			  }
			  
			  public void n(final CharSequence s) {
			  }
			}
		''')
	}
	
	@Test
	def testSwitch_02() {
		assertCompilesTo('''
			class C {
				def void m() {
					switch Object o: new Object {
						String: n(o)
					}
				}
				def void n(CharSequence s) {
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    Object _object = new Object();
			    final Object o = _object;
			    boolean _matched = false;
			    if (o instanceof String) {
			      _matched=true;
			      this.n(((CharSequence)o));
			    }
			  }
			  
			  public void n(final CharSequence s) {
			  }
			}
		''')
	}
	
	@Test
	def testIf_01() {
		assertCompilesTo('''
			class C {
				def void m(Object o) {
					if (o instanceof String) {
						n(o)
					}
				}
				def void n(CharSequence s) {
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final Object o) {
			    if ((o instanceof String)) {
			      this.n(((CharSequence)o));
			    }
			  }
			  
			  public void n(final CharSequence s) {
			  }
			}
		''')
	}
	
	@Test
	def testField_01() {
		assertCompilesTo('''
			class C {
				val Object o = null
				def void m() {
					if (o instanceof String) {
						n(o)
					}
				}
				def void n(CharSequence s) {
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private final Object o = null;
			  
			  public void m() {
			    if ((this.o instanceof String)) {
			      this.n(((CharSequence)this.o));
			    }
			  }
			  
			  public void n(final CharSequence s) {
			  }
			}
		''')
	}
	
	@Test
	def testField_02() {
		assertCompilesTo('''
			class C {
				val Object o = null
				def void m() {
					if (C.this.o instanceof String) {
						n(this.o)
					}
				}
				def void n(CharSequence s) {
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private final Object o = null;
			  
			  public void m() {
			    if ((this.o instanceof String)) {
			      this.n(((CharSequence)this.o));
			    }
			  }
			  
			  public void n(final CharSequence s) {
			  }
			}
		''')
	}
}