package org.eclipse.xtend.core.tests.macro

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.Files
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.file.ProjectConfig
import org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider
import org.eclipse.xtext.xbase.file.WorkspaceConfig
import org.eclipse.xtext.xbase.lib.IterableExtensions
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.junit.After

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
class ActiveAnnotationsRuntimeTest extends AbstractReusableActiveAnnotationTests {

	@Inject CompilationTestHelper compiler
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	@Inject ProcessorInstanceForJvmTypeProvider processorProvider
	@Inject ValidationTestHelper validationTestHelper
	@Inject Provider<XtextResourceSet> resourceSetProvider;
	@Inject RuntimeWorkspaceConfigProvider configProvider
	@Inject extension MutableFileSystemSupport fileSystemSupport
	
	val macroProject = "macroProject"
	val clientProject = "userProject"

	@Before
	def void setUp() {
		compiler.setJavaCompilerClassPath(typeof(MutableTypeDeclaration), typeof(IterableExtensions), typeof(Lists))
		configureFreshWorkspace()
	}
	
	@After
	def void tearDown() {
		Files.sweepFolder(new File(configProvider.workspaceConfig.absoluteFileSystemPath))
	}
	
	protected def void configureFreshWorkspace() {
		val tempDir = createFreshTempDir()
		configProvider.workspaceConfig = new WorkspaceConfig(tempDir.absolutePath) => [
			addProjectConfig(new ProjectConfig(macroProject) => [
				sourceFolderMappings.put(new Path('/'+macroProject+'/src'), new Path('/'+macroProject+'/xtend-gen'))
			])
			addProjectConfig(new ProjectConfig(clientProject) => [
				sourceFolderMappings.put(new Path('/'+clientProject+'/src'), new Path('/'+clientProject+'/xtend-gen'))
			])
		]
	}
	
	protected def File createFreshTempDir() {
		val tempDir = File.createTempFile("temp", Long.toString(System.nanoTime()));
		if (!tempDir.delete) {
			throw new IllegalStateException("couldn't delete temp file.")
		}
		if (!tempDir.mkdir) {
			throw new IllegalStateException("couldn't create temp dir.")
		}
		return tempDir
	}
	
	protected def URI copyToDisk(String projectName, Pair<String,String> fileRepresentation) {
		val path = new Path("/"+projectName+"/src/"+fileRepresentation.key)
		path.setContents(fileRepresentation.value)
		return URI.createFileURI(configProvider.workspaceConfig.absoluteFileSystemPath+path.toString)
	}

	override assertProcessing(Pair<String, String> macroFile, Pair<String, String> clientFile, (CompilationUnitImpl)=>void expectations) {
		val macroURI = copyToDisk(macroProject,macroFile)
		val clientURI = copyToDisk(clientProject,clientFile)
		
		val macroResourceSet = resourceSetProvider.get
		macroResourceSet.classpathURIContext = getClass.classLoader
		macroResourceSet.createResource(macroURI)
		
		val resourceSet = resourceSetProvider.get
		resourceSet.createResource(clientURI)
		
		compiler.compile(macroResourceSet) [ result |
			val classLoader = new DelegatingClassloader(getClass().classLoader) [
				result.getCompiledClass(it)
			]
			resourceSet.classpathURIContext = classLoader
			processorProvider.classLoader = classLoader
		]

		val singleResource = resourceSet.resources.head
		compiler.compile(resourceSet) [
			val unit = compilationUnitProvider.get
			val xtendFile = singleResource.contents.filter(typeof(XtendFile)).head
			validationTestHelper.assertNoErrors(xtendFile)
			unit.setXtendFile(xtendFile)
			expectations.apply(unit)
			assertTrue(singleResource.errors.isEmpty)
		]
	}

	// dummy override to enable launch configs
	@Test override testSimpleModification() {
		super.testSimpleModification()
	}

}

class DelegatingClassloader extends ClassLoader {
	(String)=>Class<?> classFinder

	new(ClassLoader parent, (String)=>Class<?> classFinder) {
		super(parent)
		this.classFinder = classFinder
	}

	override findClass(String name) throws ClassNotFoundException {
		val result = classFinder.apply(name)
		if (result != null)
			return result
		super.findClass(name)
	}

	override loadClass(String name) throws ClassNotFoundException {
		super.loadClass(name)
	}

}
