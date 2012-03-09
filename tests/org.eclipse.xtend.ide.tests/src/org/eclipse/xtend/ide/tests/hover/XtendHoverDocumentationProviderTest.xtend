package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.hover.XtendHoverDocumentationProvider
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.junit.After
import org.junit.Test

import static org.junit.Assert.*

class XtendHoverDocumentationProviderTest extends AbstractXtendUITestCase {
	
	@Inject
	private ParseHelper<XtendFile> parseHelper
	
	@Inject
	private WorkbenchTestHelper testHelper
	
	@Inject
	private XtendHoverDocumentationProvider documentationProvider
	
	@Test
	def testSimpleJavaDocWithMixedParameters(){
	
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* @param a something
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals("SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b>  something</dd><dd><b>b</b> </dd></dl>",docu)
	}
	
	@Test
	def testSimpleJavaDocWithSeeAndAuthor(){
	
		val xtendFile = parseHelper.parse('''
		package testpackage
		import java.util.Collections
		class Foo {
			
			/**
			* SimpleJavaDoc
			* @see Collections
			* @see java.util.List
			* @author FooBar
			* @since 2.3
			* @deprecated
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''<p><b>Deprecated.</b> <i></i></p>SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd><dt>Since:</dt><dd> 2.3</dd><dt>Author:</dt><dd> FooBar</dd><dt>See Also:</dt><dd><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections">Collections</a></dd><dd><a href="eclipse-xtext-doc:java:/Objects/java.util.List%23java.util.List">java.util.List</a></dd></dl>'''.toString, docu)
	}
	
	@Test
	def testSimpleJavaDocWithMixedExceptions(){
	
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* @throws NullPointerException not so good
			*/
			def bar(String a, String b) throws NullPointerException, RuntimeException{
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc<dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd><dt>Throws:</dt><dd><a href="eclipse-xtext-doc:java:/Objects/java.lang.NullPointerException%23java.lang.NullPointerException">NullPointerException</a> -  not so good</dd><dd><a href="eclipse-xtext-doc:java:/Objects/java.lang.RuntimeException%23java.lang.RuntimeException">RuntimeException</a></dd></dl>'''.toString,docu)
	
	}
	
	@Test
	def testJavaDocWithLinkWithOutLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)

		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections">java.util.Collections</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkWithLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections label foo bar}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections"> label foo bar</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithBrokenLink(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link Collections}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code>Collections</code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkToMethodWithoutLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections#sort(java.util.List)}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections.sort(java.util.List)">java.util.Collections#sort(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkToMethodWithLabel(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link java.util.Collections#sort(java.util.List) label foo bar}
			*/
			def bar(String a, String b){
			}
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:java:/Objects/java.util.Collections%23java.util.Collections.sort(java.util.List)"> label foo bar</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString,docu)
	}
	
	@Test
	def testJavaDocWithLinkToXtendFunction(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		import java.util.List
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link testpackage.Foo#foo(java.util.List)}
			*/
			def bar(String a, String b){
			}
			
			def foo(List a)
		}
		''',resourceSet)
		val member = xtendFile.xtendClass.members.get(0)
		val docu = documentationProvider.getDocumentation(member)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2">testpackage.Foo#foo(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
	}
	
	@Test
	def testJavaDocWithLinkToXtendFunctionOnReference(){
		val xtendFile = parseHelper.parse('''
		package testpackage
		
		import java.util.List
		
		class Foo {
			
			/**
			* SimpleJavaDoc
			* {@link testpackage.Foo#foo(java.util.List)}
			*/
			def bar(String a, String b){
			}
			
			def foo(List a){
				bar("42","43")
		}
		''',resourceSet)
		val function = xtendFile.xtendClass.members.get(1) as XtendFunction
		val call = (function.expression as XBlockExpression).expressions.get(0) as XAbstractFeatureCall
		val docu = documentationProvider.getDocumentation(call.feature)
		assertEquals('''SimpleJavaDoc
<code><a href="eclipse-xtext-doc:__synthetic0.xtend%23/1/@members.2">testpackage.Foo#foo(java.util.List)</a></code><dl><dt>Parameters:</dt><dd><b>a</b> </dd><dd><b>b</b> </dd></dl>'''.toString, docu)
	}
	
	def getResourceSet(){
		getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project)
	}
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}
}