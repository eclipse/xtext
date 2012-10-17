/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.macro.lang.tests

import com.google.common.util.concurrent.FutureCallback
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(MacroInjectorProvider))
class ProcessingTest {
	
	@Inject extension CompilationTestHelper
	@Inject extension MacroTestExtensions 
	
	@Test def void testProcessing_01() {
		resourceSet('''
				@AsInterface
				abstract class MyClass {
					def String sayHi()
				}
			'''.xtend,
			'''
				@AsInterface for class {
					process {
						for (e : elements) {
							with(e.name) [
								interface = true
								^abstract = false
								superTypes.clear
							]
						}
					}
				}
			'''.macro
		).compile [
			val clazz = getCompiledClass('MyClass')
			assertNotNull(clazz)
			assertTrue(clazz.isInterface)
		]
	}
	
	
	@Test def void testProcessing_02() {
		resourceSet('''
				@WithStringField('hello')
				class MyClass {
				}
				@WithStringField
				class MyClass2 {
				}
			'''.xtend,
			'''
				@WithStringField for class {
					
					static String value = 'foo'
					
					process {
						for (e : elements) {
							with(e.name) [
								field(value(e), <String>type)
							]
						}
					}
				}
			'''.macro
		).compile [
			val myClass = getCompiledClass('MyClass')
			assertNotNull(myClass.getDeclaredField('hello'))
			val myClass2 = getCompiledClass('MyClass2')
			assertEquals(typeof(String), myClass2.getDeclaredField('foo').type)
		]
	}
	
	@Test def void testProcessing_03() {
		resourceSet('''
				package foo
				
				@GWTService
				class AsyncTest {
					
					override String myService(String x) {
						x.toUpperCase
					}
					
					override boolean anotherFunc(Iterable<Boolean> trues) {
						trues.head
					}
				}
			'''.xtend,
			'''
				package foo
				
				import org.eclipse.xtend.core.xtend.XtendFunction
				import com.google.common.util.concurrent.FutureCallback
				
				@GWTService for class {
				
				  register {
				  	elements.forEach [
					  	registerInterface(source.^package + "." + name + "InterfaceAsync")
						registerInterface(source.^package + "." + name + "Interface")
				  	]
				  }
				
				  process {
				  	elements.forEach [
						with(source.^package + "." + name + "InterfaceAsync") [ asyncInterface |
						  for (m : members.filter(typeof(XtendFunction))) {
						    method (m.name, type(Void::TYPE)) [
						      m.parameters.forEach [ param(name, parameterType) ]
						      param('result', type( typeof(FutureCallback), m.returnType))
						    ]
						  }
						]
						
						with(source.^package + "." + name + "Interface") [ interface |
							for (m : members.filter(typeof(XtendFunction))) {
								method (m.name, m.returnType) [
							    	m.parameters.forEach [ param(name, parameterType) ]
							  	]
							}
							with(source.^package + "." + name) [ mainType |
								mainType.superTypes += type(interface)
							]
						]
				  	]
				  }
				}
			'''.macro
		).compile [
			val myClass = getCompiledClass('foo.AsyncTest')
			assertNotNull(myClass)
			val interf = getCompiledClass('foo.AsyncTestInterface')
			assertSame( myClass.interfaces.get(0), interf )
			
			val asyncInterf = getCompiledClass('foo.AsyncTestInterfaceAsync')
			assertNotNull(asyncInterf.getMethod("myService", newArrayList(typeof(String), typeof(FutureCallback)) as Class<?>[]))
		]
	}
	
	@Test def void testProcessingWithClassFunction_01() {
		resourceSet('''
				package foo
				
				import anotherPack.MyService
				
				@MyService
				class MyClass {
					
				}
			'''.xtend,
			'''
				package anotherPack
				
				import org.eclipse.xtend.core.xtend.XtendClass
				import org.eclipse.xtend.core.xtend.XtendFile
				import static extension anotherPack.HelperClass.*
				
				class HelperClass {
					
					def static String interfaceName(XtendClass it) {
						it.qualifiedName + "Interface"
					}
					
					def static String qualifiedName(XtendClass it) {
						(eContainer as XtendFile).^package + "." + name
					}
				}
				
				@MyService for class {
				
				  register {
				  	elements.forEach [e |
					  	registerInterface(e.interfaceName)
				  	]
				  }
				
				  process {
				  	elements.forEach [ e |
						with(e.qualifiedName) [
						  superTypes += type(e.interfaceName)
						]
				  	]
				  }
				}
			'''.macro
		).compile [
			val myClass = getCompiledClass('foo.MyClass')
			assertNotNull(myClass)
			val interf = getCompiledClass('foo.MyClassInterface')
			assertSame( myClass.interfaces.get(0), interf )
		]	
	}
	
	
	@Test def void testProcessingWithClassFunction_02() {
		resourceSet('''
				package foo
				
				import anotherPack.MyService
				
				@MyService
				class MyClass {
					
				}
			'''.xtend,
			'MyService.macro' -> '''
				package anotherPack
				
				import static extension anotherPack.HelperClass.*
				
				@MyService for class {
				
				  register {
				  	elements.forEach [e |
					  	registerInterface(e.interfaceName)
				  	]
				  }
				
				  process {
				  	elements.forEach [ e |
						with(e.qualifiedName) [
						  superTypes += type(e.interfaceName)
						]
				  	]
				  }
				}
			''',
			'HelperClass.macro' ->'''
				package anotherPack
				
				import org.eclipse.xtend.core.xtend.XtendClass
				import org.eclipse.xtend.core.xtend.XtendFile
				import static extension anotherPack.HelperClass.*
				
				class HelperClass {
					
					def static String interfaceName(XtendClass it) {
						it.qualifiedName + "Interface"
					}
					
					def static String qualifiedName(XtendClass it) {
						(eContainer as XtendFile).^package + "." + name
					}
				}
			'''
		).compile [
			val myClass = getCompiledClass('foo.MyClass')
			assertNotNull(myClass)
			val interf = getCompiledClass('foo.MyClassInterface')
			assertSame( myClass.interfaces.get(0), interf )
		]	
	}
	
	@Test def void testFields() {
		resourceSet('''
				package foo
				
				import anotherPack.MyService
				
				@MyService(specialClass=typeof(String))
				class MyClass {
					
				}
			'''.xtend,
			'MyService.macro' -> '''
				package anotherPack
				
				@MyService for class {
				
				  static Class<?> specialClass
				  static String value = 'foo'
				
				  process {
				  	elements.forEach [ e |
						with('foo.MyClass') [
						    field(value(e), type(specialClass(e)))
						]
				  	]
				  }
				}
			'''
		).compile [
			val myClass = getCompiledClass('foo.MyClass')
			assertNotNull(myClass)
			assertTrue(myClass.getDeclaredField('foo').type == typeof(String))
		]	
	}
	
	@Test def void testFields_2() {
		resourceSet('''
				package foo
				
				import anotherPack.MyService
				
				@MyService("myField")
				class MyClass {
					
				}
			'''.xtend,
			'MyService.macro' -> '''
				package anotherPack
				
				@MyService for class {
				
				  static Class<?> specialClass = typeof(Boolean)
				  static String value = 'foo'
				
				  process {
				  	elements.forEach [ e |
						with('foo.MyClass') [
						    field(value(e), type(specialClass(e)))
						]
				  	]
				  }
				}
			'''
		).compile [
			val myClass = getCompiledClass('foo.MyClass')
			assertNotNull(myClass)
			assertTrue(myClass.getDeclaredField('myField').type == typeof(Boolean))
		]	
	}
	
}