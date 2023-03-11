/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
			
			@SuppressWarnings("all")
			public class C extends Visibilities {
			  public void m(final D d) {
			    d.protectedMethod();
			  }
			}
		''')
	}
	
	@Test def test472662_01() {
		'''
			class B {
				C c = new C()
				
				protected def doX(Runnable r) {
					doX [
						c.protectedMethod
					]
				}
			}
			class C {
				protected def void protectedMethod() {
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B {
			  private C c = new C();
			
			  protected Object doX(final Runnable r) {
			    final Runnable _function = new Runnable() {
			      public void run() {
			        B.this.c.protectedMethod();
			      }
			    };
			    return this.doX(_function);
			  }
			}
		''')
	}
	
	@Test def test472662_02() {
		'''
			class B {
				C c = new C()
				protected def doX(Runnable r) {
					doX (new Runnable() {
						override run() {
							c.protectedMethod
						}
					})
				}
			}
			class C {
				protected def void protectedMethod() {
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B {
			  private C c = new C();
			
			  protected Object doX(final Runnable r) {
			    return this.doX(new Runnable() {
			      public void run() {
			        B.this.c.protectedMethod();
			      }
			    });
			  }
			}
		''')
	}
	
	@Test def void testExtrasIssue229_01() {
		'''
		class Sample {
			static class ParamClass extends testdata.ClazzWithProtectedMember {
				def doSomething(ParamClass c) {
					c.member = "Hello"
				}
			}
		}
		'''.assertCompilesTo('''
		import testdata.ClazzWithProtectedMember;
		
		@SuppressWarnings("all")
		public class Sample {
		  public static class ParamClass extends ClazzWithProtectedMember {
		    public String doSomething(final Sample.ParamClass c) {
		      return c.member = "Hello";
		    }
		  }
		}
		''')
	}	
	
	@Test def void testExtrasIssue229_02() {
		'''
		class Sample extends testdata.ClazzWithProtectedMember {
			static class ParamClass {
				def doSomething(Sample c) {
					c.member = "Hello"
				}
			}
		}
		'''.assertCompilesTo('''
		import testdata.ClazzWithProtectedMember;
		
		@SuppressWarnings("all")
		public class Sample extends ClazzWithProtectedMember {
		  public static class ParamClass {
		    public String doSomething(final Sample c) {
		      return c.member = "Hello";
		    }
		  }
		}
		''')
		
	}
}