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
import org.junit.Test
import org.junit.Ignore

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
		for (URI uri : allResourceUris) {
			val File file = new File(uri.toFileString());
			println("Converting: " + file.getAbsolutePath());
			val String java = Files.toString(file, Charset.defaultCharset());
			val JavaConverter j2x = javaConverter.get();
			val String xtendCode = j2x.toXtend(file.name, java).xtendCode
			val projectRelative = uri.toFileString().replace(projectRoot.absolutePath, "")
			val targetFile = new File(testProject, projectRelative + ".xtend")
			println("Writing to: " + targetFile.absolutePath)
			if (!targetFile.exists) {
				Files.createParentDirs(targetFile)
				targetFile.createNewFile
			}
			Files.write(xtendCode, targetFile, Charset.defaultCharset)
			try {
				file(xtendCode, true);
			} catch (AssertionError error) {
				System.err.print(error.message)
			}
		}
		println("Done...")
	}

}
