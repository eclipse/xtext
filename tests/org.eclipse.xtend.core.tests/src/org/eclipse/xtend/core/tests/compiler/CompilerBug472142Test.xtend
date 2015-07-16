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
	
	@Test def test_03() {
		'''
			class C {
				var CharSequence mySeq
				def m() {
					if(mySeq == null) {
						mySeq = (all('s', ''«»'s2'«»'').subList(1,1).head as String).ext
					}
					mySeq
				}
				def java.util.List<CharSequence> all(String s, String s2) {
				}
				def ext(String s) {
					s
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import java.util.List;
			import org.eclipse.xtend2.lib.StringConcatenation;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  private CharSequence mySeq;
			  
			  public CharSequence m() {
			    CharSequence _xblockexpression = null;
			    {
			      boolean _equals = Objects.equal(this.mySeq, null);
			      if (_equals) {
			        StringConcatenation _builder = new StringConcatenation();
			        _builder.append("s2");
			        List<CharSequence> _all = this.all("s", _builder.toString());
			        List<CharSequence> _subList = _all.subList(1, 1);
			        CharSequence _head = IterableExtensions.<CharSequence>head(_subList);
			        String _ext = this.ext(((String) _head));
			        this.mySeq = _ext;
			      }
			      _xblockexpression = this.mySeq;
			    }
			    return _xblockexpression;
			  }
			  
			  public List<CharSequence> all(final String s, final String s2) {
			    return null;
			  }
			  
			  public String ext(final String s) {
			    return s;
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class C {
				var boolean b
				def m() {
					return b = (all('s', ''«»'s2'«»'').subList(1,1).head instanceof String).ext
				}
				def java.util.List<CharSequence> all(String s, String s2) {
				}
				def ext(boolean b) {
					b
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtend2.lib.StringConcatenation;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  private boolean b;
			  
			  public boolean m() {
			    StringConcatenation _builder = new StringConcatenation();
			    _builder.append("s2");
			    List<CharSequence> _all = this.all("s", _builder.toString());
			    List<CharSequence> _subList = _all.subList(1, 1);
			    CharSequence _head = IterableExtensions.<CharSequence>head(_subList);
			    boolean _ext = this.ext((_head instanceof String));
			    return this.b = _ext;
			  }
			  
			  public List<CharSequence> all(final String s, final String s2) {
			    return null;
			  }
			  
			  public boolean ext(final boolean b) {
			    return b;
			  }
			}
		''')
	}
	
}