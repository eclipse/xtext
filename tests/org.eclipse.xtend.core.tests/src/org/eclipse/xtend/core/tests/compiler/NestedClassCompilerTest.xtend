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
class NestedClassCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def void testPlain() {'''
			class C {
				static class X {}
				X x
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class X {
			  }
			  
			  private C.X x;
			}
		''')
	}
	
	@Test
	def void testAbstractNestedClass() {'''
			class C {
				abstract static class X {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static abstract class X {
			  }
			}
		''')
	}
	
	@Test
	def void testGetSuper_01() {'''
			class C {
				def void m2(A a) {
					a.super.m
				}
			}
			class A {
				def B getSuper() {
				}
			}
			class B {
				def void m() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m2(final A a) {
			    B _super = a.getSuper();
			    _super.m();
			  }
			}
		''')
	}
	
	@Test
	def void testGetSuper_02() {'''
			class C {
				def void m2(A it) {
					super.toString
				}
			}
			class A {
				def Object getSuper() {
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m2(final A it) {
			    super.toString();
			  }
			}
		''')
	}
	
	@Test
	def void testOverloads() {'''
			class A {
				static class B {
					def void m(CharSequence c) {
						m('')
					}
				}
				def static void m(String s) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public static class B {
			    public void m(final CharSequence c) {
			      this.m("");
			    }
			  }
			  
			  public static void m(final String s) {
			  }
			}
		''')
	}
	
	@Test
	def void testOverloadsOuterChosen() {'''
			class A {
				static class B {
					def void m(int i) {
						m('')
					}
				}
				def static void m(String s) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public static class B {
			    public void m(final int i) {
			      A.m("");
			    }
			  }
			  
			  public static void m(final String s) {
			  }
			}
		''')
	}
	
	@Test
	def void testDeeplyNested() {'''
			class A {
				static interface B {
					class C {
						A a
						B b
						C c
						D d
						static class D {
							A a
							B b = new A.B {}
							C c = new C
							D d = new B.C.D {}
						}
					}
				}
				A a
				B b = new B {}
				B.C c
				B.C.D d
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public interface B {
			    public static class C {
			      public static class D {
			        private A a;
			        
			        private A.B b = new A.B() {
			        };
			        
			        private A.B.C c = new A.B.C();
			        
			        private A.B.C.D d = new A.B.C.D() {
			        };
			      }
			      
			      private A a;
			      
			      private A.B b;
			      
			      private A.B.C c;
			      
			      private A.B.C.D d;
			    }
			  }
			  
			  private A a;
			  
			  private A.B b = new A.B() {
			  };
			  
			  private A.B.C c;
			  
			  private A.B.C.D d;
			}
		''')
	}
	
	@Test
	def void testDeeplyNestedWithDollarSyntax() {'''
			class A {
				static interface B {
					class C {
						A a
						B b
						C c
						D d
						static class D {
							A a
							B b = new A$B {}
							C c = new C
							D d = new B$C$D {}
						}
					}
				}
				A a
				B b = new B {}
				B$C c = new B$C {}
				B$C$D d = new B$C$D
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public interface B {
			    public static class C {
			      public static class D {
			        private A a;
			        
			        private A.B b = new A.B() {
			        };
			        
			        private A.B.C c = new A.B.C();
			        
			        private A.B.C.D d = new A.B.C.D() {
			        };
			      }
			      
			      private A a;
			      
			      private A.B b;
			      
			      private A.B.C c;
			      
			      private A.B.C.D d;
			    }
			  }
			  
			  private A a;
			  
			  private A.B b = new A.B() {
			  };
			  
			  private A.B.C c = new A.B.C() {
			  };
			  
			  private A.B.C.D d = new A.B.C.D();
			}
		''')
	}
	
	@Test
	def void testOuterMemberAccess() {'''
			class C {
				static class X {
					new(C c) {
						c.m
					}
				}
				private def void m() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class X {
			    public X(final C c) {
			      c.m();
			    }
			  }
			  
			  private void m() {
			  }
			}
		''')
	}
	
	@Test
	def void testSiblingAccess() {'''
			class C {
				static class X {
					new(Y y) {
						y.m
					}
				}
				private static class Y {
					private def void m() {}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class X {
			    public X(final C.Y y) {
			      y.m();
			    }
			  }
			  
			  private static class Y {
			    private void m() {
			    }
			  }
			}
		''')
	}
	
	@Test
	def void testNestedInterface() {'''
			class C {
				interface I {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			  }
			}
		''')
	}
	
	@Test
	def void testNestedEnum() {'''
			class C {
				private static enum E {
					VAL
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  private enum E {
			    VAL;
			  }
			}
		''')
	}
	
	@Test
	def void testNestedAnnotation() {'''
			class C {
				package annotation A {
					String value = ''
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  @interface A {
			    public String value() default "";
			  }
			}
		''')
	}
	
	@Test
	def void testBugNotAnEnclosingInstance_01() {
		'''
			class Account {
			    def Iterable<Boolean> transferAReq(int _amount, Account _account) {
			        return new Iterable<Boolean>() {
			            val dis = this;
			            val depositExceptionHandler = new com.google.common.collect.AbstractIterator<Boolean>() {
			                override Boolean computeNext() {
			                    return false;
			                }
			            };
			            override java.util.Iterator<Boolean> iterator() {
			                send([dis.processAsyncResponse(true)]);
			                null
			            }
			            def void send((Object)=>void p) {}
			            def void processAsyncResponse(boolean o) {}
			        };
			    }
			    def Object depositSReq(int amount) {}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Account {
			  public Iterable<Boolean> transferAReq(final int _amount, final Account _account) {
			    abstract class __Account_1 implements Iterable<Boolean> {
			      final __Account_1 _this__Account_1 = this;
			      
			      __Account_1 dis;
			      
			      AbstractIterator<Boolean> depositExceptionHandler;
			      
			      public abstract void send(final Procedure1<? super Object> p);
			      
			      public abstract void processAsyncResponse(final boolean o);
			    }
			    
			    return new __Account_1() {
			      {
			        dis = this;
			        
			        depositExceptionHandler = new AbstractIterator<Boolean>() {
			          public Boolean computeNext() {
			            return Boolean.valueOf(false);
			          }
			        };
			      }
			      public Iterator<Boolean> iterator() {
			        Object _xblockexpression = null;
			        {
			          final Procedure1<Object> _function = new Procedure1<Object>() {
			            public void apply(final Object it) {
			              _this__Account_1.dis.processAsyncResponse(true);
			            }
			          };
			          this.send(_function);
			          _xblockexpression = null;
			        }
			        return ((Iterator<Boolean>)_xblockexpression);
			      }
			      
			      public void send(final Procedure1<? super Object> p) {
			      }
			      
			      public void processAsyncResponse(final boolean o) {
			      }
			    };
			  }
			  
			  public Object depositSReq(final int amount) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def void testBugNotAnEnclosingInstance_02() {
		'''
			class C {
				def void m1(String s) {}
				def void m2() {
					new Object() {
						def void m1(int i) {}
						def void m2() {
							val I i = [
								m1(1)
								m1('')
							]
						}
					}
				}
				interface I {
					def void m1(int i)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			    public abstract void m1(final int i);
			  }
			  
			  public void m1(final String s) {
			  }
			  
			  public void m2() {
			    abstract class __C_1 {
			      final __C_1 _this__C_1 = this;
			      
			      public abstract void m1(final int i);
			      
			      public abstract void m2();
			    }
			    
			    new __C_1() {
			      public void m1(final int i) {
			      }
			      
			      public void m2() {
			        final C.I _function = new C.I() {
			          public void m1(final int it) {
			            _this__C_1.m1(1);
			            C.this.m1("");
			          }
			        };
			        final C.I i = _function;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testBugNotAnEnclosingInstance_03() {
		'''
			class C {
				def void m1(String s) {}
				def void m2() {
					new Object() {
						def void m1(int i) {}
						def void m2() {
							val I i = new I() {
								override void m1() {
									m1(1)
									m1('')
									m1()
								}
							}
						}
					}
				}
				interface I {
					def void m1()
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			    public abstract void m1();
			  }
			  
			  public void m1(final String s) {
			  }
			  
			  public void m2() {
			    abstract class __C_1 {
			      final __C_1 _this__C_1 = this;
			      
			      public abstract void m1(final int i);
			      
			      public abstract void m2();
			    }
			    
			    new __C_1() {
			      public void m1(final int i) {
			      }
			      
			      public void m2() {
			        final C.I i = new C.I() {
			          public void m1() {
			            _this__C_1.m1(1);
			            C.this.m1("");
			            this.m1();
			          }
			        };
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testBugNotAnEnclosingInstance_04() {
		'''
			class C {
				def void m1(String s) {}
				def void m2() {
					new D() {
						def void m2() {
							val I i = [
								self.m1(1)
								
								m1(1)
								this.m1(1)
								m1('')
								C.this.m1('')
								
								m2()
								this.m2()
								C.this.m2
							]
						}
					}
				}
				interface I {
					def void m1(int i)
				}
				static class D {
					def void m1(int i) {}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			    public abstract void m1(final int i);
			  }
			  
			  public static class D {
			    public void m1(final int i) {
			    }
			  }
			  
			  public void m1(final String s) {
			  }
			  
			  public void m2() {
			    abstract class __C_1 extends C.D {
			      final __C_1 _this__C_1 = this;
			      
			      public abstract void m2();
			    }
			    
			    new __C_1() {
			      public void m2() {
			        final C.I _function = new C.I() {
			          public void m1(final int it) {
			            this.m1(1);
			            _this__C_1.m1(1);
			            _this__C_1.m1(1);
			            C.this.m1("");
			            C.this.m1("");
			            _this__C_1.m2();
			            _this__C_1.m2();
			            C.this.m2();
			          }
			        };
			        final C.I i = _function;
			      }
			    };
			  }
			}
		''')
	}
}
