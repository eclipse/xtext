package org.eclipse.xtend.core.tests.resource

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.junit.Test
import org.eclipse.xtext.resource.IResourceDescription
import com.google.inject.Inject

class ImportedNamesTest extends AbstractXtendTestCase {
	@Inject
	IResourceDescription$Manager resourceDescriptionManager
	
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
	
}