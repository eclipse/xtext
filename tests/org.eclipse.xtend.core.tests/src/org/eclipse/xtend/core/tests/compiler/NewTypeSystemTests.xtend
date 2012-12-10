/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Ignore

@Ignore("TBD")
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class CompilerTest2 extends CompilerTest {
}

@Ignore("TBD")
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class XtendCompilerTest2 extends XtendCompilerTest {
	
	@Test override testThreeDataClassesExtendingEachOther() {
		'''
			import java.util.ArrayList
			
			@Data class Node {
				ArrayList<Node> contents = newArrayList
				def String tagName() {
					getClass.simpleName.toLowerCase
				}
			}
			
			@Data class ContentNode extends Node {}
			@Data class Body extends ContentNode {}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Node {
			  private final ArrayList<Node> _contents = new Function0<ArrayList<Node>>() {
			    public ArrayList<Node> apply() {
			      ArrayList<Node> _newArrayList = CollectionLiterals.<Node>newArrayList();
			      return _newArrayList;
			    }
			  }.apply();
			  
			  public ArrayList<Node> getContents() {
			    return this._contents;
			  }
			  
			  public String tagName() {
			    Class<? extends Node> _class = this.getClass();«/* super impl assert Class<? extends Object> */»
			    String _simpleName = _class.getSimpleName();
			    String _lowerCase = _simpleName.toLowerCase();
			    return _lowerCase;
			  }
			  
			  public Node() {
			    super();
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_contents== null) ? 0 : _contents.hashCode());
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
			    Node other = (Node) obj;
			    if (_contents == null) {
			      if (other._contents != null)
			        return false;
			    } else if (!_contents.equals(other._contents))
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
	
	@Test override testSwitchOverNull() {
		assertCompilesTo('''
			public class Foo  {
			    def foo() {
			        switch null {
			            case null : [Object it|it]
			            case null : [Integer it|it]
			        }
			    }    
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Function1<? super Integer,? extends Object> foo() {
			    Function1<? super Integer,? extends Object> _switchResult = null;
			    final Object _switchValue = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(_switchValue,null)) {
			        _matched=true;
			        final Function1<Object,Object> _function = new Function1<Object,Object>() {
			            public Object apply(final Object it) {
			              return it;
			            }
			          };
			        _switchResult = _function;
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue,null)) {
			        _matched=true;
			        final Function1<Integer,Integer> _function_1 = new Function1<Integer,Integer>() {
			            public Integer apply(final Integer it) {
			              return it;
			            }
			          };
			        _switchResult = _function_1;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
}

@Ignore("TBD")
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class XtendCompilerErrorHandlingTest2 extends XtendCompilerErrorHandlingTest {
}