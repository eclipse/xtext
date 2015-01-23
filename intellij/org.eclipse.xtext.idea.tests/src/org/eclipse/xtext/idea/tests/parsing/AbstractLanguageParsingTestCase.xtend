/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.LanguageASTFactory
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.CharsetToolkit
import com.intellij.testFramework.ParsingTestCase
import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet

abstract class AbstractLanguageParsingTestCase extends ParsingTestCase implements ModelChecker {

	@Inject
	@Accessors(PROTECTED_GETTER)
	Provider<XtextResourceSet> xtextResourceSetProvider

	@Inject
	@Accessors(PROTECTED_GETTER)
	Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider

	@Accessors(PROTECTED_GETTER)
	XtextResource actualResource

	@Accessors(PROTECTED_GETTER)
	XtextResource expectedResource

	@Inject
	@Accessors(PROTECTED_GETTER)
	BaseXtextASTFactory astFactory

	@Inject
	@Accessors(PROTECTED_GETTER)
	ValidationTestHelper validationHelper

	@Inject
	@Accessors(PROTECTED_GETTER)
	extension XtextResourceAsserts xtextResourceAsserts

	override protected setUp() throws Exception {
		super.setUp()
		addExplicitExtension(LanguageASTFactory.INSTANCE, myLanguage, astFactory)
	}

	override protected tearDown() throws Exception {
		super.tearDown()
		actualResource = null
		expectedResource = null
	}

	new(LanguageFileType fileType) {
		this("", fileType)
	}

	new(String dataPath, LanguageFileType fileType) {
		this(dataPath, fileType.defaultExtension, fileType.language as IXtextLanguage)
	}

	new(String fileExt, IXtextLanguage language) {
		this("", fileExt, language.getInstance(ParserDefinition))
	}

	new(String dataPath, String fileExt, IXtextLanguage language) {
		super(dataPath, fileExt, language.getInstance(ParserDefinition))
		language.injectMembers(this)
	}

	new(String dataPath, String fileExt, ParserDefinition... definitions) {
		super(dataPath, fileExt, definitions)
	}

	new(String dataPath, String fileExt, boolean lowercaseFirstLetter, ParserDefinition... definitions) {
		super(dataPath, fileExt, lowercaseFirstLetter, definitions)
	}

	override <T extends EObject> checkModel(String code, boolean validate) {
		doCodeTest(code)
		val model = actualResource.contents.head as T
		if (validate) {
			validationHelper.assertNoErrors(model)
		}
		model
	}

	override protected includeRanges() {
		true
	}

	override protected doTest(boolean checkResult) {
		super.doTest(checkResult)
		if (checkResult) {
			assertResource
		}
	}

	override protected doCodeTest(String code) throws IOException {
		super.doCodeTest(code)
		assertResource
	}

	protected def void assertResource() {
		actualResource = createActualResource
		expectedResource = createExpectedResource
		assertResource(expectedResource, actualResource)
	}

	def protected createActualResource() {
		val psiToEcoreTransformator = psiToEcoreTransformatorProvider.get => [
			xtextFile = myFile as BaseXtextFile
		]
		val uri = URI.createURI(myFile.virtualFile.url)
		xtextResourceSetProvider.get.createResource(uri) as XtextResource => [
			parser = psiToEcoreTransformator
			load(new ByteArrayInputStream(newByteArrayOfSize(0)), null)
			psiToEcoreTransformator.adapter.install(it)
		]
	}

	def protected createExpectedResource() {
		var resourceSet = xtextResourceSetProvider.get
		val uri = URI.createURI(myFile.virtualFile.url)
		resourceSet.createResource(uri) as XtextResource => [
			load(new ByteArrayInputStream(myFile.text.bytes), null)
		]
	}
	
	override protected loadFile(String name) throws IOException {
		FileUtil.loadFile(new File(myFullDataPath, name), CharsetToolkit.UTF8, true)
	}

}
