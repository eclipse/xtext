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
	
	@Test def void testBug_427637_01_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.forEach [
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    IterableExtensions.forEach(list, _function);
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
	
	@Test def void testBug_427637_02_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.forEach [
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    IterableExtensions.<V>forEach(list, _function);
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
	
	@Test def void testBug_427637_03_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.forEach [
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			      }
			    };
			    IterableExtensions.forEach(list, _function);
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
	
	@Test def void testBug_427637_04_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    IterableExtensions.forEach(_subList, _function);
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
	
	@Test def void testBug_427637_05_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = new Procedure1<V>() {
			      public void apply(final V it) {
			      }
			    };
			    IterableExtensions.<V>forEach(_subList, _function);
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
	
	@Test def void testBug_427637_06_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			      }
			    };
			    IterableExtensions.forEach(_subList, _function);
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
	
	@Test def void testBug_427637_07_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach [
						it.toString
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
			    IterableExtensions.forEach(_subList, _function);
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
	
	@Test def void testBug_427637_08_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach [
						it.toString
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
			    IterableExtensions.<V>forEach(_subList, _function);
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
	
	@Test def void testBug_427637_09_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach [
						it.toString
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
			    IterableExtensions.forEach(_subList, _function);
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
	
	@Test def void testBug_427637_10_b() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					val List<V> target = null
					list.forEach [
						target += it
					]
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
			    IterableExtensions.forEach(list, _function);
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
	
	@Test def void testBug_427637_12() {
		assertCompilesTo('''
			import java.util.List
			
			class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
				
				Group layer
				
				override onChanged(Change<? extends T> change) {
					while(change.next) {
						if(change.wasAdded)
							change.addedSubList.forEach [ T it | // Xtend bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=427637
								layer.children += it
								it.activate()
							]
						if(change.wasRemoved) 
							change.removed.forEach [ T it | // Xtend bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=427637
								layer.children -= it
							]
					}
				}
			}
			interface ObservableList<E> extends Observable, List<E> {}
			interface Observable {} 
			interface Node {}
			interface Group extends Node {
				def ObservableList<Node> getChildren()
			}
			interface XActivatable {
				def void activate()
			}
			interface ListChangeListener<E> {
				def void onChanged(Change<? extends E> c)
			}
			interface Change<E> {
				def List<E> getAddedSubList()
				def List<E> getRemoved()
				def boolean next()
				def boolean wasAdded()
				def boolean wasRemoved()
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
			  private Group layer;
			  
			  public void onChanged(final Change<? extends T> change) {
			    boolean _next = change.next();
			    boolean _while = _next;
			    while (_while) {
			      {
			        boolean _wasAdded = change.wasAdded();
			        if (_wasAdded) {
			          List<? extends T> _addedSubList = change.getAddedSubList();
			          final Procedure1<T> _function = new Procedure1<T>() {
			            public void apply(final T it) {
			              ObservableList<Node> _children = Listener.this.layer.getChildren();
			              _children.add(it);
			              it.activate();
			            }
			          };
			          IterableExtensions.forEach(_addedSubList, _function);
			        }
			        boolean _wasRemoved = change.wasRemoved();
			        if (_wasRemoved) {
			          List<? extends T> _removed = change.getRemoved();
			          final Procedure1<T> _function_1 = new Procedure1<T>() {
			            public void apply(final T it) {
			              ObservableList<Node> _children = Listener.this.layer.getChildren();
			              _children.remove(it);
			            }
			          };
			          IterableExtensions.forEach(_removed, _function_1);
			        }
			      }
			      boolean _next_1 = change.next();
			      _while = _next_1;
			    }
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_13() {
		assertCompilesTo('''
			import java.util.List
			
			class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
				
				Group layer
				
				override onChanged(Change<? extends T> change) {
					while(change.next) {
						if(change.wasAdded)
							change.addedSubList.forEach [
								layer.children += it
								it.activate()
							]
						if(change.wasRemoved) 
							change.removed.forEach [
								layer.children -= it
							]
					}
				}
			}
			interface ObservableList<E> extends Observable, List<E> {}
			interface Observable {} 
			interface Node {}
			interface Group extends Node {
				def ObservableList<Node> getChildren()
			}
			interface XActivatable {
				def void activate()
			}
			interface ListChangeListener<E> {
				def void onChanged(Change<? extends E> c)
			}
			interface Change<E> {
				def List<E> getAddedSubList()
				def List<E> getRemoved()
				def boolean next()
				def boolean wasAdded()
				def boolean wasRemoved()
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
			  private Group layer;
			  
			  public void onChanged(final Change<? extends T> change) {
			    boolean _next = change.next();
			    boolean _while = _next;
			    while (_while) {
			      {
			        boolean _wasAdded = change.wasAdded();
			        if (_wasAdded) {
			          List<? extends T> _addedSubList = change.getAddedSubList();
			          final Procedure1<T> _function = new Procedure1<T>() {
			            public void apply(final T it) {
			              ObservableList<Node> _children = Listener.this.layer.getChildren();
			              _children.add(it);
			              it.activate();
			            }
			          };
			          IterableExtensions.forEach(_addedSubList, _function);
			        }
			        boolean _wasRemoved = change.wasRemoved();
			        if (_wasRemoved) {
			          List<? extends T> _removed = change.getRemoved();
			          final Procedure1<T> _function_1 = new Procedure1<T>() {
			            public void apply(final T it) {
			              ObservableList<Node> _children = Listener.this.layer.getChildren();
			              _children.remove(it);
			            }
			          };
			          IterableExtensions.forEach(_removed, _function_1);
			        }
			      }
			      boolean _next_1 = change.next();
			      _while = _next_1;
			    }
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_14() {
		assertCompilesTo('''
			import java.util.List
			
			class Listener { // implements ListChangeListener<T> {
				Group layer
				def <T> onChanged(Change<? extends T> change) {
					change.addedSubList.forEach2 [
						layer.children += it
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
			interface ObservableList<E> extends Observable, List<E> {}
			interface Observable {} 
			interface Node {}
			interface Group extends Node {
				def ObservableList<Object> getChildren()
			}
			interface XActivatable {
				def void activate()
			}
			interface ListChangeListener<E> {
				def void onChanged(Change<? extends E> c)
			}
			interface Change<E> {
				def List<E> getAddedSubList()
				def List<E> getRemoved()
				def boolean next()
				def boolean wasAdded()
				def boolean wasRemoved()
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Listener {
			  private Group layer;
			  
			  public <T extends Object> void onChanged(final Change<? extends T> change) {
			    List<? extends T> _addedSubList = change.getAddedSubList();
			    final Procedure1<T> _function = new Procedure1<T>() {
			      public void apply(final T it) {
			        ObservableList<Object> _children = Listener.this.layer.getChildren();
			        _children.add(it);
			      }
			    };
			    this.forEach2(_addedSubList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
}