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
class CompilerBug471631Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def void m() {
					for(Integer i: m2) {}
				}
				def <T> T m2() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    int[] _m2 = this.<int[]>m2();
			    for (final Integer i : _m2) {
			    }
			  }
			  
			  public <T extends Object> T m2() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def void m() {
					for(Integer i: m2) {}
				}
				def <T> Iterable<T> m2() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    Iterable<Integer> _m2 = this.<Integer>m2();
			    for (final Integer i : _m2) {
			    }
			  }
			  
			  public <T extends Object> Iterable<T> m2() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
				def void m() {
					for(C c: m2) {}
				}
				def <T> Iterable<T> m2() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    Iterable<C> _m2 = this.<C>m2();
			    for (final C c : _m2) {
			    }
			  }
			  
			  public <T extends Object> Iterable<T> m2() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class C {
				def void m() {
					for(C c: m2) {}
				}
				def <T> T m2() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    C[] _m2 = this.<C[]>m2();
			    for (final C c : _m2) {
			    }
			  }
			  
			  public <T extends Object> T m2() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def test_05() {
		'''
			class C extends java.util.ArrayList<C> {
				def void m() {
					for(C c: this) {}
				}
				def C m2() {}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			
			@SuppressWarnings("all")
			public class C extends ArrayList<C> {
			  public void m() {
			    for (final C c : this) {
			    }
			  }
			  
			  public C m2() {
			    return null;
			  }
			}
		''')
	}
}