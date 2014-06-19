/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ValueObject
@Wither
class Foo {
	String bar
	int baz
}
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
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name;
			  
			  private final boolean _myFlag;
			  
			  private final Iterable<? extends Foo> _references;
			  
			  public Foo(final String name, final boolean myFlag, final Iterable<? extends Foo> references) {
			    super();
			    this._name = name;
			    this._myFlag = myFlag;
			    this._references = references;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
			    result = prime * result + (this._myFlag ? 1231 : 1237);
			    result = prime * result + ((this._references== null) ? 0 : this._references.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (this._name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!this._name.equals(other._name))
			      return false;
			    if (other._myFlag != this._myFlag)
			      return false;
			    if (this._references == null) {
			      if (other._references != null)
			        return false;
			    } else if (!this._references.equals(other._references))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public String getName() {
			    return this._name;
			  }
			  
			  @Pure
			  public boolean isMyFlag() {
			    return this._myFlag;
			  }
			  
			  @Pure
			  public Iterable<? extends Foo> getReferences() {
			    return this._references;
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
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name = "foo";
			  
			  public Foo() {
			    super();
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (this._name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!this._name.equals(other._name))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public String getName() {
			    return this._name;
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
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name = "foo";
			  
			  public Foo() {
			    super();
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (this._name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!this._name.equals(other._name))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public String getName() {
			    return this._name;
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
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Node {
			  private final ArrayList<Node> _contents = CollectionLiterals.<Node>newArrayList();
			  
			  public String tagName() {
			    Class<? extends Node> _class = this.getClass();
			    String _simpleName = _class.getSimpleName();
			    return _simpleName.toLowerCase();
			  }
			  
			  public Node() {
			    super();
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._contents== null) ? 0 : this._contents.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Node other = (Node) obj;
			    if (this._contents == null) {
			      if (other._contents != null)
			        return false;
			    } else if (!this._contents.equals(other._contents))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public ArrayList<Node> getContents() {
			    return this._contents;
			  }
			}
		''')
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PropertyCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
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

				import org.eclipse.xtend.lib.Property;
				import org.eclipse.xtext.xbase.lib.Pure;
				
				@SuppressWarnings("all")
				public class Bar {
				  @Property
				  private boolean _generateExpressions = true;
				  
				  @Pure
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
				import org.eclipse.xtend.lib.Property;
				import org.eclipse.xtext.xbase.lib.Pure;
				
				@SuppressWarnings("all")
				public class C {
				  @Property
				  private final String _string = "";
				  
				  @Pure
				  public String getString() {
				    return this._string;
				  }
				}
			''', generatorConfig)
	}
	
	@Test
	def compilePropertyWithoutType() {
		clazz(
			'''
				class C {
					@Property
					var string = ''
				}
			''').members.head.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred")
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
				import org.eclipse.xtend.lib.Property;
				import org.eclipse.xtext.xbase.lib.Pure;
				
				@SuppressWarnings("all")
				public class C<T extends Object> {
				  @Property
				  private T _t;
				  
				  @Pure
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
		clazz(
			'''
				class C<T> {
					@Property
					var iterable = null as Iterable<T>
				}
			''').members.head.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred")
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
				import org.eclipse.xtend.lib.Property;
				import org.eclipse.xtext.xbase.lib.Pure;
				
				@SuppressWarnings("all")
				public class C<T extends Object> {
				  @Property
				  private String[] _array = { "a" };
				  
				  @Pure
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
				import org.eclipse.xtend.lib.Property;
				import org.eclipse.xtext.xbase.lib.Pure;
				
				@SuppressWarnings("all")
				public class X {
				  @Property
				  private final String _x = "hello";
				  
				  @Pure
				  public String getX() {
				    return this._x;
				  }
				}
			''')
	}
	
}