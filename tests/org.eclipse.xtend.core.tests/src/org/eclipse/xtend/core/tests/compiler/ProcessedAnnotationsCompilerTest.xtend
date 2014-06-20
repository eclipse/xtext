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
import org.junit.Ignore

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
	
	
	
	@Ignore
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
	
	@Test
	def void testExistingGetter() {
		'''
			class Foo {
				@Property int foo
				def getFoo() {
					5
				}
			}
		'''.compile[
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(5, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testExistingSetter() {
		'''
			class Foo {
				@Property int foo
				def setFoo(int foo) {
					_foo = 5
				}
			}
		'''.compile[
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			setFoo.invoke(instance, 1)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(5, getFoo.invoke(instance))
		]
	}
}

class EqualsHashCodeCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testEqualsHashCode() {
		'''
			@EqualsHashCode class Foo {
				static String ignoreMe
				transient String ignoreMe2
				
				int a = 1
				char b = 'a'
				short c = 2 as short
				byte d = 3 as byte
				long e = 4
				float f = 5
				double g = 6
				boolean h = true
				Object i = "Foo"
			}
		'''.compile [
			val first = compiledClass.newInstance
			val second = compiledClass.newInstance
			compiledClass.getDeclaredField("ignoreMe") => [
				accessible = true
				set(null, "Bar")
			]
			compiledClass.getDeclaredField("ignoreMe2") => [
				accessible = true
				set(second, "Bar")
			]
			val third = compiledClass.newInstance
			compiledClass.getDeclaredField("i") => [
				accessible = true
				set(third, "Bar")
			]
			
			assertEquals(first, second)
			assertFalse(first.equals(third))
			assertEquals(first.hashCode, second.hashCode)
			assertFalse(first.hashCode == third.hashCode)
		]
	}
	
	@Test
	def void testEqualsWithSuperClass() {
		'''
			@EqualsHashCode class Foo {
				int foo = 1
			}
			@EqualsHashCode class Bar extends Foo{
				String bar = "Foo"
			}
		'''.compile[
			val foo = getCompiledClass("Foo")
			val bar = getCompiledClass("Bar")
			
			val first = bar.newInstance 
			val second = bar.newInstance
			val third = bar.newInstance
			bar.getDeclaredField("bar") => [
				accessible = true
				set(third, "Bar")
			]
			val fourth = foo.newInstance
			
			assertEquals(first, second)
			assertFalse(first.equals(third))
			assertFalse(first.equals(fourth))
			assertFalse(fourth.equals(first))
		]
	}
	
	@Test
	def void testExistingEquals() {
		val text = '''
			@EqualsHashCode class Foo {
				int a = 1
				override equals(Object o) {
					true
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_CLASS,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.newInstance
			assertEquals(instance, "foo")
		]
	}
	
	@Test
	def void testExistingHashCode() {
		val text = '''
			@EqualsHashCode class Foo {
				int a = 1
				override hashCode() {
					0
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_CLASS,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.newInstance
			assertEquals(0, instance.hashCode)
		]
	}
}

class ToStringCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testToString() {
		'''
			@ToString class Foo {
				static String ignoreMe
				transient String ignoreMe2
				int a = 1
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals("Foo{a=1}", instance.toString)
		]
	}
	
	@Test
	def void testToStringWithSuperClass() {
		'''
			class Foo {
				int a = 1
			}
			@ToString class Bar extends Foo {
				String b = "Bar"
			}
		'''.compile [
			val instance = getCompiledClass("Bar").newInstance
			
			assertEquals('Bar [\n'+'  b = "Bar"\n' +'  a = 1\n' + ']', instance.toString)
		]
	}
	
	@Test
	def void testExistingToString() {
		val text = '''
			@ToString class Foo {
				int a = 1
				override toString() {
					"foo"
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_CLASS,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.newInstance
			assertEquals("foo", instance.toString)
		]
	}
}

class GetterCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper

	@Test
	def void testCreateSingleGetter() {
		'''
			class Foo {
				@Getter int foo = 1
			}
		'''.compile[
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(1, getFoo.invoke(instance))
		]
	}

	@Test
	def void testCreateAllGetters() {
		'''
			@Getter class Foo {
				static String ignoreMe
				int foo = 1
				String bar = "bar"
				
				def getFoo() {
					2
				}
			}
		'''.compile[
			assertFalse(compiledClass.declaredMethods.exists[name == "getIgnoreMe"])
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			val getBar = compiledClass.getDeclaredMethod("getBar")
			assertEquals(2, getFoo.invoke(instance))
			assertEquals("bar", getBar.invoke(instance))
		]
	}

	@Test
	def void testExistingGetter() {
		val text = '''
			class Foo {
				@Getter int foo = 1
				def getFoo() {
					2
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_FIELD, "user.issue", "no effect")
		text.compile[
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(2, getFoo.invoke(instance))
		]
	}
}

class SetterCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper

	@Test
	def void testCreateSingleSetter() {
		'''
			class Foo {
				@Setter int foo
			}
		'''.compile[
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [
				accessible = true
			]
			setFoo.invoke(instance, 1)
			assertEquals(1, fooField.get(instance))
		]
	}

	@Test
	def void testCreateAllSetters() {
		'''
			@Setter class Foo {
				static String ignoreMe
				int foo
				String bar
				
				def setFoo(int foo) {
					this.foo = 2
				}
			}
		'''.compile[
			assertFalse(compiledClass.declaredMethods.exists[name == "setIgnoreMe"])
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [accessible = true]
			val setBar = compiledClass.getDeclaredMethod("setBar", String)
			val barField = compiledClass.getDeclaredField("bar") => [accessible = true]
			setFoo.invoke(instance, 1)
			setBar.invoke(instance, "bar")
			assertEquals(2, fooField.get(instance))
			assertEquals("bar", barField.get(instance))
		]
	}

	@Test
	def void testExistingGetter() {
		val text = '''
			class Foo {
				@Setter int foo
				def setFoo(int foo) {
					this.foo = 2
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_FIELD, "user.issue", "no effect")
		text.compile[
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [accessible = true]
			setFoo.invoke(instance, 1)
			assertEquals(2, fooField.get(instance))
		]
	}

	@Test
	def void testFinalField() {
		val text = '''
			class Foo {
				@Setter val int foo
			}
		'''
		text.clazz.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "final")
	}
}

class WitherCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testCreateSingleWither() {
		'''
			class Foo {
				static String ignoreMe
				transient String ignoreMe2
				@Wither String foo
				new(String foo) {
					this.foo = foo
				}
				def getFoo() {
					foo
				}
			}
		'''.compile[
			val first= compiledClass.getDeclaredConstructor(String).newInstance("foo")
			val withFoo = compiledClass.getDeclaredMethod("withFoo", String)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			val second = withFoo.invoke(first, "bar")
			
			assertNotSame(first, second)
			assertEquals("bar", getFoo.invoke(second))
		]
	}
	
	@Test
	def void testCreateAllWithers() {
		'''
			@Wither
			class Foo {
				static String ignoreMe
				transient String ignoreMe2
				String foo
				int x
				new(String foo, int x) {
					this.foo = foo
					this.x = x
				}
				
				def withX(int x) {
					new Foo(foo, 5)
				}
				
				def getFoo() {
					foo
				}
				
				def getX() {
					x
				}
			}
		'''.compile[
			val first= compiledClass.getDeclaredConstructor(String, int).newInstance("foo", 1)
			val withFoo = compiledClass.getDeclaredMethod("withFoo", String)
			val withX = compiledClass.getDeclaredMethod("withX", int)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			val getX = compiledClass.getDeclaredMethod("getX")
			val second = withX.invoke(withFoo.invoke(first, "bar"), 2)
			
			assertEquals("bar", getFoo.invoke(second))
			assertEquals(5, getX.invoke(second))
		]
	}
	
	@Test
	def void testExstingWither() {
		val text = '''
			class Foo {
				@Wither int x
				
				new(int x) {
					this.x = x
				}
				
				def withX(int x) {
					new Foo(5)
				}
				
				def getX() {
					x
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_FIELD, "user.issue", "no effect")
		text.compile[
			val first= compiledClass.getDeclaredConstructor(int).newInstance(1)
			val withX = compiledClass.getDeclaredMethod("withX", int)
			val getX = compiledClass.getDeclaredMethod("getX")
			val second = withX.invoke(first , 2)
			
			assertEquals(5, getX.invoke(second))
		]
	}
	
	@Test
	def void testExstingMethodNotMatching() {
		'''
			class Foo {
				@Wither String foo
				new(String foo) {
					this.foo = foo
				}
				def withFoo() {
					null
				}
				def withFoo(int x) {
					null
				}
			}
		'''.compile[
			compiledClass.getDeclaredMethod("withFoo", String)
		]
	}
	
	@Test
	def void testInferredType() {
		val text = '''
			class Foo {
				@Wither var x = 1
				
				new(int x) {
					this.x = x
				}
			}
		'''
		text.clazz.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred")
	}
}