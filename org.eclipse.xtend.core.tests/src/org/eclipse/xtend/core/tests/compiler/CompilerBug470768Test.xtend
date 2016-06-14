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
class CompilerBug470768Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class SOE {
				def dispatch getList(A it) {
					new CustomItr().toList;
				}
				def dispatch getList(Object it) {
					emptyList;
				}
				static class A {}
				static class CustomItr implements Iterable<A> {
					override iterator() {
						throw new UnsupportedOperationException()
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Arrays;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class SOE {
			  public static class A {
			  }
			  
			  public static class CustomItr implements Iterable<SOE.A> {
			    public Iterator<SOE.A> iterator() {
			      throw new UnsupportedOperationException();
			    }
			  }
			  
			  protected List<SOE.A> _getList(final SOE.A it) {
			    SOE.CustomItr _customItr = new SOE.CustomItr();
			    return IterableExtensions.<SOE.A>toList(_customItr);
			  }
			  
			  protected List<SOE.A> _getList(final Object it) {
			    return CollectionLiterals.<SOE.A>emptyList();
			  }
			  
			  public List<SOE.A> getList(final Object it) {
			    if (it instanceof SOE.A) {
			      return _getList((SOE.A)it);
			    } else if (it != null) {
			      return _getList(it);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(it).toString());
			    }
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def dispatch getList(C it) {
					new CustomItr().toList;
				}
				def dispatch getList(Object it) {
					<C>emptyList
				}
				static class CustomItr implements Iterable<C> {
					override iterator() {
						null
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Arrays;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public static class CustomItr implements Iterable<C> {
			    public Iterator<C> iterator() {
			      return null;
			    }
			  }
			  
			  protected List<C> _getList(final C it) {
			    C.CustomItr _customItr = new C.CustomItr();
			    return IterableExtensions.<C>toList(_customItr);
			  }
			  
			  protected List<C> _getList(final Object it) {
			    return CollectionLiterals.<C>emptyList();
			  }
			  
			  public List<C> getList(final Object it) {
			    if (it instanceof C) {
			      return _getList((C)it);
			    } else if (it != null) {
			      return _getList(it);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(it).toString());
			    }
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class SOE {
				def dispatch getList(Object it) {
					emptyList
				}
				def dispatch getList(A it) {
					new CustomItr().<A>toList;
				}
				
				static class A {}
				static class CustomItr implements Iterable<A> {
					override iterator() {
						null
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Arrays;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class SOE {
			  public static class A {
			  }
			  
			  public static class CustomItr implements Iterable<SOE.A> {
			    public Iterator<SOE.A> iterator() {
			      return null;
			    }
			  }
			  
			  protected List<SOE.A> _getList(final Object it) {
			    return CollectionLiterals.<SOE.A>emptyList();
			  }
			  
			  protected List<SOE.A> _getList(final SOE.A it) {
			    SOE.CustomItr _customItr = new SOE.CustomItr();
			    return IterableExtensions.<SOE.A>toList(_customItr);
			  }
			  
			  public List<SOE.A> getList(final Object it) {
			    if (it instanceof SOE.A) {
			      return _getList((SOE.A)it);
			    } else if (it != null) {
			      return _getList(it);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(it).toString());
			    }
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class SOE {
				def dispatch getList(A it) {
					new CustomItr().<A>toList;
				}
				def dispatch getList(Object it) {
					emptyList
				}
				static class A {}
				static class CustomItr implements Iterable<A> {
					override iterator() {
						null
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Arrays;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class SOE {
			  public static class A {
			  }
			  
			  public static class CustomItr implements Iterable<SOE.A> {
			    public Iterator<SOE.A> iterator() {
			      return null;
			    }
			  }
			  
			  protected List<SOE.A> _getList(final SOE.A it) {
			    SOE.CustomItr _customItr = new SOE.CustomItr();
			    return IterableExtensions.<SOE.A>toList(_customItr);
			  }
			  
			  protected List<SOE.A> _getList(final Object it) {
			    return CollectionLiterals.<SOE.A>emptyList();
			  }
			  
			  public List<SOE.A> getList(final Object it) {
			    if (it instanceof SOE.A) {
			      return _getList((SOE.A)it);
			    } else if (it != null) {
			      return _getList(it);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(it).toString());
			    }
			  }
			}
		''')
	}
	
	
}