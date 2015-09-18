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
import com.intellij.lang.Language
import com.intellij.lang.LanguageASTFactory
import com.intellij.lang.LanguageParserDefinitions
import com.intellij.lang.ParserDefinition
import com.intellij.mock.MockEditorFactory
import com.intellij.mock.MockFileDocumentManagerImpl
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.impl.DocumentImpl
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.impl.FileDocumentManagerImpl
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
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.lang.LanguageSetup
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription

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
	
	@Inject
	ParserDefinition parserDefinition

	override protected setUp() throws Exception {
		super.setUp()
		addExplicitExtension(LanguageSetup.INSTANCE, myLanguage, setup)
		xtextLanguage.injectMembers(this)
		
		addExplicitExtension(LanguageParserDefinitions.INSTANCE, myLanguage, parserDefinition);
		addExplicitExtension(LanguageASTFactory.INSTANCE, myLanguage, astFactory)

		val appContainer = application.picoContainer
		appContainer.unregisterComponent(EditorFactory)
		appContainer.unregisterComponent(FileDocumentManager)
		
		val editorFactory = new MockEditorFactory() {
			
			override createDocument(CharSequence text) {
				new DocumentImpl(text, true, false)
			}
			
		}
		appContainer.registerComponentInstance(EditorFactory, editorFactory)
		appContainer.registerComponentInstance(FileDocumentManager, new MockFileDocumentManagerImpl([charSequence |
			editorFactory.createDocument(charSequence)
		], FileDocumentManagerImpl.HARD_REF_TO_DOCUMENT_KEY))
		
		xtextResourceAsserts.nodeModelPrinter.ignoreSyntaxErrors = false
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
		this("", fileExt, language)
	}

	new(String dataPath, String fileExt, IXtextLanguage language) {
		super(dataPath, fileExt)
		myLanguage = language as Language
	}
	
	protected def getXtextLanguage() {
		myLanguage as IXtextLanguage
	}
	
	protected abstract def ISetup getSetup()
	
	override checkResource(String code, boolean validate) {
		doCodeTest(code)
		if (validate) {
			validationHelper.assertNoErrors(actualResource)
		}
		actualResource
	}

	override <T extends EObject> checkModel(String code, boolean validate) {
		doCodeTest(code)
		val model = actualResource.contents.head as T
		if (validate) {
			validationHelper.assertNoErrors(model)
		}
		model
	}
	
	override <T extends EObject> checkModel(String path, String code, boolean validate) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
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
		assertResource(expectedResource, actualResource, false)
	}

	def protected createActualResource() {
		val psiToEcoreTransformator = psiToEcoreTransformatorProvider.get => [
			xtextFile = myFile as BaseXtextFile
		]
		val uri = URI.createURI(myFile.virtualFile.url)
		createFreshResourceSet().createResource(uri) as XtextResource => [
			parser = psiToEcoreTransformator
			load(new ByteArrayInputStream(newByteArrayOfSize(0)), null)
			psiToEcoreTransformator.adapter.install(it)
		]
	}
	
	def XtextResourceSet createFreshResourceSet() {
		var resourceSet = xtextResourceSetProvider.get
		new ChunkedResourceDescriptions(emptyMap, resourceSet)
		val project = new ProjectDescription() => [
			name = 'parsing-test-project'
		]
		project.attachToEmfObject(resourceSet)
		return resourceSet
	}

	def protected createExpectedResource() {
		var resourceSet = createFreshResourceSet
		val uri = URI.createURI(myFile.virtualFile.url)
		resourceSet.createResource(uri) as XtextResource => [
			load(new ByteArrayInputStream(myFile.text.bytes), null)
		]
	}

	override protected loadFile(String name) throws IOException {
		FileUtil.loadFile(new File(myFullDataPath, name), CharsetToolkit.UTF8, true)
	}

}
