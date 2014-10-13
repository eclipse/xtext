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
import org.junit.Before

/**
 * @author dhuebner - Initial contribution and API
 */
public class JavaFileConverterTest extends AbstractXtendTestCase {
	@Inject
	private Provider<JavaConverter> javaConverter;

	String sourceProject
	String targetProject
	int errorsExpected = 0
	int problemsExpected = 0

	@Before
	def void setUp() {
		sourceProject = null
		targetProject = null
		errorsExpected = 0
		problemsExpected = 0
	}

	@Test @Ignore
	def void testConvertFilesInThisProject() throws Exception {
		sourceProject = "org.eclipse.xtend.core.tests"
		targetProject = "test-converter"
		errorsExpected = 14
		problemsExpected = 29
		runConverter
	}

	@Test@Ignore
	def void testConvertFilesInXtextTestsProject() throws Exception {
		sourceProject = "org.eclipse.xtext.tests"
		targetProject = "org.eclipse.xtext.tests.converted"
		errorsExpected = 3021
		problemsExpected = 5035
		runConverter
	}

	def runConverter() {
		val File srcProjectRoot = new File(new File("").getAbsoluteFile().parentFile, sourceProject);

		val testProject = new File(srcProjectRoot.parentFile, targetProject)
		println("Working in " + srcProjectRoot.getPath());
		val PathTraverser pathTraverser = new PathTraverser();
		val Set<URI> allResourceUris = pathTraverser.findAllResourceUris(srcProjectRoot.getAbsolutePath(),
			new Predicate<URI>() {
				override boolean apply(URI input) {
					val fileName = input.toFileString()
					return "java".equals(input.fileExtension()) && !fileName.contains("xtend-gen");
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
			val javaFileProjRelPath = uri.toFileString().replace(srcProjectRoot.absolutePath, "")
			var fileName = javaFileProjRelPath + ".xtend"
			var content = xtendCode
			try {
				file(xtendCode, true);
			} catch (AssertionError error) {
				System.err.println('''«uri» - «error.message»''')

				//				writeToFile(testProject, javaFileProjRelPath, javaCode)
				//				fileName += ".error"
				errors++
			}
			writeToFile(testProject, fileName, content)
		}
		println('''Errors («errors»)''')
		println('''Problems («problems»)''')
		println("Done...")
		assertEquals(errorsExpected, errors)
		assertEquals(problemsExpected, problems)
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
