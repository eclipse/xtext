/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug427637Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug427637Test {
	
	@Test override void testBug_427637_01() {
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
	
	@Test override void testBug_427637_01_b() {
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
	
	@Test override void testBug_427637_02() {
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
	
	@Test override void testBug_427637_02_b() {
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
	
	@Test override void testBug_427637_03() {
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
	
	@Test override void testBug_427637_03_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.forEach [
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    final Consumer<Object> _function = (Object it) -> {
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override void testBug_427637_04() {
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
	
	@Test override void testBug_427637_04_b() {
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
	
	@Test override void testBug_427637_05() {
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
	
	@Test override void testBug_427637_05_b() {
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
	
	@Test override void testBug_427637_06() {
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
	
	@Test override void testBug_427637_06_b() {
		'''
			import java.util.List
			
			class C {
				def <V> m(List<? super V> list) {
					list.subList(1,1).forEach [
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Consumer<Object> _function = (Object it) -> {
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override void testBug_427637_07() {
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
	
	@Test override void testBug_427637_07_b() {
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
	
	@Test override void testBug_427637_08() {
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
	
	@Test override void testBug_427637_08_b() {
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
	
	@Test override void testBug_427637_09() {
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
	
	@Test override void testBug_427637_09_b() {
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
			import java.util.List;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public <V extends Object> void m(final List<? super V> list) {
			    List<? super V> _subList = list.subList(1, 1);
			    final Consumer<Object> _function = (Object it) -> {
			      it.toString();
			    };
			    _subList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override void testBug_427637_10() {
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
	
	@Test override void testBug_427637_10_b() {
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
	
	@Test override void testBug_427637_11() {
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
	
	@Test override void testBug_427637_12() {
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
	
	@Test override void testBug_427637_13() {
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
	
	@Test override void testBug_427637_14() {
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

	@Test override void testBug_427637_15() {
		assertCompilesTo('''
			package org.eclipse.xtext.xbase.formatting
			
			import com.google.inject.Inject
			import org.eclipse.xtext.nodemodel.INode
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper
			
			import static org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys.*
			import org.eclipse.xtext.preferences.PreferenceKey
			
			class FormattingDataFactory {
			
				@Inject extension HiddenLeafAccess
			
				def protected (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
					HiddenLeafs leafs,
					(FormattingDataInit)=>void init
				) {
					val data = new FormattingDataInit()
					init.apply(data)
					newFormattingData(leafs, data.key, data)
				}
			
				def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(HiddenLeafs leafs,
					Void key, FormattingDataInit it) {
					[ FormattableDocument doc |
						val int newLines2 = newLines ?: 0
						if ((space == null && newLines == null) || (leafs.newLinesInComments == 0 && (newLines2 == 0 || space == "")))
							return newWhitespaceData(leafs, space, increaseIndentationChange, decreaseIndentationChange, doc.debugConflicts)
						else
							return newNewLineData(leafs, newLines2, newLines2, increaseIndentationChange, decreaseIndentationChange, doc.debugConflicts)
					]
				}
			
				def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
					HiddenLeafs leafs,
					BlankLineKey key,
					FormattingDataInit it
				) {
					[ FormattableDocument doc |
						val blankline = doc.cfg.get(key)
						val preserve = doc.cfg.get(preserveBlankLines)
						val min = blankline + 1
						val max = Math.max(preserve + 1, min)
						newNewLineData(leafs, min, max, increaseIndentationChange, decreaseIndentationChange, doc.debugConflicts)
					]
				}
			
				def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
					HiddenLeafs leafs,
					NewLineOrPreserveKey key,
					FormattingDataInit it
				) {
					[ FormattableDocument doc |
						val newLine = doc.cfg.get(key)
						val preserve = doc.cfg.get(preserveNewLines)
						newNewLineData(leafs, if (newLine) 1 else 0, if (preserve || newLine) 1 else 0, increaseIndentationChange, decreaseIndentationChange,
							doc.debugConflicts)
					]
				}
			
				def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
					HiddenLeafs leafs,
					NewLineKey key,
					FormattingDataInit it
				) {
					[ FormattableDocument doc |
						val newLine = doc.cfg.get(key)
						val minmax = if (newLine) 1 else 0
						newNewLineData(leafs, minmax, minmax, increaseIndentationChange, decreaseIndentationChange, doc.debugConflicts)
					]
				}
			
				def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(
					HiddenLeafs leafs,
					PreferenceKey key,
					FormattingDataInit it
				) {
					throw new RuntimeException("Unknown configuration key kind: " + key.^class)
				}
			
				def protected dispatch (FormattableDocument)=>Iterable<FormattingData> newFormattingData(HiddenLeafs leafs,
					WhitespaceKey key, FormattingDataInit it) {
					[ FormattableDocument doc |
						val space = doc.cfg.get(key)
						newWhitespaceData(leafs, if (space) " " else "", increaseIndentationChange, decreaseIndentationChange, doc.debugConflicts)
					]
				}
			
				def protected Iterable<FormattingData> newWhitespaceData(
					HiddenLeafs leafs,
					String space,
					int increaseIndentationChange,
					int decreaseIndentationChange,
					boolean trace
				) {
					val result = <FormattingData>newArrayList
					var isFirst = true
					for (leaf : leafs.leafs)
						switch leaf {
							WhitespaceInfo: {
								result += new WhitespaceData(leaf.offset, leaf.length, if(isFirst) increaseIndentationChange else 0, if(isFirst) decreaseIndentationChange else 0,
									if (trace) new RuntimeException, space)
								isFirst = false
							}
							CommentInfo: {
							}
						}
					result
				}
			
				def protected Iterable<FormattingData> newNewLineData(
					HiddenLeafs leafs,
					int minNewLines,
					int maxNewLines,
					int increaseIndentationChange,
					int decreaseIndentationChange,
					boolean trace
				) {
					val result = <FormattingData>newArrayList
					var applied = false
					for (leaf : leafs.leafs)
						switch leaf {
							WhitespaceInfo: {
								val equalIndentationChange = increaseIndentationChange == decreaseIndentationChange * -1
								if (leaf.trailingComment?.trailing && !leaf.trailingComment?.multiline) {
									val space = if (leaf.offset == 0) "" else if(maxNewLines == 0) null else " "
									result += new WhitespaceData(leaf.offset, leaf.length, 0 , 0, if (trace) new RuntimeException(), space)
								} else if (!applied) {
									var newLines = Math.min(Math.max(leafs.newLines, minNewLines), maxNewLines)
									if (newLines < 1 && leaf.offset > 0 &&
										(leaf.leadingComment?.multiline || leaf.trailingComment?.multiline))
										newLines = 1
									if (leaf.leadingComment?.endsWithNewLine)
										newLines = newLines - 1
									if (!leaf.leadingComment?.endsWithNewLine && newLines == 0)
										result += new WhitespaceData(leaf.offset, leaf.length, increaseIndentationChange, decreaseIndentationChange,
											if (trace) new RuntimeException(), if (leaf.offset == 0) "" else if(leafs.containsComment) null else " ")
									else
										if(equalIndentationChange && leafs.leafs.last != leaf)
											result += new NewLineData(leaf.offset, leaf.length, increaseIndentationChange, decreaseIndentationChange, if (trace) new RuntimeException(), newLines)
										else
											result += new NewLineData(leaf.offset, leaf.length, if(equalIndentationChange) 0  else increaseIndentationChange, if(equalIndentationChange) 0 else decreaseIndentationChange, if (trace) new RuntimeException(), newLines)
									applied = true
								} else {
									var newLines = 1
									if (leaf.leadingComment?.endsWithNewLine)
										newLines = newLines - 1
									if(equalIndentationChange && leafs.leafs.last != leaf)
										result += new NewLineData(leaf.offset, leaf.length, increaseIndentationChange, decreaseIndentationChange, if (trace) new RuntimeException(), newLines)
									else
										result += new NewLineData(leaf.offset, leaf.length, 0, 0, if (trace) new RuntimeException(), newLines)
								}
							}
							CommentInfo: {
							}
						}
					result
				}
			
				def (FormattableDocument)=>Iterable<FormattingData> append(
					INode node,
					(FormattingDataInit)=>void init
				) {
					if (node != null) {
						node.hiddenLeafsAfter.newFormattingData(init)
					}
				}
			
				def (FormattableDocument)=>Iterable<FormattingData> prepend(
					INode node,
					(FormattingDataInit)=>void init
				) {
					if (node != null) {
						node.hiddenLeafsBefore.newFormattingData(init)
					}
				}
			
				def (FormattableDocument)=>Iterable<FormattingData> surround(
					INode node,
					(FormattingDataInit)=>void init
				) {
					[ FormattableDocument doc |
						val result = <FormattingData>newArrayList()
						if (node != null) {
							result += node.hiddenLeafsBefore.newFormattingData(init)?.apply(doc) ?: emptyList
							result += node.hiddenLeafsAfter.newFormattingData(init)?.apply(doc) ?: emptyList
						}
						result
					]
				}
			
				def (FormattableDocument)=>Iterable<FormattingData> surround(
					INode node,
					(FormattingDataInit)=>void before,
					(FormattingDataInit)=>void after
				) {
					[ FormattableDocument doc |
						val result = <FormattingData>newArrayList()
						if (node != null) {
							result += node.hiddenLeafsBefore.newFormattingData(before)?.apply(doc) ?: emptyList
							result += node.hiddenLeafsAfter.newFormattingData(after)?.apply(doc) ?: emptyList
						}
						result
					]
				}
				
				static class FormattingDataInit {
					public String space = null
					public Integer newLines = null
					public int increaseIndentationChange = 0
					public int decreaseIndentationChange = 0
					public PreferenceKey key = null
				
					def void cfg(PreferenceKey key) {
						this.key = key
					}
				
					def void newLine() {
						newLines = 1
					}
				
					def void noSpace() {
						space = ""
					}
				
					def void oneSpace() {
						space = " "
					}
				
					def void increaseIndentation() {
						increaseIndentationChange = increaseIndentationChange + 1
					}
				
					def void decreaseIndentation() {
						decreaseIndentationChange = decreaseIndentationChange - 1
					}
				
					override String toString() {
						new ToStringHelper().toString(this)
					}
				}
			}
		''', '''
			package org.eclipse.xtext.xbase.formatting;
			
			import com.google.common.base.Objects;
			import com.google.common.collect.Iterables;
			import com.google.inject.Inject;
			import java.util.ArrayList;
			import java.util.Arrays;
			import java.util.List;
			import org.eclipse.xtext.nodemodel.INode;
			import org.eclipse.xtext.preferences.PreferenceKey;
			import org.eclipse.xtext.xbase.formatting.BlankLineKey;
			import org.eclipse.xtext.xbase.formatting.CommentInfo;
			import org.eclipse.xtext.xbase.formatting.FormattableDocument;
			import org.eclipse.xtext.xbase.formatting.FormattingData;
			import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
			import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess;
			import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
			import org.eclipse.xtext.xbase.formatting.LeafInfo;
			import org.eclipse.xtext.xbase.formatting.NewLineData;
			import org.eclipse.xtext.xbase.formatting.NewLineKey;
			import org.eclipse.xtext.xbase.formatting.NewLineOrPreserveKey;
			import org.eclipse.xtext.xbase.formatting.WhitespaceData;
			import org.eclipse.xtext.xbase.formatting.WhitespaceInfo;
			import org.eclipse.xtext.xbase.formatting.WhitespaceKey;
			import org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Extension;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@SuppressWarnings("all")
			public class FormattingDataFactory {
			  public static class FormattingDataInit {
			    public String space = null;
			    
			    public Integer newLines = null;
			    
			    public int increaseIndentationChange = 0;
			    
			    public int decreaseIndentationChange = 0;
			    
			    public PreferenceKey key = null;
			    
			    public void cfg(final PreferenceKey key) {
			      this.key = key;
			    }
			    
			    public void newLine() {
			      this.newLines = Integer.valueOf(1);
			    }
			    
			    public void noSpace() {
			      this.space = "";
			    }
			    
			    public void oneSpace() {
			      this.space = " ";
			    }
			    
			    public void increaseIndentation() {
			      this.increaseIndentationChange = (this.increaseIndentationChange + 1);
			    }
			    
			    public void decreaseIndentation() {
			      this.decreaseIndentationChange = (this.decreaseIndentationChange - 1);
			    }
			    
			    @Override
			    public String toString() {
			      ToStringHelper _toStringHelper = new ToStringHelper();
			      return _toStringHelper.toString(this);
			    }
			  }
			  
			  @Inject
			  @Extension
			  private HiddenLeafAccess _hiddenLeafAccess;
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> newFormattingData(final HiddenLeafs leafs, final Procedure1<? super FormattingDataFactory.FormattingDataInit> init) {
			    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _xblockexpression = null;
			    {
			      final FormattingDataFactory.FormattingDataInit data = new FormattingDataFactory.FormattingDataInit();
			      init.apply(data);
			      _xblockexpression = this.newFormattingData(leafs, data.key, data);
			    }
			    return _xblockexpression;
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final Void key, final FormattingDataFactory.FormattingDataInit it) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      Integer _elvis = null;
			      if (it.newLines != null) {
			        _elvis = it.newLines;
			      } else {
			        _elvis = Integer.valueOf(0);
			      }
			      final int newLines2 = (int) _elvis;
			      boolean _or = false;
			      boolean _and = false;
			      boolean _equals = Objects.equal(it.space, null);
			      if (!_equals) {
			        _and = false;
			      } else {
			        boolean _equals_1 = Objects.equal(it.newLines, null);
			        _and = _equals_1;
			      }
			      if (_and) {
			        _or = true;
			      } else {
			        boolean _and_1 = false;
			        int _newLinesInComments = leafs.getNewLinesInComments();
			        boolean _equals_2 = (_newLinesInComments == 0);
			        if (!_equals_2) {
			          _and_1 = false;
			        } else {
			          boolean _or_1 = false;
			          if ((newLines2 == 0)) {
			            _or_1 = true;
			          } else {
			            boolean _equals_3 = Objects.equal(it.space, "");
			            _or_1 = _equals_3;
			          }
			          _and_1 = _or_1;
			        }
			        _or = _and_1;
			      }
			      if (_or) {
			        boolean _isDebugConflicts = doc.isDebugConflicts();
			        return this.newWhitespaceData(leafs, it.space, it.increaseIndentationChange, it.decreaseIndentationChange, _isDebugConflicts);
			      } else {
			        boolean _isDebugConflicts_1 = doc.isDebugConflicts();
			        return this.newNewLineData(leafs, newLines2, newLines2, it.increaseIndentationChange, it.decreaseIndentationChange, _isDebugConflicts_1);
			      }
			    };
			    return _function;
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final BlankLineKey key, final FormattingDataFactory.FormattingDataInit it) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      Iterable<FormattingData> _xblockexpression = null;
			      {
			        FormattingPreferenceValues _cfg = doc.getCfg();
			        final int blankline = _cfg.get(key);
			        FormattingPreferenceValues _cfg_1 = doc.getCfg();
			        final int preserve = _cfg_1.get(XbaseFormatterPreferenceKeys.preserveBlankLines);
			        final int min = (blankline + 1);
			        final int max = Math.max((preserve + 1), min);
			        boolean _isDebugConflicts = doc.isDebugConflicts();
			        _xblockexpression = this.newNewLineData(leafs, min, max, it.increaseIndentationChange, it.decreaseIndentationChange, _isDebugConflicts);
			      }
			      return _xblockexpression;
			    };
			    return _function;
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final NewLineOrPreserveKey key, final FormattingDataFactory.FormattingDataInit it) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      Iterable<FormattingData> _xblockexpression = null;
			      {
			        FormattingPreferenceValues _cfg = doc.getCfg();
			        final boolean newLine = _cfg.get(key);
			        FormattingPreferenceValues _cfg_1 = doc.getCfg();
			        final boolean preserve = _cfg_1.get(XbaseFormatterPreferenceKeys.preserveNewLines);
			        int _xifexpression = (int) 0;
			        if (newLine) {
			          _xifexpression = 1;
			        } else {
			          _xifexpression = 0;
			        }
			        int _xifexpression_1 = (int) 0;
			        boolean _or = false;
			        if (preserve) {
			          _or = true;
			        } else {
			          _or = newLine;
			        }
			        if (_or) {
			          _xifexpression_1 = 1;
			        } else {
			          _xifexpression_1 = 0;
			        }
			        boolean _isDebugConflicts = doc.isDebugConflicts();
			        _xblockexpression = this.newNewLineData(leafs, _xifexpression, _xifexpression_1, it.increaseIndentationChange, it.decreaseIndentationChange, _isDebugConflicts);
			      }
			      return _xblockexpression;
			    };
			    return _function;
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final NewLineKey key, final FormattingDataFactory.FormattingDataInit it) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      Iterable<FormattingData> _xblockexpression = null;
			      {
			        FormattingPreferenceValues _cfg = doc.getCfg();
			        final boolean newLine = _cfg.get(key);
			        int _xifexpression = (int) 0;
			        if (newLine) {
			          _xifexpression = 1;
			        } else {
			          _xifexpression = 0;
			        }
			        final int minmax = _xifexpression;
			        boolean _isDebugConflicts = doc.isDebugConflicts();
			        _xblockexpression = this.newNewLineData(leafs, minmax, minmax, it.increaseIndentationChange, it.decreaseIndentationChange, _isDebugConflicts);
			      }
			      return _xblockexpression;
			    };
			    return _function;
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final PreferenceKey key, final FormattingDataFactory.FormattingDataInit it) {
			    Class<? extends PreferenceKey> _class = key.getClass();
			    String _plus = ("Unknown configuration key kind: " + _class);
			    throw new RuntimeException(_plus);
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData(final HiddenLeafs leafs, final WhitespaceKey key, final FormattingDataFactory.FormattingDataInit it) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      Iterable<FormattingData> _xblockexpression = null;
			      {
			        FormattingPreferenceValues _cfg = doc.getCfg();
			        final boolean space = _cfg.get(key);
			        String _xifexpression = null;
			        if (space) {
			          _xifexpression = " ";
			        } else {
			          _xifexpression = "";
			        }
			        boolean _isDebugConflicts = doc.isDebugConflicts();
			        _xblockexpression = this.newWhitespaceData(leafs, _xifexpression, it.increaseIndentationChange, it.decreaseIndentationChange, _isDebugConflicts);
			      }
			      return _xblockexpression;
			    };
			    return _function;
			  }
			  
			  protected Iterable<FormattingData> newWhitespaceData(final HiddenLeafs leafs, final String space, final int increaseIndentationChange, final int decreaseIndentationChange, final boolean trace) {
			    ArrayList<FormattingData> _xblockexpression = null;
			    {
			      final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
			      boolean isFirst = true;
			      List<LeafInfo> _leafs = leafs.getLeafs();
			      for (final LeafInfo leaf : _leafs) {
			        boolean _matched = false;
			        if (leaf instanceof WhitespaceInfo) {
			          _matched=true;
			          int _offset = ((WhitespaceInfo)leaf).getOffset();
			          int _length = ((WhitespaceInfo)leaf).getLength();
			          int _xifexpression = (int) 0;
			          if (isFirst) {
			            _xifexpression = increaseIndentationChange;
			          } else {
			            _xifexpression = 0;
			          }
			          int _xifexpression_1 = (int) 0;
			          if (isFirst) {
			            _xifexpression_1 = decreaseIndentationChange;
			          } else {
			            _xifexpression_1 = 0;
			          }
			          RuntimeException _xifexpression_2 = null;
			          if (trace) {
			            _xifexpression_2 = new RuntimeException();
			          }
			          WhitespaceData _whitespaceData = new WhitespaceData(_offset, _length, _xifexpression, _xifexpression_1, _xifexpression_2, space);
			          result.add(_whitespaceData);
			          isFirst = false;
			        }
			        if (!_matched) {
			          if (leaf instanceof CommentInfo) {
			            _matched=true;
			          }
			        }
			      }
			      _xblockexpression = result;
			    }
			    return _xblockexpression;
			  }
			  
			  protected Iterable<FormattingData> newNewLineData(final HiddenLeafs leafs, final int minNewLines, final int maxNewLines, final int increaseIndentationChange, final int decreaseIndentationChange, final boolean trace) {
			    ArrayList<FormattingData> _xblockexpression = null;
			    {
			      final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
			      boolean applied = false;
			      List<LeafInfo> _leafs = leafs.getLeafs();
			      for (final LeafInfo leaf : _leafs) {
			        boolean _matched = false;
			        if (leaf instanceof WhitespaceInfo) {
			          _matched=true;
			          final boolean equalIndentationChange = (increaseIndentationChange == (decreaseIndentationChange * (-1)));
			          boolean _and = false;
			          CommentInfo _trailingComment = ((WhitespaceInfo)leaf).trailingComment();
			          boolean _isTrailing = false;
			          if (_trailingComment!=null) {
			            _isTrailing=_trailingComment.isTrailing();
			          }
			          if (!_isTrailing) {
			            _and = false;
			          } else {
			            CommentInfo _trailingComment_1 = ((WhitespaceInfo)leaf).trailingComment();
			            boolean _isMultiline = false;
			            if (_trailingComment_1!=null) {
			              _isMultiline=_trailingComment_1.isMultiline();
			            }
			            boolean _not = (!_isMultiline);
			            _and = _not;
			          }
			          if (_and) {
			            String _xifexpression = null;
			            int _offset = ((WhitespaceInfo)leaf).getOffset();
			            boolean _equals = (_offset == 0);
			            if (_equals) {
			              _xifexpression = "";
			            } else {
			              String _xifexpression_1 = null;
			              if ((maxNewLines == 0)) {
			                _xifexpression_1 = null;
			              } else {
			                _xifexpression_1 = " ";
			              }
			              _xifexpression = _xifexpression_1;
			            }
			            final String space = _xifexpression;
			            int _offset_1 = ((WhitespaceInfo)leaf).getOffset();
			            int _length = ((WhitespaceInfo)leaf).getLength();
			            RuntimeException _xifexpression_2 = null;
			            if (trace) {
			              _xifexpression_2 = new RuntimeException();
			            }
			            WhitespaceData _whitespaceData = new WhitespaceData(_offset_1, _length, 0, 0, _xifexpression_2, space);
			            result.add(_whitespaceData);
			          } else {
			            if ((!applied)) {
			              int _newLines = leafs.getNewLines();
			              int _max = Math.max(_newLines, minNewLines);
			              int newLines = Math.min(_max, maxNewLines);
			              boolean _and_1 = false;
			              boolean _and_2 = false;
			              if (!(newLines < 1)) {
			                _and_2 = false;
			              } else {
			                int _offset_2 = ((WhitespaceInfo)leaf).getOffset();
			                boolean _greaterThan = (_offset_2 > 0);
			                _and_2 = _greaterThan;
			              }
			              if (!_and_2) {
			                _and_1 = false;
			              } else {
			                boolean _or = false;
			                CommentInfo _leadingComment = ((WhitespaceInfo)leaf).leadingComment();
			                boolean _isMultiline_1 = false;
			                if (_leadingComment!=null) {
			                  _isMultiline_1=_leadingComment.isMultiline();
			                }
			                if (_isMultiline_1) {
			                  _or = true;
			                } else {
			                  CommentInfo _trailingComment_2 = ((WhitespaceInfo)leaf).trailingComment();
			                  boolean _isMultiline_2 = false;
			                  if (_trailingComment_2!=null) {
			                    _isMultiline_2=_trailingComment_2.isMultiline();
			                  }
			                  _or = _isMultiline_2;
			                }
			                _and_1 = _or;
			              }
			              if (_and_1) {
			                newLines = 1;
			              }
			              CommentInfo _leadingComment_1 = ((WhitespaceInfo)leaf).leadingComment();
			              boolean _endsWithNewLine = false;
			              if (_leadingComment_1!=null) {
			                _endsWithNewLine=_leadingComment_1.endsWithNewLine();
			              }
			              if (_endsWithNewLine) {
			                newLines = (newLines - 1);
			              }
			              boolean _and_3 = false;
			              CommentInfo _leadingComment_2 = ((WhitespaceInfo)leaf).leadingComment();
			              boolean _endsWithNewLine_1 = false;
			              if (_leadingComment_2!=null) {
			                _endsWithNewLine_1=_leadingComment_2.endsWithNewLine();
			              }
			              boolean _not_1 = (!_endsWithNewLine_1);
			              if (!_not_1) {
			                _and_3 = false;
			              } else {
			                _and_3 = (newLines == 0);
			              }
			              if (_and_3) {
			                int _offset_3 = ((WhitespaceInfo)leaf).getOffset();
			                int _length_1 = ((WhitespaceInfo)leaf).getLength();
			                RuntimeException _xifexpression_3 = null;
			                if (trace) {
			                  _xifexpression_3 = new RuntimeException();
			                }
			                String _xifexpression_4 = null;
			                int _offset_4 = ((WhitespaceInfo)leaf).getOffset();
			                boolean _equals_1 = (_offset_4 == 0);
			                if (_equals_1) {
			                  _xifexpression_4 = "";
			                } else {
			                  String _xifexpression_5 = null;
			                  boolean _containsComment = leafs.containsComment();
			                  if (_containsComment) {
			                    _xifexpression_5 = null;
			                  } else {
			                    _xifexpression_5 = " ";
			                  }
			                  _xifexpression_4 = _xifexpression_5;
			                }
			                WhitespaceData _whitespaceData_1 = new WhitespaceData(_offset_3, _length_1, increaseIndentationChange, decreaseIndentationChange, _xifexpression_3, _xifexpression_4);
			                result.add(_whitespaceData_1);
			              } else {
			                boolean _and_4 = false;
			                if (!equalIndentationChange) {
			                  _and_4 = false;
			                } else {
			                  List<LeafInfo> _leafs_1 = leafs.getLeafs();
			                  LeafInfo _last = IterableExtensions.<LeafInfo>last(_leafs_1);
			                  boolean _notEquals = (!Objects.equal(_last, leaf));
			                  _and_4 = _notEquals;
			                }
			                if (_and_4) {
			                  int _offset_5 = ((WhitespaceInfo)leaf).getOffset();
			                  int _length_2 = ((WhitespaceInfo)leaf).getLength();
			                  RuntimeException _xifexpression_6 = null;
			                  if (trace) {
			                    _xifexpression_6 = new RuntimeException();
			                  }
			                  NewLineData _newLineData = new NewLineData(_offset_5, _length_2, increaseIndentationChange, decreaseIndentationChange, _xifexpression_6, Integer.valueOf(newLines));
			                  result.add(_newLineData);
			                } else {
			                  int _offset_6 = ((WhitespaceInfo)leaf).getOffset();
			                  int _length_3 = ((WhitespaceInfo)leaf).getLength();
			                  int _xifexpression_7 = (int) 0;
			                  if (equalIndentationChange) {
			                    _xifexpression_7 = 0;
			                  } else {
			                    _xifexpression_7 = increaseIndentationChange;
			                  }
			                  int _xifexpression_8 = (int) 0;
			                  if (equalIndentationChange) {
			                    _xifexpression_8 = 0;
			                  } else {
			                    _xifexpression_8 = decreaseIndentationChange;
			                  }
			                  RuntimeException _xifexpression_9 = null;
			                  if (trace) {
			                    _xifexpression_9 = new RuntimeException();
			                  }
			                  NewLineData _newLineData_1 = new NewLineData(_offset_6, _length_3, _xifexpression_7, _xifexpression_8, _xifexpression_9, Integer.valueOf(newLines));
			                  result.add(_newLineData_1);
			                }
			              }
			              applied = true;
			            } else {
			              int newLines_1 = 1;
			              CommentInfo _leadingComment_3 = ((WhitespaceInfo)leaf).leadingComment();
			              boolean _endsWithNewLine_2 = false;
			              if (_leadingComment_3!=null) {
			                _endsWithNewLine_2=_leadingComment_3.endsWithNewLine();
			              }
			              if (_endsWithNewLine_2) {
			                newLines_1 = (newLines_1 - 1);
			              }
			              boolean _and_5 = false;
			              if (!equalIndentationChange) {
			                _and_5 = false;
			              } else {
			                List<LeafInfo> _leafs_2 = leafs.getLeafs();
			                LeafInfo _last_1 = IterableExtensions.<LeafInfo>last(_leafs_2);
			                boolean _notEquals_1 = (!Objects.equal(_last_1, leaf));
			                _and_5 = _notEquals_1;
			              }
			              if (_and_5) {
			                int _offset_7 = ((WhitespaceInfo)leaf).getOffset();
			                int _length_4 = ((WhitespaceInfo)leaf).getLength();
			                RuntimeException _xifexpression_10 = null;
			                if (trace) {
			                  _xifexpression_10 = new RuntimeException();
			                }
			                NewLineData _newLineData_2 = new NewLineData(_offset_7, _length_4, increaseIndentationChange, decreaseIndentationChange, _xifexpression_10, Integer.valueOf(newLines_1));
			                result.add(_newLineData_2);
			              } else {
			                int _offset_8 = ((WhitespaceInfo)leaf).getOffset();
			                int _length_5 = ((WhitespaceInfo)leaf).getLength();
			                RuntimeException _xifexpression_11 = null;
			                if (trace) {
			                  _xifexpression_11 = new RuntimeException();
			                }
			                NewLineData _newLineData_3 = new NewLineData(_offset_8, _length_5, 0, 0, _xifexpression_11, Integer.valueOf(newLines_1));
			                result.add(_newLineData_3);
			              }
			            }
			          }
			        }
			        if (!_matched) {
			          if (leaf instanceof CommentInfo) {
			            _matched=true;
			          }
			        }
			      }
			      _xblockexpression = result;
			    }
			    return _xblockexpression;
			  }
			  
			  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> append(final INode node, final Procedure1<? super FormattingDataFactory.FormattingDataInit> init) {
			    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _xifexpression = null;
			    boolean _notEquals = (!Objects.equal(node, null));
			    if (_notEquals) {
			      HiddenLeafs _hiddenLeafsAfter = this._hiddenLeafAccess.getHiddenLeafsAfter(node);
			      _xifexpression = this.newFormattingData(_hiddenLeafsAfter, init);
			    }
			    return _xifexpression;
			  }
			  
			  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> prepend(final INode node, final Procedure1<? super FormattingDataFactory.FormattingDataInit> init) {
			    Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _xifexpression = null;
			    boolean _notEquals = (!Objects.equal(node, null));
			    if (_notEquals) {
			      HiddenLeafs _hiddenLeafsBefore = this._hiddenLeafAccess.getHiddenLeafsBefore(node);
			      _xifexpression = this.newFormattingData(_hiddenLeafsBefore, init);
			    }
			    return _xifexpression;
			  }
			  
			  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> surround(final INode node, final Procedure1<? super FormattingDataFactory.FormattingDataInit> init) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      ArrayList<FormattingData> _xblockexpression = null;
			      {
			        final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
			        boolean _notEquals = (!Objects.equal(node, null));
			        if (_notEquals) {
			          Iterable<FormattingData> _elvis = null;
			          HiddenLeafs _hiddenLeafsBefore = this._hiddenLeafAccess.getHiddenLeafsBefore(node);
			          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(_hiddenLeafsBefore, init);
			          Iterable<FormattingData> _apply = null;
			          if (_newFormattingData!=null) {
			            _apply=_newFormattingData.apply(doc);
			          }
			          if (_apply != null) {
			            _elvis = _apply;
			          } else {
			            List<FormattingData> _emptyList = CollectionLiterals.<FormattingData>emptyList();
			            _elvis = _emptyList;
			          }
			          Iterables.<FormattingData>addAll(result, _elvis);
			          Iterable<FormattingData> _elvis_1 = null;
			          HiddenLeafs _hiddenLeafsAfter = this._hiddenLeafAccess.getHiddenLeafsAfter(node);
			          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData_1 = this.newFormattingData(_hiddenLeafsAfter, init);
			          Iterable<FormattingData> _apply_1 = null;
			          if (_newFormattingData_1!=null) {
			            _apply_1=_newFormattingData_1.apply(doc);
			          }
			          if (_apply_1 != null) {
			            _elvis_1 = _apply_1;
			          } else {
			            List<FormattingData> _emptyList_1 = CollectionLiterals.<FormattingData>emptyList();
			            _elvis_1 = _emptyList_1;
			          }
			          Iterables.<FormattingData>addAll(result, _elvis_1);
			        }
			        _xblockexpression = result;
			      }
			      return _xblockexpression;
			    };
			    return _function;
			  }
			  
			  public Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> surround(final INode node, final Procedure1<? super FormattingDataFactory.FormattingDataInit> before, final Procedure1<? super FormattingDataFactory.FormattingDataInit> after) {
			    final Function1<FormattableDocument, Iterable<FormattingData>> _function = (FormattableDocument doc) -> {
			      ArrayList<FormattingData> _xblockexpression = null;
			      {
			        final ArrayList<FormattingData> result = CollectionLiterals.<FormattingData>newArrayList();
			        boolean _notEquals = (!Objects.equal(node, null));
			        if (_notEquals) {
			          Iterable<FormattingData> _elvis = null;
			          HiddenLeafs _hiddenLeafsBefore = this._hiddenLeafAccess.getHiddenLeafsBefore(node);
			          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData = this.newFormattingData(_hiddenLeafsBefore, before);
			          Iterable<FormattingData> _apply = null;
			          if (_newFormattingData!=null) {
			            _apply=_newFormattingData.apply(doc);
			          }
			          if (_apply != null) {
			            _elvis = _apply;
			          } else {
			            List<FormattingData> _emptyList = CollectionLiterals.<FormattingData>emptyList();
			            _elvis = _emptyList;
			          }
			          Iterables.<FormattingData>addAll(result, _elvis);
			          Iterable<FormattingData> _elvis_1 = null;
			          HiddenLeafs _hiddenLeafsAfter = this._hiddenLeafAccess.getHiddenLeafsAfter(node);
			          Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> _newFormattingData_1 = this.newFormattingData(_hiddenLeafsAfter, after);
			          Iterable<FormattingData> _apply_1 = null;
			          if (_newFormattingData_1!=null) {
			            _apply_1=_newFormattingData_1.apply(doc);
			          }
			          if (_apply_1 != null) {
			            _elvis_1 = _apply_1;
			          } else {
			            List<FormattingData> _emptyList_1 = CollectionLiterals.<FormattingData>emptyList();
			            _elvis_1 = _emptyList_1;
			          }
			          Iterables.<FormattingData>addAll(result, _elvis_1);
			        }
			        _xblockexpression = result;
			      }
			      return _xblockexpression;
			    };
			    return _function;
			  }
			  
			  protected Function1<? super FormattableDocument, ? extends Iterable<FormattingData>> newFormattingData(final HiddenLeafs leafs, final PreferenceKey key, final FormattingDataFactory.FormattingDataInit it) {
			    if (key instanceof BlankLineKey) {
			      return _newFormattingData(leafs, (BlankLineKey)key, it);
			    } else if (key instanceof NewLineKey) {
			      return _newFormattingData(leafs, (NewLineKey)key, it);
			    } else if (key instanceof NewLineOrPreserveKey) {
			      return _newFormattingData(leafs, (NewLineOrPreserveKey)key, it);
			    } else if (key instanceof WhitespaceKey) {
			      return _newFormattingData(leafs, (WhitespaceKey)key, it);
			    } else if (key == null) {
			      return _newFormattingData(leafs, (Void)null, it);
			    } else if (key != null) {
			      return _newFormattingData(leafs, key, it);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(leafs, key, it).toString());
			    }
			  }
			}
		''')
	}		
}