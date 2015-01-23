/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.stubs

import com.google.inject.Inject
import com.intellij.psi.PsiFile
import com.intellij.psi.stubs.DefaultStubBuilder
import com.intellij.psi.stubs.StubElement
import org.eclipse.xtext.idea.lang.IElementTypeProvider
import org.eclipse.xtext.psi.impl.BaseXtextFile

class XtextStubBuilder extends DefaultStubBuilder {

	@Inject
	IElementTypeProvider elementTypeProvider

	override protected StubElement<?> createStubForFile(PsiFile file) {
		switch file {
			BaseXtextFile: file.createStubForFile
			default: super.createStubForFile(file)
		}
	}

	protected def createStubForFile(BaseXtextFile xtextFile) {
		val stub = new XtextFileStub(xtextFile, elementTypeProvider.fileType as XtextFileElementType<?>)
		stub.uri = xtextFile.physicalURI
		stub.exportedObjects = newArrayList
		val resourceDescription = xtextFile.resourceDescription
		if (resourceDescription != null) {
			stub.exportedObjects += resourceDescription.exportedObjects.map [
				new ExportedObject(qualifiedName, EClass, EObjectURI)
			]
		}
		stub
	}

}
