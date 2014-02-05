package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.xtend.XtendClass
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
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.junit.After
import org.junit.Test
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.junit.Ignore

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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val signature = signatureProvider.getSignature(clazz)
		assertEquals("Foo",signature)
	}
	
	@Test
	def testSignatureForXtendFunction(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(String a) throws NullPointerException { }
			def void bar(String a, int b) throws NullPointerException, RuntimeException {}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendField = clazz.members.get(0) as XtendField
		val signature = signatureProvider.getSignature(xtendField)
		assertEquals("Collections collections",signature)
	}
	
	@Test
	def testSignatureForXtendFieldWithoutTypeDeclaration(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		import java.util.Collections
		import com.google.inject.Inject

		class Foo {
			val collections = <String>newArrayList
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendField = clazz.members.get(0) as XtendField
		val signature = signatureProvider.getSignature(xtendField)
		assertEquals("ArrayList<String> collections",signature)
	}
	
	@Test
	def testSignatureForExtensionFieldWithoutName(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		import java.util.Collections
		import com.google.inject.Inject

		class Foo {
			extension String
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendField = clazz.members.get(0) as XtendField
		val signature = signatureProvider.getSignature(xtendField)
		assertEquals("String",signature)
	}
	
	@Test
	def testSignatureForXtendFieldWithoutNameOrType(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		import java.util.Collections
		import com.google.inject.Inject

		class Foo {
			val = ""
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendField = clazz.members.get(0) as XtendField
		val signature = signatureProvider.getSignature(xtendField)
		assertEquals("",signature)
	}
	
	@Test
	def testSignatureForXtendConstructor(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			new(String a, int b){}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val signature = signatureProvider.getSignature(clazz)
		assertEquals("Foo<T, Y>",signature)
	}

	@Test
	def testSignatureXtendConstructorWithGenerics_01(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<S extends CharSequence> {
			def bar() {
				new Foo()
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall.constructor)
		assertEquals("Foo<S extends CharSequence>()",signature)
	}

	@Test
	def testSignatureConstructorCall_01(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<S extends CharSequence> {
			def bar() {
				new Foo()
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall)
		assertEquals("Foo<CharSequence>()",signature)
	}
	
	@Test
	def testSignatureConstructorCall_02(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<S> {
			def bar() {
				new Foo(StringBuilder, StringBuffer)
			}
			new <X>(Class<X> c, Class<S> c2) {}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall)
		assertEquals("<StringBuilder> Foo<StringBuffer>(Class<StringBuilder> c, Class<StringBuffer> c2)",signature)
	}
	
	@Test
	def testSignatureConstructorCall_03(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<S> {
			def bar() {
				new Foo<String>()
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val constructorCall = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XConstructorCall
		val signature = signatureProvider.getSignature(constructorCall)
		assertEquals("Foo<String>()",signature)
	}
	
	@Ignore
	@Test
	def testSignatureDelegateConstructorCall_01(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<S extends CharSequence> {
			new(int i) {
				this()
			}
			new() {}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendConstructor = clazz.members.get(0) as XtendConstructor
		val featureCall = (xtendConstructor.expression as XBlockExpression).expressions.get(0) as XFeatureCall
		val signature = signatureProvider.getSignature(featureCall)
		assertEquals("Foo<S>()",signature)
	}
	
	@Ignore
	@Test
	def testSignatureDelegateConstructorCall_02(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo<S extends CharSequence> {
			new(int i) {
				this(StringBuilder)
			}
			new<X>(Class<X> c) {}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendConstructor = clazz.members.get(0) as XtendConstructor
		val featureCall = (xtendConstructor.expression as XBlockExpression).expressions.get(0) as XFeatureCall
		val signature = signatureProvider.getSignature(featureCall)
		assertEquals("Foo<S>()",signature)
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
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
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val xtendFunction = clazz.members.get(0) as XtendFunction
		val variable = (xtendFunction.expression as XBlockExpression).expressions.get(0) as XVariableDeclaration
		val signature = signatureProvider.getSignature(variable)
		assertEquals("String a", signature)
	}
	
	@Test
	def testBug378082(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		@Data
		class Foo {
			int id

			def dispatch void a(int i){}
			def dispatch void a(int i){}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val field = clazz.members.head
		val function = clazz.members.get(1);
		val fieldSignature = signatureProvider.getSignature(field)
		assertEquals("int id", fieldSignature)
		val  functionSignature = signatureProvider.getSignature(function);
		assertEquals("void a(int i)", functionSignature)
	}

	@Test
	def testBug379019(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def error() {
				val start = System::currentTimeMillis()
				var time = System::currentTimeMillis() - start
				time
			}
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val function = clazz.members.head
		val signature = signatureProvider.getSignature(function)
		EcoreUtil::resolveAll(xtendFile)
		assertEquals("long error()", signature)
	}
	
	@Test
	def testEnumDeclaration(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		enum Foo { BAR, BAZ }
		''',resourceSet)
		val en = xtendFile.xtendTypes.head
		assertEquals("Foo", signatureProvider.getSignature(en))
	}

	@Test
	def testEnumReference(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Bar {
			def baz(Foo f){}
		}
		enum Foo { BAR, BAZ }
		''',resourceSet)
		val en = (xtendFile.xtendTypes.head.members.head as XtendFunction).parameters.head.parameterType.type
		assertEquals("Foo", signatureProvider.getSignature(en))
	}

	@Test
	def testInterfaceDeclaration(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		interface Foo { }
		''',resourceSet)
		val in = xtendFile.xtendTypes.head
		assertEquals("Foo", signatureProvider.getSignature(in))
	}

	@Test
	def testInterfaceReference(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Bar implements Foo {

		}
		interface Foo { }
		''',resourceSet)
		val in = (xtendFile.xtendTypes.head as XtendClass).^implements.head.type
		assertEquals("Foo", signatureProvider.getSignature(in))
	}

	@Test
	def testAnnotationDeclaration(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		annotation Foo { }
		''',resourceSet)
		val in = xtendFile.xtendTypes.head
		assertEquals("Foo", signatureProvider.getSignature(in))
	}

	@Test
	def testAnnotationReference(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		@Foo
		class Bar {}
		annotation Foo { }
		''',resourceSet)
		val in = (xtendFile.xtendTypes.head as XtendClass).annotations.head.annotationType
		assertEquals("Foo", signatureProvider.getSignature(in))
	}

	@Test
	def test381185(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo{
			Bar b
			def bar(){ 
				b.foo
			}
		}
		class Bar {
			Foo f
			def foo() {
				f.bar
			}
		}
		
		''',resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass)).head
		val clazz2 = xtendFile.getXtendTypes.filter(typeof(XtendClass)).drop(1).head
		val function1 = clazz.members.get(1) as XtendFunction
		val function2 = clazz2.members.get(1) as XtendFunction
		val expression1 = function1.expression as XBlockExpression
		val expression2 = function2.expression as XBlockExpression
		val call1 = expression1.expressions.get(0) as XMemberFeatureCall
		val call2 = expression2.expressions.get(0) as XMemberFeatureCall
		assertEquals("Object Bar.foo()",signatureProvider.getSignature(call1.feature))
		assertEquals("Object Foo.bar()",signatureProvider.getSignature(call2.feature))
		assertEquals("Bar Foo.b", signatureProvider.getSignature((call1.memberCallTarget as XFeatureCall).feature))
		assertEquals("Foo Bar.f", signatureProvider.getSignature((call2.memberCallTarget as XFeatureCall).feature))
		
	}

	def getResourceSet(){
		getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project)
	}
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}
}