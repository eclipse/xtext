package org.eclipse.xtend.ide.tests.imports

import javax.inject.Inject
import org.junit.Test
import org.eclipse.xtext.xbase.imports.ImportOrganizer
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.resource.XtextResource

class OrganizeImportsTest extends AbstractXtendUITestCase {
	
	@Inject ImportOrganizer importOrganizer
	
	@Inject extension WorkbenchTestHelper
	
	def protected assertIsOrganizedTo(CharSequence model, CharSequence expected) {
		val xtendFile = xtendFile("Foo", model.toString)
		val changes = importOrganizer.getOrganizedImportChanges(xtendFile.eResource as XtextResource)
		val builder = new StringBuilder(model)
		for(it: changes.sortBy[offset].reverse)
			builder.replace(offset, offset + length, text)
		assertEquals(expected.toString, builder.toString)
	}
	
	@Test def testUnresolvedType() {
		'''
			class Foo implements Serializable {
			}
		'''.assertIsOrganizedTo('''
			import java.io.Serializable
			
			class Foo implements Serializable {
			}
		''')
	}

	@Test def testUnresolvedConstructorCall() {
		'''
			class Foo {
				Object bar = new ArrayList
			}
		'''.assertIsOrganizedTo('''
			import java.util.ArrayList
			
			class Foo {
				Object bar = new ArrayList
			}
		''')
	}
}