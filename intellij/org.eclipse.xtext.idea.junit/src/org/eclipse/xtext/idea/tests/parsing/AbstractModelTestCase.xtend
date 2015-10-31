/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import java.io.ByteArrayInputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*
import org.eclipse.xtext.util.LazyStringInputStream

class AbstractModelTestCase extends LightToolingTest implements ModelChecker {

	@Inject
	@Accessors(PROTECTED_GETTER)
	BaseXtextASTFactory astFactory

	@Inject
	@Accessors(PROTECTED_GETTER)
	ValidationTestHelper validationHelper

	@Inject
	@Accessors(PROTECTED_GETTER)
	IdeaResourceSetProvider resourceSetProvider

	@Inject
	@Accessors(PROTECTED_GETTER)
	extension XtextResourceAsserts xtextResourceAsserts

	new(LanguageFileType fileType) {
		super(fileType)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXbaseLibrary
	}

	override checkResource(String code, boolean validate) {
		createFile(null, code)
		if (validate) {
			validationHelper.assertNoErrors(actualResource)
		}
		actualResource
	}

	override <T extends EObject> checkModel(String code, boolean validate) {
		checkModel(null, code, validate)
	}

	override <T extends EObject> checkModel(String path, String code, boolean validate) {
		createFile(path, code)
		val model = actualResource.contents.head as T
		if (validate) {
			validationHelper.assertNoErrors(model)
		}
		model
	}

	protected def void createFile(String path, String code) {
		if (path === null) {
			configureByText(code)
		} else {
			configureByText(path, code)
		}
		val actualResource = actualResource
		val expectedResource = createExpectedResource
		assertResource(expectedResource, actualResource)
	}

	def protected XtextResource getActualResource() {
		xtextFile.resource as XtextResource
	}

	def protected XtextResource createExpectedResource() {
		var resourceSet = resourceSetProvider.get(myModule)
		var resource = resourceSet.createResource(URI.createURI(xtextFile.virtualFile.url)) as XtextResource
		try {
			resource.load(new LazyStringInputStream(xtextFile.text), null)
		} catch (IOException e) {
			throw new RuntimeException(e)
		}
		return resource
	}

}
