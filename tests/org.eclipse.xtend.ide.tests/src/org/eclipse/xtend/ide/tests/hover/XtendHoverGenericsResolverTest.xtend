package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider
import org.junit.After
import org.junit.Test

class XtendHoverGenericsResolverTest extends AbstractXtendUITestCase {
	@Inject
	private ParseHelper<XtendFile> parseHelper;
	
	@Inject
	private WorkbenchTestHelper testHelper
	
	@Inject
	private XbaseDeclarativeHoverSignatureProvider signatureProvider;
	
	@Test
	def testGenerics_1(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(){
				newArrayList("sd").something
			}
			
			def <T> T something(Iterable<T> iterable)
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass))
		val function = clazz.head.members.get(0) as XtendFunction
		val expression = function.expression as XBlockExpression
		val call = expression.expressions.get(0) as XAbstractFeatureCall
		val resolvedSignature = signatureProvider.getSignature(call)
		assertEquals("<String> String Foo.something(Iterable<String> iterable)", resolvedSignature)
	}
	
	@Test
	def testGenerics_2(){
		val xtendFile = parseHelper.parse('''
		package testPackage
		class Foo {
			def bar(){
				something(newArrayList("zonk"), new Foo(),"42")
			}
			
			def <T,Y,E extends RuntimeException> Y something(Iterable<T> iterable, Y type1, T type2) throws E
		}
		''', resourceSet)
		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass))
		val function = clazz.head.members.get(0) as XtendFunction
		val expression = function.expression as XBlockExpression
		val call = expression.expressions.get(0) as XAbstractFeatureCall
		val resolvedSignature = signatureProvider.getSignature(call)
		assertEquals("<String, Foo, RuntimeException> Foo Foo.something(Iterable<String> iterable, Foo type1, String type2) throws RuntimeException", resolvedSignature)
	}
	
//	@Test
//	def testGenerics_in_html_from_Java(){
//		val xtendFile = parseHelper.parse('''
//		package testPackage
//		class Foo {
//			def bar(){
//				newArrayList("sd").head
//			}
//		}
//		''', resourceSet)
//		val clazz = xtendFile.getXtendTypes.filter(typeof(XtendClass))
//		val function = clazz.head.members.get(0) as XtendFunction
//		val expression = function.expression as XBlockExpression
//		val call = expression.expressions.get(0) as XAbstractFeatureCall
//		val feature = call.getFeature()
//		val javaElement = javaElementFinder.findElementFor(feature)
//		val prefix = "something <T>T<T>T this is html"
//		val suffix = " and at the END TOOOOOOOO"
//		val originalSignature =  hoverGenericsResolver.getJavaSignature(javaElement)
//		assertEquals(prefix + originalSignature.replaceAll("\\bT\\b","String") + suffix, hoverGenericsResolver.resolveSignatureInHtml(call, javaElement, prefix + originalSignature + suffix))
//	}
	
	def getResourceSet(){
		getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project)
	}
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}
}