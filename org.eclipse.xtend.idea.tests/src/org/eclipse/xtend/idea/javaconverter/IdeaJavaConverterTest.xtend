/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.javaconverter

import com.google.inject.Inject
import com.intellij.openapi.fileTypes.LanguageFileType
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtend.core.javaconverter.JavaConverter
import org.eclipse.xtend.core.tests.javaconverter.JavaConverterTest
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.junit.Test
import org.eclipse.xtend.core.idea.javaconverter.ConvertJavaCodeHandler

/**
 * @author dhuebner - Initial contribution and API
 */
@TestDecorator
class IdeaJavaConverterTest extends AbstractModelTestCase {
	@Inject JavaConverter converter

	new(LanguageFileType fileType) {
		super(fileType)
	}

	Delegate delegate

	new() {
		super(XtendFileType.INSTANCE)
		delegate = new Delegate(this)
	}

	override protected setUp() throws Exception {
		super.setUp()
		xtextLanguage.injectMembers(delegate)
		delegate.setUp
	}

	@FinalFieldsConstructor
	private static class Delegate extends JavaConverterTest {

		val ModelChecker modelChecker

		override file(String code, boolean validate) {
			modelChecker.checkModel(getFileName(code), code, validate)
		}

	}

	@Test
	def void testSimpleCase() {
		val javaCalzz = myFixture.addFileToProject('javaconverter/JavaConverterTest.java', '''
			package javaconverter;
			
			public class JavaConverterTest {
			
				public void doStuff() {
				}
			
			}
		''')
		val result = converter.toXtend(javaCalzz.virtualFile.nameWithoutExtension, javaCalzz.text, myModule)
		assertNotNull(result)
		assertTrue(result.problems.empty)
	}

	@Test
	def void testCollectJavaFilesInHandler() {
		val javaCalzz = myFixture.addFileToProject('javaconverter/foo/JavaConverterTest.java', '''
			package javaconverter.foo;
			public class JavaConverterTest {}
		''')
		myFixture.addFileToProject('javaconverter/bar/JavaConverterTest.java', '''
			package javaconverter.bar;
			public class JavaConverterTest {}
		''')
		val otherClazz = myFixture.addFileToProject('JavaConverterTest.java', '''
			public class JavaConverterTest {}
		''')
		val result = ConvertJavaCodeHandler.collectJavaFiles(#[javaCalzz.parent.parent, otherClazz])
		assertTrue(result.iterator.hasNext)
		assertEquals(3, result.iterator.size)
	}
}
