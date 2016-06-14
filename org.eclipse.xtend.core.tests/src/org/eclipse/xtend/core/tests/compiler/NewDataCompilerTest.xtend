/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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

class NewDataCompilerTest extends AbstractXtendCompilerTest {
	
	@Inject
	extension ValidationTestHelper
	
	@Test
	def testDataClasses_01() { 
		assertCompilesTo('''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo {
				String name
				boolean myFlag
				java.lang.Iterable<? extends Foo> references
			}
		''', '''
			import org.eclipse.xtend.lib.annotations.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String name;
			  
			  private final boolean myFlag;
			  
			  private final Iterable<? extends Foo> references;
			  
			  public Foo(final String name, final boolean myFlag, final Iterable<? extends Foo> references) {
			    super();
			    this.name = name;
			    this.myFlag = myFlag;
			    this.references = references;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
			    result = prime * result + (this.myFlag ? 1231 : 1237);
			    result = prime * result + ((this.references== null) ? 0 : this.references.hashCode());
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
			    if (this.name == null) {
			      if (other.name != null)
			        return false;
			    } else if (!this.name.equals(other.name))
			      return false;
			    if (other.myFlag != this.myFlag)
			      return false;
			    if (this.references == null) {
			      if (other.references != null)
			        return false;
			    } else if (!this.references.equals(other.references))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    ToStringBuilder b = new ToStringBuilder(this);
			    b.add("name", this.name);
			    b.add("myFlag", this.myFlag);
			    b.add("references", this.references);
			    return b.toString();
			  }
			  
			  @Pure
			  public String getName() {
			    return this.name;
			  }
			  
			  @Pure
			  public boolean isMyFlag() {
			    return this.myFlag;
			  }
			  
			  @Pure
			  public Iterable<? extends Foo> getReferences() {
			    return this.references;
			  }
			}
		''')
	}
	
	@Test
	def void testExistingDataConstructor() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo {
				int foo
				new (int foo) {
					this.foo = foo * 2
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
			import org.eclipse.xtend.lib.annotations.Data
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
	def void testExistingGetter2() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo {
				boolean foo
				def getFoo() {
					true
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(boolean).newInstance(false)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(true, getFoo.invoke(instance))
			assertFalse(compiledClass.declaredMethods.exists[name == "isFoo"])
		]
	}
	
	@Test
	def void testExistingToString() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
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
			import org.eclipse.xtend.lib.annotations.Data
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
			import org.eclipse.xtend.lib.annotations.Data
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
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo {
				int foo
				
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
			import org.eclipse.xtend.lib.annotations.Data
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
	
	@Test
	def void testVariable() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo {
				var foo = 3
			}
		'''
		clazz(text).assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "'var'")
	}
	
	@Test
	def testDataClassWithStaticField() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
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
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo {
				boolean foo
				Boolean bar
			}
		'''.compile[
			compiledClass => [
				assertTrue(declaredFields.exists[name == "foo"])
				assertTrue(declaredFields.exists[name == "bar"])
				assertTrue(declaredMethods.exists[name == "isFoo"])
				assertTrue(declaredMethods.exists[name == "getBar"])
			]
		]
	}
	
	@Test
	def testParametrizedSuperConstructor() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
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
	
	@Test
	def testSuperClassWithTypeParameters() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo<T> {
				T foo
			}
			@Data class Bar extends Foo<String> {
			}
		'''.compile [
			assertTrue(getGeneratedCode("Bar").contains("public Bar(final String foo) {"))
		]
	}
	
	@Test
	def testClassAndSuperClassWithTypeParameters() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class Foo<T> {
				T foo
			}
			@Data class Bar<X> extends Foo<X> {
			}
		'''.compile [
			assertTrue(getGeneratedCode("Bar").contains("public Bar(final X foo) {"))
		]
	}
	
	@Test
	def testBug449185() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			@Data class A {
			}
			
			@Data class C extends A {
				val int c
			}
			
			@Data class B {
				val int b
			}
			
			@Data class D extends B {
				val double d
			}
		'''.compile[
			val d = getCompiledClass("D")
			val parameterTypes = d.declaredConstructors.head.parameterTypes
			assertArrayEquals(#[int, double], parameterTypes)
		]
	}
	
	@Test def void testSuperClassWithoutEquals() {
		'''
			import org.eclipse.xtend.lib.annotations.Data
			class Foo {
			}
			@Data class Bar extends Foo {
				String bar = "Foo"
			}
		'''.compile[
			assertFalse(getGeneratedCode("Bar"),getGeneratedCode("Bar").contains("super.equals"))
			assertFalse(getGeneratedCode("Bar").contains("super.hashCode"))
		]
	}
}