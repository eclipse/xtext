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
 * @author Miro Spoenemann - Initial contribution and API
 */
class CompilerBug457350Test extends AbstractXtendCompilerTest {
	
	@Test def testBug457350_01() {
		'''
			class Test {
				def void test() {
					val Runnable r1 = [
						new Runnable {
							override run() {
								self.run
								this.run
							}
						}
					]
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public void test() {
			    final Runnable _function = new Runnable() {
			      final Runnable _self = this;
			      public void run() {
			        new Runnable() {
			          public void run() {
			            _self.run();
			            this.run();
			          }
			        };
			      }
			    };
			    final Runnable r1 = _function;
			  }
			}
		''')
	}
	
	@Test def testBug457350_02() {
		'''
			class Test {
				def void test() {
					[val Runnable r1 = [
						new Runnable {
							override run() {
								self.run
								this.run
							}
						}
					]].apply(null)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public void test() {
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			        final Runnable _function = new Runnable() {
			          final Runnable _self = this;
			          public void run() {
			            new Runnable() {
			              public void run() {
			                _self.run();
			                this.run();
			              }
			            };
			          }
			        };
			        final Runnable r1 = _function;
			      }
			    };
			    _function.apply(null);
			  }
			}
		''')
	}
	
	@Test def testBug457350_03() {
		'''
			class Test {
				def void test() {
					new Runnable {
						override run() {
							val Runnable r1 = [
								self.run
								this.run
							]
						}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public void test() {
			    new Runnable() {
			      final Runnable _this = this;
			      public void run() {
			        final Runnable _function = new Runnable() {
			          public void run() {
			            this.run();
			            _this.run();
			          }
			        };
			        final Runnable r1 = _function;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test def testBug457350_04() {
		'''
			class Test {
				def void test() {
					new Runnable {
						override run() {
							val Runnable r1 = [
								self.run
								this.run
							]
						}
						def blub() {}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public void test() {
			    abstract class __Test_1 implements Runnable {
			      final __Test_1 _this__Test_1 = this;
			      
			      public abstract Object blub();
			    }
			    
			    new __Test_1() {
			      public void run() {
			        final Runnable _function = new Runnable() {
			          public void run() {
			            this.run();
			            _this__Test_1.run();
			          }
			        };
			        final Runnable r1 = _function;
			      }
			      
			      public Object blub() {
			        return null;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test def testBug457350_05() {
		'''
			class Test {
				def void test() {
					[new Runnable {
						override run() {
							val Runnable r1 = [
								self.run
								this.run
							]
						}
					}].apply(null)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Test {
			  public void test() {
			    final Function1<Object, Runnable> _function = new Function1<Object, Runnable>() {
			      public Runnable apply(final Object it) {
			        return new Runnable() {
			          final Runnable _this = this;
			          public void run() {
			            final Runnable _function = new Runnable() {
			              public void run() {
			                this.run();
			                _this.run();
			              }
			            };
			            final Runnable r1 = _function;
			          }
			        };
			      }
			    };
			    _function.apply(null);
			  }
			}
		''')
	}
	
	@Test def testBug457350_06() {
		'''
			class Test extends SuperFoo {
				def void test() {
					val Runnable r1 = [
						new Runnable {
							override run() {
								Test.super.bar
							}
						}
					]
				}
			}
			class SuperFoo {
				def void bar() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test extends SuperFoo {
			  public void test() {
			    final Runnable _function = new Runnable() {
			      public void run() {
			        new Runnable() {
			          public void run() {
			            Test.super.bar();
			          }
			        };
			      }
			    };
			    final Runnable r1 = _function;
			  }
			}
		''')
	}
	
}