/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(DomainmodelInjectorProvider)
class CompilerTest {

	@Rule
	@Inject public TemporaryFolder temporaryFolder
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions

	@Test def void testGeneratedJava() throws Exception {
		'''
			entity Foo {
				name : String
				op doStuff(String x) : String {
					return x + ' ' + this.name
				}
			}
		'''.compile [
			val obj = it.compiledClass.getDeclaredConstructor().newInstance
			obj.invoke('setName', 'Foo')
			assertEquals("Hello Foo", obj.invoke('doStuff','Hello'))
		]
	}

	@Test def void testGeneratedJavaFromSeveralInputs() throws Exception {
		#[
		'''
			entity Foo {
				bar : Bar
				op doStuff(String x) : String {
					return x + ' ' + bar.getName()
				}
			}
		''',
		'''
			entity Bar {
				name : String
			}
		'''
		].compile [
			val barObj = it.getCompiledClass("Bar").getDeclaredConstructor().newInstance
			barObj.invoke('setName', 'Bar')
			val fooObj = it.getCompiledClass("Foo").getDeclaredConstructor().newInstance
			fooObj.invoke('setBar', barObj)
			assertEquals("Hello Bar", fooObj.invoke('doStuff','Hello'))
		]
	}

	@Test def void compareGeneratedJava() throws Exception {
		'''
			entity Foo {
				name : String
			}
		'''.compile[assertEquals('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Foo() {
			  }
			
			  public Foo(final Procedure1<Foo> initializer) {
			    initializer.apply(this);
			  }
			
			  private String name;
			
			  public String getName() {
			    return this.name;
			  }
			
			  public void setName(final String name) {
			    this.name = name;
			  }
			
			  @Override
			  public String toString() {
			    String result = new ToStringBuilder(this).addAllFields().toString();
			    return result;
			  }
			}
		'''.toString, getSingleGeneratedCode)
		]
	}

	@Test def void testGeneratedJavaWithOverloadedMethods() throws Exception {
		'''
			entity Foo {
				op doStuff(String x) : String {
					return x
				}
				op doStuff(int i) : String {
					return "int "+i
				}
			}
		'''.compile [
			val obj = it.compiledClass.getDeclaredConstructor().newInstance
			assertEquals("Hello", obj.invoke('doStuff','Hello'))
			assertEquals("int 10", obj.invoke('doStuff',10))
		]
	}

	@Test def void testExplicitGetterReplacesGeneratedOne() throws Exception {
		'''
			entity Foo {
				name : String
				/** explicit getter will replace the generated one */
				op getName() {
					name.toFirstUpper
				}
			}
		'''.compile[
			assertEquals('''
				import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
				import org.eclipse.xtext.xbase.lib.StringExtensions;
				import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
				
				@SuppressWarnings("all")
				public class Foo {
				  public Foo() {
				  }
				
				  public Foo(final Procedure1<Foo> initializer) {
				    initializer.apply(this);
				  }
				
				  private String name;
				
				  public void setName(final String name) {
				    this.name = name;
				  }
				
				  /**
				   * explicit getter will replace the generated one
				   */
				  public String getName() {
				    return StringExtensions.toFirstUpper(this.name);
				  }
				
				  @Override
				  public String toString() {
				    String result = new ToStringBuilder(this).addAllFields().toString();
				    return result;
				  }
				}
			'''.toString, getSingleGeneratedCode
			)
			// make sure it compiles in Java
			val obj = it.compiledClass.getDeclaredConstructor().newInstance
			obj.invoke('setName', "hello")
			assertEquals("Hello", obj.invoke('getName'))
		]
	}

	@Test def void testExplicitSetterReplacesGeneratedOne() throws Exception {
		'''
			entity Foo {
				name : String
				/** explicit setter will replace the generated one,
					even if it's not void */
				op setName(String name) : String {
					this.name = name.toFirstUpper
				}
			}
		'''.compile[
			assertEquals('''
				import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
				import org.eclipse.xtext.xbase.lib.StringExtensions;
				import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
				
				@SuppressWarnings("all")
				public class Foo {
				  public Foo() {
				  }
				
				  public Foo(final Procedure1<Foo> initializer) {
				    initializer.apply(this);
				  }
				
				  private String name;
				
				  public String getName() {
				    return this.name;
				  }
				
				  /**
				   * explicit setter will replace the generated one,
				   * even if it's not void
				   */
				  public String setName(final String name) {
				    return this.name = StringExtensions.toFirstUpper(name);
				  }
				
				  @Override
				  public String toString() {
				    String result = new ToStringBuilder(this).addAllFields().toString();
				    return result;
				  }
				}
			'''.toString, getSingleGeneratedCode
			)
			// make sure it compiles in Java
			val obj = it.compiledClass.getDeclaredConstructor().newInstance
			assertEquals("Hello", obj.invoke('setName', "hello"))
			assertEquals("Hello", obj.invoke('getName'))
		]
	}

	@Test def void testExplicitGetterSetterReplaceGeneratedOnes() throws Exception {
		'''
			entity Foo {
				name : String
				/** explicit getter will replace the generated one */
				op getName() {
					name.toUpperCase
				}
				/** explicit setter will replace the generated one,
					even if it's not void */
				op setName(String name) : String {
					this.name = name.toFirstUpper
				}
			}
		'''.compile[
			assertEquals('''
				import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
				import org.eclipse.xtext.xbase.lib.StringExtensions;
				import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
				
				@SuppressWarnings("all")
				public class Foo {
				  public Foo() {
				  }
				
				  public Foo(final Procedure1<Foo> initializer) {
				    initializer.apply(this);
				  }
				
				  private String name;
				
				  /**
				   * explicit getter will replace the generated one
				   */
				  public String getName() {
				    return this.name.toUpperCase();
				  }
				
				  /**
				   * explicit setter will replace the generated one,
				   * even if it's not void
				   */
				  public String setName(final String name) {
				    return this.name = StringExtensions.toFirstUpper(name);
				  }
				
				  @Override
				  public String toString() {
				    String result = new ToStringBuilder(this).addAllFields().toString();
				    return result;
				  }
				}
			'''.toString, getSingleGeneratedCode
			)
			// make sure it compiles in Java
			val obj = it.compiledClass.getDeclaredConstructor().newInstance
			assertEquals("Hello", obj.invoke('setName', "hello"))
			assertEquals("HELLO", obj.invoke('getName'))
		]
	}
}