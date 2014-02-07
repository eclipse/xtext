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
class CompilerBug427637Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_427637_01() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    this.forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_02() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    this.<V>forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_03() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			      }
			    };
			    this.forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_04() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_05() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    this.<V>forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_06() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			      }
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_07() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach2 [
						it.toString
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			        it.toString();
			      }
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_08() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach2 [
						it.toString
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			        it.toString();
			      }
			    };
			    this.<V>forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_09() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach2 [
						it.toString
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			        it.toString();
			      }
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_10() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					val List<V> target = null
					list.forEach2 [
						target += it
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final List<V> target = null;
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			        target.add(it);
			      }
			    };
			    this.forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_11() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <T> m(List<? extends T> list) {
					val List<T> target = null
					list.subList(0,1).forEach [
						target.subList(0, 1) += it
						target.subList(0, 1) -= it
						target.subList(0, 1) += newArrayList(it)
						target.subList(0, 1) -= newArrayList(it)
					]
				}
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> void m(final List<? extends T> list) {
			    final List<T> target = null;
			    List<? extends T> _subList = list.subList(0, 1);
			    final Procedure1<T> _function = new Procedure1<T>() {
			      public void apply(final T it) {
			        List<T> _subList = target.subList(0, 1);
			        _subList.add(it);
			        List<T> _subList_1 = target.subList(0, 1);
			        _subList_1.remove(it);
			        List<T> _subList_2 = target.subList(0, 1);
			        ArrayList<T> _newArrayList = CollectionLiterals.<T>newArrayList(it);
			        Iterables.<T>addAll(_subList_2, _newArrayList);
			        List<T> _subList_3 = target.subList(0, 1);
			        ArrayList<T> _newArrayList_1 = CollectionLiterals.<T>newArrayList(it);
			        Iterables.removeAll(_subList_3, _newArrayList_1);
			      }
			    };
			    IterableExtensions.forEach(_subList, _function);
			  }
			}
		''')
	}
	
}