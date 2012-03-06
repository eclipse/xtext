package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.junit.After
import org.eclipse.xtend.ide.hover.XtendHoverSignatureProvider
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendField
import org.junit.Before
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XConstructorCall

class XtendHoverSignatureProviderTest extends AbstractXtendUITestCase {
	@Inject
	private ParseHelper<XtendFile> parseHelper;
	
	@Inject
	private WorkbenchTestHelper testHelper
	
	@Inject
	private XtendHoverSignatureProvider signatureProvider
	
	@Test
	def testSignatureForXtendClass(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
		}
		''', resourceSet)
		val clazz = xtendFile.xtendClass
		val signature = signatureProvider.getSignature(clazz)
		assertEquals("Foo",signature)
	}
	
	@Test
	def testSignatureForXtendFunction(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(String a) throws NullPointerException
			def void bar(String a, int b) throws NullPointerException, RuntimeException
		}
		''', resourceSet)
		val clazz = xtendFile.xtendClass
		val xtendFunction1 = clazz.members.get(0)
		val xtendFunction2 = clazz.members.get(1)
		val signature1 = signatureProvider.getSignature(xtendFunction1)
		val signature2 = signatureProvider.getSignature(xtendFunction2)
		assertEquals("Object bar(String a) throws NullPointerException",signature1)
		assertEquals("void bar(String a, int b) throws NullPointerException, RuntimeException",signature2)
	}
	
	@Test
	def testSignatureForXtendParameter(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(String a) throws NullPointerException
		}
		''', resourceSet)
		val clazz = xtendFile.xtendClass
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val xtendParameter = xtendFunction.parameters.get(0)
		val signature = signatureProvider.getSignature(xtendParameter)
		assertEquals("String a - bar(String)",signature)
	}
	
	@Test
	def testSignatureForXtendField(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		import java.util.Collections
		import com.google.inject.Inject
		

		class Foo {
			@Inject
			Collections collections
			
			def bar(String a) throws NullPointerException
		}
		''', resourceSet)
		val clazz = xtendFile.xtendClass
		val xtendField = clazz.members.get(0) as XtendField
		val signature = signatureProvider.getSignature(xtendField)
		assertEquals("Collections collections",signature)
	}
	
	@Test
	def testSignatureForXtendConstructor(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			new(String a, int b){}
		}
		''', resourceSet)
		val clazz = xtendFile.xtendClass
		val xtendConstructor = clazz.members.get(0)
		val signature = signatureProvider.getSignature(xtendConstructor)
		assertEquals("Foo (String a, int b)",signature)
	}
	
	@Test
	def testSignatureForXtendDefaultConstructor(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(){
			new Foo()
			}
		}
		''', resourceSet)
		val clazz = xtendFile.xtendClass
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall.constructor)
		assertEquals("Foo ()",signature)
	}
	
	def getResourceSet(){
		getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project)
	}
	
	@Before
	
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}
}