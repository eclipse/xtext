package org.eclipse.xtext.xtend2.ui.tests.hover

import com.google.inject.Inject
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationControlInput
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider$JavadocHoverWrapper
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.util.Tuples
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations
import org.eclipse.xtext.xtend2.ui.hover.XtendDispatchingEObjectTextHover
import org.eclipse.xtext.xtend2.ui.hover.XtendInformationControlInput
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper
import org.eclipse.xtext.xtend2.xtend2.XtendFile
import org.eclipse.xtext.xtend2.xtend2.XtendFunction
import org.junit.BeforeClass
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.eclipse.xtext.xtend2.ui.tests.hover.XtendUnsugaredHoverTest.*
import static org.junit.Assert.*

class XtendUnsugaredHoverTest extends AbstractXtend2UITestCase {
	 
	@Inject
	private WorkbenchTestHelper testHelper
	
	@Inject
	extension IXtend2JvmAssociations
	
	@Inject
	private IJavaElementFinder javaElementFinder
	
	private static String FILEEXTENSION = ".xtend"
	private static String FILEPATH = WorkbenchTestHelper::TESTPROJECT_NAME + "/src/testpackage/Foo" + FILEEXTENSION

	@BeforeClass
	def static void createExtensionClass() throws Exception {
		createFile(WorkbenchTestHelper::TESTPROJECT_NAME + "/src/testpackage/Extension" + FILEEXTENSION, '''
			package testpackage
			import java.util.List
			class Extension {
				def bar(Integer p1, Integer p2)
				
				def barCharSequence(Integer p1, CharSequence c)
				
				def bar(List<String list, Integer a)
			}
			
			'''.toString
		);
		
		createFile(WorkbenchTestHelper::TESTPROJECT_NAME + "/src/testpackage/ExtensionJava.java", '''
			package testpackage;
			public class ExtensionJava {
				public void bar(Integer p1, Integer p2){
					
				}
			}
			
			'''.toString
		);
	}

	@Test
	def void testUnsuagaredVersionForXtendFunction() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(42)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(it, 42)",triple.second.unsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_2() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(it, 42)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(it, 42)",triple.second.unsugaredExpression)
	}
	
		@Test
	def void testUnsuagaredVersionForXtendFunction_3() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
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
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(it, 42 + a)",triple.second.unsugaredExpression)
	}

	@Test
	def void testUnsuagaredVersionForXtendFunction_4() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		class Foo {
			extension Extension
			
			def baz(Integer it){
				bar(it, 40 + 2)	
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,0)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(it, 40 + 2)", triple.second.unsugaredExpression)
	}
	
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_5() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
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
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(new ArrayList<String>(), 42)", triple.second.unsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_6() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				this._extension.bar(new ArrayList<String>(), 42)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,17)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(new ArrayList<String>(), 42)", triple.second.unsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_7() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				this._extension.bar(new ArrayList<String>(), 42)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,17)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(new ArrayList<String>(), 42)", triple.second.unsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_8() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				this._extension.barCharSequence(42, «"'''"»   Test   Test
		Test«"'''"»)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,17)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals('''this._extension.barCharSequence(42, «"'''"»   Test   Test
Test«"'''"»)'''.toString, triple.second.unsugaredExpression)
	}
	
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_9() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
		package testpackage
		import java.util.ArrayList
		class Foo {
			extension Extension
			
			def baz(Integer it){
				_extension.bar(new ArrayList<String>(), 42)
			}
			
		}
		'''.toString))
		val triple = computeAstAndInvokeHover(editor,0,12)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("_extension.bar(new ArrayList<String>(), 42)", triple.second.unsugaredExpression)
	}
	
	@Test
	def void testUnsuagaredVersionForXtendFunction_10() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
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
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation).xtendFunction), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extension.bar(it, 42)", triple.second.unsugaredExpression)
	}
	
	
	@Test
	def void testUnsuagaredVersionForJava() throws Exception {
		val editor = testHelper.openEditor(createFile(FILEPATH, ''' 
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
		assertEquals(javaElement, triple.second.inputElement)
		val javaDocHoverWrapper = new JavadocHoverWrapper()
		javaDocHoverWrapper.setJavaElement(javaElement)
		val javaDocHoverInput = javaDocHoverWrapper.getHoverInfo2(null, triple.third) as JavadocBrowserInformationControlInput
		assertEquals(triple.second.html, javaDocHoverInput.html)
		assertEquals(EcoreUtil2::getURI((triple.first.feature as JvmOperation)), EcoreUtil2::getURI(triple.second.element))
		assertEquals("this._extensionJava.bar(it, 40 + 2)", triple.second.unsugaredExpression)
	}
	
	def computeAstAndInvokeHover(XtextEditor editor, int indexOfExpressionToHover, int addOffset){
		waitForAutoBuild
		val resource = loadResource
		val xtendFile = resource.contents.get(0) as XtendFile
		val featureCall = ((xtendFile.xtendClass.members.get(1) as XtendFunction).expression as XBlockExpression).expressions.get(indexOfExpressionToHover) as XAbstractFeatureCall
		val hover = get(typeof(IEObjectHover)) as XtendDispatchingEObjectTextHover
		val region = hover.getHoverRegion(editor.internalSourceViewer, NodeModelUtils::getNode(featureCall).offset + addOffset)
		return Tuples::create(featureCall, hover.getHoverInfo2(editor.internalSourceViewer, region) as XtendInformationControlInput, region)
	}
	
	def IProject getProject(){
		return ResourcesPlugin::getWorkspace().getRoot().getProject(WorkbenchTestHelper::TESTPROJECT_NAME);
	}

	def loadResource(){
		val uri = URI::createURI("platform:/resource/" + FILEPATH);
		var resource = injector.getInstance(typeof(IResourceSetProvider)).get(getProject()).createResource(uri)
		resource.load(null)
		return resource
	}
}