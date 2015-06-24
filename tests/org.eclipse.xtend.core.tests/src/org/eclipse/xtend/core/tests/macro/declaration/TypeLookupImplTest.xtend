package org.eclipse.xtend.core.tests.macro.declaration

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration
import org.junit.Test

class TypeLookupImplTest extends AbstractXtendTestCase {
	
	@Test def void testFindClass_01() {
		validFile('''
			package foo
			
			class MyClass {}
			enum MyEnum {}
			interface MyInterface {}
			annotation MyAnnotation {}
		''').asCompilationUnit [
			assertNotNull(typeLookup.findClass('foo.MyClass'))
			assertNull(typeLookup.findClass('foo.MyClass.Unknown'))
			assertNull(typeLookup.findClass('foo.MyInterface'))
			
			assertNotNull(typeLookup.findEnumerationType('foo.MyEnum'))
			assertNotNull(typeLookup.findAnnotationType('foo.MyAnnotation'))
			assertNotNull(typeLookup.findInterface('foo.MyInterface'))
			
			assertNull(typeLookup.findClass('java.lang.String'))
		]
	}
	
	@Test def void testFindClass_02() {
		validFile('''
			package foo
			import org.eclipse.xtend.core.tests.macro.declaration.AddNestedTypes
			
			@AddNestedTypes class MyClass {}
			@AddNestedTypes enum MyEnum {}
			@AddNestedTypes interface MyInterface {}
			@AddNestedTypes annotation MyAnnotation {}
		''').asCompilationUnit [
			assertNotNull(typeLookup.findClass('foo.MyClass.NestedClass'))
			assertNotNull(typeLookup.findInterface('foo.MyClass.NestedInterface'))
			assertNotNull(typeLookup.findEnumerationType('foo.MyClass.NestedEnumerationType'))
			assertNotNull(typeLookup.findAnnotationType('foo.MyClass.NestedAnnotationType'))
		]
	}
	
	@Test def void testFindUpstreamType() {
		validFile('''
			package foo
			
			class MyClass {}
		''').asCompilationUnit [
			assertNull(typeLookup.findUpstreamType('foo.MyClass'))
			assertNotNull(typeLookup.findUpstreamType('java.lang.String'))
		]
	}
	
	@Test def void testFindSourceType() {
		validFile('''
			package foo
			import org.eclipse.xtend.core.tests.macro.declaration.AddNestedTypes
			
			@AddNestedTypes class MyClass {}
			@AddNestedTypes enum MyEnum {}
			@AddNestedTypes interface MyInterface {}
			@AddNestedTypes annotation MyAnnotation {}
		''').asCompilationUnit [
			assertNotNull(typeLookup.findSourceClass('foo.MyClass'))
			assertNotNull(typeLookup.findSourceInterface('foo.MyInterface'))
			assertNotNull(typeLookup.findSourceEnumerationType('foo.MyEnum'))
			assertNotNull(typeLookup.findSourceAnnotationType('foo.MyAnnotation'))
			assertNull(typeLookup.findSourceClass('foo.MyClass.NestedClass'))
			assertNull(typeLookup.findSourceInterface('foo.MyClass.NestedInterface'))
			assertNull(typeLookup.findSourceEnumerationType('foo.MyClass.NestedEnumerationType'))
			assertNull(typeLookup.findSourceAnnotationType('foo.MyClass.NestedAnnotationType'))
		]
	}

	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	
	def validFile(CharSequence code) {
		file(code.toString, true)
	}
	
	def asCompilationUnit(XtendFile file, (CompilationUnitImpl)=>void block) {
		val compilationUnit = compilationUnitProvider.get
		compilationUnit.xtendFile = file
		block.apply(compilationUnit)
	}	
}

@Active(typeof(AddNestedTypesProcessor))
annotation AddNestedTypes {}
class AddNestedTypesProcessor implements RegisterGlobalsParticipant<TypeDeclaration> {
	
	override doRegisterGlobals(List<? extends TypeDeclaration> annotatedSourceElements, RegisterGlobalsContext context) {
		for (type : annotatedSourceElements) {
			context.registerClass(type.qualifiedName+'.NestedClass')
			context.registerInterface(type.qualifiedName+'.NestedInterface')
			context.registerAnnotationType(type.qualifiedName+'.NestedAnnotationType')
			context.registerEnumerationType(type.qualifiedName+'.NestedEnumerationType')
		}
	}
	
}