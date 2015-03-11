package i18n

import extract.Extract
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.junit.Test

import static org.junit.Assert.assertEquals

class ExternalizedTest {
	
	extension XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(Extract)
	
	@Test def void testExtractAnnotation() {
		'''
			package i18n
			
			@Externalized
			class MyMessages {
				val GREETING = "Hello {0}"
				val DATE_MESSAGE = "Today, is ${0,date}."
			}
		'''.compile [
			val extension ctx = transformationContext
			val clazz = findClass('i18n.MyMessages')
			
			assertEquals(2, clazz.declaredMethods.size)
			
			val path = compilationUnit.filePath
			val properties = path.targetFolder.append(clazz.qualifiedName.replace('.','/')+'.properties')
			assertEquals('''
				GREETING = Hello {0}
				DATE_MESSAGE = Today, is ${0,date}.
			'''.toString, properties.contents.toString)
		]
	}
}