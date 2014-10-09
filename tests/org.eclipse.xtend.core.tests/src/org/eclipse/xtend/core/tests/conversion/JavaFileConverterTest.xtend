/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.conversion;

import com.google.common.base.Predicate
import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.nio.charset.Charset
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.conversion.JavaConverter
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.mwe.PathTraverser
import org.junit.Ignore
import org.junit.Test

/**
 * @author dhuebner - Initial contribution and API
 */
public class JavaFileConverterTest extends AbstractXtendTestCase {
	@Inject
	private Provider<JavaConverter> javaConverter;

	@Test @Ignore
	def void testConvertFilesInThisProject() throws Exception {
		val File projectRoot = new File("").getAbsoluteFile();
		val testProject = new File(projectRoot.parentFile, "test-converter")
		println("Working in " + projectRoot.getPath());
		val PathTraverser pathTraverser = new PathTraverser();
		val Set<URI> allResourceUris = pathTraverser.findAllResourceUris(projectRoot.getAbsolutePath(),
			new Predicate<URI>() {
				override boolean apply(URI input) {
					val fileName = input.toFileString()
					return "java".equals(input.fileExtension()) && !fileName.contains("xtend-gen") &&
						!fileName.contains("ScenarioBug395002");
				}
			});
		var errors = 0
		var problems = 0
		for (URI uri : allResourceUris) {
			val File file = new File(uri.toFileString());
			println("Converting: " + file.getAbsolutePath());
			val String javaCode = Files.toString(file, Charset.defaultCharset());
			val JavaConverter j2x = javaConverter.get();
			val xtendResult = j2x.toXtend(file.name, javaCode)
			problems += xtendResult.problems.size
			val String xtendCode = xtendResult.xtendCode
			val javaFileProjRelPath = uri.toFileString().replace(projectRoot.absolutePath, "")
			var fileName = javaFileProjRelPath + ".xtend"
			var content =  xtendCode
			try {
				file(xtendCode, true);
			} catch (AssertionError error) {
				System.err.println('''«uri» - «error.message»''')
				writeToFile(testProject, javaFileProjRelPath, javaCode)
				fileName += ".error"
				errors++
			}
			writeToFile(testProject, fileName, content)
		}
		println('''Problems («problems»)''')
		println('''Errors («errors»)''')
		println("Done...")
		assertEquals(13, errors)
		assertEquals(27, problems)
	}
	
	def writeToFile(File parent, String fileName, String content) {
		val targetFile = new File(parent, fileName)
		println("Writing to: " + targetFile.absolutePath)
		if (!targetFile.exists) {
			Files.createParentDirs(targetFile)
			targetFile.createNewFile
		}
		Files.write(content, targetFile, Charset.defaultCharset)
	}

}
