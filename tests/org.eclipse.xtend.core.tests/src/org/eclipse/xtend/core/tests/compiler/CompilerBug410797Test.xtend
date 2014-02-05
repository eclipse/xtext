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
class CompilerBug410797Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_410797_01() {
		assertCompilesTo('''
			class C {
				def Iterable<D> m() {
					val list = <E>newArrayList
					val g = new G
			
					list.map[e|e.m].flatten.map[d(g)]
				}
				def d(F f, G g) {
					new D
				}
			}
			class D {
			}
			class E {
				def m() {
					<F>newArrayList
				}
			}
			
			class G {	
			}
			class F {
				
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<D> m() {
			    Iterable<D> _xblockexpression = null;
			    {
			      final ArrayList<E> list = CollectionLiterals.<E>newArrayList();
			      final G g = new G();
			      final Function1<E, ArrayList<F>> _function = new Function1<E, ArrayList<F>>() {
			        public ArrayList<F> apply(final E e) {
			          return e.m();
			        }
			      };
			      List<ArrayList<F>> _map = ListExtensions.<E, ArrayList<F>>map(list, _function);
			      Iterable<F> _flatten = Iterables.<F>concat(_map);
			      final Function1<F, D> _function_1 = new Function1<F, D>() {
			        public D apply(final F it) {
			          return C.this.d(it, g);
			        }
			      };
			      _xblockexpression = IterableExtensions.<F, D>map(_flatten, _function_1);
			    }
			    return _xblockexpression;
			  }
			  
			  public D d(final F f, final G g) {
			    return new D();
			  }
			}
		''')
	}
	
	@Test def void testBug_410797_02() {
		assertCompilesTo('''
			class C {
				def Iterable<D> m() {
					val g = new G();
					<E>newArrayList.map[e|e.m].flatten.map[d(g)]
				}
				def d(F f, G g) {
					new D
				}
			}
			class D {
			}
			class E {
				def m() {
					<F>newArrayList
				}
			}
			
			class G {	
			}
			class F {
				
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<D> m() {
			    Iterable<D> _xblockexpression = null;
			    {
			      final G g = new G();
			      ArrayList<E> _newArrayList = CollectionLiterals.<E>newArrayList();
			      final Function1<E, ArrayList<F>> _function = new Function1<E, ArrayList<F>>() {
			        public ArrayList<F> apply(final E e) {
			          return e.m();
			        }
			      };
			      List<ArrayList<F>> _map = ListExtensions.<E, ArrayList<F>>map(_newArrayList, _function);
			      Iterable<F> _flatten = Iterables.<F>concat(_map);
			      final Function1<F, D> _function_1 = new Function1<F, D>() {
			        public D apply(final F it) {
			          return C.this.d(it, g);
			        }
			      };
			      _xblockexpression = IterableExtensions.<F, D>map(_flatten, _function_1);
			    }
			    return _xblockexpression;
			  }
			  
			  public D d(final F f, final G g) {
			    return new D();
			  }
			}
		''')
	}
	
	@Test def void testBug_410797_03() {
		assertCompilesTo('''
			class C {
				def Iterable<D> m() {
					<E>newArrayList.map[e|e.m].flatten.map[d(new G)]
				}
				def d(F f, G g) {
					new D
				}
			}
			class D {
			}
			class E {
				def m() {
					<F>newArrayList
				}
			}
			
			class G {	
			}
			class F {
				
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<D> m() {
			    ArrayList<E> _newArrayList = CollectionLiterals.<E>newArrayList();
			    final Function1<E, ArrayList<F>> _function = new Function1<E, ArrayList<F>>() {
			      public ArrayList<F> apply(final E e) {
			        return e.m();
			      }
			    };
			    List<ArrayList<F>> _map = ListExtensions.<E, ArrayList<F>>map(_newArrayList, _function);
			    Iterable<F> _flatten = Iterables.<F>concat(_map);
			    final Function1<F, D> _function_1 = new Function1<F, D>() {
			      public D apply(final F it) {
			        G _g = new G();
			        return C.this.d(it, _g);
			      }
			    };
			    return IterableExtensions.<F, D>map(_flatten, _function_1);
			  }
			  
			  public D d(final F f, final G g) {
			    return new D();
			  }
			}
		''')
	}
	
	@Test def void testBug_410797_04() {
		assertCompilesTo('''
			package org.eclipse.xtext.xbase.formatting

			import com.google.inject.Inject
			import org.eclipse.xtext.nodemodel.INode
			import java.util.List
			import org.eclipse.xtext.nodemodel.ILeafNode
			import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator
			import org.eclipse.xtext.nodemodel.ICompositeNode

			@Data class HiddenLeafs {
				int offset
				List<LeafInfo> leafs = newArrayList
				
				def boolean isSingleWhitespace() {
					leafs.empty || (leafs.size == 1 && leafs.head instanceof WhitespaceInfo)
				}
				
				def int getLenght() {
					leafs.fold(0, [x, i | x + i.node?.length])
				}
				
				def int getNewLines() {
					leafs.fold(0, [x, i | x + i.newLines])
				}
				
				def int getNewLinesInComments() {
					leafs.filter(CommentInfo).fold(0, [x, i | x + i.newLines])
				}
			
				def containsComment(){
					leafs.filter(CommentInfo).size > 0
				}
			}
		''', '''
			package org.eclipse.xtext.xbase.formatting;
			
			import com.google.common.collect.Iterables;
			import java.util.List;
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.nodemodel.ILeafNode;
			import org.eclipse.xtext.xbase.formatting.CommentInfo;
			import org.eclipse.xtext.xbase.formatting.LeafInfo;
			import org.eclipse.xtext.xbase.formatting.WhitespaceInfo;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class HiddenLeafs {
			  private final int _offset;
			  
			  public int getOffset() {
			    return this._offset;
			  }
			  
			  private final List<LeafInfo> _leafs = CollectionLiterals.<LeafInfo>newArrayList();
			  
			  public List<LeafInfo> getLeafs() {
			    return this._leafs;
			  }
			  
			  public boolean isSingleWhitespace() {
			    boolean _or = false;
			    List<LeafInfo> _leafs = this.getLeafs();
			    boolean _isEmpty = _leafs.isEmpty();
			    if (_isEmpty) {
			      _or = true;
			    } else {
			      boolean _and = false;
			      List<LeafInfo> _leafs_1 = this.getLeafs();
			      int _size = _leafs_1.size();
			      boolean _equals = (_size == 1);
			      if (!_equals) {
			        _and = false;
			      } else {
			        List<LeafInfo> _leafs_2 = this.getLeafs();
			        LeafInfo _head = IterableExtensions.<LeafInfo>head(_leafs_2);
			        _and = (_head instanceof WhitespaceInfo);
			      }
			      _or = _and;
			    }
			    return _or;
			  }
			  
			  public int getLenght() {
			    List<LeafInfo> _leafs = this.getLeafs();
			    final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {
			      public Integer apply(final Integer x, final LeafInfo i) {
			        ILeafNode _node = i.getNode();
			        int _length = 0;
			        if (_node!=null) {
			          _length=_node.getLength();
			        }
			        return Integer.valueOf(((x).intValue() + _length));
			      }
			    };
			    return (int) IterableExtensions.<LeafInfo, Integer>fold(_leafs, Integer.valueOf(0), _function);
			  }
			  
			  public int getNewLines() {
			    List<LeafInfo> _leafs = this.getLeafs();
			    final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {
			      public Integer apply(final Integer x, final LeafInfo i) {
			        int _newLines = i.getNewLines();
			        return Integer.valueOf(((x).intValue() + _newLines));
			      }
			    };
			    return (int) IterableExtensions.<LeafInfo, Integer>fold(_leafs, Integer.valueOf(0), _function);
			  }
			  
			  public int getNewLinesInComments() {
			    List<LeafInfo> _leafs = this.getLeafs();
			    Iterable<CommentInfo> _filter = Iterables.<CommentInfo>filter(_leafs, CommentInfo.class);
			    final Function2<Integer, CommentInfo, Integer> _function = new Function2<Integer, CommentInfo, Integer>() {
			      public Integer apply(final Integer x, final CommentInfo i) {
			        int _newLines = i.getNewLines();
			        return Integer.valueOf(((x).intValue() + _newLines));
			      }
			    };
			    return (int) IterableExtensions.<CommentInfo, Integer>fold(_filter, Integer.valueOf(0), _function);
			  }
			  
			  public boolean containsComment() {
			    List<LeafInfo> _leafs = this.getLeafs();
			    Iterable<CommentInfo> _filter = Iterables.<CommentInfo>filter(_leafs, CommentInfo.class);
			    int _size = IterableExtensions.size(_filter);
			    return (_size > 0);
			  }
			  
			  public HiddenLeafs(final int offset) {
			    super();
			    this._offset = offset;
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + _offset;
			    result = prime * result + ((_leafs== null) ? 0 : _leafs.hashCode());
			    return result;
			  }
			  
			  @Override
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    HiddenLeafs other = (HiddenLeafs) obj;
			    if (other._offset != _offset)
			      return false;
			    if (_leafs == null) {
			      if (other._leafs != null)
			        return false;
			    } else if (!_leafs.equals(other._leafs))
			      return false;
			    return true;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			}
		''')
	}
	
}