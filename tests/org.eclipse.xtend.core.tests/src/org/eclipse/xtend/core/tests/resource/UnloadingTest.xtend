package org.eclipse.xtend.core.tests.resource

import org.eclipse.xtend.core.resource.XtendResource
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.junit.Test
import org.eclipse.xtend.core.xtend.XtendFile

class UnloadingTest extends AbstractXtendTestCase {
	
	@Test def void testProperUnloading() {
		val String fileB = '''
			class B {
				def void foo() {
					new A(this)
				}
			}
		'''
		val parsedFiles = files(true, '''
			class A {
				new (B b) {
				}
			}
		''', fileB).toList
		
		val XtendResource resource = parsedFiles.get(1).eResource as XtendResource
		val resourceA = parsedFiles.head.eResource;
		resource.reparse(fileB)
		val file = resourceA.contents.head as XtendFile
		assertNotNull(((file.xtendTypes.head as XtendClass).members.head as XtendConstructor).parameters.head.parameterType.type.eResource)
	}
}