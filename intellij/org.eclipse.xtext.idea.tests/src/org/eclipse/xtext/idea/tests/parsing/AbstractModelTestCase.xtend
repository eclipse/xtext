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
import javax.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.resource.ModuleBasedResourceSetProvider
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

class AbstractModelTestCase extends LightToolingTest implements ModelChecker {

	@Inject
	@Accessors(PROTECTED_GETTER)
	BaseXtextASTFactory astFactory

	@Inject
	@Accessors(PROTECTED_GETTER)
	ValidationTestHelper validationHelper

	@Inject
	@Accessors(PROTECTED_GETTER)
	ModuleBasedResourceSetProvider resourceSetProvider

	@Inject
	@Accessors(PROTECTED_GETTER)
	Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider

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
		checkModel(code)
		if (validate) {
			validationHelper.assertNoErrors(actualResource)
		}
		actualResource
	}

	override <T extends EObject> checkModel(String code, boolean validate) {
		checkModel(code)
		val model = actualResource.contents.head as T
		if (validate) {
			validationHelper.assertNoErrors(model)
		}
		model
	}

	protected def void checkModel(String code) {
		configureByText(code)

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
			resource.load(new ByteArrayInputStream(xtextFile.text.bytes), null)
		} catch (IOException e) {
			throw new RuntimeException(e)
		}
		return resource
	}
}
