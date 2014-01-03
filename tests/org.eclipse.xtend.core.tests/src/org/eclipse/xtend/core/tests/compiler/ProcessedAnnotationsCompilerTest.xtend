/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
class DataCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def testDataClasses_01() { 
		assertCompilesTo('''
			@Data class Foo {
				String name
				boolean myFlag
				java.lang.Iterable<? extends Foo> references
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name;
			  
			  public String getName() {
			    return this._name;
			  }
			  
			  private final boolean _myFlag;
			  
			  public boolean isMyFlag() {
			    return this._myFlag;
			  }
			  
			  private final Iterable<? extends Foo> _references;
			  
			  public Iterable<? extends Foo> getReferences() {
			    return this._references;
			  }
			  
			  public Foo(final String name, final boolean myFlag, final Iterable<? extends Foo> references) {
			    super();
			    this._name = name;
			    this._myFlag = myFlag;
			    this._references = references;
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
			    result = prime * result + (_myFlag ? 1231 : 1237);
			    result = prime * result + ((_references== null) ? 0 : _references.hashCode());
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
			    Foo other = (Foo) obj;
			    if (_name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!_name.equals(other._name))
			      return false;
			    if (other._myFlag != _myFlag)
			      return false;
			    if (_references == null) {
			      if (other._references != null)
			        return false;
			    } else if (!_references.equals(other._references))
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
	
	@Test
	def testDataClasses_02() { 
		assertCompilesTo('''
			@Data class Foo {
				String name = 'foo'
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name = "foo";
			  
			  public String getName() {
			    return this._name;
			  }
			  
			  public Foo() {
			    super();
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
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
			    Foo other = (Foo) obj;
			    if (_name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!_name.equals(other._name))
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
	
	@Test
	def testDataClasses_03() { 
		assertCompilesTo('''
			@Data class Foo {
				val name = 'foo'
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name = "foo";
			  
			  public String getName() {
			    return this._name;
			  }
			  
			  public Foo() {
			    super();
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
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
			    Foo other = (Foo) obj;
			    if (_name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!_name.equals(other._name))
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
	
	@Test def testThreeDataClassesExtendingEachOther() {
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
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Node {
			  private final ArrayList<Node> _contents = CollectionLiterals.<Node>newArrayList();
			  
			  public ArrayList<Node> getContents() {
			    return this._contents;
			  }
			  
			  public String tagName() {
			    Class<? extends Node> _class = this.getClass();
			    String _simpleName = _class.getSimpleName();
			    return _simpleName.toLowerCase();
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
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PropertyCompilerTest extends AbstractXtendCompilerTest {
	@Test
	def compileProperty() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				package foo

				class Bar {
					@Property
					boolean generateExpressions = true
				}
			''',
			'''
				package foo;
				
				@SuppressWarnings("all")
				public class Bar {
				  private boolean _generateExpressions = true;
				  
				  public boolean isGenerateExpressions() {
				    return this._generateExpressions;
				  }
				  
				  public void setGenerateExpressions(final boolean generateExpressions) {
				    this._generateExpressions = generateExpressions;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compileReadonlyPropertyWithoutType() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				class C {
					@Property
					val string = ''
				}
			''',
			'''
				@SuppressWarnings("all")
				public class C {
				  private final String _string = "";
				  
				  public String getString() {
				    return this._string;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compilePropertyWithoutType() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				class C {
					@Property
					var string = ''
				}
			''',
			'''
				@SuppressWarnings("all")
				public class C {
				  private String _string = "";
				  
				  public String getString() {
				    return this._string;
				  }
				  
				  public void setString(final String string) {
				    this._string = string;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compilePropertyWithTypeParameter() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				class C<T> {
					@Property
					var T t
				}
			''',
			'''
				@SuppressWarnings("all")
				public class C<T extends Object> {
				  private T _t;
				  
				  public T getT() {
				    return this._t;
				  }
				  
				  public void setT(final T t) {
				    this._t = t;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compilePropertyWithoutTypeButTypeParameter() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				class C<T> {
					@Property
					var iterable = null as Iterable<T>
				}
			''',
			'''
				@SuppressWarnings("all")
				public class C<T extends Object> {
				  private Iterable<T> _iterable = ((Iterable<T>) null);
				  
				  public Iterable<T> getIterable() {
				    return this._iterable;
				  }
				  
				  public void setIterable(final Iterable<T> iterable) {
				    this._iterable = iterable;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compilePropertyWithArrayType() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				class C<T> {
					@Property
					var String[] array = #['a']
				}
			''',
			'''
				@SuppressWarnings("all")
				public class C<T extends Object> {
				  private String[] _array = { "a" };
				  
				  public String[] getArray() {
				    return this._array;
				  }
				  
				  public void setArray(final String[] array) {
				    this._array = array;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compileExplicitProperty() {
		assertCompilesTo(
			'''
				class X {
					@Property val String x = 'hello'
				}
			''', '''
				@SuppressWarnings("all")
				public class X {
				  private final String _x = "hello";
				  
				  public String getX() {
				    return this._x;
				  }
				}
			''')
	}
	
}