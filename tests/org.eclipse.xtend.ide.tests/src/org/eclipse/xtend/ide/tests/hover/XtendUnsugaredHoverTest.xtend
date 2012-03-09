package org.eclipse.xtend.ide.tests.hover

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.ui.hover.XbaseDispatchingEObjectTextHover
import org.eclipse.xtext.xbase.ui.hover.XbaseInformationControlInput
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
	private IJavaElementFinder javaElementFinder
	
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
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(42)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(it, 42)",triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_2() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(it, 42)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(it, 42)",triple.second.getUnsugaredExpression)
	}
	
		@Test
	def void testUnsuagaredVersionForXtendFunction_3() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				val a = 42
				bar(it, 42 + a)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,1,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(it, 42 + a)",triple.second.getUnsugaredExpression)
	}

	@Test
	def void testUnsuagaredVersionForXtendFunction_4() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(it, 40 + 2)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(it, 40 + 2)", triple.second.getUnsugaredExpression)
	}
	
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_5() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				new ArrayList<String>().bar(42)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,25)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(new ArrayList<String>(), 42)", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_6() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(new ArrayList<String>(), 42)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(new ArrayList<String>(), 42)", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_7() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				barCharSequence(42, «"'''"»   Test   Test
		Test«"'''"»)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals('''_extension.barCharSequence(42, «"'''"»   Test   Test
Test«"'''"»)'''.toString, triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_8() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				it.bar(42)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,4)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(it, 42)", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_9() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(String it){
				substring(0)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("it.substring(0)", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_10() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(){
				val it = "42"
				substring(0)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,1,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("it.substring(0)", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_11() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(){
				new ArrayList<String>().head
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,27)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("IterableExtensions::head(new ArrayList<String>())", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_12() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def fooBarBaz(String it){
				fooBarBaz
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI(triple.first.feature), EcoreUtil2::getURI(triple.second.element))
		assertEquals("fooBarBaz(it)", triple.second.getUnsugaredExpression)
	}

	@Test
	def void testUnsuagaredVersionForJava() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension ExtensionJava
			
			def baz(Integer it){
				bar(it, 40 + 2)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		val javaElement = javaElementFinder.findElementFor(triple.first.feature);
		assertEquals(javaElement, triple.second.getInputElement)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation)), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extensionJava.bar(it, 40 + 2)", triple.second.getUnsugaredExpression)
	}
	
	@Test
	def testBug373054() throws Exception {
		val editor = testHelper.openEditor(testHelper.createFile(FILEPATH, ''' 
		package testpackage
		import static extension testpackage.Extension.*
		class Foo {
			def bar(){}
			def baz(String it, String s){
				zonk = s + s + s
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals("setZonk(it, s + s + s)", triple.second.getUnsugaredExpression)
	}
	
	def computeAstAndInvokeHover(XtextEditor editor, int indexOfExpressionToHover, int addOffset){
		waitForAutoBuild
		val resource = loadResource
		val xtendFile = resource.contents.get(0) as XtendFile
		val featureCall = ((xtendFile.xtendClass.members.get(1) as XtendFunction).expression as XBlockExpression).expressions.get(indexOfExpressionToHover) as XAbstractFeatureCall
		val hover = get(typeof(IEObjectHover)) as XbaseDispatchingEObjectTextHover
		val region = hover.getHoverRegion(editor.internalSourceViewer, NodeModelUtils::getNode(featureCall).offset + addOffset)
		return Tuples::create(featureCall, hover.getHoverInfo2(editor.internalSourceViewer, region) as XbaseInformationControlInput, region)
	}
	

	def loadResource(){
		val uri = URI::createURI("platform:/resource/"+WorkbenchTestHelper::TESTPROJECT_NAME + "/src/" + FILEPATH);
		var resource = getInjector.getInstance(typeof(IResourceSetProvider)).get(testHelper.project).createResource(uri)
		resource.load(null)
		return resource
	}
}