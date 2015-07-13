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
class CompilerBug472142Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def boolean m(CharSequence obj) {
					return obj?.subSequence(1,1) instanceof String && obj!==null && obj.getClass()!==null;
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final CharSequence obj) {
			    boolean _and = false;
			    boolean _and_1 = false;
			    CharSequence _subSequence = null;
			    if (obj!=null) {
			      _subSequence=obj.subSequence(1, 1);
			    }
			    if (!(_subSequence instanceof String)) {
			      _and_1 = false;
			    } else {
			      _and_1 = (obj != null);
			    }
			    if (!_and_1) {
			      _and = false;
			    } else {
			      Class<? extends CharSequence> _class = obj.getClass();
			      boolean _tripleNotEquals = (_class != null);
			      _and = _tripleNotEquals;
			    }
			    return _and;
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def boolean m(CharSequence obj) {
					return obj?.subSequence(1,1) instanceof String && obj!==null
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final CharSequence obj) {
			    boolean _and = false;
			    CharSequence _subSequence = null;
			    if (obj!=null) {
			      _subSequence=obj.subSequence(1, 1);
			    }
			    if (!(_subSequence instanceof String)) {
			      _and = false;
			    } else {
			      _and = (obj != null);
			    }
			    return _and;
			  }
			}
		''')
	}
	
}