package org.eclipse.xtend.ide.tests.macros

import com.google.common.io.CharStreams
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.BufferedInputStream
import java.io.BufferedWriter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.jar.Manifest
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtend.core.macro.fsaccess.IOUtils.*
import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.*
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendIDEInjectorProvider))
class ActiveAnnotationsProcessingInIDETest extends AbstractReusableActiveAnnotationTests {

	@Inject
	private extension IEObjectHoverDocumentationProvider documentationProvider

	// dummy override, to make launch config available
	@Test override testSimpleModification() {
		super.testSimpleModification()
	}

	@Test
	def void testDocumetationProvider() {
		assertProcessing(
			'annotation/ChangeDoc.xtend' -> '''
				package annotation
				
				import java.util.List
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
				import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.TransformationParticipant
				import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration
				import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
				
				@Active(ChangeDocProcessor)
				annotation ChangeDoc {
				}
				
				class ChangeDocProcessor implements RegisterGlobalsParticipant<MemberDeclaration>, TransformationParticipant<MutableMemberDeclaration> {
				
					override doRegisterGlobals(List<? extends MemberDeclaration> annotatedSourceElements, RegisterGlobalsContext context) {
						//do nothing
					}
				
					override doTransform(List<? extends MutableMemberDeclaration> annotatedTargetElements,
						extension TransformationContext context) {
						for (it : annotatedTargetElements) {
							docComment = "Hello World!"
						}
					}
				
				}
			''',
			'usercode/UserCode.xtend' -> '''
				package usercode
				
				import annotation.ChangeDoc
				
				/** 
				 *	 Comment
				 */
				@ChangeDoc
				class UserClass {
				
					/** 
						* Comment
						*/
					@ChangeDoc
					private Object object
				
					/** 
					* Comment
					*/
					private Object object2
				
					/** 
					* Comment
					*/
					@ChangeDoc
					new() {
						this(new Object, new Object)
					}
				
					/** 
					* Comment
					*/
					new(Object object, Object object2) {
						this.object = object
						this.object2 = object2
					}
				
					/** 
					* Comment
					*/
					@ChangeDoc
					def op() {
					}
				
					/** 
					* Comment
					*/
					def op2() {
					}
				
				}
			''') [
			val xtendClass = xtendFile.xtendTypes.filter(XtendClass).head
			assertEquals(
				'''@<a href="eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1">ChangeDoc</a><br>Hello World!'''.
					toString, xtendClass.documentation)
			val objectField = xtendClass.members.filter(XtendField).filter[name.equals("object")].head
			assertEquals(
				'''@<a href="eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1">ChangeDoc</a><br>Hello World!'''.
					toString, objectField.documentation)
			val objectField2 = xtendClass.members.filter(XtendField).filter[name.equals("object2")].head
			assertEquals('''Comment'''.toString, objectField2.documentation)
			val constructor = xtendClass.members.filter(XtendConstructor).filter[parameters.empty].head
			assertEquals(
				'''@<a href="eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1">ChangeDoc</a><br>Hello World!'''.
					toString, constructor.documentation)
			val constructor2 = xtendClass.members.filter(XtendConstructor).filter[parameters.size == 2].head
			assertEquals(
				'''Comment<dl><dt>Parameters:</dt><dd><b>object</b> </dd><dd><b>object2</b> </dd></dl>'''.toString,
				constructor2.documentation)
			val opFunction = xtendClass.members.filter(XtendFunction).filter[name.equals("op")].head
			assertEquals(
				'''@<a href="eclipse-xtext-doc:platform:/resource/macroProject/src/annotation/ChangeDoc.xtend%23/1">ChangeDoc</a><br>Hello World!'''.
					toString, opFunction.documentation)
			val op2Function = xtendClass.members.filter(XtendFunction).filter[name.equals("op2")].head
			assertEquals('''Comment'''.toString, op2Function.documentation)
		]
	}

