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
class CompilerBugProtectedVisibilityTest extends AbstractXtendCompilerTest {
	
	@Test def void test_01() {
		assertCompilesTo('''
			class Foo extends test.Visibilities {
				def foo() {
					protectedMethod
				}
			}
		''', '''
			import test.Visibilities;
			
			@SuppressWarnings("all")
			public class Foo extends Visibilities {
			  public void foo() {
			    this.protectedMethod();
			  }
			}
		''')
	}
	
	@Test def void test_02() {
		assertCompilesTo('''
			class Foo extends test.Visibilities {
				def foo() {
					this.protectedMethod
					super.protectedMethod
				}
			}
		''', '''
			import test.Visibilities;
			
			@SuppressWarnings("all")
			public class Foo extends Visibilities {
			  public void foo() {
			    this.protectedMethod();
			    super.protectedMethod();
			  }
			}
		''')
	}
	
	@Test def void test_03() {
		assertCompilesTo('''
			package test 
			class C extends test.Visibilities {
				def m(test.Visibilities s) {
					s.protectedMethod
				}
			}
		''', '''
			package test;
			
			import test.Visibilities;
			
			@SuppressWarnings("all")
			public class C extends Visibilities {
			  public void m(final Visibilities s) {
			    s.protectedMethod();
			  }
			}
		''')
	}
	
	@Test def void test_04() {
		assertCompilesTo('''
			package test 
			class C {
				def m(test.Visibilities s) {
					s.protectedMethod
				}
			}
		''', '''
			package test;
			
			import test.Visibilities;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final Visibilities s) {
			    s.protectedMethod();
			  }
			}
		''')
	}
	
	@Test def void test_05() {
		assertCompilesTo('''
			package test
			class C extends test.Visibilities {
				def m(test.VisibilitiesSubclass vc) { vc.protectedMethod }
			}
		''', '''
			package test;
			
			import test.Visibilities;
			import test.VisibilitiesSubclass;
			
			@SuppressWarnings("all")
			public class C extends Visibilities {
			  public void m(final VisibilitiesSubclass vc) {
			    vc.protectedMethod();
			  }
			}
		''')
	}
	
	@Test def void test_06() {
		assertCompilesTo('''
			package test
			class C extends test.Visibilities {
				def m(test.VisibilitiesSubclass vc) {
					(vc as test.Visibilities).protectedMethod
				}
			}
		''', '''
			package test;
			
			import test.Visibilities;
			import test.VisibilitiesSubclass;
			
			@SuppressWarnings("all")
			public class C extends Visibilities {
			  public void m(final VisibilitiesSubclass vc) {
			    ((Visibilities) vc).protectedMethod();
			  }
			}
		''')
	}
	
	@Test def void test_07() {
		assertCompilesTo('''
			package x
			class C extends test.Visibilities {
				def m(D d) { d.protectedMethod }
			}
			class D extends C {}
		''', '''
			package x;
			
			import test.Visibilities;
			import x.D;
			
			@SuppressWarnings("all")
			public class C extends Visibilities {
			  public void m(final D d) {
			    d.protectedMethod();
			  }
			}
		''')
	}
	
}