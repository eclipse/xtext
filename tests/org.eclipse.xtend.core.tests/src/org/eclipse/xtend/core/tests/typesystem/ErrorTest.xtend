/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.XAssignment
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ErrorTest extends AbstractXtendTestCase {
	
	@Inject
	IResourceValidator resourceValidator
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Inject
	IJvmModelAssociations associations
	
	@Test
	def void testErrorModel_01() throws Exception {
		'''
			import static extension Throwables.*
			import java.net.URI
			
			class Client {
				val uri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
			}
			class Throwables {
				def static <T> T propagate((
		'''.processWithoutException
	}
	
	@Test
	def void testErrorModel_02() throws Exception {
		val file = '''
			class TestXtend {
				val static int a = 4
				
				@
		'''.processWithoutException
		val clazz = file.xtendTypes.head as XtendClass
		val lastMember = clazz.members.last
		val annotations = lastMember.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_03() throws Exception {
		val file = '''
			class TestXtend {
				val static int a = 4
				
				@Click({ a, a })
				d
		'''.processWithoutException
		val clazz = file.xtendTypes.head as XtendClass
		val lastMember = clazz.members.last
		val annotations = lastMember.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_04() throws Exception {
		val file = '''
			class TestXtend {
				val static int a = 4
				
				@Click({ a, a })
				def m
		'''.processWithoutException
		val clazz = file.xtendTypes.head as XtendClass
		val lastMember = clazz.members.last
		val annotations = lastMember.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_05() throws Exception {
		val file = '''
			@
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.head
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_06() throws Exception {
		val file = '''
			@Data class A {}
			@
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_07() throws Exception {
		val file = '''
			@Data class A {}
			@Data class
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_08() throws Exception {
		val file = '''
			annotation Bar { @
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.members.last.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_09() throws Exception {
		val file = '''
			class X {
				@Property val S
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.members.last.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_10() throws Exception {
		val file = '''
			@SuppressWarnings("unused"
		'''.processWithoutException
		val typeDeclaration = file.xtendTypes.last
		val annotations = typeDeclaration.annotations
		val resolvedTypes = typeResolver.resolveTypes(annotations.head)
		assertNotNull(resolvedTypes.getActualType(annotations.head))
	}
	
	@Test
	def void testErrorModel_11() throws Exception {
		val file = '''
			annotation { 
				val inferred = 'bar'
			}
		'''.processWithoutException
		val annotation = file.xtendTypes.last
		val field = annotation.members.head as XtendField
		val initializer = field.initialValue
		val resolvedTypes = typeResolver.resolveTypes(initializer)
		assertNotNull(resolvedTypes.getActualType(initializer))
	}
	
	@Test
	def void testErrorModel_12() throws Exception {
		val file = '''
			class Y {
			 static def <T> IExpectationSetters<T> expect(T value) {
			 }
			 HeaderAccess<?> unboundedMockHeaderAccess
			 def test() {
			   val Object header = unboundedMockHeaderAccess.header
			   val IExpectationSettersObject> exp1 = expect(header)
			   val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())
			 }
			}
			interface HeaderAccess<T> {
			   def T getHeader();
			}
			interface IExpectationSetters<T> {}
		'''.processWithoutException
		val y = file.xtendTypes.head
		val exp1 = y.members.get(3) as XtendField // error recovery parses two fields after the function #test
		val initializer = exp1.initialValue
		val resolvedTypes = typeResolver.resolveTypes(initializer)
		assertNotNull(resolvedTypes.getActualType(initializer))
	}
	
	@Test
	def void testErrorModel_13() throws Exception {
		val file = '''
			class Y {
			 static def <T> IExpectationSetters<T> expect(T value) {
			 }
			 HeaderAccess<?> unboundedMockHeaderAccess
			 def test() {
			   val Object header = unboundedMockHeaderAccess.header
			   val IExpectationSetters<Object> exp1 = expect(header)
			   val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())
			 }
			}
			interface IExpectationSetters<T> {}
			interface HeaderAccess<T> {
			   def  getHeader();
			}
		'''.processWithoutException
		val headerAccess = file.xtendTypes.last
		val function = headerAccess.members.head as XtendFunction // error recovery parses two fields after the function #test
		val operation = associations.getJvmElements(function).head as JvmOperation
		val resolvedTypes = typeResolver.resolveTypes(operation)
		assertNotNull(resolvedTypes.getActualType(operation))
	}
	
	@Test
	def void testErrorModel_14() throws Exception {
		val file = '''
			class B extends  {
				override foo(String x, String...args) {
					return x
				}
			}
			abstract class A {
				def String foo(String x, String...args)
			}
		'''.processWithoutException
		val headerAccess = file.xtendTypes.last
		val function = headerAccess.members.head as XtendFunction // error recovery parses two fields after the function #test
		val operation = associations.getJvmElements(function).head as JvmOperation
		val resolvedTypes = typeResolver.resolveTypes(operation)
		assertNotNull(resolvedTypes.getActualType(operation))
	}
	
	@Test
	def void testErrorModel_15() throws Exception {
		val file = '''
			@ class Node {
			}
		'''.processWithoutException
		val node = file.xtendTypes.head
		val annotation = node.annotations.head
		val resolvedTypes = typeResolver.resolveTypes(annotation)
		assertNotNull(resolvedTypes.getActualType(annotation))
	}
	
	@Test
	def void testErrorModel_16() throws Exception {
		val file = '''
			class <T> {
				val String s
			    new(String ^new) {
			        s = ^new
			    }
			}
		'''.processWithoutException
		val unnamed = file.xtendTypes.head
		val constructor = unnamed.members.last as XtendConstructor
		val body = constructor.expression as XBlockExpression
		val assignment = body.expressions.head as XAssignment
		val resolvedTypes = typeResolver.resolveTypes(assignment)
		assertNotNull(resolvedTypes.getActualType(assignment))
	}
	
	@Test
	def void testErrorModel_17() throws Exception {
		val file = '''
			import static extension Throwables.*
			import java.net.URI
			
			class Throwables {
				def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {
					try {
						proc.apply
					} catch(Exception e) {
						throw handler.apply(e)
					}
				}
			}
			class Client {
				valuri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
			}
		'''.processWithoutException
		val client = file.xtendTypes.last
		val field = client.members.head as XtendField
		val initializer = field.initialValue as XMemberFeatureCall
		val closure = initializer.memberCallArguments.head as XClosure
		val implicit = closure.implicitParameter
		assertNotNull(implicit)
		val resolvedTypes = typeResolver.resolveTypes(implicit)
		assertNotNull(resolvedTypes.getActualType(implicit))
	}
	
	@Test
	def void testErrorModel_18() throws Exception {
		val file = '''
			class C {
				def m(@
		'''.processWithoutException
		val c = file.xtendTypes.head
		val function = c.members.head as XtendFunction
		val param = function.parameters.head
		val annotation = param.annotations.head
		val resolvedTypes = typeResolver.resolveTypes(annotation)
		assertNotNull(resolvedTypes.getActualType(annotation))
	}
	
	@Test
	def void testErrorModel_19() throws Exception {
		val file = '''
			package x
			import bug396879.*
			class Z {
			  	def addListeners(BooleanProperty prop) {
					val ChangeListenerBoolean> listener = [ p, oldValue, newValue | ]		prop.addListener(listener)
				}
			}
		'''.processWithoutException
		val z = file.xtendTypes.head
		val field = z.members.get(1) as XtendField
		val closure = field.initialValue as XClosure
		val param = closure.declaredFormalParameters.head
		val resolvedTypes = typeResolver.resolveTypes(param)
		assertNotNull(resolvedTypes.getActualType(param))
	}
	
	@Test
	def void testErrorModel_20() throws Exception {
		val file = '''
			package x
			class Y {
				@com.google.inject.Inject extension test.GenericExtensionMethods<String,Integer> x
				def foo(String arg) {
					arg.method
				}
			}
		'''.processWithoutException
		val y = file.xtendTypes.head
		val function = y.members.last as XtendFunction
		val body = function.expression as XBlockExpression
		val featureCall = body.expressions.head as XMemberFeatureCall
		val implicitReceiver = featureCall.implicitReceiver as XMemberFeatureCall
		val this_ = implicitReceiver.memberCallTarget
		val resolvedTypes = typeResolver.resolveTypes(this_)
		assertNotNull(resolvedTypes.getActualType(this_))
	}
	
	def processWithoutException(CharSequence input) throws Exception {
		val resource = resourceSet.createResource(URI::createURI("abcdefg.xtend"))
		resource.load(new StringInputStream(input.toString), null)
		resourceValidator.validate(resource, CheckMode::ALL, CancelIndicator::NullImpl)
		return resource.contents.head as XtendFile
	}
	
}