	@Test def void testFileSystemAccess() {
		val userCodeContent = '''
			package myusercode
			
			@myannotation.MyAnnotation
			class MyClass {
			}
		'''
		assertProcessing(
			'myannotation/MyAnnotation.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(typeof(MyAnnotationProcessor))
				annotation MyAnnotation{ }
				class MyAnnotationProcessor extends AbstractClassProcessor {
					
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
					}
					
				}
			''',
			'myusercode/UserCode.xtend' -> userCodeContent
		) [
			assertNotNull(sourceFolder)
			assertTrue(sourceFolder.exists)
			assertEquals("src", sourceFolder.name)
			assertTrue(sourceFolder.path.endsWith("/userProject/src"))
			assertNotNull(targetFolder)
			assertTrue(targetFolder.exists)
			assertEquals("xtend-gen", targetFolder.name)
			assertTrue(targetFolder.path.endsWith("/userProject/xtend-gen"))
			assertNotNull(rootFolder)
			assertTrue(rootFolder.exists)
			assertEquals("userProject", rootFolder.name)
			assertTrue(rootFolder.path.endsWith("/userProject"))
			val myusercodeFolder = sourceFolder.getFolder("myusercode")
			assertNotNull(myusercodeFolder)
			assertTrue(myusercodeFolder.exists)
			assertEquals("myusercode", myusercodeFolder.name)
			assertTrue(myusercodeFolder.path.endsWith("/userProject/src/myusercode"))
			try {
				sourceFolder.getFolder("myusercode/UserCode.xtend")
				fail
			} catch (IllegalStateException e) {
				assertTrue(e.message.contains("/userProject/src/myusercode/UserCode.xtend"))
			}
			val userCodeFile = sourceFolder.getFile("myusercode/UserCode.xtend")
			assertNotNull(userCodeFile)
			assertTrue(userCodeFile.exists)
			assertEquals("UserCode.xtend", userCodeFile.name)
			assertTrue(userCodeFile.path.endsWith("/userProject/src/myusercode/UserCode.xtend"))
			try {
				sourceFolder.getFile("myusercode")
				fail
			} catch (IllegalStateException e) {
				assertTrue(e.message.contains("/userProject/src/myusercode"))
			}
			assertEquals(userCodeContent, userCodeFile.contents)
			userCodeFile.read[assertEquals(userCodeContent, CharStreams.toString(new InputStreamReader(it)))]
			val userCodeCss = sourceFolder.getFile("myusercode/UserCode.css")
			assertNotNull(userCodeCss)
			assertFalse(userCodeCss.exists)
			assertEquals("UserCode.css", userCodeCss.name)
			assertTrue(userCodeCss.path.endsWith("/userProject/src/myusercode/UserCode.css"))
			val helloWorldCssClassDeclaration = ".helloWorldCssClass {}"
			userCodeCss.writeContents[helloWorldCssClassDeclaration as CharSequence]
			val userCodeCss2 = sourceFolder.getFile("myusercode/UserCode.css")
			assertNotNull(userCodeCss2)
			assertTrue(userCodeCss2.exists)
			assertEquals(helloWorldCssClassDeclaration, userCodeCss2.contents)
			val userCode2Css = sourceFolder.getFile("com/itemis/myusercode/UserCode2.css")
			assertNotNull(userCode2Css)
			assertFalse(userCode2Css.exists)
			assertEquals("UserCode2.css", userCode2Css.name)
			assertTrue(userCode2Css.path.endsWith("/userProject/src/com/itemis/myusercode/UserCode2.css"))
			userCode2Css.write [
				tryWith([|new BufferedWriter(new OutputStreamWriter(it))]) [
					write(helloWorldCssClassDeclaration)
				]
			]
			val userCode2Css2 = sourceFolder.getFile("com/itemis/myusercode/UserCode2.css")
			assertNotNull(userCode2Css2)
			assertTrue(userCode2Css2.exists)
			assertEquals(helloWorldCssClassDeclaration, userCode2Css2.contents)
		]
	}

	@Inject XtextResourceSetProvider resourceSetProvider
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider

	@Rule public StopwatchRule stopwatch = new StopwatchRule(true);

	@After def tearDown() throws Exception {
		macroProject = null
		userProject = null
		sourceFile = null
		cleanWorkspace();
	}

	IJavaProject macroProject
	IJavaProject userProject
	IFile sourceFile

	override assertProcessing(Pair<String, String> macroFile, Pair<String, String> clientFile,
		(CompilationUnitImpl)=>void expectations) {
		macroProject = JavaCore::create(createPluginProject("macroProject"))
		macroProject.newSource(macroFile.key, macroFile.value.toString)
		val lidx = macroFile.key.lastIndexOf('/')
		if (lidx != -1) {
			val packageName = macroFile.key.substring(0, lidx).replace('/', '.')
			macroProject.addExportedPackage(packageName)
		}
		userProject = JavaCore::create(
			createPluginProject("userProject", "com.google.inject", "org.eclipse.xtend.lib",
				"org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.ide.tests.data", "org.junit4", "macroProject"))
		sourceFile = userProject.newSource(clientFile.key, clientFile.value.toString)
		waitForAutoBuild()

		val resourceSet = resourceSetProvider.get(userProject.project)
		val resource = resourceSet.getResource(URI::createPlatformResourceURI(sourceFile.fullPath.toString, true), true)
		val unit = compilationUnitProvider.get
		unit.xtendFile = resource.contents.filter(typeof(XtendFile)).head
		expectations.apply(unit)
	}

	def IFile newSource(IJavaProject it, String fileName, String contents) {
		val result = it.project.getFile("src/" + fileName)
		var parent = result.parent
		while (!parent.exists) {
			(parent as IFolder).create(true, false, null)
		}
		result.create(new StringInputStream(contents), true, null)
		return result
	}

	def void addExportedPackage(IJavaProject pluginProject, String ... exportedPackages) {
		val manifestFile = pluginProject.project.getFile("META-INF/MANIFEST.MF")
		val manifest = new Manifest(manifestFile.contents)
		val attrs = manifest.getMainAttributes()
		if (attrs.containsKey("Export-Package")) {
			attrs.putValue("Export-Package", attrs.get("Export-Package") + "," + exportedPackages.join(","))
		} else {
			attrs.putValue("Export-Package", exportedPackages.join(","))
		}
		val out = new ByteArrayOutputStream()
		manifest.write(out)
		val in = new ByteArrayInputStream(out.toByteArray)
		manifestFile.setContents(new BufferedInputStream(in), true, true, null)
	}

}
