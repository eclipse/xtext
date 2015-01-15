/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug427637Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_427637_01() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final Procedure1<V> _function = (V it) -> {
			    };
			    this.forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_01_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.forEach [
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final Consumer<V> _function = (V it) -> {
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_02() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    final Procedure1<V> _function = (V it) -> {
			    };
			    this.<V>forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_02_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.forEach [
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    final Consumer<V> _function = (V it) -> {
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_03() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    final Procedure1<Object> _function = (Object it) -> {
			    };
			    this.forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Ignore /* TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=457539 */
	@Test def void testBug_427637_03_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.forEach [
					]
				}
			}
		'''.assertCompilesTo('''

		''')
	}
	
	@Test def void testBug_427637_04() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = (V it) -> {
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_04_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Consumer<V> _function = (V it) -> {
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_05() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = (V it) -> {
			    };
			    this.<V>forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_05_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Consumer<V> _function = (V it) -> {
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_06() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach2 [
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Procedure1<Object> _function = (Object it) -> {
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Ignore /* TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=457539 */
	@Test def void testBug_427637_06_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		'''.assertCompilesTo('''

		''')
	}
	
	@Test def void testBug_427637_07() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach2 [
						it.toString
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = (V it) -> {
			      it.toString();
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_07_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					list.subList(1,1).forEach [
						it.toString
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    List<? extends V> _subList = list.subList(1, 1);
			    final Consumer<V> _function = (V it) -> {
			      it.toString();
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_08() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach2 [
						it.toString
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Procedure1<V> _function = (V it) -> {
			      it.toString();
			    };
			    this.<V>forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_08_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<V> list) {
					list.subList(1,1).forEach [
						it.toString
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<V> list) {
			    List<V> _subList = list.subList(1, 1);
			    final Consumer<V> _function = (V it) -> {
			      it.toString();
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_09() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach2 [
						it.toString
					]
				}
				def <T> void forEach2(Iterable<T> iterable, (T)=>void procedure) {}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Procedure1<Object> _function = (Object it) -> {
			      it.toString();
			    };
			    this.forEach2(_subList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Ignore /* TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=457539 */
	@Test def void testBug_427637_09_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach [
						it.toString
					]
				}
			}
		'''.assertCompilesTo('''

		''')
	}
	
	@Test def void testBug_427637_10() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final List<V> target = null;
			    final Procedure1<V> _function = (V it) -> {
			      target.add(it);
			    };
			    this.forEach2(list, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_10_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? extends V> list) {
					val List<V> target = null
					list.forEach [
						target += it
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? extends V> list) {
			    final List<V> target = null;
			    final Consumer<V> _function = (V it) -> {
			      target.add(it);
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_11() {
		'''
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
		'''.assertCompilesTo('''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> void m(final List<? extends T> list) {
			    final List<T> target = null;
			    List<? extends T> _subList = list.subList(0, 1);
			    final Consumer<T> _function = (T it) -> {
			      List<T> _subList_1 = target.subList(0, 1);
			      _subList_1.add(it);
			      List<T> _subList_2 = target.subList(0, 1);
			      _subList_2.remove(it);
			      List<T> _subList_3 = target.subList(0, 1);
			      ArrayList<T> _newArrayList = CollectionLiterals.<T>newArrayList(it);
			      Iterables.<T>addAll(_subList_3, _newArrayList);
			      List<T> _subList_4 = target.subList(0, 1);
			      ArrayList<T> _newArrayList_1 = CollectionLiterals.<T>newArrayList(it);
			      Iterables.removeAll(_subList_4, _newArrayList_1);
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_12() {
		'''
			import java.util.List
			
			class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
				
				Group layer
				
				override onChanged(Change<? extends T> change) {
					while(change.next) {
						if(change.wasAdded)
							change.addedSubList.forEach [ T it |
								layer.children += it
								it.activate()
							]
						if(change.wasRemoved) 
							change.removed.forEach [ T it |
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
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
			  private Group layer;
			  
			  @Override
			  public void onChanged(final Change<? extends T> change) {
			    while (change.next()) {
			      {
			        boolean _wasAdded = change.wasAdded();
			        if (_wasAdded) {
			          List<? extends T> _addedSubList = change.getAddedSubList();
			          final Consumer<T> _function = (T it) -> {
			            ObservableList<Node> _children = this.layer.getChildren();
			            _children.add(it);
			            it.activate();
			          };
			          _addedSubList.forEach(_function);
			        }
			        boolean _wasRemoved = change.wasRemoved();
			        if (_wasRemoved) {
			          List<? extends T> _removed = change.getRemoved();
			          final Consumer<T> _function_1 = (T it) -> {
			            ObservableList<Node> _children = this.layer.getChildren();
			            _children.remove(it);
			          };
			          _removed.forEach(_function_1);
			        }
			      }
			    }
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_13() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class Listener<T extends Node & XActivatable> implements ListChangeListener<T> {
			  private Group layer;
			  
			  @Override
			  public void onChanged(final Change<? extends T> change) {
			    while (change.next()) {
			      {
			        boolean _wasAdded = change.wasAdded();
			        if (_wasAdded) {
			          List<? extends T> _addedSubList = change.getAddedSubList();
			          final Consumer<T> _function = (T it) -> {
			            ObservableList<Node> _children = this.layer.getChildren();
			            _children.add(it);
			            it.activate();
			          };
			          _addedSubList.forEach(_function);
			        }
			        boolean _wasRemoved = change.wasRemoved();
			        if (_wasRemoved) {
			          List<? extends T> _removed = change.getRemoved();
			          final Consumer<T> _function_1 = (T it) -> {
			            ObservableList<Node> _children = this.layer.getChildren();
			            _children.remove(it);
			          };
			          _removed.forEach(_function_1);
			        }
			      }
			    }
			  }
			}
		''')
	}
	
	@Test def void testBug_427637_14() {
		'''
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
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Listener {
			  private Group layer;
			  
			  public <T extends Object> void onChanged(final Change<? extends T> change) {
			    List<? extends T> _addedSubList = change.getAddedSubList();
			    final Procedure1<T> _function = (T it) -> {
			      ObservableList<Object> _children = this.layer.getChildren();
			      _children.add(it);
			    };
			    this.forEach2(_addedSubList, _function);
			  }
			  
			  public <T extends Object> void forEach2(final Iterable<T> iterable, final Procedure1<? super T> procedure) {
			  }
			}
		''')
	}
		
}