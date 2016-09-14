/*******************************************************************************
 * Copyright (c) 2016 TypeFox.io (http://www.typefox.io) and others.
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
class CompilerBug491931Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def void foo(boolean a, boolean b) {
					val boolean x1 = !a && !b
					val boolean x2 = a && !b
					val boolean x3 = !a && b
					val boolean x4 = a && b
					println(x1 || x2 || x3 || x4)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class C {
			  public void foo(final boolean a, final boolean b) {
			    final boolean x1 = ((!a) && (!b));
			    final boolean x2 = (a && (!b));
			    final boolean x3 = ((!a) && b);
			    final boolean x4 = (a && b);
			    InputOutput.<Boolean>println(Boolean.valueOf((((x1 || x2) || x3) || x4)));
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def boolean foo(boolean a, boolean b) {
					return a && b
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public boolean foo(final boolean a, final boolean b) {
			    return (a && b);
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
				def boolean foo(boolean a, boolean b) {
					return !a && !b
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public boolean foo(final boolean a, final boolean b) {
			    return ((!a) && (!b));
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class C {
				def boolean m(Object obj) {
					return obj?.toString() instanceof String && obj!==null && obj.getClass()!==null; 
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final Object obj) {
			    boolean _and = false;
			    boolean _and_1 = false;
			    String _string = null;
			    if (obj!=null) {
			      _string=obj.toString();
			    }
			    if (!(_string instanceof String)) {
			      _and_1 = false;
			    } else {
			      _and_1 = (obj != null);
			    }
			    if (!_and_1) {
			      _and = false;
			    } else {
			      Class<?> _class = obj.getClass();
			      boolean _tripleNotEquals = (_class != null);
			      _and = _tripleNotEquals;
			    }
			    return _and;
			  }
			}
		''')
	}
	
	@Test def test_05() {
		'''
			class C {
				def boolean foo(CharSequence obj) {
					return !((obj.subSequence(1, 1) instanceof String) && obj != null)
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean foo(final CharSequence obj) {
			    return (!((obj.subSequence(1, 1) instanceof String) && (!Objects.equal(obj, null))));
			  }
			}
		''')
	}
	
	@Test def test_06() {
		'''
			class C {
				def void foo(java.util.List<String> l) {
					l.add("x") && l.add("y")
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void foo(final List<String> l) {
			    boolean _and = false;
			    boolean _add = l.add("x");
			    if (!_add) {
			      _and = false;
			    } else {
			      boolean _add_1 = l.add("y");
			      _and = _add_1;
			    }
			  }
			}
		''')
	}
	
}