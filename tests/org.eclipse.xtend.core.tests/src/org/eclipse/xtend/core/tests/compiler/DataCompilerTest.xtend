/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler
import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class DataCompilerTest extends AbstractXtendCompilerTest {
	
	@Inject
	extension ValidationTestHelper
	
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
	
	@Test
	def void testExistingDataConstructor() {
		'''
			@Data class Foo {
				int foo
				new (int foo) {
					_foo = foo * 2
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(4, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testExistingGetter() {
		'''
			@Data class Foo {
				int foo
				def getFoo() {
					5
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(5, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testExistingToString() {
		'''
			@Data class Foo {
				int foo
				override toString() {
					"5"
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val toString = compiledClass.getDeclaredMethod("toString")
			assertEquals("5", toString.invoke(instance))
		]
	}
	
	@Test
	def void testExistingEquals() {
		'''
			@Data class Foo {
				int foo
				override equals(Object o) {
					true
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val equals = compiledClass.getDeclaredMethod("equals", Object)
			assertEquals(true, equals.invoke(instance, 1))
		]
	}
	
	@Test
	def void testExistingHashCode() {
		'''
			@Data class Foo {
				int foo
				override hashCode() {
					0
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val hashCode = compiledClass.getDeclaredMethod("hashCode")
			assertEquals(0, hashCode.invoke(instance))
		]
	}
	
	@Test
	def void testExistingMethodsNotMatchingExactly() {
		'''
			@Data class Foo {
				int foo
				
				new(String bar) {
					_foo = 1
				}
				
				def getFoo(String bar) {
					1
				}
				
				def toString(String bar) {
					"1"
				}
				
				def hashCode(String bar) {
					1
				}
				
				def equals(String bar) {
					true
				}
				
				def equals(Object foo, String bar) {
					true
				}
			}
		'''.compile[
			compiledClass=>[
				getDeclaredConstructor(int)
				getDeclaredMethod("equals", Object)
				getDeclaredMethod("hashCode")
				getDeclaredMethod("toString")
				getDeclaredMethod("getFoo")
			]
		]
	}
	
	
	
	@Test
	def void testWithCreateExtension() {
		val text = '''
			@Data class Foo {
				def create {} foo() {
				}
			}
		'''
		clazz(text).assertNoIssues
		text.compile[
			assertFalse(compiledClass.declaredMethods.exists[name.startsWith("get")])
		]
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
	
	@Test
	def testDataClassWithStaticField() {
		'''
			@Data class Foo {
				static int foo = 1
			}
		'''.compile[
			compiledClass => [
				assertTrue(declaredFields.exists[name == "foo"])
				assertFalse(declaredMethods.exists[name == "getFoo"])
				assertTrue(declaredConstructors.exists[parameterTypes.length == 0])
			]
		]
	}
	
	@Test
	def testBooleanProperties() {
		'''
			@Data class Foo {
				boolean foo
				Boolean bar
			}
		'''.compile[
			compiledClass => [
				assertTrue(declaredFields.exists[name == "_foo"])
				assertTrue(declaredFields.exists[name == "_bar"])
				assertTrue(declaredMethods.exists[name == "isFoo"])
				assertTrue(declaredMethods.exists[name == "isBar"])
			]
		]
	}
	
	@Test
	def testParametrizedSuperConstructor() {
		'''
			@Data class Foo {
				int foo
			}
			@Data class Bar extends Foo {
				String bar
			}
		'''.compile[
			getCompiledClass("Bar") => [
				assertTrue(declaredConstructors.exists[parameterTypes.toList == #[int, String]])
			]
		]
	}
}