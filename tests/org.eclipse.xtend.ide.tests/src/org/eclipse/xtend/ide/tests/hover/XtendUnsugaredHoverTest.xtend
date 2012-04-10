package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.hover.XtendHoverSerializer
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.xbase.XBlockExpression
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtend.ide.tests.hover.XtendUnsugaredHoverTest.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.junit.Assert.*

class XtendUnsugaredHoverTest extends AbstractXtendUITestCase {
	 
	@Inject
	private WorkbenchTestHelper testHelper
	
	@Inject
	private XtendHoverSerializer serializer
	
	private static String FILEEXTENSION = ".xtend"
	private static String FILEPATH = "testpackage/Foo" + FILEEXTENSION
	

	@Before
	def void createExtensionClass() throws Exception {
		testHelper.createFile("testpackage/Extension" + FILEEXTENSION, '''
			package testpackage
			import java.util.List
			class Extension {
				def bar(Integer p1, Integer p2)
				
				def barCharSequence(Integer p1, CharSequence c)
				
				def bar(List<String list, Integer a)
				
				def static String setZonk(String s, String s2) {
					s + s2
				}
			}
			
			'''.toString
		);
		
		testHelper.createFile("testpackage/ExtensionJava.java", '''
			package testpackage;
			public class ExtensionJava {
				public void bar(Integer p1, Integer p2){
					
				}
			}
			
			'''.toString
		);
	}
	
	@After
	def void cleanup(){
		testHelper.tearDown
	}

	@Test
	def void testUnsuagaredVersionForXtendFunction() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH,''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(42)	
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extension.bar(it, 42)",serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_2() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(it, 42)	
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extension.bar(it, 42)",serializer.computeUnsugaredExpression(call))
	}
	
		@Test
	def void testUnsuagaredVersionForXtendFunction_3() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				val a = 42
				bar(it, 42 + a)	
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(1)
		assertEquals("_extension.bar(it, 42 + a)", serializer.computeUnsugaredExpression(call))
	}

	@Test
	def void testUnsuagaredVersionForXtendFunction_4() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH,  ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(it, 40 + 2)	
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extension.bar(it, 40 + 2)", serializer.computeUnsugaredExpression(call))
	}
	
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_5() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH,  ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				new ArrayList<String>().bar(42)
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extension.bar(new ArrayList<String>(), 42)",  serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_6() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(new ArrayList<String>(), 42)
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extension.bar(new ArrayList<String>(), 42)", serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_7() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				barCharSequence(42, «"'''"»   Test   Test
		Test«"'''"»)
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals('''_extension.barCharSequence(42, «"'''"»   Test   Test
Test«"'''"»)'''.toString, serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_8() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				it.bar(42)
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extension.bar(it, 42)", serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_9() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(String it){
				substring(0)
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("it.substring(0)", serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_10() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(){
				val it = "42"
				substring(0)
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(1)
		assertEquals("it.substring(0)",  serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_11() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(){
				new ArrayList<String>().head
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("IterableExtensions::head(new ArrayList<String>())", serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_12() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def fooBarBaz(String it){
				fooBarBaz
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("fooBarBaz(it)", serializer.computeUnsugaredExpression(call))
	}

	@Test
	def void testUnsuagaredVersionForJava() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension ExtensionJava
			
			def baz(Integer it){
				bar(it, 40 + 2)	
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("_extensionJava.bar(it, 40 + 2)", serializer.computeUnsugaredExpression(call))
	}
	
	@Test
	def testBug373054() throws Exception {
		val xtendFile = testHelper.xtendFile(FILEPATH, ''' 
		package testpackage
		import static extension testpackage.Extension.*
		class Foo {
			def bar(){}
			def baz(String it, String s){
				zonk = s + s + s
			}
			
		}
		'''.toString)
		waitForAutoBuild
		val function = xtendFile.getXtendClasses.head.members.get(1) as XtendFunction
		val block = function.expression as XBlockExpression
		val call = block.expressions.get(0)
		assertEquals("setZonk(it, s + s + s)", serializer.computeUnsugaredExpression(call))
	}
}