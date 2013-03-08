package org.eclipse.xtend.core.tests.macro

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.IterableExtensions
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
class ActiveAnnotationsRuntimeTest extends AbstractReuasableActiveAnnotationTests {
	
	@Inject CompilationTestHelper compiler
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	@Inject ProcessorInstanceForJvmTypeProvider processorProvider
	
	@Before
	def void setUp() {
		compiler.setJavaCompilerClassPath(typeof(MutableTypeDeclaration) , typeof(IterableExtensions), typeof(Lists))
	}
	
	override assertProcessing(Pair<String,String> macroFile, Pair<String,String> clientFile, (CompilationUnitImpl)=>void expectations) {
		val macroResourceSet = compiler.unLoadedResourceSet(macroFile) as XtextResourceSet
		macroResourceSet.classpathURIContext = getClass.classLoader
		val resourceSet = compiler.unLoadedResourceSet(clientFile) as XtextResourceSet
		compiler.compile(macroResourceSet) [ result |
			val classLoader = new DelegatingClassloader(getClass().classLoader) [result.getCompiledClass(it)]
			resourceSet.classpathURIContext = classLoader
			processorProvider.classLoader = classLoader
		]
		
		val singleResource = resourceSet.resources.head
		compiler.compile(resourceSet) [
			val unit = compilationUnitProvider.get
			unit.setXtendFile(singleResource.contents.filter(typeof(XtendFile)).head)
			expectations.apply(unit)
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