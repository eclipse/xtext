/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.javaconverter

import com.google.common.base.Predicate
import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.nio.charset.Charset
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.javaconverter.JavaConverter
import org.eclipse.xtend.core.javaconverter.JavaConverter.ConversionResult
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.mwe.PathTraverser
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

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
		problemsExpected = 22
		runConverter
	}

	@Test @Ignore
	def void testConvertFilesInXtextTestsProject() throws Exception {
		sourceProject = "org.eclipse.xtext.tests"
		targetProject = "org.eclipse.xtext.tests.converted"
		errorsExpected = 87
		problemsExpected = 13404
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
			val javaFileProjRelPath = uri.toFileString().replace(srcProjectRoot.absolutePath, "")
			println("Converting: " + javaFileProjRelPath);
			var compileError = false
			val String javaCode = Files.toString(file, Charset.defaultCharset());

			val xtendResult = converToXtend(file.name, javaCode)
			val knownProblemsFound = xtendResult.problems.size
			var xtendCode = xtendResult.xtendCode

			var fileName = javaFileProjRelPath + ".xtend"
			try {
				file(xtendCode, true);
			} catch (AssertionError error) {
				compileError = true
				System.err.println('''«javaFileProjRelPath» - «error.message»''')
			}
			if (knownProblemsFound != 0 || compileError) {
				filesWithErrorsOrProblems++
				if (knownProblemsFound != 0) {
					writeToFile(testProject, javaFileProjRelPath, javaCode)
					fileName += ".error"
				} else {
					errors++
				}
			}
			problems += knownProblemsFound
			files++
			writeToFile(testProject, fileName, xtendCode)
		}
		println('''Not covered Errors («errors»)''')
		println('''Known Problems («problems»)''')
		println('''Files read («files»)''')
		println('''Files with errors/problems («filesWithErrorsOrProblems»)''')
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
		println('''Writing to: «fileName»''')
		if (!targetFile.exists) {
			Files.createParentDirs(targetFile)
			targetFile.createNewFile
		}
		Files.write(content, targetFile, Charset.defaultCharset)
	}

}
