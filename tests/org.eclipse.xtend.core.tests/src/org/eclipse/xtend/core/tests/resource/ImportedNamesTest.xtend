package org.eclipse.xtend.core.tests.resource

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.junit.Test
import org.eclipse.xtext.resource.IResourceDescription
import com.google.inject.Inject

class ImportedNamesTest extends AbstractXtendTestCase {
	@Inject
	IResourceDescription$Manager resourceDescriptionManager
	
	val primitives = #["boolean", "int", "char", "byte", "short", "long"]
		
	@Test
	def void testPrimitvesNotIncluded () {
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
				
				List<Object> l;
			}
		''')
		val description = resourceDescriptionManager.getResourceDescription(file.eResource)
		//println(description.getImportedNames.toString().replace(',','\n'))
		assertFalse(description.importedNames.exists[ primitives.contains(it.lastSegment) ]);
	}
}