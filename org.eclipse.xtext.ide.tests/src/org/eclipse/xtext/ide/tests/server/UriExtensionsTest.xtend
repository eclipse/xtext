/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import java.io.File

@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class UriExtensionsTest {

	@Inject
	extension UriExtensions;

	@Test
	def void testConversion() {
		assertEquals("file:///dir/name.ext", "file:///dir/name.ext".toUri.toPath)
	}

	@Test
	def void testFileUriConversion() {
		assertEquals("file:///dir/name.ext", URI.createFileURI("/dir/name.ext").toPath)
	}

	@Test
	def void testFilesWithSpaces() {
		assertEquals("file:///dir/Foo Bar.testlang", "file:///dir/Foo Bar.testlang".toUri.toPath)
	}

	@Test
	def void testFilesWithCyrillicSymbols() {
		assertEquals("file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang",
			"file:///dir/\u0424\u0443 \u0411\u0430\u0440.testlang".toUri.toPath)
	}

	@Test
	def void testFolderIsPrefix() {
		var directory = new File("./test-data/test-project")
		var uri = URI.createFileURI(directory.absolutePath).toPath.toUri
		assertTrue(uri.isPrefix)
	}
}

