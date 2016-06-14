/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug473781Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def void foo() throws AssertionError {
				}
				def void someMethod() {
					foo()
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void foo() throws AssertionError {
			  }
			  
			  public void someMethod() {
			    this.foo();
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def void foo() throws java.io.IOException {
				}
				def void someMethod() {
					foo()
				}
			}
		'''.assertCompilesTo('''
			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public void foo() throws IOException {
			  }
			  
			  public void someMethod() {
			    try {
			      this.foo();
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
				def void foo() throws NullPointerException {
				}
				def void someMethod() {
					foo()
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void foo() throws NullPointerException {
			  }
			  
			  public void someMethod() {
			    this.foo();
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class C {
				def void foo(Throwable t) {
					throw t
				}
				def void someMethod() {
					foo(new Throwable)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public void foo(final Throwable t) {
			    try {
			      throw t;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			  
			  public void someMethod() {
			    Throwable _throwable = new Throwable();
			    this.foo(_throwable);
			  }
			}
		''')
	}
	
	@Test def test_05() {
		'''
			class C {
				def void foo(Throwable t) {
					if (t instanceof Error) {
						throw t
					}
				}
				def void someMethod() {
					foo(new Throwable)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void foo(final Throwable t) {
			    if ((t instanceof Error)) {
			      throw ((Error)t);
			    }
			  }
			  
			  public void someMethod() {
			    Throwable _throwable = new Throwable();
			    this.foo(_throwable);
			  }
			}
		''')
	}
	
}