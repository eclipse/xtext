package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.hover.XtendHoverSignatureProvider
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.junit.After
import org.junit.Test

import static org.junit.Assert.*

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
		val clazz = xtendFile.getXtendClasses.head
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
		val clazz = xtendFile.getXtendClasses.head
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
		val clazz = xtendFile.getXtendClasses.head
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
		val clazz = xtendFile.getXtendClasses.head
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
		val clazz = xtendFile.getXtendClasses.head
		val xtendConstructor = clazz.members.get(0)
		val signature = signatureProvider.getSignature(xtendConstructor)
		assertEquals("Foo(String a, int b)",signature)
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
		val clazz = xtendFile.getXtendClasses.head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall.constructor)
		assertEquals("Foo()",signature)
	}
	
	@Test
	def testDeclarationOfClazzWithGenrics(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<T,Y> {}
		''',resourceSet)
		val clazz = xtendFile.xtendClasses.head
		val signature = signatureProvider.getSignature(clazz)
		assertEquals("Foo<T, Y>",signature)
	}

	@Test
	def testSignatureForXtendDefaultConstructorWithGenerics(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<String> {
			def bar(){
			new Foo()
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendClasses.head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall.constructor)
		assertEquals("Foo<String>()",signature)
	}
	
	@Test
	def testSignatureForForLoopVariable(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		import java.util.List
		class Foo {
				def bar(List<String> list){
					for(foo : list){
					
					}
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendClasses.head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val param = ((xtendFunction.expression as XBlockExpression).expressions.get(0) as XForLoopExpression).declaredParam
		val signature = signatureProvider.getSignature(param)
		assertEquals("String foo", signature)
	}
	
	@Test
	def testSignatureForForXClosureVariable(){
		val xtendFile = parseHelper.parse('''
			package testPackage
			class Foo {
				def zonk(){
					bar(s | s + "42")
				}
				def bar((String)=>String fun){
					
				}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendClasses.head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val closure = ((xtendFunction.expression as XBlockExpression).expressions.get(0) as XFeatureCall).featureCallArguments.get(0) as XClosure
		val param = closure.declaredFormalParameters.get(0)
		val signature = signatureProvider.getSignature(param)
		assertEquals("String s", signature)
	}
	
	@Test
	def testSignatureForXVariableDeclaration(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(List<String> list){
				val a = "42"
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendClasses.head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val variable = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XVariableDeclaration
		val signature = signatureProvider.getSignature(variable)
		assertEquals("String a", signature)
	}
	
	def getResourceSet(){
		getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project)
	}
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}
}