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
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult

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
		errorsExpected = 0
		problemsExpected = 33
		runConverter
	}

	@Test @Ignore
	def void testConvertFilesInXtextTestsProject() throws Exception {
		sourceProject = "org.eclipse.xtext.tests"
		targetProject = "org.eclipse.xtext.tests.converted"
		errorsExpected = 198
		problemsExpected = 12173
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
					return "java".equals(input.fileExtension()) && !fileName.contains("xtend-gen") &&
						!fileName.contains("batch-compiler-data");
				}
			});
		var errors = 0
		var problems = 0
		var files = 0
		var filesWithErrorsOrProblems = 0
		for (URI uri : allResourceUris) {
			val File file = new File(uri.toFileString());
			println("Converting: " + file.getAbsolutePath());
			val String javaCode = Files.toString(file, Charset.defaultCharset());

			val xtendResult = converToXtend(file.name, javaCode)

			val problemsFound = xtendResult.problems.size
			var xtendCode = xtendResult.xtendCode

			val javaFileProjRelPath = uri.toFileString().replace(srcProjectRoot.absolutePath, "")
			var fileName = javaFileProjRelPath + ".xtend"
			try {
				file(xtendCode, true);
			} catch (AssertionError error) {
				if (problemsFound != 0) {
					writeToFile(testProject, javaFileProjRelPath, javaCode)
					fileName += ".error"
				} else {
					System.err.println('''«uri» - «error.message»''')
					errors++
				}
				filesWithErrorsOrProblems++
			}
			problems += problemsFound
			files++
			writeToFile(testProject, fileName, xtendCode)
		}
		println('''Files read («files»)''')
		println('''Files with errors/problems («filesWithErrorsOrProblems»)''')
		println('''Errors («errors»)''')
		println('''Problems («problems»)''')
		println("Done...")
		assertEquals(problemsExpected, problems)
		assertEquals(errorsExpected, errors)
	}

	def ConversionResult converToXtend(String unitName, String javaCode) {
		val JavaConverter j2x = javaConverter.get();
		var result = j2x.toXtend(unitName, javaCode)
		if (result.problems.size == 0) {
			try {
				file(result.xtendCode, true);
			} catch (AssertionError error) {
				result = j2x.useRobustSyntax.toXtend(unitName, javaCode)
			}
		}
		return result
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
