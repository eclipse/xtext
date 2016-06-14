package org.eclipse.xtend.core.tests.resource

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.resource.IResourceDescription
import org.junit.Test

class ImportedNamesTest extends AbstractXtendTestCase {
	@Inject
	IResourceDescription.Manager resourceDescriptionManager
	
	val primitives = #["boolean", "int", "char", "byte", "short", "long", "float", "double", "void"]
		
	@Test
	def void testPrimitivesNotIncluded () {
		val file = this.file('''
			package testPackage
			
			import hubbabubba.*
			import java.util.*
			
			class TestCase {
				String x;
				int i;
				boolean b;
				char c;
				short s;
				long l;
				byte t;
				float f;
				double d;
				
				List<Object> l;
				
				def void foo() {
					if (x == i == b == c == s == l == t == f == d) {
						println("never happens")
					}
				}
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
//		println(description.getImportedNames.toString().replace(',','\n'))
		assertFalse(description.importedNames.exists[ primitives.contains(it.lastSegment) ]);
	}
	
	@Test
	def void testExtendedInterfaces() {
		val file = file('''
			package foo
			
			import java.util.List
			
			class Foo implements List {
			
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[it.lastSegment.equals('collection')]);
	}
	
	@Test
	def void testAnonymousClass() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = new Runnable() {
					override run() {}
				}
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[it.lastSegment.equals('runnable')]);
	}
	
	@Test
	def void testNestedTypesIncluded() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = types.StaticOuterClass.StaticMiddleClass.StaticInnerClass.CONSTANT
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[toString == 'types.StaticOuterClass$StaticMiddleClass$StaticInnerClass'.toLowerCase]);
	}
	
	@Test
	def void testNestedTypesIncludedOnUnresolvedFeatures() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = types.StaticOuterClass.Unknown.StaticInnerClass.CONSTANT
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[toString == 'types.StaticOuterClass$Unknown'.toLowerCase]);
	}
	
	@Test
	def void testNestedTypesIncludedOnUnresolvedFeatures_02() {
		val file = file('''
			package foo
			
			class Foo {
				val foo = types.StaticOuterClass.StaticMiddleClass.Unknown
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		val importedNames = description.importedNames
		assertTrue('' + importedNames, importedNames.exists[toString == 'types.StaticOuterClass$StaticMiddleClass$Unknown'.toLowerCase]);
	}
	
}