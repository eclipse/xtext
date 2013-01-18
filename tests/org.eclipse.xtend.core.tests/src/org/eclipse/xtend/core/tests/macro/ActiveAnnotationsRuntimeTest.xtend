package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.Pair
import org.junit.runner.RunWith
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import com.google.inject.Provider
import org.eclipse.xtend.core.xtend.XtendFile

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
class ActiveAnnotationsRuntimeTest extends AbstractActiveAnnotationsTest {
	
	@Inject CompilationTestHelper compiler
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	
	override assertProcessing(Pair<String,String> macroFile, Pair<String,String> clientFile, (CompilationUnit)=>void expectations) {
		val resourceSet = compiler.unLoadedResourceSet(clientFile) as XtextResourceSet
		compiler.compile(macroFile.value) [ result |
			resourceSet.setClasspathURIContext(new DelegatingClassloader(getClass().classLoader) [result.getCompiledClass(it)])
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
	(String)=>Class classFinder
	
	new(ClassLoader parent, (String)=>Class classFinder) {
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