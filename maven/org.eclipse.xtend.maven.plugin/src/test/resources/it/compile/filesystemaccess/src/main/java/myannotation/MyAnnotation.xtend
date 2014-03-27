package myannotation

import com.google.common.io.CharStreams
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStreamReader
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CodeGenerationContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.file.Path

import static org.junit.Assert.*

@Active(typeof(MyAnnotationProcessor))
annotation MyAnnotation {
}

class MyAnnotationProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
		val Path cuPath = clazz.compilationUnit.filePath
		assertNotNull("projectFolder is set", cuPath.projectFolder)
		assertTrue("projectFolder exists", cuPath.projectFolder.exists)
		assertEquals("projectFolder name is 'filesystemaccess-client'", "filesystemaccess-client",
			cuPath.projectFolder.lastSegment)
		assertTrue(
			"projectFolder should end with /filesystemaccess-client but was: " + cuPath.projectFolder.toString,
			cuPath.projectFolder.toString.endsWith("/filesystemaccess-client"))

		
		val cuSrcFolder = cuPath.sourceFolder
		assertNotNull("srcfolder is set", cuSrcFolder)
		assertTrue("srcfolder exists", cuSrcFolder.exists)
		assertEquals("srcfolder name is 'java'", "java", cuSrcFolder.lastSegment)
		assertTrue("srcfolder should end with /filesystemaccess-client/src/main/java but was: " + cuSrcFolder.toString,
			cuSrcFolder.toString.endsWith("/filesystemaccess-client/src/main/java"))

		assertNotNull("targetfolder is set", cuSrcFolder.targetFolder)

		//assertTrue("targetfolder exists", targetFolder.exists)
		assertEquals("targetfolder name is 'xtend'", "xtend", cuSrcFolder.targetFolder.lastSegment)
		assertTrue(
			cuSrcFolder.targetFolder.toString.endsWith("/filesystemaccess-client/src/main/generated-sources/xtend"))

		val myusercodeFolder = cuSrcFolder.append("myusercode")
		assertTrue(myusercodeFolder.exists)
		assertTrue(myusercodeFolder.folder)
		assertFalse(myusercodeFolder.file)
		assertEquals("myusercode", myusercodeFolder.lastSegment)
		assertTrue(myusercodeFolder.toString.endsWith("/filesystemaccess-client/src/main/java/myusercode"))

		val userCodeFile = cuSrcFolder.append("myusercode").append("UserCode.xtend")
		assertNotNull(userCodeFile)
		assertTrue(userCodeFile.exists)
		assertFalse(userCodeFile.folder)
		assertTrue(userCodeFile.file)
		assertEquals("UserCode.xtend", userCodeFile.lastSegment)
		assertTrue(
			userCodeFile.toString.endsWith("/filesystemaccess-client/src/main/java/myusercode/UserCode.xtend"))

		val userCodeContent = 
			"package myusercode\n"
			+ "\n"
			+"@myannotation.MyAnnotation\n"
			+"class MyClass {\n"
			+"}\n"
		
		assertEquals(userCodeContent, userCodeFile.contents)
		assertEquals(userCodeContent, CharStreams.toString(new InputStreamReader(userCodeFile.contentsAsStream)))

	}

	override doGenerateCode(ClassDeclaration annotatedClass, extension CodeGenerationContext context) {
		val cuSrcFolder = annotatedClass.compilationUnit.filePath.sourceFolder
		val userCodeCss = cuSrcFolder.append("myusercode").append("UserCode.css")

		assertNotNull(userCodeCss)
		assertFalse(userCodeCss.exists)
		assertEquals("UserCode.css", userCodeCss.lastSegment)
		assertTrue(userCodeCss.toString.endsWith("/filesystemaccess-client/src/main/java/myusercode/UserCode.css"))
		val helloWorldCssClassDeclaration = ".helloWorldCssClass {}"
		userCodeCss.setContents(helloWorldCssClassDeclaration as CharSequence)

		val userCodeCss2 = cuSrcFolder.append("myusercode").append("UserCode.css")
		assertNotNull(userCodeCss2)
		assertTrue(userCodeCss2.exists)
		assertEquals(helloWorldCssClassDeclaration, userCodeCss2.contents)

		val userCode2Css = cuSrcFolder.append("com").append("itemis").append("myusercode").append("UserCode2.css")
		assertNotNull(userCode2Css)
		assertFalse(userCode2Css.exists)
		assertEquals("UserCode2.css", userCode2Css.lastSegment)
		assertTrue(
			userCode2Css.toString.endsWith(
				"/filesystemaccess-client/src/main/java/com/itemis/myusercode/UserCode2.css"))
		userCode2Css.setContentsAsStream(new ByteArrayInputStream(helloWorldCssClassDeclaration.getBytes()))
		println(new File(userCode2Css.toString).absolutePath)
		assertNotNull(userCode2Css)
		assertTrue(userCode2Css.exists)
		assertEquals(helloWorldCssClassDeclaration, userCode2Css.contents)
	}

}
