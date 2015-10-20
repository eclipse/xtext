package org.eclipse.xtend.core.tests.macro

import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.nio.charset.Charset
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.macro.AnnotationProcessor
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.TemporaryFolder
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.workspace.FileProjectConfig
import org.eclipse.xtext.workspace.ProjectConfigAdapter
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class ActiveAnnotationsRuntimeTest extends AbstractReusableActiveAnnotationTests {

	@Rule 
	@Inject public TemporaryFolder temporaryFolder

	@Inject CompilationTestHelper compiler
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	@Inject Provider<XtextResourceSet> resourceSetProvider;
	@Inject ValidationTestHelper validator
	
	val macroProject = "macroProject"
	val clientProject = "userProject"
	File workspaceRoot

	@Before
	def void setUp() {
		compiler.javaCompilerClassPath = ActiveAnnotationsRuntimeTest.classLoader
		configureFreshWorkspace()
	}
	
	protected def void configureFreshWorkspace() {
		workspaceRoot = createFreshTempDir()
	}
	
	protected def File createFreshTempDir() {
		return temporaryFolder.newFolder()
	}
	
	protected def URI copyToDisk(String projectName, Pair<String,String> fileRepresentation) {
		val file = new File(workspaceRoot, projectName+"/src/"+fileRepresentation.key)
		file.parentFile.mkdirs
		Files.write(fileRepresentation.value, file, Charset.defaultCharset)
		return URI.createFileURI(file.path)
	}

	override assertProcessing(Pair<String, String> macroFile, Pair<String, String> clientFile, (CompilationUnitImpl)=>void expectations) {
		val resourceSet = macroFile.compileMacroResourceSet(clientFile)
		val singleResource = resourceSet.resources.head
		singleResource.load(emptyMap)
		compiler.compile(resourceSet) [
			it.generatedCode // ensure everything is compiled
			val unit = compilationUnitProvider.get
			val xtendFile = singleResource.contents.filter(XtendFile).head
			unit.setXtendFile(xtendFile)
			expectations.apply(unit)
		]
	}
	
	def assertIssues(Pair<String, String> macroFile, Pair<String, String> clientFile, (List<Issue>)=>void expectations) {
		val resourceSet = macroFile.compileMacroResourceSet(clientFile)
		val singleResource = resourceSet.resources.head as XtextResource
		if (!singleResource.isLoaded()) {
			singleResource.load(resourceSet.getLoadOptions());
		}
		val validator = singleResource.resourceServiceProvider.resourceValidator
		expectations.apply(validator.validate(singleResource, CheckMode.ALL, CancelIndicator.NullImpl))
	}
	
	def XtextResourceSet compileMacroResourceSet(Pair<String, String> macroFile, Pair<String, String> clientFile) {
		val macroURI = copyToDisk(macroProject, macroFile)
		val clientURI = copyToDisk(clientProject, clientFile)
		val macroProjectConfig = new FileProjectConfig(new File(workspaceRoot, macroProject)) => [
			addSourceFolder("src")
		]
		val clientProjectConfig = new FileProjectConfig(new File(workspaceRoot, clientProject)) => [
			addSourceFolder("src")
		]
		
		val macroResourceSet = resourceSetProvider.get
		ProjectConfigAdapter.install(macroResourceSet, macroProjectConfig)
		macroResourceSet.classpathURIContext = getClass.classLoader
		macroResourceSet.createResource(macroURI)
		
		val resourceSet = resourceSetProvider.get
		ProjectConfigAdapter.install(resourceSet, clientProjectConfig)
		resourceSet.createResource(clientURI)
		
		compiler.compile(macroResourceSet) [ result |
			val classLoader = new DelegatingClassloader(getClass().classLoader, result)
			resourceSet.classpathURIContext = classLoader
			compiler.javaCompilerClassPath = classLoader 
		]
		
		return resourceSet
	}

	// dummy override to enable launch configs
	@Test override testSimpleModification() {
		super.testSimpleModification()
	}

	@Test def void testBug403563() {
		assertIssues(
			'myannotation/ThrowExceptionAnnotationProcessor.xtend' -> '''
				package myannotation
				
				import org.eclipse.xtend.lib.macro.Active
				import org.eclipse.xtend.lib.macro.TransformationContext
				import org.eclipse.xtend.lib.macro.AbstractClassProcessor
				import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
				
				@Active(ThrowExceptionAnnotationProcessor)
				annotation ThrowExceptionAnnotation{ }
				class ThrowExceptionAnnotationProcessor extends AbstractClassProcessor {
				
					override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
						throw new IllegalStateException
					}
				
				}
			''',
			'myusercode/UserCode.xtend' -> '''
				package myusercode
				
				@myannotation.ThrowExceptionAnnotation class MyClass {
				}
			'''
		) [ 
			assertEquals(1, size)
			
			val error = head
			assertNotNull(error)
			assertEquals(IssueCodes.PROCESSING_ERROR, error.code)
			assertTrue(error.message.contains(IllegalStateException.name))
			assertFalse(error.message.contains(AnnotationProcessor.name))
		]
	}
	
	@Test def void testDetectOrphanedElements() {
		assertProcessing(
				'myannotation/EvilAnnotation.xtend' -> '''
					package myannotation
					
					import java.util.List
					import org.eclipse.xtend.lib.macro.Active
					import org.eclipse.xtend.lib.macro.AbstractClassProcessor
					import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
					import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
					import org.eclipse.xtend.lib.macro.TransformationContext
					import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
					
					@Active(EvilProcessor)
					annotation EvilAnnotation {
						
					}
					
					class EvilProcessor extends AbstractClassProcessor {
						
						override doRegisterGlobals(List<? extends ClassDeclaration> classes, extension RegisterGlobalsContext context) {
							classes.forEach[
								registerClass(qualifiedName+'.Inner')
							]
						}
						
						override doTransform(List<? extends MutableClassDeclaration> classes, extension TransformationContext context) {
							classes.forEach[
								addField("foo")[
									type = object
									markAsRead
								]
								addMethod("foo")[
									returnType = object
									body = ["return null;"]
									addParameter("x", Integer.newTypeReference)
								]
							]
						}
					}
				''',
				'myusercode/UserCode.xtend' -> '''
					package myusercode
					
					import myannotation.EvilAnnotation
					
					@EvilAnnotation
					class Foo {
					}
				'''
			)[
				validator.assertIssue(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELMENT, Severity.WARNING, 
					"The generated field 'myusercode.Foo.foo' is not associated with a source element.")
				validator.assertIssue(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELMENT, Severity.WARNING, 
					"The generated method 'myusercode.Foo.foo(Integer)' is not associated with a source element.")
				validator.assertIssue(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELMENT, Severity.WARNING, 
					"The generated type 'myusercode.Foo.Inner' is not associated with a source element.")
			]
	}
	
	@Test def void testDetectOrphanedElements2() {
		assertProcessing(
				'myannotation/EvilAnnotation.xtend' -> '''
					package myannotation
					
					import java.util.List
					import org.eclipse.xtend.lib.macro.Active
					import org.eclipse.xtend.lib.macro.AbstractClassProcessor
					import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
					import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
					import org.eclipse.xtend.lib.macro.TransformationContext
					import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
					
					@Active(EvilProcessor)
					annotation EvilAnnotation {}
					
					class EvilProcessor extends AbstractClassProcessor {
						
						override doRegisterGlobals(ClassDeclaration clazz, extension RegisterGlobalsContext context) {
							registerClass(clazz.qualifiedName+'.Inner')
						}
						
						override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
							findClass(clazz.qualifiedName+'.Inner').primarySourceElement = clazz
						}
					}
				''',
				'myusercode/UserCode.xtend' -> '''
					package myusercode
					
					import myannotation.EvilAnnotation
					
					@EvilAnnotation
					class Foo {
						Comparable<String> p = new Comparable<String>() {
							override compareTo(String other) { 42 }
						}
					}
				'''
			)[
				validator.assertNoWarnings(xtendFile, XtendPackage.Literals.XTEND_FILE, IssueCodes.ORPHAN_ELMENT)
			]
	}

}

class DelegatingClassloader extends ClassLoader {
	CompilationTestHelper.Result classFinder

	new(ClassLoader parent, CompilationTestHelper.Result classFinder) {
		super(parent)
		this.classFinder = classFinder
	}
	
	override protected findResource(String name) {
		val result = classFinder.classLoader.getResource(name)
		return result ?: super.findResource(name)
	}
	
	override findClass(String name) throws ClassNotFoundException {
		val result = classFinder.getCompiledClass(name)
		if (result != null)
			return result
		super.findClass(name)
	}

	override loadClass(String name) throws ClassNotFoundException {
		super.loadClass(name)
	}

}
